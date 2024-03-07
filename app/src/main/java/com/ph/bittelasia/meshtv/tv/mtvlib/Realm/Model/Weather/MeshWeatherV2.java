package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather;


import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshWeatherV2 extends RealmObject implements MeshObjectInterface
{
    //================================================Variable======================================
    //------------------------------------------------Constant--------------------------------------
    @Ignore
    public static final String TAG          = MeshWeatherV2.class.getSimpleName();
    @Ignore
    public static final String TAG_ID       = "id";
    @Ignore
    public static final String TAG_LOC_ID   = "loc_id";
    @Ignore
    public static final String TAG_LON      = "lon";
    @Ignore
    public static final String TAG_LAT      = "lat";
    @Ignore
    public static final String TAG_COUNTRY  = "country";
    @Ignore
    public static final String TAG_LOCATION = "loc_name";
    @Ignore
    public static final String TAG_SUNRISE  = "sunrise";
    @Ignore
    public static final String TAG_SUNSET   = "sunset";
    @Ignore
    public static final String TAG_DESC     = "description";
    @Ignore
    public static final String TAG_ICON     = "icon";
    @Ignore
    public static final String TAG_TEMP_CUR = "temp_cur";
    @Ignore
    public static final String TAG_TEMP_MIN = "temp_min";
    @Ignore
    public static final String TAG_TEMP_MAX = "temp_max";
    @Ignore
    public static final String TAG_HUMIDITY = "humidity";
    @Ignore
    public static final String TAG_PRESSURE = "pressure";
    @Ignore
    public static final String TAG_TIMEZONE = "timezone";
    @Ignore
    public static final String TAG_WIND_SPEED = "wind_speed";
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Instance--------------------------------------
    int id;
    int loc_id;
    double lon;
    double lat;
    @PrimaryKey
    String country;
    String loc_name;
    long sunrise;
    long sunset;
    String description;
    String icon;
    float temp_cur;
    float temp_min;
    float temp_max;
    float humidity;
    float pressure;
    float timezone;
    float wind_speed;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Constructor====================================
    //==============================================================================================
    //==================================================Method======================================
    //--------------------------------------------------Getter--------------------------------------
    public int getId() {
        return id;
    }
    public int getLoc_id() {
        return loc_id;
    }
    public double getLon() {
        return lon;
    }
    public double getLat() {
        return lat;
    }
    public String getCountry() {
        return country;
    }
    public String getLoc_name() {
        return loc_name;
    }
    public long getSunrise() {
        return sunrise;
    }
    public long getSunset() {
        return sunset;
    }
    public String getDescription() {
        return description;
    }
    public String getIcon() {
        return icon;
    }
    public float getTemp_cur() {
        return temp_cur;
    }
    public float getTemp_min() {
        return temp_min;
    }
    public float getTemp_max() {
        return temp_max;
    }
    public float getHumidity() {
        return humidity;
    }
    public float getPressure() {
        return pressure;
    }
    public float getTimezone() {
        return timezone;
    }
    public float getWind_speed() {
        return wind_speed;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------------Setter--------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setLoc_id(int loc_id) {
        this.loc_id = loc_id;
    }
    public void setLon(double lon) {
        this.lon = lon;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setLoc_name(String loc_name) {
        this.loc_name = loc_name;
    }
    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }
    public void setSunset(long sunset) {
        this.sunset = sunset;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public void setTemp_cur(float temp_cur) {
        this.temp_cur = temp_cur;
    }
    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }
    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
    public void setTimezone(float timezone) {
        this.timezone = timezone;
    }
    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================MeshObjectInterface================================
    @Override
    public int getMeshID() {
        return getId();
    }
    @Override
    public String getMeshLabel() {
        return getCountry();
    }
    @Override
    public String getMeshDescription() {
        return getDescription();
    }
    @Override
    public int getMeshQuantity() {
        return 0;
    }
    @Override
    public double getMeshPrice() {
        return 0;
    }
    @Override
    public String getMeshIMG() {
        return getIcon();
    }
    //==============================================================================================
}
