package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Parser;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshSubscriber;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Bill.MeshBillV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshEPG;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackageChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshSubscription;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestService;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFood;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFoodCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacility;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacilityCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshAirport;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshArrivalFlight;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshDepartureFlight;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshCity;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshContinent;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RoomType.MeshRoomType;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Statistics.MeshStat;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStream;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStreamCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Tag.MeshTag;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshTelecomBill;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshGenre;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVODBought;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshCompany;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshLayout;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshSchedule;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshSignage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshSignageSchedule;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshLayoutV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaZone;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaZoneAssignment;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshScrollingMessage;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshSignageV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshType;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
/**
 * Parses JSONData to corresponding data depending on their class
 * <br>
 *
 * <br>Version 2.0 added support for:
 * <br>1. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackage MeshPackage}
 * <br>2. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackageChannel MeshPackageChannel}
 * <br>3. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshSubscription MeshSubscription}
 *
 * @author Mars Ray Canizares Araullo
 * @version 2.0
 */
public class MeshParser
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = MeshParser.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Method=========================================
    //-----------------------------------------------Airport----------------------------------------
    /**
     * Parse data to a list of {@link MeshAirport MeshAirport}s
     * @param data String data to be parsed
     * @return list of {@link MeshAirport MeshAirport}s
     */
    public static ArrayList<MeshAirport> parseAirports(String data)
    {
        return BittelParser.parseAirports(data);
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------ArrivalFlight------------------------------------
    /**
     * Parse data to a list of {@link MeshArrivalFlight MeshArrivalFlight}s
     * @param data String data to be parsed
     * @return list of {@link MeshArrivalFlight MeshArrivalFlight}s
     */
    public static ArrayList<MeshArrivalFlight> parseArrivalFlights(String data)
    {
        return BittelParser.parseArrivalFlights(data);
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------------Bill----------------------------------------
    /**
     * Parse data to a list of {@link MeshBillV2 MeshBillV2}s
     * @param data String data to be parsed
     * @return list of {@link MeshBillV2 MeshBillV2}s
     */
    public static ArrayList<MeshBillV2> parseBills(String data)
    {
        return BittelParser.parseBills(data);
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------Channel--------------------------------------
    /**
     * Parse data to a list of {@link MeshChannel MeshChannel}s
     * @param data String data to be parsed
     * @return list of {@link MeshChannel MeshChannel}s
     */
    public static ArrayList<MeshChannel> parseChannels(String data)
    {
        return BittelParser.parseChannels(data);
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------ChannelCategory----------------------------------
    /**
     * Parse data to a list of {@link MeshChannelCategory MeshChannelCategories}
     * @param data String data to be parsed
     * @return list of {@link MeshChannelCategory MeshChannelCategories}
     */
    public static ArrayList<MeshChannelCategory> parseChannelCategories(String data)
    {
        return BittelParser.parseChannelCategories(data);
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------------City----------------------------------------
    /**
     * Parse data to a list of {@link MeshCity MeshCities}
     * @param data String data to be parsed
     * @return list of {@link MeshCity MeshCities}
     */
    public static ArrayList<MeshCity> parseCities(String data)
    {
        return BittelParser.parseCities(data);
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------Continent------------------------------------
    /**
     * Parse data to a list of {@link MeshContinent MeshContinent}s
     * @param data String data to be parsed
     * @return list of {@link MeshContinent MeshContinent}s
     */
    public static ArrayList<MeshContinent> parseContinents(String data)
    {
        return BittelParser.parseContinents(data);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------DepartureFlight---------------------------------
    /**
     * Parse data to a list of {@link MeshDepartureFlight MeshDepartureFlight}s
     * @param data String data to be parsed
     * @return list of {@link MeshDepartureFlight MeshDepartureFlight}s
     */
    public static ArrayList<MeshDepartureFlight> parseDepartureFlights(String data)
    {
        return BittelParser.parseDepartureFlights(data);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------------Tag--------------------------------------
    /**
     * Parse data to a list of {@link MeshTag MeshTag}s
     * @param data String data to be parsed
     * @return list of {@link MeshTag MeshTag}s
     */
    public static ArrayList<MeshTag> parseTags(String data)
    {
        return BittelParser.parseTags(data);
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------------Facility-----------------------------------
    /**
     * Parse data to a list of {@link MeshFacility MeshFacilities}
     * @param data String data to be parsed
     * @return list of {@link MeshFacility MeshFacilities}
     */
    public static ArrayList<MeshFacility> parseFacilities(String data)
    {
        return BittelParser.parseFacilities(data);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------FacilityCategory-------------------------------
    /**
     * Parse data to a list of {@link MeshFacilityCategory MeshFacilityCategories}
     * @param data String data to be parsed
     * @return list of {@link MeshFacilityCategory MeshFacilityCategories}
     */
    public static ArrayList<MeshFacilityCategory> parseFacilityCategories(String data)
    {
        return BittelParser.parseFacilityCategories(data);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------------Food------------------------------------
    /**
     * Parse data to a list of {@link MeshFood MeshFood}s
     * @param data String data to be parsed
     * @return list of {@link MeshFood MeshFood}s
     */
    public static ArrayList<MeshFood> parseFood(String data)
    {
        return BittelParser.parseFoods(data);
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------------FoodCategory--------------------------------
    /**
     * Parse data to a list of {@link MeshFoodCategory MeshFoodCategories}
     * @param data String data to be parsed
     * @return list of {@link MeshFoodCategory MeshFoodCategories}
     */
    public static ArrayList<MeshFoodCategory> parseFoodCategory(String data)
    {
        return BittelParser.parseFoodCategories(data);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------Forecast----------------------------------
    /**
     * Parse data to a list of {@link MeshWeatherForecast MeshWeatherForecast}s
     * @param data String data to be parsed
     * @return list of {@link MeshWeatherForecast MeshWeatherForecast}s
     */
    public static ArrayList<MeshWeatherForecast> parseForecast(String data)
    {
        return BittelParser.parseForecasts(data);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------------Genre-----------------------------------
    /**
     * Parse data to a list of {@link MeshGenre MeshGenre}s
     * @param data String data to be parsed
     * @return list of {@link MeshGenre MeshGenre}s
     */
    public static ArrayList<MeshGenre> parseGenre(String data)
    {
        return BittelParser.parseGenres(data);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------------Message----------------------------------
    /**
     * Parse data to a list of {@link MeshMessage MeshMessage}s
     * @param data String data to be parsed
     * @return list of {@link MeshMessage MeshMessage}s
     */
    public static ArrayList<MeshMessage> parseMessage(String data)
    {
        return BittelParser.parseMessages(data);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------------RoomType---------------------------------
    /**
     * Parse data to a list of {@link MeshRoomType MeshRoomType}s
     * @param data String data to be parsed
     * @return list of {@link MeshRoomType MeshRoomType}s
     */
    public static ArrayList<MeshRoomType> parseRoomType(String data)
    {
        return BittelParser.parseRoomTypes(data);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------------Shopping---------------------------------
    /**
     * Parse data to a list of {@link MeshShoppingItem MeshShoppingItem}s
     * @param data String data to be parsed
     * @return list of {@link MeshShoppingItem MeshShoppingItem}s
     */
    public static ArrayList<MeshShoppingItem> parseShoppingItem(String data)
    {
        return BittelParser.parseShoppingItems(data);
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------ShoppingCategory-----------------------------
    /**
     * Parse data to a list of {@link MeshShoppingCategory MeshShoppingCategories}
     * @param data String data to be parsed
     * @return list of {@link MeshShoppingCategory MeshShoppingCategories}
     */
    public static ArrayList<MeshShoppingCategory> parseShoppingCategory(String data)
    {
        return BittelParser.parseShoppingCategories(data);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------------Stat-------------------------------------
    /**
     * Parse data to a list of {@link MeshStat MeshStat}s
     * @param data String data to be parsed
     * @return list of {@link MeshStat MeshStat}s
     */
    public static ArrayList<MeshStat> parseStats(String data)
    {
        return BittelParser.parseStats(data);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------------Stream-----------------------------------
    /**
     * Parse data to a list of {@link MeshStream MeshStream}s
     * @param data String data to be parsed
     * @return list of {@link MeshStream MeshStream}s
     */
    public static ArrayList<MeshStream> parseStreams(String data)
    {
        return BittelParser.parseStreams(data);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------StreamCategory--------------------------------
    /**
     * Parse data to a list of {@link MeshStreamCategory MeshStreamCategories}
     * @param data String data to be parsed
     * @return list of {@link MeshStreamCategory MeshStreamCategories}
     */
    public static ArrayList<MeshStreamCategory> parseStreamCategory(String data)
    {
        return BittelParser.parseStreamCategories(data);
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------------VC-------------------------------------
    /**
     * Parse data to a list of {@link MeshVC MeshVC}s
     * @param data String data to be parsed
     * @return list of {@link MeshVC MeshVC}s
     */
    public static ArrayList<MeshVC> parseVC(String data)
    {
        return BittelParser.parseVCs(data);
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------------VCCategory---------------------------------
    /**
     * Parse data to a list of {@link MeshVCCategory MeshVCCategories}
     * @param data String data to be parsed
     * @return list of {@link MeshVCCategory MeshVCCategories}
     */
    public static ArrayList<MeshVCCategory> parseVCCategory(String data)
    {
        return BittelParser.parseVCCategories(data);
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------------VOD------------------------------------
    /**
     * Parse data to a list of {@link MeshVOD MeshVOD}s
     * @param data String data to be parsed
     * @return list of {@link MeshVOD MeshVOD}s
     */
    public static ArrayList<MeshVOD> parseVOD(String data)
    {
        return BittelParser.parseVODs(data);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------VODBought---------------------------------
    /**
     * Parse data to a list of {@link MeshVODBought MeshVODBought}s
     * @param data String data to be parsed
     * @return list of {@link MeshVODBought MeshVODBought}s
     */
    public static ArrayList<MeshVODBought> parseVODsBought(String data)
    {
        return  BittelParser.parseVODsBought(data);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------WeatherV2---------------------------------
    /**
     * Parse data to a list of {@link MeshWeatherV2 MeshWeatherV2}s
     * @param data String data to be parsed
     * @return list of {@link MeshWeatherV2 MeshWeatherV2}s
     */
    public static ArrayList<MeshWeatherV2> parseWeatherV2(String data)
    {
        return BittelParser.parseWeatherV2s(data);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------------ConciergeCat----------------------------
    /**
     * Parse data to a list of {@link MeshConciergeCategory MeshConciergeCategories}
     * @param data String data to be parsed
     * @return list of {@link MeshConciergeCategory MeshConciergeCategories}
     */
    public static ArrayList<MeshConciergeCategory> parseConciergeCategories(String data)
    {
        return BittelParser.parseConciergeCategories(data);
    }
    //----------------------------------------------------------------------------------------------

    //-----------------------------------------------------ConciergeItem----------------------------
    /**
     * Parse data to a list of {@link MeshConciergeRequestItem MeshConciergeRequestItem}s
     * @param data String data to be parsed
     * @return list of {@link MeshConciergeRequestItem MeshConciergeRequestItem}s
     */
    public static ArrayList<MeshConciergeRequestItem> parseConciergeItems(String data)
    {
        return BittelParser.parseRequestItems(data);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------------ConciergeSvc-----------------------------
    /**
     * Parse data to a list of {@link MeshConciergeRequestService MeshConciergeRequestService}s
     * @param data String data to be parsed
     * @return list of {@link MeshConciergeRequestService MeshConciergeRequestService}s
     */
    public static ArrayList<MeshConciergeRequestService> parseConciergeServices(String data)
    {
        return BittelParser.parseRequestServices(data);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================V 2.0===============================================
    //---------------------------------------MeshPackage--------------------------------------------
    /**
     * Parse data to a list of {@link MeshPackage MeshPackage}s
     * @param data String data to be parsed
     * @return list of {@link MeshPackage MeshPackage}s
     */
    public static ArrayList<MeshPackage> parsePackages(String data)
    {
        return BittelParser.parsePackages(data);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------MeshPackageChannel------------------------------------------
    /**
     * Parse data to a list of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackageChannel MeshPackageChannel}s
     * @param data String data to be parsed
     * @return list of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackageChannel MeshPackageChannel}s
     */
    public static ArrayList<MeshPackageChannel> parsePackageChannels(String data)
    {
        return BittelParser.parsePackageChannels(data);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------MeshSubscription------------------------------------------
    /**
     * Parse data to a list of {@link MeshSubscription MeshSubscription}s
     * @param data String data to be parsed
     * @return list of {@link MeshSubscription MeshSubscription}s
     */
    public static ArrayList<MeshSubscription> parseSubscriptions(String data)
    {
        return BittelParser.parseSubscriptions(data);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------MeshSubscription------------------------------------------
//    /**
//     * Parse data to a list of {@link MeshSubscriber MeshSubscriber}s
//     * @param data String data to be parsed
//     * @return list of {@link MeshSubscriber MeshSubscriber}s
//     */
//    public static ArrayList<MeshSubscriber> parseSubscribers(String data)
//    {
//        return BittelParser.parseSubscribers(data);
//    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------MeshEPG----------------------------------------------
    /**
     * Parse data to a list of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshEPG MeshEPG}s
     * @param data String data to be parsed
     * @return list of {@link MeshEPG MeshEPG}s
     */
    public static ArrayList<MeshEPG> parseEPGs(String data)
    {
        return BittelParser.parseEPGs(data);
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------MeshTelecomBill------------------------------------------
    /**
     * Parse data to a list of {@link MeshTelecomBill MeshTelecomBill}s
     * @param data String data to be parsed
     * @return list of {@link MeshTelecomBill MeshTelecomBill}s
     */
    public static ArrayList<MeshTelecomBill> parseTeleBills(String data)
    {
        return BittelParser.parseTeleBills(data);
    }
    //----------------------------------------------------------------------------------------------

    //--------------------------------------MeshSignage---------------------------------------------

    /**
     * Parse data to a list of {@link MeshSignage MeshSignage}s
     * @param data String data to be parsed
     * @return list of {@link MeshSignage MeshSignage}s
     */
    public static ArrayList<MeshSignage> parseSignages(String data){return BittelParser.parseSignages(data);}
    //----------------------------------------------------------------------------------------------

    //-------------------------------------MeshCompany----------------------------------------------

    /**
     * Parse data to a list of {@link MeshCompany MeshCompany}s
     * @param data String to be parsed
     * @return list of {@link MeshCompany MeshCompany}s
     */
    public static ArrayList<MeshCompany> parseCompanies(String data){return BittelParser.parseCompanies(data);}
    //-----------------------------------------------------------------------------------------------
    //-----------------------------------------MeshLayout-------------------------------------------

    public static ArrayList<MeshLayout> parseLayouts(String data)
    {
        return BittelParser.parseLayouts(data);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------MeshSchedule-------------------------------------------

    public static ArrayList<MeshSchedule> parseSchedules(String data)
    {
        return BittelParser.parseSchedules(data);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------MeshSignageSchedule----------------------------------

    public static ArrayList<MeshSignageSchedule> parseSignageSchedules(String data)
    {

        return BittelParser.parseSignageSchedules(data);
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------MeshLayoutV2--------------------------------------

    public static ArrayList<MeshLayoutV2> parseMeshLayoutV2s(String data)
    {

        return BittelParser.parseMeshLayoutV2s(data);
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------MeshMediaV2---------------------------------------

    public static ArrayList<MeshMediaV2> parseMediaV2s(String data)
    {

        return BittelParser.parseMediaV2s(data);
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------MeshMediaZone-------------------------------------

    public static ArrayList<MeshMediaZone> parseMediaZones(String data)
    {

        return BittelParser.parseMediaZones(data);
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------MeshMediaZoneAssignment---------------------------------

    public static ArrayList<MeshMediaZoneAssignment> parseMediaZoneAssignments(String data)
    {

        return BittelParser.parseMediaZoneAssignments(data);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------=-----------MeshSignageV2------------------------------------

    public static ArrayList<MeshSignageV2> parseSignageV2s(String data)
    {
        return BittelParser.parseSignageV2s(data);
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------MeshType---------------------------------------

    public static ArrayList<MeshType> parseTypes(String data)
    {
        return BittelParser.parseTypes(data);
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------MeshScrollingMessage-----------------------------
    public static ArrayList<MeshScrollingMessage> parseScrollingMessages(String data)
    {
        return BittelParser.parseScrollingMessages(data);
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------MeshTVFeed-----------------------------------
    public static ArrayList<MeshTVFeed> parseFeeds(String data)
    {
        return BittelParser.parseFeeds(data);
    }
    //----------------------------------------------------------------------------------------------

    //==============================================================================================
}
