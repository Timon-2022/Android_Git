package com.example.app01.lottery;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class LotteryHandle extends Handler {
    private TextView textView;
    public LotteryHandle(TextView textView){
        this.textView = textView;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);

        //通知Activity 更新ImageView 显示内容

        String text = (String)msg.obj;
        textView.setText(text);

    }

}
