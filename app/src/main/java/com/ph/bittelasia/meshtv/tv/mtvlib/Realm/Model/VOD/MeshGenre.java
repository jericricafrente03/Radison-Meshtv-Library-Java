package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD;


import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mars on 6/5/17.
 */

public class MeshGenre extends RealmObject implements MeshObjectInterface
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    @Ignore
    public static final String TAG = MeshGenre.class.getSimpleName();
    @Ignore
    public static final String TAG_ID       = "id";
    @Ignore
    public static final String TAG_NAME     = "genre";
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    @PrimaryKey
    String genre;
    int id;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    public String getGenre() {
        return genre;
    }
    public int getId() {
        return id;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setId(int id) {
        this.id = id;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Convert-------------------------------------------
    public static ArrayList<MeshGenre> getGenre(MeshVOD vod)
    {
        ArrayList<MeshGenre> genres = new ArrayList<>();
        try
        {
            JSONArray array = new JSONArray(vod.getTag());
            for(int ctr = 0 ; ctr<array.length();ctr++)
            {
                MeshGenre genre = new MeshGenre();
                genre.setGenre(new JSONObject(array.getString(ctr)).getString("genre"));
                genres.add(genre);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return genres;
    }
    public static boolean checkGenre(MeshVOD vod,String genreName)
    {
        ArrayList<MeshGenre> genres = new ArrayList<>();
        try
        {
            JSONArray array = new JSONArray(vod.getTag());
            for(int ctr = 0 ; ctr<array.length();ctr++)
            {
             if(new JSONObject(array.getString(ctr)).getString("genre").toLowerCase().equals(genreName.toLowerCase()))
             {
                    return true;
             }

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Abstract==========================================
    @Override
    public int getMeshID() {
        return id;
    }
    @Override
    public String getMeshLabel() {
        return genre;
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
    //==============================================================================================
}
