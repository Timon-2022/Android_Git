package com.example.app01.thunder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.widget.ImageView;

import com.example.app01.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyThread implements Runnable{
//    private Canvas canvas;
//    private Paint paint;
//    private Bitmap bitmap;
//    private ImageView imageView;  //显示内容
    private float ex1,ey1;
    Random random = new Random();
    private long time= 500;
    private ThunderActivity thunderActivity;
    private List<Enemy> enemyList = new ArrayList<>();




//    public EnemyThread(Canvas canvas, Paint paint, Bitmap bitmap, ImageView imageView,ThunderActivity thunderActivity) {
//        this.canvas = canvas;
//        this.paint = paint;
//        this.bitmap = bitmap;
//        this.imageView = imageView;
//        this.thunderActivity = thunderActivity;
//    }

    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            ex1=random.nextInt(2000);
            ey1=random.nextInt(500);


            Enemy enemy = new Enemy(ex1,ey1);

            enemyList.add(enemy);
            Log.i("敌机坐标 ","低级坐标 x= "+ex1+"y="+ey1+"list="+enemyList);


        }

    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }
}
