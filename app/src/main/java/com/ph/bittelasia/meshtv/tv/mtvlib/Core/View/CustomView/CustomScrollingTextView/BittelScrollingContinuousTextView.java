package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.CustomScrollingTextView;

import android.content.Context;
import android.os.Handler;

import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

class BittelScrollingContinuousTextView extends AppCompatTextView
{

    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = BittelScrollingContinuousTextView.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Constructor=======================================
    public BittelScrollingContinuousTextView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        setSingleLine(true);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setMaxLines(1);
        setMarqueeRepeatLimit(-1);

    }
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
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    @Override
    public boolean isSelected()
    {
        return true;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
