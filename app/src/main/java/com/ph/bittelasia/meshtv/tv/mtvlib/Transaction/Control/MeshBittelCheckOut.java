package com.ph.bittelasia.meshtv.tv.mtvlib.Transaction.Control;

import android.os.AsyncTask;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshCheckOutListener;

public class MeshBittelCheckOut
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshBittelCheckOut.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Method============================================
    public static void checkout(MeshCheckOutListener listener,boolean isDemo,Class... classes)
    {
        new BittelCheckOutCartTask(listener,isDemo,classes).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
    //==============================================================================================
}
