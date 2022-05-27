package com.example.app01.thunder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.app01.R;

import java.util.List;

public class ImageViewThread  implements Runnable{
    private Canvas canvas;
    private Paint paint;
    private Bitmap bitmap;
    private ImageView imageView;  //显示内容
    private float x1,y1,x2,y2;
    private BitmapHandle handler;
    private float x3,y3;//相对位置差值
    private float mx,my;
    private ThunderActivity thunderActivity;
    private List<Enemy> enemyList;


//    Picture picture = new Picture(hero1.png);

    public ImageViewThread(ThunderActivity thunderActivity,BitmapHandle handler,ImageView imageView,float x1,float y1,float mx, float my,List<Enemy> enemyList) {
        this.handler = handler;
        this.imageView = imageView;
        this.x1 = x1;
        this.y1 = y1;

        this.mx=mx;
        this.my=my;
        this.thunderActivity=thunderActivity;
        this.enemyList=enemyList;;

    }

    @Override
    public void run() {
        //加载两个素材，背景和飞机
        Bitmap bitmapbg = BitmapFactory.decodeResource(thunderActivity.getResources(), R.drawable.bg2);
        Bitmap bmphero = BitmapFactory.decodeResource(thunderActivity.getResources(), R.drawable.hero1);
        Bitmap bmpenemy = BitmapFactory.decodeResource(thunderActivity.getResources(), R.drawable.enemy);

        //初始化画图对象
        if(bitmap == null){
            bitmap = Bitmap.createBitmap(imageView.getWidth(),imageView.getHeight(),Bitmap.Config.ARGB_8888);
            canvas = new Canvas(bitmap);
            paint = new Paint();
        }
        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //实现背景绘制
            canvas.drawBitmap(bitmapbg,0,0,paint);



            //实现飞机移动的本质是改变飞机绘制的位置
            canvas.drawBitmap(bmphero,mx,my,paint);


            for (int i = 0; i <enemyList.size() ; i++) {
                Enemy enemy = enemyList.get(i);
                canvas.drawBitmap(bmpenemy,enemy.getEx1(),enemy.getEy1(),paint);
                enemy.move();


            }



//            mx+=(x2-x1);
//            my+=y2-y1;
            //创建Msg对象,绑定要更新的数据
            Message message = new Message();
            message.obj = bitmap;

            //发送给Handle
            handler.sendMessage(message);
        }


    }

    public void setMx(float mx) {
        this.mx = mx;
    }

    public void setMy(float my) {
        this.my = my;
    }


    public static class TDTouchListener implements View.OnTouchListener{
        private Bitmap bitmap;   //图层对象
        private Canvas canvas;  //画笔对象
        private Paint paint;    //设置画笔属性
        private ImageView imageView;
        private float x1,y1;//鼠标点击的坐标位置
        private float x2,y2;//飞机绘制的位置
        private float mx1,my1;//飞机的初始位置
        private float mx=500;
        private float my=1600;
        float dx,dy;

        private BitmapHandle handler;
        private ImageViewThread imageRunnable;
        private ThunderActivity thunderActivity;

        public TDTouchListener(ThunderActivity thunderActivity) {
            this.thunderActivity = thunderActivity;
        }


        @Override
        public boolean onTouch(View v, MotionEvent event) {

            //初始化画图对象
            if(bitmap == null){
                bitmap = Bitmap.createBitmap(v.getWidth(),v.getHeight(),Bitmap.Config.ARGB_8888);
                canvas = new Canvas(bitmap);
                paint = new Paint();

                imageView = (ImageView)v;

                handler = new BitmapHandle(imageView);
            }

            int key =  event.getAction();
            switch (key) {
                case MotionEvent.ACTION_DOWN:

                    x1 = event.getX();
                    y1 = event.getY();

                    if(imageRunnable == null){
                        EnemyThread enemyThread = new EnemyThread();
                        new Thread(enemyThread).start();;
                        imageRunnable = new ImageViewThread(thunderActivity,handler, imageView, x1, y1,mx,my,enemyThread.getEnemyList());
                        new Thread(imageRunnable).start();


                    }
                    dx = x1-mx;
                    dy = y1-my;

//                    Log.i("飞机坐标 ","mx="+(mx)+"         my= "+(my));
                    break;

                case MotionEvent.ACTION_UP:
                    break;


                case MotionEvent.ACTION_MOVE:
                    mx=event.getX()-dx;
                    my=event.getY()-dy;
                    imageRunnable.setMx(mx);
                    imageRunnable.setMy(my);

                    Log.i("飞机坐标 ","x2-dx="+(x2-dx)+"         y2-dy= "+(y2-dy));






                    break;
            }
            return true;
        }
    }
}
