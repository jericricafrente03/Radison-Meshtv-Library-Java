package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.util.AttributeSet;
import android.widget.ViewFlipper;

import androidx.annotation.ColorInt;

public class CustomViewFlipper extends ViewFlipper {

    Paint paint = new Paint();
    Paint paint2 = new Paint();

    private int currentDisplayedColor= Color.TRANSPARENT;

    private int defaultColor=Color.TRANSPARENT;

    private int yIndicatorPlace;

    private float margin;

    private float radius;

    public CustomViewFlipper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int width = getWidth();

        float cx = width / 2 - ((getRadius() + getMargin()) * 2 * getChildCount() / 2);
        float cy = getHeight() - getyIndicatorPlace();

        canvas.save();

        paint.setAntiAlias(true);
        paint2.setAntiAlias(true);

        for (int i = 0; i < getChildCount(); i++) {
            if (i == getDisplayedChild()) {
                paint2.setColor(getCurrentDisplayedColor());
                paint.setColor(getDefaultColor());
                paint.setStrokeWidth(2);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeCap(Paint.Cap.ROUND);
                canvas.drawCircle(cx, cy, getRadius(), paint2);
                canvas.drawCircle(cx, cy, getRadius(), paint);

            } else {
                paint2.setColor(getDefaultColor());
                paint.setColor(getDefaultColor());
                paint.setStrokeWidth(2);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeCap(Paint.Cap.ROUND);
                canvas.drawCircle(cx, cy, getRadius(), paint2);
                canvas.drawCircle(cx, cy, getRadius(), paint);
            }
            cx += 2 * (getRadius() + getMargin());
        }
        canvas.restore();
    }

    public int getCurrentDisplayedColor() {
        return currentDisplayedColor;
    }

    public void setCurrentDisplayedColor(@ColorInt int currentDisplayedColor) {
        this.currentDisplayedColor = currentDisplayedColor;
    }

    public int getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(@ColorInt int defaultColor) {
        this.defaultColor = defaultColor;
    }

    public int getyIndicatorPlace() {
        return yIndicatorPlace;
    }

    public void setyIndicatorPlace(int yIndicatorPlace) {
        this.yIndicatorPlace = yIndicatorPlace;
    }

    public float getMargin() {
        return margin;
    }

    public void setMargin (float margin) {
        this.margin = margin;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}