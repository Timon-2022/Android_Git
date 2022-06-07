package com.example.app01.ThunderNew;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BulletThread implements Runnable{

    private float mx1,my1;
    private long time= 100;
    private List<Bullet> bulletList = new ArrayList<>();

    public BulletThread(float mx1, float my1) {
        this.mx1 = mx1;
        this.my1 = my1;
    }
    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Bullet bullet= new Bullet(mx1,my1);
            bulletList.add(bullet);
        }

    }
    public List<Bullet> getBulletList() {
        return bulletList;
    }
}
