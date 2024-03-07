package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshLayout extends RealmObject implements MeshObjectInterface
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    @Ignore
    public static final String TAG              = MeshLayout.class.getSimpleName();
    @Ignore
    public static final String TAG_ID           = "id";
    @Ignore
    public static final String DATE_FORMAT      = "yyyy-MM-dd kk:mm:ss";
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Instance-------------------------------------------
    @PrimaryKey
    private int id;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

    //============================================Method============================================
    //--------------------------------------------Getter--------------------------------------------
    public int getId() {
        return id;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Setter--------------------------------------------
    public void setId(int id) {
        this.id = id;
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
