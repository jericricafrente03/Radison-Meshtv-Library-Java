package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * @author Mars Ray Canizares Araullo
 * @version 2.0
 */
public class MeshPackage extends RealmObject implements MeshObjectInterface
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    @Ignore
    public static final String TAG = MeshPackage.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String CLASS_NAME = "get_packages";
    @Ignore
    public static final String TAG_NAME = "name";
    @Ignore
    public static final String TAG_DESC = "description";
    @Ignore
    public static final String TAG_COST = "cost";
    @Ignore
    public static final String TAG_MODE = "mode";
    @Ignore
    public static final String TAG_DATE = "date";
    @Ignore
    public static final String DATE_FORMAT = "yyyy-MM-dd kk:mm:ss";
    @Ignore
    public static final int MODE_TRIAL = 1;
    @Ignore
    public static final int MODE_NORMAL = 0;
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    @PrimaryKey
    int id;
    String name;
    String description;
    double cost;
    int mode;
    String date;
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
    public String getDescription() {
        return description;
    }
    public double getCost() {
        return cost;
    }
    public int getMode() {
        return mode;
    }
    public String getDate() {
        return date;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public void setMode(int mode) {
        this.mode = mode;
    }
    public void setDate(String date) {
        this.date = date;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=======================================MeshObjectInterface====================================
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
        return 1;
    }
    @Override
    public double getMeshPrice() {
        return cost;
    }
    @Override
    public String getMeshIMG() {
        return null;
    }
    //==============================================================================================
}

