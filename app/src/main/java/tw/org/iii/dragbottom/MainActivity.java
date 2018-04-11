package tw.org.iii.dragbottom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout test ;
    private int vWidth,vHeight;
    private Button click1,click2,click3;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = findViewById(R.id.test1);
        tv=findViewById(R.id.tv);
        // 取得螢幕解析度
        DisplayMetrics dm = new DisplayMetrics();
        DisplayMetrics monitorsize =new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(monitorsize);
        vHeight =monitorsize.heightPixels;
        Log.v("chad","高度" +vHeight);
        click1 =test.findViewById(R.id.click1);
        click2 =test.findViewById(R.id.click2);
        click3 =test.findViewById(R.id.click3);
        click1.setOnClickListener(new MyClickListener());
        click2.setOnClickListener(new MyClickListener());
        click3.setOnClickListener(new MyClickListener());
    }

    public void go(View view) {
        view.getHeight();

        test.setY(1800);
    }
    private class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            tv.setText((Math.random()*49)+"");
        }
    }
}
