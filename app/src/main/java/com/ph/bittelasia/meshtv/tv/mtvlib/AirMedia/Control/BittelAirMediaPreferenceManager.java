package com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Control;

import android.content.Context;
import android.content.SharedPreferences;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

/**
 * Manages Airmedia Preferences
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
class BittelAirMediaPreferenceManager
{

    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    static final String TAG = "Mars-"+BittelAirMediaPreferenceManager.class.getSimpleName();
    /**
     * Tag for Airmedia device name
     */
    static final String TAG_DEVICE_NAME = "device_name";
    /**
     * Default Airmedia device name
     */
    static final String TAG_DEVICE_NAME_DEF = "airmedia";
    /**
     * Tag for Airmedia password
     */
    static final String TAG_DEVICE_PASSWORD = "device_password";
    /**
     * Default Airmedia password
     */
    static final String TAG_DEVICE_PASSWORD_DEF = "123456";
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================DeviceName=========================================
    /**
     * Retrieve the current saved Airmedia device name
     * @return Airmedia device name
     */
    static final String getDeviceName()
    {
        SharedPreferences preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        String result = preferences.getString(TAG_DEVICE_NAME,TAG_DEVICE_NAME_DEF);
        return result;
    }
    /**
     * Update the Airmedia device name
     * @param value new Airmedia device name
     */
    static final void setDeviceName(String value)
    {
        SharedPreferences preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TAG_DEVICE_NAME,value);
        editor.commit();
    }
    //==============================================================================================
    //=========================================DevicePassword=======================================
    /**
     * Retrieve the current saved Airmedia password
     * @return Airmedia password
     */
    static final String getDevicePassword()
    {
        SharedPreferences preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        String result = preferences.getString(TAG_DEVICE_PASSWORD,TAG_DEVICE_PASSWORD_DEF);
        return result;
    }
    /**
     * Update the Airmedia password
     * @param value new Airmedia password
     */
    static final void setDevicePassword(String value)
    {
        SharedPreferences preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TAG_DEVICE_PASSWORD,value);
        editor.commit();
    }
    //==============================================================================================
}
