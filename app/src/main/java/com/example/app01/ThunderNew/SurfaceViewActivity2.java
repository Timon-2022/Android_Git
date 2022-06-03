package com.example.app01.ThunderNew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.app01.R;

public class SurfaceViewActivity2 extends AppCompatActivity {
    private SurfaceViewActivity2 surfaceViewActivity2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view2);
//        MySurfaceView mySurfaceView = new MySurfaceView(SurfaceViewActivity2.this);
        MySurfaceView mySurfaceView = this.findViewById(R.id.surfaceView);
        TouchListener touchListener = new TouchListener();
        mySurfaceView.setOnTouchListener(touchListener);

    }
}