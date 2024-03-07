package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

import java.util.concurrent.CountDownLatch;

/**
 * Manages the guest preference of the STB (Currently checked-in guest)
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
class GuestPreference
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    static final String TAG                              = GuestPreference.class.getSimpleName();
    /**
     * Tag for guest firstname preference
     */
    static final String GUEST_FIRSTNAME                  = "firstname";
    /**
     * Tag for guest lastname preference
     */
    static final String GUEST_LASTNAME                   = "lastname";
    /**
     * Tag for guest landline number preference
     */
    static final String GUEST_LANDLINE                   = "landline_no";
    /**
     * Tag for guest address preference
     */
    static final String GUEST_HOME_ADDRESS1              = "home_addr1";
    /**
     * Tag for guest city preference
     */
    static final String GUEST_HOME_ADDRESS2              = "home_addr2";
    /**
     * Tag for guest country preference
     */
    static final String GUEST_HOME_ADDRESS3              = "home_addr3";
    /**
     * Tag for guest zip code preference
     */
    static final String GUEST_HOME_ADDRESS4              = "home_addr4";
    /**
     * Tag for guest zip code preference
     */
    static final String GUEST_ID                         = "id";
    /**
     * Tag for guest zip code preference
     */
    static final String GUEST_CHECKIN                    = "checkin";
    /**
     * Tag for guest class name preference
     */
    static final String GUEST_CLASS_NAME                 = "class_name";
    /**
     * Tag for guest assign id preference
     */
    static final String GUEST_ASSIGN_ID                  = "assign_id";
    /**
     * Tag for guest email address preference
     */
    static final String GUEST_EMAIL                      = "email";
    /**
     * Tag for guest birthdate preference
     */
    static final String GUEST_BIRTHDATE                  = "birthdate";
    /**
     * Tag for guest weather id preference
     */
    static final String GUEST_WEATHER_ID                 = "weather_id";
    /**
     * Tag for guest mobile number preference
     */
    static final String GUEST_MOBILE_NO                  = "mobile_no";
    /**
     * Default guest firstname (Welcome) this is also used when no guest is checked-in
     */
    static final String DEF_GUEST_FIRSTNAME              = "Welcome";
    /**
     * Default guest lastname (Guest) this is also used when no guest is checked-in
     */
    static final String DEF_GUEST_LASTNAME               = "Guest";
    /**
     * Default guest landline no (+6325555555) this is also used when no guest is checked-in
     */
    static final String DEF_GUEST_LANDLINE               = "+6325555555";
    /**
     * Default guest address (MeshTV) this is also used when no guest is checked-in
     */
    static final String DEF_GUEST_HOME_ADDRESS1          = "MeshTV";
    /**
     * Default guest city (Manila) this is also used when no guest is checked-in
     */
    static final String DEF_GUEST_HOME_ADDRESS2          = "Manila";
    /**
     * Default guest country (Philippines) this is also used when no guest is checked-in
     */
    static final String DEF_GUEST_HOME_ADDRESS3          = "Philippines";
    /**
     * Default guest zip code (1747) this is also used when no guest is checked-in
     */
    static final String DEF_GUEST_HOME_ADDRESS4          = "1747";
    /**
     * Default guest id (-1) this is also used when no guest is checked-in
     */
    static final int    DEF_GUEST_ID                     = -1;
    /**
     * Default guest class name (class_name) this is also used when no guest is checked-in
     */
    static final String DEF_GUEST_CLASS_NAME             = "class_name";
    /**
     * Default guest check-in (<BLANK>) this is also used when no guest is checked-in
     */
    static final String DEF_GUEST_CHECKIN                = "";
    /**
     * Default guest assign id (-1) this is also used when no guest is checked-in
     */
    static final int    DEF_GUEST_ASSIGN_ID              = -1;
    /**
     * Default guest email address (support@bittelasia.com) this is also used when no guest is checked-in
     */
    static final String DEF_GUEST_EMAIL                  = "support@bittelasia.com";
    /**
     * Default guest birthdate (1972-12-20) this is also used when no guest is checked-in
     */
    static final String DEF_GUEST_BIRTHDATE              = "1972-12-20";
    /**
     * Default guest weather id (5) this is also used when no guest is checked-in
     */
    static final String DEF_GUEST_WEATHER_ID             = "5";
    /**
     * Default guest mobile no (+6329499999999) this is also used when no guest is checked-in
     */
    static final String DEF_GUEST_MOBILE_NO              = "+6329499999999";
    //----------------------------------------------------------------------------------------------
    //===========================================Actions============================================
    /**
     * Reset the guest config to the default configuration
     * @param context required for accessing preferences
     */
    static final void reset(Context context)
    {
        MeshTVPreferenceManager.setGuestFirstName(context,DEF_GUEST_FIRSTNAME);
        MeshTVPreferenceManager.setGuestLastName(context,DEF_GUEST_LASTNAME);
        MeshTVPreferenceManager.setGuestLandline(context,DEF_GUEST_LANDLINE);
        MeshTVPreferenceManager.setGuestAddress(context,DEF_GUEST_HOME_ADDRESS1);
        MeshTVPreferenceManager.setGuestCity(context,DEF_GUEST_HOME_ADDRESS2);
        MeshTVPreferenceManager.setGuestCountry(context,DEF_GUEST_HOME_ADDRESS3);
        MeshTVPreferenceManager.setGuestPostal(context, DEF_GUEST_HOME_ADDRESS4);
        MeshTVPreferenceManager.setGuestEmail(context,DEF_GUEST_EMAIL);
        MeshTVPreferenceManager.setGuestBirthDate(context,DEF_GUEST_BIRTHDATE);
        MeshTVPreferenceManager.setGuestMobile(context, DEF_GUEST_MOBILE_NO);
    }
    //==============================================================================================
    //==========================================Firstname===========================================

    /**
     * Retrieve guest firstname preference
     * @param context required to access preference
     * @return guest firstname preference (Welcome if no Guest has checked-in)
     */
    static final String getGuestFirstname(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        String result = preferences.getString(GUEST_FIRSTNAME,DEF_GUEST_FIRSTNAME);
        return result;
    }

    /**
     * Sets the guest firstname preference
     * @param context required to access preference
     * @param value new value for firstname
     */
    static final void setGuestFirstname(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(GUEST_FIRSTNAME,value);
        editor.commit();
    }
    //==============================================================================================
    //===========================================Lastname===========================================
    /**
     * Retrieve guest lastname preference
     * @param context required to access preference
     * @return guest lastname preference (Guest if no Guest has checked-in)
     */
    static final String getGuestLastname(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        String result = preferences.getString(GUEST_LASTNAME,DEF_GUEST_LASTNAME);
        return result;
    }
    /**
     * Sets the guest lastname preference
     * @param context required to access preference
     * @param value new value for lastname
     */
    static final void setGuestLastname(Context context,String value)
    {

        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(GUEST_LASTNAME,value);
        editor.commit();
    }
    //==============================================================================================
    //===========================================LandLine===========================================
    /**
     * Retrieve guest landline preference
     * @param context required to access preference
     * @return guest landline preference
     */
    static final String getGuestLandline(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        String result = preferences.getString(GUEST_LANDLINE,DEF_GUEST_LANDLINE);
        return result;
    }
    /**
     * Sets the guest landline preference
     * @param context required to access preference
     * @param value new value for landline
     */
    static final void setGuestLandline(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(GUEST_LANDLINE,value);
        editor.commit();
    }
    //==============================================================================================
    //============================================Address===========================================
    /**
     * Retrieve guest address preference
     * @param context required to access preference
     * @return guest address preference
     */
    static final String getGuestAddress(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        String result = preferences.getString(GUEST_HOME_ADDRESS1,DEF_GUEST_HOME_ADDRESS1);
        return result;
    }
    /**
     * Sets the guest address preference
     * @param context required to access preference
     * @param value new value for address
     */
    static final void setGuestAddress(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(GUEST_HOME_ADDRESS1,value);
        editor.commit();
    }
    //==============================================================================================
    //==============================================================================================
    //==============================================City============================================
    static final String getGuestCity(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        String result = preferences.getString(GUEST_HOME_ADDRESS2,DEF_GUEST_HOME_ADDRESS2);
        return result;
    }
    static final void setGuestCity(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(GUEST_HOME_ADDRESS2,value);
        editor.commit();
    }
    //==============================================================================================
    //============================================Country===========================================
    /**
     * Retrieve guest country preference
     * @param context required to access preference
     * @return guest country preference
     */
    static final String getGuestCountry(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        String result = preferences.getString(GUEST_HOME_ADDRESS3,DEF_GUEST_HOME_ADDRESS3);
        return result;
    }
    /**
     * Sets the guest country preference
     * @param context required to access preference
     * @param value new value for country
     */
    static final void setGuestCountry(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(GUEST_HOME_ADDRESS3,value);
        editor.commit();
    }
    //==============================================================================================
    //=============================================Postal===========================================
    /**
     * Retrieve guest postal preference
     * @param context required to access preference
     * @return guest postal preference
     */
    static final String getGuestPostal(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        String result = preferences.getString(GUEST_HOME_ADDRESS4,DEF_GUEST_HOME_ADDRESS4);
        return result;
    }
    /**
     * Sets the guest postal preference
     * @param context required to access preference
     * @param value new value for postal
     */
    static final void setGuestPostal(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(GUEST_HOME_ADDRESS4,value);
        editor.commit();
    }

    //==============================================================================================
    //===============================================ID=============================================
    /**
     * Retrieve guest id preference
     * @param context required to access preference
     * @return guest id preference
     */
    static final int getGuestID(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }

        int result = preferences.getInt(GUEST_ID,DEF_GUEST_ID);
        return result;
    }
    /**
     * Sets the guest id preference
     * @param context required to access preference
     * @param value new value for id
     */
    static final void setGuestID(Context context,int value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(GUEST_ID,value);
        editor.commit();
    }
    //==============================================================================================
    //===========================================Class Name=========================================
    /**
     * Retrieve guest class name preference
     * @param context required to access preference
     * @return guest class name preference
     */
    static final String getGuestClassName(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        String result = preferences.getString(GUEST_CLASS_NAME,DEF_GUEST_CLASS_NAME);
        return result;
    }
    /**
     * Sets the guest class name preference
     * @param context required to access preference
     * @param value new value for class name
     */
    static final void setGuestClassName(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(GUEST_CLASS_NAME,value);
        editor.commit();
    }
    //==============================================================================================
    //============================================Check-in==========================================
    /**
     * Retrieve guest check-in preference
     * @param context required to access preference
     * @return guest check-in preference
     */
    static final String getGuestCheckin(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        String result = preferences.getString(GUEST_CHECKIN,DEF_GUEST_CHECKIN);
        return result;
    }
    /**
     * Sets the guest check-in preference
     * @param context required to access preference
     * @param value new value for check-in
     */
    static final void setGuestCheckin(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(GUEST_CHECKIN,value);
        editor.commit();
    }
    //==============================================================================================
    //===========================================Assign ID==========================================
    //==============================================================================================
    //===========================================Weather ID=========================================
    /**
     * Retrieve guest weather id preference
     * @param context required to access preference
     * @return guest weather id preference
     */
    static final String getGuestWeatherId(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        String result = preferences.getString(GUEST_WEATHER_ID,DEF_GUEST_WEATHER_ID);
        return result;
    }
    /**
     * Sets the guest weather id preference
     * @param context required to access preference
     * @param value new value for weather id
     */
    static final void setGuestWeatherId(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(GUEST_ASSIGN_ID,value);
        editor.commit();
    }
    //==============================================================================================
    //===========================================Guest Email========================================
    /**
     * Retrieve guest email preference
     * @param context required to access preference
     * @return guest email preference
     */
    static final String getGuestEmail(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        String result = preferences.getString(GUEST_EMAIL,DEF_GUEST_EMAIL);
        return result;
    }
    /**
     * Sets the guest email preference
     * @param context required to access preference
     * @param value new value for email
     */
    static final void setGuestEmail(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(GUEST_EMAIL,value);
        editor.commit();

    }
    //==============================================================================================
    //============================================Birthdate=========================================
    /**
     * Retrieve guest birthdate preference
     * @param context required to access preference
     * @return guest birthdate preference
     */
    static final String getGuestBirthdate(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        String result = preferences.getString(GUEST_BIRTHDATE,DEF_GUEST_BIRTHDATE);
        return result;
    }
    /**
     * Sets the guest birthdate preference
     * @param context required to access preference
     * @param value birthdate for landline
     */
    static final void setGuestBirthdate(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(GUEST_BIRTHDATE,value);
        editor.commit();
    }
    //==============================================================================================
    //============================================Birthdate=========================================
    /**
     * Retrieve guest mobile no preference
     * @param context required to access preference
     * @return guest mobile no preference
     */
    static final String getGuestMobileNo(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        String result = preferences.getString(GUEST_MOBILE_NO,DEF_GUEST_MOBILE_NO);
        return result;
    }
    /**
     * Sets the guest mobile no preference
     * @param context required to access preference
     * @param value new value for mobile no
     */
    static final void setGuestMobileNo(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(GUEST_MOBILE_NO,value);
        editor.commit();
    }
    //==============================================================================================
}
