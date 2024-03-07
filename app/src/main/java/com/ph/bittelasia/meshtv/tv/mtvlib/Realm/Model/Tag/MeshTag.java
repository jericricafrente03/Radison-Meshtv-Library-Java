package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Tag;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mars on 6/2/17.
 */

public class MeshTag extends RealmObject implements MeshObjectInterface
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    @Ignore
    public static final String TAG = MeshTag.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_PARENTID = "parentID";
    @Ignore
    public static final String TAG_PARENT = "parent";
    @Ignore
    public static final String TAG_NAME = "name";
    @Ignore
    public static final String TAG_IMG = "img";
    @Ignore
    public static final String TAG_IS_CUSTOM = "isCustom";
    @Ignore
    public static final String TAG_PRICE = "price";
    @Ignore
    public static final String TAG_DESC = "description";
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    @PrimaryKey
    int id;
    int parentID;
    int isCustom;
    String name;
    String parent;
    String img;
    String description;
    double price;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    public int getId() {
        return id;
    }
    public int getParentID() {
        return parentID;
    }
    public int getIsCustom() {
        return isCustom;
    }
    public String getName() {
        return name;
    }
    public String getParent() {
        return parent;
    }
    public String getImg() {
        return img;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setParentID(int parentID) {
        this.parentID = parentID;
    }
    public void setIsCustom(int isCustom) {
        this.isCustom = isCustom;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setParent(String parent) {
        this.parent = parent;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Abstract==========================================
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
        return price;
    }
    @Override
    public String getMeshIMG() {
        return img;
    }
    //==============================================================================================
}
