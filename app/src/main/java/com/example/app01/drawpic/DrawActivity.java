package com.example.app01.drawpic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.example.app01.R;

public class DrawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_draw);

        ImageView imageView=(ImageView) this.findViewById(R.id.imageViewhuaban);

        Button btnundo = (Button) this.findViewById(R.id.buttonundo);
        Button btnclear = (Button) this.findViewById(R.id.buttonclear);
        Button btnsave = (Button) this.findViewById(R.id.buttonsave);


        TouchListener touch = new TouchListener();
        imageView.setOnTouchListener(touch);

    }
}