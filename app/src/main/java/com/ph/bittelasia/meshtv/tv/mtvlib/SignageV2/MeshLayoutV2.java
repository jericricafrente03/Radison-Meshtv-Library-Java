package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshLayoutV2 extends RealmObject implements MeshObjectInterface
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    @Ignore
    public static final String TAG = MeshLayoutV2.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_LAYOUT = "name";
    @Ignore
    public static final String TAG_ZONE = "zones";
    @Ignore
    public static final String TAG_PREVIEW_URL="preview_url";
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    @PrimaryKey
    private int id;
    private String name;
    private int zones;
    private String preview_url;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getZones() {
        return zones;
    }
    public String getPreview_url() {
        return preview_url;
    }

    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String layout_name) {
        this.name = layout_name;
    }
    public void setZones(int zones) {
        this.zones = zones;
    }
    public void setPreview_url(String preview_url) {
        this.preview_url = preview_url;
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
