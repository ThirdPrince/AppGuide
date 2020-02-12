package com.example.appguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.appguide.view.MyScrollView;

public class ScrollViewActivity extends AppCompatActivity {


    public static void startActivity(Activity activity)
    {
        Intent intent = new Intent(activity,ScrollViewActivity.class);
        activity.startActivity(intent);
    }


    private MyScrollView myScrollView ;
    private LinearLayout anim ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        initView();
    }

    private void initView()
    {
        myScrollView = findViewById(R.id.scroll_view);
        anim = findViewById(R.id.anim);
        myScrollView.setOnScrollChangeListener(new MyScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(int top, int oldTop) {
                if(top > oldTop)
                {
                   // anim.setVisibility(View.VISIBLE);
                    Animation animation = AnimationUtils.loadAnimation(ScrollViewActivity.this,R.anim.scroll_view_bottom_scal);
                    anim.startAnimation(animation);
                }else
                {
                   // anim.setVisibility(View.INVISIBLE);
                    Animation animation = AnimationUtils.loadAnimation(ScrollViewActivity.this,R.anim.scroll_view_bottom_alpha);
                    anim.startAnimation(animation);

                }
            }
        });
    }
}
