package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshWeatherForecast extends RealmObject implements MeshObjectInterface
{

    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    @Ignore
    public static final String TABLE_NAME = MeshWeatherForecast.class.getSimpleName();
    @Ignore
    public static final String TAG_COUNTRY = "country";
    @Ignore
    public static final String TAG_CITY = "city";
    @Ignore
    public static final String TAG_FORECAST = "forecast";
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Properties---------------------------------------
    @PrimaryKey
    private String country;
    private String city;
    private String forecast;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Getter------------------------------------------

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getForecast() {
        return forecast;
    }

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Setter------------------------------------------

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================MeshObject=========================================
    @Override
    public int getMeshID() {
        return 0;
    }

    @Override
    public String getMeshLabel() {
        return null;
    }

    @Override
    public String getMeshDescription() {
        return null;
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
        return null;
    }
    //===============================================================================================
}
