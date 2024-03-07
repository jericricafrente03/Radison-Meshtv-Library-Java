package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment;


import android.app.Activity;
import android.os.Handler;
import android.view.View;

import java.util.ArrayList;

public abstract class MeshTVQuickTuneFragment extends MeshTVFragment
{

    //=========================================Variable=============================================
    //-----------------------------------------Constant---------------------------------------------
    public static final String TAG = MeshTVQuickTuneFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Instance--------------------------------------------
    RequestChannelCallBack rccb = null;
    String s = "";
    Runnable r = new Runnable() {
        @Override
        public void run()
        {


            h.removeCallbacks(this);
            if(rccb!=null)
            {
                if(s.length()>0)
                {
                    if (s.startsWith("_"))
                    {
                        s=s.replace("_","");
                    }
                    rccb.onChannelRequested(Integer.valueOf(s));
                    s="";
                }

            }
            hide();
        }
    };
    Handler h = new Handler();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================LifeCycle=========================================

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (getActivity() instanceof RequestChannelCallBack)
        {
            rccb = (RequestChannelCallBack)getActivity();
        }
        hide();
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        rccb = null;
    }

    //==============================================================================================
    //===========================================Method=============================================
    public void displayChannel(int i,long delay)
    {
        h.removeCallbacks(r);
        if(s.startsWith("_"))
        {
            s=s.replace("_","");
            s=s+i;
            updateDisplay(s);
        }
        else
        {
            s = "_"+String.valueOf(i);
            updateDisplay(s);

        }
        h.postDelayed(r,delay);

    }
    //==============================================================================================
    //==========================================Abstract============================================
    public abstract void updateDisplay(String display);
    public abstract void hide();
    //==============================================================================================
    //==========================================CallBack============================================
    //========================================RequestChannel========================================
    public interface RequestChannelCallBack
    {
        public abstract void onChannelRequested(int index);

    }
    //==============================================================================================
    //==============================================================================================
    //=======================================MeshTVFragment=========================================
    @Override
    protected void onDrawDone(View v) {

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
}
