package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Result;

import android.app.Activity;
import android.content.Intent;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util.MeshUtil;

/**
 * Manages onActivityResults
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
final class BittelResultManager
{
    //================================================Variable======================================
    //------------------------------------------------Constant--------------------------------------
    static final String TAG = BittelResultManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==================================================Method======================================
    //----------------------------------------------GenerateResult----------------------------------

    /**
     * Manages on ActivityResult when PIP is runned and the calling activity should be closed
     * @param a the Activity waiting for the result and to be cl
     * @param url url of the video
     * @param seek if set will seek video
     */
    final static synchronized void openPIPOnClose(Activity a,String url,int seek)
    {
        Intent i = new Intent();
        i.putExtra(MeshUtil.PIP_VIDEO_URI,url);
        i.putExtra(MeshUtil.PIP_VIDEO_SEEK,seek);
        a.setResult(Activity.RESULT_OK,i);
        a.finish();
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
