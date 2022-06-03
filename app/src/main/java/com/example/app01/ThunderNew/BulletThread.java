package com.example.app01.ThunderNew;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BulletThread implements Runnable{

    private float mx,my;

    private long time= 100;
    private List<Bullet> bulletList = new ArrayList<>();

    public BulletThread(float mx, float my) {
        this.mx = mx;
        this.my = my;
    }

    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            Bullet bullet= new Bullet(mx,my);


            bulletList.add(bullet);



        }

    }



    public List<Bullet> getBulletList() {
        return bulletList;
    }
}
