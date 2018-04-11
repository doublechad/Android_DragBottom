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

import java.util.zip.Inflater;

/**
 * Created by User on 2018/4/11.
 */

public class MyTestView extends LinearLayout{
    private int actionBarHeight, vHeight;
    public MyTestView(Context context){
        super(context);

    }
    public MyTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater mInflater = LayoutInflater.from(context);
        View myView = mInflater.inflate(R.layout.test, null);
        addView(myView);
        //取得螢幕寬高
        DisplayMetrics dm = new DisplayMetrics();
        Activity a1 =(Activity)context;
        a1.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int vWidth = dm.widthPixels;
        vHeight= dm.heightPixels;
        this.setOnTouchListener(new MyOnTouchListener());

    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.v("chad","onLayout");
        super.onLayout(changed, l, t, r, b);
        actionBarHeight =vHeight-this.getHeight();
        this.setY(1000);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        Log.v("chad","Y= "+this.getY());
//        Log.v("chad","eventY ="+event.getRawY());
        //取得ActionBar 高度


        float postion = event.getRawY()-actionBarHeight;
        if(postion<1848&&postion>1000) {
            this.setY(postion);
        }
        return true/*super.onTouchEvent(event)*/;
    }
    private class MyOnTouchListener implements OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {


            return false;
        }
    }
}
