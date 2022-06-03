package com.example.app01.ThunderNew;

import android.util.Log;

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
    private long time= 2000;
    private List<EnemyNew> enemyNewListnew = new ArrayList<>();

    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            ex1=random.nextInt(1500);
            ey1=random.nextInt(500);


            EnemyNew enemyNew1 = new EnemyNew(ex1,0);

            enemyNewListnew.add(enemyNew1);

//            Log.i("敌机坐标 ","敌机坐标 x= "+ex1+"y="+ey1+"list="+ enemyNewListnew);


        }

    }

    public List<EnemyNew> getEnemyList() {
        return enemyNewListnew;
    }
}
