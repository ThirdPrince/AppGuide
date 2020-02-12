package com.example.appguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.example.appguide.adapter.ImageFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends AppCompatActivity {


    private ViewPager view_pager ;

    private List<Fragment> list ;

    private LinearLayout indicator ;

    public static void startActivity(Activity activity)
    {
        Intent intent = new Intent(activity,VideoActivity.class);
        activity.startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();
        initData();
    }

    private void initView()
    {
        view_pager  = findViewById(R.id.view_pager);
        indicator = findViewById(R.id.indicator);
    }

    private void initData()
    {
        list = new ArrayList<>();
        list.add( VideoFragment.newInstance(0));
        list.add( VideoFragment.newInstance(1));
        view_pager.setAdapter(new ImageFragmentAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,list));
        initIndicator();
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0;i<indicator.getChildCount();i++) {
                    View  view = indicator.getChildAt(i);
                    view.setBackgroundResource(i == position ? R.drawable.dot_focus :R.drawable.dot_normal);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initIndicator()
    {
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,15f,getResources().getDisplayMetrics());

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width,width,1);

        lp.rightMargin =  width;
        lp.leftMargin = width ;
        for(int i = 0;i<list.size();i++)
        {
            View view = new View(this);
            view.setBackgroundResource(i == 0 ? R.drawable.dot_focus :R.drawable.dot_normal);
            view.setLayoutParams(lp);
            indicator.addView(view);
        }
    }
}
