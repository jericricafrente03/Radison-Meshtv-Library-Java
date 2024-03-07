package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model;

import android.os.AsyncTask;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Manager.MeshTVDataManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.UpdateTask.CompareGuestTask;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.UpdateTask.CompareSubscriberTask;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

import org.json.JSONObject;

/**
 * @author Mars Ray Canizares Araullo
 * @version 2.0
 */
public class MeshSubscriber
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshSubscriber.class.getSimpleName();
    public static final String CLASS_NAME = "get_subscriber";
    public static final String TAG_ACCOUNT_ID = "account_id";
    public static final String TAG_TITLE = "title";
    public static final String TAG_LASTNAME = "lastname";
    public static final String TAG_MIDDLENAME = "middlename";
    public static final String TAG_FIRSTNAME = "firstname";
    public static final String TAG_CONTACT_NO = "contact_no";
    public static final String TAG_MOBILE_NO = "mobile_no";
    public static final String TAG_EMAIL = "email";
    public static final String TAG_HOUSE_NO = "house_no";
    public static final String TAG_SUBDIVISION = "subdivision";
    public static final String TAG_BARANGAY = "barangay";
    public static final String TAG_CITY = "city";
    public static final String TAG_COUNTRY_CODE = "country_code";
    public static final String TAG_POSTAL_CODE = "postal_code";
    public static final String TAG_STATUS = "status";
    public static final String TAG_PROVINCE = "province";
    public static final int STATUS_ENABLED = 1;
    public static final int STATUS_DISABLED = 0;
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    String account_id;
    String title;
    String lastname;
    String firstname;
    String middlename;
    String contact_no;
    String mobile_no;
    String email;
    String house_no;
    String subdivision;
    String barangay;
    String city;
    String country_code;
    String postal_code;
    String province;
    int status;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================Constructor=========================================
    public MeshSubscriber()
    {
        account_id = MeshTVPreferenceManager.getAccountID(null);
        title= MeshTVPreferenceManager.getAccountTitle(null);
        lastname= MeshTVPreferenceManager.getAccountLastname(null);
        firstname= MeshTVPreferenceManager.getAccountFirstname(null);
        middlename= MeshTVPreferenceManager.getAccountMiddlename(null);
        contact_no= MeshTVPreferenceManager.getAccountContactNo(null);
        mobile_no= MeshTVPreferenceManager.getAccountMobileNo(null);
        email= MeshTVPreferenceManager.getAccountEmailaddress(null);
        house_no= MeshTVPreferenceManager.getAccountHouseNo(null);
        subdivision= MeshTVPreferenceManager.getAccountSubdivision(null);
        barangay= MeshTVPreferenceManager.getAccountBarangay(null);
        city= MeshTVPreferenceManager.getAccountCity(null);
        country_code= MeshTVPreferenceManager.getAccountCountryCode(null);
        province = MeshTVPreferenceManager.getProvince(null);
        postal_code= MeshTVPreferenceManager.getAccountPostalCode(null);
        status= MeshTVPreferenceManager.getAccountStatus(null);
    }
    public MeshSubscriber(String data)
    {
        try
        {
            Log.i(TAG,"DATA:"+data);
            JSONObject object = new JSONObject(data);
            Log.i(TAG,"DATA:"+object.getInt(MeshSubscriber.TAG_STATUS));
            account_id = object.getString(MeshSubscriber.TAG_ACCOUNT_ID);
            title = object.getString(MeshSubscriber.TAG_TITLE);
            lastname = object.getString(MeshSubscriber.TAG_LASTNAME);
            firstname = object.getString(MeshSubscriber.TAG_FIRSTNAME);
            middlename = object.getString(MeshSubscriber.TAG_MIDDLENAME);
            contact_no = object.getString(MeshSubscriber.TAG_CONTACT_NO);
            mobile_no = object.getString(MeshSubscriber.TAG_MOBILE_NO);
            email = object.getString(MeshSubscriber.TAG_EMAIL);
            house_no = object.getString(MeshSubscriber.TAG_HOUSE_NO);
            subdivision = object.getString(MeshSubscriber.TAG_SUBDIVISION);

            province = object.getString(MeshSubscriber.TAG_PROVINCE);
            barangay = object.getString(MeshSubscriber.TAG_BARANGAY);
            city = object.getString(MeshSubscriber.TAG_CITY);
            country_code = object.getString(MeshSubscriber.TAG_COUNTRY_CODE);
            postal_code = object.getString(MeshSubscriber.TAG_POSTAL_CODE);
            status = object.getInt(MeshSubscriber.TAG_STATUS);
    }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //==============================================================================================
    //============================================Method============================================
    //--------------------------------------------Action--------------------------------------------
    public void updatePreference()
    {
        MeshTVPreferenceManager.setAccountID(null,account_id);
        MeshTVPreferenceManager.setAccountTitle(null,title);
        MeshTVPreferenceManager.setAccountLastname(null,lastname);
        MeshTVPreferenceManager.setAccountFirstname(null,firstname);
        MeshTVPreferenceManager.setAccountMiddlename(null,middlename);
        MeshTVPreferenceManager.setAccountContactNo(null,contact_no);
        MeshTVPreferenceManager.setAccountMobileNo(null,mobile_no);
        MeshTVPreferenceManager.setAccountEmailAddress(null,email);
        MeshTVPreferenceManager.setAccountHouseNo(null,house_no);
        MeshTVPreferenceManager.setAccountSubdivision(null,subdivision);
        MeshTVPreferenceManager.setAccountBarangay(null,barangay);
        MeshTVPreferenceManager.setAccountCity(null,city);
        MeshTVPreferenceManager.setAccountCountryCode(null,country_code);
        MeshTVPreferenceManager.setProvince(null,province);
        MeshTVPreferenceManager.setAccountPostalCode(null,postal_code);
        MeshTVPreferenceManager.setAccountStatus(null,status);
    }
    public final void updateListeners()
    {
        MeshTVApp.get().updateSubscriber();
    }
    public final void enable()
    {
        MeshTVApp.get().onEnableSubscription();
    }
    public final void disable()
    {
        MeshTVApp.get().onDisableSubscription();
    }
    public final void refresh(MeshDataListener listener)
    {
        MeshTVDataManager.requestData(MeshSubscriber.class,listener);
    }
    public final void compare()
    {
        new CompareSubscriberTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Getter--------------------------------------------
    public String getAccount_id() {
        return account_id;
    }
    public String getTitle() {
        return title;
    }
    public String getLastname() {
        return lastname;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getMiddlename() {
        return middlename;
    }
    public String getContact_no() {
        return contact_no;
    }
    public String getMobile_no() {
        return mobile_no;
    }
    public String getEmail() {
        return email;
    }
    public String getHouse_no() {
        return house_no;
    }
    public String getSubdivision() {
        return subdivision;
    }
    public String getBarangay() {
        return barangay;
    }
    public String getCity() {
        return city;
    }
    public String getCountry_code() {
        return country_code;
    }
    public String getPostal_code() {
        return postal_code;
    }
    public int getStatus() {
        return status;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Setter--------------------------------------------
    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }
    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }
    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setHouse_no(String house_no) {
        this.house_no = house_no;
    }
    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }
    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }
    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
