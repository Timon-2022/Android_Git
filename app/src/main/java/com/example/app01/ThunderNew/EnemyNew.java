package com.example.app01.ThunderNew;

public class EnemyNew extends AirPlane {

    private float ex1,ey1;

    public EnemyNew(float ex1, float ey1) {
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
