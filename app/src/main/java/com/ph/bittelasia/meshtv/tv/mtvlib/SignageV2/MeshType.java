package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshType extends RealmObject implements MeshObjectInterface
{

    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    @Ignore
    public static final String TAG = MeshType.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_NAME = "name";
    @Ignore
    public static final String TAG_DESCRIPTION = "description";
    @Ignore
    public static final int TYPE_IMAGE = 0;
    @Ignore
    public static final int TYPE_VIDEO = 1;
    @Ignore
    public static final int TYPE_SCROLL = 2;
    @Ignore
    public static final int TYPE_WEATHER = 3;
    @Ignore
    public static final int TYPE_TIME = 4;
    @Ignore
    public static final int TYPE_FEED = 5;
    @Ignore
    public static final int TYPE_WEATHER_FORECAST = 6;
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Instance-------------------------------------------
    @PrimaryKey
    private int id;
    private String name;
    private String description;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Method============================================
    //--------------------------------------------Getter--------------------------------------------
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Setter--------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //========================================MeshObjectInterface===================================
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
    //==============================================================================================
}
