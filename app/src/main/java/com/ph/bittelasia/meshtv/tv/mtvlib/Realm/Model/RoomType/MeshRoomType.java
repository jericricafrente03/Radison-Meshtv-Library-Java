package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RoomType;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshRoomType extends RealmObject implements MeshObjectInterface
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    @Ignore
    public static final String TAG = MeshRoomType.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_CATEGORY_ID = "facility_category_id";
    @Ignore
    public static final String TAG_ORDER = "order_no";
    @Ignore
    public static final String TAG_NAME = "category_name";
    @Ignore
    public static final String TAG_DESC = "category_description";
    @Ignore
    public static final String TAG_AMENITIES = "amenities";
    @Ignore
    public static final String TAG_IMAGES = "images";
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    @PrimaryKey
    int id;
    int facilityCategoryId;
    int orderNo;
    String category_name;
    String category_description;
    String amenities;
    String images;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Method=========================================
    //-----------------------------------------------Getter-----------------------------------------
    public int getId() {
        return id;
    }
    public int getFacilityCategoryId() {
        return facilityCategoryId;
    }
    public int getOrderNo() {
        return orderNo;
    }
    public String getCategory_name() {
        return category_name;
    }
    public String getCategory_description() {
        return category_description;
    }
    public String getAmenities() {
        return amenities;
    }
    public String getImages() {
        return images;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Setter-----------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setFacilityCategoryId(int facilityCategoryId) {
        this.facilityCategoryId = facilityCategoryId;
    }
    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }
    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }
    public void setImages(String images) {
        this.images = images;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Abstract========================================
    @Override
    public int getMeshID() {
        return id;
    }
    @Override
    public String getMeshLabel() {
        return category_name;
    }
    @Override
    public String getMeshDescription() {
        return category_description;
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
        return images;
    }
    //==============================================================================================
}
