package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mars on 6/5/17.
 */

public class MeshVOD extends RealmObject implements MeshObjectInterface
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    @Ignore
    public static final String TAG = MeshVOD.class.getSimpleName();
    @Ignore
    public static final String TAG_ID    = "id";
    @Ignore
    public static final String TAG_TITLE    = "title";
    @Ignore
    public static final String TAG_GENRE    = "tag";
    @Ignore
    public static final String TAG_PLOT     = "plot";
    @Ignore
    public static final String TAG_IMG      = "img";
    @Ignore
    public static final String TAG_TRAILER  = "trailer";
    @Ignore
    public static final String TAG_FULL     = "full";
    @Ignore
    public static final String TAG_LENGTH   = "length";
    @Ignore
    public static final String TAG_RATING   = "rating";
    @Ignore
    public static final String TAG_BOUGHT   = "bought";
    @Ignore
    public static final String TAG_PRICE   = "price";
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    @PrimaryKey
    public int id;
    public String title;
    public String tag;
    public String plot;
    public String img;
    public String trailer;
    public String full;
    public int length;
    public String rating;
    public int bought = 0;
    public double price = 0;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Getter------------------------------------------
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getTag() {
        return tag;
    }
    public String getPlot() {
        return plot;
    }
    public String getImg() {
        return img;
    }
    public String getTrailer() {
        return trailer;
    }
    public String getFull() {
        return full;
    }
    public int getLength() {
        return length;
    }
    public String getRating() {
        return rating;
    }
    public int getBought() {
        return bought;
    }
    public double getPrice() {
        return price;
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Setter------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public void setPlot(String plot) {
        this.plot = plot;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
    public void setFull(String full) {
        this.full = full;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public void setBought(int bought) {
        this.bought = bought;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Abstract=========================================
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
        return plot;
    }
    @Override
    public int getMeshQuantity() {
        return 0;
    }
    @Override
    public double getMeshPrice() {
        return price;
    }
    @Override
    public String getMeshIMG() {
        return img;
    }
    //==============================================================================================
}
