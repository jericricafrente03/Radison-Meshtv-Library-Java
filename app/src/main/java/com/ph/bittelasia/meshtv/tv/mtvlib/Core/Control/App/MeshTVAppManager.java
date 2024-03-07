package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.App;

import android.app.Activity;

/**
 * Provides Access to AppManager
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshTVAppManager
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    public static final String TAG = MeshTVAppManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Method============================================
    //--------------------------------------------Action--------------------------------------------
    /**
     * Launches Activity with a reference to the calling Activity and the name of Activity to be launched
     * @param a Calling Activity
     * @param name Name of Activity to be launched
     */
    public static void launch(Activity a,String name)
    {
        BittelAppManager.launch(a,name);
    }
    /**
     * Launches Activity with a reference to the calling Activity, the name of the Activity to launch and a set of Intent Flags
     * @param a Calling Activity
     * @param name Name of Activity to be Launched
     * @param flags Array of flags
     */
    public static void launch(Activity a,String name,int... flags)
    {
        BittelAppManager.launch(a,name,flags);
    }
    /**
     * Launches Activity and waits for a response with a reference to the calling activity, activity name and the request code
     * @param a Calling Activity
     * @param name Name of Activity to be Launched
     * @param id request code
     */
    public static void launchForeResult(Activity a,String name,int id)
    {
        BittelAppManager.launchForResult(a,name,id);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
