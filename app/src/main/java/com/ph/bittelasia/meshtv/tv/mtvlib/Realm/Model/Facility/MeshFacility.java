package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshFacility extends RealmObject implements MeshObjectInterface
{
    //=========================================Variable=============================================
    //-----------------------------------------Constant---------------------------------------------
    @Ignore
    public static final String TAG = MeshFacility.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_ITEM_NAME = "item_name";
    @Ignore
    public static final String TAG_DESC = "item_description";
    @Ignore
    public static final String TAG_UNIT_PRICE = "unit_price";
    @Ignore
    public static final String TAG_CATEGORY_ID = "category_id";
    @Ignore
    public static final String TAG_IMG_URI = "img_uri";
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------Instance---------------------------------------------
    @PrimaryKey
    private int id;
    private String item_name;
    private String item_description;
    private double unit_price;
    private int category_id;
    private String img_uri;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================Method==============================================
    //------------------------------------------Getter----------------------------------------------
    public int getId() {
        return id;
    }
    public String getItem_name() {
        return item_name;
    }
    public String getItem_description() {
        return item_description;
    }
    public double getUnit_price() {
        return unit_price;
    }
    public String getImg_uri() {
        return img_uri;
    }

    public int getCategory_id() {
        return category_id;
    }

    //----------------------------------------------------------------------------------------------
    //------------------------------------------Setter----------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }
    public void setImg_uri(String img_uri) {
        this.img_uri = img_uri;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================Abstract=============================================
    @Override
    public int getMeshID() {
        return id;
    }
    @Override
    public String getMeshLabel() {
        return item_name;
    }
    @Override
    public String getMeshDescription() {
        return item_description;
    }
    @Override
    public int getMeshQuantity() {
        return 0;
    }
    @Override
    public double getMeshPrice() {
        return unit_price;
    }
    @Override
    public String getMeshIMG() {
        return img_uri;
    }
    //==============================================================================================
}
