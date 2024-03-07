package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.CustomScrollingTextView;

import android.content.Context;
import android.os.Handler;

import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

class BittelScrollingTextView extends AppCompatTextView
{

    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = BittelScrollingTextView.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    Handler h;
    int seconds = 5;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            setVisibility(GONE);
        }
    };
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Constructor=======================================
    public BittelScrollingTextView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        setSingleLine(true);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setMaxLines(1);
        h = new Handler();
        h.postDelayed(runnable,seconds*1000);
    }
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    @Override
    public boolean isSelected()
    {
        return true;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------

    final void setSeconds(int seconds) {
        this.seconds = seconds;
        setVisibility(VISIBLE);
        h.removeCallbacks(runnable);
        if(seconds>-1)
        {
            h.postDelayed(runnable,this.seconds*1000);
        }
    }

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================TextView==========================================
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) getLayoutParams();
        params.width = w;
        params.height = h;
        params.weight=0;
        setLayoutParams(params);
    }
    //==============================================================================================
}
