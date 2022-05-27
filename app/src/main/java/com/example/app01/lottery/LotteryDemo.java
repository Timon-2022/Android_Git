package com.example.app01.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.app01.R;

public class LotteryDemo extends AppCompatActivity {

    //创建一个Handler
//    private Handler handler = new Handler() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottery_demo);

        Button btnstart = (Button) this.findViewById(R.id.buttonlotterystart);
        Button btnstop = (Button) this.findViewById(R.id.buttonlotterystop);
//定义UPDATE_TEXT这个整型敞亮，用于表示更新TextView这个动作
        TextView textView = (TextView) LotteryDemo.this.findViewById(R.id.Textlottery);



        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                LotteryHandle handler = new LotteryHandle(textView);

                LotteryThread thread = new LotteryThread(textView,handler);
                new Thread(thread).start();


            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }
}