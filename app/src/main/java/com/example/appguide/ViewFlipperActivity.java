package com.example.appguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

public class ViewFlipperActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {


    public static  void startActivity(Activity activity)
    {
        Intent intent = new Intent(activity,ViewFlipperActivity.class);
        activity.startActivity(intent);

    }

    private ViewFlipper view_flipper ;

    private GestureDetector gestureDetector ;

    private int index = 0;

    private  Animation animation ;

    private boolean isFling = false ;

    private LinearLayout indicator ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);

        view_flipper = findViewById(R.id.view_flipper);
        indicator = findViewById(R.id.indicator);
        initData();
        initIndicator();
    }

    private void initData()
    {
        gestureDetector = new GestureDetector(this);
    }
    private void initIndicator()
    {
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,15f,getResources().getDisplayMetrics());

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width,width,1);

        lp.rightMargin =  width;
        lp.leftMargin = width ;
        for(int i = 0;i<view_flipper.getChildCount();i++)
        {
            View view = new View(this);
            view.setBackgroundResource(i == 0 ? R.drawable.dot_focus_ring :R.drawable.dot_normal_ring);
            view.setLayoutParams(lp);
            indicator.addView(view);
        }
    }

    private void changeIndicator()
    {
        for(int i = 0;i<indicator.getChildCount();i++)
        {
            View view = indicator.getChildAt(i);
            view.setBackgroundResource(i == index ? R.drawable.dot_focus_ring :R.drawable.dot_normal_ring);
        }
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent startEvent, MotionEvent endEvent, float v, float v1) {


            if (startEvent.getX() > endEvent.getX()) {
                animation = AnimationUtils.loadAnimation(this, R.anim.right_in);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        isFling = true ;
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        isFling = false ;
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                //if(!isFling)
                {
                    view_flipper.setInAnimation(animation);
                    view_flipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.left_out));
                    view_flipper.showNext();
                    index = index < 2 ? index +1 :0;
                }

            } else if (startEvent.getX() < endEvent.getX()) {
                animation = AnimationUtils.loadAnimation(this, R.anim.left_in);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        isFling = true ;
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        isFling = false ;
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
               // if(!isFling)
                {
                    view_flipper.setInAnimation(animation);
                    view_flipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.right_out));
                    view_flipper.showPrevious();
                    index = index >0 ? index -1 :2;

                }

            } else if (startEvent.getX() == endEvent.getX()) {
                return false;
            }
        changeIndicator();
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
