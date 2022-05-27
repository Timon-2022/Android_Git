package com.example.app01.drawpic;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.app01.thunder.BitmapHandle;

public class TouchListener implements View.OnTouchListener {
    //There are 3 objects in android drawing
    //bitmap _ = buffimage
    //canvas = graphics
    //paint

    //1.initialize basic 3 attributes
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;
    //initialize image and the location
    private ImageView imageView;
    private float x1,x2,y1,y2;
    private BitmapHandle handler;



//rewrite ontouch method in order to implements drawing function
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(bitmap==null){
            //create the bitmap when there is no bitmap using the height and width of the imageview
            bitmap=Bitmap.createBitmap(v.getWidth(),v.getHeight(),Bitmap.Config.ARGB_8888);
            //=new graphic of a buffimage
            canvas=new Canvas(bitmap);
            paint =new Paint();
//            paint.setColor(Color.red(122));

            //?need a note
            imageView=(ImageView)v;
        }

        int key =event.getAction();
        switch (key){
            case MotionEvent.ACTION_DOWN:
                x1=event.getX();
                y1=event.getY();
                break;

            case MotionEvent.ACTION_UP:
                x2=event.getX();
                y2=event.getY();

                //how to change the color
                paint.setColor(Color.GREEN);
                canvas.drawRect(x1,y1,x2,y2,paint);


//

                imageView.setImageBitmap(bitmap);
                //canvas.drawcolor change the whole image
//                canvas.drawColor(Color.BLUE);

                break;

            case MotionEvent.ACTION_MOVE:
                    break;

        }



        //remember to return true
        return true;
    }
}
