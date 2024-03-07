package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshSignageSchedule extends RealmObject implements MeshObjectInterface
{

    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    @Ignore
    public static final String TAG              = MeshSignageSchedule.class.getSimpleName();
    @Ignore
    public static final String TAG_ID           = "id";
    @Ignore
    public static final String TAG_SIGNAGE_ID   = "signage_id";
    @Ignore
    public static final String TAG_SCHEDULE_ID  = "schedule_id";
    @Ignore
    public static final String DATE_FORMAT = "yyyy-MM-dd kk:mm:ss";
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    @PrimaryKey
    private int id;
    private int signage_id;
    private int schedule_id;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Getter------------------------------------------
    public int getId() {
        return id;
    }
    public int getSignage_id() {
        return signage_id;
    }
    public int getSchedule_id() {
        return schedule_id;
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Setter------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setSignage_id(int signage_id) {
        this.signage_id = signage_id;
    }
    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================MeshObjectInterface==================================
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
