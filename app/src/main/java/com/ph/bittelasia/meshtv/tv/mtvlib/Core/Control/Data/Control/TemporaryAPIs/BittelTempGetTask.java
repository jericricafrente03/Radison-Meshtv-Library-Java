package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.TemporaryAPIs;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Model.MeshAirMedia;
import com.ph.bittelasia.meshtv.tv.mtvlib.BuildConfig;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners.MeshParamListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Settings.AppMode;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Constant.AppDataSource;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Getter.MeshAdditionalParam;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Parser.MeshParser;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshConfig;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshGuest;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshSubscriber;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshWeatherLocal;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.FileReader.MeshTVFileManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util.MeshAPIKeyRetriever;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.Data.Model.MeshData;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Bill.MeshBillV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshEPG;
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
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Music.MeshMusic;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Music.MeshMusicCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RoomType.MeshRoomType;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Statistics.MeshStat;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStream;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStreamCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Tag.MeshTag;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackageChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshSubscription;
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
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshZone;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshLayoutV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaZone;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaZoneAssignment;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshScrollingMessage;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshSignageV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshType;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Requests for data depending on the datasource and API call
 * <br>Version 2.0 added support for:
 *
 * <br>1. {@link MeshPackage MeshPackage}
 * <br>2. {@link MeshPackageChannel MeshPackageChannel}
 * <br>3. {@link MeshSubscription MeshSubscription}
 *
 * <br>4. {@link MeshAdditionalParam MeshAdditionalParam}
 * @author Mars Ray Canizares Araullo
 * @version 2.0
 */
class BittelTempGetTask extends AsyncTask<Void,Void,String> implements MeshParamListener
{
    //=========================================Variable=============================================
    //-----------------------------------------Constant---------------------------------------------
    public static final String TAG = BittelTempGetTask.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------Instance---------------------------------------------
    /**
     * Result of the request
     */
    String result = null;
    /**
     * Count of the parsed results
     */
    int parsedResults = 0;
    /**
     * Required for methods that requires a context
     */
    Context context = null;
    /**
     * Data source
     */
    int dataSource = -1;
    /**
     * Requested Class of Data
     */
    Class c;
    /**
     * Listens to the results of the request
     */
    MeshDataListener listener;

    MeshTVTemporaryAPIListener tempListener = null;
    /**
     * Provides additional params for the request
     */
    MeshAdditionalParam additionalParam;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================Constructor=========================================
    /**
     * @param c Requested class of data
     * @param listener Listens for the result of the request
     */
    BittelTempGetTask(Class c, MeshDataListener listener,MeshTVTemporaryAPIListener tempListener)
    {
        this.c = c;
        this.listener = listener;
        this.tempListener = tempListener;
        this.context = MeshTVApp.get().getBaseContext();
        this.dataSource = MeshTVApp.get().getDataSourceSetting();
    }
    /**
     * @param c Requested class of data
     * @param listener Listens for the result of the request
     * @param additionalParam interface to add additional parameters to the query
     */
    BittelTempGetTask(Class c, MeshDataListener listener, MeshAdditionalParam additionalParam,MeshTVTemporaryAPIListener tempListener)
    {
        this.c = c;
        this.listener = listener;
        this.context = MeshTVApp.get().getBaseContext();
        this.dataSource = MeshTVApp.get().getDataSourceSetting();
        this.additionalParam = additionalParam;
        this.tempListener = tempListener;

    }

    /**
     *
     * @param context Custom context (will use App Context if null)
     * @param dataSource Custom dataSource (When data source is not same as the App's setting)
     * @param c Requested class of data
     * @param listener Listens for the result of the request
     */
    BittelTempGetTask(Context context, int dataSource, Class c, MeshDataListener listener,MeshTVTemporaryAPIListener tempListener)
    {
        this.c = c;
        this.listener = listener;
        this.context = context;
        this.dataSource = dataSource;
        this.tempListener = tempListener;

    }

