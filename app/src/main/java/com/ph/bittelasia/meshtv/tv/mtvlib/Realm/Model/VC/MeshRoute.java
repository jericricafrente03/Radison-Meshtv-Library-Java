package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC;

import org.json.JSONObject;

/**
 * Created by mars on 6/5/17.
 */

public class MeshRoute
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG_ID           = "id";
    public static final String TAG_TRIPLENGTH   = "distance";
    public static final String TAG_ROUTES_LON       = "turn_coords_lon";
    public static final String TAG_ROUTES_LAT       = "turn_coords_lat";
    public static final String TAG_DIRECTIONS   = "narrative";
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    private int id;
    private String tripLength;
    private double turn_coords_lon;
    private double turn_coords_lat;
    private String directions;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Constructor=======================================
    public MeshRoute(JSONObject object) {
        try
        {
            if(object.has(TAG_ID))
            {
                id = object.getInt(TAG_ID);
            }

            tripLength = object.getString(TAG_TRIPLENGTH);
            turn_coords_lon = object.getDouble(TAG_ROUTES_LON);
            turn_coords_lat = object.getDouble(TAG_ROUTES_LAT);
            directions = object.getString(TAG_DIRECTIONS);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public MeshRoute(String data) {
        try {
            JSONObject object = new JSONObject(data);
            if(object.has(TAG_ID))
            {
                id = object.getInt(TAG_ID);
            }

            tripLength = object.getString(TAG_TRIPLENGTH);
            turn_coords_lon = object.getDouble(TAG_ROUTES_LON);
            turn_coords_lat = object.getDouble(TAG_ROUTES_LAT);
            directions = object.getString(TAG_DIRECTIONS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //==============================================================================================
    //============================================Converter=========================================
    public JSONObject getJSON() {
        JSONObject object = new JSONObject();
        try
        {
            object.put(TAG_ID,id);
            object.put(TAG_TRIPLENGTH,tripLength);
            object.put(TAG_DIRECTIONS,directions);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return object;
    }
    //==============================================================================================
    //============================================Getter============================================
    public String getTripLength() {
        return tripLength;
    }
    public int getId() {
        return id;
    }
    public String getDirections() {
        return directions;
    }

    public double getTurn_coords_lon() {
        return turn_coords_lon;
    }

    public double getTurn_coords_lat() {
        return turn_coords_lat;
    }

    //==============================================================================================
    //============================================Setter============================================
    public void setTripLength(String tripLength) {
        this.tripLength = tripLength;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setTurn_coords_lon(double turn_coords_lon) {
        this.turn_coords_lon = turn_coords_lon;
    }

    public void setTurn_coords_lat(double turn_coords_lat) {
        this.turn_coords_lat = turn_coords_lat;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }
    //==============================================================================================


}
