package com.example.app01.thunder;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public class BitmapHandle extends Handler {
    private ImageView imageView;
    public BitmapHandle(ImageView imageView){
        this.imageView = imageView;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);

        //通知Activity 更新ImageView 显示内容
        Bitmap bitmap = (Bitmap)msg.obj;
        imageView.setImageBitmap(bitmap);
    }


}
