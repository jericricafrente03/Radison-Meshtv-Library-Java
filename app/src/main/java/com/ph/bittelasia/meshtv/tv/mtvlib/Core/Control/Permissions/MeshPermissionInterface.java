package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Permissions;

import android.content.Context;
import android.util.Log;

/**
 * Provides easy access to Permission Requests
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshPermissionInterface
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String  TAG                         = MeshPermissionInterface.class.getSimpleName();
    /**
     * Request for Record Audio Permission
     */
    public static final int     TAG_RECORD_AUDIO            = BittelPermissions.TAG_RECORD_AUDIO;
    /**
     * Request for Write External Permission
     */
    public static final int     TAG_WRITE_EXTERNAL          = BittelPermissions.TAG_WRITE_EXTERNAL;
    /**
     * Request for Read External Permission
     */
    public static final int     TAG_READ_EXTERNAL           = BittelPermissions.TAG_READ_EXTERNAL;
    /**
     * Request for Read Calendar
     */
    public static final int     TAG_READ_CALENDAR           = BittelPermissions.TAG_READ_CALENDAR;
    /**
     * Request for Write Calendar
     */
    public static final int     TAG_WRITE_CALENDAR          = BittelPermissions.TAG_WRITE_CALENDAR;
    /**
     * Request for Access to Camera
     */
    public static final int     TAG_CAMERA                  = BittelPermissions.TAG_CAMERA;
    /**
     * Request to Read Contacts
     */
    public static final int     TAG_READ_CONTACTS           = BittelPermissions.TAG_READ_CONTACTS;
    /**
     * Request to Write Contacts
     */
    public static final int     TAG_WRITE_CONTACTS          = BittelPermissions.TAG_WRITE_CONTACTS;
    /**
     * Request to get Accounts
     */
    public static final int     TAG_GET_ACCOUNTS            = BittelPermissions.TAG_GET_ACCOUNTS;
    /**
     * Request to access Fine Location
     */
    public static final int     TAG_ACCESS_FINE_LOCATION    = BittelPermissions.TAG_ACCESS_FINE_LOCATION;
    /**
     * Request to access Phone State
     */
    public static final int     TAG_ACCESS_COARSE_LOCATION  = BittelPermissions.TAG_ACCESS_COARSE_LOCATION;
    /**
     * Request to access Phone State
     */
    public static final int     TAG_READ_PHONE_STATE        = BittelPermissions.TAG_READ_PHONE_STATE;
    /**
     * Request to make calls
     */
    public static final int     TAG_CALL_PHONE              = BittelPermissions.TAG_CALL_PHONE;
    /**
     * Request to access call logs
     */
    public static final int     TAG_READ_CALL_LOG           = BittelPermissions.TAG_READ_CALL_LOG;
    /**
     * Request to add call logs
     */
    public static final int     TAG_WRITE_CALL_LOG          = BittelPermissions.TAG_WRITE_CALL_LOG;
    /**
     * Request to add voice mail
     */
    public static final int     TAG_ADD_VOICE_MAIL          = BittelPermissions.TAG_ADD_VOICE_MAIL;
    /**
     * Request to use SIP
     */
    public static final int     TAG_USE_SIP                 = BittelPermissions.TAG_USE_SIP;
    /**
     * Request to process outgoing calls
     */
    public static final int     TAG_PROCESS_OUTGOING_CALLS  = BittelPermissions.TAG_PROCESS_OUTGOING_CALLS;
    /**
     * Request to access body sensors
     */
    public static final int     TAG_BODY_SENSORS            = BittelPermissions.TAG_BODY_SENSORS;
    /**
     * Request to send SMS
     */
    public static final int     TAG_SEND_SMS                = BittelPermissions.TAG_SEND_SMS;
    /**
     * Request to receive SMS
     */
    public static final int     TAG_RECEIVE_SMS             = BittelPermissions.TAG_RECEIVE_SMS;
    /**
     * Request to access WAP Push
     */
    public static final int     TAG_RECEIVE_WAP_PUSH        = BittelPermissions.TAG_RECEIVE_WAP_PUSH;
    /**
     * Request to receive MMS
     */
    public static final int     TAG_RECEIVE_MMS             = BittelPermissions.TAG_RECEIVE_MMS;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Request------------------------------------------
    /**
     * Checks if the permission is allowed, if not it will request permission from the current user
     * @param context required to launch the request
     * @param request id of the permission requested
     * @return
     */
    public static boolean requestPermission(Context context, int request)
    {
        Log.i(TAG,"requestPermission( context, "+request+" )");
        boolean result = BittelPermissions.requestPermission(context,request);
        Log.i(TAG,"Result: "+result);
        return result;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
