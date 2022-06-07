package com.example.app01.ThunderNew;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyThread implements Runnable{
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
        }

    }

    public List<EnemyNew> getEnemyList() {
        return enemyNewListnew;
    }
}
