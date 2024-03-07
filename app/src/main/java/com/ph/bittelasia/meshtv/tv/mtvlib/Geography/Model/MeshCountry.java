package com.ph.bittelasia.meshtv.tv.mtvlib.Geography.Model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MeshCountry
{
    //==========================================Variable============================================
    //------------------------------------------Constant--------------------------------------------
    public static final String TAG = MeshCountry.class.getSimpleName();
    public static final String TAG_CODE = "code";
    public static final String TAG_CITY = "city";
    public static final String TAG_COUNTRY = "country";
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Instance-------------------------------------------
    String code = null;
    String city = null;
    String country = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================Constructor==========================================
    public MeshCountry(String data)
    {
        try
        {
            JSONObject object = new JSONObject(data);
            this.code = object.getString(TAG_CODE);
            this.country = object.getString(TAG_COUNTRY);
            this.city = object.getString(TAG_CITY);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //==============================================================================================
    //===========================================Method=============================================
    //-------------------------------------------Parser---------------------------------------------\
    public static ArrayList<MeshCountry> parse(String data)
    {
        ArrayList<MeshCountry> countries = new ArrayList<>();
        try
        {
            JSONArray array = new JSONArray(data);
            for(int ctr=0;ctr<array.length();ctr++)
            {
                countries.add(new MeshCountry(array.getString(ctr)));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return countries;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Getter---------------------------------------------
    public String getCode() {
        return code;
    }
    public String getCity() {
        return city;
    }
    public String getCountry() {
        return country;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Setter---------------------------------------------
    public void setCode(String code) {
        this.code = code;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
