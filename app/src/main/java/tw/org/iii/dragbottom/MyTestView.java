package tw.org.iii.dragbottom;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

/**
 * Created by User on 2018/4/11.
 */

public class MyTestView extends LinearLayout{
    private int actionBarHeight, vHeight;
    private MyListView listView;
    private View myView;
    private ArrayList<HashMap<String,String>> data;
    float postion;
    private float handInt;
    private SimpleAdapter simpleAdapter;
    public MyTestView(Context context){
        super(context);

    }
    public MyTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        data = new ArrayList<>();
        for(int i=0;i<20;i++){
            HashMap<String,String> m1 =new HashMap<>();
            m1.put("title",i+"");
            m1.put("texts","abc "+i);
            data.add(m1);
        }
        LayoutInflater mInflater = LayoutInflater.from(context);
        myView = mInflater.inflate(R.layout.test, null);
        addView(myView);
        //取得螢幕寬高
        DisplayMetrics dm = new DisplayMetrics();
        Activity a1 =(Activity)context;
        a1.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int vWidth = dm.widthPixels;
        vHeight= dm.heightPixels;
        Log.v("chad",vHeight+"");
        intitListView();


    }
    public ArrayList<HashMap<String,String>> getDataList(){
        return data;
    }
    public SimpleAdapter getSimpleAdapter(){
        return simpleAdapter;
    }
    private void intitListView(){
        String[] from =new String[]{"title","texts"};
        int[] to =new int[]{R.id.title,R.id.texts};
        listView =myView.findViewById(R.id.listview);
        simpleAdapter=new SimpleAdapter(this.getContext(),data, R.layout.sample_list,from,to);
        listView.setAdapter(simpleAdapter);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        actionBarHeight =320;
        this.setY(960);

    }
    //判斷LISTVIEW 是否置頂
    private boolean isFirstItemVisible() {
        final Adapter adapter = listView.getAdapter();

        if (null == adapter || adapter.isEmpty()) {
            return true;
        }
        //第一个可见item在ListView中的位置
        if (listView.getFirstVisiblePosition() == 0) {
            //getChildCount是当前屏幕可见范围内的count
            int mostTop = (getChildCount() > 0) ? listView.getChildAt(0)
                    .getTop() : 0;
            if (mostTop >= 0) {
                return true;
            }
        }
        return false;
    }



    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {


        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//            Log.v("chad", "ACTION_DOWN");

            handInt =ev.getRawY();
        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {

                float temp = handInt - ev.getRawY();
                if (temp >0 ) {
                    handInt = ev.getRawY();
                    Log.v("chad", "ACTION_MOVE_up");
                    if(this.getY()==960) {
                        return false;
                    }else{
                        this.setY(960);
                    }

                } else if (temp < -0) {
                    Log.v("chad", isFirstItemVisible()+"");

                    handInt = ev.getRawY();
                    if(this.getY()==960&&isFirstItemVisible()) {
                        this.setY(1960-600);

                    }else{
                        return false;
                    }
                }


            return true;
        }

        return false;










    }

}
