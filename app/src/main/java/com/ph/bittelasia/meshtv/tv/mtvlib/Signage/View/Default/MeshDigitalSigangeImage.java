package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.View.Default;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.ResourceManager.MeshResourceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshSignage;

import java.util.ArrayList;


public abstract class MeshDigitalSigangeImage extends MeshTVFragment
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshDigitalSigangeImage.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------View--------------------------------------------
    public ImageView iv_image;
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    public MeshSignage signage;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Setter------------------------------------------
    public void setSignage(MeshSignage signage)
    {
        this.signage = signage;
        Log.i(TAG,"Setting signage");

        if(iv_image!=null)
        {
            Log.i(TAG,"Loading:"+signage.getMedia());
            MeshResourceManager.displayLiveImageFor(getActivity(),iv_image,this.signage.getMedia());
        }
        else
        {
            Log.i(TAG,"Signage not done");
        }
    }

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================MeshTVFragment======================================
    @Override
    protected void onDrawDone(View view)
    {
        iv_image =getIv_image();
        if(signage!=null)
        {
            MeshResourceManager.displayLiveImageFor(getActivity(),iv_image,signage.getMedia());

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
    //=========================================Abstract=============================================
    public abstract ImageView getIv_image();
    //==============================================================================================
}
