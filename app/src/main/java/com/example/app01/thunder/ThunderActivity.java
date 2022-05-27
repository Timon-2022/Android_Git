package com.example.app01.thunder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import com.example.app01.R;

public class ThunderActivity extends AppCompatActivity {
    private ThunderActivity thunderActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_thunder);
        ImageView imageView=(ImageView) this.findViewById(R.id.imageViewthunderbg);




        ImageViewThread.TDTouchListener touch = new ImageViewThread.TDTouchListener(this);
        imageView.setOnTouchListener(touch);
    }
}