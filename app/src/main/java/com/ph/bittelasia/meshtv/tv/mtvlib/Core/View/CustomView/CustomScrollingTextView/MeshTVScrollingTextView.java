package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.CustomScrollingTextView;

import android.content.Context;

import android.util.AttributeSet;

import androidx.annotation.Nullable;

public class MeshTVScrollingTextView extends BittelScrollingTextView
{
    public MeshTVScrollingTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public void setDisplayTime(int seconds)
    {
        setSeconds(seconds);
    }
}
