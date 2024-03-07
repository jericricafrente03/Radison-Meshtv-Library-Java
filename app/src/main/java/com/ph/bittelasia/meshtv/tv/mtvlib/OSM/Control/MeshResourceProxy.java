package com.ph.bittelasia.meshtv.tv.mtvlib.OSM.Control;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import com.ph.bittelasia.meshtv.tv.mtvlib.R;

import org.osmdroid.DefaultResourceProxyImpl;

/**
 * Created by mars on 12/26/17.
 */

public class MeshResourceProxy extends DefaultResourceProxyImpl
{
    Context context;
    public MeshResourceProxy(Context pContext) {
        super(pContext);
        this.context = pContext;
    }


    @Override
    public Bitmap getBitmap(final bitmap pResId) {
        switch (pResId){
            case marker_default:
                //your image goes here!!!
                return BitmapFactory.decodeResource(context.getResources(),R.drawable.address_icon);
        }
        return super.getBitmap(pResId);
    }

    @Override
    public Drawable getDrawable(final bitmap pResId) {
        switch (pResId){
            case marker_default:
                return context.getResources().getDrawable(R.drawable.address_icon);
        }
        return super.getDrawable(pResId);
    }
}
