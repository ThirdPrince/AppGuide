package com.example.appguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.appguide.adapter.ImageFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends AppCompatActivity {


    private ViewPager view_pager ;

    private List<Fragment> list ;


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
    }

    private void initData()
    {
        list = new ArrayList<>();
        list.add( VideoFragment.newInstance(0));
        list.add( VideoFragment.newInstance(1));
        view_pager.setAdapter(new ImageFragmentAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,list));
    }
}
