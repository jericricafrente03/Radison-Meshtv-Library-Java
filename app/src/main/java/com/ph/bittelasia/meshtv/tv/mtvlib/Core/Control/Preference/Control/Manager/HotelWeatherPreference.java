package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;


/**
 * Manages the weather preference of the STB (Hotel Configuration)
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
class HotelWeatherPreference
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    static final String TAG                           = HotelWeatherPreference.class.getSimpleName();
    /**
     * Tag for weather longitude
     */
    public static final String WEATHER_COORD_LON            = "lon";
    /**
     * Tag for weather latitude
     */
    public static final String WEATHER_COORD_LAT            = "lat";
    /**
     * Tag for weather country
     */
    public static final String WEATHER_SYS_COUNTRY          = "country";
    /**
     * Tag for weather sunrise time
     */
    public static final String WEATHER_SYS_SUNRISE          = "sunrise";
    /**
     * Tag for weather sunset time
     */
    public static final String WEATHER_SYS_SUNSET           = "sunset";
    /**
     * Tag for weather description
     */
    public static final String WEATHER_WEATHER_DESC         = "description";
    /**
     * Tag for weather icon
     */
    public static final String WEATHER_WEATHER_ICON         = "weather";
    /**
     * Tag for weather name
     */
    public static final String WEATHER_NAME                 = "name";
    /**
     * Tag for weather timezone
     */
    public static final String WEATHER_TIMEZONE             = "timezone";
    /**
     * Tag for weather main temperature
     */
    public static final String WEATHER_MAIN_TEMP            = "temp";
    /**
     * Tag for weather pressure
     */
    public static final String WEATHER_MAIN_PRESSURE        = "pressure";
    /**
     * Tag for weather humidity
     */
    public static final String WEATHER_MAIN_HUMIDITY        = "humidity";
    /**
     * Tag for weather minimum temperature
     */
    public static final String WEATHER_MAIN_TEMP_MIN        = "temp_min";
    /**
     * Tag for weather maximum temperature
     */
    public static final String WEATHER_MAIN_TEMP_MAX        = "temp_max";
    /**
     * Default coordinate longitude
     */
    static final String DEFAULT_WEATHER_COORD_LON       = "121.49";
    /**
     * Default coordinate latitude
     */
    static final String DEFAULT_WEATHER_COORD_LAT       = "38.58";
    /**
     * Default Country
     */
    static final String DEFAULT_WEATHER_SYS_COUNTRY     = "MY";
    /**
     * Default sunrise time
     */
    static final String DEFAULT_WEATHER_SYS_SUNRISE     = "1422026271";
    /**
     * Default sunset time
     */
    static final String DEFAULT_WEATHER_SYS_SUNSET      = "1522062283";
    /**
     * Default weather description
     */
    static final String DEFAULT_WEATHER_WEATHER_DESC    = "Sunny";
    /**
     * Default icon
     */
    static final String DEFAULT_WEATHER_WEATHER_ICON    = "/images/weather/50n.png";
    /**
     * Default City name
     */
    static final String DEFAULT_WEATHER_NAME            = "Malaysia";
    /**
     * Default Timezone
     */
    static final String DEFAULT_WEATHER_TIMEZONE        = "+8";
    /**
     * Default main temperature
     */
    static final String DEFAULT_WEATHER_MAIN_TEMP       = "27.29";
    /**
     * Default pressure
     */
    static final String DEFAULT_WEATHER_MAIN_PRESSURE   = "1028";
    /**
     * Default humidity
     */
    static final String DEFAULT_WEATHER_MAIN_HUMIDITY   = "81";
    /**
     * Default minimum temperature
     */
    static final String DEFAULT_WEATHER_MAIN_TEMP_MIN   = "14.245";
    /**
     * Default maximum temperature
     */
    static final String DEFAULT_WEATHER_MAIN_TEMP_MAX   = "15.245";

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Action============================================
    /**
     * Reset the weather config to the default configuration
     * @param context required for accessing preferences
     */
    static final void reset(Context context)
    {
        MeshTVPreferenceManager.setHotelWeatherCoordLat(context,DEFAULT_WEATHER_COORD_LON);
        MeshTVPreferenceManager.setHotelWeatherCoordLon(context,DEFAULT_WEATHER_COORD_LAT);
        MeshTVPreferenceManager.setHotelWeatherSysCountry(context,DEFAULT_WEATHER_SYS_COUNTRY);
        MeshTVPreferenceManager.setHotelWeatherSysSunrise(context,DEFAULT_WEATHER_SYS_SUNRISE);
        MeshTVPreferenceManager.setHotelWeatherSysSunset(context,DEFAULT_WEATHER_SYS_SUNSET);

        MeshTVPreferenceManager.setHotelWeatherWeatherDesc(context,DEFAULT_WEATHER_WEATHER_DESC);
        MeshTVPreferenceManager.setHotelWeatherWeatherIcon(context,DEFAULT_WEATHER_WEATHER_ICON);

        MeshTVPreferenceManager.setHotelWeatherCity(context,DEFAULT_WEATHER_NAME);

        MeshTVPreferenceManager.setHotelWeatherTimezone(context,DEFAULT_WEATHER_TIMEZONE);

        MeshTVPreferenceManager.setHotelWeatherMainTemp(context,DEFAULT_WEATHER_MAIN_TEMP);
        MeshTVPreferenceManager.setHotelWeatherMainPressure(context,DEFAULT_WEATHER_MAIN_PRESSURE);
        MeshTVPreferenceManager.setHotelWeatherMainHumidity(context,DEFAULT_WEATHER_MAIN_HUMIDITY);
        MeshTVPreferenceManager.setHotelWeatherMainTempMin(context,DEFAULT_WEATHER_MAIN_TEMP_MIN);
        MeshTVPreferenceManager.setHotelWeatherMainTempMax(context,DEFAULT_WEATHER_MAIN_TEMP_MAX);
    }
    //==============================================================================================
    //==========================================Longitude===========================================
    /**
     * Retrieve longitude preference
     * @param context required to access preference
     * @return longitude preference
     */
    static final String getHotelWeatherCoordLon(Context context)
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
        String result = preferences.getString(WEATHER_COORD_LON,DEFAULT_WEATHER_COORD_LON);
        return result;
    }
    /**
     * Sets the longitude preference
     * @param context required to access preference
     * @param value new value for longitude
     */
    static final void setHotelWeatherCoordLon(Context context,String value)
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
        editor.putString(WEATHER_COORD_LON,value);
        editor.commit();
    }
    //==============================================================================================
    //==========================================Latitude============================================
    /**
     * Retrieve latitude preference
     * @param context required to access preference
     * @return latitude preference
     */
    static final String getHotelWeatherCoordLat(Context context)
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
        String result = preferences.getString(WEATHER_COORD_LAT,DEFAULT_WEATHER_COORD_LAT);
        return result;
    }
    /**
     * Sets the latitude preference
     * @param context required to access preference
     * @param value new value for latitude
     */
    static final void setHotelWeatherCoordLat(Context context,String value)
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
        editor.putString(WEATHER_COORD_LAT,value);
        editor.commit();
    }
    //==============================================================================================
    //==========================================Country=============================================
    /**
     * Retrieve weather country preference
     * @param context required to access preference
     * @return weather country preference
     */
    static final String getHotelWeatherSysCountry(Context context)
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
        String result = preferences.getString(WEATHER_SYS_COUNTRY,DEFAULT_WEATHER_SYS_COUNTRY);
        return result;
    }
    /**
     * Sets the weather country preference
     * @param context required to access preference
     * @param value new value for weather country
     */
    static final void setHotelWeatherSysCountry(Context context,String value)
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
        editor.putString(WEATHER_SYS_COUNTRY,value);
        editor.commit();
    }
    //==============================================================================================
    //==========================================Sunrise=============================================
    /**
     * Retrieve sunrise time preference
     * @param context required to access preference
     * @return sunrise time preference
     */
    static final String getHotelWeatherSysSunrise(Context context)
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
        String result = preferences.getString(WEATHER_SYS_SUNRISE,DEFAULT_WEATHER_SYS_SUNRISE);
        return result;
    }
    /**
     * Sets the sunrise time preference
     * @param context required to access preference
     * @param value new value for sunrise time
     */
    static final void setHotelWeatherSysSunrise(Context context,String value)
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
        editor.putString(WEATHER_SYS_SUNRISE,value);
        editor.commit();
    }
    //==============================================================================================
    //==========================================Sunrise=============================================
    /**
     * Retrieve sunset time preference
     * @param context required to access preference
     * @return sunset time preference
     */
    static final String getHotelWeatherSysSunset(Context context)
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
        String result = preferences.getString(WEATHER_SYS_SUNSET,DEFAULT_WEATHER_SYS_SUNSET);
        return result;
    }
    /**
     * Sets the sunset time preference
     * @param context required to access preference
     * @param value new value for sunset time
     */
    static final void setHotelWeatherSysSunset(Context context,String value)
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
        editor.putString(WEATHER_SYS_SUNSET,value);
        editor.commit();
    }
    //==============================================================================================
    //==========================================Sunset==============================================
    /**
     * Retrieve weather description preference
     * @param context required to access preference
     * @return  weather description preference
     */
    static final String getHotelWeatherWeatherDesc(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        String result = preferences.getString(WEATHER_WEATHER_DESC,DEFAULT_WEATHER_WEATHER_DESC);
        return result;
    }
    /**
     * Sets the  weather description preference
     * @param context required to access preference
     * @param value new value for  weather description
     */
    static final void setHotelWeatherWeatherDesc(Context context,String value)
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
        editor.putString(WEATHER_WEATHER_DESC,value);
        editor.commit();
    }
    //==============================================================================================
    //============================================Icon==============================================
    /**
     * Retrieve weather icon preference
     * @param context required to access preference
     * @return weather icon preference
     */
    static final String getHotelWeatherWeatherIcon(Context context)
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
        String result = preferences.getString(WEATHER_WEATHER_ICON,DEFAULT_WEATHER_WEATHER_ICON);
        return result;
    }
    /**
     * Sets the  weather icon preference
     * @param context required to access preference
     * @param value new value for  weather icon
     */
    static final void setHotelWeatherWeatherIcon(Context context,String value)
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
        editor.putString(WEATHER_WEATHER_ICON,value);
        editor.commit();
    }
    //==============================================================================================
    //============================================Name==============================================
    /**
     * Retrieve city preference
     * @param context required to access preference
     * @return city preference
     */
    static final String getHotelWeatherCity(Context context)
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
        String result = preferences.getString(WEATHER_NAME,DEFAULT_WEATHER_NAME);
        return result;
    }
    /**
     * Sets the city preference
     * @param context required to access preference
     * @param value new value for city
     */
    static final void setHotelWeatherCity(Context context,String value)
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
        editor.putString(WEATHER_NAME,value);
        editor.commit();
    }
    //==============================================================================================
    //==========================================Timezone============================================
    /**
     * Retrieve timezone preference
     * @param context required to access preference
     * @return timezone preference
     */
    static final String getHotelWeatherTimezone(Context context)
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
        String result = preferences.getString(WEATHER_TIMEZONE,DEFAULT_WEATHER_TIMEZONE);
        return result;
    }
    /**
     * Sets the timezone preference
     * @param context required to access preference
     * @param value new value for timezone
     */
    static final void setHotelWeatherTimezone(Context context,String value)
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
        editor.putString(WEATHER_TIMEZONE,value);
        editor.commit();
    }
    //==============================================================================================
    //==========================================Timezone============================================
    /**
     * Retrieve weather main temp preference
     * @param context required to access preference
     * @return weather main temp preference
     */
    static final String getHotelWeatherMainTemp(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        String result = preferences.getString(WEATHER_MAIN_TEMP,DEFAULT_WEATHER_MAIN_TEMP);
        return result;
    }
    /**
     * Sets the weather main temp preference
     * @param context required to access preference
     * @param value new value for weather main temp
     */
    static final void setHotelWeatherMainTemp(Context context,String value)
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
        editor.putString(WEATHER_MAIN_TEMP,value);
        editor.commit();
    }
    //==============================================================================================
    //==========================================Pressure============================================
    /**
     * Retrieve pressure preference
     * @param context required to access preference
     * @return pressure preference
     */
    static final String getHotelWeatherMainPressure(Context context)
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
        String result = preferences.getString(WEATHER_MAIN_PRESSURE,DEFAULT_WEATHER_MAIN_PRESSURE);
        return result;
    }
    /**
     * Sets the pressure preference
     * @param context required to access preference
     * @param value new value for pressure
     */
    static final void setHotelWeatherMainPressure(Context context,String value)
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
        editor.putString(WEATHER_MAIN_PRESSURE,value);
        editor.commit();
    }
    //==============================================================================================
    //==========================================Humidity============================================
    /**
     * Retrieve humidity preference
     * @param context required to access preference
     * @return humidity preference
     */
    static final String getHotelWeatherMainHumidity(Context context)
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
        String result = preferences.getString(WEATHER_MAIN_HUMIDITY,DEFAULT_WEATHER_MAIN_HUMIDITY);
        return result;
    }
    /**
     * Sets the humidity preference
     * @param context required to access preference
     * @param value new value for humidity
     */
    static final void setHotelWeatherMainHumidity(Context context,String value)
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
        editor.putString(WEATHER_MAIN_HUMIDITY,value);
        editor.commit();
    }
    //==============================================================================================
    //==========================================Temp Min============================================
    /**
     * Retrieve minimum temp preference
     * @param context required to access preference
     * @return minimum temp preference
     */
    static final String getHotelWeatherMainTempMin(Context context)
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
        String result = preferences.getString(WEATHER_MAIN_TEMP_MIN,DEFAULT_WEATHER_MAIN_TEMP_MIN);
        return result;
    }
    /**
     * Sets the minimum temp preference
     * @param context required to access preference
     * @param value new value for minimum temp
     */
    static final void setHotelWeatherMainTempMin(Context context,String value)
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
        editor.putString(WEATHER_MAIN_TEMP_MIN,value);
        editor.commit();
    }
    //==============================================================================================
    //==========================================Temp Max============================================
    /**
     * Retrieve maximum temperature preference
     * @param context required to access preference
     * @return maximum temperature preference
     */
    static final String getHotelWeatherMainTempMax(Context context)
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
        String result = preferences.getString(WEATHER_MAIN_TEMP_MAX,DEFAULT_WEATHER_MAIN_TEMP_MAX);
        return result;
    }
    /**
     * Sets the maximum temperature preference
     * @param context required to access preference
     * @param value new value for maximum temperature
     */
    static final void setHotelWeatherMainTempMax(Context context,String value)
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
        editor.putString(WEATHER_MAIN_TEMP_MAX,value);
        editor.commit();
    }
    //==============================================================================================
}
