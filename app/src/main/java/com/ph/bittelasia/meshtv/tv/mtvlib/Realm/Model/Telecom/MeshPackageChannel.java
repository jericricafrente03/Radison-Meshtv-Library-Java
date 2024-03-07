package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom;


import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * @author Mars Ray Canizares Araullo
 * @version 2.0
 */
public class MeshPackageChannel extends RealmObject implements MeshObjectInterface
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    @Ignore
    public static final String TAG = MeshPackageChannel.class.getSimpleName();
    @Ignore
    public static final String CLASS_NAME = "get_package_channels";
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_PACKAGE_ID = "package_id";
    @Ignore
    public static final String TAG_CHANNEL_ID = "channel_id";
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    @PrimaryKey
    int id;
    int package_id;
    int channel_id;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    public int getId() {
        return id;
    }
    public int getPackage_id() {
        return package_id;
    }
    public int getChannel_id() {return channel_id;}
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setPackage_id(int package_id) {
        this.package_id = package_id;
    }
    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=======================================MeshObjectInterface====================================
    @Override
    public int getMeshID() {
        return 0;
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
