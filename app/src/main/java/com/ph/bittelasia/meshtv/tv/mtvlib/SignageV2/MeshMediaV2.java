package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshMediaV2  extends RealmObject implements MeshObjectInterface
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    @Ignore
    public static final String TAG = MeshMediaV2.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_NAME = "name";
    @Ignore
    public static final String TAG_TYPE_ID = "type_id";
    @Ignore
    public static final String TAG_GROUP_ID = "group_id";
    @Ignore
    public static final String TAG_URL = "url";
    @Ignore
    public static final String TAG_LAYOUT_ID = "layout_id";
    @Ignore
    public static final String TAG_ORIENTATION = "orientation";
    @Ignore
    public static final int ORIENTATION_PORTRAIT = 0;
    @Ignore
    public static final int ORIENTATION_LANDSCAPE = 1;
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    @PrimaryKey
    private int id;
    private String name;
    private int type_id;
    private String url;
    private int group_id;
    private int layout_id;
    private int orientation;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Method=========================================
    //-----------------------------------------------Getter-----------------------------------------
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getType_id() {
        return type_id;
    }
    public String getUrl() {
        return url;
    }
    public int getGroup_id() {
        return group_id;
    }
    public int getLayout_id() {
        return layout_id;
    }
    public int getOrientation() {
        return orientation;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Setter-----------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }
    public void setLayout_id(int layout_id) {
        this.layout_id = layout_id;
    }
    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //========================================MeshObjectInterface===================================
    @Override
    public int getMeshID() {
        return id;
    }
    @Override
    public String getMeshLabel() {
        return url;
    }
    @Override
    public String getMeshDescription() {
        return url;
    }
    @Override
    public int getMeshQuantity() {
        return id;
    }
    @Override
    public double getMeshPrice() {
        return id;
    }
    @Override
    public String getMeshIMG() {
        return url;
    }
    //==============================================================================================
}
