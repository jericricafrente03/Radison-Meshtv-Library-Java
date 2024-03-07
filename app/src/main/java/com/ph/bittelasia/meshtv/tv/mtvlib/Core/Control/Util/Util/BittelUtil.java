package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

import java.io.File;

/**
 * Utility Methods for maintenance purposes
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
final class BittelUtil
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    static final String TAG = BittelUtil.class.getSimpleName();
    static final String RAM_ERROR = "-1";
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=================================================OS===========================================

    /**
     * Retrieves the Android SDK version of the Device
     * @return Android SDK version
     */
    static final int getAndroidOS()
    {
        Log.i(TAG,"getAndroidOS() - Getting SDK Version");
        int version = Build.VERSION.SDK_INT;
        Log.i(TAG,"getAndroidOS() - Version:"+version);
        return version;
    }
    //==============================================================================================
    //==============================================Hardware========================================

    /**
     * Retrieves the total available hard disk space of the device
     * @return total free space of the Device in MegaBytes
     */
    static final String getTotalROM()
    {
        Log.i(TAG,"getTotalRom(context) - Getting total ROM");
        try
        {
            StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long bytesAvailable = (long)stat.getBlockSize() * (long)stat.getAvailableBlocks();
            long megAvailable = bytesAvailable / (1024 * 1024);
            Log.i(TAG,"getTotalRom(context) - ROM : "+megAvailable+" MB(s)");
            return String.valueOf(megAvailable);
        }
        catch (Exception e)
        {

            e.printStackTrace();
            Log.i(TAG,"getTotalRom(context) - Error in Reading ROM");
            return RAM_ERROR;
        }
    }

    /**
     * Retrieves Total RAM Capacity of the Device
     * @param context Required to access activity manager
     * @return Total RAM
     */
    static final String getTotalRAM(Context context)
    {
        Log.i(TAG,"getTotalRam(context) - Getting total RAM");
        try
        {
            ActivityManager actManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
            actManager.getMemoryInfo(memInfo);
            long totalMemory = memInfo.totalMem/(1024*1024);
            Log.i(TAG,"getTotalRam(context) - RAM : "+totalMemory+" MB(s)");
            return String.valueOf(totalMemory);
        }
        catch (Exception e)
        {

            e.printStackTrace();
            Log.i(TAG,"getTotalRam(context) - Error in Reading RAM");
            return RAM_ERROR;
        }



    }

    /**
     * Get total number of cores of the device
     * @return total cores
     */
   static final int getNumberOfCores()
    {
        Log.i(TAG,"getNumberOfCores() - Counting Cores");
        int cores = Runtime.getRuntime().availableProcessors();
        Log.i(TAG,"getNumberOfCores() - Cores: "+cores);
        return cores;

    }
    //==============================================================================================
}
