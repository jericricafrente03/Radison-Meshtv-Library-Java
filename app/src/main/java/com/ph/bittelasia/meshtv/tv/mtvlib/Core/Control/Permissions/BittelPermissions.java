package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Permissions;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

/**
 * Assists in implementing permission request for dangerous permissions
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
class BittelPermissions
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String  TAG                         = "Mars-"+BittelPermissions.class.getSimpleName();
    /**
     * Request for Record Audio Permission
     */
    public static final int     TAG_RECORD_AUDIO            = 1;
    /**
     * Request for Write External Permission
     */
    public static final int     TAG_WRITE_EXTERNAL          = 2;
    /**
     * Request for Read External Permission
     */
    public static final int     TAG_READ_EXTERNAL           = 3;
    /**
     * Request for Read Calendar
     */
    public static final int     TAG_READ_CALENDAR           = 4;
    /**
     * Request for Write Calendar
     */
    public static final int     TAG_WRITE_CALENDAR          = 5;
    /**
     * Request for Access to Camera
     */
    public static final int     TAG_CAMERA                  = 6;
    /**
     * Request to Read Contacts
     */
    public static final int     TAG_READ_CONTACTS           = 7;
    /**
     * Request to Write Contacts
     */
    public static final int     TAG_WRITE_CONTACTS          = 8;
    /**
     * Request to get Accounts
     */
    public static final int     TAG_GET_ACCOUNTS            = 9;
    /**
     * Request to access Fine Location
     */
    public static final int     TAG_ACCESS_FINE_LOCATION    = 10;
    /**
     * Request to access Coarse Location
     */
    public static final int     TAG_ACCESS_COARSE_LOCATION  = 11;
    /**
     * Request to access Phone State
     */
    public static final int     TAG_READ_PHONE_STATE        = 12;
    /**
     * Request to make calls
     */
    public static final int     TAG_CALL_PHONE              = 13;
    /**
     * Request to access call logs
     */
    public static final int     TAG_READ_CALL_LOG           = 14;
    /**
     * Request to add call logs
     */
    public static final int     TAG_WRITE_CALL_LOG          = 15;
    /**
     * Request to add voice mail
     */
    public static final int     TAG_ADD_VOICE_MAIL          = 16;
    /**
     * Request to use SIP
     */
    public static final int     TAG_USE_SIP                 = 17;
    /**
     * Request to process outgoing calls
     */
    public static final int     TAG_PROCESS_OUTGOING_CALLS  = 18;
    /**
     * Request to access body sensors
     */
    public static final int     TAG_BODY_SENSORS            = 19;
    /**
     * Request to send SMS
     */
    public static final int     TAG_SEND_SMS                = 20;
    /**
     * Request to receive SMS
     */
    public static final int     TAG_RECEIVE_SMS             = 21;
    /**
     * Request to access WAP Push
     */
    public static final int     TAG_RECEIVE_WAP_PUSH        = 22;
    /**
     * Request to receive MMS
     */
    public static final int     TAG_RECEIVE_MMS             = 23;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Method==========================================
    //-----------------------------------------------Init-------------------------------------------

    /**
     * Check if permission is neeed
     * @param id ID of the permission
     * @return
     * Results
     * <br>
     * <br>
     * True - permission should be requested first
     * <br>
     * False - you can already use the feature requested
     */
    private static boolean shouldRequest(int id)
    {
        int version = Build.VERSION.SDK_INT;
        Log.i(TAG,"Android Version:"+version);
        if(version >= Build.VERSION_CODES.M)
        {

            if(ContextCompat.checkSelfPermission(MeshTVApp.get().getApplicationContext(),getPermission(id)) != PackageManager.PERMISSION_GRANTED)
            {
                Log.i(TAG,"Permission not yet granted ("+getPermission(id)+")");
                return true;
            }
            else
            {
                Log.i(TAG,"Permission granted ("+getPermission(id)+")");
                return false;

            }
        }
        else
        {
            Log.i(TAG,"Dangerous Permissions is not supported for Android: "+version);
            return false;
        }
    }

    /**
     * Retrieves the permission associated to the id
     * @param id id of request permission
     * @return name of permission requested
     */
    private static String getPermission(int id)
    {
        switch (id)
        {
            case TAG_RECORD_AUDIO:
                return Manifest.permission.RECORD_AUDIO;
            case TAG_WRITE_EXTERNAL:
                return Manifest.permission.WRITE_EXTERNAL_STORAGE;
            case TAG_READ_EXTERNAL:
                return Manifest.permission.READ_EXTERNAL_STORAGE;
            case TAG_READ_CALENDAR:
                return Manifest.permission.READ_CALENDAR;
            case TAG_WRITE_CALENDAR:
                return Manifest.permission.WRITE_CALENDAR;
            case TAG_CAMERA:
                return Manifest.permission.CAMERA;
            case TAG_READ_CONTACTS:
                return Manifest.permission.READ_CONTACTS;
            case TAG_WRITE_CONTACTS:
                return Manifest.permission.WRITE_CONTACTS;
            case TAG_GET_ACCOUNTS:
                return Manifest.permission.GET_ACCOUNTS;
            case TAG_ACCESS_FINE_LOCATION:
                return Manifest.permission.ACCESS_FINE_LOCATION;
            case TAG_ACCESS_COARSE_LOCATION:
                return Manifest.permission.ACCESS_COARSE_LOCATION;
            case TAG_READ_PHONE_STATE:
                return Manifest.permission.READ_PHONE_STATE;
            case TAG_CALL_PHONE:
                return Manifest.permission.CALL_PHONE;
            case TAG_READ_CALL_LOG:
                return Manifest.permission.READ_CALL_LOG;
            case TAG_WRITE_CALL_LOG:
                return Manifest.permission.WRITE_CALL_LOG;
            case TAG_ADD_VOICE_MAIL:
                return Manifest.permission.ADD_VOICEMAIL;
            case TAG_USE_SIP:
                return Manifest.permission.USE_SIP;
            case TAG_PROCESS_OUTGOING_CALLS:
                return Manifest.permission.PROCESS_OUTGOING_CALLS;
            case TAG_BODY_SENSORS:
                return Manifest.permission.BODY_SENSORS;
            case TAG_SEND_SMS:
                return Manifest.permission.SEND_SMS;
            case TAG_RECEIVE_SMS:
                return Manifest.permission.RECEIVE_SMS;
            case TAG_RECEIVE_WAP_PUSH:
                return Manifest.permission.RECEIVE_WAP_PUSH;
            case TAG_RECEIVE_MMS:
                return Manifest.permission.RECEIVE_MMS;
        }
        return null;
    }

    /**
     * Request the message to be displayed when requesting for permission
     * @param id permission requested
     * @return corresponding message
     */
    private static String getDialogMessage(int id)
    {
        switch (id)
        {
            case TAG_RECORD_AUDIO:
                return "Use the Microphone";
            case TAG_WRITE_EXTERNAL:
                return "Write to External Storage";
            case TAG_READ_EXTERNAL:
                return "Read External Storage";
            case TAG_READ_CALENDAR:
                return "Read the Calendar";
            case TAG_WRITE_CALENDAR:
                return "Write on the Calendar";
            case TAG_CAMERA:
                return "Use the Camera";
            case TAG_READ_CONTACTS:
                return "Read Contacts";
            case TAG_WRITE_CONTACTS:
                return "Write Contacts";
            case TAG_GET_ACCOUNTS:
                return "Get Accounts";
            case TAG_ACCESS_FINE_LOCATION:
                return "Access Fine Location";
            case TAG_ACCESS_COARSE_LOCATION:
                return "Access Coarse Location";
            case TAG_READ_PHONE_STATE:
                return "Read Phone State";
            case TAG_CALL_PHONE:
                return "Make Calls";
            case TAG_READ_CALL_LOG:
                return "Read Call Log";
            case TAG_WRITE_CALL_LOG:
                return "Write Call Log";
            case TAG_ADD_VOICE_MAIL:
                return "Add Voice Mail";
            case TAG_USE_SIP:
                return "Use SIP";
            case TAG_PROCESS_OUTGOING_CALLS:
                return "Process Outgoing Calls";
            case TAG_BODY_SENSORS:
                return "Use Body Sensors";
            case TAG_SEND_SMS:
                return "Send SMS";
            case TAG_RECEIVE_SMS:
                return "Receive SMS";
            case TAG_RECEIVE_WAP_PUSH:
                return "Receive WAP Push";
            case TAG_RECEIVE_MMS:
                return "Receove MMS";
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================RequestPermission====================================
    //-----------------------------------------------Request----------------------------------------

    /**
     * Checks if the permission is allowed, if not it will request permission from the current user
     * @param context required to launch the request
     * @param request id of the permission requested
     * @return
     */
    public static boolean requestPermission(final Context context, final int request)
    {
        if(shouldRequest(request))
        {
            Log.i(TAG,"Requesting permission ("+getPermission(request)+")");
            ActivityCompat.requestPermissions((Activity) context, new String[] { getPermission(request)}, request);
            return false;
        }
        else
        {
            Log.i(TAG,"You can now use: ("+getPermission(request)+")");
            return true;
        }
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}

