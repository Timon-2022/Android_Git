package com.example.app01.ThunderNew;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.app01.R;
import com.example.app01.thunder.Enemy;

import java.util.List;

public class GameThread implements Runnable{
    private Canvas canvas;
    private Paint paint;
    private List<EnemyNew> enemyListnew;
    private MySurfaceView mySurfaceView;
    private Context context;
    private SurfaceHolder surfaceHolder;
    private List<Bullet> bulletList;
    private Hero hero;

    private float mx1,my1;

        public GameThread(Hero hero,Context context, List<EnemyNew> enemyListnew,List<Bullet> bulletList,MySurfaceView mySurfaceView,  float mx1, float my1) {
            this.hero= hero;
            this.context = context;
            this.enemyListnew = enemyListnew;
            this.bulletList=bulletList;

            this.mx1 = mx1;
            this.my1 = my1;
            this.mySurfaceView=mySurfaceView;
            surfaceHolder=mySurfaceView.getHolder();
    }

    @Override
    public void run() {
         Activity activity =(Activity) context;
        Bitmap bitmapbg = BitmapFactory.decodeResource(activity.getResources(), R.drawable.bg2);
        Bitmap bmphero = BitmapFactory.decodeResource(activity.getResources(), R.drawable.hero1);
        Bitmap bmpenemy = BitmapFactory.decodeResource(activity.getResources(), R.drawable.enemy);
        Bitmap bmpBullet = BitmapFactory.decodeResource(activity.getResources(), R.drawable.bullet);

        paint = new Paint();
        while(true){

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try{
                canvas = surfaceHolder.lockCanvas();
                canvas.drawBitmap(bitmapbg, 0, 0, paint);
                //实现飞机移动的本质是改变飞机绘制的位置
                canvas.drawBitmap(bmphero,mx1,my1,paint);


                for (int i = 0; i <enemyListnew.size(); i++) {
                    EnemyNew enemy = enemyListnew.get(i);
                    canvas.drawBitmap(bmpenemy,enemy.getEx1(),enemy.getEy1(),paint);
                    enemy.move();


                }
                for (int j = 0; j < bulletList.size() ; j++) {
                    Bullet bullet = bulletList.get(j);
                    canvas.drawBitmap(bmpBullet,bullet.getMx()+50,bullet.getMy()-50,paint);
                    bullet.shot();
                }
            }finally {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }

    }
}
