package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshContinent extends RealmObject implements MeshObjectInterface
{

    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    @Ignore
    public static final String TAG = MeshContinent.class.getSimpleName();
    @Ignore
    public static final String TAG_ID       = "id";
    @Ignore
    public static final String TAG_NAME     = "name";
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Instance-------------------------------------------
    @PrimaryKey
    public int id;
    public String name;
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
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Setter--------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Abstract===========================================
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
