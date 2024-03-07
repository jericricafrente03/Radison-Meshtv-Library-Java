package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mars on 6/2/17.
 */

public class MeshFoodCategory extends RealmObject implements MeshObjectInterface
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    @Ignore
    public static final String TAG = MeshFoodCategory.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_NAME = "category_name";
    @Ignore
    public static final String TAG_DESC = "category_description";
    @Ignore
    public static final String TAG_SERVICE = "is_service";
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    @PrimaryKey
    private int id;
    private boolean is_service;
    private String category_name;
    private String category_description;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Method=========================================
    //-----------------------------------------------Getter-----------------------------------------
    public int getId() {
        return id;
    }
    public boolean is_service() {
        return is_service;
    }
    public String getCategory_name() {
        return category_name;
    }
    public String getCategory_description() {
        return category_description;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Setter-----------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setIs_service(boolean is_service) {
        this.is_service = is_service;
    }
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Abstract========================================
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
    public String getMeshIMG() {return null;}
    //==============================================================================================
}