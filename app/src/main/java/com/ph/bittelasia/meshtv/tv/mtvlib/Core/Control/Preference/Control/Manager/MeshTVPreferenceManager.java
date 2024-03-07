package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.FileReader.MeshTVFileManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

import org.json.JSONObject;

/**
 * Provides access to all MeshTV Preferences
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshTVPreferenceManager
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = MeshTVPreferenceManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //================================================Guest=========================================
    //------------------------------------------------Action----------------------------------------
    /**
     * Reset guest preference to default
     * @param context required to access preferences
     */
    public static void resetGuest(Context context)
    {
        GuestPreference.reset(context);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Firstname---------------------------------------
    /**
     * Retrieves guest first name preference (DEFAULT:Welcome - also used when no guest is assigned to the room)
     * <br>Displayed on the Apps Guest Fragment
     * <br>Substituted by {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Interpreter.MeshInterpreter MeshInterpreter} to:
     * <br>1. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Interpreter.MeshInterpreter#KEY_GUEST_FNAME [f_guest_name]}
     * <br>2. First part of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Interpreter.MeshInterpreter#KEY_GUEST [guest_name]}
     *
     * @param c required to access preferences
     */
    public static String getGuestFirstName(Context c) {return GuestPreference.getGuestFirstname(c);}

    /**
     * Sets the value of first name preference
     * @param c required to access preferences
     * @param firstName new value for first name preference
     */
    public static void setGuestFirstName(Context c,String firstName){GuestPreference.setGuestFirstname(c,firstName);}
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Lastname---------------------------------------
    /**
     * Retrieves guest last name preference (DEFAULT:Guest - also used when no guest is assigned to the room)
     * <br>Displayed on the Apps Guest Fragment
     * <br>Substituted by {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Interpreter.MeshInterpreter MeshInterpreter} to:
     * <br>1. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Interpreter.MeshInterpreter#KEY_GUEST_LNAME [l_guest_name]}
     *
     * <br>2. Second part of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Interpreter.MeshInterpreter#KEY_GUEST [guest_name]}
     * @param c required to access preferences
     */
    public static String getGuestLastName(Context c) {return GuestPreference.getGuestLastname(c);}
    /**
     * Sets the value of last name preference
     * @param c required to access preferences
     * @param lastName new value for first last preference
     */
    public static void setGuestLastName(Context c,String lastName){GuestPreference.setGuestLastname(c,lastName);}
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Birthdate--------------------------------------
    /**
     * Retrieves guest birth date preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getGuestBirthDate(Context c) {return GuestPreference.getGuestBirthdate(c);}
    /**
     * Sets the value of birth date preference
     * @param c required to access preferences
     * @param birthDate new value for birth date preference
     */
    public static void setGuestBirthDate(Context c,String birthDate){GuestPreference.setGuestBirthdate(c,birthDate);}
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Address---------------------------------------
    /**
     * Retrieves guest address preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getGuestAddress(Context c) {return GuestPreference.getGuestAddress(c);}
    /**
     * Sets the value of address preference
     * @param c required to access preferences
     * @param address new value for address preference
     */
    public static void setGuestAddress(Context c,String address){GuestPreference.setGuestAddress(c,address);}
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------City-----------------------------------------
    /**
     * Retrieves guest city preference
     * <br>Substituted by {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Interpreter.MeshInterpreter MeshInterpreter} to:
     * <br>1. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Interpreter.MeshInterpreter#KEY_GUEST_CITY [guest_city]}
     *
     * @param c required to access preferences
     */
    public static String getGuestCity(Context c) {return GuestPreference.getGuestCity(c);}
    /**
     * Sets the value of city preference
     * @param c required to access preferences
     * @param city new value for city preference
     */
    public static void setGuestCity(Context c,String city) {GuestPreference.setGuestCity(c,city);}
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Country---------------------------------------
    /**
     * Retrieves guest country preference
     * <br>Substituted by {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Interpreter.MeshInterpreter MeshInterpreter} to:
     * <br>1. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Interpreter.MeshInterpreter#KEY_GUEST_COUNTRY [guest_country]}
     *
     * @param c required to access preferences
     */
    public static String getGuestCountry(Context c) {return GuestPreference.getGuestCountry(c);}
    /**
     * Sets the value of country preference
     * @param c required to access preferences
     * @param country new value for city preference
     */
    public static void setGuestCountry(Context c,String country) {GuestPreference.setGuestCountry(c,country);}
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Postal----------------------------------------
    /**
     * Retrieves guest postal code preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getGuestPostal(Context c) {return GuestPreference.getGuestPostal(c);}
    /**
     * Sets the value of guest postal code preference
     * @param c required to access preferences
     * @param postal new value for guest postal code preference
     */
    public static void setGuestPostal(Context c,String postal) {GuestPreference.setGuestPostal(c,postal);}
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Email-----------------------------------------
    /**
     * Retrieves guest email preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getGuestEmail(Context c) {return GuestPreference.getGuestEmail(c);}
    /**
     * Sets the value of guest email preference
     * @param c required to access preferences
     * @param mobile new value for guest email preference
     */
    public static void setGuestEmail(Context c,String mobile) {GuestPreference.setGuestEmail(c,mobile);}
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Mobile----------------------------------------
    /**
     * Retrieves guest mobile preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getGuestMobile(Context c) {return GuestPreference.getGuestMobileNo(c);}
    /**
     * Sets the value of guest mobile preference
     * @param c required to access preferences
     * @param mobile new value for guest mobile preference
     */
    public static void setGuestMobile(Context c,String mobile) {GuestPreference.setGuestMobileNo(c,mobile);}
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Landline---------------------------------------
    /**
     * Retrieves guest landline preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getGuestLandline(Context c) {return GuestPreference.getGuestLandline(c);}
    /**
     * Sets the value of guest landline preference
     * @param c required to access preferences
     * @param landline new value for guest landline preference
     */
    public static void setGuestLandline(Context c,String landline) {GuestPreference.setGuestLandline(c,landline);}
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //================================================Config========================================
    //------------------------------------------------Action----------------------------------------
    /**
     * Reset hotel preference to default
     * @param context required to access preferences
     */
    public static void resetConfig(Context context)
    {
        HotelPreference.reset(context);
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------hotel_name---------------------------------------
    /**
     * Retrieves hotel name preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getHotelName(Context c) {return HotelPreference.getConfigName(c);}
    /**
     * Sets the value of hotel name preference
     * @param c required to access preferences
     * @param name new value for hotel name preference
     */
    public static void setHotelName(Context c,String name) {HotelPreference.setConfigName(c,name);}
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------hotel_street--------------------------------------
    /**
     * Retrieves hotel street preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getHotelStreet(Context c) {return HotelPreference.getConfigHotelStreet(c);}
    /**
     * Sets the value of hotel street preference
     * @param c required to access preferences
     * @param street new value for hotel street preference
     */
    public static void setHotelStreet(Context c,String street) {HotelPreference.setConfigHotelStreet(c,street);}
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------hotel_city---------------------------------------
    /**
     * Retrieves hotel city preference
     * <br>Displayed in Weather Fragment
     * @param c required to access preferences
     */
    public static String getHotelCity(Context c) {return HotelPreference.getConfigCity(c);}
    /**
     * Sets the value of hotel city preference
     * @param c required to access preferences
     * @param city new value for hotel city preference
     */
    public static void setHotelCity(Context c,String city) {HotelPreference.setConfigCity(c,city);}
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------hotel_country--------------------------------------
    /**
     * Retrieves hotel country preference
     * <br>Filter for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2 MeshWeatherV2} for weather to be displayed in Weather Fragment
     * <br>Basis for default Weather Forecast
     * @param c required to access preferences
     */
    public static String getHotelCountry(Context c) {return HotelPreference.getConfigCountry(c);}
    /**
     * Sets the value of hotel country preference
     * @param c required to access preferences
     * @param country new value for hotel country preference
     */
    public static void setHotelCountry(Context c,String country) {HotelPreference.setConfigCountry(c,country);}
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------hotel_tz-----------------------------------------
    /**
     * Retrieves hotel timezone preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getHotelTimezone(Context c) {return HotelPreference.getConfigTimezoneId(c);}
    /**
     * Sets the value of hotel timezone preference
     * @param c required to access preferences
     * @param timezone new value for hotel timezone preference
     */
    public static void setHotelTimezone(Context c,String timezone) {HotelPreference.setConfigTimezoneId(c,timezone);}
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------hotel_email----------------------------------------
    /**
     * Retrieves hotel email preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getHotelEmail(Context c) {return HotelPreference.getConfigEmail(c);}
    /**
     * Sets the value of hotel email preference
     * @param c required to access preferences
     * @param email new value for hotel email preference
     */
    public static void setHotelEmail(Context c,String email) {HotelPreference.setConfigEmail(c,email);}
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------hotel_currency---------------------------------------
    /**
     * Retrieves hotel currency preference
     * <br>Currency used for all purchases within the app
     * @param c required to access preferences
     */
    public static String getHotelCurrency(Context c) {return HotelPreference.getConfigCurrency(c);}
    /**
     * Sets the value of hotel currency preference
     * @param c required to access preferences
     * @param currency new value for hotel currency preference
     */
    public static void setHotelCurrency(Context c,String currency) {HotelPreference.setConfigCurrency(c,currency);}
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------hotel_website----------------------------------------
    /**
     * Retrieves hotel website preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getHotelWebsite(Context c) {return HotelPreference.getConfigWebsite(c);}
    /**
     * Sets the value of hotel website preference
     * @param c required to access preferences
     * @param website new value for hotel website preference
     */
    public static void setHotelWebsite(Context c,String website) {HotelPreference.setConfigWebsite(c,website);}
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------hotel_logo-----------------------------------------
    /**
     * Retrieves hotel logo preference
     * <br>Can be displayed at Config Fragments
     * @param c required to access preferences
     */
    public static String getHotelLogo(Context c) {return HotelPreference.getConfigLogo(c);}
    /**
     * Sets the value of hotel logo preference
     * @param c required to access preferences
     * @param logo new value for hotel logo preference
     */
    public static void setHotelLogo(Context c,String logo) {HotelPreference.setConfigLogo(c,logo);}
    //----------------------------------------------------------------------------------------------
    //------------------------------------------hotel_coord-----------------------------------------
    /**
     * Retrieves hotel coordinates preference
     * <br>Full Coordinates of the hotel can be used to display location on a map
     * @param c required to access preferences
     */
    public static String getHotelCoord(Context c) {return HotelPreference.getConfigMapCoord(c);}
    /**
     * Sets the value of hotel coordinates preference
     * @param c required to access preferences
     * @param coord new value for hotel coordinates preference
     */
    public static void setHotelCoord(Context c,String coord) {HotelPreference.setConfigMapCoord(c,coord);}
    //----------------------------------------------------------------------------------------------
    //------------------------------------------hotel_w_id------------------------------------------
    /**
     * Retrieves hotel welcome message preference
     * <br>Hotel's Welcome Message can be displayed to greet newly checked-in guests
     * @param c required to access preferences
     */
    public static String getWelcomeMessage(Context c) {return HotelPreference.getConfigWelcomeMsg(c);}
    /**
     * Sets the value of hotel welcome message preference
     * @param c required to access preferences
     * @param message new value for hotel welcome message preference
     */
    public static void setWelcomeMessage(Context c,String message) {HotelPreference.setConfigWelcomeMsg(c,message);}
    //----------------------------------------------------------------------------------------------
    //----------------------------------------hotel_r_message---------------------------------------
    /**
     * Retrieves hotel reservation message preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getReservationMessage(Context c) {return HotelPreference.getConfigReservationMsg(c);}
    /**
     * Sets the value of hotel reservation message preference
     * @param c required to access preferences
     * @param message new value for hotel reservation message preference
     */
    public static void setReservationMessage(Context c,String message) {HotelPreference.setConfigReservationMsg(c,message);}
    //----------------------------------------------------------------------------------------------
    //----------------------------------------hotel_s_message---------------------------------------
    /**
     * Retrieves hotel service message preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getServiceMessage(Context c) {return HotelPreference.getConfigSvcRequestMsg(c);}
    /**
     * Sets the value of hotel service message preference
     * @param c required to access preferences
     * @param message new value for hotel service message preference
     */
    public static void setServiceMessage(Context c,String message) {HotelPreference.setConfigSvcRequestMsg(c,message);}
    //----------------------------------------------------------------------------------------------
    //----------------------------------------hotel_c_message---------------------------------------
    /**
     * Retrieves hotel checkout message preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getCheckOutMessage(Context c) {return HotelPreference.getConfigCheckoutMsg(c);}
    /**
     * Sets the value of hotel checkout message preference
     * @param c required to access preferences
     * @param message new value for hotel checkout message preference
     */
    public static void setCheckOutMessage(Context c,String message) {HotelPreference.setConfigCheckoutMsg(c,message);}
    //----------------------------------------------------------------------------------------------
    //------------------------------------------weather_id------------------------------------------
    /**
     * Retrieves hotel weather id preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getWeatherID(Context c) {return HotelPreference.getConfigWeatherId(c);}
    /**
     * Sets the value of hotel weather id preference
     * @param c required to access preferences
     * @param weatherID new value for hotel weather id preference
     */
    public static void setWeatherID(Context c,String weatherID) {HotelPreference.setConfigWeatherId(c,weatherID);}
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Weather===========================================
    //------------------------------------------------Action----------------------------------------
    /**
     * Reset weather preference to default
     * @param context required to access preferences
     */
    public static void resetHotelWeather(Context context)
    {
        HotelWeatherPreference.reset(context);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Lon--------------------------------------------
    /**
     * Retrieves weather longitude preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getHotelWeatherCoordLon(Context c) {return HotelWeatherPreference.getHotelWeatherCoordLon(c);}
    /**
     * Sets the value of weather longitude preference
     * @param c required to access preferences
     * @param value new value for weather longitude preference
     */
    public static void setHotelWeatherCoordLon(Context c,String value) {HotelWeatherPreference.setHotelWeatherCoordLon(c,value);}

    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Lat--------------------------------------------
    /**
     * Retrieves weather latitude preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getHotelWeatherCoordLat(Context c) {return HotelWeatherPreference.getHotelWeatherCoordLat(c);}
    /**
     * Sets the value of weather latitude preference
     * @param c required to access preferences
     * @param value new value for weather latitude preference
     */
    public static void setHotelWeatherCoordLat(Context c,String value) {HotelWeatherPreference.setHotelWeatherCoordLat(c,value);}

    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Country------------------------------------------
    /**
     * Retrieves weather country preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getHotelWeatherSysCountry(Context c) {return HotelWeatherPreference.getHotelWeatherSysCountry(c);}
    /**
     * Sets the value of weather country preference
     * @param c required to access preferences
     * @param value new value for weather country preference
     */
    public static void setHotelWeatherSysCountry(Context c,String value) {HotelWeatherPreference.setHotelWeatherSysCountry(c,value);}

    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Sunrise------------------------------------------
    /**
     * Retrieves weather sunrise time preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getHotelWeatherSysSunrise(Context c) {return HotelWeatherPreference.getHotelWeatherSysSunrise(c);}
    /**
     * Sets the value of weather sunrise time preference
     * @param c required to access preferences
     * @param value new value for weather sunrise time preference
     */
    public static void setHotelWeatherSysSunrise(Context c,String value) {HotelWeatherPreference.setHotelWeatherSysSunrise(c,value);}

    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Sunset-------------------------------------------
    /**
     * Retrieves weather sunset time preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getHotelWeatherSysSunset(Context c) {return HotelWeatherPreference.getHotelWeatherSysSunset(c);}
    /**
     * Sets the value of weather sunset time preference
     * @param c required to access preferences
     * @param value new value for weather sunset time preference
     */
    public static void setHotelWeatherSysSunset(Context c,String value) {HotelWeatherPreference.setHotelWeatherSysSunset(c,value);}

    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Description---------------------------------------
    /**
     * Retrieves weather description preference
     * <br>Displayed in Weather Fragment
     * @param c required to access preferences
     */
    public static String getHotelWeatherWeatherDesc(Context c) {return HotelWeatherPreference.getHotelWeatherWeatherDesc(c);}
    /**
     * Sets the value of weather description preference
     * @param c required to access preferences
     * @param value new value for weather description preference
     */
    public static void setHotelWeatherWeatherDesc(Context c,String value) {HotelWeatherPreference.setHotelWeatherWeatherDesc(c,value);}

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Icon--------------------------------------------
    /**
     * Retrieves weather icon preference
     * <br>Displayed in Weather Fragment
     * @param c required to access preferences
     */
    public static String getHotelWeatherWeatherIcon(Context c) {return HotelWeatherPreference.getHotelWeatherWeatherIcon(c);}
    /**
     * Sets the value of weather icon preference
     * @param c required to access preferences
     * @param value new value for weather icon preference
     */
    public static void setHotelWeatherWeatherIcon(Context c,String value) {HotelWeatherPreference.setHotelWeatherWeatherIcon(c,value);}

    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------City-------------------------------------------
    /**
     * Retrieves weather city preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getHotelWeatherCity(Context c) {return HotelWeatherPreference.getHotelWeatherCity(c);}
    /**
     * Sets the value of weather city preference
     * @param c required to access preferences
     * @param value new value for weather city preference
     */
    public static void setHotelWeatherCity(Context c,String value) {HotelWeatherPreference.setHotelWeatherCity(c,value);}

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Timezone----------------------------------------
    /**
     * Retrieves weather timezone preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getHotelWeatherTimezone(Context c) {return HotelWeatherPreference.getHotelWeatherTimezone(c);}
    /**
     * Sets the value of weather timezone preference
     * @param c required to access preferences
     * @param value new value for weather timezone preference
     */
    public static void setHotelWeatherTimezone(Context c,String value) {HotelWeatherPreference.setHotelWeatherTimezone(c,value);}

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------MainTemp----------------------------------------
    /**
     * Retrieves weather main temp preference
     * <br>Displayed in Weather Fragment
     * @param c required to access preferences
     */
    public static String getHotelWeatherMainTemp(Context c) {return HotelWeatherPreference.getHotelWeatherMainTemp(c);}
    /**
     * Sets the value of weather main temp preference
     * @param c required to access preferences
     * @param value new value for weather main temp preference
     */
    public static void setHotelWeatherMainTemp(Context c,String value) {HotelWeatherPreference.setHotelWeatherMainTemp(c,value);}

    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Pressure-----------------------------------------
    /**
     * Retrieves weather main pressure preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getHotelWeatherMainPressure(Context c) {return HotelWeatherPreference.getHotelWeatherMainPressure(c);}
    /**
     * Sets the value of weather main pressure preference
     * @param c required to access preferences
     * @param value new value for weather main pressure preference
     */
    public static void setHotelWeatherMainPressure(Context c,String value) {HotelWeatherPreference.setHotelWeatherMainPressure(c,value);}

    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Humidity-----------------------------------------
    /**
     * Retrieves weather main humidity preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getHotelWeatherMainHumidity(Context c) {return HotelWeatherPreference.getHotelWeatherMainHumidity(c);}
    /**
     * Sets the value of weather main humidity preference
     * @param c required to access preferences
     * @param value new value for weather main humidity preference
     */
    public static void setHotelWeatherMainHumidity(Context c,String value) {HotelWeatherPreference.setHotelWeatherMainHumidity(c,value);}

    //----------------------------------------------------------------------------------------------
    //---------------------------------------------TempMin------------------------------------------
    /**
     * Retrieves weather minimum temperature preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getHotelWeatherMainTempMin(Context c) {return HotelWeatherPreference.getHotelWeatherMainTempMin(c);}
    /**
     * Sets the value of weather minimum temperature preference
     * @param c required to access preferences
     * @param value new value for weather minimum temperature preference
     */
    public static void setHotelWeatherMainTempMin(Context c,String value) {HotelWeatherPreference.setHotelWeatherMainTempMin(c,value);}

    //----------------------------------------------------------------------------------------------
    //---------------------------------------------TempMax------------------------------------------
    /**
     * Retrieves weather maximum temperature preference
     * <br>No Specific Use Yet
     * @param c required to access preferences
     */
    public static String getHotelWeatherMainTempMax(Context c) {return HotelWeatherPreference.getHotelWeatherMainTempMax(c);}
    /**
     * Sets the value of weather maximum temperature preference
     * @param c required to access preferences
     * @param value new value for weather maximum temperature preference
     */
    public static void setHotelWeatherMainTempMax(Context c,String value) {HotelWeatherPreference.setHotelWeatherMainTempMax(c,value);}
    //-----------------------------------------------------------------------------------------------
    //==============================================================================================

    //==========================================ChannelPreference===================================
    //-----------------------------------------------Action-----------------------------------------
    /**
     * Reset Channel prereference to default
     * @param c required to access preferences
     */
    public static void resetChannelPreferences(Context c)
    {
        ChannelPreferenceManager.reset(c);
    }
    //----------------------------------------------------------------------------------------------

    //----------------------------------------------Current ID--------------------------------------
    /**
     * Retrieves current channel ID
     * @param c required to access preferences
     * @return current channel ID
     */
    public static int getCurrentID(Context c)
    {
        return ChannelPreferenceManager.getCurrentID(c);
    }
    /**
     * Sets the value of current channel ID
     * @param c required to access preferences
     * @param id new value for current channel ID
     */
    public static void setCurrentID(Context c,int id)
    {
        ChannelPreferenceManager.setCurrentID(c,id);
    }
    //----------------------------------------------------------------------------------------------

    //---------------------------------------------Current URL--------------------------------------
    /**
     * Retrieves current channel URL
     * @param c required to access preferences
     * @return current channel URL
     */
    public static String getCurrentURL(Context c)
    {
        return ChannelPreferenceManager.getCurrentURL(c);
    }
    /**
     * Sets the value of current channel URL
     * @param c required to access preferences
     * @param url new value for current channel URL
     */
    public static void setCurrentURL(Context c,String url)
    {
        ChannelPreferenceManager.setCurrentUrl(c,url);
    }
    //----------------------------------------------------------------------------------------------

    //---------------------------------------------Current Index------------------------------------
    /**
     * Retrieves current channel index
     * @param c required to access preferences
     * @return current channel index
     */
    public static int getCurrentIndex(Context c)
    {
        return ChannelPreferenceManager.getCurrentIndex(c);
    }
    /**
     * Sets the value of current channel index
     * @param c required to access preferences
     * @param index new value for current channel index
     */
    public static void setCurrentIndex(Context c,int index)
    {
        ChannelPreferenceManager.setCurrentIndex(c,index);
    }
    //----------------------------------------------------------------------------------------------

    //---------------------------------------------Current Name-------------------------------------
    /**
     * Retrieves current channel name
     * @param c required to access preferences
     * @return current channel name
     */
    public static String getCurrentName(Context c)
    {
        return ChannelPreferenceManager.getCurrentName(c);
    }
    /**
     * Sets the value of current channel name
     * @param c required to access preferences
     * @param name new value for current channel name
     */
    public static void setCurrentName(Context c,String name)
    {
        ChannelPreferenceManager.setCurrentName(c,name);
    }
    //----------------------------------------------------------------------------------------------

    //---------------------------------------------Current Image------------------------------------
    /**
     * Retrieves current channel image
     * @param c required to access preferences
     * @return current channel image
     */
    public static String getCurrentImage(Context c)
    {
        return ChannelPreferenceManager.getChannelCurrentImage(c);
    }
    /**
     * Sets the value of current channel image
     * @param c required to access preferences
     * @param image new value for current channel image
     */
    public static void setCurrentImage(Context c,String image)
    {
        ChannelPreferenceManager.setChannelCurrentImage(c,image);
    }
    //----------------------------------------------------------------------------------------------

    //-----------------------------------------------Prev1 ID---------------------------------------
    /**
     * Retrieves prev-1 channel ID
     * @param c required to access preferences
     * @return prev-1 channel ID
     */
    public static int getPrev1Id(Context c)
    {
        return ChannelPreferenceManager.getPrev1ID(c);
    }
    /**
     * Sets the value of prev-1 channel ID
     * @param c required to access preferences
     * @param id new value for prev-1 channel ID
     */
    public static void setPrev1Id(Context c,int id)
    {
        ChannelPreferenceManager.setPrev1ID(c,id);
    }
    //----------------------------------------------------------------------------------------------

    //-----------------------------------------------Prev2 ID---------------------------------------
    /**
     * Retrieves prev-2 channel ID
     * @param c required to access preferences
     * @return prev-2 channel ID
     */
    public static int getPrev2Id(Context c)
    {
        return ChannelPreferenceManager.getPrev2ID(c);
    }
    /**
     * Sets the value of prev-2 channel ID
     * @param c required to access preferences
     * @param id new value for prev-2 channel ID
     */
    public static void setPrev2Id(Context c,int id)
    {
        ChannelPreferenceManager.setPrev2ID(c,id);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================SubscriberPreference=================================
    //----------------------------------------------Action------------------------------------------
    /**
     * Reset Subscriber preference to default
     * @param c required to access preferences
     */
    public static void resetSubscriber(Context c)
    {

        SubscriberPreferenceManager.reset(c);

    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Account ID---------------------------------------
    /**
     * Retrieve account ID
     * @param context required to access preference
     * @return account ID
     */
    public static final String getAccountID(Context context)
    {
        return SubscriberPreferenceManager.getAccountID(context);
    }
    /**
     * Sets the account ID the STB is registered to
     * @param context required to access preference
     * @param value new account ID
     */
    public static final void setAccountID(Context context,String value)
    {
        SubscriberPreferenceManager.setAccountID(context,value);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Title-----------------------------------------
    /**
     * Retrieve title/salutation of the account holder
     * @param context required to access preference
     * @return title/salutation of the account holder
     */
    public static final String getAccountTitle(Context context)
    {

        return SubscriberPreferenceManager.getTitle(context);
    }
    /**
     * Sets the title/salutation of the account holder
     * @param context required to access preference
     * @param value new title/salutation of the account holder
     */
    public static final void setAccountTitle(Context context, String value)
    {
        SubscriberPreferenceManager.setTitle(context,value);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Lastname---------------------------------------
    /**
     * Retrieve lastname of the account holder
     * @param context required to access preference
     * @return lastname of the account holder
     */
    public static final String getAccountLastname(Context context)
    {
        return SubscriberPreferenceManager.getLastname(context);
    }
    /**
     * Sets the lastname of the account holder
     * @param context required to access preference
     * @param value new lastname of the account holder
     */
    public static final void setAccountLastname(Context context, String value)
    {
        SubscriberPreferenceManager.setLastname(context,value);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Firstname---------------------------------------
    /**
     * Retrieve firstname of the account holder
     * @param context required to access preference
     * @return firstname of the account holder
     */
    public static final String getAccountFirstname(Context context)
    {
        return SubscriberPreferenceManager.getFirstname(context);
    }
    /**
     * Sets the firstname of the account holder
     * @param context required to access preference
     * @param value new firstname of the account holder
     */
    public  static final void setAccountFirstname(Context context, String value)
    {
        SubscriberPreferenceManager.setFirstname(context,value);
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Middlename---------------------------------------
    /**
     * Retrieve middlename of the account holder
     * @param context required to access preference
     * @return middlename of the account holder
     */
    public static final String getAccountMiddlename(Context context)
    {
        return SubscriberPreferenceManager.getMiddlename(context);
    }
    /**
     * Sets the middlename of the account holder
     * @param context required to access preference
     * @param value new middlename of the account holder
     */
    public static final void setAccountMiddlename(Context context, String value)
    {
        SubscriberPreferenceManager.setMiddlename(context,value);
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Contact No---------------------------------------
    /**
     * Retrieve contact number of the account holder
     * @param context required to access preference
     * @return contact number of the account holder
     */
    public static final String getAccountContactNo(Context context)
    {
        return SubscriberPreferenceManager.getContactNo(context);
    }
    /**
     * Sets the contact number of the account holder
     * @param context required to access preference
     * @param value new contact number of the account holder
     */
    public static final void setAccountContactNo(Context context, String value)
    {
        SubscriberPreferenceManager.setContactNo(context,value); ;
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Mobile No---------------------------------------
    /**
     * Retrieve mobile number of the account holder
     * @param context required to access preference
     * @return mobile number of the account holder
     */
    public static final String getAccountMobileNo(Context context)
    {

        return SubscriberPreferenceManager.getMobileNo(context);
    }
    /**
     * Sets the contact number of the account holder
     * @param context required to access preference
     * @param value new contact number of the account holder
     */
    public static final void setAccountMobileNo(Context context, String value)
    {
        SubscriberPreferenceManager.setMobileNo(context,value);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Email-----------------------------------------
    /**
     * Retrieve email address of the account holder
     * @param context required to access preference
     * @return email address of the account holder
     */
    public static final String getAccountEmailaddress(Context context)
    {
        return SubscriberPreferenceManager.getEmailaddress(context);
    }
    /**
     * Sets the email address of the account holder
     * @param context required to access preference
     * @param value new email address of the account holder
     */
    public static final void setAccountEmailAddress(Context context, String value)
    {
        SubscriberPreferenceManager.setEmailAddress(context,value);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------House No----------------------------------------
    /**
     * Retrieve house no. of the account holder
     * @param context required to access preference
     * @return house no. of the account holder
     */
    public static final String getAccountHouseNo(Context context)
    {
        return SubscriberPreferenceManager.getHouseNo(context);
    }
    /**
     * Sets the house no. of the account holder
     * @param context required to access preference
     * @param value new house no. of the account holder
     */
    public static final void setAccountHouseNo(Context context, String value)
    {
        SubscriberPreferenceManager.setHouseNo(context,value);
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Subdivision---------------------------------------
    /**
     * Retrieve subdivision of the account holder
     * @param context required to access preference
     * @return subdivision. of the account holder
     */
    public static final String getAccountSubdivision(Context context)
    {
        return SubscriberPreferenceManager.getSubdivision(context);
    }
    /**
     * Sets the subdivision of the account holder
     * @param context required to access preference
     * @param value new subdivision of the account holder
     */
    public static final void setAccountSubdivision(Context context, String value)
    {
        SubscriberPreferenceManager.setSubdivision(context,value);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Barangay----------------------------------------
    /**
     * Retrieve barangay of the account holder
     * @param context required to access preference
     * @return barangay of the account holder
     */
    public static final String getAccountBarangay(Context context)
    {
        return SubscriberPreferenceManager.getBarangay(context);
    }
    /**
     * Sets the barangay of the account holder
     * @param context required to access preference
     * @param value new barangay of the account holder
     */
    public static final void setAccountBarangay(Context context, String value)
    {
        SubscriberPreferenceManager.getBarangay(context);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------City------------------------------------------
    /**
     * Retrieve city of the account holder
     * @param context required to access preference
     * @return city of the account holder
     */
    public static final String getAccountCity(Context context)
    {

        return SubscriberPreferenceManager.getCity(context);
    }
    /**
     * Sets the city of the account holder
     * @param context required to access preference
     * @param value new city of the account holder
     */
    public static final void setAccountCity(Context context, String value)
    {
        SubscriberPreferenceManager.setCity(context,value);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Province----------------------------------------
    /**
     * Retrieve province code of the account holder
     * @param context required to access preference
     * @return province code of the account holder
     */
    public static final String getProvince(Context context)
    {
        return SubscriberPreferenceManager.getProvince(context);
    }
    /**
     * Sets the province code of the account holder
     * @param context required to access preference
     * @param value new province code of the account holder
     */
    public static final void setProvince(Context context, String value)
    {
        SubscriberPreferenceManager.setProvince(context,value);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------County----------------------------------------
    /**
     * Retrieve country code of the account holder
     * @param context required to access preference
     * @return country code of the account holder
     */
    public static final String getAccountCountryCode(Context context)
    {
        return SubscriberPreferenceManager.getCountryCode(context);
    }
    /**
     * Sets the country code of the account holder
     * @param context required to access preference
     * @param value new country code of the account holder
     */
    public static final void setAccountCountryCode(Context context, String value)
    {
        SubscriberPreferenceManager.setCountryCode(context,value);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Postal----------------------------------------
    /**
     * Retrieve postal code of the account holder
     * @param context required to access preference
     * @return postal code of the account holder
     */
    public static final String getAccountPostalCode(Context context)
    {
        return SubscriberPreferenceManager.getPostalCode(context);
    }
    /**
     * Sets the postal code of the account holder
     * @param context required to access preference
     * @param value new postal code of the account holder
     */
    public static final void setAccountPostalCode(Context context, String value)
    {
        SubscriberPreferenceManager.setPostalCode(context,value);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Status----------------------------------------
    /**
     * Retrieve status of Subscription:
     * <br>
     * <br>
     * Results:
     * <br>
     * 0 - disabled
     * <br>
     * 1 - enabled
     * @param context required to access preference
     * @return status of account
     */
    public static final int getAccountStatus(Context context)
    {
        return SubscriberPreferenceManager.getStatus(context);
    }
    /**
     * Sets the status of account
     * @param context required to access preference
     * @param value new status of account
     */
    public  static final void setAccountStatus(Context context, int value)
    {
        SubscriberPreferenceManager.setStatus(context,value);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================IPTVPreference====================================
    //-----------------------------------------------Action-----------------------------------------

    /**
     * Reset IPTV prereference to default
     * @param c required to access preferences
     */
    public static void resetIPTV(Context c)
    {

        IPTVPreference.setRoom(c,IPTVPreference.DEFAULT_ROOM);
        IPTVPreference.setUsername(c,IPTVPreference.DEFAULT_XMPP_USERNAME);
        IPTVPreference.setPassword(c,IPTVPreference.DEFAULT_XMPP_PASSWORD);
        IPTVPreference.setService(c,IPTVPreference.DEFAULT_XMPP_SERVICE);
        IPTVPreference.setXMPPHost(c,IPTVPreference.DEFAULT_XMPP_HOST);
        IPTVPreference.setXMPPPort(c,IPTVPreference.DEFAULT_XMPP_PORT);
        IPTVPreference.setHTTPPort(c,IPTVPreference.DEFAULT_HTTP_PORT);
        IPTVPreference.setHTTPHost(c,IPTVPreference.DEFAULT_HTTP_HOST);
        IPTVPreference.setTimeout(c,IPTVPreference.DEFAULT_HTTP_TIMEOUT);
        IPTVPreference.setConTimeout(c,IPTVPreference.DEFAULT_HTTP_CON_TIMEOUT);
        IPTVPreference.setVersion(c,IPTVPreference.DEFAULT_VER);

    }

    /**
     * Update IPTV prereference to data from /sdcard/Android/NAME_OF_APP/iptv_xmpp.txt
     * @param c required to access preferences
     */
    public static void updateIPTV(Context c)
    {
        String result = MeshTVFileManager.readFile(MeshTVApp.get().getDB()+"/iptv_xmpp.txt");
        try
        {
            JSONObject o = new JSONObject(result);
            IPTVPreference.setRoom(c,o.getString(IPTVPreference.TAG_ROOM));
            IPTVPreference.setUsername(c,o.getString(IPTVPreference.TAG_XMPP_USERNAME));
            IPTVPreference.setPassword(c,o.getString(IPTVPreference.TAG_XMPP_PASSWORD));
            IPTVPreference.setService(c,o.getString(IPTVPreference.TAG_XMPP_SERVICE));
            IPTVPreference.setXMPPHost(c,o.getString(IPTVPreference.TAG_XMPP_HOST));
            IPTVPreference.setXMPPPort(c,Integer.valueOf(o.getString(IPTVPreference.TAG_XMPP_PORT)));
            IPTVPreference.setHTTPPort(c,Integer.valueOf(o.getString(IPTVPreference.TAG_HTTP_PORT)));
            IPTVPreference.setHTTPHost(c,o.getString(IPTVPreference.TAG_HTTP_HOST));
            IPTVPreference.setTimeout(c,Integer.valueOf(o.getString(IPTVPreference.TAG_HTTP_TIMEOUT)));
            IPTVPreference.setConTimeout(c,Integer.valueOf(o.getString(IPTVPreference.TAG_HTTP_CON_TIMEOUT)));
            IPTVPreference.setVersion(c,o.getString(IPTVPreference.TAG_VER));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Room-------------------------------------------

    /**
     * Retrieves room preference
     * <br>Substituted by {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Interpreter.MeshInterpreter MeshInterpreter} to:
     * <br>1. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Interpreter.MeshInterpreter#KEY_ROOM [guest_room]}
     * @param c required to access preferences
     */
    public static String getRoom(Context c)
    {
        return IPTVPreference.getRoom(c);
    }
    /**
     * Sets the value of room preference
     * @param c required to access preferences
     * @param room new value for room preference
     */
    public static void setRoom(Context c,String room)
    {
        IPTVPreference.setRoom(c,room);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Service-------------------------------------------
    /**
     * Retrieves service preference
     * <br>Required for XMPP - this sets the domain XMPP will connect to
     * @param c required to access preferences
     */
    public static String getService(Context c)
    {
        return IPTVPreference.getService(c);
    }
    /**
     * Sets the value of service preference
     * @param c required to access preferences
     * @param service new value for service preference
     */
    public static void setService(Context c,String service)
    {
        IPTVPreference.setRoom(c,service);
    }
    //----------------------------------------------------------------------------------------------

    //---------------------------------------------XUsername----------------------------------------
    /**
     * Retrieves username preference
     * <br>Required for XMPP - this sets the username to be used by the app (usually same as the room number)
     * @param c required to access preferences
     */
    public static String getXUsername(Context c)
    {
        return IPTVPreference.getUsername(c);
    }
    /**
     * Sets the value of username preference
     * @param c required to access preferences
     * @param username new value for username preference
     */
    public static void setXUsername(Context c,String username)
    {
        IPTVPreference.setUsername(c,username);
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------XPassword----------------------------------------
    /**
     * Retrieves password preference
     * <br>Required for XMPP - this sets the username password to be used by the app
     * @param c required to access preferences
     */
    public static String getPassword(Context c)
    {
        return IPTVPreference.getPassword(c);
    }
    /**
     * Sets the value of password preference
     * @param c required to access preferences
     * @param password new value for username preference
     */
    public static void setPassword(Context c,String password)
    {
        IPTVPreference.setPassword(c,password);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------XHost------------------------------------------
    /**
     * Retrieves XMPP Host preference
     * <br>Required for XMPP - IP of the XMPP Host
     * @param c required to access preferences
     */
    public static String getXMPPHost(Context c)
    {
        return IPTVPreference.getXMPPHost(c);
    }
    /**
     * Sets the value of XMPP Host preference
     * @param c required to access preferences
     * @param xmppHost new value for XMPPHost preference
     */
    public static void setXMPPHost(Context c,String xmppHost)
    {
        IPTVPreference.setXMPPHost(c,xmppHost);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------XPort------------------------------------------
    /**
     * Retrieves XMPP Port preference
     * <br>Required for XMPP - Port used by the XMPP Host to listen to XMPP events
     * @param c required to access preferences
     */
    public static int getXMPPPort(Context c)
    {
        return IPTVPreference.getXMPPPort(c);
    }
    /**
     * Sets the value of XMPP Port preference
     * @param c required to access preferences
     * @param xmppPort new value for XMPP Port preference
     */
    public static void setXMPPPort(Context c,int xmppPort)
    {
        IPTVPreference.setXMPPPort(c,xmppPort);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------HPort------------------------------------------
    /**
     * Retrieves HTTP Port preference
     * <br>Required for Live Apps - Port used by the server to listen to HTTP Requests
     * @param c required to access preferences
     */
    public static int getHTTPPort(Context c)
    {
        return IPTVPreference.getHTTPPort(c);
    }
    /**
     * Sets the value of HTTP Port preference
     * @param c required to access preferences
     * @param httpPort new value for HTTP Port preference
     */
    public static void setHTTPPort(Context c,int httpPort)
    {
        IPTVPreference.setHTTPPort(c,httpPort);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------HHost------------------------------------------
    /**
     * Retrieves HTTP Host preference
     * <br>Required for Live Apps - IP of the server for HTTP Requests
     * @param c required to access preferences
     */
    public static String getHTTPHost(Context c)
    {
        return IPTVPreference.getHTTPHost(c);
    }
    /**
     * Sets the value of HTTP Host preference
     * @param c required to access preferences
     * @param httpHost new value for HTTP Host preference
     */
    public static void setHTTPHost(Context c,String httpHost)
    {
        IPTVPreference.setHTTPHost(c,httpHost);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------HTimeOut----------------------------------------
    /**
     * Retrieves HTTP Request Timeout preference
     * <br>Required for Live Apps - The maximum time the app will wait for a response to an HTTP Request
     * @param c required to access preferences
     */
    public static int getTimeOut(Context c)
    {
        return IPTVPreference.getTimeout(c);
    }
    /**
     * Sets the value of HTTP Request Timeout preference
     * @param c required to access preferences
     * @param timeOut new value for HTTP Request Timeout preference
     */
    public static void setTimeOut(Context c,int timeOut)
    {
        IPTVPreference.setTimeout(c,timeOut);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------HCTimeOut---------------------------------------
    /**
     * Retrieves HTTP Connection Timeout preference
     * <br>Required for Live Apps - The maximum time the app will wait to connect to the server
     * @param c required to access preferences
     */
    public static int getConnectionTimeout(Context c)
    {
        return IPTVPreference.getConTimeout(c);
    }
    /**
     * Sets the value of HTTP Connection Timeout preference
     * @param c required to access preferences
     * @param timeOut new value for HTTP Connection Timeout preference
     */
    public static void setConnectionTimeout(Context c,int timeOut)
    {
        IPTVPreference.setConTimeout(c,timeOut);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Version-----------------------------------------
    /**
     * Retrieves MeshTV Version preference
     * <br> VERY IMPORTANT: All APIs will not work if you put the wrong version number
     * <br> Current Version Number: 4.0
     * @param c required to access preferences
     */
    public static String getVersion(Context c)
    {
        return IPTVPreference.getVersion(c);
    }
    /**
     * Sets the value of MeshTV Version preference
     * @param c required to access preferences
     * @param version new value for MeshTV Version preference
     */
    public static void setVersion(Context c,String version)
    {
        IPTVPreference.setVersion(c,version);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================Scrolling Message====================================
    //=================================================URL==========================================
    public static final String getScrollingMessage(Context context)
    {
        return NotificationPreferenceManager.getScrollingMessage(context);
    }
    public static final void setScrollingMessage(Context context,String value)
    {
        NotificationPreferenceManager.setScrollingMessage(context,value);
    }
    //==============================================================================================
    //==============================================Timeout=========================================

    public static final int getScrollTimeout(Context context)
    {
        return NotificationPreferenceManager.getTimeout(context);
    }

    public static final void setScrollTimeout(Context context,int value)
    {
         NotificationPreferenceManager.setTimeout(context,value);
    }
    //==============================================================================================
    //==============================================IMGURL==========================================

    public static final String getNotificationIMGURL(Context context)
    {
        return NotificationPreferenceManager.getIMGURL(context);
    }

    public static final void setNotificationIMGURL(Context context,String value)
    {
        NotificationPreferenceManager.setIMGURL(context,value);
    }
    //==============================================================================================

}
