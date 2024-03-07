package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model;


import android.content.Context;
import android.os.AsyncTask;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Manager.MeshTVDataManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.UpdateTask.CompareGuestTask;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

import org.json.JSONObject;

/**
 * Provides easy management of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.GuestPreference GuestPreference}
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshGuest
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG              = MeshGuest.class.getSimpleName();
    /**
     * Tag for retrieving {@link #firstname firstname} from JSONObject
     */
    public static final String TAG_FIRSTNAME    = "firstname";
    /**
     * Tag for retrieving {@link #lastname lastname} from JSONObject
     */
    public static final String TAG_LASTNAME     = "lastname";
    /**
     * Tag for retrieving {@link #birthDate birthDate} from JSONObject
     */
    public static final String TAG_BIRTHDATE    = "birthdate";
    /**
     * Tag for retrieving {@link #address address} from JSONObject
     */
    public static final String TAG_HOME_ADDR1   = "home_addr1";
    /**
     * Tag for retrieving {@link #city city} from JSONObject
     */
    public static final String TAG_HOME_ADDR2   = "home_addr2";
    /**
     * Tag for retrieving {@link #country country} from JSONObject
     */
    public static final String TAG_HOME_ADDR3   = "home_addr3";

    /**
     * Tag for retrieving {@link #postal postal} from JSONObject
     */
    public static final String TAG_HOME_ADDR4   = "home_addr4";
    /**
     * Tag for retrieving {@link #mobile mobile} from JSONObject
     */
    public static final String TAG_MOBILE_NO    = "mobile_no";
    /**
     * Tag for retrieving {@link #landline landline} from JSONObject
     */
    public static final String TAG_LANDLINE_NO  = "landline_no";
    /**
     * Tag for retrieving {@link #email email} from JSONObject
     */
    public static final String TAG_EMAIL        = "email";
    /**
     * Date format used for this object
     */
    public static final String DATE_FORMAT      = "yyyy-MM-dd";
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Instance--------------------------------------
    /**
     * First name of the Guest
     */
    String firstname;
    /**
     * Last name of the Guest
     */
    String lastname;
    /**
     * Birthdate of the guest following the format of {@link #DATE_FORMAT DATE_FORMAT}
     */
    String birthDate;
    /**
     * Address of the guest
     */
    String address;
    /**
     * City the guest is residing
     */
    String city;
    /**
     * Country of origin of the guest
     */
    String country;
    /**
     * Postal code of the guest
     */
    String postal;
    /**
     * Mobile number of the guest
     */
    String mobile;
    /**
     * Landline number of the guest
     */
    String landline;
    /**
     * Email address of the guest
     */
    String email;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Constructor=====================================

    /**
     * Constructor that sets all data to the value of - uses application context to access preferences
     * {@link MeshGuest MeshGuest}
     */
    public MeshGuest()
    {
        firstname = MeshTVPreferenceManager.getGuestFirstName(null);
        lastname = MeshTVPreferenceManager.getGuestLastName(null);
        birthDate = MeshTVPreferenceManager.getGuestBirthDate(null);
        address =MeshTVPreferenceManager.getGuestAddress(null);
        city = MeshTVPreferenceManager.getGuestCity(null);
        country = MeshTVPreferenceManager.getGuestCountry(null);
        postal = MeshTVPreferenceManager.getGuestPostal(null);
        mobile = MeshTVPreferenceManager.getGuestMobile(null);
        landline = MeshTVPreferenceManager.getGuestLandline(null);
        email = MeshTVPreferenceManager.getGuestEmail(null);
    }

    /**
     * Constructor that sets all data to the value of
     * @param c required to access preferences
     */
    public MeshGuest(Context c)
    {
        firstname = MeshTVPreferenceManager.getGuestFirstName(c);
        lastname = MeshTVPreferenceManager.getGuestLastName(c);
        birthDate = MeshTVPreferenceManager.getGuestBirthDate(c);
        address =MeshTVPreferenceManager.getGuestAddress(c);
        city = MeshTVPreferenceManager.getGuestCity(c);
        country = MeshTVPreferenceManager.getGuestCountry(c);
        postal = MeshTVPreferenceManager.getGuestPostal(c);
        mobile = MeshTVPreferenceManager.getGuestMobile(c);
        landline = MeshTVPreferenceManager.getGuestLandline(c);
        email = MeshTVPreferenceManager.getGuestEmail(c);
    }
    /**
     * Parses "data" field from a JSON obtained from Datasource to instantiate a {@link MeshGuest MeshGuest} object
     * @param data contents of data field from a JSON whose class is get_customer
     */
    public MeshGuest(String data)
    {
        try
        {
            JSONObject object = new JSONObject(data);
            firstname = object.getString(TAG_FIRSTNAME);
            lastname = object.getString(TAG_LASTNAME);
            birthDate = object.getString(TAG_BIRTHDATE);
            address = object.getString(TAG_HOME_ADDR1);
            city = object.getString(TAG_HOME_ADDR2);
            country = object.getString(TAG_HOME_ADDR3);
            postal = object.getString(TAG_HOME_ADDR4);
            mobile = object.getString(TAG_MOBILE_NO);
            landline = object.getString(TAG_LANDLINE_NO);
            email = object.getString(TAG_EMAIL);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //==============================================================================================
    //=================================================Method=======================================
    //-------------------------------------------------Action---------------------------------------

    /**
     * Request data from a DataSource and listens for the response using a {@link MeshDataListener MeshDataListener}
     * @param listener
     */
    public final void refresh(MeshDataListener listener)
    {
        MeshTVDataManager.requestData(MeshGuest.class,listener);
    }

    /**
     * Triggers {@link MeshTVApp#updateGuest(MeshGuest) MeshTVApp.updateGuest(MeshGuest)} to notify all listeners
     */
    public final void display()
    {
        MeshTVApp.get().updateGuest(this);
    }
    /**
     * Asynchronously compares this instance to the data from {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.GuestPreference GuestPreference}
     */
    public final void compare()
    {
        new CompareGuestTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
    /**
     * Saves the fields of this instance as the new value for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.GuestPreference GuestPreference}
     */
    public final void update()
    {
        try
        {
            MeshTVPreferenceManager.setGuestFirstName(null,firstname);
            MeshTVPreferenceManager.setGuestLastName(null,lastname);
            MeshTVPreferenceManager.setGuestAddress(null,address);
            MeshTVPreferenceManager.setGuestBirthDate(null,birthDate);
            MeshTVPreferenceManager.setGuestCity(null,city);
            MeshTVPreferenceManager.setGuestCountry(null,country);
            MeshTVPreferenceManager.setGuestPostal(null,postal);
            MeshTVPreferenceManager.setGuestEmail(null,email);
            MeshTVPreferenceManager.setGuestMobile(null,mobile);
            MeshTVPreferenceManager.setGuestLandline(null,landline);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Saves the fields of this instance as the new value for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.GuestPreference GuestPreference}
     * @param c - required to access preferences
     */
    public final void update(Context c)
    {
        try
        {
            MeshTVPreferenceManager.setGuestFirstName(c,firstname);
            MeshTVPreferenceManager.setGuestLastName(c,lastname);
            MeshTVPreferenceManager.setGuestAddress(c,address);
            MeshTVPreferenceManager.setGuestBirthDate(c,birthDate);
            MeshTVPreferenceManager.setGuestCity(c,city);
            MeshTVPreferenceManager.setGuestCountry(c,country);
            MeshTVPreferenceManager.setGuestPostal(c,postal);
            MeshTVPreferenceManager.setGuestEmail(c,email);
            MeshTVPreferenceManager.setGuestMobile(c,mobile);
            MeshTVPreferenceManager.setGuestLandline(c,landline);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------Getter---------------------------------------

    /**
     * Concatenates {@link #firstname firstname} and {@link #lastname lastname}
     * @return Result of concatenation
     */
    public final String getName() {
        String result = "";
        String tempFirstname = "";
        String tempLastname = "";
        if ((firstname + " " + lastname).length() > 20) {
            tempFirstname = firstname.substring(0,1).toUpperCase() + ".";
        }
        else
        {
            return firstname+" "+lastname;
        }
        if ((tempFirstname +" "+ lastname).length() > 20)
        {
            return (tempFirstname +" "+ lastname).substring(0,19);
        }
        else
        {
            return tempFirstname +" "+ lastname;
        }
    }
    /**
     * Returns {@link #firstname firstname}
     * @return {@link #firstname firstname}
     */
    public final String getFirstname() {
        return firstname;
    }
    /**
     * Returns {@link #lastname lastname}
     * @return {@link #lastname lastname}
     */
    public final String getLastname() {
        return lastname;
    }
    /**
     * Returns {@link #birthDate birthDate}
     * @return {@link #birthDate birthDate}
     */
    public final String getBirthDate() {
        return birthDate;
    }
    /**
     * Returns {@link #address address}
     * @return {@link #address address}
     */
    public final String getAddress() {
        return address;
    }
    /**
     * Returns {@link #city city}
     * @return {@link #city city}
     */
    public final String getCity() {
        return city;
    }
    /**
     * Returns {@link #country country}
     * @return {@link #country country}
     */
    public final String getCountry() {
        return country;
    }
    /**
     * Returns {@link #postal postal}
     * @return {@link #postal postal}
     */
    public final String getPostal() {
        return postal;
    }
    /**
     * Returns {@link #mobile mobile}
     * @return {@link #mobile mobile}
     */
    public final String getMobile() {
        return mobile;
    }
    /**
     * Returns {@link #landline landline}
     * @return {@link #landline landline}
     */
    public final String getLandline() {
        return landline;
    }
    /**
     * Returns {@link #email email}
     * @return {@link #email email}
     */
    public final String getEmail() {
        return email;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------Setter---------------------------------------
    /**
     * Sets new value for {@link #firstname firstname}
     * @param firstname new value for {@link #firstname firstname}
     */
    public final void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    /**
     * Sets new value for {@link #lastname lastname}
     * @param lastname new value for {@link #lastname lastname}
     */
    public final void setLastname(String lastname) {
        this.lastname = lastname;
    }
    /**
     * Sets new value for {@link #birthDate birthDate}
     * @param birthDate new value for {@link #birthDate birthDate}
     */
    public final void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    /**
     * Sets new value for {@link #address address}
     * @param address new value for {@link #address address}
     */
    public final void setAddress(String address) {
        this.address = address;
    }
    /**
     * Sets new value for {@link #city city}
     * @param city new value for {@link #city city}
     */
    public final void setCity(String city) {
        this.city = city;
    }
    /**
     * Sets new value for {@link #country country}
     * @param country new value for {@link #country country}
     */
    public final void setCountry(String country) {
        this.country = country;
    }
    /**
     * Sets new value for {@link #postal postal}
     * @param postal new value for {@link #postal postal}
     */
    public final void setPostal(String postal) {
        this.postal = postal;
    }
    /**
     * Sets new value for {@link #mobile mobile}
     * @param mobile new value for {@link #mobile mobile}
     */
    public final void setMobile(String mobile) {
        this.mobile = mobile;
    }
    /**
     * Sets new value for {@link #landline landline}
     * @param landline new value for {@link #landline landline}
     */
    public final void setLandline(String landline) {
        this.landline = landline;
    }
    /**
     * Sets new value for {@link #email email}
     * @param email new value for {@link #email email}
     */
    public final void setEmail(String email) {
        this.email = email;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
