package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Table;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MeshHeader
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG          = MeshHeader.class.getSimpleName();
    public static final String TAG_NAME     = "namme";
    public static final String TAG_ORDER    = "order";
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    String name;
    int order;
    int resId;
    static Comparator<MeshHeader> headerComparator = new Comparator<MeshHeader>() {
        @Override
        public int compare(MeshHeader o1, MeshHeader o2) {
            return o1.getOrder()==o2.getOrder()?1:-1;
        }
    };
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Constructor======================================
    public MeshHeader()
    {

    }
    public MeshHeader(String data)
    {
        try
        {
            JSONObject object = new JSONObject(data);
            this.name = object.getString(TAG_NAME);
            this.order = object.getInt(TAG_ORDER);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public MeshHeader(String data, int resId)
    {
        try
        {
            JSONObject object = new JSONObject(data);
            this.name = object.getString(TAG_NAME);
            this.order = object.getInt(TAG_ORDER);
            this.resId = resId;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //==============================================================================================
    //===============================================Parser=========================================
    public static ArrayList<MeshHeader> parse(String data, int resId)
    {
        ArrayList<MeshHeader> headers = new ArrayList<>();
        try
        {
            JSONArray array = new JSONArray(data);
            for(int ctr = 0; ctr<array.length();ctr++)
            {
                MeshHeader header = new MeshHeader(array.getString(ctr),resId);
                headers.add(header);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        sort(headers);
        return headers;
    }
    public static void sort(ArrayList<MeshHeader> headers)
    {
        Collections.sort(headers,headerComparator);
    }
    //==============================================================================================
    //===============================================Method=========================================
    //-----------------------------------------------Getter-----------------------------------------
    public String getName() {
        return name;
    }
    public int getOrder() {
        return order;
    }
    public int getResId() {return resId;}
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Setter-----------------------------------------
    public void setName(String name) {this.name = name;}
    public void setOrder(int order) {this.order = order;}
    public void setResId(int resId) {this.resId = resId;}
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
