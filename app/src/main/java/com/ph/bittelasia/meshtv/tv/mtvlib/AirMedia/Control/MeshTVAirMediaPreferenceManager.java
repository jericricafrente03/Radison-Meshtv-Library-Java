package com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Control;

/**
 * Provides access to Airmedia Preference
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshTVAirMediaPreferenceManager
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = "Mars-"+MeshTVAirMediaPreferenceManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Method=========================================
    //----------------------------------------------DeviceName--------------------------------------
    /**
     * Get Airmedia device name
     * @return Airmedia device name
     */
    public static String getDeviceName()
    {
        return BittelAirMediaPreferenceManager.getDeviceName();
    }
    /**
     * Set Airmedia device name
     * @param value Airmedia device name
     */
    public static void setDeviceName(String value)
    {
        BittelAirMediaPreferenceManager.setDeviceName(value);
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------DevicePassword------------------------------------
    /**
     * Get Airmedia password
     * @return Airmedia password
     */
    public static String getDevicePassword()
    {
        return BittelAirMediaPreferenceManager.getDevicePassword();
    }
    /**
     * Set Airmedia password
     * @param value Airmedia password
     */
    public static void setDevicePassword(String value)
    {
        BittelAirMediaPreferenceManager.setDevicePassword(value);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
