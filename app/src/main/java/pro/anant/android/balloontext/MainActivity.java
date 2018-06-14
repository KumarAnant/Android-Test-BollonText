package pro.anant.android.balloontext;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import javax.xml.namespace.QName;

public class MainActivity extends Activity {

    private ViewGroup mContentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContentView = (ViewGroup) findViewById(R.id.activity_main);
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setToFullScreen();
            }
        });

        mContentView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Balloon b = new Balloon(MainActivity.this, 0xFFFF0000, 100);
                    qnText qn = new qnText(MainActivity.this, "This is fun!!");
                    b.setX(event.getX());
                    b.setY(event.getY());
                    qn.setX(event.getX());
                    qn.setY(event.getY());
                    mContentView.addView(b);
                    mContentView.addView(qn);
                }

                return false;
            }
        });


    }

    private void setToFullScreen(){
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        setToFullScreen();
    }
}
