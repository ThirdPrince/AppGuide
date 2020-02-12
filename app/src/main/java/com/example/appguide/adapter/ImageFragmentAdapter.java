package com.example.appguide.adapter;

import android.media.Image;

import com.example.appguide.ImageFragment;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ImageFragmentAdapter extends FragmentPagerAdapter {


    private List<Fragment> list;

    public ImageFragmentAdapter(@NonNull FragmentManager fm, int behavior,List<Fragment> list) {
        super(fm, behavior);
        this.list = list ;

    }

    /*public ImageFragmentAdapter(@NonNull FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list = list ;
    }*/




    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
