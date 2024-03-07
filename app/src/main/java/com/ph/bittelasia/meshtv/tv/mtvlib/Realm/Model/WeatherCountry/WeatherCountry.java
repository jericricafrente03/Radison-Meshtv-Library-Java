package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherCountry;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mars on 9/28/17.
 */

public class WeatherCountry
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = WeatherCountry.class.getSimpleName();
    public static final String TAG_COUNTRY  = "country";
    public static final String TAG_CITY     = "city";
    public static final String TAG_CODE     = "code";
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    String country;
    String city;
    String code;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================Constructor==========================================
    public WeatherCountry(String data)
    {
        try
        {
            JSONObject object = new JSONObject(data);
            code = object.getString(TAG_CODE);
            city = object.getString(TAG_CITY);
            country = object.getString(TAG_COUNTRY);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //==============================================================================================
    //============================================Method============================================
    //--------------------------------------------Getter--------------------------------------------
    public String getCountry() {
        return country;
    }
    public String getCity() {
        return city;
    }
    public String getCode() {
        return code;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Setter--------------------------------------------
    public void setCountry(String country) {
        this.country = country;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setCode(String code) {
        this.code = code;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Filter---------------------------------------------
    public boolean isIncluded(String s)
    {
        s=s.toUpperCase();

        if(s.equals(code.toUpperCase()))
        {
            return true;
        }
        if(country.toUpperCase().startsWith(s))
        {
            return true;
        }
        if(city.toUpperCase().startsWith(s))
        {
            return true;
        }
        return false;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------Parse---------------------------------------------------
    public static ArrayList<WeatherCountry> getCountries(Context context, int resource)
    {
        ArrayList<WeatherCountry> countries = new ArrayList<>();
        try
        {
            InputStream is = context.getResources().openRawResource(resource);


            Scanner s = new Scanner(is);
            String result ="";
            do
            {
                result = result+s.next();
            }while (s.hasNext());


            JSONArray array = new JSONArray(result);
            for(int ctr = 0; ctr < array.length();ctr++)
            {
                try
                {
                    WeatherCountry c1 = new WeatherCountry(array.getString(ctr));
                    countries.add(c1);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return countries;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

}
