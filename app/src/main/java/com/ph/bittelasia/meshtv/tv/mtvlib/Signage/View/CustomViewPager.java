package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.View;

import android.content.Context;

import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Control.CustomViewPagerEventListener;

public class CustomViewPager extends ViewPager
{
    static final String TAG = CustomViewPager.class.getSimpleName();
    private boolean enabled;
    CustomViewPagerEventListener listener;
    public CustomViewPager(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.enabled = true;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (this.enabled)
        {
            int action = event.getAction();
            switch (action)
            {
                case MotionEvent.ACTION_UP:
                    if(getListener()!=null)
                        getListener().isClicked(true);
                    return true;
                case MotionEvent.ACTION_DOWN:
                    Log.i(TAG,"action down");
                    return true;
            }
            if(getListener()!=null)
            {
                getListener().isClicked(true);
            }

            return super.onTouchEvent(event);
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event)
    {
        if (this.enabled)
        {
            int action = event.getAction();
            switch (action)
            {
                case MotionEvent.ACTION_UP:
                    Log.i(TAG,"intercept action up");
                    return true;
                case MotionEvent.ACTION_DOWN:
                    if(getListener()!=null)
                        getListener().isClicked(true);
                    return true;
            }
            return super.onInterceptTouchEvent(event);
        }
        return false;
    }

    @Override
    public boolean onDragEvent(DragEvent event)
    {
        if (this.enabled)
        {
            return super.onDragEvent(event);
        }
        return false;
    }

    @Override
    public boolean onHoverEvent(MotionEvent event) {
        if(this.enabled) {
            if(getListener()!=null)
            {
                getListener().isHovered(true);
            }

            super.onHoverEvent(event);
        }
        return false;

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if(this.enabled)
        {
            switch (event.getKeyCode())
            {
                case KeyEvent.KEYCODE_DPAD_CENTER:
                    Log.i(TAG,"keycode center: "+event.getKeyCode());
                    return true;
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    Log.i(TAG,"keycode left: "+event.getKeyCode());
                    return false;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    Log.i(TAG,"keycode right: "+event.getKeyCode());
                    return false;
            }

            if(getListener()!=null)
            {
                getListener().isClicked(true);
            }

            return super.dispatchKeyEvent(event);
        }
        return false;
    }

    public void setPagingEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public void setListener(CustomViewPagerEventListener listener) {
        this.listener = listener;
    }

    public CustomViewPagerEventListener getListener() {
        return listener;
    }

}
