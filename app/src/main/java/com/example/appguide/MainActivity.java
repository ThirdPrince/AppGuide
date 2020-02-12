package com.example.appguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 四种 引导页启动方式
 */
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void viewPage(View view)
    {

        ViewPagerGuideActivity.startActivity(this);
    }

    public void viewFlipper(View view)
    {
        ViewFlipperActivity.startActivity(this);
    }
    public void scrollView(View view)
    {
        ScrollViewActivity.startActivity(this);
    }

    public void video(View view)
    {
        VideoActivity.startActivity(this);
    }


}
