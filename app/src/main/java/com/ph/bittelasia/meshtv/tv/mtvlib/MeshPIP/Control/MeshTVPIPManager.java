package com.ph.bittelasia.meshtv.tv.mtvlib.MeshPIP.Control;

import android.app.Activity;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

public class MeshTVPIPManager
{
    //===============================================Variable=======================================
    //-----------------------------------------------Constant---------------------------------------
    public static final String TAG = MeshTVPIPManager.class.getSimpleName();
    public static final double SCALE_HALF = 0.5;
    public static final double SCALE_80 = 0.8;
    public static final double SCALE_20 = 0.2;

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //================================================Method========================================
    //-----------------------------------------------Launcher---------------------------------------
    public final static void run (Activity a,String url, long time, boolean isMovable,int x, int y, int width, int height)
    {
        BittelPIPManager.run(a,url,time,isMovable,x,y,width,height);
    }
    public final static void run ( Activity a,String url, long time, boolean isMovable,double scale)
    {
        BittelPIPManager.run(a,url,time,isMovable,scale);
    }
    public final static void run (Activity a,String url, long time, boolean isMovable)
    {
        BittelPIPManager.run(a,url,time,isMovable);
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Getter-------------------------------------------
    public final static String getURL(Activity a)
    {
        return BittelPIPPreference.getPIPURL(a);
    }
    public final static long getSeek(Activity a)
    {
        return BittelPIPPreference.getPIPSeek(a);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
