package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util;

import android.content.Context;
/**
 * Utility Methods for maintenance purposes
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshUtil
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG                  = MeshUtil.class.getSimpleName();
    /**
     * Use for broadcastin that PIP is readt to play
     */
    public static final String PIP_VIDEO_READY      = "PIP_VIDEO_READY";
    /**
     * Stops PIP
     */
    public static final String PIP_VIDEO_STOP       = "PIP_VIDEO_STOP";
    /**
     * Tag for the video uri
     */
    public static final String PIP_VIDEO_URI        = "PIP_VIDEO_URI";
    /**
     * Tag for the seek of the PIP video
     */
    public static final String PIP_VIDEO_SEEK       = "PIP_VIDEO_SEEK";
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //================================================OS============================================

    /**
     * Retrieves the Android SDK version of the Device
     * @return Android SDK version
     */
    public static int getVersion()
    {
        return BittelUtil.getAndroidOS();
    }
    //==============================================================================================
    //=============================================Hardware=========================================
    /**
     * Retrieves the total available hard disk space of the device
     * @return total free space of the Device in MegaBytes
     */
    public static String getTotalROM(Context context)
    {
        return BittelUtil.getTotalROM();
    }
    /**
     * Retrieves Total RAM Capacity of the Device
     * @param context Required to access activity manager
     * @return Total RAM
     */
    public static String getTotalRAM(Context context)
    {
        return BittelUtil.getTotalRAM(context);
    }
    /**
     * Get total number of cores of the device
     * @return total cores
     */
    public static int countCores()
    {
        return BittelUtil.getNumberOfCores();
    }
    //==============================================================================================

}
