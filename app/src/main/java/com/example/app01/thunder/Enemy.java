package com.example.app01.thunder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.app01.R;

public class Enemy extends AirPlane{

    private float ex1,ey1;

    public Enemy(float ex1, float ey1) {
        this.ex1 = ex1;
        this.ey1 = ey1;
    }

    public void move(){
        ey1+=vy;
    }

    public float getEx1() {
        return ex1;
    }

    public float getEy1() {
        return ey1;
    }

    public void setEy1(float ey1) {
        this.ey1 = ey1;
    }
}
