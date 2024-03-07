package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshCompany extends RealmObject implements MeshObjectInterface
{
    //=========================================Variable=============================================
    //-----------------------------------------Constant---------------------------------------------
    @Ignore
    public static final String TAG_ID               = "id";
    @Ignore
    public static final String TAG_COMPANY_NAME     = "company_name";
    @Ignore
    public static final String TAG_COMPANY_ADDRESS  = "company_address";
    @Ignore
    public static final String TAG_CONTACT          = "company_contact";
    @Ignore
    public static final String TAG_DISCOUNT         = "discount";
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------Instance---------------------------------------------
    @PrimaryKey
    private int id;
    private String company_name;
    private String company_address;
    private String company_contact;
    private Double discount;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================Method===============================================
    //-----------------------------------------Setter-----------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setCompanyName(String companyName) {
        this.company_name = companyName;
    }
    public void setCompanyAddress(String companyAddress) {
        this.company_address = companyAddress;
    }
    public void setCompanyContact(String companyContact) {
        this.company_contact = companyContact;
    }
    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------Getter-----------------------------------------------
    public int getId() {
        return id;
    }
    public String getCompanyName() {
        return company_name;
    }
    public String getCompanyAddress() {
        return company_address;
    }
    public String getCompanyContact() {
        return company_contact;
    }
    public Double getDiscount() {
        return discount;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================================================================
    //--------------------------------------MeshObjectInterface-------------------------------------
    @Override
    public int getMeshID() {
        return id;
    }
    @Override
    public String getMeshLabel() {
        return company_name;
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
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
