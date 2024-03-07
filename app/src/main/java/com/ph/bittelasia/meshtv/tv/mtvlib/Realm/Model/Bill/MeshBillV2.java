package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Bill;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;


public class MeshBillV2 extends RealmObject
{
    //==========================================Variable============================================
    //------------------------------------------Constant--------------------------------------------
    @Ignore
    public static final String TAG = MeshBillV2.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_DC = "dc";
    @Ignore
    public static final String TAG_BI = "price";
    @Ignore
    public static final String TAG_BD = "item";
    @Ignore
    public static final String TAG_FN = "fn";
    @Ignore
    public static final String TAG_DA = "da";
    @Ignore
    public static final String TAG_TI = "ti";
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------Instance---------------------------------------------
    @PrimaryKey
    private int id;
    private int dc;
    private double price;
    private String item;
    private int fn;
    private double da;
    private double ti;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================Method==============================================
    //------------------------------------------Getter----------------------------------------------
    public int getId() {
        return id;
    }
    public int getDc() {
        return dc;
    }
    public double getPrice() {
        return price;
    }
    public String getItem() {
        return item;
    }
    public int getFn() {
        return fn;
    }
    public double getDa() {
        return da;
    }
    public double getTi() {
        return ti;
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Setter----------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setDc(int dc) {
        this.dc = dc;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public void setFn(int fn) {
        this.fn = fn;
    }
    public void setDa(double da) {
        this.da = da;
    }
    public void setTi(double ti) {
        this.ti = ti;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
