package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshMessage extends RealmObject implements MeshObjectInterface
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    @Ignore
    public static final String TAG = MeshMessage.class.getSimpleName();
    @Ignore
    public static final String TAG_ID2 = "id";
    @Ignore
    public static final String TAG_ID= "id";
    @Ignore
    public static final String TAG_USER_ID = "user_id";
    @Ignore
    public static final String TAG_ROOMNO = "room_id";
    @Ignore
    public static final String TAG_ACCOUNT = "account_no";
    @Ignore
    public static final String TAG_SUBJECT = "messg_subject";
    @Ignore
    public static final String TAG_DATE = "messg_datetime";
    @Ignore
    public static final String TAG_FROM = "messg_from";
    @Ignore
    public static final String TAG_MESSAGE = "messg_text";
    @Ignore
    public static final String TAG_STATUS = "messg_status";
    @Ignore
    public static final String TAG_NEW = "is_new";
    @Ignore
    public static final String TAG_TYPE = "messg_type";
    @Ignore
    public static final String TAG_IMG = "messg_img";
    @Ignore
    public static final String TAG_VID = "messg_vid";
    @Ignore
    public static final String TAG_DIS_TIME = "messg_display_time";
    @Ignore
    public static final String DATE_FORMAT = "yyyy-MM-dd kk:mm:ss";
    @Ignore
    public static final int TYPE_NORMAL = 0;
    @Ignore
    public static final int TYPE_SCROLLING = 1;
    @Ignore
    public static final int TYPE_POP_UP = 2;
    @Ignore
    public static final int TYPE_FULL_SCREEN = 3;
    @Ignore
    public static final int TYPE_EMERGENCY = 4;
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    @PrimaryKey
    private int id;
    private String room_id;
    private String messg_subject;
    private String messg_datetime;
    private String messg_from;
    private String messg_text;
    private int messg_type = 0;
    private String messg_img;
    private String messg_vid;
    private int messg_status;
    private boolean is_new = true;
    private int messg_display_time = 5;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    public int getId() {
        return id;
    }
    public String getRoom_id() {
        return room_id;
    }
    public String getMessg_subject() {
        return messg_subject;
    }
    public String getMessg_datetime() {
        return messg_datetime;
    }
    public String getMessg_from() {
        return messg_from;
    }
    public String getMessg_text() {
        return messg_text;
    }
    public int getMessg_status() {
        return messg_status;
    }
    public boolean is_new() {
        return is_new;
    }
    public int getMessg_type() {
        return messg_type;
    }
    public String getMessg_img() {
        return messg_img;
    }
    public String getMessg_vid() {
        return messg_vid;
    }

    public int getMessg_display_time() {
        return messg_display_time;
    }



    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }
    public void setMessg_subject(String messg_subject) {
        this.messg_subject = messg_subject;
    }
    public void setMessg_datetime(String messg_datetime) {
        this.messg_datetime = messg_datetime;
    }
    public void setMessg_from(String messg_from) {
        this.messg_from = messg_from;
    }
    public void setMessg_text(String messg_text) {
        this.messg_text = messg_text;
    }
    public void setMessg_status(int messg_status) {
        this.messg_status = messg_status;
    }
    public void setIs_new(boolean is_new) {
        this.is_new = is_new;
    }
    public void setMessg_type(int messg_type) {
        this.messg_type = messg_type;
    }
    public void setMessg_img(String messg_img) {
        this.messg_img = messg_img;
    }
    public void setMessg_vid(String messg_vid) {
        this.messg_vid = messg_vid;
    }
    public void setMessg_display_time(int messg_display_time) {
        this.messg_display_time = messg_display_time*1000;
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
        return messg_subject;
    }
    @Override
    public String getMeshDescription() {
        return messg_text;
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
