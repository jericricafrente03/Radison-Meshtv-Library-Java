package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
/**
 * @author Mars Ray Canizares Araullo
 * @version 2.0
 */
public class MeshSubscription  extends RealmObject implements MeshObjectInterface
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    @Ignore
    public static final String TAG = MeshSubscription.class.getSimpleName();
    @Ignore
    public static final String CLASS_NAME = "get_subscriptions";
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_CUSTOMER_ID = "subscriber_id";
    @Ignore
    public static final String TAG_PACKAGE_ID = "package_id";

    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    @PrimaryKey
    int id;
    String customer_id;
    int package_id;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    public String getCustomer_id() {
        return customer_id;
    }
    public int getPackage_id() {
        return package_id;
    }
    public int getId() {
        return id;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }
    public void setPackage_id(int package_id) {
        this.package_id = package_id;
    }
    public void setId(int id) {
        this.id = id;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=======================================MeshObjectInterface====================================
    @Override
    public int getMeshID() {
        return -1;
    }
    @Override
    public String getMeshLabel() {
        return null;
    }
    @Override
    public String getMeshDescription() {
        return null;
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
