package tw.org.iii.dragbottom;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private MyTestView test ;
    private int vWidth,vHeight;
    private Button click1,click2,click3;
    private TextView tv;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        test = findViewById(R.id.test1);
        tv=findViewById(R.id.tv);
        actionBar=getSupportActionBar();
        actionBar.hide();
        // 取得螢幕解析度
        DisplayMetrics dm = new DisplayMetrics();
        DisplayMetrics monitorsize =new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(monitorsize);
        vHeight =monitorsize.heightPixels;
        float yDpi =monitorsize.ydpi;
        int dd =monitorsize.densityDpi;
        Log.v("chad","dpi = "+dd);
        Log.v("chad","高度" +vHeight);
        //px = dp * (dpi / 160  )

    }

    public void add(View view) {
        ArrayList<HashMap<String,String>> data =test.getDataList();
        HashMap<String,String> m1 =new HashMap<>();
        m1.put("title","1");
        m1.put("texts","abc");
        data.add(m1);
        test.getSimpleAdapter().notifyDataSetChanged();

    }
    public TextView getTv(){
        return tv;
    }

    private class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            tv.setText((Math.random()*49)+"");
        }
    }
}
