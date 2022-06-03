package com.example.app01.ThunderNew;

public class Bullet extends AirPlane {


    float mx,my;

    public Bullet(float mx, float my) {
        this.mx = mx;
        this.my = my;
    }

    public void shot(){
        y-=vy;
    }

    public float getMx() {
        return mx;
    }

    public float getMy() {
        return my;
    }
}
