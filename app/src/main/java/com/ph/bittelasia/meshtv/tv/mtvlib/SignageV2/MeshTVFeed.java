package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshTVFeed extends RealmObject implements MeshObjectInterface
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    @Ignore
    public static final String TAG = MeshTVFeed.class.getSimpleName();
    @Ignore
    public static final String TAG_API = "get_all_feeds";
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_SIGNAGE_ID = "signage_id";
    @Ignore
    public static final String TAG_GROUP_ID = "group_id";
    @Ignore
    public static final String TAG_GROUP_ORDER = "group_order";
    @Ignore
    public static final String TAG_SOURCE = "source";
    @Ignore
    public static final String TAG_TITLE = "title";
    @Ignore
    public static final String TAG_DESCRIPTION = "description";
    @Ignore
    public static final String TAG_SCHEDULE = "schedule";
    @Ignore
    public static final String TAG_IMAGE = "image";
    @Ignore
    public static final String TAG_LOCATION = "location";
    @Ignore
    public static final String TAG_OWNER = "owner";
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    @PrimaryKey
    int id;
    int signage_id;
    int group_id;
    int group_order;
    String source;
    String title;
    String description;
    String schedule;
    String image;
    String location;
    String owner;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Getter------------------------------------------
    public int getId() {
        return id;
    }
    public int getSignage_id() {
        return signage_id;
    }
    public int getGroup_id() {
        return group_id;
    }
    public int getGroup_order() {
        return group_order;
    }
    public String getSource() {
        return source;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getSchedule() {
        return schedule;
    }
    public String getImage() {
        return image;
    }
    public String getLocation() {
        return location;
    }
    public String getOwner() {
        return owner;
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Setter------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setSignage_id(int signage_id) {
        this.signage_id = signage_id;
    }
    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }
    public void setGroup_order(int group_order) {
        this.group_order = group_order;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================MeshTVFeed========================================
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
