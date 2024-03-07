package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshCity extends RealmObject implements MeshObjectInterface
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    @Ignore
    public static final String TAG = MeshCity.class.getSimpleName();
    @Ignore
    public static final String TAG_CONT_ID          = "cont_id";
    @Ignore
    public static final String TAG_COUNTRY          = "cntry";
    @Ignore
    public static final String TAG_COUNTRY_CODE     = "cntry_code";
    @Ignore
    public static final String TAG_CODE             = "code";
    @Ignore
    public static final String TAG_DST              = "dst";
    @Ignore
    public static final String TAG_ID               = "id";
    @Ignore
    public static final String TAG_NAME             = "name";
    @Ignore
    public static final String TAG_TZONE            = "tzone";
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    @PrimaryKey
    private int id;
    private int cont_id;
    private String name;
    private String cntry;
    private String cntry_code;
    private String code;
    private boolean dst;
    private String tzone;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    public int getId() {
        return id;
    }
    public int getCont_id() {
        return cont_id;
    }
    public String getName() {
        return name;
    }
    public String getCntry() {
        return cntry;
    }
    public String getCntry_code() {
        return cntry_code;
    }
    public String getCode() {
        return code;
    }
    public boolean isDst() {
        return dst;
    }
    public String getTzone() {
        return tzone;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setCont_id(int cont_id) {
        this.cont_id = cont_id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCntry(String cntry) {
        this.cntry = cntry;
    }
    public void setCntry_code(String cntry_code) {
        this.cntry_code = cntry_code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setDst(boolean dst) {
        this.dst = dst;
    }
    public void setTzone(String tzone) {
        this.tzone = tzone;
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
        return name;
    }
    @Override
    public String getMeshDescription() {
        return cntry;
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
