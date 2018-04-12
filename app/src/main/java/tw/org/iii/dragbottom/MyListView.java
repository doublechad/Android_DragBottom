package tw.org.iii.dragbottom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 2018/4/12.
 */

public class MyListView extends ListView {
    private TextView tv;
    private boolean isAtTop,isAtBottom;
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        setOnTouchListener(new ListViewOntouch());
        MainActivity ma =(MainActivity)getContext();
        tv =ma.getTv();

        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("chad",parent.getSelectedItem()+"");
                Log.v("chad",position+"");
            }
        });
    }

//    private class ListViewOntouch implements OnTouchListener{
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//
//            return true;
//
//        }
//    }



//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        int scrollRange = computeVerticalScrollRange();
//        int scrollOffset = computeVerticalScrollOffset();
//        int scrollExtend = computeVerticalScrollExtent();
//        if(scrollOffset == 0){
//            //AtTop
//            isAtTop= true;
//        }else if(scrollRange == scrollOffset + scrollExtend){
//            //AtBottom
//            isAtBottom=true;
//        }
//        if(!isAtTop && !isAtBottom){
//            getParent().requestDisallowInterceptTouchEvent(true);
//        }
//        return super.onInterceptTouchEvent(ev);
//    }


}
