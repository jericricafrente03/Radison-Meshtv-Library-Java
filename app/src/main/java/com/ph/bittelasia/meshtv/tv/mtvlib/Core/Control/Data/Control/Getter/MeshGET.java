package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Getter;

import android.content.Context;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners.MeshParamListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.Data.Model.MeshData;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshEPG;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackageChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshSubscriber;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshSubscription;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshTelecomBill;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVODBought;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Class that requests GET API calls to the server
 * <br>Version 2.0 added support for:
 *
 * <br>1. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackage MeshPackage}
 * <br>2. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackageChannel MeshPackageChannel}
 * <br>3. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshSubscription MeshSubscription}
 *
 * @author Mars Ray Canizares Araullo
 * @version 2.0
 */
final class MeshGET
{

    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    static final String TAG                 = MeshGET.class.getSimpleName();
    /**
     * Directory of API Calls in the MeshTVServer
     */
    static final String DIR                 = "/index.php/apicall/";
    /**
     * API to request customer details - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshGuest MeshGuest}
     */
    static final String CUSTOMER            = "get_customer";
    /**
     * API to request airmedia credentials - {@link com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Model.MeshAirMedia MeshAirMedia}
     */
    static final String AIRMEDIA_USER       = "get_airmedia_user";
    /**
     * API to request data of airports  - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshAirport MeshAirport}
     */
    static final String AIRPORT_NAME        = "get_airport_name";
    /**
     * API to request data of virtual concierge - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC MeshVC}
     */
    static final String VC                  = "get_all_establishments";
    /**
     * API to request data of food items  - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFood MeshFood}
     */
    static final String FOOD                = "get_all_f_and_b_item";
    /**
     * API to request data of facilities  - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacility MeshFacility}
     */
    static final String FACILITY            = "get_all_facilities";
    /**
     * API to request data of item requests  - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestItem MeshConciergeRequestItem}
     */
    static final String ITEM_REQ            = "get_all_item_request";
    /**
     * API to request data of service requests - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestService MeshConciergeRequestService}
     */
    static final String SVC_REQ             = "get_all_service_request";
    /**
     * API to request data of shopping items - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem MeshShoppingItem}
     */
    static final String SHOPPING_ITEM       = "get_all_shopping_item";
    /**
     * API to request data of TV Channels - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel MeshChannel}
     */
    static final String TV                  = "get_all_tv_channel";
    /**
     * API to request data of Arrival Flights  - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshArrivalFlight MeshArrivalFlight}
     */
    static final String ARRIVAL_FLIGHT      = "get_arrival_flights";
    /**
     * API to request data of Concierge Categories - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeCategory MeshConciergeCategory}
     */
    static final String CONCIERGE_CATEGORY  = "get_concierge_category";
    /**
     * API to request data of hotel configuration - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshConfig MeshConfig}
     */
    static final String CONFIG              = "get_config";
    /**
     * API to request data of continents - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshContinent MeshContinent}
     */
    static final String CONTINENTS          = "get_continents";
    /**
     * API to request data of departing flights - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshDepartureFlight MeshDepartureFlight}
     */
    static final String DEPARTURE_FLIGHT    = "get_departure_flights";
    /**
     * API to request data of extras - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Tag.MeshTag MeshTag}
     */
    static final String EXTRAS              = "get_extras";
    /**
     * API to request data of food categories  - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFoodCategory MeshFoodCategory}
     */
    static final String FOOD_CATEGORY       = "get_f_and_b_category";
    /**
     * API to request data of genres - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshGenre MeshGenre}
     */
    static final String GENRES              = "get_genres";
    /**
     * API to request data of live stream categories - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStreamCategory MeshStreamCategory}
     */
    static final String LIVESTREAM_CAT      = "get_live_stream_category";
    /**
     * API to request data of live stream series  - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStream MeshStream}
     */
    static final String LIVESTREAM_SER      = "get_live_stream_series";
    /**
     * API to request data of map categories - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory MeshVCCategory}
     */
    static final String MAP_CATEGORIES      = "get_maps_categories";
    /**
     * API to request data of shopping categories - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingCategory MeshShoppingCategory}
     */
    static final String SHOPPING_CATEGORY   = "get_shopping_category";
    /**
     * API to request data of channel categories - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory MeshChannelCategory}
     */
    static final String TV_CATEGORY         = "get_tv_channel_category";
    /**
     * API to request data of VOD items - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD MeshVOD}
     */
    static final String VOD                 = "get_vod";
    /**
     * API to request data of Weather items - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2 MeshWeatherV2}
     */
    static final String WEATHER             = "get_all_countries_and_weather";
    /**
     * API to request data of Weather Forecast items - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast MeshWeatherForecast}
     */
    static final String WEATHER_FORECAST    = "get_all_countries_and_weatherforecast";
    /**
     * API to request data of Message items - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage MeshMessage}
     */
    static final String MESSAGE             = "get_message";
    /**
     * API to request data of Bill items (UNUSED) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Bill.MeshBillV2  MeshBillV2}
     */
    static final String BILL                = "view_bill2";
    /**
     * API to request data of Bill items - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Bill.MeshBillV2  MeshBillV2}
     */
    static final String XBILL               = "view_bill2_xr";
    /**
     * API to request data of facility categories  - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacilityCategory MeshFacilityCategory}
     */
    static final String FACILITY_CATEGORY   = "get_facility_category";
    /**
     * API to request data of Bought - {@link MeshVODBought  MeshVODBought}
     */
    static final String VOD_BOUGHT          = MeshVODBought.API;
    /**
     * API to request data of packages - {@link MeshPackage  MeshPackage}
     */
    static final String PACKAGES            = MeshPackage.CLASS_NAME;
    /**
     * API to request data of package channels - {@link MeshPackageChannel  MeshPackageChannel}
     */
    static final String PACKAGE_CHANNELS    = MeshPackageChannel.CLASS_NAME;
    /**
     * API to request data of subscriptions - {@link MeshSubscription  MeshSubscription}
     */
    static final String SUBSCRIPTIONS       = MeshSubscription.CLASS_NAME;
    /**
     * API to request data of subscribers - {@link MeshSubscriber  MeshSubscriber}
     */
    static final String SUBSCRIBERS         = MeshSubscriber.CLASS_NAME;
    static final String EPG                 = MeshEPG.CLASS_NAME;
    static final String TELE_BILL           = MeshTelecomBill.CLASS_NAME;
    static final String LAYOUT              = "get_layout";
    static final String SCHEDULE            = "get_schedule";
    static final String SIGNAGE_SCHEDULE    = "get_signage_schedule";
    static final String SIGNAGE             = "get_all_signages";
    static final String COMPANY             = "get_all_companies";
    static final String SCROLLING_MESSAGE             = MeshData.SCROLLING_MESSAGES;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Method==========================================
    /**
     * Retrieves data from the server
     * @param context - retrieves App Context if null
     * @param api - API to be requested
     * @param listener - retrieves parameters from the asynchronous task implementing {@link MeshParamListener MeshParamListener} that invoked this method
     * @return response of API call
     */
    public final String get(Context context, String api, MeshParamListener listener)
    {
        String result = null;
        if(context==null)
        {
            context = MeshTVApp.get().getApplicationContext();
        }

        String source =
                MeshTVPreferenceManager.getHTTPHost(context)
                        +":"
                        +MeshTVPreferenceManager.getHTTPPort(context)
                        +DIR
                        +api;

        source = listener.requestParams(source);
        try
        {
            Log.i(TAG,"GETTING:"+source);
            URL url = new URL(source.replaceAll("\\n",""));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(MeshTVPreferenceManager.getTimeOut(context));
            conn.setConnectTimeout(MeshTVPreferenceManager.getConnectionTimeout(context));
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            StringBuilder responseOutput = new StringBuilder();

            while((line = br.readLine()) != null ) {
                responseOutput.append(line);
            }
            result =responseOutput.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }

        return result;
    }
    //==============================================================================================
}