    /**
     * @param context Custom context (will use App Context if null)
     * @param dataSource Custom dataSource (When data source is not same as the App's setting)
     * @param listener Listens for the result of the request
     * @param data Default result
     */
    BittelTempGetTask(Context context, int dataSource, MeshDataListener listener, String data,MeshTVTemporaryAPIListener tempListener)
    {
        this.listener = listener;
        this.context = context;
        this.dataSource = dataSource;
        this.result = data;
        this.tempListener = tempListener;


    }
    //==============================================================================================
    //==========================================LifeCycle===========================================
    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
    }
    @Override
    protected String doInBackground(Void... voids)
    {
        if(c==null)
        {
            if(dataSource==-1)
            {
                setClass(result);
            }
            else if (dataSource == -2)
            {
                setClass(result);
                result = getFromLive();
            }

        }
        else
        {
            switch (dataSource)
            {
                case AppDataSource.RAW:
                    result = getFromRaw();
                    break;
                case AppDataSource.FILE_SYSTEM:
                    result = getFromFileSystem();
                    break;
                case AppDataSource.SERVER:
                    result = getFromLive();
                    break;
            }
        }

        if(BuildConfig.DEBUG)
        {
            Log.i(TAG,"Result ("+c.getSimpleName()+"-"+(
                    dataSource==AppDataSource.RAW?"RAW":
                            dataSource==AppDataSource.FILE_SYSTEM?"FS":
                                    dataSource==AppDataSource.SERVER?"LIVE":
                                            dataSource==-1?"DATA DIRECT":"DATA REQUEST")+") : "+result);
        }
        if(result==null)
        {

            if(listener!=null)
            {
                listener.onNoData(c);

            }
        }
        else
        {
            if(!result.contains("data"))
            {
                if(listener!=null)
                {
                    listener.onParseFailed(c,"Failed to parse:"+result);
                }

                return null;
            }
            else
            {
                parse();
            }
        }


        return result;
    }
    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        if(c == MeshGuest.class)
        {
            Log.i(TAG,"Parsing: "+c.getSimpleName());
            try
            {
                JSONObject o = new JSONObject(s);
                MeshGuest g = new MeshGuest(o.getString("data"));
                g.compare();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else if (c == MeshSubscriber.class)
        {
            Log.i(TAG,"Parsing: "+c.getSimpleName());

            try
            {
                Log.i(TAG,"Subscriber: "+s);
                JSONObject o = new JSONObject(s);
                Log.i(TAG,"Parsing: "+o.getString("data"));
                MeshSubscriber c = new MeshSubscriber((o.getString("data")));
                c.compare();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (c == MeshConfig.class)
        {
            Log.i(TAG,"Parsing: "+c.getSimpleName());
            try
            {
                JSONObject o = new JSONObject(s);
                MeshConfig c = new MeshConfig((o.getString("data")));
                c.compare();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }
    //==============================================================================================
    //==========================================Method==============================================
    //------------------------------------------Getter----------------------------------------------

    /**
     * Returns the result of the request
     * @return Result of the request
     */
    public String getResult() {return result;}

    /**
     * Returns the number of parsed objects
     * @return Number of parsed objects
     */
    public int getParsedResults() {
        return parsedResults;
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------
    //---------------------------------------CheckConnection----------------------------------------
    //----------------------------------------------------------------------------------------------
    //------------------------------------------DataDirect------------------------------------------

    /**
     * Trigerred when data is from XMPP, sets {@link #c c} to its corresponding class depending on the data received
     * @param s
     */
    private void setClass(String s)
    {
        String classname = null;
        try
        {
            JSONObject object = new JSONObject(s);
            classname = object.getString("class");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            classname = s;
        }
        switch (classname)
        {
            case MeshData.FEEDS:
                c = MeshTVFeed.class;
                break;
            case MeshData.SCROLLING_MESSAGES:
                c = MeshScrollingMessage.class;
                break;
            case MeshTempGET.LAYOUT:
                c = MeshLayout.class;
                break;
            case MeshTempGET.SCHEDULE:
                c = MeshSchedule.class;

                break;
            case MeshTempGET.SIGNAGE_SCHEDULE:
                c = MeshSignageSchedule.class;

                break;
            case MeshTempGET.SIGNAGE:
                c = MeshSignage.class;

                break;
            case MeshTempGET.COMPANY:
                c = MeshCompany.class;

                break;
            case MeshTempGET.TELE_BILL:
                c = MeshTelecomBill.class;
                break;
            case MeshTempGET.EPG:
                c = MeshEPG.class;
                break;
            case MeshTempGET.SUBSCRIBERS:
                c = MeshSubscriber.class;
                break;
            case MeshTempGET.SUBSCRIPTIONS:
                c = MeshSubscription.class;
                break;
            case MeshTempGET.PACKAGES:
                c = MeshPackage.class;
                break;
            case MeshTempGET.PACKAGE_CHANNELS:
                c = MeshPackageChannel.class;
                break;
            case MeshTempGET.VOD_BOUGHT:
                c = MeshVODBought.class;
                break;
            case MeshTempGET.XBILL:
                c = MeshBillV2.class;
                break;
            case MeshTempGET.AIRMEDIA_USER:
                c = MeshAirMedia.class;
                break;
            case MeshTempGET.CONCIERGE_CATEGORY:
                c = MeshConciergeCategory.class;
                break;
            case MeshTempGET.TV:
                c = MeshChannel.class;
                break;
            case MeshTempGET.TV_CATEGORY:
                c = MeshChannelCategory.class;
                break;
            case MeshTempGET.ITEM_REQ:
                c= MeshConciergeRequestItem.class;
                break;
            case MeshTempGET.SVC_REQ:
                c = MeshConciergeRequestService.class;
                break;
            case MeshTempGET.FOOD:
                c = MeshFood.class;
                break;
            case MeshTempGET.FOOD_CATEGORY:
                c = MeshFoodCategory.class;
                break;
            case MeshTempGET.FACILITY:
                c = MeshFacility.class;
                break;
            case MeshTempGET.FACILITY_CATEGORY:
                c = MeshFacilityCategory.class;
                break;
            case MeshTempGET.AIRPORT_NAME:
                c = MeshAirport.class;
                break;
            case MeshTempGET.DEPARTURE_FLIGHT:
                c = MeshDepartureFlight.class;
                break;
            case MeshTempGET.ARRIVAL_FLIGHT:
                c = MeshArrivalFlight.class;
                break;
            case MeshTempGET.SHOPPING_ITEM:
                c = MeshShoppingItem.class;
                break;
            case MeshTempGET.SHOPPING_CATEGORY:
                c = MeshShoppingCategory.class;
                break;
            case MeshTempGET.MESSAGE:
                c = MeshMessage.class;
                break;
            case MeshTempGET.LIVESTREAM_SER:
                c = MeshStream.class;
                break;
            case MeshTempGET.LIVESTREAM_CAT:
                c = MeshStreamCategory.class;
                break;
            case MeshTempGET.EXTRAS:
                c = MeshTag.class;
                break;
            case MeshTempGET.VC:
                c = MeshVC.class;
                break;
            case MeshTempGET.MAP_CATEGORIES:
                c = MeshVCCategory.class;
                break;
            case MeshTempGET.WEATHER:
                c = MeshWeatherV2.class;
                break;
            case MeshTempGET.WEATHER_FORECAST:
                c = MeshWeatherForecast.class;
                break;
            case MeshTempGET.VOD:
                c = MeshVOD.class;
                break;
            case MeshTempGET.CONFIG:
                c = MeshConfig.class;
                break;
            case MeshTempGET.CUSTOMER:
                c = MeshGuest.class;
                break;
            case MeshTempGET.GENRES:
                c = MeshGenre.class;
                break;
            case MeshData.LAYOUT_V2:
                c = MeshLayoutV2.class;
                break;
            case MeshData.MEDIA:
                c = MeshMediaV2.class;
                break;
            case MeshData.MEDIA_ZONE:
                c = MeshMediaZone.class;
                break;
            case MeshData.ZONE:
                c = MeshZone.class;
                break;
            case MeshData.SIGNAGE_V2:
                c = MeshSignageV2.class;
                break;
            case MeshData.MEDIA_TYPE:
                c = MeshType.class;
                break;

        }
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Live----------------------------------------------

    /**
     * Request data from the server
     * @return Data from server
     */
    private String getFromLive()
    {
        try
        {
            Log.i(TAG,"getFromLive - Class: "+c.getSimpleName());
            String resultFromLive = "";
            String api = "";
            if(c == MeshBillV2.class)
            {
                api = MeshTempGET.XBILL;
            }
            else if (c == MeshTVFeed.class )
            {
                api = MeshTVFeed.TAG_API;
            }
            else if (c == MeshScrollingMessage.class )
            {
                api = MeshData.SCROLLING_MESSAGES;
            }
            else if ( c == MeshTelecomBill.class)
            {

            }
            else if ( c == MeshSchedule.class)
            {
                api = MeshTempGET.SCHEDULE;
            }
            else if ( c == MeshCompany.class)
            {
                api = MeshTempGET.COMPANY;
            }
            else if ( c == MeshSignage.class)
            {
                api = MeshTempGET.SIGNAGE;
            }
            else if ( c == MeshSignageSchedule.class)
            {
                api = MeshTempGET.SIGNAGE_SCHEDULE;
            }
            else if ( c == MeshLayout.class)
            {
                api = MeshTempGET.LAYOUT;
            }
            else if (c == MeshTelecomBill.class)
            {
                api = MeshTempGET.TELE_BILL;
            }
            else if (c == MeshEPG.class)
            {
                api = MeshTempGET.EPG;
            }
            else if (c == MeshSubscriber.class)
            {
                api = MeshTempGET.SUBSCRIBERS;
            }
            else if(c == MeshPackage.class)
            {
                api = MeshTempGET.PACKAGES;

            }
            else if (c == MeshPackageChannel.class)
            {
                api = MeshTempGET.PACKAGE_CHANNELS;

            }
            else if (c == MeshSubscription.class)
            {
                api = MeshTempGET.SUBSCRIPTIONS;

            }
            else if(c ==MeshVODBought.class)
            {
                api = MeshTempGET.VOD_BOUGHT;
            }
            else if(c == MeshAirMedia.class)
            {
                api = MeshTempGET.AIRMEDIA_USER;
            }
            else if(c == MeshConciergeCategory.class)
            {
                return getFromRaw();
            }
            else if (c == MeshChannel.class)
            {
                api = MeshTempGET.TV;
            }
            else if (c == MeshChannelCategory.class)
            {
                api = MeshTempGET.TV_CATEGORY;
            }
            else if (c == MeshConciergeRequestItem.class)
            {
                api = MeshTempGET.ITEM_REQ;

            }
            else if (c == MeshConciergeRequestService.class)
            {
                api = MeshTempGET.SVC_REQ;
            }
            else if (c == MeshFood.class)
            {
                api = MeshTempGET.FOOD;
            }
            else if (c == MeshFoodCategory.class)
            {
                api = MeshTempGET.FOOD_CATEGORY;
            }
            else if (c == MeshFacility.class)
            {
                api = MeshTempGET.FACILITY;
            }
            else if (c == MeshFacilityCategory.class)
            {
                api = MeshTempGET.FACILITY_CATEGORY;
            }
            else if (c == MeshAirport.class)
            {
                api = MeshTempGET.AIRPORT_NAME;
            }
            else if ( c == MeshDepartureFlight.class)
            {
                api = MeshTempGET.DEPARTURE_FLIGHT;
            }
            else if ( c== MeshArrivalFlight.class)
            {
                api = MeshTempGET.ARRIVAL_FLIGHT;
            }

            else if ( c == MeshMessage.class)
            {
                api = MeshTempGET.MESSAGE;
            }
            else if ( c == MeshShoppingCategory.class)
            {
                api = MeshTempGET.SHOPPING_CATEGORY;
            }
            else if ( c == MeshShoppingItem.class)
            {
                api = MeshTempGET.SHOPPING_ITEM;
            }
            else if ( c == MeshStream.class)
            {
                api = MeshTempGET.LIVESTREAM_SER;
            }
            else if ( c == MeshStreamCategory.class)
            {
                api = MeshTempGET.LIVESTREAM_CAT;
            }
            else if ( c == MeshTag.class)
            {
                api = MeshTempGET.EXTRAS;
            }
            else if (c == MeshVC.class)
            {
                api = MeshTempGET.VC;
            }
            else if (c == MeshVCCategory.class)
            {
                api = MeshTempGET.MAP_CATEGORIES;

            }
            else if (c == MeshWeatherV2.class)
            {
                api = MeshTempGET.WEATHER;

            }
            else if (c == MeshWeatherForecast.class)
            {
                api = MeshTempGET.WEATHER_FORECAST;
            }
            else if(c == MeshVOD.class)
            {
                api = MeshTempGET.VOD;
            }
            else if(c==MeshConfig.class)
            {
                api = MeshTempGET.CONFIG;
            }
            else if(c==MeshGuest.class)
            {
                api = MeshTempGET.CUSTOMER;
            }
            else if(c==MeshGenre.class)
            {
                api = MeshTempGET.GENRES;
            }
            else if (c ==MeshCity.class)
            {
                return getFromRaw();
            }
            else if (c ==MeshContinent.class)
            {
                return getFromRaw();
            }
            else if (c == MeshLayoutV2.class)
            {
                api = MeshData.LAYOUT_V2;
            }
            else if (c == MeshMediaV2.class)
            {
                api = MeshData.MEDIA;
            }
            else if (c == MeshMediaZone.class)
            {
                api = MeshData.MEDIA_ZONE;
            }
            else if (c == MeshMediaZoneAssignment.class)
            {
                api = MeshData.ZONE;
            }
            else if (c == MeshSignageV2.class)
            {
                api = MeshData.SIGNAGE_V2;
            }
            else if ( c == MeshType.class)
            {
                api = MeshData.MEDIA_TYPE;
            }
            if(api.length()!=0)
            {
                Log.i(TAG,"Resource ID:"+api);
                MeshTempGET get = new MeshTempGET();
                resultFromLive=get.get(context,api,this);
            }
            else
            {
                Log.i(TAG,"Resource ID: UNKNOWN");
                if(listener!=null)
                {
                    listener.onFileNotFound(c,"File not found for "+c.getSimpleName());

                }
            }
            Log.i(TAG,"Data for : "+c.getSimpleName());
            Log.i(TAG,"Data (Live): "+resultFromLive);
            return resultFromLive;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Raw-----------------------------------------------

    /**
     * Request data from raw
     * @return Data from Raw
     */
    private String getFromRaw()
    {
        try
        {
            Log.i(TAG,"Class: "+c.getSimpleName());
            String resultFromRaw = "";
            int resourceID = 0;
            if(c == MeshBillV2.class)
            {

            }
            else if (c == MeshScrollingMessage.class)
            {
                resourceID = R.raw.get_all_scrolling_messages;
            }
            else if (c == MeshTVFeed.class)
            {
                resourceID = R.raw.get_all_feeds;
            }
            else if (c == MeshLayout.class)
            {
                resourceID = R.raw.get_layout;
            }
            else if (c == MeshSchedule.class)
            {
                resourceID = R.raw.get_schedule;
            }
            else if (c == MeshSignageSchedule.class)
            {
                resourceID = R.raw.get_signage_schedule;
            }
            else if (c == MeshSignage.class)
            {
                resourceID = R.raw.get_all_signages;
            }
            else if (c == MeshCompany.class)
            {
                resourceID = R.raw.get_all_companies;
            }
            else if (c == MeshTelecomBill.class)
            {
                resourceID = R.raw.get_account_bill;
            }
            else if (c == MeshEPG.class)
            {
                resourceID = R.raw.get_epg;
            }
            else if (c == MeshSubscriber.class)
            {
                resourceID = R.raw.get_subscriber;
            }
            else if (c == MeshSubscription.class)
            {
                resourceID = R.raw.get_subscriptions;
            }
            else if (c == MeshPackage.class)
            {
                resourceID = R.raw.get_packages;
            }
            else if (c == MeshPackageChannel.class)
            {
                resourceID = R.raw.get_package_channels;
            }
            else if (c == MeshAirMedia.class)
            {
                resourceID = R.raw.get_airmedia_user;
            }
            else if(c == MeshConciergeCategory.class)
            {
                resourceID = R.raw.get_concierge_category;
            }
            else if (c == MeshChannel.class)
            {
                resourceID = R.raw.get_all_tv_channel;
            }
            else if (c == MeshChannelCategory.class)
            {
                resourceID = R.raw.get_tv_channel_category;
            }
            else if (c == MeshConciergeRequestItem.class)
            {
                resourceID = R.raw.get_all_item_request;

            }
            else if (c == MeshConciergeRequestService.class)
            {
                resourceID = R.raw.get_all_service_request;
            }
            else if (c == MeshFood.class)
            {
                resourceID = R.raw.get_all_f_and_b_item;
            }
            else if (c == MeshFoodCategory.class)
            {
                resourceID = R.raw.get_f_and_b_category;
            }
            else if (c == MeshFacility.class)
            {
                resourceID = R.raw.get_all_facilities;
            }
            else if (c == MeshFacilityCategory.class)
            {
                resourceID = R.raw.get_facility_category;
            }
            else if (c == MeshAirport.class)
            {
                resourceID = R.raw.get_airport_name;
            }
            else if ( c == MeshDepartureFlight.class)
            {
                resourceID = R.raw.get_departure_flights;
            }
            else if ( c== MeshArrivalFlight.class)
            {
                resourceID = R.raw.get_arrival_flights;
            }
            else if ( c == MeshCity.class)
            {
                resourceID = R.raw.search_city;
            }
            else if ( c == MeshContinent.class)
            {
                resourceID = R.raw.get_continents;
            }
            else if ( c == MeshMessage.class)
            {

            }
            else if (c == MeshMusic.class)
            {
            }
            else if (c == MeshMusicCategory.class)
            {

            }
            else if ( c== MeshRoomType.class)
            {

            }
            else if ( c == MeshShoppingCategory.class)
            {
                resourceID = R.raw.get_shopping_category;
            }
            else if ( c == MeshShoppingItem.class)
            {
                resourceID = R.raw.get_all_shopping_item;
            }
            else if ( c == MeshStat.class)
            {

            }
            else if ( c == MeshStream.class)
            {
                resourceID = R.raw.get_live_stream_series;
            }
            else if ( c == MeshStreamCategory.class)
            {
                resourceID = R.raw.get_live_stream_category;
            }
            else if ( c == MeshTag.class)
            {
                resourceID = R.raw.get_extras;
            }
            else if (c == MeshVC.class)
            {
                resourceID = R.raw.get_all_establishments_v3;
            }
            else if (c == MeshVCCategory.class)
            {
                resourceID = R.raw.get_maps_categories;

            }
            else if (c == MeshWeatherV2.class)
            {
                resourceID = R.raw.all_weather;

            }
            else if (c == MeshWeatherForecast.class)
            {
                resourceID = R.raw.weather_forecast;
            }
            else if(c == MeshVOD.class)
            {
                resourceID = R.raw.get_vod;
            }
            else if(c==MeshConfig.class)
            {
                resourceID = R.raw.get_config;
            }
            else if(c==MeshGuest.class)
            {
                resourceID = R.raw.get_customer;
            }
            else if(c==MeshGenre.class)
            {
                resourceID = R.raw.get_genres;
            }
            else if(c== MeshCity.class)
            {
                resourceID = R.raw.search_city;
            }
            else if (c == MeshLayoutV2.class)
            {
                resourceID = R.raw.get_layout_v2;
            }
            else if (c == MeshMediaV2.class)
            {
                resourceID = R.raw.get_all_media;
            }
            else if (c == MeshMediaZone.class)
            {
                resourceID = R.raw.get_all_media_zone;
            }
            else if (c == MeshMediaZoneAssignment.class)
            {
                resourceID = R.raw.get_all_zone_assignment;
            }
            else if (c == MeshSignageV2.class)
            {
                resourceID = R.raw.get_all_signage_v2;
            }
            else if ( c == MeshType.class)
            {
                resourceID = R.raw.get_all_type;
            }



            if(resourceID!=0)
            {
                Log.i(TAG,"Resource ID:"+resourceID);
                InputStream inputStream = context.getResources().openRawResource(resourceID);
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String newLine="";
                do
                {

                    resultFromRaw=resultFromRaw+newLine;
                    newLine = br.readLine();
                }while (newLine!=null);
            }
            else
            {
                Log.i(TAG,"Resource ID: UNKNOWN");
                if(listener!=null)
                {
                    listener.onFileNotFound(c,"File not found for "+c.getSimpleName());

                }
            }
            Log.i(TAG,"Data for : "+c.getSimpleName());
            Log.i(TAG,"Data (RAW): "+resultFromRaw);
            return resultFromRaw;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------FileSystem-------------------------------------------

    /**
     * Request data from File System
     * @return Data from File System
     */
    private String getFromFileSystem()
    {
        try
        {
            Log.i(TAG,"Class: "+c.getSimpleName());
            String resultFromFS = "";
            String resourceID = "";
            if(c == MeshConciergeCategory.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_concierge_category.txt";
            }
            else if (c == MeshTVFeed.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_all_feeds.txt";
            }
            else if (c == MeshScrollingMessage.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_all_scrolling_messages.txt";
            }
            else if (c == MeshLayout.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_layout.txt";

            }
            else if (c == MeshSchedule.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_schedule.txt";

            }
            else if (c == MeshSignageSchedule.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_signage_schedule.txt";

            }
            else if (c == MeshSignage.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_all_signages.txt";

            }
            else if (c == MeshCompany.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_all_companies.txt";

            }
            else if (c == MeshTelecomBill.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_account_bill.txt";
            }
            else if (c == MeshEPG.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_epg.txt";
            }
            else if (c == MeshSubscriber.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_subscriber.txt";
            }
            else if (c == MeshPackage.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_packages.txt";
            }
            else if (c == MeshPackageChannel.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_package_channels.txt";
            }
            else if ( c == MeshSubscription.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_subscriptions.txt";
            }
            else if(c == MeshAirMedia.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_airmedia_user.txt";
            }
            else if (c == MeshChannel.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_all_tv_channel.txt";
            }
            else if (c == MeshChannelCategory.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_tv_channel_category.txt";
            }
            else if (c == MeshConciergeRequestItem.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_all_item_request.txt";

            }
            else if (c == MeshConciergeRequestService.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_all_service_request.txt";
            }
            else if (c == MeshFood.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_all_f_and_b_item.txt";
            }
            else if (c == MeshFoodCategory.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_f_and_b_category.txt";
            }
            else if (c == MeshFacility.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_all_facilities.txt";
            }
            else if (c == MeshFacilityCategory.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_facility_category.txt";
            }
            else if (c == MeshAirport.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_airport_name.txt";
            }
            else if ( c == MeshDepartureFlight.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_departure_flights.txt";
            }
            else if ( c== MeshArrivalFlight.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_arrival_flights.txt";
            }
            else if (c ==MeshCity.class)
            {
                return getFromRaw();
            }
            else if (c ==MeshContinent.class)
            {
                return getFromRaw();
            }
            else if ( c == MeshMessage.class)
            {

            }
            else if (c == MeshMusic.class)
            {
            }
            else if (c == MeshMusicCategory.class)
            {

            }
            else if ( c== MeshRoomType.class)
            {

            }
            else if ( c == MeshShoppingCategory.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_shopping_category.txt";
            }
            else if ( c == MeshShoppingItem.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_all_shopping_item.txt";
            }
            else if ( c == MeshStat.class)
            {

            }
            else if ( c == MeshStream.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_live_stream_series.txt";
            }
            else if ( c == MeshStreamCategory.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_live_stream_category.txt";
            }
            else if ( c == MeshTag.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_extras.txt";
            }
            else if (c == MeshVC.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_all_establishments_v3.txt";
            }
            else if (c == MeshVCCategory.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_maps_categories.txt";
            }
            else if (c == MeshWeatherV2.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/all_weather.txt";

            }
            else if (c == MeshWeatherForecast.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/weather_forecast.txt";
            }
            else if(c == MeshVOD.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_vod.txt";
            }
            else if(c==MeshConfig.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_config.txt";
            }
            else if(c==MeshGuest.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_customer.txt";
            }
            else if(c==MeshGenre.class)
            {
                resourceID = MeshTVApp.get().getFSPath()+"/get_genres.txt";
            }
            else if (c == MeshLayoutV2.class)
            {
                resourceID =  MeshTVApp.get().getFSPath()+"/"+MeshData.LAYOUT_V2+".txt";
            }
            else if (c == MeshMediaV2.class)
            {
                resourceID =  MeshTVApp.get().getFSPath()+"/"+MeshData.MEDIA+".txt";            }
            else if (c == MeshMediaZone.class)
            {
                resourceID =  MeshTVApp.get().getFSPath()+"/"+MeshData.MEDIA_ZONE+".txt";
            }
            else if (c == MeshMediaZoneAssignment.class)
            {
                resourceID =  MeshTVApp.get().getFSPath()+"/"+MeshData.ZONE+".txt";
            }
            else if (c == MeshSignageV2.class)
            {
                resourceID =  MeshTVApp.get().getFSPath()+"/"+MeshData.SIGNAGE_V2+".txt";
            }
            else if ( c == MeshType.class)
            {
                resourceID =  MeshTVApp.get().getFSPath()+"/"+MeshData.MEDIA_TYPE+".txt";
            }


            if(resourceID!="")
            {
                Log.i(TAG,"File:"+resourceID);
                resultFromFS = MeshTVFileManager.readFile(resourceID);
            }
            else
            {
                Log.i(TAG,"File: UNKNOWN");
                if(listener!=null)
                {
                    listener.onFileNotFound(c,"File not found for "+c.getSimpleName());

                }
            }
            Log.i(TAG,"Data for : "+c.getSimpleName());
            Log.i(TAG,"Data (FS): "+resultFromFS);
            return resultFromFS;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Parse---------------------------------------------

    /**
     * Parses the results and sends the parsed objects to the listener
     */
    public void parse() {
        if (c == MeshChannel.class) {
            ArrayList<Object> channels = new ArrayList<>();
            try
            {
                channels.addAll(MeshParser.parseChannels(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = channels.size();
            if (channels.size() > 0)
            {
                if (listener != null) {
                    listener.onDataReceived(c, channels.size());
                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshChannel.class,channels);
                }

            } else {
                if (listener != null) {
                    listener.onNoData(c);
                }

                if(tempListener!=null)
                {
                    tempListener.onFail(MeshChannel.class);
                }

            }
        }
        else if ( c == MeshTVFeed.class)
        {
            ArrayList<Object> scrolls = new ArrayList<>();
            try
            {
                scrolls.addAll(MeshParser.parseFeeds(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = scrolls.size();

            if (scrolls.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c, scrolls.size());
                }
                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshTVFeed.class,scrolls);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshTVFeed.class);
                }

            }
        }
        else if ( c == MeshScrollingMessage.class)
        {
            ArrayList<Object> scrolls = new ArrayList<>();
            try
            {
                scrolls.addAll(MeshParser.parseScrollingMessages(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = scrolls.size();

            if (scrolls.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c, scrolls.size());
                }
                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshScrollingMessage.class,scrolls);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshScrollingMessage.class);
                }

            }
        }
        else if ( c == MeshTelecomBill.class)
        {
            ArrayList<Object> epgs = new ArrayList<>();
            try
            {
                epgs.addAll(MeshParser.parseTeleBills(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = epgs.size();
            if (epgs.size() > 0) {
                if(listener!=null)
                {
                    listener.onDataReceived(c, epgs.size());
                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshTelecomBill.class,epgs);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshTelecomBill.class);
                }

            }
        }
        else if (c == MeshEPG.class)
        {
            ArrayList<Object> epgs = new ArrayList<>();
            try
            {
                epgs.addAll(MeshParser.parseEPGs(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = epgs.size();
            if (epgs.size() > 0) {
                if(listener!=null)
                {
                    listener.onDataReceived(c, epgs.size());
                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshEPG.class,epgs);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshEPG.class);
                }

            }
        }

        else if (c == MeshConciergeCategory.class)
        {
            ArrayList<Object> categories = new ArrayList<>();
            try
            {
                categories.addAll(MeshParser.parseConciergeCategories(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = categories.size();
            if (categories.size() > 0) {
                if(listener!=null)
                {
                    listener.onDataReceived(c, categories.size());
                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshConciergeCategory.class,categories);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshConciergeCategory.class);
                }

            }
        }
        else if (c == MeshChannelCategory.class)
        {
            ArrayList<Object> categories = new ArrayList<>();
            try
            {
                categories.addAll(MeshParser.parseChannelCategories(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = categories.size();
            if (categories.size() > 0) {
                if(listener!=null)
                {
                    listener.onDataReceived(c, categories.size());
                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshChannelCategory.class,categories);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshChannelCategory.class);
                }
            }
        }
        else if (c == MeshAirport.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseAirports(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());
                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshAirport.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshAirport.class);
                }
            }
        }
        else if (c == MeshArrivalFlight.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseArrivalFlights(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());
                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshArrivalFlight.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshArrivalFlight.class);
                }

            }
        }
        else if (c == MeshBillV2.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseBills(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());
                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshBillV2.class,items);
                }

            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshBillV2.class);
                }

            }
        }
        else if (c == MeshCity.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseCities(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());
                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshCity.class,items);
                }


            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshCity.class);
                }

            }
        }
        else if (c == MeshContinent.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseContinents(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {listener.onDataReceived(c,items.size());

                }


                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshContinent.class,items);
                }


            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);

                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshContinent.class);
                }
            }
        }
        else if (c == MeshDepartureFlight.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseDepartureFlights(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());
                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshDepartureFlight.class,items);
                }

            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshDepartureFlight.class);
                }
            }
        }
        else if (c == MeshTag.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseTags(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());
                }


                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshTag.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshTag.class);
                }
            }
        }
        else if (c == MeshFacility.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseFacilities(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();

            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());
                }


                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshFacility.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);

                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshFacility.class);
                }
            }
        }
        else if (c == MeshFacilityCategory.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseFacilityCategories(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());
                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshFacilityCategory.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshFacilityCategory.class);
                }
            }
        }
        else if (c == MeshFood.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseFood(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());

                }
                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshFood.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshFood.class);
                }
            }
        }
        else if (c == MeshFoodCategory.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseFoodCategory(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());
                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshFoodCategory.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshFoodCategory.class);
                }
            }
        }
        else if (c == MeshGenre.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseGenre(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());
                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshGenre.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
            }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshGenre.class);
                }

            }
        }
        else if (c == MeshMessage.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseMessage(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());

                }
                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshMessage.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshMessage.class);
                }
            }
        }
        else if (c == MeshRoomType.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseRoomType(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());
                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshRoomType.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshRoomType.class);
                }
            }
        }
        else if (c == MeshShoppingItem.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseShoppingItem(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());
                }


                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshShoppingItem.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshShoppingItem.class);
                }

            }
        }
        else if (c == MeshShoppingCategory.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseShoppingCategory(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());
                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshShoppingCategory.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshShoppingCategory.class);
                }
            }
        }
        else if (c == MeshStat.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseStats(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());

                }
                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshStat.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshStat.class);
                }

            }
        }
        else if (c == MeshStream.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseStreams(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults =items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());
                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshStream.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshStream.class);
                }
            }
        }
        else if (c == MeshStreamCategory.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseStreamCategory(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());

                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshStreamCategory.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);

                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshStreamCategory.class);
                }
            }
        }
        else if (c == MeshVC.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseVC(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());
                }

                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshVC.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshVC.class);
                }
            }
        }
        else if (c == MeshVCCategory.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseVCCategory(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());

                }
                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshVCCategory.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);

                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshVCCategory.class);
                }
            }
        }
        else if (c == MeshVOD.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseVOD(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());
                }
                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshVOD.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);
                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshVOD.class);
                }
            }
        }
        else if ( c== MeshVODBought.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseVODsBought(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());

                }
                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshVODBought.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);

                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshVODBought.class);
                }
            }
        }
        else if (c == MeshWeatherV2.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseWeatherV2(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());

                }
                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshWeatherV2.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);

                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshWeatherV2.class);
                }
            }
            new MeshWeatherLocal().display();
        }
        else if (c == MeshWeatherForecast.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseForecast(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());

                }
                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshWeatherForecast.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);

                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshWeatherForecast.class);
                }
            }
        }
        else if (c == MeshConciergeRequestItem.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseConciergeItems(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());

                }
                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshConciergeRequestItem.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);

                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshConciergeRequestItem.class);
                }
            }
        }
        else if (c == MeshConciergeRequestService.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parseConciergeServices(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());

                }
                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshConciergeRequestService.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);

                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshConciergeRequestService.class);
                }
            }
        }
        else if (c == MeshSubscriber.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                JSONObject rs = new JSONObject(result);
                MeshSubscriber config = new MeshSubscriber(rs.getString("data"));
                items.add(config);
                parsedResults = items.size();
                if (items.size() > 0)
                {
                    config.compare();
                    if(listener!=null)
                    {
                        listener.onDataReceived(c,items.size());

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onSuccess(MeshSubscriber.class,items);
                    }

                }
                else
                {
                    if(listener!=null)
                    {
                        listener.onNoData(c);

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onFail(MeshSubscriber.class);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (c == MeshConfig.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                JSONObject rs = new JSONObject(result);
                MeshConfig config = new MeshConfig(rs.getString("data"));
                items.add(config);
                parsedResults = items.size();
                if (items.size() > 0)
                {
                    config.update();
                    if(listener!=null)
                    {
                        listener.onDataReceived(c,items.size());

                    }

                }
                else
                {
                    if(listener!=null)
                    {
                        listener.onNoData(c);

                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else if (c == MeshGuest.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                JSONObject rs = new JSONObject(result);
                MeshGuest guest = new MeshGuest(rs.getString("data"));
                items.add(guest);
                parsedResults = items.size();
                if (items.size() > 0)
                {
                    guest.update();
                    if(listener!=null)
                    {
                        listener.onDataReceived(c,items.size());

                    }

                }
                else
                {
                    if(listener!=null)
                    {
                        listener.onNoData(c);

                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else if (c == MeshAirMedia.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                JSONObject rs = new JSONObject(result);
                MeshAirMedia user = new MeshAirMedia(rs.getString("data"));
                items.add(user);
                parsedResults = items.size();
                if (items.size() > 0)
                {
                    if(listener!=null)
                    {
                        listener.onDataReceived(c,items.size());

                    }
                    user.update();
                }
                else
                {
                    if(listener!=null)
                    {
                        listener.onNoData(c);

                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else if (c == MeshPackage.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parsePackages(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());

                }
                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshPackage.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);

                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshPackage.class);
                }
            }
        }
        else if (c == MeshPackageChannel.class)
        {
            ArrayList<Object> items = new ArrayList<>();
            try
            {
                items.addAll(MeshParser.parsePackageChannels(result));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            parsedResults = items.size();
            if (items.size() > 0)
            {
                if(listener!=null)
                {
                    listener.onDataReceived(c,items.size());

                }
                if(tempListener!=null)
                {
                    tempListener.onSuccess(MeshPackageChannel.class,items);
                }
            }
            else
            {
                if(listener!=null)
                {
                    listener.onNoData(c);

                }
                if(tempListener!=null)
                {
                    tempListener.onFail(MeshPackageChannel.class);
                }
            }
        }
        else if (c == MeshSubscription.class)
        {
            try
            {
                ArrayList<Object> items = new ArrayList<>();
                try
                {
                    items.addAll(MeshParser.parseSubscriptions(result));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }


                parsedResults = items.size();
                if (items.size() > 0)
                {
                    if(listener!=null)
                    {
                        listener.onDataReceived(c,items.size());

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onSuccess(MeshSubscription.class,items);
                    }
                }
                else
                {
                    if(listener!=null)
                    {
                        listener.onNoData(c);

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onFail(MeshSubscription.class);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else if (c == MeshSignage.class)
        {
            try
            {
                ArrayList<Object> items = new ArrayList<>();
                try
                {
                    items.addAll(MeshParser.parseSignages(result));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }


                parsedResults = items.size();
                if (items.size() > 0)
                {
                    if(listener!=null)
                    {
                        listener.onDataReceived(c,items.size());

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onSuccess(MeshSignage.class,items);
                    }
                }
                else
                {
                    if(listener!=null)
                    {
                        listener.onNoData(c);

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onFail(MeshSignage.class);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else if (c == MeshCompany.class)
        {
            try
            {
                ArrayList<Object> items = new ArrayList<>();
                try
                {
                    items.addAll(MeshParser.parseCompanies(result));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }


                parsedResults = items.size();
                if (items.size() > 0)
                {
                    if(listener!=null)
                    {
                        listener.onDataReceived(c,items.size());

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onSuccess(MeshCompany.class,items);
                    }
                }
                else
                {
                    if(listener!=null)
                    {
                        listener.onNoData(c);

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onFail(MeshCompany.class);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else if (c == MeshLayout.class)
        {
            try
            {
                ArrayList<Object> items = new ArrayList<>();
                try
                {
                    items.addAll(MeshParser.parseLayouts(result));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }


                parsedResults = items.size();
                if (items.size() > 0)
                {
                    if(listener!=null)
                    {
                        listener.onDataReceived(c,items.size());

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onSuccess(MeshLayout.class,items);
                    }
                }
                else
                {
                    if(listener!=null)
                    {
                        listener.onNoData(c);

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onFail(MeshLayout.class);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else if (c == MeshSignageSchedule.class)
        {
            try
            {
                ArrayList<Object> items = new ArrayList<>();
                try
                {
                    items.addAll(MeshParser.parseSignageSchedules(result));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }


                parsedResults = items.size();
                if (items.size() > 0)
                {
                    if(listener!=null)
                    {
                        listener.onDataReceived(c,items.size());

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onSuccess(MeshSignageSchedule.class,items);
                    }
                }
                else
                {
                    if(listener!=null)
                    {
                        listener.onNoData(c);

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onFail(MeshSignageSchedule.class);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else if (c == MeshSchedule.class)
        {
            try
            {
                ArrayList<Object> items = new ArrayList<>();
                try
                {
                    items.addAll(MeshParser.parseSchedules(result));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                parsedResults = items.size();
                if (items.size() > 0)
                {
                    if(listener!=null)
                    {
                        listener.onDataReceived(c,items.size());

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onSuccess(MeshSchedule.class,items);
                    }
                }
                else
                {
                    if(listener!=null)
                    {
                        listener.onNoData(c);

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onFail(MeshSchedule.class);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else if (c == MeshLayoutV2.class)
        {
            try
            {
                ArrayList<Object> items = new ArrayList<>();
                try
                {
                    items.addAll(MeshParser.parseMeshLayoutV2s(result));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }


                parsedResults = items.size();
                if (items.size() > 0)
                {
                    if(listener!=null)
                    {
                        listener.onDataReceived(c,items.size());

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onSuccess(MeshLayoutV2.class,items);
                    }
                }
                else
                {
                    if(listener!=null)
                    {
                        listener.onNoData(c);

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onFail(MeshLayoutV2.class);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (c == MeshMediaV2.class)
        {
            try
            {
                ArrayList<Object> items = new ArrayList<>();
                try
                {
                    items.addAll(MeshParser.parseMediaV2s(result));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                parsedResults = items.size();
                if (items.size() > 0)
                {
                    if(listener!=null)
                    {
                        listener.onDataReceived(c,items.size());

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onSuccess(MeshMediaV2.class,items);
                    }
                }
                else
                {
                    if(listener!=null)
                    {
                        listener.onNoData(c);

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onFail(MeshMediaV2.class);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (c == MeshMediaZone.class)
        {
            try
            {
                ArrayList<Object> items = new ArrayList<>();
                try
                {
                    items.addAll(MeshParser.parseMediaZones(result));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                parsedResults = items.size();
                if (items.size() > 0)
                {
                    if(listener!=null)
                    {
                        listener.onDataReceived(c,items.size());

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onSuccess(MeshMediaZone.class,items);
                    }
                }
                else
                {
                    if(listener!=null)
                    {
                        listener.onNoData(c);

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onFail(MeshMediaZone.class);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (c == MeshMediaZoneAssignment.class)
        {
            try
            {
                ArrayList<Object> items = new ArrayList<>();
                try
                {
                    items.addAll(MeshParser.parseMediaZoneAssignments(result));

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                parsedResults = items.size();
                if (items.size() > 0)
                {
                    if(listener!=null)
                    {
                        listener.onDataReceived(c,items.size());

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onSuccess(MeshMediaZoneAssignment.class,items);
                    }
                }
                else
                {
                    if(listener!=null)
                    {
                        listener.onNoData(c);

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onFail(MeshMediaZoneAssignment.class);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (c == MeshSignageV2.class)
        {
            try
            {
                ArrayList<Object> items = new ArrayList<>();
                try
                {
                    items.addAll(MeshParser.parseSignageV2s(result));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }


                parsedResults = items.size();
                if (items.size() > 0)
                {
                    if(listener!=null)
                    {
                        listener.onDataReceived(c,items.size());

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onSuccess(MeshSignageV2.class,items);
                    }
                }
                else
                {
                    if(listener!=null)
                    {
                        listener.onNoData(c);

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onFail(MeshSignageV2.class);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if ( c == MeshType.class)
        {
            try
            {
                ArrayList<Object> items = new ArrayList<>();
                try
                {
                    items.addAll(MeshParser.parseTypes(result));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                parsedResults = items.size();
                if (items.size() > 0)
                {
                    if(listener!=null)
                    {
                        listener.onDataReceived(c,items.size());

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onSuccess(MeshType.class,items);
                    }
                }
                else
                {
                    if(listener!=null)
                    {
                        listener.onNoData(c);

                    }
                    if(tempListener!=null)
                    {
                        tempListener.onFail(MeshType.class);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================MeshParamListener====================================\
    /**
     * Appends extra parameters to certain API calls
     */
    @Override
    public String requestParams(String url)
    {

        if(c==MeshGuest.class)
        {
            url=url+"/"+ MeshAPIKeyRetriever.getAPIKey(context).replaceAll(":","").toLowerCase();
            url = url+"/"+ MeshTVPreferenceManager.getRoom(context);
        }
        else if(c == MeshMessage.class)
        {
            url=url+"/"+ MeshAPIKeyRetriever.getAPIKey(context).replaceAll(":","").toLowerCase();
            if(MeshTVApp.get().getAppSettings().appMode()== AppMode.HOTEL)
            {
                url=url+"/"+ MeshTVPreferenceManager.getRoom(context);
            }
            else if(MeshTVApp.get().getAppSettings().appMode()== AppMode.TELECOM)
            {
                url=url+"/"+ MeshTVPreferenceManager.getAccountID(context);
            }
        }

        else
        {
            url=url+"/"+ MeshAPIKeyRetriever.getAPIKey(context).replaceAll(":","").toLowerCase();

        }
        if(additionalParam!=null)
        {
            url = additionalParam.addAdditionalParams(url);
        }
        return url;

    }
    //==============================================================================================
}
