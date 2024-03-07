package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshChannel extends RealmObject implements MeshObjectInterface
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    @Ignore
    public static final String TAG              = MeshChannel.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_CATEGORY_ID = "channel_category_id";
    @Ignore
    public static final String TAG_DESCRIPTION = "channel_description";
    @Ignore
    public static final String TAG_IMAGE_URL = "channel_image";
    @Ignore
    public static final String TAG_TITLE = "channel_title";
    @Ignore
    public static final String TAG_URI = "channel_uri";
    @Ignore
    public static final String TAG_ORDER = "order_no";
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    @PrimaryKey
    private int id;
    private String channel_title;
    private int channel_category_id;
    private String channel_uri;
    private String channel_image;
    private String channel_description;
    private int order_no;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Method=========================================
    //-----------------------------------------------Getter-----------------------------------------
    public int getId() {
        return id;
    }
    public String getChannel_title() {
        return channel_title;
    }
    public int getChannel_category_id() {
        return channel_category_id;
    }
    public String getChannel_uri() {
        return channel_uri;
    }
    public String getChannel_image() {
        return channel_image;
    }
    public String getChannel_description() {
        return channel_description;
    }
    public int getOrder_no() {
        return order_no;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Setter-----------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setChannel_title(String channel_title) {
        this.channel_title = channel_title;
    }
    public void setChannel_category_id(int channel_category_id) {this.channel_category_id = channel_category_id;}
    public void setChannel_uri(String channel_uri) {
        this.channel_uri = channel_uri;
    }
    public void setChannel_image(String channel_image) {
        this.channel_image = channel_image;
    }
    public void setChannel_description(String channel_description) {
        this.channel_description = channel_description;
    }
    public void setOrder_no(int order_no) {
        this.order_no = order_no;
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
        return channel_title;
    }
    @Override
    public String getMeshDescription() {
        return channel_description;
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
        return channel_image;
    }
    //==============================================================================================

}
