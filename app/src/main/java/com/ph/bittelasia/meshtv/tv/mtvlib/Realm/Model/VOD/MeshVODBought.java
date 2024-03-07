package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshVODBought extends RealmObject implements MeshObjectInterface
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    @Ignore
    public static final String TAG = MeshVODBought.class.getSimpleName();
    @Ignore
    public static  final String TAG_ID = "id";
    @Ignore
    public static  final String API = "vod_rented";
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Instance-------------------------------------------
    @PrimaryKey
    public int id;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    public int getId() {
        return id;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================MeshObjectInterface=================================
    @Override
    public int getMeshID() {
        return id;
    }
    @Override
    public String getMeshLabel() {
        return String.valueOf(id);
    }
    @Override
    public String getMeshDescription() {
        return String.valueOf(id);
    }
    @Override
    public int getMeshQuantity() {
        return 1;
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
