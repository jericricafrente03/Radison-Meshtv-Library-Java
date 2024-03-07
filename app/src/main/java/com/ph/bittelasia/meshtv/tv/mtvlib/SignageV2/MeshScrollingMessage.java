package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshScrollingMessage extends RealmObject implements MeshObjectInterface
{
    //=========================================Variable=============================================
    //-----------------------------------------Constant---------------------------------------------
    @Ignore
    public static final String TAG = MeshScrollingMessage.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_SIGNAGE_ID = "signage_id";
    @Ignore
    public static final String TAG_ZONE = "zone";
    @Ignore
    public static final String TAG_MESSAGE = "message";
    @Ignore
    public static final String TAG_TIME = "time";
    @Ignore
    public static final int TIME_DEFAULT = 0;
    @Ignore
    public static final int TIME_FOREVER = -1;
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Instance--------------------------------------------
    @PrimaryKey
    int id;
    int signage_id;
    int zone;
    String message;
    int time;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Method=============================================
    //-------------------------------------------Getter---------------------------------------------
    public int getId() {
        return id;
    }
    public int getSignage_id() {
        return signage_id;
    }
    public int getZone() {
        return zone;
    }
    public String getMessage() {
        return message;
    }
    public int getTime() {
        return time;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Setter--------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setSignage_id(int signage_id) {
        this.signage_id = signage_id;
    }
    public void setZone(int zone) {
        this.zone = zone;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setTime(int time) {
        this.time = time;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=====================================MeshObjectInterface======================================
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
