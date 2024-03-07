package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshTelecomBill extends RealmObject implements MeshObjectInterface
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    @Ignore
    public static final String TAG                  = MeshTelecomBill.class.getSimpleName();
    @Ignore
    public static final String CLASS_NAME           = "get_account_bill";
    @Ignore
    public static final String TAG_ID               = "bill_id";
    @Ignore
    public static final String TAG_ADDRESS          = "address";
    @Ignore
    public static final String TAG_ACCOUNT_NO       = "account_number";
    @Ignore
    public static final String TAG_ACCOUNT_NAME     = "account_name";
    @Ignore
    public static final String TAG_BALANCE          = "balance";
    @Ignore
    public static final String TAG_OUTLET_FEE       = "outlet_fee";
    @Ignore
    public static final String TAG_MAINTENANCE_FEE  = "maintenance_fee";
    @Ignore
    public static final String TAG_SUBSCRIPTION_FEE = "subscription_fee";
    @Ignore
    public static final String TAG_INTERNET_FEE     = "internet_fee";
    @Ignore
    public static final String TAG_PHONE_FEE        = "phone_fee";
    @Ignore
    public static final String TAG_BANDWIDTH_FEE    = "bandwidth_fee";
    @Ignore
    public static final String TAG_BILL_START       = "billing_start";
    @Ignore
    public static final String TAG_BILL_END         = "billing_end";
    @Ignore
    public static final String TAG_PAYMENT          = "payment_received";
    @Ignore
    public static final String TAG_ANNOUNCEMENT     = "announcement";
    @Ignore
    public static final String TAG_YEAR             = "year";
    @Ignore
    public static final String TAG_PACKAGELIST             = "package_list";
    @Ignore
    public static final String DATE_FORMAT          = "yyyy-MM-dd kk:mm:ss";
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    @PrimaryKey
    int bill_id;
    String account_number;
    String account_name;
    String address;
    String package_list;
    double balance;
    double outlet_fee;
    double maintenance_fee;
    double subscription_fee;
    double internet_fee;
    double phone_fee;
    double bandwidth_fee;
    String billing_start;
    String billing_end;
    String announcement;
    double payment_received;
    int year;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=================================================Method=======================================
    //-------------------------------------------------Getter---------------------------------------
    public int getBill_id() {
        return bill_id;
    }
    public String getAccount_number() {
        return account_number;
    }
    public String getAccount_name() {
        return account_name;
    }
    public String getAddress() {
        return address;
    }
    public double getBalance() {
        return balance;
    }
    public double getOutlet_fee() {
        return outlet_fee;
    }
    public double getMaintenance_fee() {
        return maintenance_fee;
    }
    public double getSubscription_fee() {
        return subscription_fee;
    }
    public double getInternet_fee() {
        return internet_fee;
    }
    public double getPhone_fee() {
        return phone_fee;
    }
    public double getBandwidth_fee() {
        return bandwidth_fee;
    }
    public String getBilling_start() {
        return billing_start;
    }
    public String getBilling_end() {
        return billing_end;
    }
    public double getPayment_received() {
        return payment_received;
    }
    public int getYear() {
        return year;
    }
    public String getAnnouncement() {
        return announcement;
    }

    public String getPackage_list() {
        return package_list;
    }



    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------Setter---------------------------------------
    public void setPackage_list(String package_list) {
        this.package_list = package_list;
    }
    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }
    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }
    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setOutlet_fee(double outlet_fee) {
        this.outlet_fee = outlet_fee;
    }
    public void setMaintenance_fee(double maintenance_fee) {
        this.maintenance_fee = maintenance_fee;
    }
    public void setSubscription_fee(double subscription_fee) {
        this.subscription_fee = subscription_fee;
    }
    public void setInternet_fee(double internet_fee) {
        this.internet_fee = internet_fee;
    }
    public void setPhone_fee(double phone_fee) {
        this.phone_fee = phone_fee;
    }
    public void setBandwidth_fee(double bandwidth_fee) {
        this.bandwidth_fee = bandwidth_fee;
    }
    public void setBilling_start(String billing_start) {
        this.billing_start = billing_start;
    }
    public void setBilling_end(String billing_end) {
        this.billing_end = billing_end;
    }
    public void setPayment_received(double payment_received) {
        this.payment_received = payment_received;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================MeshObjectInterface===============================
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
