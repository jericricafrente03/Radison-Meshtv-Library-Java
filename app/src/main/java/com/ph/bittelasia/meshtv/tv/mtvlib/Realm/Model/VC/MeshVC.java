package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshVC extends RealmObject implements MeshObjectInterface
{

    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    @Ignore
    public static final String TAG = MeshVC.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_CAT_ID = "category_id";
    @Ignore
    public static final String TAG_E_NAME = "name";
    @Ignore
    public static final String TAG_LAT = "latitude";
    @Ignore
    public static final String TAG_LONG = "longitude";
    @Ignore
    public static final String TAG_E_ADDRESS = "address";
    @Ignore
    public static final String TAG_CONTACT_NO = "contact_no";
    @Ignore
    public static final String TAG_IMAGE_URL = "img_url";
    @Ignore
    public static final String TAG_QR_CODE_URL = "qr_code";
    @Ignore
    public static final String TAG_RATING = "rating";
    @Ignore
    public static final String TAG_ROUTES   = "establishment_route";
    @Ignore
    public static final String TAG_ROUTE   = "routes";
    @Ignore
    public static final String TAG_DIR   = "directions";
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    @PrimaryKey
    private int id;
    private int category_id;
    private String establishment_name;
    private double latitude;
    private double longitude;
    private String establishment_addr;
    private String contact_no;
    private String img_url;
    private String qr_code;
    private double rating;
    private String establishment_route;
    private String directions;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Method=========================================
    //-----------------------------------------------Getter-----------------------------------------

    public int getId() {
        return id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getEstablishment_name() {
        return establishment_name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getEstablishment_addr() {
        return establishment_addr;
    }

    public String getContact_no() {
        return contact_no;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getQr_code() {
        return qr_code;
    }

    public double getRating() {
        return rating;
    }

    public String getEstablishment_route() {
        return establishment_route;
    }

    public String getDirections() {
        return directions;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Setter-----------------------------------------

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setEstablishment_name(String establishment_name) {
        this.establishment_name = establishment_name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setEstablishment_addr(String establishment_addr) {
        this.establishment_addr = establishment_addr;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setEstablishment_route(String establishment_route) {
        this.establishment_route = establishment_route;
    }

    public void setDirections(String directions) {
        this.directions = directions;
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
        return establishment_name;
    }
    @Override
    public String getMeshDescription() {
        return establishment_addr;
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
        return img_url;
    }
    //==============================================================================================
}
