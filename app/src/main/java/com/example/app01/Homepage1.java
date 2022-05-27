package com.example.app01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.app01.drawpic.DrawActivity;
import com.example.app01.lottery.LotteryDemo;
import com.example.app01.thunder.ThunderActivity;

public class Homepage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage1);
        //How to get user name from another activity
//        String userName = (EditText) MainActivity.findViewById(R.id.editTextTextPersonName);



        //get the userName from login UI and show it
        Intent intent = getIntent();
        //把传送进来的String类型的Message的值赋给新的变量message
        String message = intent.getStringExtra("name");
        //把布局文件中的文本框和textview链接起来
        TextView textView = (TextView) findViewById(R.id.RecMes);
        //在textview中显示出来message
        textView.setText(message);



        //create a button with drawing function
        //1.initialize the button object
        Button btndraw = (Button) this.findViewById(R.id.buttondraw);
        btndraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(Homepage1.this, DrawActivity.class);
                Homepage1.this.startActivity(intent5);
            }
        });

        Button btnlottery = (Button) this.findViewById(R.id.buttonlottery);
        btnlottery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(Homepage1.this, LotteryDemo.class);
                Homepage1.this.startActivity(intent6);
            }
        });

        Button btnThunder = (Button) this.findViewById(R.id.buttonThunder);
        btnThunder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent(Homepage1.this, ThunderActivity.class);
                Homepage1.this.startActivity(intent7);
            }
        });

    }
}