package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Control;

import android.content.Context;
import android.content.SharedPreferences;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.WeatherForecast.WeatherForecastFragment1.MeshWeatherForecastFragment1;

public class SignagePreference
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = SignagePreference.class.getSimpleName();
    public static final String TAG_DEFAULT_DELAY = "DEFAULT_DELAY";
    public static final String TAG_DEFAULT_LOGO = "DEFAULT_LOGO";
    public static final String TAG_DEFAULT_MESSAGE = "DEFAULT_MESSAGE";
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Method=============================================
    //-----------------------------------------Preference-------------------------------------------
    private static final SharedPreferences getPreference()
    {
        SharedPreferences preferences = MeshTVApp.get().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        return preferences;
    }
    private static final SharedPreferences.Editor getEditor()
    {
        SharedPreferences.Editor editor = getPreference().edit();
        return editor;
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Delay-----------------------------------------------
    public static int getDelay()
    {

        return getPreference().getInt(TAG_DEFAULT_DELAY,5);
    }
    public static void setDelay(int seconds)
    {
        getEditor().putInt(TAG_DEFAULT_DELAY ,seconds).commit();
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Message---------------------------------------------
    public static String getMessage()
    {
        return getPreference().getString(TAG_DEFAULT_MESSAGE,"n/a");
    }
    public static void setMessage(String message)
    {
        getEditor().putString(TAG_DEFAULT_MESSAGE,message).commit();
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Logo-----------------------------------------------
    public static String getLogoUrl()
    {
        return getPreference().getString(TAG_DEFAULT_LOGO,"n/a");
    }
    public static void setLogoUrl(String url)
    {
        getEditor().putString(TAG_DEFAULT_LOGO,url).commit();
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

}
