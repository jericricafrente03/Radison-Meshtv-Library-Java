package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.View.Default;

import android.view.View;
import android.widget.TextClock;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.CustomScrollingTextView.MeshTVScrollingTextView;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshSignage;

import java.util.ArrayList;

public abstract class MeshDigitalSignageScroll extends MeshTVFragment
{

    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    public static final String TAG = MeshDigitalSignageScroll.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------View---------------------------------------------
    public TextClock tc_time;
    MeshTVScrollingTextView scrolling;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================MeshTVFragment=======================================
    @Override
    protected void onDrawDone(View view)
    {
        tc_time=getTextClock();
        scrolling = getScrollingTextView();
        scrolling.setDisplayTime(60*60*24);
    }

    @Override
    protected void onDataUpdated(ArrayList arrayList) {

    }

    @Override
    protected void onNewData(Object o) {

    }

    @Override
    protected void onDataUpdated(Object o, int i) {

    }

    @Override
    protected void onDeleteData(int i) {

    }

    @Override
    protected void onClearData() {

    }

    @Override
    protected void onDataNotFound(Class aClass) {

    }

    @Override
    protected void refresh() {

    }

    @Override
    protected void update(Object o) {

    }
    //==============================================================================================
    //=============================================Abstract=========================================
    public abstract MeshTVScrollingTextView getScrollingTextView();
    public abstract TextClock getTextClock();
    //==============================================================================================
}
