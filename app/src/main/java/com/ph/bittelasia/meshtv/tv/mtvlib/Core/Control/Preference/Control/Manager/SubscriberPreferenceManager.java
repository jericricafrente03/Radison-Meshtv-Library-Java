package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshSubscriber;

class SubscriberPreferenceManager
{
    //==========================================Variable============================================
    //------------------------------------------Constant--------------------------------------------
    public static final String TAG                  =  SubscriberPreferenceManager.class.getSimpleName();
    public static final String TAG_ACCOUNT_ID_DEF   = "account_id";
    public static final String TAG_TITLE_DEF        = "title";
    public static final String TAG_LASTNAME_DEF     = "lastname";
    public static final String TAG_MIDDLENAME_DEF   = "middlename";
    public static final String TAG_FIRSTNAME_DEF    = "firstname";
    public static final String TAG_CONTACT_NO_DEF   = "contact_no";
    public static final String TAG_MOBILE_NO_DEF    = "mobile_no";
    public static final String TAG_EMAIL_DEF        = "email";
    public static final String TAG_HOUSE_NO_DEF     = "house_no";
    public static final String TAG_SUBDIVISION_DEF  = "subdivision";
    public static final String TAG_BARANGAY_DEF     = "barangay";
    public static final String TAG_CITY_DEF         = "city";
    public static final String TAG_COUNTRY_CODE_DEF = "country_code";
    public static final String TAG_POSTAL_CODE_DEF  = "postal_code";
    public static final String TAG_PROVINCE_DEF     = "province";
    public static final int TAG_STATUS_DEF          = MeshSubscriber.STATUS_DISABLED;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //========================================Action================================================
    static final void reset(Context context)
    {
        setAccountID(context,TAG_ACCOUNT_ID_DEF);
        setTitle(context,TAG_TITLE_DEF);
        setLastname(context,TAG_LASTNAME_DEF);
        setMiddlename(context,TAG_MIDDLENAME_DEF);
        setFirstname(context,TAG_FIRSTNAME_DEF);
        setContactNo(context,TAG_CONTACT_NO_DEF);
        setMobileNo(context,TAG_MOBILE_NO_DEF);
        setEmailAddress(context,TAG_EMAIL_DEF);
        setHouseNo(context,TAG_HOUSE_NO_DEF);
        setSubdivision(context,TAG_SUBDIVISION_DEF);
        setBarangay(context,TAG_BARANGAY_DEF);
        setCity(context,TAG_CITY_DEF);
        setCountryCode(context,TAG_COUNTRY_CODE_DEF);
        setPostalCode(context,TAG_POSTAL_CODE_DEF);
        setStatus(context,TAG_STATUS_DEF);
        setProvince(context,TAG_PROVINCE_DEF);
    }
    //==============================================================================================
    //==============================================Preference======================================
    private static final SharedPreferences getPreference(Context context)
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
        return preferences;
    }
    private static final SharedPreferences.Editor getEditor(Context context)
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
        return preferences.edit();
    }
    //==============================================================================================
    //============================================Account ID========================================
    /**
     * Retrieve account ID
     * @param context required to access preference
     * @return account ID
     */
    static final String getAccountID(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(MeshSubscriber.TAG_ACCOUNT_ID,TAG_ACCOUNT_ID_DEF);
        return result;
    }
    /**
     * Sets the account ID the STB is registered to
     * @param context required to access preference
     * @param value new account ID
     */
    static final void setAccountID(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(MeshSubscriber.TAG_ACCOUNT_ID,value);
        editor.commit();
    }
    //==============================================================================================
    //===============================================Title==========================================
    /**
     * Retrieve title/salutation of the account holder
     * @param context required to access preference
     * @return title/salutation of the account holder
     */
    static final String getTitle(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(MeshSubscriber.TAG_TITLE,TAG_TITLE_DEF);
        return result;
    }
    /**
     * Sets the title/salutation of the account holder
     * @param context required to access preference
     * @param value new title/salutation of the account holder
     */
    static final void setTitle(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(MeshSubscriber.TAG_TITLE,value);
        editor.commit();
    }
    //==============================================================================================
    //=============================================Lastname=========================================
    /**
     * Retrieve lastname of the account holder
     * @param context required to access preference
     * @return lastname of the account holder
     */
    static final String getLastname(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(MeshSubscriber.TAG_LASTNAME,TAG_LASTNAME_DEF);
        return result;
    }
    /**
     * Sets the lastname of the account holder
     * @param context required to access preference
     * @param value new lastname of the account holder
     */
    static final void setLastname(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(MeshSubscriber.TAG_LASTNAME,value);
        editor.commit();
    }
    //==============================================================================================
    //=============================================Firstname========================================
    /**
     * Retrieve firstname of the account holder
     * @param context required to access preference
     * @return firstname of the account holder
     */
    static final String getFirstname(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(MeshSubscriber.TAG_FIRSTNAME,TAG_FIRSTNAME_DEF);
        return result;
    }
    /**
     * Sets the firstname of the account holder
     * @param context required to access preference
     * @param value new firstname of the account holder
     */
    static final void setFirstname(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(MeshSubscriber.TAG_FIRSTNAME,value);
        editor.commit();
    }
    //==============================================================================================
    //=============================================Middlename=======================================
    /**
     * Retrieve middlename of the account holder
     * @param context required to access preference
     * @return middlename of the account holder
     */
    static final String getMiddlename(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(MeshSubscriber.TAG_MIDDLENAME,TAG_MIDDLENAME_DEF);
        return result;
    }
    /**
     * Sets the middlename of the account holder
     * @param context required to access preference
     * @param value new middlename of the account holder
     */
    static final void setMiddlename(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(MeshSubscriber.TAG_MIDDLENAME,value);
        editor.commit();
    }
    //==============================================================================================
    //=============================================Contact No=======================================
    /**
     * Retrieve contact number of the account holder
     * @param context required to access preference
     * @return contact number of the account holder
     */
    static final String getContactNo(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(MeshSubscriber.TAG_CONTACT_NO,TAG_CONTACT_NO_DEF);
        return result;
    }
    /**
     * Sets the contact number of the account holder
     * @param context required to access preference
     * @param value new contact number of the account holder
     */
    static final void setContactNo(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(MeshSubscriber.TAG_CONTACT_NO,value);
        editor.commit();
    }
    //==============================================================================================
    //=============================================Mobile No========================================
    /**
     * Retrieve mobile number of the account holder
     * @param context required to access preference
     * @return mobile number of the account holder
     */
    static final String getMobileNo(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(MeshSubscriber.TAG_MOBILE_NO,TAG_MOBILE_NO_DEF);
        return result;
    }
    /**
     * Sets the contact number of the account holder
     * @param context required to access preference
     * @param value new contact number of the account holder
     */
    static final void setMobileNo(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(MeshSubscriber.TAG_MOBILE_NO,value);
        editor.commit();
    }
    //==============================================================================================
    //===============================================Email==========================================
    /**
     * Retrieve email address of the account holder
     * @param context required to access preference
     * @return email address of the account holder
     */
    static final String getEmailaddress(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(MeshSubscriber.TAG_EMAIL,TAG_EMAIL_DEF);
        return result;
    }
    /**
     * Sets the email address of the account holder
     * @param context required to access preference
     * @param value new email address of the account holder
     */
    static final void setEmailAddress(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(MeshSubscriber.TAG_EMAIL,value);
        editor.commit();
    }
    //==============================================================================================
    //=============================================House No=========================================
    /**
     * Retrieve house no. of the account holder
     * @param context required to access preference
     * @return house no. of the account holder
     */
    static final String getHouseNo(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(MeshSubscriber.TAG_HOUSE_NO,TAG_HOUSE_NO_DEF);
        return result;
    }
    /**
     * Sets the house no. of the account holder
     * @param context required to access preference
     * @param value new house no. of the account holder
     */
    static final void setHouseNo(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(MeshSubscriber.TAG_HOUSE_NO,value);
        editor.commit();
    }
    //==============================================================================================
    //============================================Subdivision=======================================
    /**
     * Retrieve subdivision of the account holder
     * @param context required to access preference
     * @return subdivision. of the account holder
     */
    static final String getSubdivision(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(MeshSubscriber.TAG_SUBDIVISION,TAG_SUBDIVISION_DEF);
        return result;
    }
    /**
     * Sets the subdivision of the account holder
     * @param context required to access preference
     * @param value new subdivision of the account holder
     */
    static final void setSubdivision(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(MeshSubscriber.TAG_SUBDIVISION,value);
        editor.commit();
    }
    //==============================================================================================
    //=============================================Barangay=========================================
    /**
     * Retrieve barangay of the account holder
     * @param context required to access preference
     * @return barangay of the account holder
     */
    static final String getBarangay(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(MeshSubscriber.TAG_BARANGAY,TAG_BARANGAY_DEF);
        return result;
    }
    /**
     * Sets the barangay of the account holder
     * @param context required to access preference
     * @param value new barangay of the account holder
     */
    static final void setBarangay(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(MeshSubscriber.TAG_BARANGAY,value);
        editor.commit();
    }
    //==============================================================================================
    //===============================================City===========================================
    /**
     * Retrieve city of the account holder
     * @param context required to access preference
     * @return city of the account holder
     */
    static final String getCity(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(MeshSubscriber.TAG_CITY,TAG_CITY_DEF);
        return result;
    }
    /**
     * Sets the city of the account holder
     * @param context required to access preference
     * @param value new city of the account holder
     */
    static final void setCity(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(MeshSubscriber.TAG_CITY,value);
        editor.commit();
    }
    //==============================================================================================
    //=============================================Province=========================================
    /**
     * Retrieve province of the account holder
     * @param context required to access preference
     * @return province of the account holder
     */
    static final String getProvince(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(MeshSubscriber.TAG_PROVINCE,TAG_PROVINCE_DEF);
        return result;
    }
    /**
     * Sets the province of the account holder
     * @param context required to access preference
     * @param value new province of the account holder
     */
    static final void setProvince(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(MeshSubscriber.TAG_PROVINCE,value);
        editor.commit();
    }
    //==============================================================================================
    //============================================Country Code======================================
    /**
     * Retrieve country code of the account holder
     * @param context required to access preference
     * @return country code of the account holder
     */
    static final String getCountryCode(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(MeshSubscriber.TAG_COUNTRY_CODE,TAG_COUNTRY_CODE_DEF);
        return result;
    }
    /**
     * Sets the country code of the account holder
     * @param context required to access preference
     * @param value new country code of the account holder
     */
    static final void setCountryCode(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(MeshSubscriber.TAG_COUNTRY_CODE,value);
        editor.commit();
    }
    //==============================================================================================
    //=============================================Postal Code======================================
    /**
     * Retrieve postal code of the account holder
     * @param context required to access preference
     * @return postal code of the account holder
     */
    static final String getPostalCode(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(MeshSubscriber.TAG_POSTAL_CODE,TAG_POSTAL_CODE_DEF);
        return result;
    }
    /**
     * Sets the postal code of the account holder
     * @param context required to access preference
     * @param value new postal code of the account holder
     */
    static final void setPostalCode(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(MeshSubscriber.TAG_POSTAL_CODE,value);
        editor.commit();
    }
    //==============================================================================================
    //==============================================Status==========================================
    /**
     * Retrieve status of Subscription:
     * <br>
     * <br>
     * Results:
     * <br>
     * 0 - disabled
     * <br>
     * 1 - enabled
     * @param context required to access preference
     * @return status of account
     */
    static final int getStatus(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        int result = preferences.getInt(MeshSubscriber.TAG_STATUS,TAG_STATUS_DEF);
        return result;
    }
    /**
     * Sets the status of account
     * @param context required to access preference
     * @param value new status of account
     */
    static final void setStatus(Context context,int value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putInt(MeshSubscriber.TAG_STATUS,value);
        editor.commit();
    }
    //==============================================================================================

}
