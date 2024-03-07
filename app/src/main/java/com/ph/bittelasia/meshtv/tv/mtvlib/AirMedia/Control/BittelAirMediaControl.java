package com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Control;

import android.content.Context;
import android.content.Intent;

import com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Model.MeshAirmediaInstructions;
import com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Model.MeshAirmediaNotes;
import com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Model.MeshAirmediaRequirements;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.FileReader.MeshTVFileManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 * Class developed for controlling Airmedia. Most functions are triggered by sending broadcasts.
 */
class BittelAirMediaControl
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    static final String TAG = BittelAirMediaControl.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //========================================Maintenance Broadcast=================================
    //-----------------------------------------------Action-----------------------------------------
    /**
     * Broadcast Action:
     * <br><br>
     * Target: MeshTV Maintenance Application
     * <br>
     * Function: Action used to trigger system commands through MeshTV Maintenance Application
     */
    public static final String BROADCAST = "MESHTV_MAINTENANCE";
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Extra-Tag---------------------------------------
    /**
     * Broadcast Tag:
     * <br><br>
     * Action: {@link #BROADCAST BROADCAST}
     * <br>
     * Function: The command to be executed.
     */
    public static final String TAG_COMMAND = "COMMAND";
    /**
     * Broadcast Tag:
     * <br><br>
     * Action: {@link #BROADCAST BROADCAST}
     * <br>
     * Function: Package name of app to be Installed/Uninstalled.
     */
    public static final String TAG_PACKAGENAME                      =   "PACKAGE_NAME";
    /**
     * Broadcast Tag:
     * <br><br>
     * Action: {@link #BROADCAST BROADCAST}
     * <br>
     * Function: Path of APK to be installed.
     */
    public static final String TAG_PATH                             =   "PATH";
    /**
     * Broadcast Tag:
     * <br><br>
     * Action: {@link #BROADCAST BROADCAST}
     * <br>
     * Function: Path of APK to be installed.
     */
    public static final String TAG_REMOVE_FILE_ON_INSTALLED         =   "REMOVE";
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Extra-Values-------------------------------------
    /**
     * Broadcast Value:
     * <br><br>
     * Tag: {@link #TAG_COMMAND TAG_COMMAND}
     * <br>
     * Function: Triggers the install function of MeshTV Maintenance Application
     */
    public static final String TAG_INSTALL = "INSTALL";
    /**
     * Broadcast Value:
     * <br><br>
     * Tag: {@link #TAG_COMMAND TAG_COMMAND}
     * <br>
     * Function: Triggers the uninstall function of MeshTV Maintenance Application
     */
    public static final String TAG_UNINSTALL = "UNINSTALL";
    /**
     * Broadcast Value:
     * <br><br>
     * Tag: {@link #TAG_COMMAND TAG_COMMAND}
     * <br>
     * Function: Triggers the reinstall function of MeshTV Maintenance Application
     */
    public static final String TAG_REINSTALL = "REINSTALL";
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================Airmedia Broadcast==================================
    //-----------------------------------------------Action-----------------------------------------
    /**
     * Broadcast Action:
     * <br><br>
     * Target: AirMedia
     * <br>
     * Function: Enables/Disables Airplay(IOS)
     */
    public static final String UPDATE_AIRPLAY        = "com.waxrain.airpin.UPDATE_AIRPLAY";
    /**
     * Broadcast Action:
     * <br><br>
     * Target: AirMedia
     * <br>
     * Function: Enables/Disables DLNA(Android)
     */
    public static final String UPDATE_DLNA           = "com.waxrain.airpin.UPDATE_DLNA";
    /**
     * Broadcast Action:
     * <br><br>
     * Target: AirMedia
     * <br>
     * Function: Changes Display name of Airmedia App on the network
     */
    public static final String UPDATE_NICKNAME       = "com.waxrain.airpin.UPDATE_NICKNAME";
    /**
     * Broadcast Action:
     * <br><br>
     * Target: AirMedia
     * <br>
     * Function: Changes password tp access Airmedia
     */
    public static final String UPDATE_PASSWORD       = "com.waxrain.airpin.UPDATE_PASSWORD";
    /**
     * Broadcast Action:
     * <br><br>
     * Target: AirMedia
     * <br>
     * Function: Enables/Disables System Toasts
     */
    public static final String UPDATE_POP_UP         = "com.waxrain.airpin.UPDATE_POPUPMSG";
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Extra-Tag---------------------------------------
    /**
     * Broadcast Tag:
     * <br><br>
     * Action: All Airmedia Action:
     * <br>
     * 1. ({@link #UPDATE_AIRPLAY UPDATE_AIRPLAY }
     * <br>
     * 2. {@link #UPDATE_DLNA UPDATE_DLNA }
     * <br>
     * 3. {@link #UPDATE_NICKNAME UPDATE_NICKNAME }
     * <br>
     * 4. {@link #UPDATE_PASSWORD UPDATE_PASSWORD }
     * <br>
     * 5. {@link #UPDATE_POP_UP UPDATE_POP_UP }
     * <br>
     * Function: The Project ID Vendor uses to verify if app has subscribed to Airmedia
     */
    public static final String ACCESS_ID    = "accessid";
    /**
     * Broadcast Tag:
     * <br><br>
     * Action:
     * <br>
     * 1. ({@link #UPDATE_AIRPLAY UPDATE_AIRPLAY }
     * <br>
     * 2. {@link #UPDATE_DLNA UPDATE_DLNA }
     * <br>
     * 3. {@link #UPDATE_POP_UP UPDATE_POP_UP }
     * <br>
     * Function: Flag for enabling/disabling options
     * <br>
     * Values:
     * <br>
     * 1. {@link #ENABLE ENABLE} to enable
     * <br>
     * 2. {@link #DISABLE DISABLE} to disable
     */
    public static final String OPTION       = "option";
    /**
     * Broadcast Tag:
     * <br><br>
     * Action:({@link #UPDATE_AIRPLAY UPDATE_AIRPLAY }
     * <br>
     * Function: Flag for enabling/disabling IOS Audio
     * <br>
     * Values:
     * <br>
     * 1. {@link #ENABLE ENABLE} to enable
     * <br>
     * 2. {@link #DISABLE DISABLE} to disable
     */
    public static final String AP_AUDIO     = "audioen";
    /**
     * Broadcast Tag:
     * <br><br>
     * Action:
     * <br>
     * 1. ({@link #UPDATE_AIRPLAY UPDATE_AIRPLAY }
     * <br>
     * 2. ({@link #UPDATE_DLNA UPDATE_DLNA }
     * <br>
     * Function: Selects type of network Airmedia will work on, chooses from either Ethernet/Wi-Fi
     * <br>
     * Values:
     * <br>
     * 1. ({@link #UPDATE_DLNA UPDATE_DLNA }
     * <br>
     * 2. ({@link #UPDATE_DLNA UPDATE_DLNA }
     */
    public static final String BIND_IF      = "bindif";
    /**
     * NIY
     */
    public static final String NICKNAME     = "nickname";
    /**
     * NIY
     */
    public static final String PASSWORD     = "password";
    /**
     * NIY
     */
    public static final String TIMEOUT      = "to";
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Extra-Values-------------------------------------
    /**
     * Broadcast Value:
     * <br><br>
     * Tag: {@link #ACCESS_ID ACCESS_ID}
     * <br>
     * Function: ID for Airmedia Subscription
     */
    public static final String ACCESS_ID_VALUE  = "PRJ:AirPlayer|ID:760ba1810b647cb0";
    /**
     * Broadcast Value:
     * <br><br>
     * Tag:
     * <br>
     * 1. {@link #OPTION OPTION}
     * <br>
     * 2. {@link #AP_AUDIO AP_AUDIO}
     * <br>
     * Function: Enables the Tag
     */
    public static final int ENABLE              = 1;
    /**
     * Broadcast Value:
     * <br><br>
     * Tag:
     * <br>
     * 1. {@link #OPTION OPTION}
     * <br>
     * 2. {@link #AP_AUDIO AP_AUDIO}
     * <br>
     * Function: Disables the Tag
     */
    public static final int DISABLE             = 0;
    /**
     * Broadcast Value:
     * <br><br>
     * Tag: {@link #BIND_IF BIND_IF}
     * <br>
     * Function: Chooses Wi-Fi as the only network Airmedia will work
     */
    public static final String WIFI             = "wlan0";
    /**
     * Broadcast Value:
     * <br><br>
     * Tag: {@link #BIND_IF BIND_IF}
     * <br>
     * Function: Chooses Ethernet as the only network Airmedia will work
     */
    public static final String ETH              = "eth0";
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================================================================
    //===============================================Method=========================================
    //------------------------------------------------APK-------------------------------------------

    /**
     * Installs AirMedia
     * @param context Required to send Broadcasts
     */
    static final synchronized void install(Context context)
    {
        Intent i = new Intent();
        i.setAction(BROADCAST);
        i.putExtra(TAG_COMMAND,TAG_INSTALL);
        i.putExtra(TAG_PACKAGENAME,"com.waxrain.airplaydmr");
        i.putExtra(TAG_PATH ,"airmedia.apk");
        i.putExtra(TAG_REMOVE_FILE_ON_INSTALLED,false);
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        context.sendBroadcast(i);
    }
    /**
     * Uninstalls AirMedia
     * @param context Required to send Broadcasts
     */
    static final synchronized void uninstall(Context context)
    {
        Intent i = new Intent();
        i.setAction(BROADCAST);
        i.putExtra(TAG_COMMAND,TAG_UNINSTALL);
        i.putExtra(TAG_PACKAGENAME,"com.waxrain.airplaydmr");
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        context.sendBroadcast(i);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Action-----------------------------------------
    /**
     * Starts Airmedia Service
     * @param context Required to send Broadcasts
     */
    static final synchronized void startAirMedia(Context context)
    {
        Intent intent = new Intent();
        intent.setClassName("com.waxrain.airplaydmr","com.waxrain.airplaydmr.WaxPlayService");
        context.startService(intent);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------DLNA------------------------------------------
    /**
     * Enables DLNA
     * @param context Required to send Broadcasts
     */
    static final synchronized void enableDLNA(Context context)
    {
        Intent on = new Intent(UPDATE_DLNA);
        on.putExtra(ACCESS_ID,ACCESS_ID_VALUE);
        on.putExtra(OPTION,ENABLE);
        on.putExtra(BIND_IF,WIFI);
        context.sendBroadcast(on);
    }
    /**
     * Disables DLNA
     * @param context Required to send Broadcasts
     */
    static final synchronized void disableDLNA(Context context)
    {
        Intent off = new Intent(UPDATE_DLNA);
        off.putExtra(ACCESS_ID,ACCESS_ID_VALUE);
        off.putExtra(OPTION,DISABLE);
        off.putExtra(BIND_IF,WIFI);
        context.sendBroadcast(off);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------AirPlay----------------------------------------
    /**
     * Enables Airplay
     * @param context Required to send Broadcasts
     */
    static final synchronized void enableAirplay(Context context)
    {
        Intent on = new Intent(UPDATE_AIRPLAY);
        on.putExtra(ACCESS_ID,ACCESS_ID_VALUE);
        on.putExtra(OPTION,ENABLE);
        on.putExtra(BIND_IF,WIFI);
        on.putExtra(AP_AUDIO,ENABLE);
        context.sendBroadcast(on);
    }
    /**
     * Disables Airplay
     * @param context Required to send Broadcasts
     */
    static final synchronized void disableAirplay(Context context)
    {
        Intent off = new Intent(UPDATE_AIRPLAY);
        off.putExtra(ACCESS_ID,ACCESS_ID_VALUE);
        off.putExtra(OPTION,DISABLE);
        off.putExtra(AP_AUDIO,DISABLE);
        off.putExtra(BIND_IF,WIFI);
        context.sendBroadcast(off);
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Credentials--------------------------------------
    /**
     * Set Airmedia username
     * @param context  Required to send Broadcasts
     * @param username New username
     */
    static final synchronized void changeUsername(Context context,String username)
    {
        MeshTVAirMediaPreferenceManager.setDeviceName(username);
        Intent cpassword = new Intent(UPDATE_NICKNAME);
        cpassword.putExtra(ACCESS_ID,ACCESS_ID_VALUE);
        cpassword.putExtra(NICKNAME,username);
        context.sendBroadcast(cpassword);
    }

    /**
     * Set Airmedia password
     * @param context  Required to send Broadcasts
     * @param password New password
     */
    static final synchronized void changePassword(Context context,String password)
    {
        MeshTVAirMediaPreferenceManager.setDevicePassword(password);
        Intent cpassword = new Intent(UPDATE_PASSWORD);
        cpassword.putExtra(ACCESS_ID,ACCESS_ID_VALUE);
        cpassword.putExtra(PASSWORD,password);
        context.sendBroadcast(cpassword);
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------Toast----------------------------------------
    /**
     * Enables Airmedia Toasts
     * @param context Required to send Broadcasts
     */
    public static void enableToast(Context context)
    {
        Intent toast = new Intent(UPDATE_POP_UP);
        toast.putExtra(ACCESS_ID,ACCESS_ID_VALUE);
        toast.putExtra(OPTION,ENABLE);
        context.sendBroadcast(toast);
    }
    /**
     * Disables Airmedia Toasts
     * @param context Required to send Broadcasts
     */
    public static void disableToast(Context context)
    {
        Intent toast = new Intent(UPDATE_POP_UP);
        toast.putExtra(ACCESS_ID,ACCESS_ID_VALUE);
        toast.putExtra(OPTION,DISABLE);
        context.sendBroadcast(toast);
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instructions-------------------------------------

    /**
     * Retrieve Android Instructions
     * @param context required to read raw files
     * @param isFromRaw true if data will be coming from raw files, false if data will be coming from file system
     * @return JSONArray that can be parsed to {@link MeshAirmediaInstructions MeshAirmediaInstructions}
     */
    static final synchronized ArrayList<MeshAirmediaInstructions> getAndroidInstructions(Context context, boolean isFromRaw)
    {
        ArrayList<MeshAirmediaInstructions> instructions = new ArrayList<>();
        String data = "";
        if(isFromRaw)
        {
            data = read(context, R.raw.android_instruction);
        }
        else
        {
            data = read(context, "android_instruction.txt");
        }
        try
        {
            JSONArray array = new JSONArray(new JSONObject(data).getString(MeshAirmediaInstructions.TAG_INS));
            for(int ctr = 0; ctr<array.length();ctr++)
            {
                instructions.add(new MeshAirmediaInstructions(array.getString(ctr)));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return instructions;
    }
    /**
     * Retrieve IOS Instructions
     * @param context required to read raw files
     * @param isFromRaw true if data will be coming from raw files, false if data will be coming from file system
     * @return JSONArray that can be parsed to {@link MeshAirmediaInstructions MeshAirmediaInstructions}
     */
    static final synchronized ArrayList<MeshAirmediaInstructions> getIOSInstructions(Context context, boolean isFromRaw)
    {
        ArrayList<MeshAirmediaInstructions> instructions = new ArrayList<>();
        String data = "";
        if(isFromRaw)
        {
            data = read(context, R.raw.ios_instruction);
        }
        else
        {
            data = read(context, "ios_instruction.txt");
        }

        try
        {
            JSONArray array = new JSONArray(new JSONObject(data).getString(MeshAirmediaInstructions.TAG_INS));
            for(int ctr = 0; ctr<array.length();ctr++)
            {
                instructions.add(new MeshAirmediaInstructions(array.getString(ctr)));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return instructions;
    }
    /**
     * Retrieve Windows Instructions
     * @param context required to read raw files
     * @param isFromRaw true if data will be coming from raw files, false if data will be coming from file system
     * @return JSONArray that can be parsed to {@link MeshAirmediaInstructions MeshAirmediaInstructions}
     */
    static final synchronized ArrayList<MeshAirmediaInstructions> getWindowsInstructions(Context context, boolean isFromRaw)
    {
        ArrayList<MeshAirmediaInstructions> instructions = new ArrayList<>();
        String data = "";
        if(isFromRaw)
        {
            data = read(context, R.raw.windows_instruction);
        }
        else
        {
            data = read(context, "windows_instruction.txt");
        }
        try
        {
            JSONArray array = new JSONArray(new JSONObject(data).getString(MeshAirmediaInstructions.TAG_INS));
            for(int ctr = 0; ctr<array.length();ctr++)
            {
                instructions.add(new MeshAirmediaInstructions(array.getString(ctr)));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return instructions;
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Notes-----------------------------------------
    /**
     * Retrieve Android Notes
     * @param context required to read raw files
     * @param isFromRaw true if data will be coming from raw files, false if data will be coming from file system
     * @return JSONArray that can be parsed to {@link MeshAirmediaNotes MeshAirmediaNotes}
     */
    static final synchronized ArrayList<MeshAirmediaNotes> getAndroidNotes(Context context, boolean isFromRaw)
    {
        ArrayList<MeshAirmediaNotes> notes = new ArrayList<>();
        String data = "";
        if(isFromRaw)
        {
            data = read(context, R.raw.android_instruction);
        }
        else
        {
            data = read(context, "android_instruction.txt");
        }
        try
        {
            JSONArray array = new JSONArray(new JSONObject(data).getString(MeshAirmediaNotes.TAG_NOTE));
            for(int ctr = 0; ctr<array.length();ctr++)
            {
                notes.add(new MeshAirmediaNotes(array.getString(ctr)));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return notes;
    }
    /**
     * Retrieve IOS Notes
     * @param context required to read raw files
     * @param isFromRaw true if data will be coming from raw files, false if data will be coming from file system
     * @return JSONArray that can be parsed to {@link MeshAirmediaNotes MeshAirmediaNotes}
     */
    static final synchronized ArrayList<MeshAirmediaNotes> getIOSNotes(Context context, boolean isFromRaw)
    {
        ArrayList<MeshAirmediaNotes> notes = new ArrayList<>();
        String data = "";
        if(isFromRaw)
        {
            data = read(context, R.raw.ios_instruction);
        }
        else
        {
            data = read(context, "ios_instruction.txt");
        }
        try
        {
            JSONArray array = new JSONArray(new JSONObject(data).getString(MeshAirmediaNotes.TAG_NOTE));
            for(int ctr = 0; ctr<array.length();ctr++)
            {
                notes.add(new MeshAirmediaNotes(array.getString(ctr)));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return notes;
    }
    /**
     * Retrieve Windows Notes
     * @param context required to read raw files
     * @param isFromRaw true if data will be coming from raw files, false if data will be coming from file system
     * @return JSONArray that can be parsed to {@link MeshAirmediaNotes MeshAirmediaNotes}
     */
    static final synchronized ArrayList<MeshAirmediaNotes> getWindowsNotes(Context context, boolean isFromRaw)
    {
        ArrayList<MeshAirmediaNotes> notes = new ArrayList<>();
        String data = "";
        if(isFromRaw)
        {
            data = read(context, R.raw.windows_instruction);
        }
        else
        {
            data = read(context, "windows_instruction.txt");
        }
        try
        {
            JSONArray array = new JSONArray(new JSONObject(data).getString(MeshAirmediaNotes.TAG_NOTE));
            for(int ctr = 0; ctr<array.length();ctr++)
            {
                notes.add(new MeshAirmediaNotes(array.getString(ctr)));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return notes;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Requirements-----------------------------------
    /**
     * Retrieve Android Requirements
     * @param context required to read raw files
     * @param isFromRaw true if data will be coming from raw files, false if data will be coming from file system
     * @return JSONArray that can be parsed to {@link MeshAirmediaRequirements MeshAirmediaRequirements}
     */
    static final synchronized ArrayList<MeshAirmediaRequirements> getAndroidRequirements(Context context, boolean isFromRaw)
    {
        ArrayList<MeshAirmediaRequirements> req = new ArrayList<>();
        String data = "";
        if(isFromRaw)
        {
            data = read(context, R.raw.android_instruction);
        }
        else
        {
            data = read(context, "android_instruction.txt");
        }
        try
        {
            JSONArray array = new JSONArray(new JSONObject(data).getString(MeshAirmediaRequirements.TAG_REQ));
            for(int ctr = 0; ctr<array.length();ctr++)
            {
                req.add(new MeshAirmediaRequirements(array.getString(ctr)));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return req;
    }
    /**
     * Retrieve IOS Requirements
     * @param context required to read raw files
     * @param isFromRaw true if data will be coming from raw files, false if data will be coming from file system
     * @return JSONArray that can be parsed to {@link MeshAirmediaRequirements MeshAirmediaRequirements}
     */
    static final synchronized ArrayList<MeshAirmediaRequirements> getIOSRequirements(Context context, boolean isFromRaw)
    {
        ArrayList<MeshAirmediaRequirements> req = new ArrayList<>();
        String data = "";
        if(isFromRaw)
        {
            data = read(context, R.raw.ios_instruction);
        }
        else
        {
            data = read(context, "ios_instruction.txt");
        }
        try
        {
            JSONArray array = new JSONArray(new JSONObject(data).getString(MeshAirmediaRequirements.TAG_REQ));
            for(int ctr = 0; ctr<array.length();ctr++)
            {
                req.add(new MeshAirmediaRequirements(array.getString(ctr)));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return req;
    }
    /**
     * Retrieve Windows Requirements
     * @param context required to read raw files
     * @param isFromRaw true if data will be coming from raw files, false if data will be coming from file system
     * @return JSONArray that can be parsed to {@link MeshAirmediaRequirements MeshAirmediaRequirements}
     */
    static final synchronized ArrayList<MeshAirmediaRequirements> getWindowsRequirements(Context context, boolean isFromRaw)
    {
        ArrayList<MeshAirmediaRequirements> req = new ArrayList<>();
        String data = "";
        if(isFromRaw)
        {
            data = read(context, R.raw.windows_instruction);
        }
        else
        {
            data = read(context, "windows_instruction.txt");
        }
        try
        {
            JSONArray array = new JSONArray(new JSONObject(data).getString(MeshAirmediaRequirements.TAG_REQ));
            for(int ctr = 0; ctr<array.length();ctr++)
            {
                req.add(new MeshAirmediaRequirements(array.getString(ctr)));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return req;
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Read------------------------------------------------

    /**
     * Reads files from Raw
     * @param context required to access raw files
     * @param resourceID id of the raw file to read
     * @return contents of raw file
     */
    private static String read(Context context,int resourceID)
    {

        InputStream inputStream = context.getResources().openRawResource(resourceID);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String resultFromRaw = "";
        String newLine="";
        do {
            try
            {
                resultFromRaw=resultFromRaw+newLine;
                newLine = br.readLine();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }while (newLine!=null);

        return resultFromRaw;
    }
    /**
     * Reads files from File System
     * @param context required to access raw files
     * @param  filename filename of file to be read
     * @return contents of file
     */
    private static String read(Context context,String filename)
    {
        return MeshTVFileManager.readFile(filename);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
