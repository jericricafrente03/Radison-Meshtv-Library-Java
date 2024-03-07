package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomMessage.ScrollingFragment;

import android.text.Html;
import android.view.View;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.CustomMessage.ScrollingSettings;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.CustomScrollingTextView.MeshTVScrollingTextView;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;

import java.util.ArrayList;

abstract class BittelScrollingFragment extends MeshTVFragment<Object>
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    public static final String TAG = BittelScrollingFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    ScrollingSettings settings = null;
    MeshMessage message;
    MeshTVScrollingTextView scrollingTextView;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //========================================MeshTVFragment========================================
    @Override
    protected void onDrawDone(View v)
    {
        settings = getClass().getAnnotation(ScrollingSettings.class);
        if(settings!=null)
        {
            scrollingTextView = (MeshTVScrollingTextView) v.findViewById(settings.scrollingTextId());
        }
        else
        {
            throw new RuntimeException("MeshTVScrollSettings Annotation is Required");
        }
        if(scrollingTextView!=null)
        {
            if(message!=null)
            {
                setMessage(message);
            }
            else
            {
                scrollingTextView.setVisibility(View.GONE);
            }
        }


    }
    @Override
    protected void onDataUpdated(ArrayList items) {

    }
    @Override
    protected void onNewData(Object o) {

    }
    @Override
    protected void onDataUpdated(Object o, int index) {

    }
    @Override
    protected void onDeleteData(int index) {

    }
    @Override
    protected void onClearData() {

    }
    @Override
    protected void onDataNotFound(Class c) {

    }
    @Override
    protected void refresh() {

    }
    @Override
    protected void update(Object item) {

    }
    //==============================================================================================
    //============================================Method============================================
    //--------------------------------------------Setter--------------------------------------------
    public void setMessage(MeshMessage message)
    {
        this.message = message;
        if(message.getMessg_type()==MeshMessage.TYPE_SCROLLING)
        {
            if(scrollingTextView!=null)
            {
                scrollingTextView.setText(Html.fromHtml(message.getMessg_text()));
                scrollingTextView.setDisplayTime(message.getMessg_display_time());
            }
        }

    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Abstract===========================================

    //==============================================================================================
}
