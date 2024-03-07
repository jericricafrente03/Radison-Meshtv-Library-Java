package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshMediaZone extends RealmObject implements MeshObjectInterface
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    @Ignore
    public static final String TAG = MeshMediaZone.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_MEDIA_ID = "media_id";
    @Ignore
    public static final String TAG_ZONE_ID = "zone_id";
    @Ignore
    public static final String TAG_SIGNAGE_ID = "signage_id";
    @Ignore
    public static final String TAG_TIME = "time";
    @Ignore
    public static final int TIME_DEFAULT = 0;
    @Ignore
    public static final int TIME_FOREVER = -1;
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    @PrimaryKey
    private int id;
    private int media_id;
    private int signage_id;
    private int zone_id;
    private int time;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Method=========================================
    //-----------------------------------------------Getter-----------------------------------------
    public int getId() {
        return id;
    }
    public int getMedia_id() {
        return media_id;
    }
    public int getZone_id() {
        return zone_id;
    }
    public int getTime() {
        return time;
    }
    public int getSignage_id() {
        return signage_id;
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Setter------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setMedia_id(int media_id) {
        this.media_id = media_id;
    }
    public void setZone_id(int zone_id) {
        this.zone_id = zone_id;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public void setSignage_id(int signage_id) {
        this.signage_id = signage_id;
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
