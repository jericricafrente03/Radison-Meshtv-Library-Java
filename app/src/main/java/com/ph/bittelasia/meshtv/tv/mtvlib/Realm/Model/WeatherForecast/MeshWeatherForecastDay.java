package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MeshWeatherForecastDay {
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = MeshWeatherForecastDay.class.getSimpleName();
    public static final String DATE_FORMAT = "MM-dd-yyyy";
    public static final String TAG_DATE = "date";
    public static final String TAG_DAY = "day";
    public static final String TAG_DAY_OF_WEEK = "day_of_week";
    public static final String TAG_DESCRIPTION = "description";
    public static final String TAG_HUMIDTY = "humidity";
    public static final String TAG_TEMP_MIN = "temp_min";
    public static final String TAG_TEMP = "temp";
    public static final String TAG_TEMP_MAX = "temp_max";
    public static final String TAG_WIND_SPEED = "wind_speed";
    public static final String TAG_ICON = "icon";
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Instance---------------------------------------
    private Date date;
    private int day;
    private String day_of_week;
    private String description;
    private float humidity;
    private float temp_min;
    private float temp;
    private float temp_max;
    private float wind_speed;
    private String icon;

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Constructor======================================
    public MeshWeatherForecastDay(String data) {
        try
        {
            JSONObject object = new JSONObject(data);
            day = object.getInt(TAG_DAY);
            day_of_week = object.getString(TAG_DAY_OF_WEEK);
            description = object.getString(TAG_DESCRIPTION);
            humidity = Float.valueOf(object.getString(TAG_HUMIDTY));
            temp_min = Float.valueOf(object.getString(TAG_TEMP_MIN));
            temp_max = Float.valueOf(object.getString(TAG_TEMP_MAX));
            temp = Float.valueOf(object.getString(TAG_TEMP));
            wind_speed = Float.valueOf(object.getString(TAG_WIND_SPEED));
            icon = object.getString(TAG_ICON);
            date = new SimpleDateFormat(DATE_FORMAT).parse(object.getString(TAG_DATE));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //==============================================================================================
    //===============================================Method=========================================
    //------------------------------------------------Parse-----------------------------------------
    public static ArrayList<MeshWeatherForecastDay> parse(String data)
    {
        ArrayList<MeshWeatherForecastDay> days = new ArrayList<>();

        try {
            JSONArray array = new JSONArray(data);
            for (int ctr = 0; ctr < array.length(); ctr++)
            {
               MeshWeatherForecastDay day = new MeshWeatherForecastDay(array.getString(ctr));
                days.add(day);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return days;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Getter-----------------------------------------

    public Date getDate() {
        return date;
    }

    public int getDay() {
        return day;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public String getDescription() {
        return description;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public float getTemp() {
        return temp;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public float getWind_speed() {
        return wind_speed;
    }

    public String getIcon() {
        return icon;
    }

    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Setter-----------------------------------------

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setDay_of_week(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
