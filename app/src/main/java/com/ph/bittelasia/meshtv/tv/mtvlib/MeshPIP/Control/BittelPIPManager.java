package com.ph.bittelasia.meshtv.tv.mtvlib.MeshPIP.Control;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

/**
 * Created by mars on 12/7/17.
 */

class BittelPIPManager
{
    //==================================================Variable====================================
    //--------------------------------------------------Constant------------------------------------
    public static final String TAG  = BittelPIPManager.class.getSimpleName();
    static final int FULL_WIDTH     = 1920;
    static final int FULL_HEIGHT    = 1080;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===================================================Method=====================================
    //----------------------------------------------------Init--------------------------------------
    static void run(Activity a,String url, long time, boolean isMovable, int x, int y, int width, int height)
    {
        Log.i(TAG,"Init PIP");
        Log.i(TAG,"URL:"+url);
        BittelPIPPreference.setPIPURL(a,url);
        Log.i(TAG,"Seek:"+time);
        BittelPIPPreference.setPIPSeek(a,time);
        Log.i(TAG,"Seekable:"+(time>-1));
        BittelPIPPreference.setPIPCanSeek(a,time>-1);
        Log.i(TAG,"Movable:"+(isMovable));
        BittelPIPPreference.setIsMovable(a,isMovable);
        Log.i(TAG,"X:"+x);
        BittelPIPPreference.setPIPX(a,x);
        Log.i(TAG,"Y:"+y);
        BittelPIPPreference.setPIPY(a,y);
        Log.i(TAG,"Width:"+width);
        BittelPIPPreference.setPIPWidth(a,width);
        Log.i(TAG,"Height:"+height);
        BittelPIPPreference.setPIPHeight(a,height);

        launch(a);

    }
    static void run(Activity a,String url, long time, boolean isMovable, double scale)
    {
        Log.i(TAG,"Init PIP");
        Log.i(TAG,"URL:"+url);
        BittelPIPPreference.setPIPURL(a,url);
        Log.i(TAG,"Seek:"+time);
        BittelPIPPreference.setPIPSeek(a,time);
        BittelPIPPreference.setPIPCanSeek(a,time>-1);
        Log.i(TAG,"Seekable:"+(time>-1));
        BittelPIPPreference.setIsMovable(a,isMovable);
        Log.i(TAG,"Movable:"+(isMovable));
        BittelPIPPreference.setPIPX(a,FULL_WIDTH-(((int)(FULL_WIDTH*scale))+20));
        Log.i(TAG,"X:"+(FULL_WIDTH-(((int)(FULL_WIDTH*scale))+20)));
        BittelPIPPreference.setPIPY(a,FULL_HEIGHT-(((int)(FULL_HEIGHT*scale))+20));
        Log.i(TAG,"Y:"+(FULL_HEIGHT-(((int)(FULL_HEIGHT*scale))+20)));
        BittelPIPPreference.setPIPWidth(a,(int)(FULL_WIDTH*scale));
        Log.i(TAG,"Width:"+((int)(FULL_WIDTH*scale)));
        BittelPIPPreference.setPIPHeight(a,(int)(FULL_HEIGHT*scale));
        Log.i(TAG,"Height:"+((int)(FULL_HEIGHT*scale)));
        launch(a);

    }
    static void run(Activity a,String url, long time, boolean isMovable)
    {
        Log.i(TAG,"Init PIP");
        Log.i(TAG,"URL:"+url);
        BittelPIPPreference.setPIPURL(a,url);
        BittelPIPPreference.setPIPSeek(a,time);
        Log.i(TAG,"Seek:"+time);
        BittelPIPPreference.setPIPCanSeek(a,time>-1);
        Log.i(TAG,"Seekable:"+(time>-1));
        BittelPIPPreference.setIsMovable(a,isMovable);
        Log.i(TAG,"Movable:"+(isMovable));
        BittelPIPPreference.setPIPX(a,FULL_WIDTH-(((int)(FULL_WIDTH*.2))+20));
        Log.i(TAG,"X:"+(FULL_WIDTH-(((int)(FULL_WIDTH*.2))+20)));
        BittelPIPPreference.setPIPY(a,FULL_HEIGHT-(((int)(FULL_HEIGHT*.2))+20));
        Log.i(TAG,"Y:"+(FULL_HEIGHT-(((int)(FULL_HEIGHT*.2))+20)));
        BittelPIPPreference.setPIPWidth(a,(int)(FULL_WIDTH*.2));
        Log.i(TAG,"Width:"+((int)(FULL_WIDTH*.2)));
        BittelPIPPreference.setPIPHeight(a,(int)(FULL_HEIGHT*.2));
        Log.i(TAG,"Height:"+((int)(FULL_HEIGHT*.2)));

        launch(a);

    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------Action------------------------------------
    private static void launch(Activity a)
    {
        Log.i(TAG,"Running PIP");
        Intent i = new Intent(a,MeshTVPIP.class);
        a.startService(i);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
