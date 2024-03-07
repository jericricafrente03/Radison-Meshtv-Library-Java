package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MeshDirection{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    //Tags
    public static final String TAG_DISTANCE = "distance";
    public static final String TAG_ICON_URL = "icon_url";
    public static final String TAG_NARRATIVE = "narrative";
    public static final String TAG_TURN_COORDS_LAT = "turn_coords_lat";
    public static final String TAG_TURN_COORDS_LONG = "turn_coords_lon";
    public static final String TAG_SEQ_NO = "sequence_number";
    public static final String TAG_CATID = "category_id";
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Properties----------------------------------------
    private String distance;
    private String iconUrl;
    private String narrative;
    private double turnCoordsLat;
    private double turnCoordsLon;
    private Bitmap icon;
    private int sequenceNumber;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Constructor=======================================
    public MeshDirection(String distance, String iconUrl, String narrative, double turnCoordsLat, double turnCoordsLon, int sequenceNumber)
    {
        this.distance = distance;
        this.iconUrl = iconUrl;
        this.narrative = narrative;
        this.turnCoordsLat = turnCoordsLat;
        this.turnCoordsLon = turnCoordsLon;
        this.sequenceNumber = sequenceNumber;
    }

    public MeshDirection(JSONObject object) {
        try {
            this.distance = object.getString(TAG_DISTANCE);
            this.iconUrl = object.getString(TAG_ICON_URL);
            this.narrative = object.getString(TAG_NARRATIVE);
            this.turnCoordsLat = object.getDouble(TAG_TURN_COORDS_LAT);
            this.turnCoordsLon = object.getDouble(TAG_TURN_COORDS_LONG);
            this.sequenceNumber = object.getInt(TAG_SEQ_NO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MeshDirection(String data) {
        try {
            JSONObject object = new JSONObject(data);
            this.distance = object.getString(TAG_DISTANCE);
            this.iconUrl = object.getString(TAG_ICON_URL);
            this.narrative = object.getString(TAG_NARRATIVE);
            this.turnCoordsLat = object.getDouble(TAG_TURN_COORDS_LAT);
            this.turnCoordsLon = object.getDouble(TAG_TURN_COORDS_LONG);
            this.sequenceNumber = object.getInt(TAG_SEQ_NO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //==============================================================================================
    //============================================Converter=========================================
    public JSONObject getJSON() {
        JSONObject object = new JSONObject();
        try {
            object.put(TAG_DISTANCE,distance);
            object.put(TAG_ICON_URL,iconUrl);
            object.put(TAG_NARRATIVE,narrative);
            object.put(TAG_TURN_COORDS_LAT,turnCoordsLat);
            object.put(TAG_TURN_COORDS_LONG,turnCoordsLon);
            object.put(TAG_SEQ_NO,sequenceNumber);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    //==============================================================================================
    //============================================Getter============================================

    public String getDistance() {
        return distance;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getNarrative() {
        return narrative;
    }

    public double getTurnCoordsLat() {
        return turnCoordsLat;
    }

    public double getTurnCoordsLon() {
        return turnCoordsLon;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    //==============================================================================================
    //============================================Setter============================================

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public void setTurnCoordsLat(double turnCoordsLat) {
        this.turnCoordsLat = turnCoordsLat;
    }

    public void setTurnCoordsLon(double turnCoordsLon) {
        this.turnCoordsLon = turnCoordsLon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    //==============================================================================================
    //============================================MeshQLite Object==================================
    //==============================================================================================
    //============================================Parser============================================
    public static List<MeshDirection> parse(String data)
    {
        ArrayList<MeshDirection> directions =new ArrayList<MeshDirection>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString(MeshVC.TAG_DIR));
            for(int ctr = 0; ctr<data.length();ctr++)
            {
                directions.add(new MeshDirection(array.getString(ctr)));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return directions;
    }
    //==============================================================================================
}
