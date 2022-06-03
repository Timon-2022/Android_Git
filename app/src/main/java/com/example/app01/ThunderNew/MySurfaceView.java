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

        return true;
    }

    //surface绑定callback
    public void init(Context context){
        surfaceHolder=this.getHolder();
        surfaceHolder.addCallback(this);

        paint=new Paint();


        EnemyThread enemyThreadnew = new EnemyThread();
        new Thread(enemyThreadnew).start();

        BulletThread bulletThread = new BulletThread(mx,my);
        new Thread(bulletThread).start();

        GameThread gameThread =new GameThread(context,enemyThreadnew.getEnemyList(),
                                                bulletThread.getBulletList(),this,mx,my);
        new Thread(gameThread).start();


    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        Log.i("MySurfaceView", "surfaceCreated...");

    }



    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
}
