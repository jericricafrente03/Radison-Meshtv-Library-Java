package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshSignageV2 extends RealmObject implements MeshObjectInterface
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    @Ignore
    public static final String TAG = MeshSignageV2.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_LAYOUT_ID = "layout_id";
    @Ignore
    public static final String TAG_BACKGROUND = "background";
    @Ignore
    public static final String TAG_ORIENTATION = "orientation";
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    @PrimaryKey
    private int id;
    private int layout_id;
    private String background;
    private int orientation;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Getter------------------------------------------
    public int getId() {
        return id;
    }
    public int getLayout_id() {
        return layout_id;
    }
    public String getBackground() {
        return background;
    }
    public int getOrientation() {
        return orientation;
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Setter------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setLayout_id(int layout_id) {
        this.layout_id = layout_id;
    }
    public void setBackground(String background) {
        this.background = background;
    }
    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================MeshObjectInterface==================================
    @Override
    public int getMeshID() {
        return id;
    }
    @Override
    public String getMeshLabel() {
        return background;
    }
    @Override
    public String getMeshDescription() {
        return background;
    }
    @Override
    public int getMeshQuantity() {
        return layout_id;
    }
    @Override
    public double getMeshPrice() {
        return layout_id;
    }
    @Override
    public String getMeshIMG() {
        return background;
    }
    //==============================================================================================
}
