package com.example.app01.lottery;

import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import com.example.app01.lottery.LotteryHandle;

import java.util.Random;

public class LotteryThread implements Runnable{

    int flag=0;
    int num1,num2;
    private TextView textView;
    private LotteryHandle handler;
    int num =100;

    public LotteryThread(TextView textView, LotteryHandle handler) {
        this.textView = textView;
        this.handler = handler;
    }


    @Override
    public void run() {


        Random random =new Random();
        while(flag==0){

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(num>=400){
                continue;
            }
            num1= random.nextInt(10);
            num2= random.nextInt(10);
            num+=100;
            String text = "当前中奖号码为"+num1+"、"+num2; //为消息设置值
            Log.i("Lotterycheckout",text+"    num=  "+num);

            Message message = new Message();
            message.obj=text;

            handler.sendMessage(message);



        }


    }
}
