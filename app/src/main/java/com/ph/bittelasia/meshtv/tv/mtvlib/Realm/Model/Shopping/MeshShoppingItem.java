package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshShoppingItem extends RealmObject implements MeshObjectInterface
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    @Ignore
    public static final String TAG = MeshShoppingItem.class.getSimpleName();
    @Ignore
    public static final String TAG_ID           = "id";
    @Ignore
    public static final String TAG_ITEM_NAME    = "item_name";
    @Ignore
    public static final String TAG_DESC         = "item_description";
    @Ignore
    public static final String TAG_UNIT_PRICE   = "unit_price";
    @Ignore
    public static final String TAG_CATEGORY_ID  = "shopping_category_id";
    @Ignore
    public static final String TAG_IMG_URI      = "img_uri";
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    @PrimaryKey
    int id;
    int shopping_category_id;
    String item_name;
    String item_description;
    String img_uri;
    double unit_price;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Method=========================================
    //-----------------------------------------------Getter-----------------------------------------
    public int getId() {
        return id;
    }
    public int getShopping_category_id() {
        return shopping_category_id;
    }
    public String getItem_name() {
        return item_name;
    }
    public String getItem_description() {
        return item_description;
    }
    public String getImg_uri() {
        return img_uri;
    }
    public double getUnit_price() {
        return unit_price;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Setter-----------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setShopping_category_id(int shopping_category_id) {
        this.shopping_category_id = shopping_category_id;
    }
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }
    public void setImg_uri(String img_uri) {
        this.img_uri = img_uri;
    }
    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Abstract=========================================
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
    //===============================================================================================
}
