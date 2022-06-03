package com.example.app01.ThunderNew;

public class Hero extends AirPlane {
    float x1,y1,mx1,my1;


    public Hero(float x1, float y1, float mx1, float my1) {
        this.x1 = x1;
        this.y1 = y1;
        this.mx1 = mx1;
        this.my1 = my1;
    }

    public void setMx1(float mx1) {
        this.mx1 = mx1;
    }

    public void setMy1(float my1) {
        this.my1 = my1;
    }

    public float getMx1() {
        return mx1;
    }

    public float getMy1() {
        return my1;
    }
}
