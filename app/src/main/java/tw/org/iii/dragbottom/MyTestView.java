package tw.org.iii.dragbottom;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.zip.Inflater;

/**
 * Created by User on 2018/4/11.
 */

public class MyTestView extends LinearLayout{
    private int actionBarHeight, vHeight;
    private ScrollView sv;
    private boolean isDrag;
    float postion;
    private float handInt;
    public MyTestView(Context context){
        super(context);

    }
    public MyTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater mInflater = LayoutInflater.from(context);
        View myView = mInflater.inflate(R.layout.test, null);
        sv =myView.findViewById(R.id.sv);
        addView(myView);
        //取得螢幕寬高
        DisplayMetrics dm = new DisplayMetrics();
        Activity a1 =(Activity)context;
        a1.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int vWidth = dm.widthPixels;
        vHeight= dm.heightPixels;
//        this.setOnTouchListener(new MyOnTouchListener());
        isDrag =true;


    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        Log.v("chad","onLayout");
        super.onLayout(changed, l, t, r, b);
        actionBarHeight =320;
        this.setY(1000);

    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        postion =event.getRawY()-actionBarHeight;
////        Log.v("chad",postion+" = onTouchEvent");
////        Log.v("chad",event.getAction()+"");
////        if (postion < 1848 && postion > 1000) {
////
////            this.setY(postion);
//        float temp = handInt-event.getRawY();
//        if(temp>0){
//            this.setY(1000);
//            handInt=event.getRawY();
//            return true;
//
//        }else if (temp<0){
//            this.setY(1800);
//            handInt=event.getRawY();
//            return false;
//        }
//        return false;
////
////        }else{
////            if(postion<1000) {
////                isDrag = false;
////            }
////            return false;
////        }
//    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {


        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            Log.v("chad","ACTION_DOWN");
            handInt =ev.getRawY();
        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            Log.v("chad",sv.getScrollY()+"");

                float temp = handInt - ev.getRawY();
//            Log.v("chad",temp+"");
                if (temp > 0) {
                    handInt = ev.getRawY();
                    Log.v("chad", "ACTION_MOVE_up");
                    if(this.getY()==1000) {
                        return false;
                    }else{
                        this.setY(1000);
                    }

                } else if (temp < 0) {
                    Log.v("chad", "ACTION_MOVE_down");

                    handInt = ev.getRawY();
                    if(this.getY()==1000&&sv.getScrollY()==0) {
                        this.setY(1800);

                    }else{
                        return false;
                    }
                }


            return true;
        }


        return false;









         /*super.onInterceptTouchEvent(ev)*/
    }

//    private class MyOnTouchListener implements OnTouchListener{
//
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            Log.v("chad","onTouch");
//
//            return true;
//        }
//    }
}
