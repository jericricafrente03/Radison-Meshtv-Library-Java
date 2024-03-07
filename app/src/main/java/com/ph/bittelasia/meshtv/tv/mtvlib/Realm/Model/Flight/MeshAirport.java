package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight;


import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshAirport extends RealmObject implements MeshObjectInterface
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    @Ignore
    public static final String TABLE_NAME = MeshAirport.class.getSimpleName();
    @Ignore
    public static final String TAG_ACTIVE = "active";
    @Ignore
    public static final String TAG_CITY = "city";
    @Ignore
    public static final String TAG_CITYCODE = "citycode";
    @Ignore
    public static final String TAG_CLASSIFICATION = "classification";
    @Ignore
    public static final String TAG_COUNTRY_CODE = "countrycode";
    @Ignore
    public static final String TAG_COUNTRY_NAME = "countryname";
    @Ignore
    public static final String TAG_FS = "fs";
    @Ignore
    public static final String TAG_IATA = "iata";
    @Ignore
    public static final String TAG_ICAO = "icao";
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_LAT = "latitude";
    @Ignore
    public static final String TAG_LONG = "longitude";
    @Ignore
    public static final String TAG_NAME = "name";
    @Ignore
    public static final String TAG_REGION_NAME = "regionname";
    //-------------------------------------------------------------------------------------------------
    //--------------------------------------------Properties----------------------------------------
    @PrimaryKey
    private int id;
    private int active;
    private String city;
    private String citycode;
    private int classification;
    private String countrycode;
    private String countryname;
    private String fs;
    private String iata;
    private String icao;
    private double latitude;
    private double longitude;
    private String name;
    private String regionname;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Getter============================================
    public int getActive() {
        return active;
    }
    public String getCity() {
        return city;
    }
    public String getCitycode() {
        return citycode;
    }
    public int getClassification() {
        return classification;
    }
    public String getCountrycode() {
        return countrycode;
    }
    public String getCountryname() {
        return countryname;
    }
    public String getFs() {
        return fs;
    }
    public String getIata() {
        return iata;
    }
    public String getIcao() {
        return icao;
    }
    public int getId() {
        return id;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public String getName() {
        return name;
    }
    public String getRegionname() {
        return regionname;
    }
    //==============================================================================================
    //============================================Setter============================================
    public void setActive(int active) {
        this.active = active;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }
    public void setClassification(int classification) {
        this.classification = classification;
    }
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }
    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }
    public void setFs(String fs) {
        this.fs = fs;
    }
    public void setIata(String iata) {
        this.iata = iata;
    }
    public void setIcao(String icao) {
        this.icao = icao;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }
    //==============================================================================================
    //=====================================MeshObjectInterface======================================
    @Override
    public int getMeshID() {
        return id;
    }
    @Override
    public String getMeshLabel() {
        return name;
    }
    @Override
    public String getMeshDescription() {
        return city+", "+ countryname;
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
    //==============================================================================================
}
