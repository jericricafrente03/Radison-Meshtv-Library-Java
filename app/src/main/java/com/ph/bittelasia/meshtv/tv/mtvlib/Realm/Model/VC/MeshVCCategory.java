package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshVCCategory extends RealmObject implements MeshObjectInterface
{
    //==========================================Variable============================================
    //------------------------------------------Constant--------------------------------------------
    @Ignore
    public static final String TAG = MeshVCCategory.class.getSimpleName();
    @Ignore
    public static final String TAG_ID           = "id";
    @Ignore
    public static final String TAG_NAME         = "category_name";
    @Ignore
    public static final String TAG_DESCRIPTION  = "category_description";
    @Ignore
    public static final String TAG_PREVIEW      = "img_preview";
    @Ignore
    public static final String TAG_IMG          = "img_uri";
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Instance--------------------------------------------
    @PrimaryKey
    private int id;
    private String name;
    private String description;
    private String img_uri;
    private String img_preview;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Method=============================================
    //-------------------------------------------Getter---------------------------------------------
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getImg_uri() {
        return img_uri;
    }
    public String getImg_preview() {
        return img_preview;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Setter---------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setImg_uri(String img_uri) {
        this.img_uri = img_uri;
    }
    public void setImg_preview(String img_preview) {
        this.img_preview = img_preview;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================Abstract============================================
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
        return description;
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
