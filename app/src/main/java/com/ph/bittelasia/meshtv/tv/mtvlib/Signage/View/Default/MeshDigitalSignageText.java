package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.View.Default;

import android.view.View;


import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshSignage;

import java.util.ArrayList;

public abstract class MeshDigitalSignageText extends MeshTVFragment
{

    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    public static final String TAG = MeshDigitalSignageText.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Instance-------------------------------------------
    MeshSignage signage;
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------View---------------------------------------------
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Method============================================
    //--------------------------------------------Getter--------------------------------------------
    public MeshSignage getSignage() {
        return signage;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Setter--------------------------------------------
    public void setSignage(MeshSignage signage)
    {
        this.signage = signage;
        updateDisplay(signage);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================MeshTVFragment=======================================
    @Override
    protected void onDrawDone(View view) {

        if(signage!=null)
        {
            updateDisplay(signage);
        }
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
    //===========================================Abstract===========================================
    public abstract void updateDisplay(MeshSignage signage);
    //==============================================================================================
}
