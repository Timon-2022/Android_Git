package com.example.app01.ThunderNew;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.util.List;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private Canvas canvas;
    private Paint paint;
    private Bitmap bitmap;
    private Context context;
    private SurfaceHolder surfaceHolder;

    private float mx=500;
    private float my=1600;
    float x1,y1;
    float dx,dy;
    private float mx1=500;
    private float my1=1600;
    private Hero hero;

    //手动调用
    public MySurfaceView(Context context) {
        super(context);

        this.context=context;
        init(context);
        Log.i("指针", "contextXX=: "+this.context);
    }

    //在配置xml引用自定义的SurfaceView
    public MySurfaceView(Context context, AttributeSet attrs) {

        super(context, attrs);
        Log.i("MySurfaceView", "在xml中显示surfaceView...");
        init(context);

    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.i("监听器", "onTouchEvent: "+event.getAction());
        int key =  event.getAction();
        switch (key) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();

                if(hero==null){ hero = new Hero(x1,y1,mx1,my1); }
                dx = x1 - mx1;
                dy = y1 - my1;

                Log.i("TAG", "onTouchEvent: dx="+dx+" dy="+dy);
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                mx1=event.getX()-dx;
                my1=event.getY()-dy;
                hero.setMx1(mx1);
                hero.setMy1(my1);
                Log.i("TAG", "onTouchEvent: mx1="+mx1+" my1="+my1);
                break;}
        return true;
    }

    //surface绑定callback
    public void init(Context context){
        surfaceHolder=this.getHolder();
        surfaceHolder.addCallback(this);
        paint=new Paint();

        EnemyThread enemyThreadnew = new EnemyThread();
        new Thread(enemyThreadnew).start();

        BulletThread bulletThread = new BulletThread(mx1,my1);
        new Thread(bulletThread).start();

        GameThread gameThread =new GameThread(hero,context,enemyThreadnew.getEnemyList(), bulletThread.getBulletList(),this,mx1,my1);
        new Thread(gameThread).start();
    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) { Log.i("MySurfaceView", "surfaceCreated..."); }
    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) { }
    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) { }
}
