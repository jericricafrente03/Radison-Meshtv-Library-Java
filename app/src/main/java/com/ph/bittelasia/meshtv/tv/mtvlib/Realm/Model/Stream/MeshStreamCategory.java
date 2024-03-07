package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mars on 6/5/17.
 */

public class MeshStreamCategory extends RealmObject implements MeshObjectInterface
{
    //==========================================Variable============================================
    //------------------------------------------Constant--------------------------------------------
    @Ignore
    public static final String TAG = MeshStreamCategory.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_CATEGORY_DESCRIPTION = "category_description";
    @Ignore
    public static final String TAG_CATEGORY_NAME = "category_name";
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Instance--------------------------------------------
    @PrimaryKey
    int id;
    String category_description;
    String category_name;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Method=============================================
    //-------------------------------------------Getter---------------------------------------------
    public int getId() {
        return id;
    }
    public String getCategory_description() {
        return category_description;
    }
    public String getCategory_name() {
        return category_name;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Setter---------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
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
        return null;
    }
    //==============================================================================================
}
