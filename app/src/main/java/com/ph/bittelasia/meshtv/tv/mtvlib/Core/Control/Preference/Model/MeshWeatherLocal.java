package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model;

import android.os.AsyncTask;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.UpdateTask.CompareWeatherTask;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Query.MeshValuePair;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2;

import java.util.ArrayList;

/**
 * Provides easy management of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelWeatherPreference HotelWeatherPreference}
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshWeatherLocal implements MeshRealmListener {
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = MeshWeatherLocal.class.getSimpleName();
    /**
     * Tag for retrieving {@link #lon lon} from a JSONObject
     */
    public static final String TAG_LON = "lon";
    /**
     * Tag for retrieving {@link #lat lat} from a JSONObject
     */
    public static final String TAG_LAT = "lat";
    /**
     * Tag for retrieving {@link #country country} from a JSONObject
     */
    public static final String TAG_COUNTRY = "country";
    /**
     * Tag for retrieving {@link #loc_name loc_name} from a JSONObject
     */
    public static final String TAG_LOCATION = "loc_name";
    /**
     * Tag for retrieving {@link #sunrise sunrise} from a JSONObject
     */
    public static final String TAG_SUNRISE = "sunrise";
    /**
     * Tag for retrieving {@link #sunset sunset} from a JSONObject
     */
    public static final String TAG_SUNSET = "sunset";
    /**
     * Tag for retrieving {@link #description description} from a JSONObject
     */
    public static final String TAG_DESC = "description";
    /**
     * Tag for retrieving {@link #icon icon} from a JSONObject
     */
    public static final String TAG_ICON = "icon";
    /**
     * Tag for retrieving {@link #temp_cur temp_cur} from a JSONObject
     */
    public static final String TAG_TEMP_CUR = "temp_cur";
    /**
     * Tag for retrieving {@link #temp_min temp_min} from a JSONObject
     */
    public static final String TAG_TEMP_MIN = "temp_min";
    /**
     * Tag for retrieving {@link #temp_max temp_max} from a JSONObject
     */
    public static final String TAG_TEMP_MAX = "temp_max";
    /**
     * Tag for retrieving {@link #humidity humidity} from a JSONObject
     */
    public static final String TAG_HUMIDITY = "humidity";
    /**
     * Tag for retrieving {@link #pressure pressure} from a JSONObject
     */
    public static final String TAG_PRESSURE = "pressure";
    /**
     * Tag for retrieving {@link #timezone timezone} from a JSONObject
     */
    public static final String TAG_TIMEZONE = "timezone";

    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    /**
     * Code of weather data's country of origin
     */
    String country_code = "";
    /**
     * Longitude coordinate of the weather data's origin
     */
    double lon;
    /**
     * Latitude coordinate of the weather data's origin
     */
    double lat;
    /**
     * Weather data's country of origin
     */
    String country;
    /**
     * Weather data's city of origin
     */
    String loc_name;
    /**
     * Weather data sunrise time
     */
    long sunrise;
    /**
     * Weather data sunset time
     */
    long sunset;
    /**
     * Weather data description
     */
    String description;
    /**
     * Weather data icon
     */
    String icon;
    /**
     * Weather data current temperature
     */
    float temp_cur;
    /**
     * Weather data minimum temperature
     */
    float temp_min;
    /**
     * Weather data maximum temparature
     */
    float temp_max;
    /**
     * Weather data humidity
     */
    float humidity;
    /**
     * Weather data pressure
     */
    float pressure;
    /**
     * Weather data timezone
     */
    float timezone;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Constructor====================================

    /**
     * Constructor that sets all data to the values of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelWeatherPreference HotelWeatherPreference}
     */
    public MeshWeatherLocal()
    {
        country_code = MeshTVPreferenceManager.getHotelWeatherSysCountry(null);
        lon = Double.valueOf(MeshTVPreferenceManager.getHotelWeatherCoordLon(null));
        lat = Double.valueOf(MeshTVPreferenceManager.getHotelWeatherCoordLon(null));
        country = MeshTVPreferenceManager.getHotelWeatherSysCountry(null);
        loc_name = MeshTVPreferenceManager.getHotelWeatherCity(null);
        sunrise = Long.valueOf(MeshTVPreferenceManager.getHotelWeatherSysSunrise(null));
        sunset = Long.valueOf(MeshTVPreferenceManager.getHotelWeatherSysSunset(null));
        description = MeshTVPreferenceManager.getHotelWeatherWeatherDesc(null);
        icon = MeshTVPreferenceManager.getHotelWeatherWeatherIcon(null);
        temp_cur = Float.valueOf(MeshTVPreferenceManager.getHotelWeatherMainTemp(null));
        temp_min = Float.valueOf(MeshTVPreferenceManager.getHotelWeatherMainTempMin(null));
        temp_max = Float.valueOf(MeshTVPreferenceManager.getHotelWeatherMainTempMax(null));
        humidity = Float.valueOf(MeshTVPreferenceManager.getHotelWeatherMainHumidity(null));
        pressure = Float.valueOf(MeshTVPreferenceManager.getHotelWeatherMainPressure(null));
        timezone = Float.valueOf(MeshTVPreferenceManager.getHotelWeatherTimezone(null));
    }

    /**
     * Copies the data from a {@link MeshWeatherV2 MeshWeatherV2}
     * @param v2 instance of {@link MeshWeatherV2 MeshWeatherV2} to copy
     */
    public MeshWeatherLocal(MeshWeatherV2 v2) {
        copy(v2);
    }

    /**
     * Constructor that searches realm for a {@link MeshWeatherV2 MeshWeatherV2} object whose {@link MeshWeatherV2#country MeshWeatherV2.country} matches
     * country
     * @param country country code to look for
     */
    public MeshWeatherLocal(String country) {
        MeshValuePair vp = new MeshValuePair(MeshWeatherV2.TAG_COUNTRY, country);
        vp.setString(true);
        MeshRealmManager.retrieve(MeshWeatherV2.class, this, vp);
    }

    //==============================================================================================
    //=================================================Method=======================================
    //-------------------------------------------------Action---------------------------------------
    /**
     * Triggers {@link MeshTVApp#updateWeather(MeshWeatherLocal) MeshTVApp.updateWeather(MeshWeatherLocal)} to notify all listeners
     */
    public final void display()
    {
        MeshTVApp.get().updateWeather(this);
    }

    /**
     * Asynchronously compares this instance to the data from {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelWeatherPreference HotelWeatherPreference}
     */
    public final void compare() {
        new CompareWeatherTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }

    /**
     * Copies the data from an instance of {@link MeshWeatherV2 MeshWeatherV2}
     * @param v2 data to copy
     */
    private void copy(MeshWeatherV2 v2)
    {
        country_code = v2.getCountry();
        lon = v2.getLon();
        lat = v2.getLat();
        country = v2.getCountry();
        loc_name = v2.getLoc_name();
        sunrise =v2.getSunrise() ;
        sunset =v2.getSunset() ;
        description = v2.getDescription();
        icon= v2.getIcon();
        temp_cur= v2.getTemp_cur();
        temp_min= v2.getTemp_min();
        temp_max= v2.getTemp_max();
        humidity= v2.getHumidity();
        pressure= v2.getPressure();
        timezone= v2.getTimezone();
    }

    /**
     * Saves the fields of this instance as the new value for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelWeatherPreference HotelWeatherPreference}
     */
    public final void update()
    {
        try
        {
            MeshTVPreferenceManager.setHotelWeatherSysCountry(null,country_code);
            MeshTVPreferenceManager.setHotelWeatherCoordLon(null,String.valueOf(lon));
            MeshTVPreferenceManager.setHotelWeatherCoordLat(null,String.valueOf(lat));
            MeshTVPreferenceManager.setHotelWeatherCity(null,loc_name);
            MeshTVPreferenceManager.setHotelWeatherSysSunrise(null,String.valueOf(sunrise));
            MeshTVPreferenceManager.setHotelWeatherSysSunset(null,String.valueOf(sunset));
            MeshTVPreferenceManager.setHotelWeatherWeatherDesc(null,description);
            MeshTVPreferenceManager.setHotelWeatherWeatherIcon(null,icon);
            MeshTVPreferenceManager.setHotelWeatherMainTemp(null,String.valueOf(temp_cur));
            MeshTVPreferenceManager.setHotelWeatherMainTempMax(null,String.valueOf(temp_max));
            MeshTVPreferenceManager.setHotelWeatherMainTempMin(null,String.valueOf(temp_min));
            MeshTVPreferenceManager.setHotelWeatherMainHumidity(null,String.valueOf(humidity));
            MeshTVPreferenceManager.setHotelWeatherMainPressure(null,String.valueOf(pressure));
            MeshTVPreferenceManager.setHotelTimezone(null,String.valueOf(timezone));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------Getter---------------------------------------
    /**
     * Returns {@link #country_code country_code}
     * @return {@link #country_code country_code}
     */
    public String getCountry_code() {
        return country_code;
    }
    /**
     * Returns {@link #lon lon}
     * @return {@link #lon lon}
     */
    public double getLon() {
        return lon;
    }
    /**
     * Returns {@link #lat lat}
     * @return {@link #lat lat}
     */
    public double getLat() {
        return lat;
    }
    /**
     * Returns {@link #country country}
     * @return {@link #country country}
     */
    public String getCountry() {
        return country;
    }
    /**
     * Returns {@link #loc_name loc_name}
     * @return {@link #loc_name loc_name}
     */
    public String getLoc_name() {
        return loc_name;
    }
    /**
     * Returns {@link #sunrise sunrise}
     * @return {@link #sunrise sunrise}
     */
    public long getSunrise() {
        return sunrise;
    }
    /**
     * Returns {@link #sunset sunset}
     * @return {@link #sunset sunset}
     */
    public long getSunset() {
        return sunset;
    }
    /**
     * Returns {@link #description description}
     * @return {@link #description description}
     */
    public String getDescription() {
        return description;
    }
    /**
     * Returns {@link #icon icon}
     * @return {@link #icon icon}
     */
    public String getIcon() {
        return icon;
    }
    /**
     * Returns {@link #temp_cur temp_cur}
     * @return {@link #temp_cur temp_cur}
     */
    public float getTemp_cur() {
        return temp_cur;
    }
    /**
     * Returns {@link #temp_min temp_min}
     * @return {@link #temp_min temp_min}
     */
    public float getTemp_min() {
        return temp_min;
    }
    /**
     * Returns {@link #temp_max temp_max}
     * @return {@link #temp_max temp_max}
     */
    public float getTemp_max() {
        return temp_max;
    }
    /**
     * Returns {@link #humidity humidity}
     * @return {@link #humidity humidity}
     */
    public float getHumidity() {
        return humidity;
    }
    /**
     * Returns {@link #pressure pressure}
     * @return {@link #pressure pressure}
     */
    public float getPressure() {
        return pressure;
    }
    /**
     * Returns {@link #timezone timezone}
     * @return {@link #timezone timezone}
     */
    public float getTimezone() {
        return timezone;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------Setter---------------------------------------
    /**
     * Sets new value for {@link #country_code country_code}
     * @param country_code new value for {@link #country_code country_code}
     */
    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }
    /**
     * Sets new value for {@link #lon lon}
     * @param lon new value for {@link #lon lon}
     */
    public void setLon(double lon) {
        this.lon = lon;
    }
    /**
     * Sets new value for {@link #lat lat}
     * @param lat new value for {@link #lat lat}
     */
    public void setLat(double lat) {
        this.lat = lat;
    }
    /**
     * Sets new value for {@link #country country}
     * @param country new value for {@link #country country}
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * Sets new value for {@link #loc_name loc_name}
     * @param loc_name new value for {@link #loc_name loc_name}
     */
    public void setLoc_name(String loc_name) {
        this.loc_name = loc_name;
    }
    /**
     * Sets new value for {@link #sunrise sunrise}
     * @param sunrise new value for {@link #sunrise sunrise}
     */
    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }
    /**
     * Sets new value for {@link #sunset sunset}
     * @param sunset new value for {@link #sunset sunset}
     */
    public void setSunset(long sunset) {
        this.sunset = sunset;
    }
    /**
     * Sets new value for {@link #description description}
     * @param description new value for {@link #description description}
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Sets new value for {@link #icon icon}
     * @param icon new value for {@link #icon icon}
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
    /**
     * Sets new value for {@link #temp_cur temp_cur}
     * @param temp_cur new value for {@link #temp_cur temp_cur}
     */
    public void setTemp_cur(float temp_cur) {
        this.temp_cur = temp_cur;
    }
    /**
     * Sets new value for {@link #temp_min temp_min}
     * @param temp_min new value for {@link #temp_min temp_min}
     */
    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }
    /**
     * Sets new value for {@link #temp_max temp_max}
     * @param temp_max new value for {@link #temp_max temp_max}
     */
    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }
    /**
     * Sets new value for {@link #humidity humidity}
     * @param humidity new value for {@link #humidity humidity}
     */
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
    /**
     * Sets new value for {@link #pressure pressure}
     * @param pressure new value for {@link #pressure pressure}
     */
    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
    /**
     * Sets new value for {@link #timezone timezone}
     * @param timezone new value for {@link #timezone timezone}
     */
    public void setTimezone(float timezone) {
        this.timezone = timezone;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================MeshRealmListener================================

    /**
     * Triggered when a {@link MeshWeatherV2 MeshWeatherV2} instance was found
     * @param c Class of the object found
     * @param results ArrayList of the Objects found
     */
    @Override
    public void onRetrieved(Class c, ArrayList<Object> results) {
        if(results.size()>0)
        {
            copy((MeshWeatherV2) results.get(0));
            compare();
        }
    }

    /**
     * When no {@link MeshWeatherV2 MeshWeatherV2} matches the request
     * @param c Class of the object found
     * @param message reason why the request failed
     */
    @Override
    public void onFailed(Class c, String message) {

    }

    /**
     * When the database does not contain any {@link MeshWeatherV2 MeshWeatherV2} data
     * @param c Class of the object found
     * @param message reason why data was empty
     */
    @Override
    public void onEmpty(Class c, String message) {

    }

    @Override
    public void onCleared(Class c) {

    }
    //==============================================================================================
}
