package com.example.appguide.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView {

    private static final String TAG = "MyScrollView";

    public interface OnScrollChangeListener
    {
        void onScrollChange(int top ,int oldTop);
    }

    private OnScrollChangeListener onScrollChangeListener ;

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.onScrollChangeListener = onScrollChangeListener;
    }

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onScrollChanged(int l, int top, int oldl, int oldtop) {
        super.onScrollChanged(l, top, oldl, oldtop);

        Log.e(TAG,"top:"+top+"::oldtop=="+oldtop);
        if(onScrollChangeListener != null)
        {
            onScrollChangeListener.onScrollChange(top,oldtop);
        }
    }
}
