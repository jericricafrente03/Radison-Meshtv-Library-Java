package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Music;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshMusic extends RealmObject implements MeshObjectInterface
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    @Ignore
    public static final String TAG = MeshMusic.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_CATEGORY_ID = "music_category_id";
    @Ignore
    public static final String TAG_DESC = "music_description";
    @Ignore
    public static final String TAG_IMAGE = "img_uri";
    @Ignore
    public static final String TAG_TITLE = "music_title";
    @Ignore
    public static final String TAG_URI = "music_uri";
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    @PrimaryKey
    private int id;
    private int music_category_id;
    private String music_description;
    private String music_uri;
    private String music_title;
    private String img_uri;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    public int getId() {
        return id;
    }
    public int getMusic_category_id() {
        return music_category_id;
    }
    public String getMusic_description() {
        return music_description;
    }
    public String getMusic_uri() {
        return music_uri;
    }
    public String getMusic_title() {
        return music_title;
    }
    public String getImg_uri() {
        return img_uri;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setMusic_category_id(int music_category_id) {
        this.music_category_id = music_category_id;
    }
    public void setMusic_description(String music_description) {
        this.music_description = music_description;
    }
    public void setMusic_uri(String music_uri) {
        this.music_uri = music_uri;
    }
    public void setMusic_title(String music_title) {
        this.music_title = music_title;
    }
    public void setImg_uri(String img_uri) {
        this.img_uri = img_uri;
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
        return music_title;
    }
    @Override
    public String getMeshDescription() {
        return music_description;
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
        return img_uri;
    }
    //==============================================================================================
}
