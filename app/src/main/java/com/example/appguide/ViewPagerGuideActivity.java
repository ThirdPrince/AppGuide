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

/**
 * ViewPager 滑动 引导页
 */
public class ViewPagerGuideActivity extends AppCompatActivity {

    private ViewPager viewPager ;

    private LinearLayout indicator  ;

    private List<Fragment> imageFragmentList ;

    public static void startActivity(Activity activity)
    {
        Intent intent = new Intent(activity,ViewPagerGuideActivity.class);
        activity.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_guide);
        initId();
        initData();
    }
    private void initId()
    {
        viewPager = findViewById(R.id.viewPage);
        indicator = findViewById(R.id.indicator);

    }

    private void initData()
    {
        imageFragmentList = new ArrayList<>();
        for(int i = 0; i<3;i++)
        {
            imageFragmentList.add(ImageFragment.newInstance(i));
        }
        viewPager.setAdapter(new ImageFragmentAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,imageFragmentList));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0;i<indicator.getChildCount();i++) {
                    View  view = indicator.getChildAt(i);
                    view.setBackgroundResource(i == position ? R.drawable.dot_focus_line :R.drawable.dot_normal_line);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        initIndicator();
    }

    private void initIndicator()
    {
        int width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,15f,getResources().getDisplayMetrics());

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width,width,1);

        lp.rightMargin =  width;
        lp.leftMargin = width ;
        for(int i = 0;i<imageFragmentList.size();i++)
        {
            View view = new View(this);
            view.setBackgroundResource(i == 0 ? R.drawable.dot_focus_line :R.drawable.dot_normal_line);
            view.setLayoutParams(lp);
            indicator.addView(view);
        }
    }
}
