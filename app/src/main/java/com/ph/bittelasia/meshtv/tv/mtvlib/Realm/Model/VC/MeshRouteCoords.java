package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MeshRouteCoords {
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG_LAT = "lat";
    public static final String TAG_LON = "lon";
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Properties----------------------------------------
    private double lat;
    private double lon;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Constructor=======================================
    public MeshRouteCoords()
    {

    }
    public MeshRouteCoords(double lat, double lon) {
        super();
        this.lat = lat;
        this.lon = lon;
    }
    public MeshRouteCoords(JSONObject object) {
        try {
            this.lat = object.getDouble(TAG_LAT);
            this.lon = object.getDouble(TAG_LON);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MeshRouteCoords(String data) {
        try {
            JSONObject object = new JSONObject(data);
            this.lat = object.getDouble(TAG_LAT);
            this.lon = object.getDouble(TAG_LON);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //==============================================================================================
    //============================================Converter=========================================

    public JSONObject getJSON() {
        JSONObject object = new JSONObject();
        try {
            object.put(TAG_LAT, String.valueOf(lat));
            object.put(TAG_LON, String.valueOf(lon));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    //==============================================================================================
    //============================================Getter============================================

    public double getLat() {
        return lat;
    }
    public double getLon() {
        return lon;
    }

    //==============================================================================================
    //============================================Setter============================================

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    //==============================================================================================

    //============================================Parser============================================
    public static ArrayList<MeshRouteCoords> parse(String data)
    {
        ArrayList<MeshRouteCoords> routes = new ArrayList<MeshRouteCoords>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString(MeshVC.TAG_ROUTE));
            for(int ctr = 0;ctr<array.length();ctr++)
            {
                routes.add(new MeshRouteCoords(array.getString(ctr)));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return routes;
    }
    //==============================================================================================
}
