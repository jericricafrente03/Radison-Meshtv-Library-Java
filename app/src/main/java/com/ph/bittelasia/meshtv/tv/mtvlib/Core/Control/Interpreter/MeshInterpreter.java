package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Interpreter;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;

/**
 * Interprets certain texts to App Values
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshInterpreter
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = MeshInterpreter.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Keys---------------------------------------------
    /**
     * Replaced with guest name
     */
    public static final String KEY_GUEST = "[guest_name]";
    /**
     * Replaced with guest room
     */
    public static final String ACC_NO = "[account_no]";
    /**
     * Replaced with account number
     */
    public static final String KEY_ROOM = "[guest_room]";
    /**
     * Replaced with guest first name
     */
    public static final String KEY_GUEST_FNAME = "[f_guest_name]";
    /**
     * Replaced with guest last name
     */
    public static final String KEY_GUEST_LNAME = "[l_guest_name]";
    /**
     * Replaced with guest country
     */
    public static final String KEY_GUEST_COUNTRY = "[guest_country]";
    /**
     * Replaced with guest city
     */
    public static final String KEY_GUEST_CITY = "[guest_city]";
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================

    /**
     * Replaces certain text patterns with app data
     * @param raw String to interpret
     * @return Interpreted String
     */
    public static String interpret(String raw)
    {

        return raw
                .replace(KEY_GUEST, MeshTVPreferenceManager.getGuestFirstName(null)+" "+MeshTVPreferenceManager.getGuestLastName(null))
                .replace(ACC_NO,MeshTVPreferenceManager.getAccountID(null))
                .replace(KEY_ROOM,MeshTVPreferenceManager.getRoom(null))
                .replace(KEY_GUEST_FNAME,MeshTVPreferenceManager.getGuestFirstName(null))
                .replace(KEY_GUEST_LNAME,MeshTVPreferenceManager.getGuestLastName(null))
                .replace(KEY_GUEST_COUNTRY,MeshTVPreferenceManager.getGuestCountry(null))
                .replace(KEY_GUEST_CITY,MeshTVPreferenceManager.getGuestCity(null));

    }
    //==============================================================================================
}
