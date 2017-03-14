package com.texsoft.imentoris.widgets;


import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Rogerio Lavoro on 14/03/2017.
 */

public class ViewPagerNoSwipe extends ViewPager {
    public ViewPagerNoSwipe(Context context) {
        super(context);
    }

    public ViewPagerNoSwipe(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {

        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return false;
    }
}
