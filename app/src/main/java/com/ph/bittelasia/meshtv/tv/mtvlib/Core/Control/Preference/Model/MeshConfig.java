package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model;

import android.os.AsyncTask;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Manager.MeshTVDataManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.UpdateTask.CompareConfigTask;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

import org.json.JSONObject;

/**
 * Provides easy management of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelPreference HotelPreference}
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshConfig
{
    //===============================================Variable=======================================
    //-----------------------------------------------Constant---------------------------------------
    public static final String TAG                      = MeshConfig.class.getSimpleName();
    /**
     * Tag for retrieving {@link #hotel_name hotel_name} from a JSONObject
     */
    public static final String TAG_NAME                 = "hotel_name";
    /**
     * Tag for retrieving {@link #hotel_street hotel_street} from a JSONObject
     */
    public static final String TAG_STREET               = "hotel_street";
    /**
     * Tag for retrieving {@link #hotel_city hotel_city} from a JSONObject
     */
    public static final String TAG_CITY                 = "hotel_city";
    /**
     * Tag for retrieving {@link #hotel_country hotel_country} from a JSONObject
     */
    public static final String TAG_COUNTRY              = "hotel_country";
    /**
     * Tag for retrieving {@link #hotel_timezone_id hotel_timezone_id} from a JSONObject
     */
    public static final String TAG_TIMEZONE             = "hotel_timezone_id";
    /**
     * Tag for retrieving {@link #hotel_email hotel_email} from a JSONObject
     */
    public static final String TAG_EMAIL                = "hotel_email";
    /**
     * Tag for retrieving {@link #hotel_currency hotel_currency} from a JSONObject
     */
    public static final String TAG_CURRENCY             = "hotel_currency";
    /**
     * Tag for retrieving {@link #hotel_website hotel_website} from a JSONObject
     */
    public static final String TAG_WEBSITE              = "hotel_website";
    /**
     * Tag for retrieving {@link #hotel_logo hotel_logo} from a JSONObject
     */
    public static final String TAG_LOGO                 = "hotel_logo";
    /**
     * Tag for retrieving {@link #hotel_map_coord hotel_map_coord} from a JSONObject
     */
    public static final String TAG_MAP_COORD            = "hotel_map_coord";
    /**
     * Tag for retrieving {@link #hotel_weather_id hotel_weather_id} from a JSONObject
     */
    public static final String TAG_MAP_WEATHER_ID       = "hotel_weather_id";
    /**
     * Tag for retrieving {@link #hotel_welcome_message hotel_welcome_message} from a JSONObject
     */
    public static final String TAG_WELCOME_MESSAGE      = "welcome_message";
    /**
     * Tag for retrieving {@link #hotel_reservation_message hotel_reservation_message} from a JSONObject
     */
    public static final String TAG_RESERVATION_MESSAGE  = "reservation_message";
    /**
     * Tag for retrieving {@link #hotel_service_request_message hotel_service_request_message} from a JSONObject
     */
    public static final String TAG_SERVICE_MESSAGE      = "service_request_message";
    /**
     * Tag for retrieving {@link #hotel_checkout_message hotel_checkout_message} from a JSONObject
     */
    public static final String TAG_CHECKOUT_MESSAGE     = "checkout_message";
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Instance---------------------------------------
    /**
     * Name of the hotel
     */
    private String hotel_name = "";
    /**
     * Street the hotel is situated
     */
    private String hotel_street = "";
    /**
     * City the hotel os resides
     */
    private String hotel_city = "";
    /**
     * Country the hotel resides (Basis for weather data)
     */
    private String hotel_country = "";
    /**
     * Timezone of the hotel
     */
    private String hotel_timezone_id = "";
    /**
     * Official email of the hotel
     */
    private String hotel_email = "";
    /**
     * Currency to be used in the hotel (Currency will be used on all purchases and transactions)
     */
    private String hotel_currency = "";
    /**
     * Official website of the hotel
     */
    private String hotel_website = "";
    /**
     * URL of the current logo the hotel wants to display on the IPTV
     */
    private String hotel_logo = "";
    /**
     * Location of the hotel for geo mapping
     */
    private String hotel_map_coord = "";
    /**
     * Weather ID (No Particular Use Yet)
     */
    private String hotel_weather_id = "";
    /**
     * Could displayed for new guests
     */
    private String hotel_welcome_message = "";
    /**
     * Reservation Message (No Particular Use Yet)
     */
    private String hotel_reservation_message = "";
    /**
     * Service Message (No Particular Use Yet)
     */
    private String hotel_service_request_message = "";
    /**
     * Checkout Message (No Particular Use Yet)
     */
    private String hotel_checkout_message = "";
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Constructor====================================
    /**
     * Constructor that sets all data to the values of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelPreference HotelPreference}
     */
    public MeshConfig()
    {
        hotel_name = MeshTVPreferenceManager.getHotelName(  null);
        hotel_street =  MeshTVPreferenceManager.getHotelStreet(null);
        hotel_city =  MeshTVPreferenceManager.getHotelCity(null);
        hotel_country =  MeshTVPreferenceManager.getHotelCountry(null);
        hotel_timezone_id =  MeshTVPreferenceManager.getHotelTimezone(null);
        hotel_email =  MeshTVPreferenceManager.getHotelEmail(null);
        hotel_currency =  MeshTVPreferenceManager.getHotelCurrency(null);
        hotel_website =  MeshTVPreferenceManager.getHotelWebsite(null);
        hotel_logo =   MeshTVPreferenceManager.getHotelLogo(null);
        hotel_map_coord =   MeshTVPreferenceManager.getHotelCoord(null);
        hotel_weather_id =  MeshTVPreferenceManager.getWeatherID(null);
        hotel_welcome_message =  MeshTVPreferenceManager.getWelcomeMessage(null);
        hotel_reservation_message =  MeshTVPreferenceManager.getReservationMessage(null);
        hotel_service_request_message =  MeshTVPreferenceManager.getServiceMessage(null);
        hotel_checkout_message =  MeshTVPreferenceManager.getCheckOutMessage(null);
    }

    /**
     * Parses "data" field from a JSON obtained from Datasource to instantiate a {@link MeshConfig MeshConfig} object
     * @param data contents of data field from a JSON whose class is get_config
     */
    public MeshConfig(String data)
    {
        try
        {
            JSONObject object = new JSONObject(data);
            hotel_name = object.getString(TAG_NAME);
            hotel_street = object.getString(TAG_STREET);
            hotel_city = object.getString(TAG_CITY);
            hotel_country = object.getString(TAG_COUNTRY);
            hotel_timezone_id = object.getString(TAG_TIMEZONE);
            hotel_email = object.getString(TAG_EMAIL);
            hotel_currency = object.getString(TAG_CURRENCY);
            hotel_website = object.getString(TAG_WEBSITE);
            hotel_logo =  object.getString(TAG_LOGO);
            hotel_map_coord =  object.getString(TAG_MAP_COORD);
            hotel_weather_id =  object.getString(TAG_MAP_WEATHER_ID);
            hotel_welcome_message =  object.getString(TAG_WELCOME_MESSAGE+"");
            hotel_reservation_message =  object.getString(TAG_RESERVATION_MESSAGE+"");
            hotel_service_request_message =  object.getString(TAG_SERVICE_MESSAGE+"");
            hotel_checkout_message =  object.getString(TAG_CHECKOUT_MESSAGE+"");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //==============================================================================================
    //================================================Method========================================
    //------------------------------------------------Action----------------------------------------
    /**
     * Requests data from a DataSource and listens for the response using a {@link MeshDataListener MeshDataListener}
     * @param listener
     */
    public final void refresh(MeshDataListener listener)
    {
        MeshTVDataManager.requestData(MeshConfig.class,listener);
    }

    /**
     * Triggers {@link MeshTVApp#updateConfig(MeshConfig) MeshTVApp.updateConfig(MeshConfig)} to notify all listeners
     */
    public final void display()
    {
        MeshTVApp.get().updateConfig(this);
    }

    /**
     * Asynchronously compares this instance to the data from {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelPreference HotelPreference}
     */
    public final void compare()
    {
        new CompareConfigTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }

    /**
     * Saves the fields of this instance as the new value for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelPreference HotelPreference}
     */
    public final void update()
    {
        try
        {
            MeshTVPreferenceManager.setHotelName(null,hotel_name);
            MeshTVPreferenceManager.setHotelCity(null,hotel_city);
            MeshTVPreferenceManager.setHotelStreet(null,hotel_street);
            MeshTVPreferenceManager.setHotelCountry(null,hotel_country);
            MeshTVPreferenceManager.setHotelTimezone(null,hotel_timezone_id);
            MeshTVPreferenceManager.setHotelEmail(null,hotel_email);
            MeshTVPreferenceManager.setHotelCurrency(null,hotel_currency);
            MeshTVPreferenceManager.setHotelWebsite(null,hotel_website);
            MeshTVPreferenceManager.setHotelLogo(null,hotel_logo);
            MeshTVPreferenceManager.setHotelCoord(null,hotel_map_coord);
            MeshTVPreferenceManager.setWeatherID(null,hotel_weather_id);
            MeshTVPreferenceManager.setWelcomeMessage(null,hotel_welcome_message);
            MeshTVPreferenceManager.setReservationMessage(null,hotel_reservation_message);
            MeshTVPreferenceManager.setServiceMessage(null,hotel_service_request_message);
            MeshTVPreferenceManager.setCheckOutMessage(null,hotel_checkout_message);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Getter----------------------------------------
    /**
     * Returns {@link #hotel_name hotel_name}
     * @return {@link #hotel_name hotel_name}
     */
    public String getHotel_name() {
        return hotel_name;
    }
    /**
     * Returns {@link #hotel_street hotel_street}
     * @return {@link #hotel_street hotel_street}
     */
    public String getHotel_street() {
        return hotel_street;
    }
    /**
     * Returns {@link #hotel_city hotel_city}
     * @return {@link #hotel_city hotel_city}
     */
    public String getHotel_city() {
        return hotel_city;
    }
    /**
     * Returns {@link #hotel_country hotel_country}
     * @return {@link #hotel_country hotel_country}
     */
    public String getHotel_country() {
        return hotel_country;
    }
    /**
     * Returns {@link #hotel_timezone_id hotel_timezone_id}
     * @return {@link #hotel_timezone_id hotel_timezone_id}
     */
    public String getHotel_timezone_id() {
        return hotel_timezone_id;
    }
    /**
     * Returns {@link #hotel_email hotel_email}
     * @return {@link #hotel_email hotel_email}
     */
    public String getHotel_email() {
        return hotel_email;
    }
    /**
     * Returns {@link #hotel_currency hotel_currency}
     * @return {@link #hotel_currency hotel_currency}
     */
    public String getHotel_currency() {
        return hotel_currency;
    }
    /**
     * Returns {@link #hotel_website hotel_website}
     * @return {@link #hotel_website hotel_website}
     */
    public String getHotel_website() {
        return hotel_website;
    }
    /**
     * Returns {@link #hotel_logo hotel_logo}
     * @return {@link #hotel_logo hotel_logo}
     */
    public String getHotel_logo() {
        return hotel_logo;
    }
    /**
     * Returns {@link #hotel_map_coord hotel_map_coord}
     * @return {@link #hotel_map_coord hotel_map_coord}
     */
    public String getHotel_map_coord() {
        return hotel_map_coord;
    }
    /**
     * Returns {@link #hotel_weather_id hotel_weather_id}
     * @return {@link #hotel_weather_id hotel_weather_id}
     */
    public String getHotel_weather_id() {
        return hotel_weather_id;
    }
    /**
     * Returns {@link #hotel_welcome_message hotel_welcome_message}
     * @return {@link #hotel_welcome_message hotel_welcome_message}
     */
    public String getHotel_welcome_message() {
        return hotel_welcome_message;
    }
    /**
     * Returns {@link #hotel_reservation_message hotel_reservation_message}
     * @return {@link #hotel_reservation_message hotel_reservation_message}
     */
    public String getHotel_reservation_message() {
        return hotel_reservation_message;
    }
    /**
     * Returns {@link #hotel_service_request_message hotel_service_request_message}
     * @return {@link #hotel_service_request_message hotel_service_request_message}
     */
    public String getHotel_service_request_message() {
        return hotel_service_request_message;
    }
    /**
     * Returns {@link #hotel_checkout_message hotel_checkout_message}
     * @return {@link #hotel_checkout_message hotel_checkout_message}
     */
    public String getHotel_checkout_message() {
        return hotel_checkout_message;
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Setter----------------------------------------

    /**
     * Sets new value for {@link #hotel_name hotel_name}
     * @param hotel_name new value for {@link #hotel_name hotel_name}
     */
    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }
    /**
     * Sets new value for {@link #hotel_street hotel_street}
     * @param hotel_street new value for {@link #hotel_street hotel_street}
     */
    public void setHotel_street(String hotel_street) {
        this.hotel_street = hotel_street;
    }
    /**
     * Sets new value for {@link #hotel_city hotel_city}
     * @param hotel_city new value for {@link #hotel_city hotel_city}
     */
    public void setHotel_city(String hotel_city) {
        this.hotel_city = hotel_city;
    }
    /**
     * Sets new value for {@link #hotel_country hotel_country}
     * @param hotel_country new value for {@link #hotel_country hotel_country}
     */
    public void setHotel_country(String hotel_country) {
        this.hotel_country = hotel_country;
    }
    /**
     * Sets new value for {@link #hotel_timezone_id hotel_timezone_id}
     * @param hotel_timezone_id new value for {@link #hotel_timezone_id hotel_timezone_id}
     */
    public void setHotel_timezone_id(String hotel_timezone_id) {
        this.hotel_timezone_id = hotel_timezone_id;
    }
    /**
     * Sets new value for {@link #hotel_email hotel_email}
     * @param hotel_email new value for {@link #hotel_email hotel_email}
     */
    public void setHotel_email(String hotel_email) {
        this.hotel_email = hotel_email;
    }
    /**
     * Sets new value for {@link #hotel_currency hotel_currency}
     * @param hotel_currency new value for {@link #hotel_currency hotel_currency}
     */
    public void setHotel_currency(String hotel_currency) {
        this.hotel_currency = hotel_currency;
    }
    /**
     * Sets new value for {@link #hotel_checkout_message hotel_checkout_message}
     * @param hotel_website new value for {@link #hotel_website hotel_website}
     */
    public void setHotel_website(String hotel_website) {
        this.hotel_website = hotel_website;
    }
    /**
     * Sets new value for {@link #hotel_logo hotel_logo}
     * @param hotel_logo new value for {@link #hotel_logo hotel_logo}
     */
    public void setHotel_logo(String hotel_logo) {
        this.hotel_logo = hotel_logo;
    }
    /**
     * Sets new value for {@link #hotel_map_coord hotel_map_coord}
     * @param hotel_map_coord new value for {@link #hotel_map_coord hotel_map_coord}
     */
    public void setHotel_map_coord(String hotel_map_coord) {
        this.hotel_map_coord = hotel_map_coord;
    }
    /**
     * Sets new value for {@link #hotel_weather_id hotel_weather_id}
     * @param hotel_weather_id new value for {@link #hotel_weather_id hotel_weather_id}
     */
    public void setHotel_weather_id(String hotel_weather_id) {
        this.hotel_weather_id = hotel_weather_id;
    }
    /**
     * Sets new value for {@link #hotel_welcome_message hotel_welcome_message}
     * @param hotel_welcome_message new value for {@link #hotel_welcome_message hotel_welcome_message}
     */
    public void setHotel_welcome_message(String hotel_welcome_message) {
        this.hotel_welcome_message = hotel_welcome_message;
    }
    /**
     * Sets new value for {@link #hotel_reservation_message hotel_reservation_message}
     * @param hotel_reservation_message new value for {@link #hotel_reservation_message hotel_reservation_message}
     */
    public void setHotel_reservation_message(String hotel_reservation_message) {
        this.hotel_reservation_message = hotel_reservation_message;
    }
    /**
     * Sets new value for {@link #hotel_service_request_message hotel_service_request_message}
     * @param hotel_service_request_message new value for {@link #hotel_service_request_message hotel_service_request_message}
     */
    public void setHotel_service_request_message(String hotel_service_request_message) {
        this.hotel_service_request_message = hotel_service_request_message;
    }
    /**
     * Sets new value for {@link #hotel_checkout_message hotel_checkout_message}
     * @param hotel_checkout_message new value for {@link #hotel_checkout_message hotel_checkout_message}
     */
    public void setHotel_checkout_message(String hotel_checkout_message) {
        this.hotel_checkout_message = hotel_checkout_message;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

}

