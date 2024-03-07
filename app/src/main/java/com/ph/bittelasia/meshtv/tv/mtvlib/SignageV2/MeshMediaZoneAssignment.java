package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshMediaZoneAssignment extends RealmObject implements MeshObjectInterface
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    @Ignore
    public static final String TAG = MeshMediaZoneAssignment.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_LAYOUT_ID = "layout_id";
    @Ignore
    public static final String TAG_SIGNAGE_ID = "signage_id";
    @Ignore
    public static final String TAG_ZONE = "zone";
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    @PrimaryKey
    private int id;
    private int layout_id;
    private int signage_id;
    private int zone;

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Method============================================
    //--------------------------------------------Getter--------------------------------------------

    public int getId() {
        return id;
    }

    public int getLayout_id() {
        return layout_id;
    }

    public int getSignage_id() {
        return signage_id;
    }

    public int getZone() {
        return zone;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Setter--------------------------------------------

    public void setId(int id) {
        this.id = id;
    }

    public void setLayout_id(int layout_id) {
        this.layout_id = layout_id;
    }

    public void setSignage_id(int signage_id) {
        this.signage_id = signage_id;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=======================================MeshObjectInterface====================================

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
