package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshFacilityCategory extends RealmObject implements MeshObjectInterface
{

    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    @Ignore
    public static final String TAG = MeshFacilityCategory.class.getSimpleName();
    @Ignore
    public static final String TAG_ID               = "id";
    @Ignore
    public static final String TAG_NAME             = "category_name";
    @Ignore
    public static final String TAG_DESC             = "category_description";
    @Ignore
    public static final String TAG_IMAGE            = "img_uri";
    @Ignore
    public static final String TAG_IMAGE_PREVIEW    = "img_preview";
    @Ignore
    public static final String TAG_IMAGE2           = "img_uri";
    @Ignore
    public static final String IS_SERVICE           = "is_service";
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    @PrimaryKey
    private int id;
    private String category_name;
    private String category_description;
    private String img_preview;
    private boolean is_service;
    private String img_uri;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Method============================================
    //--------------------------------------------Getter--------------------------------------------
    public int getId() {
        return id;
    }
    public String getCategory_name() {
        return category_name;
    }
    public String getCategory_description() {
        return category_description;
    }
    public String getImg_preview() {
        return img_preview;
    }
    public boolean is_service() {
        return is_service;
    }
    public String getImg_uri() {
        return img_uri;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Setter--------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }
    public void setImg_preview(String img_preview) {
        this.img_preview = img_preview;
    }
    public void setIs_service(boolean is_service) {
        this.is_service = is_service;
    }
    public void setImg_uri(String img_uri) {
        this.img_uri = img_uri;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Abstract===========================================
    @Override
    public int getMeshID() {return id;}
    @Override
    public String getMeshLabel() {return category_name;}
    @Override
    public String getMeshDescription() {return category_description;}
    @Override
    public int getMeshQuantity() {return 0;}
    @Override
    public double getMeshPrice() {return 0;}
    @Override
    public String getMeshIMG() {return img_uri;}
    //==============================================================================================
}
