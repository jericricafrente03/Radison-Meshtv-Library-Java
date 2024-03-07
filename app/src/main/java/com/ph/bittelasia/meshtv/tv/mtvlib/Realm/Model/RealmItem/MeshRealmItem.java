package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RealmItem;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshConfig;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshGuest;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshIPTV;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshWeatherLocal;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Bill.MeshBillV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestService;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFood;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFoodCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacility;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacilityCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshArrivalFlight;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshDepartureFlight;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshCity;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshContinent;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Music.MeshMusic;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Music.MeshMusicCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RoomType.MeshRoomType;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStream;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStreamCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshGenre;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast;

import org.json.JSONObject;

public class MeshRealmItem
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshRealmItem.class.getSimpleName();
    public static final String TAG_DISPLAYNAME = "displayname";
    public static final String TAG_CLASS = "classname";

    public static final String TAG_BILL                 = "MeshBillV2";
    public static final String TAG_CHANNEL              = "MeshChannel";
    public static final String TAG_CHANNEL_CATEGORY     = "MeshChannelCategory";
    public static final String TAG_CONCIERGE_CATEGORY   = "MeshConciergeCategory";
    public static final String TAG_CONCIERGE_ITEM       = "MeshConciergeRequestItem";
    public static final String TAG_CONCIERGE_SVC        = "MeshConciergeRequestService";
    public static final String TAG_FOOD                 = "MeshFood";
    public static final String TAG_FOOD_CATEGORY        = "MeshFoodCategory";
    public static final String TAG_FACILITY             = "MeshFacility";
    public static final String TAG_FACILITY_CATEGORY    = "MeshFacilityCategory";
    public static final String TAG_ARRIVAL_FLIGHT       = "MeshArrivalFlight";
    public static final String TAG_DEPARTURE_FLIGHT     = "MeshDepartureFlight";
    public static final String TAG_CITY                 = "MeshCity";
    public static final String TAG_CONTINENT            = "MeshContinent";
    public static final String TAG_MESSAGE              = "MeshMessage";
    public static final String TAG_ROOMTYPE             = "MeshRoomType";
    public static final String TAG_MUSIC                = "MeshMusic";
    public static final String TAG_MUSIC_CATEGORY       = "MeshMusicCategory";
    public static final String TAG_SHOPPING             = "MeshShoppingItem";
    public static final String TAG_SHOPPING_CATEGORY    = "MeshShoppingCategory";
    public static final String TAG_STREAM               = "MeshStream";
    public static final String TAG_STREAM_CATEGORY      = "MeshStreamCategory";
    public static final String TAG_VC                   = "MeshVC";
    public static final String TAG_VC_CATEGORY          = "MeshVCCategory";
    public static final String TAG_VOD                  = "MeshVOD";
    public static final String TAG_GENRE                = "MeshGenre";
    public static final String TAG_WEATHER_FORECAST     = "MeshWeatherForecast";
    public static final String TAG_WEATHER_V2     = "MeshWeatherV2";
    public static final String TAG_GUEST                = "MeshGuest";
    public static final String TAG_CONFIG               = "MeshConfig";
    public static final String TAG_WEATHER              = "MeshWeatherLocal";
    public static final String TAG_IPTV                 = "MeshIPTV";
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    String displayName = "";
    Class c = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Constructor========================================
    public MeshRealmItem(String data)
    {
        try
        {
            JSONObject object = new JSONObject(data);
            displayName = object.getString(TAG_DISPLAYNAME);
            setC(object.getString(TAG_CLASS));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public MeshRealmItem()
    {

    }
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    public String getDisplayName() {
        return displayName;
    }
    public Class getC() {
        return c;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public void setC(String classname) {
        switch (classname)
        {
            case TAG_BILL:
                c = MeshBillV2.class;
                break;
            case TAG_CHANNEL:
                c = MeshChannel.class;
                break;
            case TAG_CHANNEL_CATEGORY:
                c = MeshChannelCategory.class;
                break;
            case TAG_CONCIERGE_CATEGORY:
                c = MeshConciergeCategory.class;
                break;
            case TAG_CONCIERGE_ITEM:
                c = MeshConciergeRequestItem.class;
                break;
            case TAG_CONCIERGE_SVC:
                c = MeshConciergeRequestService.class;
                break;
            case TAG_FOOD:
                c = MeshFood.class;
                break;
            case TAG_FOOD_CATEGORY:
                c = MeshFoodCategory.class;
                break;
            case TAG_FACILITY:
                c = MeshFacility.class;
                break;
            case TAG_FACILITY_CATEGORY:
                c = MeshFacilityCategory.class;
                break;
            case TAG_ARRIVAL_FLIGHT:
                c = MeshArrivalFlight.class;
                break;
            case TAG_DEPARTURE_FLIGHT:
                c = MeshDepartureFlight.class;
                break;
            case TAG_CITY:
                c = MeshCity.class;
                break;
            case TAG_CONTINENT:
                c = MeshContinent.class;
                break;
            case TAG_MESSAGE:
                c = MeshMessage.class;
                break;
            case TAG_ROOMTYPE:
                c = MeshRoomType.class;
                break;
            case TAG_MUSIC:
                c = MeshMusic.class;
                break;
            case TAG_MUSIC_CATEGORY:
                c = MeshMusicCategory.class;
                break;
            case TAG_SHOPPING:
                c = MeshShoppingItem.class;
                break;
            case TAG_SHOPPING_CATEGORY:
                c = MeshShoppingCategory.class;
                break;
            case TAG_STREAM:
                c = MeshStream.class;
                break;
            case TAG_STREAM_CATEGORY:
                c = MeshStreamCategory.class;
                break;
            case TAG_VC:
                c = MeshVC.class;
                break;
            case TAG_VC_CATEGORY:
                c = MeshVCCategory.class;
                break;
            case TAG_VOD:
                c = MeshVOD.class;
                break;
            case TAG_GENRE:
                c = MeshGenre.class;
                break;
            case TAG_WEATHER_FORECAST:
                c = MeshWeatherForecast.class;
                break;
            case TAG_GUEST:
                c = MeshGuest.class;
                break;
            case TAG_CONFIG:
                c = MeshConfig.class;
                break;
            case TAG_WEATHER:
                c = MeshWeatherLocal.class;
                break;
            case TAG_IPTV:
                c = MeshIPTV.class;
                break;
            case TAG_WEATHER_V2:
                c = MeshWeatherV2.class;
                break;
        }
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
