package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

/**
 * Manages the config preference of the STB (Hotel Configuration)
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
class HotelPreference
{
    //==========================================Variable============================================
    //------------------------------------------Constant--------------------------------------------
    public static final String TAG                          = HotelPreference.class.getSimpleName();
    /**
     * Tag for hotel city
     */
    public static final String CONFIG_CITY                  = "hotel_city";
    /**
     * Tag for hotel city
     */
    public static final String CONFIG_COUNTRY               = "hotel_country";
    /**
     * Tag for hotel currency
     */
    public static final String CONFIG_CURRENCY              = "hotel_currency";
    /**
     * Tag for hotel email
     */
    public static final String CONFIG_EMAIL                 = "hotel_email";
    /**
     * Tag for hotel map coordinates
     */
    public static final String CONFIG_MAP_COORD             = "hotel_map_coord";
    /**
     * Tag for hotel map coordinates latitude
     */
    public static final String CONFIG_MAP_LAT               = "hotel_lat";
    /**
     * Tag for hotel map coordinates longitude
     */
    public static final String CONFIG_MAP_LONG              = "hotel_long";
    /**
     * Tag for hotel name
     */
    public static final String CONFIG_NAME                  = "hotel_name";
    /**
     * Tag for hotel street
     */
    public static final String CONFIG_HOTEL_STREET          = "hotel_street";
    /**
     * Tag for hotel timezone
     */
    public static final String CONFIG_TIMEZONE_ID           = "hotel_timezone_id";
    /**
     * Tag for hotel weather id
     */
    public static final String CONFIG_WEATHER_ID            = "hotel_weather_id";
    /**
     * Tag for hotel website
     */
    public static final String CONFIG_WEBSITE               = "hotel_website";
    /**
     * Tag for hotel reservation number
     */
    //Todo: original->reservation_message
    public static final String CONFIG_RESERVATION_MSG       = "hotel_reservation_message";
    /**
     * Tag for hotel welcome message
     */
    //Todo: oroginal->welcome_message
    public static final String CONFIG_WELCOME_MSG           = "hotel_welcome_message";
    /**
     * Tag for hotel service request message
     */
    //Todo: original->service_request_message
    public static final String CONFIG_SVC_REQUEST_MSG       = "hotel_service_request_message";
    /**
     * Tag for hotel check-out message
     */
    //Todo: original->checkout_message
    public static final String CONFIG_CHECKOUT_MSG          = "hotel_checkout_message";
    /**
     * Tag for hotel logo
     */
    public static final String CONFIG_LOGO                  = "hotel_logo";
    //Default
    /**
     * Default hotel city
     */
    public static final String DEF_CONFIG_CITY              = "hotel_city";
    /**
     * Default hotel country
     */
    public static final String DEF_CONFIG_COUNTRY           = "hotel_country";
    /**
     * Default hotel currency
     */
    public static final String DEF_CONFIG_CURRENCY          = "hotel_currency";
    /**
     * Default hotel email
     */
    public static final String DEF_CONFIG_EMAIL             = "hotel_email";
    /**
     * Default hotel map coord
     */
    public static final String DEF_CONFIG_MAP_COORD         = "hotel_map_coord";
    /**
     * Default hotel map coord latitude
     */
    public static final String DEF_CONFIG_MAP_LAT           = "hotel_lat";
    /**
     * Default hotel map coord longitude
     */
    public static final String DEF_CONFIG_MAP_LONG          = "hotel_long";
    /**
     * Default hotel name
     */
    public static final String DEF_CONFIG_NAME              = "hotel_name";
    /**
     * Default hotel street
     */
    public static final String DEF_CONFIG_HOTEL_STREET      = "hotel_street";
    /**
     * Default timezone id
     */
    public static final String DEF_CONFIG_TIMEZONE_ID       = "hotel_timezone_id";
    /**
     * Default weather id
     */
    public static final String DEF_CONFIG_WEATHER_ID        = "hotel_weather_id";
    /**
     * Default hotel website
     */
    public static final String DEF_CONFIG_WEBSITE           = "hotel_website";
    /**
     * Default reservation message
     */
    //Todo: original-> reservation_message
    public static final String DEF_CONFIG_RESERVATION_MSG   = "reservation_message";
    /**
     * Default welcome message
     */
    public static final String DEF_CONFIG_WELCOME_MSG       = "welcome_message";
    /**
     * Default service request message
     */
    //Todo: original-> service_request_message
    public static final String DEF_CONFIG_SVC_REQUEST_MSG   = "service_request_message";
    /**
     * Default checkout message
     */
    //Todo: original-> checkout_message
    public static final String DEF_CONFIG_CHECKOUT_MSG      = "checkout_message";
    /**
     * Default hotel logo
     */
    public static final String DEF_CONFIG_LOGO              = "hotel_logo";
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Action=============================================
    /**
     * Reset the hotel config to the default configuration
     * @param context required for accessing preferences
     */
    static final void reset(Context context)
    {

        MeshTVPreferenceManager.setHotelName(context,DEF_CONFIG_NAME );
        MeshTVPreferenceManager.setHotelStreet(context,DEF_CONFIG_HOTEL_STREET );
        MeshTVPreferenceManager.setHotelCity(context,DEF_CONFIG_CITY);
        MeshTVPreferenceManager.setHotelCountry(context,DEF_CONFIG_COUNTRY);
        MeshTVPreferenceManager.setHotelTimezone(context,DEF_CONFIG_TIMEZONE_ID);
        MeshTVPreferenceManager.setHotelEmail(context,DEF_CONFIG_EMAIL);
        MeshTVPreferenceManager.setHotelCurrency(context,DEF_CONFIG_CURRENCY);
        MeshTVPreferenceManager.setHotelWebsite(context,DEF_CONFIG_WEBSITE);
        MeshTVPreferenceManager.setHotelLogo(context,DEF_CONFIG_LOGO);
        MeshTVPreferenceManager.setHotelCoord(context,DEF_CONFIG_MAP_COORD);
        MeshTVPreferenceManager.setWelcomeMessage(context,DEF_CONFIG_WELCOME_MSG);
        MeshTVPreferenceManager.setReservationMessage(context,DEF_CONFIG_RESERVATION_MSG);
        MeshTVPreferenceManager.setCheckOutMessage(context,DEF_CONFIG_CHECKOUT_MSG);
        MeshTVPreferenceManager.setWeatherID(context,DEF_CONFIG_WEATHER_ID);
    }
    //==============================================================================================
    //===========================================City===============================================
    /**
     * Retrieve hotel city preference
     * @param context required to access preference
     * @return hotel city preference
     */
    static final String getConfigCity(Context context)
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
        String result = preferences.getString(CONFIG_CITY,DEF_CONFIG_CITY);
        return result;
    }
    /**
     * Sets the hotel city preference
     * @param context required to access preference
     * @param value new value for hotel city
     */
    static final void setConfigCity(Context context,String value)
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
        editor.putString(CONFIG_CITY,value);
        editor.commit();
    }
    //==============================================================================================
    //==========================================Country=============================================
    /**
     * Retrieve hotel country preference
     * @param context required to access preference
     * @return hotel country preference
     */
    static final String getConfigCountry(Context context)
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
        String result = preferences.getString(CONFIG_COUNTRY,DEF_CONFIG_COUNTRY);
        return result;
    }
    /**
     * Sets the hotel country preference
     * @param context required to access preference
     * @param value new value for hotel country
     */
    static final void setConfigCountry(Context context,String value)
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
        editor.putString(CONFIG_COUNTRY,value);
        editor.commit();
    }
    //==============================================================================================
    //=========================================Currency=============================================
    /**
     * Retrieve hotel currency preference
     * @param context required to access preference
     * @return hotel currency preference
     */
    static final String getConfigCurrency(Context context)
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
        String result = preferences.getString(CONFIG_CURRENCY,DEF_CONFIG_CURRENCY);
        return result;
    }
    /**
     * Sets the hotel currency preference
     * @param context required to access preference
     * @param value new value for hotel currency
     */
    static final void setConfigCurrency(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CONFIG_CURRENCY,value);
        editor.commit();
    }
    //==============================================================================================
    //==========================================Email===============================================
    /**
     * Retrieve hotel email preference
     * @param context required to access preference
     * @return hotel email preference
     */
    static final String getConfigEmail(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        String result = preferences.getString(CONFIG_EMAIL,DEF_CONFIG_EMAIL);
        return result;
    }
    /**
     * Sets the hotel email preference
     * @param context required to access preference
     * @param value new value for hotel email
     */
    static final void setConfigEmail(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CONFIG_EMAIL,value);
        editor.commit();
    }
    //==============================================================================================
    //========================================Map Coord=============================================
    /**
     * Retrieve hotel coordinate preference
     * @param context required to access preference
     * @return hotel coordinate preference
     */
    static final String getConfigMapCoord(Context context)
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
        String result = preferences.getString(CONFIG_MAP_COORD,DEF_CONFIG_MAP_COORD);
        return result;
    }
    /**
     * Sets the hotel coordinate preference
     * @param context required to access preference
     * @param value new value for hotel coordinate
     */
    static final void setConfigMapCoord(Context context,String value)
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
        editor.putString(CONFIG_MAP_COORD,value);
        editor.commit();

    }
    //==============================================================================================
    //========================================Map Lat===============================================
    /**
     * Retrieve hotel map coordinate latitude preference
     * @param context required to access preference
     * @return hotel map coordinate latitude preference
     */
    static final String getConfigMapLat(Context context)
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
        String result = preferences.getString(CONFIG_MAP_LAT,DEF_CONFIG_MAP_LAT);

        return result;
    }
    /**
     * Sets the hotel map coordinate latitude preference
     * @param context required to access preference
     * @param value new value for hotel map coordinate latitude
     */
    static final void setConfigMapLat(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CONFIG_MAP_LAT,value);
        editor.commit();

    }
    //==============================================================================================
    //========================================Map Long==============================================
    /**
     * Retrieve hotel config longitude preference
     * @param context required to access preference
     * @return hotel config longitude preference
     */
    static final String getConfigMapLong(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        String result = preferences.getString(CONFIG_MAP_LONG,DEF_CONFIG_MAP_LONG);

        return result;
    }
    /**
     * Sets the hotel config longitude preference
     * @param context required to access preference
     * @param value new value for hotel config longitude
     */
    static final void setConfigMapLong(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CONFIG_MAP_LONG,value);
        editor.commit();

    }
    //==============================================================================================
    //=========================================Name=================================================
    /**
     * Retrieve hotel name preference
     * @param context required to access preference
     * @return hotel name preference
     */
    static final String getConfigName(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        String result = preferences.getString(CONFIG_NAME,DEF_CONFIG_NAME);

        return result;
    }
    /**
     * Sets the hotel name preference
     * @param context required to access preference
     * @param value new value for hotel name
     */
    static final void setConfigName(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CONFIG_NAME,value);
        editor.commit();

    }
    //==============================================================================================
    //======================================Hotel Street============================================
    /**
     * Retrieve hotel street preference
     * @param context required to access preference
     * @return hotel street preference
     */
    static final String getConfigHotelStreet(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        String result = preferences.getString(CONFIG_HOTEL_STREET,DEF_CONFIG_HOTEL_STREET);

        return result;
    }
    /**
     * Sets the hotel street preference
     * @param context required to access preference
     * @param value new value for hotel street
     */
    static final void setConfigHotelStreet(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CONFIG_HOTEL_STREET,value);
        editor.commit();

    }
    //==============================================================================================
    //=======================================TimeZone ID============================================
    /**
     * Retrieve hotel timezone preference
     * @param context required to access preference
     * @return hotel timezone preference
     */
    static final String getConfigTimezoneId(Context context)
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
        String result = preferences.getString(CONFIG_TIMEZONE_ID,DEF_CONFIG_TIMEZONE_ID);

        return result;
    }
    /**
     * Sets the hotel timezone preference
     * @param context required to access preference
     * @param value new value for hotel timezone
     */
    static final void setConfigTimezoneId(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CONFIG_TIMEZONE_ID,value);
        editor.commit();

    }
    //==============================================================================================
    //=======================================Weather ID=============================================
    /**
     * Retrieve hotel weather id preference
     * @param context required to access preference
     * @return hotel weather id preference
     */
    static final String getConfigWeatherId(Context context)
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
        String result = preferences.getString(CONFIG_WEATHER_ID,DEF_CONFIG_WEATHER_ID);

        return result;
    }
    /**
     * Sets the hotel weather id preference
     * @param context required to access preference
     * @param value new value for hotel weather id
     */
    static final void setConfigWeatherId(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CONFIG_WEATHER_ID,value);
        editor.commit();
    }
    //==============================================================================================
    //=========================================Website==============================================
    /**
     * Retrieve hotel website preference
     * @param context required to access preference
     * @return hotel website preference
     */
    static final String getConfigWebsite(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        String result = preferences.getString(CONFIG_WEBSITE,DEF_CONFIG_WEBSITE);
        return result;
    }
    /**
     * Sets the hotel website preference
     * @param context required to access preference
     * @param value new value for hotel website
     */
    static final void setConfigWebsite(Context context,String value)
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
        editor.putString(CONFIG_WEBSITE,value);
        editor.commit();

    }
    //==============================================================================================
    //====================================Reservation Message=======================================
    /**
     * Retrieve hotel reservation message preference
     * @param context required to access preference
     * @return hotel reservation message preference
     */
    static final String getConfigReservationMsg(Context context)
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
        String result = preferences.getString(CONFIG_RESERVATION_MSG,DEF_CONFIG_RESERVATION_MSG);
        return result;
    }
    /**
     * Sets the hotel reservation message preference
     * @param context required to access preference
     * @param value new value for hotel reservation message
     */
    static final void setConfigReservationMsg(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CONFIG_RESERVATION_MSG,value);
        editor.commit();

    }
    //==============================================================================================
    //=======================================Welcome Message========================================
    /**
     * Retrieve hotel welcome message preference
     * @param context required to access preference
     * @return hotel welcome message preference
     */
    static final String getConfigWelcomeMsg(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        String result = preferences.getString(CONFIG_WELCOME_MSG,DEF_CONFIG_WELCOME_MSG);
        return result;
    }
    /**
     * Sets the hotel welecome message preference
     * @param context required to access preference
     * @param value new value for hotel welcome message
     */
    static final void setConfigWelcomeMsg(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CONFIG_WELCOME_MSG,value);
        editor.commit();
    }
    //==============================================================================================
    //=======================================Welcome Message========================================
    /**
     * Retrieve hotel city preference
     * @param context required to access preference
     * @return hotel city preference
     */
    static final String getConfigCheckoutMsg(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        String result = preferences.getString(CONFIG_CHECKOUT_MSG,DEF_CONFIG_CHECKOUT_MSG);
        return result;
    }
    /**
     * Sets the hotel city preference
     * @param context required to access preference
     * @param value new value for hotel city
     */
    static final void setConfigCheckoutMsg(Context context,String value)
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
        editor.putString(CONFIG_CHECKOUT_MSG,value);
        editor.commit();
    }
    //==============================================================================================
    //=======================================Welcome Message========================================
    /**
     * Retrieve hotel service request message preference
     * @param context required to access preference
     * @return hotel service request message preference
     */
    static final String getConfigSvcRequestMsg(Context context)
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
        String result = preferences.getString(CONFIG_SVC_REQUEST_MSG,DEF_CONFIG_SVC_REQUEST_MSG);
        return result;
    }
    /**
     * Sets the hotel service request message preference
     * @param context required to access preference
     * @param value new value for hotel service request message
     */
    static final void setConfigSvcRequestMsg(Context context,String value)
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
        editor.putString(CONFIG_SVC_REQUEST_MSG,value);
        editor.commit();
    }
    //==============================================================================================
    //=======================================Welcome Message========================================
    /**
     * Retrieve hotel logo preference
     * @param context required to access preference
     * @return hotel logo preference
     */
    static final String getConfigLogo(Context context)
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
        String result = preferences.getString(CONFIG_LOGO,DEF_CONFIG_LOGO);
        return result;
    }
    /**
     * Sets the hotel logo preference
     * @param context required to access preference
     * @param value new value for hotel logo
     */
    static final void setConfigLogo(Context context,String value)
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
        editor.putString(CONFIG_LOGO,value);
        editor.commit();
    }
    //==============================================================================================


}
