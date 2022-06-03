package com.example.app01.ThunderNew;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.app01.thunder.EnemyThread;
import com.example.app01.thunder.ImageViewThread;

public class TouchListener implements View.OnTouchListener{

    float x1,y1;
    float dx,dy;
    private float mx1=500;
    private float my1=1600;
    private Hero hero;

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int key =  event.getAction();
        switch (key) {
            case MotionEvent.ACTION_DOWN:

                x1 = event.getX();
                y1 = event.getY();
//                if(imageRunnable == null){
//                    EnemyThread enemyThread = new EnemyThread();
//                    new Thread(enemyThread).start();;
//                    imageRunnable = new ImageViewThread(thunderActivity,handler, imageView, x1, y1,mx,my,enemyThread.getEnemyList());
//                    new Thread(imageRunnable).start();
//
//
//                }
                if(hero==null){ hero = new Hero(x1,y1,mx1,my1); }
                dx = x1 - mx1;
                dy = y1 - my1;

                break;

            case MotionEvent.ACTION_UP:
                break;


            case MotionEvent.ACTION_MOVE:


                mx1=event.getX()-dx;
                my1=event.getY()-dy;
                hero.setMx1(mx1);
                hero.setMy1(my1);
                break;
        }
        return true;
    }
}
