package com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Control;

import android.content.Context;

import com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Model.MeshAirmediaInstructions;
import com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Model.MeshAirmediaNotes;
import com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Model.MeshAirmediaRequirements;

import java.util.ArrayList;

/**
 * Provides access to Airmedia commands
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshTVAirmediaControl
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = MeshTVAirmediaControl.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Method==========================================
    //-----------------------------------------------APK--------------------------------------------
    /**
     * Installs Airmedia App
     * @param context required for sending commands to Airmedia
     */
    public static synchronized void install(Context context)
    {
        BittelAirMediaControl.install(context);
    }
    /**
     * Uninstall Airmedia App
     * @param context required for sending commands to Airmedia
     */
    public static synchronized void uninstall(Context context)
    {
        BittelAirMediaControl.uninstall(context);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Action------------------------------------------
    /**
     * Starts Airmedia Service
     * @param context required for sending commands to Airmedia
     */
    public static final synchronized void startAirMedia(Context context)
    {
        BittelAirMediaControl.startAirMedia(context);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------DLNA------------------------------------------
    /**
     * Enables DLNA for Android and Windows
     * @param context required for sending commands to Airmedia
     */
    public static final synchronized void enableDLNA(Context context)
    {
        BittelAirMediaControl.enableDLNA(context);
    }
    /**
     * Disables DLNA for Android and Windows
     * @param context required for sending commands to Airmedia
     */
    public static final synchronized void disableDLNA(Context context)
    {
        BittelAirMediaControl.disableDLNA(context);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------AirPlay----------------------------------------
    /**
     * Enables Airplay for iOS
     * @param context required for sending commands to Airmedia
     */
    public static final synchronized void enableAirplay(Context context)
    {
        BittelAirMediaControl.enableAirplay(context);
    }
    /**
     * Disables Airplay
     * @param context required for sending commands to Airmedia
     */
    public static final synchronized void disableAirplay(Context context)
    {
        BittelAirMediaControl.disableAirplay(context);
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Credentials--------------------------------------
    /**
     * Change the username of Airmedia
     * @param context required for sending commands to Airmedia
     * @param username New username
     */
    public static final synchronized void changeUsername(Context context,String username)
    {
        BittelAirMediaControl.changeUsername(context,username);
    }
    /**
     * Change the password of Airmedia
     * @param context required for sending commands to Airmedia
     * @param password New password
     */
    public static final synchronized void changePassword(Context context,String password)
    {
        BittelAirMediaControl.changePassword(context,password);
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------Toast----------------------------------------
    /**
     * Enables Airmedia Toast
     * @param context required for sending commands to Airmedia
     */
    public static void enableToast(Context context)
    {
        BittelAirMediaControl.enableToast(context);
    }
    /**
     * Disables Airmedia Toast
     * @param context required for sending commands to Airmedia
     */
    public static void disableToast(Context context)
    {
        BittelAirMediaControl.disableToast(context);
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instructions-------------------------------------
    /**
     * Retrieves {@link MeshAirmediaInstructions MeshAirmediaInstructions} for Android
     * @param context required for accessing raw files
     * @param isFromRaw
     * True - Retrieve android_instruction.txt from raw folder
     * <br>
     * False - Retrieve android_instruction.txt from /sdcard/Android/<DEMO_FOLDER>/
     * @return List of {@link MeshAirmediaInstructions MeshAirmediaInstructions} for Android
     */
    public static final synchronized ArrayList<MeshAirmediaInstructions> getAndroidInstructions(Context context, boolean isFromRaw)
    {
        return BittelAirMediaControl.getAndroidInstructions(context,isFromRaw);
    }
    /**
     * Retrieves {@link MeshAirmediaInstructions MeshAirmediaInstructions} for iOS
     * @param context required for accessing raw files
     * @param isFromRaw
     * True - Retrieve ios_instruction.txt from raw folder
     * <br>
     * False - Retrieve ios_instruction.txt from /sdcard/Android/<DEMO_FOLDER>/
     * @return List of {@link MeshAirmediaInstructions MeshAirmediaInstructions} for Android
     */
    public static final synchronized ArrayList<MeshAirmediaInstructions> getIOSInstructions(Context context, boolean isFromRaw)
    {
        return BittelAirMediaControl.getIOSInstructions(context,isFromRaw);
    }
    /**
     * Retrieves {@link MeshAirmediaInstructions MeshAirmediaInstructions} for Windows
     * @param context required for accessing raw files
     * @param isFromRaw
     * True - Retrieve windows_instruction.txt from raw folder
     * <br>
     * False - Retrieve windows_instruction.txt from /sdcard/Android/<DEMO_FOLDER>/
     * @return List of {@link MeshAirmediaInstructions MeshAirmediaInstructions} for Windows
     */
    public static final synchronized ArrayList<MeshAirmediaInstructions> getWindowsInstructions(Context context, boolean isFromRaw)
    {
        return BittelAirMediaControl.getWindowsInstructions(context,isFromRaw);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Notes-----------------------------------------
    /**
     * Retrieves {@link MeshAirmediaNotes MeshAirmediaNotes} for Android
     * @param context required for accessing raw files
     * @param isFromRaw
     * True - Retrieve android_instruction.txt from raw folder
     * <br>
     * False - Retrieve android_instruction.txt from /sdcard/Android/<DEMO_FOLDER>/
     * @return List of {@link MeshAirmediaNotes MeshAirmediaNotes} for Android
     */
    public static final synchronized ArrayList<MeshAirmediaNotes> getAndroidNotes(Context context, boolean isFromRaw)
    {
        return BittelAirMediaControl.getAndroidNotes(context,isFromRaw);
    }
    /**
     * Retrieves {@link MeshAirmediaNotes MeshAirmediaNotes} for iOS
     * @param context required for accessing raw files
     * @param isFromRaw
     * True - Retrieve ios_instruction.txt from raw folder
     * <br>
     * False - Retrieve ios_instruction.txt from /sdcard/Android/<DEMO_FOLDER>/
     * @return List of {@link MeshAirmediaNotes MeshAirmediaNotes} for iOS
     */
    public static final synchronized ArrayList<MeshAirmediaNotes> getIOSNotes(Context context, boolean isFromRaw)
    {
        return BittelAirMediaControl.getIOSNotes(context,isFromRaw);
    }
    /**
     * Retrieves {@link MeshAirmediaNotes MeshAirmediaNotes} for Windows
     * @param context required for accessing raw files
     * @param isFromRaw
     * True - Retrieve windows_instruction.txt from raw folder
     * <br>
     * False - Retrieve windows_instruction.txt from /sdcard/Android/<DEMO_FOLDER>/
     * @return List of {@link MeshAirmediaNotes MeshAirmediaNotes} for Windows
     */
    public static final synchronized ArrayList<MeshAirmediaNotes> getWindowsNotes(Context context, boolean isFromRaw)
    {
        return BittelAirMediaControl.getWindowsNotes(context,isFromRaw);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Requirements-----------------------------------
    /**
     * Retrieves {@link MeshAirmediaRequirements MeshAirmediaRequirements} for Android
     * @param context required for accessing raw files
     * @param isFromRaw
     * True - Retrieve android_instruction.txt from raw folder
     * <br>
     * False - Retrieve android_instruction.txt from /sdcard/Android/<DEMO_FOLDER>/
     * @return List of {@link MeshAirmediaRequirements MeshAirmediaRequirements} for Android
     */
    public static final synchronized ArrayList<MeshAirmediaRequirements> getAndroidRequirements(Context context, boolean isFromRaw)
    {
        return BittelAirMediaControl.getAndroidRequirements(context,isFromRaw);
    }
    /**
     * Retrieves {@link MeshAirmediaRequirements MeshAirmediaRequirements} for iOS
     * @param context required for accessing raw files
     * @param isFromRaw
     * True - Retrieve ios_instruction.txt from raw folder
     * <br>
     * False - Retrieve ios_instruction.txt from /sdcard/Android/<DEMO_FOLDER>/
     * @return List of {@link MeshAirmediaRequirements MeshAirmediaRequirements} for iOS
     */
    public static final synchronized ArrayList<MeshAirmediaRequirements> getIOSRequirements(Context context, boolean isFromRaw)
    {
        return BittelAirMediaControl.getIOSRequirements(context,isFromRaw);
    }
    /**
     * Retrieves {@link MeshAirmediaRequirements MeshAirmediaRequirements} for Windows
     * @param context required for accessing raw files
     * @param isFromRaw
     * True - Retrieve windows_instruction.txt from raw folder
     * <br>
     * False - Retrieve windows_instruction.txt from /sdcard/Android/<DEMO_FOLDER>/
     * @return List of {@link MeshAirmediaRequirements MeshAirmediaRequirements} for Windows
     */
    public static final synchronized ArrayList<MeshAirmediaRequirements> getWindowsRequirements(Context context, boolean isFromRaw)
    {
        return BittelAirMediaControl.getWindowsRequirements(context,isFromRaw);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}

