package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util;

import android.util.Log;

import java.util.Date;

/**
 * Provides access to the Time Manager for converting time using timezone and retrieving timezone names
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshTVTimeManager
{
    //=======================================Variable===============================================
    //---------------------------------------Constant-----------------------------------------------
    public static final String TAG = MeshTVTimeManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=======================================Method=================================================
    /**
     * Adjusts date to the specified timezone
     * @param date original date
     * @param timeZone timezone to adjust to
     * @return Adjusted date
     */
    public static synchronized final Date update(Date date,float timeZone)
    {
        return BittelTimeManager.convert(date,timeZone);
    }
    /**
     * Contributed by: Steward Marzon Apostol
     * <br>Converts ISO country code to corresponding timezone
     * @param isoCountryCode 2 Character country ISO Code (Philippines -> PH)
     * @return Timezone name (Philippines -> Asia/Manila)
     */
    public static synchronized final String getTimeZoneName(String isoCountryCode)
    {
        Log.i(TAG,"Getting Timezone for:"+isoCountryCode);
        String result = BittelTimeManager.getTimezone(isoCountryCode);
        Log.i(TAG,"Result:"+result);
        return result;
    }
    //==============================================================================================
}
