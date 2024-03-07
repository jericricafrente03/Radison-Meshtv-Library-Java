package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mars on 6/5/17.
 */

public class MeshStream extends RealmObject implements MeshObjectInterface
{

    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    @Ignore
    public static final String TAG = MeshStream.class.getSimpleName();
    @Ignore
    public static final String TAG_ID               = "id";
    @Ignore
    public static final String TAG_CATEGORY         = "category";
    @Ignore
    public static final String TAG_TITLE            = "title";
    @Ignore
    public static final String TAG_COUNTRY          = "country";
    @Ignore
    public static final String TAG_DESCRIPTION      = "description";
    @Ignore
    public static final String TAG_BROADCAST_START  = "released";
    @Ignore
    public static final String TAG_TAGS             = "tags";
    @Ignore
    public static final String TAG_EPISODES         = "episodes";
    @Ignore
    public static final String TAG_IMAGE_URL        = "image";
    @Ignore
    public static final String TAG_STATUS           = "status";
    @Ignore
    public static final String DATE_FORMAT          = "MM-dd-yyyy";
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    @PrimaryKey
    public int id;
    public int category;
    public String title;
    public String country;
    public String description;
    public String released;
    public String tags;
    public String episodes;
    public String image;
    public String status;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    public int getId() {
        return id;
    }
    public int getCategory() {
        return category;
    }
    public String getTitle() {
        return title;
    }
    public String getCountry() {
        return country;
    }
    public String getDescription() {
        return description;
    }
    public String getReleased() {
        return released;
    }
    public String getTags() {
        return tags;
    }
    public String getEpisodes() {
        return episodes;
    }
    public String getImage() {
        return image;
    }
    public String getStatus() {
        return status;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setCategory(int category) {
        this.category = category;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setReleased(String released) {
        this.released = released;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setStatus(String status) {
        this.status = status;
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
        return title;
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
        return 0;
    }
    @Override
    public String getMeshIMG() {
        return image;
    }
    //==============================================================================================
}
