package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

/**
 * Created by Mars on 3/5/2018.
 */

class NotificationPreferenceManager
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    static final String TAG = NotificationPreferenceManager.class.getSimpleName();
    static final String MESSAGE         = "message";
    static final String TIMEOUT         = "timeout";
    static final String IMG_URL         = "IMG_URL";
    static final String DEFAULT_MESSAGE = "This is a test message";
    static final String DEFAULT_IMG_URL = "n/a";
    static final int    DEFAULT_TIMEOUT = 10000;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Preference======================================
    private static final SharedPreferences getPreference(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        return preferences;
    }
    private static final SharedPreferences.Editor getEditor(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        return preferences.edit();
    }
    //==============================================================================================

    //=================================================URL==========================================
    static final String getScrollingMessage(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(MESSAGE, DEFAULT_MESSAGE);
        return result;
    }
    static final void setScrollingMessage(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(MESSAGE,value);
        editor.commit();
    }
    //==============================================================================================
    //==============================================Timeout=========================================

    static final int getTimeout(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        int result = preferences.getInt(TIMEOUT, DEFAULT_TIMEOUT);
        return result;
    }

    static final void setTimeout(Context context,int value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putInt(TIMEOUT,value);
        editor.commit();
    }
    //==============================================================================================
    //==============================================IMGURL==========================================

    static final String getIMGURL(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(IMG_URL, DEFAULT_IMG_URL);
        return result;
    }

    static final void setIMGURL(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(IMG_URL,value);
        editor.commit();
    }
    //==============================================================================================

}
