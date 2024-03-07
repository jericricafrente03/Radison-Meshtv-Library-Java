package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MeshEpisode
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = MeshEpisode.class.getSimpleName();
    public static final String TAG_TITLE = "title";
    public static final String TAG_NUMBER = "number";
    public static final String TAG_DESC = "description";
    public static final String TAG_URL = "url";
    public static final String TAG_IMG = "img";
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Instance---------------------------------------
    private String title = null;
    private String number = null;
    private String description = null;
    private String url = null;
    private String img = null;

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Constructor======================================
    public MeshEpisode(String data)
    {
        try
        {
            JSONObject object = new JSONObject(data);
            title = object.getString(TAG_TITLE);
            number = object.getString(TAG_NUMBER);
            description = object.getString(TAG_DESC);
            url = object.getString(TAG_URL);
            img = object.getString(TAG_IMG);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //==============================================================================================
    //================================================Method========================================
    //------------------------------------------------Factory---------------------------------------
    public static ArrayList<MeshEpisode> generate(String episodes)
    {
        ArrayList<MeshEpisode> tags = new ArrayList<>();
        try
        {
            JSONArray array1 = new JSONArray(episodes);
            for(int ctr = 0; array1.length()>ctr;ctr++)
            {
                try
                {
                    tags.add(new MeshEpisode(array1.getString(ctr)));
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
        return tags;
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Getter----------------------------------------
    public String getTitle() {
        return title;
    }
    public String getNumber() {
        return number;
    }
    public String getDescription() {
        return description;
    }
    public String getUrl() {
        return url;
    }
    public String getImg() {
        return img;
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Setter----------------------------------------
    public void setTitle(String title) {
        this.title = title;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setImg(String img) {
        this.img = img;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
