package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.App;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

/**
 * Launches Activities
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
abstract class BittelAppManager
{

    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    private static final String TAG = BittelAppManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Method=========================================
    //-----------------------------------------------Action-----------------------------------------

    /**
     * Launches Activity with a reference to the calling Activity and the name of Activity to be launched
     * @param a Calling Activity
     * @param activityName Name of Activity to be launched
     */
    static synchronized void launch(Activity a, String activityName)
    {
        Log.i(TAG,"LAUNCHING:"+activityName);
        try
        {
            Intent i = new Intent(a,Class.forName(activityName));
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            a.startActivity(i);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e(TAG,"LAUNCHING FAILED:"+activityName+" ("+e.getMessage()+")");
        }

    }

    /**
     * Launches Activity with a reference to the calling Activity, the name of the Activity to launch and a set of Intent Flags
     * @param a Calling Activity
     * @param activityName Name of Activity to be Launched
     * @param flags Array of flags
     */
    static synchronized void launch (Activity a, String activityName,int... flags)
    {
        Log.i(TAG,"LAUNCHING:"+activityName);
        try
        {
            Intent i = new Intent(a,Class.forName(activityName));
            for(int ctr = 0 ;ctr<flags.length;ctr++)
            {
                i.addFlags(flags[ctr]);
            }
            a.startActivity(i);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e(TAG,"LAUNCHING FAILED:"+activityName+" ("+e.getMessage()+")");
        }
    }


    /**
     * Launches Activity and waits for a response with a reference to the calling activity, activity name and the request code
     * @param a Calling Activity
     * @param activityName Name of Activity to be Launched
     * @param id request code
     */
    static synchronized void launchForResult (Activity a, String activityName,int id)
    {
        Log.i(TAG,"LAUNCHING:"+activityName);
        try
        {
            Intent i = new Intent(a,Class.forName(activityName));
            a.startActivityForResult(i,id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e(TAG,"LAUNCHING FAILED:"+activityName+" ("+e.getMessage()+")");
        }
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

}
