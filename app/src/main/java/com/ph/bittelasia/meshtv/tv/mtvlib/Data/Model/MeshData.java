package com.ph.bittelasia.meshtv.tv.mtvlib.Data.Model;

import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Model.MeshAirMedia;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Parser.MeshParser;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshConfig;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshGuest;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshEPG;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackageChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshSubscriber;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshSubscription;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshTelecomBill;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVODBought;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;

import org.json.JSONObject;

import java.util.ArrayList;

import io.realm.Realm;

/**
 * Used to parse JSON Data into a list of objects depending on its class
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshData {
    //==========================================Variable============================================
    //------------------------------------------Constant--------------------------------------------
    public static final String TAG = MeshData.class.getSimpleName();
    /**
     * Tag to retrieve data from the JSONObject
     */
    public static final String TAG_DATA = "data";
    /**
     * Tag to retrieve class from the JSONObject
     */
    public static final String TAG_CLASSNAME = "class";
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Classes---------------------------------------------

    public static final String NOTIFICATION = "get_notification";
    /**
     * Class for {@link MeshAirMedia MeshAirmedia}
     */
    public static final String AIRMEDIA             = "get_airmedia_user";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshAirport MeshAirport}
     */
    public static final String AIRPORT              = "get_airport_name";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel MeshChannel}
     */
    public static final String CATEGORY_CHANNEL     = "get_tv_channel_category";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory MeshChannelCategory}
     */
    public static final String CATEGORY_CONCIERGE   = "get_concierge_category";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacilityCategory MeshFacilityCategory}
     */
    public static final String CATEGORY_FACILITY    = "get_facility_category";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFoodCategory MeshFoodCategory}
     */
    public static final String CATEGORY_FOOD        = "get_f_and_b_category";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshGenre MeshGenre}
     */
    public static final String CATEGORY_GENRE       = "get_genres";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStreamCategory MeshStreamCategory}
     */
    public static final String CATEGORY_LIVE_STREAM = "get_live_stream_category";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory MeshVCCategory}
     */
    public static final String CATEGORY_MAP         = "get_maps_categories";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingCategory MeshShoppingCategory}
     */
    public static final String CATEGORY_SHOPPING    = "get_shopping_category";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel MeshChannel}
     */
    public static final String CHANNELS             = "get_all_tv_channel";
    /**
     * Class for {@link MeshConfig MeshConfig}
     */
    public static final String CONFIG               = "get_config";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshContinent MeshContinent}
     */
    public static final String CONTINENTS           = "get_continents";
    /**
     * Class for {@link MeshGuest MeshGuest}
     */
    public static final String CUSTOMER             = "get_customer";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Tag.MeshTag MeshTag}
     */
    public static final String EXTRAS               = "get_extras";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacility MeshFacility}
     */
    public static final String FACILITIES           = "get_all_facilities";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshArrivalFlight MeshArrivalFlight}
     */
    public static final String FLIGHT_ARRIVAL       = "get_arrival_flights";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshDepartureFlight MeshDepartureFlight}
     */
    public static final String FLIGHT_DEPARTURE     = "get_departure_flights";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFood MeshFood}
     */
    public static final String FOOD                 = "get_all_f_and_b_item";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestItem MeshConciergeRequestItem}
     */
    public static final String ITEMS                = "get_all_item_request";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStream MeshStream}
     */
    public static final String LIVE_STREAM          = "get_live_stream_series";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RoomType.MeshRoomType MeshRoomType}
     */
    public static final String ROOM                 = "room_type";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage MeshMessage}
     */
    public static final String MESSAGE              = "get_message";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem MeshShoppingItem}
     */
    public static final String SHOPPING             = "get_all_shopping_item";
    /**
     * Class for {@link  com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestService MeshConciergeRequestService}
     */
    public static final String SVC                  = "get_all_service_request";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC MeshVC}
     */
    public static final String VC                   = "get_all_establishments";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD MeshVOD}
     */
    public static final String VOD                  = "get_vod";
    /**
     * Class for {@link MeshVODBought MeshVODBought}
     */
    public static final String VOD_BOUGHT           = MeshVODBought.API;
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2 MeshWeatherV2}
     */
    public static final String WEATHER              = "get_all_countries_and_weather";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast MeshWeatherForecast}
     */
    public static final String WEATHER_FORECAST     = "get_all_countries_and_weatherforecast";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Bill.MeshBillV2 MeshBillV2}
     */
    public static final String VIEW_BILL            = "view_bill";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshSignage MeshSignage}
     */
    public static final String SIGNAGE              = "get_all_signages";
    /**
     * Class for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshCompany MeshCompany}
     */
    public static final String COMPANY                  = "get_all_companies";
    public static final String PACKAGES                 = MeshPackage.CLASS_NAME;
    public static final String PACKAGE_CHANNELS         = MeshPackageChannel.CLASS_NAME;
    public static final String SUBSCRIPTION             = MeshSubscriber.CLASS_NAME;
    public static final String SUBSCRIPTION_PACKAGE     = MeshSubscription.CLASS_NAME;
    public static final String EPG                      = MeshEPG.CLASS_NAME;
    public static final String TELE_BILL                = MeshTelecomBill.CLASS_NAME;
    public static final String LAYOUT                   = "get_layout";
    public static final String SCHEDULE                 = "get_schedule";
    public static final String SIGNAGE_SCHEDULE         = "get_signage_schedule";
    public static final String SIGNAGE_V2               = "get_all_signage_v2";
    public static final String ZONE                     = "get_all_zone_assignment";
    public static final String MEDIA                    = "get_all_media";
    public static final String MEDIA_ZONE               = "get_all_media_zone";
    public static final String MEDIA_TYPE               = "get_all_type";
    public static final String LAYOUT_V2                = "get_all_layout_v2";
    public static final String SCROLLING_MESSAGES       = "get_all_scrolling_messages";
    public static final String FEEDS                    = MeshTVFeed.TAG_API;
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Instance--------------------------------------------
    /**
     * Contents of {@link #TAG_DATA TAG_DATA} from JSONObject
     */
    String data;
    /**
     * Contents of {@link #TAG_CLASSNAME TAG_CLASSNAME} from JSONObject
     */
    String class_name;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================Constructor=========================================

    /**
     * Defaullt Constructo of {@link MeshData MeshData}
     * @param data JSON formatted String to be parsed
     */
    public MeshData(String data) {
        try {
            JSONObject object = new JSONObject(data);
            this.data = data;
            class_name = object.getString(TAG_CLASSNAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //==============================================================================================
    //==========================================Constructor=========================================
    //--------------------------------------------Getter--------------------------------------------

    /**
     * Returns {@link #data data}
     * @return {@link  #data data}
     */
    public String getData() {
        return data;
    }
    /**
     * Returns {@link #class_name class_name}
     * @return {@link  #class_name class_name}
     */
    public String getClass_name() {
        return class_name;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Setter--------------------------------------------
    /**
     * Sets the new value for {@link #data data}
     * @param data new value for {@link #data data}
     */
    public void setData(String data) {
        this.data = data;
    }
    /**
     * Sets the new value for {@link #class_name class_name}
     * @param class_name new value for {@link #class_name class_name}
     */
    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Action--------------------------------------------

    /**
     * Updates the data by matching data with its corresponding class and updating all data associated to it
     */
    public void updateData()
    {
        Log.i(TAG,"MTV-Parsing:"+class_name);
        switch (class_name)
        {
            case SUBSCRIPTION:
                ((MeshSubscriber)parse().get(0)).compare();
                break;
            case AIRMEDIA:
                ((MeshAirMedia)parse().get(0)).update();
                break;
            case CONFIG:
                ((MeshConfig)parse().get(0)).compare();
                break;
            case CUSTOMER:
                ((MeshGuest)parse().get(0)).compare();
                break;
            case PACKAGES:
            case PACKAGE_CHANNELS:
            case SUBSCRIPTION_PACKAGE:
            case AIRPORT:
            case VOD_BOUGHT:
            case CATEGORY_CHANNEL:
            case CATEGORY_CONCIERGE:
            case CATEGORY_FACILITY:
            case CATEGORY_FOOD:
            case CATEGORY_GENRE:
            case CATEGORY_LIVE_STREAM:
            case CATEGORY_MAP:
            case CATEGORY_SHOPPING:
            case CHANNELS:
            case CONTINENTS:
            case EXTRAS:
            case FACILITIES:
            case FOOD:
            case FLIGHT_ARRIVAL:
            case SIGNAGE_V2:
            case ZONE:
            case MEDIA:
            case MEDIA_ZONE:
            case MEDIA_TYPE:
            case LAYOUT_V2:
            case FLIGHT_DEPARTURE:
            case ITEMS:
            case LIVE_STREAM:
            case MESSAGE:
            case SHOPPING:
            case ROOM:
            case FEEDS:
            case SVC:
            case VC:
            case VOD:
            case WEATHER:
            case WEATHER_FORECAST:
            case VIEW_BILL:
            case EPG:
            case TELE_BILL:
            case SIGNAGE:
            case COMPANY:
            case LAYOUT:
            case SCHEDULE:
            case SIGNAGE_SCHEDULE:
            case SCROLLING_MESSAGES:
                MeshRealmManager.insertBulk(parse());
                break;
            case NOTIFICATION:
                MeshMessage meshMessage = (MeshMessage) parse().get(0);
                MeshTVApp.get().notify(meshMessage);
                break;
        }
    }

    /**
     * Returns a list of parsed Objects from the data set matching its class
     * @return parsed Objects
     */
    public ArrayList<Object> parse()
    {
        Log.i(TAG,"MTV-Parsing:"+data);
        final ArrayList<Object> os = new ArrayList<>();
        switch (class_name)
        {
            case SCROLLING_MESSAGES:
                os.addAll(MeshParser.parseScrollingMessages(data));
                break;
            case LAYOUT:
                os.addAll(MeshParser.parseLayouts(data));
                break;
            case SCHEDULE:
                os.addAll(MeshParser.parseSchedules(data));
                break;
            case SIGNAGE_SCHEDULE:
                os.addAll(MeshParser.parseSignageSchedules(data));
                break;
            case NOTIFICATION:
                os.addAll(MeshParser.parseMessage(data));
                break;
            case TELE_BILL:
                os.addAll(MeshParser.parseTeleBills(data));
                break;
            case PACKAGES:
                os.addAll(MeshParser.parsePackages(data));
                break;
            case PACKAGE_CHANNELS:
                os.addAll(MeshParser.parsePackageChannels(data));
                break;
            case FEEDS:
                os.addAll(MeshParser.parseFeeds(data));
                break;
            case SUBSCRIPTION_PACKAGE:
                Realm r = Realm.getDefaultInstance();
                r.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.delete(MeshSubscription.class);
                        MeshTVApp.get().onSubscriptionsReset();
                        os.addAll(MeshParser.parseSubscriptions(data));
                    }
                });
                break;
            case SUBSCRIPTION:
                try
                {
                    JSONObject o = new JSONObject(data);
                    os.add(new MeshSubscriber(o.getString("data")));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
            case AIRMEDIA:
                Log.i(TAG,"MTV-Parsing:Airmedia");
                try
                {
                    JSONObject o = new JSONObject(data);
                    os.add(new MeshAirMedia(o.getString("data")));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
            case AIRPORT:
                Log.i(TAG,"MTV-Parsing:Airport");
                os.addAll(MeshParser.parseAirports(data));
                break;
            case CATEGORY_CHANNEL:
                Log.i(TAG,"MTV-Parsing:Channel Categories");
                os.addAll(MeshParser.parseChannelCategories(data));
                break;
            case CATEGORY_CONCIERGE:
                Log.i(TAG,"MTV-Parsing:Concierge Categories");
                os.addAll(MeshParser.parseConciergeCategories(data));
                break;
            case CATEGORY_FACILITY:
                Log.i(TAG,"MTV-Parsing:Facility Categories");
                os.addAll(MeshParser.parseFacilityCategories(data));
                break;
            case CATEGORY_FOOD:
                Log.i(TAG,"MTV-Parsing:Food Categories");
                os.addAll(MeshParser.parseFoodCategory(data));
                break;
            case CATEGORY_GENRE:
                Log.i(TAG,"MTV-Parsing:Genre");
                os.addAll(MeshParser.parseGenre(data));
                break;
            case CATEGORY_LIVE_STREAM:
                Log.i(TAG,"MTV-Parsing:Stream Categories");
                os.addAll(MeshParser.parseStreamCategory(data));
                break;
            case CATEGORY_MAP:
                Log.i(TAG,"MTV-Parsing:VC Categories");
                os.addAll(MeshParser.parseVCCategory(data));
                break;
            case CATEGORY_SHOPPING:
                Log.i(TAG,"MTV-Parsing:Shopping Categories");
                os.addAll(MeshParser.parseShoppingCategory(data));
                break;
            case CHANNELS:
                Log.i(TAG,"MTV-Parsing:Channel");
                os.addAll(MeshParser.parseChannels(data));
                break;
            case CONFIG:
                Log.i(TAG,"MTV-Parsing:Config");
                try
                {
                    JSONObject o = new JSONObject(data);
                    os.add(new MeshConfig(o.getString("data")));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
            case CONTINENTS:
                Log.i(TAG,"MTV-Parsing:Continents");
                os.addAll(MeshParser.parseContinents(data));
                break;
            case CUSTOMER:
                Log.i(TAG,"MTV-Parsing:Customer");
                try
                {
                    JSONObject o = new JSONObject(data);
                    os.add(new MeshGuest(o.getString("data")));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                break;
            case EXTRAS:
                Log.i(TAG,"MTV-Parsing:Tags");
                os.addAll(MeshParser.parseTags(data));
                break;
            case FACILITIES:
                Log.i(TAG,"MTV-Parsing:Facilities");
                os.addAll(MeshParser.parseFacilities(data));
                break;
            case FOOD:
                Log.i(TAG,"MTV-Parsing:Food");
                os.addAll(MeshParser.parseFood(data));
                break;
            case FLIGHT_ARRIVAL:
                Log.i(TAG,"MTV-Parsing:Arrival Flights");
                os.addAll(MeshParser.parseArrivalFlights(data));
                break;
            case FLIGHT_DEPARTURE:
                Log.i(TAG,"MTV-Parsing:Departure Flights");
                os.addAll(MeshParser.parseDepartureFlights(data));
                break;
            case ITEMS:
                Log.i(TAG,"MTV-Parsing:Items");
                os.addAll(MeshParser.parseConciergeItems(data));
                break;
            case LIVE_STREAM:
                Log.i(TAG,"MTV-Parsing:Streams");
                os.addAll(MeshParser.parseStreams(data));
                break;
            case MESSAGE:
                Log.i(TAG,"MTV-Parsing:Message");
                os.addAll(MeshParser.parseMessage(data));
                break;
            case SHOPPING:
                Log.i(TAG,"MTV-Parsing:Shopping");
                os.addAll(MeshParser.parseShoppingItem(data));
                break;
            case ROOM:
                Log.i(TAG,"MTV-Parsing:Room Type");
                os.addAll(MeshParser.parseRoomType(data));
                break;
            case SVC:
                Log.i(TAG,"MTV-Parsing:Services");
                os.addAll(MeshParser.parseConciergeServices(data));
                break;
            case VC:
                Log.i(TAG,"MTV-Parsing:VC");
                os.addAll(MeshParser.parseVC(data));
                break;
            case VOD:
                Log.i(TAG,"MTV-Parsing:VOD");
                os.addAll(MeshParser.parseVOD(data));
                break;
            case WEATHER:
                Log.i(TAG,"MTV-Parsing:Weather");
                os.addAll(MeshParser.parseWeatherV2(data));
                break;
            case WEATHER_FORECAST:
                Log.i(TAG,"MTV-Parsing:Weather Forecast");
                os.addAll(MeshParser.parseForecast(data));
                break;
            case VIEW_BILL:
                Log.i(TAG,"MTV-Parsing:View Bill");
                os.addAll(MeshParser.parseBills(data));
                break;
            case VOD_BOUGHT:
                os.addAll(MeshParser.parseVODsBought(data));
                break;
            case EPG:
                os.addAll(MeshParser.parseEPGs(data));
                break;
            case SIGNAGE:
                Log.i(TAG,"MTV-Parsing:Signage");
                os.addAll(MeshParser.parseSignages(data));
                break;
            case COMPANY:
                Log.i(TAG,"MTV-Parsing:Company");
                os.addAll(MeshParser.parseCompanies(data));
                break;
            case SIGNAGE_V2:
                os.addAll(MeshParser.parseSignageV2s(data));
                break;
            case ZONE:
                os.addAll(MeshParser.parseMediaZoneAssignments(data));
                break;
            case MEDIA:
                os.addAll(MeshParser.parseMediaV2s(data));
                break;
            case MEDIA_ZONE:
                os.addAll(MeshParser.parseMediaZones(data));
                break;
            case MEDIA_TYPE:
                os.addAll(MeshParser.parseTypes(data));
                break;
            case LAYOUT_V2:
                os.addAll(MeshParser.parseMeshLayoutV2s(data));
                break;
        }
        Log.i(TAG,"MTV-Parsing:"+os.size());
        return os;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
