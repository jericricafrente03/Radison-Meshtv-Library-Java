package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Result;

import android.app.Activity;

/**
 * Manages onActivityResults
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshTVResultManager
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = MeshTVResultManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Method=========================================
    /**
     * Manages on ActivityResult when PIP is runned and the calling activity should be closed
     * @param a the Activity waiting for the result and to be cl
     * @param url url of the video
     * @param seek
     */
    public static synchronized final void openPIPOnClose(Activity a,String url,int seek)
    {
        BittelResultManager.openPIPOnClose(a,url,seek);
    }
    //==============================================================================================
}
