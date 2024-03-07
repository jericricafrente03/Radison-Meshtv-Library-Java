package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.util.LruCache;

import com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Model.MeshAirMedia;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.GET.ReportAnalytics;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners.MeshRequestListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.POST.MeshRegisterTask;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.POST.MeshSubscribeTask;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Manager.MeshAnnotationManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Settings.AppInitSettings;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Settings.AppSettings;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Settings.RealmEditorSettings;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Constant.AppDataSource;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Manager.MeshTVDataManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshNotificationListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshSubscriptionUpdateListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshAirmediaListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshConfigListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshGuestListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshSubscriptionListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshWeatherListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshConfig;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshGuest;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Permissions.MeshPermissionInterface;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshSubscriber;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshWeatherLocal;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshChannelPackageManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmListener;
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
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RoomType.MeshRoomType;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackageChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshSubscription;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshGenre;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVODBought;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast;

import java.lang.reflect.Method;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
/**
 * Base class for all MeshTV Applications
 * <br>Tasks:
 * <br>1. Configures how the Application should work
 * <br>2. Receives events and forward to corresponding listeners
 * <br>3. Iniate Realm Database
 * <br>4. Asks dangerous permission upon a request of an Activity
 * <br>5. Caches Bitmaps
 * <br>
 * <br>Requires:
 * <br>1. {@link AppSettings AppSettings}
 * <br>2. {@link RealmEditorSettings RealmEditorSettings}
 * <br>
 * <br>Supports:
 * <br>1. {@link LruCache LruCache}
 * <br>2. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Init Init}
 * <br>3. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Activity.AttachFragment AttachFragment}
 * <br>4. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Terminate Terminate}
 * <br>5. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimedMethod}
 * <br>
 * <br>Receives Events and forwards it to listeners for:
 * <br>1. {@link MeshDataListener MeshDataListener}
 * <br>2. {@link MeshGuestListener MeshGuestListener}
 * <br>3. {@link MeshConfigListener MeshConfigListener}
 * <br>4. {@link MeshWeatherListener MeshWeatherListener}
 * <br>5. {@link MeshAirmediaListener MeshAirmediaListener}
 * @version v 1.0
 * @author Mars Ray Araullo
 */
abstract class BittelApp extends Application
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------

    private static final String TAG = BittelApp.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    private MeshRealmListener clearListener = new MeshRealmListener() {
        @Override
        public void onRetrieved(Class c, ArrayList<Object> results) {

        }

        @Override
        public void onFailed(Class c, String message) {

        }

        @Override
        public void onEmpty(Class c, String message) {

        }

        @Override
        public void onCleared(Class c) {

            MeshTVDataManager.requestData(c);

        }
    };
    /**
     * List of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Init Init} annotated methods
     */
    private ArrayList<Method>   initMethods             = new ArrayList<>();
    /**
     * List of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Terminate Terminate} annotated methods
     */
    private ArrayList<Method>   terminateMethods        = new ArrayList<>();
    /**
     * List of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimeMethod} annotated methods
     */
    private ArrayList<Method> timedMethods              = new ArrayList<>();
    /**
     * Sets the Data Source the application will be using (set using {@link AppSettings#dataSource() AppSettings.dataSource()} Annotation):
     * <br>Values:
     * <br>1. {@link AppDataSource#SERVER AppDataSource.SERVER} (live server)
     * <br>2. {@link AppDataSource#RAW AppDataSource.RAW} (raw folder)
     * <br>3. {@link AppDataSource#FILE_SYSTEM AppDataSource.FILE_SYSTEM} (android file system "sdcard/Android")
     * <br>4. {@link AppDataSource#USB AppDataSource.USB} (USB)
     */
    private int                 dataSource              = AppDataSource.RAW;
    /**
     * Sets whether MeshTV Application is Demo or Live:
     * <br>Values:
     * <br> true - DEMO (DEFAULT)
     * <br> false - LIVE
     */
    private boolean             isDemo                  = true;
    /**
     * Sets whether MeshTV Application will use XMPP:
     * <br>Values:
     * <br> true - XMPP enabled
     * <br> false - XMPP disabled (DEFAULT)
     */
    private boolean             useXMPP                 = false;
    /**
     * Flag whether to restrict Wi-Fi.
     * <br>Values:
     * <br>True - will turn-off Wi-Fi every time it can (Not Implemented Yet)
     * <br>False - will allow Wi-Fi to work normally (DEFAULT)
     */
    private boolean             restrictWifi            = false;
    /**
     * {@link AppSettings AppSettings} sets the configuration of {@link BittelApp BittelApp}
     */
    private AppSettings         settings                = null;
    /**
     * {@link RealmEditorSettings RealmEditorSettings} sets the configuration of {@link BittelApp BittelApp} for editing Realm Objects
     */
    private RealmEditorSettings rSettings               = null;
    /**
     * Handler that launches {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimedMethod} annotated methods
     */
    private Handler handler = null;
    /**
     * List of DataListeners registered
     */
    ArrayList<MeshDataListener> listeners               = new ArrayList<>();
    /**
     * List of objects that requested to listen to changes from {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.GuestPreference GuestPreference}
     */
    ArrayList<MeshGuestListener> guestListeners         = new ArrayList<>();
    /**
     * List of objects that requested to listen to changes from {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelPreference HotelPreference}
     */
    ArrayList<MeshConfigListener> configListeners       = new ArrayList<>();
    /**
     * List of objects that requested to listen to changes from {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelWeatherPreference HotelWeatherPreference}
     */
    ArrayList<MeshWeatherListener> weatherListeners     = new ArrayList<>();
    /**
     * List of objects that requested to listen to changes from {@link MeshAirmediaListener MeshAirmediaListener}
     */
    ArrayList<MeshAirmediaListener> airmediaListeners   = new ArrayList<>();
    /**
     * Caches Bitmaps for faster loading and display
     */
    LruCache<String, Bitmap> cache                      = null;
    /**
     * Controls how the app will react to data upon boot-up
     */
    AppInitSettings initSettings;
    ArrayList<MeshSubscriptionListener> subListeners;
    ArrayList<MeshNotificationListener> notificationListeners;
    ArrayList<MeshSubscriptionUpdateListener> subUpdateListeners;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================LifeCycle=========================================
    /**
     * Events:
     * <br>1. Invokes {@link #prepare prepare()} abstract method
     * <br>2. Invokes {@link #initDataBase() initDataBase()}
     * <br>3. Invokes {@link #setSettings() setSettings()}
     * <br>4. Invokes {@link #connect() connect()}
     * <br>5. Invokes {@link #init() init()}
     * <br>6. Invokes {@link #startTimedMethods() startTimedMethods()}
     */
    @Override
    public final void onCreate()
    {
        super.onCreate();
        Log.i(TAG,"Application Started");
        prepare();
        initDataBase();
        setSettings();
        connect();
        register();
        init();
        initData();
        startTimedMethods();
        if(settings.reportsAnalytics())
        {
            if(settings.dataSource()==AppDataSource.SERVER)
            {
                new ReportAnalytics(getApplicationContext(), new MeshRequestListener() {
                    @Override
                    public void onFailed(String s) {

                    }

                    @Override
                    public void onResult(String s) {

                    }
                }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
            }
        }
    }

    /**
     * Events:
     * <br>1. Invokes {@link #stopTimedMethods() stopTimedMethods} method
     * <br>2. Invokes {@link #terminate() terminate} method
     * <br>3. Invokes {@link #disconnect() disconnect} method
     */
    @Override
    public final void onTerminate()
    {
        super.onTerminate();
        stopTimedMethods();
        terminate();
        disconnect();
    }
    //==============================================================================================
    //=============================================Method===========================================
    //----------------------------------------------Init--------------------------------------------

    /**
     * Initializes Realm Database
     */
    private final void initDataBase()
    {
        Realm.init(this);
        final RealmConfiguration configuration = new RealmConfiguration.Builder().name("mtv_lib2_"+getDBName()+".realm").schemaVersion(2).migration(new BittelMigration()).build();
        Realm.setDefaultConfiguration(configuration);
        Realm.getInstance(configuration);

    }
    /**
     * Register the STB to the server
     * @version 2.0
     */
    private void register()
    {

        if(!settings.isManualSetUp())
        {
            MeshTVPreferenceManager.updateIPTV(this);
            if(settings.dataSource()==AppDataSource.SERVER)
            {
                if(this instanceof MeshRequestListener)
                {
                    switch (settings.appMode())
                    {
                        case HOTEL:
                            new MeshRegisterTask(getBaseContext(),(MeshRequestListener) this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                            break;
                        case TELECOM:
                            new MeshSubscribeTask(getBaseContext(),(MeshRequestListener) this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                            break;
                    }

                }
                else
                {
                    throw  new MeshApplicationException ("Application must implement MeshRequestListener");
                }
                if(this instanceof  MeshDataListener)
                {
                    switch (settings.appMode())
                    {
                        case HOTEL:
                            MeshTVDataManager.requestData(MeshGuest.class);
                            break;
                        case TELECOM:
                            MeshTVDataManager.requestData(MeshSubscriber.class);
                            break;
                    }
                }
                else
                {
                    throw  new MeshApplicationException ("Application must implement MeshDataListener");
                }


            }
        }

    }

    /**
     * Sets the settings for this Application
     * <br>LIVE - Updates data following data from the server:
     * <br>1. {@link MeshGuest MehsGuest}
     * /{@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.GuestPreference GuestPreference}
     * <br>2. {@link MeshConfig MeshConfig}
     * /{@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelPreference HotelPreference}
     * <br>3. {@link MeshWeatherLocal MeshWeatherLocal}
     * /{@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelWeatherPreference HotelWeatherPreference}
     */
    private final void setSettings()
    {
        initSettings = getClass().getAnnotation(AppInitSettings.class);

        settings = getClass().getAnnotation(AppSettings.class);
        if(settings==null)
        {
            throw  new MeshApplicationException(TAG+" : AppSetting Annotation is required");
        }
        rSettings = getClass().getAnnotation(RealmEditorSettings.class);
        if(rSettings==null)
        {
            throw  new MeshApplicationException(TAG+" : RealmEditorSettings Annotation is required");
        }
        else
        {
            MeshRealmManager.setUp(rSettings);
        }
        isDemo = settings.isDemo();

        restrictWifi = settings.restrictWifi();
        useXMPP = settings.useXMPP();
        dataSource = settings.dataSource();

        switch (initSettings.updateUser())
        {
            case REPLACE:
            case UPDATE:
                switch (settings.appMode())
                {
                    case HOTEL:
                        MeshTVDataManager.requestData(MeshGuest.class);
                        break;
                    case TELECOM:
                        MeshTVDataManager.requestData(MeshSubscriber.class);
                        break;
                }
                break;
            case DO_NOTHING:
                break;
        }
        switch (initSettings.updateConfig())
        {
            case REPLACE:
            case UPDATE:
                MeshTVDataManager.requestData(MeshConfig.class);
                break;
            case DO_NOTHING:
                break;
        }

        switch (initSettings.updateWeather())
        {
            case REPLACE:
                MeshRealmManager.clear(MeshWeatherV2.class,clearListener);
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshWeatherV2.class);
                break;
            case DO_NOTHING:
                break;
        }

    }

    /**
     * Initializes all data
     */
    private void initData()
    {
        switch (initSettings.updateBill())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshBillV2.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshBillV2.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshBillV2.class);
                break;
        }
        switch (initSettings.updateChannel())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshChannel.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshChannel.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshChannel.class);
                break;
        }
        switch (initSettings.updateChannelCategory())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshChannelCategory.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshChannelCategory.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshChannelCategory.class);
                break;
        }
        switch (initSettings.updateConciergeCategory())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshConciergeCategory.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshConciergeCategory.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshConciergeCategory.class);
                break;
        }
        switch (initSettings.updateConciergeItem())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshConciergeRequestItem.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshConciergeRequestItem.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshConciergeRequestItem.class);
                break;
        }
        switch (initSettings.updateConciergeService())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshConciergeRequestService.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshConciergeRequestService.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshConciergeRequestService.class);
                break;
        }
        switch (initSettings.updateFood())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshFood.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshFood.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshFood.class);
                break;
        }
        switch (initSettings.updateFoodCategory())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshFoodCategory.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshFoodCategory.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshFoodCategory.class);
                break;
        }
        switch (initSettings.updateAirport())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshAirport.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshAirport.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshAirport.class);
                break;
        }
        switch (initSettings.updateArrivalFlight())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshArrivalFlight.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshArrivalFlight.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshArrivalFlight.class);
                break;
        }
        switch (initSettings.updateDepartureFlight())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshDepartureFlight.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshDepartureFlight.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshDepartureFlight.class);
                break;
        }
        switch (initSettings.updateRoomType())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshRoomType.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshRoomType.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshRoomType.class);
                break;
        }
        switch (initSettings.updateShoppingItem())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshShoppingItem.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshShoppingItem.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshShoppingItem.class);
                break;
        }
        switch (initSettings.updateShoppingCategory())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshShoppingCategory.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshShoppingCategory.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshShoppingCategory.class);
                break;
        }
        switch (initSettings.updatePackage())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshPackage.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshPackage.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshPackage.class);
                break;
        }
        switch (initSettings.updatePackageChannel())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshPackageChannel.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshPackageChannel.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshPackageChannel.class);
                break;
        }

        switch (initSettings.updatePackageSubscription())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshSubscription.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshSubscription.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshSubscription.class);
                break;
        }
        switch (initSettings.updateVC())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshVC.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshVC.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshVC.class);
                break;
        }
        switch (initSettings.updateVCCategory())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshVCCategory.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshVCCategory.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshVCCategory.class);
                break;
        }
        switch (initSettings.updateVOD())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshVOD.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshVOD.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshVOD.class);
                break;
        }
        switch (initSettings.updateGenre())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshGenre.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshGenre.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshGenre.class);
                break;
        }
        switch (initSettings.updateForecast())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshWeatherForecast.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshWeatherForecast.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshWeatherForecast.class);
                break;
        }
        switch (initSettings.updateEPG())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshEPG.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshEPG.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshEPG.class);
                break;
        }
        switch (initSettings.updateFacility())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshFacility.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshFacility.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshFacility.class);
                break;
        }

        switch (initSettings.updateFacilityCategory())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshFacilityCategory.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshFacilityCategory.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshFacilityCategory.class);
                break;
        }

        switch (initSettings.updateMessage())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshMessage.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshMessage.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshMessage.class);
                break;
        }

        switch (initSettings.updateMessage())
        {
            case DO_NOTHING:
                break;
            case UPDATE:
                MeshTVDataManager.requestData(MeshMessage.class);
                break;
            case REPLACE:
                MeshRealmManager.clear(MeshMessage.class,clearListener);
                break;
            case CLEAR:
                MeshRealmManager.clear(MeshMessage.class);
                break;
        }
    }

    /**
     * Request Dangerous permissions requested by {@link #settings settings}
     * @param a Activity that requests permmissions
     */
    final void askPermissions(Activity a)
    {

        if(settings.recordAudio())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_RECORD_AUDIO);
        }
        if(settings.writeExternal())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_WRITE_EXTERNAL);
        }
        if(settings.readExternal())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_READ_EXTERNAL);
        }
        if(settings.readCalendar())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_READ_CALENDAR);
        }
        if(settings.writeCalendar())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_WRITE_CALENDAR);
        }
        if(settings.useCamera())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_CAMERA);
        }
        if(settings.readContacts())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_READ_CONTACTS);
        }
        if(settings.writeContacts())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_WRITE_CONTACTS);
        }
        if(settings.getAccounts())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_GET_ACCOUNTS);
        }
        if(settings.accessFineLocation())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_ACCESS_FINE_LOCATION);
        }
        if(settings.accessCoarseLocation())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_ACCESS_COARSE_LOCATION);
        }
        if(settings.readPhoneState())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_READ_PHONE_STATE);
        }
        if(settings.callPhone())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_CALL_PHONE);
        }
        if(settings.readCallLog())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_READ_CALL_LOG);
        }
        if(settings.writeCallLog())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_WRITE_CALL_LOG);
        }
        if(settings.addVoiceMail())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_ADD_VOICE_MAIL);
        }
        if(settings.useSip())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_USE_SIP);
        }
        if(settings.processOutgoingCalls())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_PROCESS_OUTGOING_CALLS);
        }
        if(settings.bodySensors())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_BODY_SENSORS);
        }
        if(settings.sendSMS())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_SEND_SMS);
        }
        if(settings.receiveSMS())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_RECEIVE_SMS);
        }
        if(settings.receiveWAP())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_RECEIVE_WAP_PUSH);
        }
        if(settings.receiveMMS())
        {
            MeshPermissionInterface.requestPermission(a,MeshPermissionInterface.TAG_RECEIVE_MMS);
        }
    }

    /**
     * Connect (Not implemented yet)
     */
    private final void connect()
    {

    }

    /**
     * Initializes the Application
     * <br>Tasks:
     * <br>
     * <br>1. Invoke {@link #initCache(Context) initCache(Context)}
     * <br>2. Retrieves all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Init Init} annotated methods
     * <br>3. Retrieves all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Terminate Terminate} annotated methods
     * <br>4. Retrieves all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod} annotated methods
     * <br>5. Invokes all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Init Init} annotated methods
     */
    private final void init()
    {
        initCache(getApplicationContext());
        initMethods = new ArrayList<>();
        terminateMethods = new ArrayList<>();
        timedMethods = new ArrayList<>();
        notificationListeners = new ArrayList<>();
        subUpdateListeners = new ArrayList<>();
        initMethods.addAll(MeshAnnotationManager.getInit(getClass()));
        terminateMethods.addAll(MeshAnnotationManager.getTerminate(getClass()));
        timedMethods.addAll(MeshAnnotationManager.getTimed(getClass()));
        MeshAnnotationManager.runMethods(initMethods, this);
    }

    /**
     * Starts all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimedMethod} annotated methods
     */
    private final void startTimedMethods()
    {
        final Object o = this;
        handler = new Handler();
        MeshAnnotationManager.startTimedMethods(timedMethods, handler,o);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Image Cache-----------------------------------------

    /**
     * Initializes a 5MB cache for BitMaps
     * @param context Required to get free memory
     * @return {@link #cache cache}
     */
    private LruCache<String, Bitmap> initCache(Context context)
    {

        if(cache==null)
        {
//            int cSize = (int) Runtime.getRuntime().freeMemory()*1048;
            cache = new LruCache<String, Bitmap>(5*1048) {
                @Override
                protected int sizeOf(String key, Bitmap bitmap)
                {
                    return bitmap.getByteCount()/1048;
                }
            };
        }

        return cache;
    }

    /**
     * Returns the BitMap whose key matches the passed key
     * @param key key of the BitMap requested for
     * @return Bitmap whose key matches the passed key
     */
    final Bitmap getBitmap(String key)
    {
        return cache.get(key);
    }

    /**
     * Adds a bitmap to the list
     * @param key key to refer to the Bitmap on the list
     * @param bitmap the actual Bitmap to be cached
     */
    final void addBitmap(String key,Bitmap bitmap)
    {
        if(cache==null)
        {
            Log.i(TAG,"Cache is not yet initiated");
            initCache(getBaseContext());
        }
        if(cache.get(key)==null)
        {
            cache.put(key,bitmap);
        }

    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Getter------------------------------------------

    /**
     * Returns the value of {@link #dataSource dataSource}
     * @return {@link #dataSource dataSource} set through {@link AppSettings AppSettings}
     */
    final int getDataSource() {
        return dataSource;
    }

    /**
     * Flag if the app is a demo app or not.
     * @return
     * Value:
     * <br>True - app is a demo version (DEFAULT)
     * <br>False - app is a live version
     */
    final boolean isDemo() {
        return isDemo;
    }

    /**
     * Flag if App will be connecting to an XMPP Server
     * @return
     * Value:
     * <br>True - app will connect to an XMPP server
     * <br>False - app will not connect to an XMPP server (DEFAULT)
     */
    final boolean isUseXMPP() {
        return useXMPP;
    }

    /**
     * Returns {@link #restrictWifi restrictWifi}
     * @return {@link #restrictWifi restrictWifi}
     *
     */
    final boolean isRestrictWifi() {
        return restrictWifi;
    }
    /**
     * Returns {@link #settings settings}
     * @return {@link #settings settings}
     *
     */
    final AppSettings getSettings() {
        return settings;
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Setter------------------------------------------

    /**
     * Sets the value for {@link #dataSource dataSource} which specifies the source of data the app will use
     * @param dataSource source of data the app will use
     */
    final void setDataSource(int dataSource) {
        this.dataSource = dataSource;
    }
    /**
     * Sets the value for {@link #isDemo isDemo} which specifies if the app is a demo or a live app
     * @param demo specifies if the app is a demo or a live app
     */
    final void setDemo(boolean demo) {
        isDemo = demo;
    }
    /**
     * Sets the value for {@link #useXMPP useXMPP} which specifies if the app will connect to an XMPP server or not
     * @param useXMPP specifies if the app will connect to an XMPP server or not
     */
    final void setUseXMPP(boolean useXMPP) {
        this.useXMPP = useXMPP;
    }
    /**
     * Sets the value for {@link #restrictWifi restrictWifi} which specifies if the app will restrict the use of Wi-Fi
     * @param restrictWifi specifies if the app will restrict the use of Wi-Fi
     */
    final void setRestrictWifi(boolean restrictWifi) {
        this.restrictWifi = restrictWifi;
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Terminate---------------------------------------

    /**
     * Runs all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Terminate Terminate} annotated methods and clears them afterwards
     */
    private final void terminate()
    {
        MeshAnnotationManager.runMethods(terminateMethods,this);
        terminateMethods.clear();
    }
    /**
     * Terminates all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimeMethod} annotated methods
     */
    private final void stopTimedMethods()
    {
        MeshAnnotationManager.stopTimedMethods(handler);
    }

    /**
     * Disconnect (Not implemented yet)
     */
    private final void disconnect()
    {

    }
    //----------------------------------------------------------------------------------------------

    //------------------------------------------------Airmedia--------------------------------------

    /**
     * Adds a {@link MeshAirmediaListener MeshAirmediaListener} to listen to Airmedia Events
     * @param listener {@link MeshAirmediaListener MeshAirmediaListener} to be added
     */
    final void addAirmediaListener(MeshAirmediaListener listener)
    {
        if(airmediaListeners==null)
        {
            airmediaListeners = new ArrayList<>();
        }
        airmediaListeners.add(listener);
        Log.i(TAG,"Airmedia Listeners:"+airmediaListeners.size());
    }

    /**
     * Removes a {@link MeshAirmediaListener MeshAirmediaListener} to stop listening to Airmedia Events
     * @param listener {@link MeshAirmediaListener MeshAirmediaListener} to be removed
     */
    final void removeAirmediaListener(MeshAirmediaListener listener)
    {
        airmediaListeners.remove(listener);
        Log.i(TAG,"Airmedia Listeners:"+airmediaListeners.size());
    }

    /**
     * Triggered when app detects changes with {@link com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Control.MeshTVAirMediaPreferenceManager MeshTVAirMediaPreferenceManager}
     * <br>Triggers: {@link MeshAirmediaListener#onCredentialsUpdated() MeshAirmediaListener.onCredentialsUpdated()}
     * @param airMedia Airmedia Credentials
     */
    final void update(MeshAirMedia airMedia)
    {
        for(MeshAirmediaListener l:airmediaListeners)
        {
            l.onCredentialsUpdated();
        }
    }

    /**
     * Triggered when App Detects that Airmedia is ready to be used
     * <br>Trigger: {@link MeshAirmediaListener#onReady() MeshAirmediaListener#onReady()}
     */
    final void onAirMediaReady()
    {
        for(MeshAirmediaListener l:airmediaListeners)
        {
            l.onReady();
        }
    }
    /**
     * Triggered when App Detects that Airmedia was stopped
     * <br>Trigger: {@link MeshAirmediaListener#onStop() MeshAirmediaListener#onStop()}
     */
    final void onAirmediaStop()
    {
        for(MeshAirmediaListener l:airmediaListeners)
        {
            l.onStop();
        }
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Notification----------------------------------
    final void playNotification()
    {
        if(settings!=null)
        {
            MediaPlayer mPlayer = null;
            mPlayer= MediaPlayer.create(this, settings.notificationSound()==-1?R.raw.best_text_message: settings.notificationSound());
            mPlayer.start();
        }

    }
    final void emergencyNotification()
    {
        if(settings!=null)
        {
            MediaPlayer mPlayer = null;
            mPlayer= MediaPlayer.create(this, settings.alertSound()==-1?R.raw.emergency_alert: settings.alertSound());
            mPlayer.start();
        }

    }
    final void addNotificationListener(MeshNotificationListener subscriptionListener)
    {
        if(notificationListeners == null )
        {
            notificationListeners = new ArrayList<>();
        }
        notificationListeners.add(subscriptionListener);
    }
    final void removeNotificationListener(MeshNotificationListener subscriptionListener)
    {
        if(notificationListeners == null )
        {
            notificationListeners = new ArrayList<>();
        }
        else
        {
            notificationListeners.remove(subscriptionListener);
        }
    }
    public void notifyApp(MeshMessage meshMessage)
    {
        Log.i(TAG,"NOTIFICATION:RECEIVED = "+meshMessage.getMessg_text());
        Log.i(TAG,"NOTIFICATION:RECEIVED = LISTENERS:"+notificationListeners.size());
        for(MeshNotificationListener l:notificationListeners)
        {
            l.onNotify(meshMessage);
        }
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Subscription-----------------------------------
    final void addSubscriptionListener(MeshSubscriptionListener subscriptionListener)
    {
        if(subListeners == null )
        {
            subListeners = new ArrayList<>();
        }
        subListeners.add(subscriptionListener);
    }
    final void removeSubscriptionListener(MeshSubscriptionListener subscriptionListener)
    {
        if(subListeners == null )
        {
            subListeners = new ArrayList<>();
        }
        else
        {
            subListeners.remove(subscriptionListener);
        }
    }
    final void enableSubscription()
    {
        for(MeshSubscriptionListener l:subListeners)
        {
            l.onEnabled();
        }
    }
    final void disableSubscription()
    {
        for(MeshSubscriptionListener l:subListeners)
        {
            l.onDisabled();
        }
    }
    final void onSubscriptionDataUpdated()
    {
        if(subListeners == null )
        {
            subListeners = new ArrayList<>();
        }
        else
        {
            for(MeshSubscriptionListener l:subListeners)
            {
                l.onDataUpdate();
            }
        }

    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------SubscriptionPackage--------------------------------------
    final void addSubscriptionPackageListener(MeshSubscriptionUpdateListener listener)
    {
        if(subUpdateListeners!=null)
        {
            subUpdateListeners = new ArrayList<>();
        }
        subUpdateListeners.add(listener);
    }
    final void removeSubscriptionPackageListener(MeshSubscriptionUpdateListener listener)
    {
        if(subUpdateListeners == null )
        {
            subUpdateListeners = new ArrayList<>();
        }
        else
        {
            subUpdateListeners.remove(listener);
        }
    }
    final void onSubscriptionReset()
    {
        if(subUpdateListeners==null)
        {
            subUpdateListeners = new ArrayList<>();
        }
        MeshChannelPackageManager.clearAll();
        for(MeshSubscriptionUpdateListener l:subUpdateListeners)
        {
            l.subscriptionReset();
        }
    }
    final void onSubDataUpdate()
    {
        if(subUpdateListeners==null)
        {
            subUpdateListeners = new ArrayList<>();
        }
        for(MeshSubscriptionUpdateListener l:subUpdateListeners)
        {
            l.subscriptionUpdated();
        }
    }
    final void onSubEmpty()
    {
        if(subUpdateListeners==null)
        {
            subUpdateListeners = new ArrayList<>();
        }
        for(MeshSubscriptionUpdateListener l:subUpdateListeners)
        {
            l.subscriptionEmpty();
        }
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Check-in/out------------------------------------
    /**
     * Adds a {@link MeshGuestListener MeshGuestListener} to listen to changes in {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.GuestPreference GuestPreference}
     * <br>
     * @param listener {@link MeshGuestListener MeshGuestListener} to be added
     */
    final void addGuestListener(MeshGuestListener listener)
    {
        if(guestListeners==null)
        {
            guestListeners = new ArrayList<>();
        }
        guestListeners.add(listener);
        Log.i(TAG,"Guest Listeners:"+guestListeners.size());
    }
    /**
     * Removes a {@link MeshGuestListener MeshGuestListener} to stop listening to changes in {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.GuestPreference GuestPreference}
     * @param listener {@link MeshGuestListener MeshGuestListener} to be removed
     */
    final void removeGuestListener(MeshGuestListener listener)
    {
        guestListeners.remove(listener);
        Log.i(TAG,"Guest Listeners:"+guestListeners.size());
    }

    /**
     * Triggered when changes in
     * {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager#getGuestFirstName(Context) MeshTVPreferenceManager#getGuestFirstName(Context)}
     * or/and {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager#getGuestLastName(Context) MeshTVPreferenceManager#getGuestLastName(Context)}
     * was detected
     *<br>Triggers: {@link MeshGuestListener#checkIn(MeshGuest)}  MeshGuestListener.checkIn(MeshGuest)}
     * @param guest New {@link MeshGuest MeshGuest} data
     */
    final void checkIn(MeshGuest guest)
    {
        Log.i(TAG,"Checkin Guest for :"+guestListeners.size()+" listener(s)");
        MeshRealmManager.clear(MeshMessage.class);
        MeshRealmManager.clear(MeshBillV2.class);
        MeshRealmManager.clear(MeshVODBought.class);
        for(MeshGuestListener l:guestListeners)
        {
            l.checkIn(guest);
        }
    }
    /**
     * Triggered when changes OTHER THAN
     * {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager#getGuestFirstName(Context) MeshTVPreferenceManager#getGuestFirstName(Context)}
     * and {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager#getGuestLastName(Context) MeshTVPreferenceManager#getGuestLastName(Context)}
     * was detected
     *<br>Triggers: {@link MeshGuestListener#onGuestUpdate(MeshGuest)}  MeshGuestListener.onGuestUpdate(MeshGuest)}
     * @param guest New {@link MeshGuest MeshGuest} data
     */
    final void update(MeshGuest guest)
    {
        Log.i(TAG,"Updating Guest for :"+guestListeners.size()+" listener(s)");
        for(MeshGuestListener l:guestListeners)
        {
            l.onGuestUpdate(guest);
        }
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Config----------------------------------------

    /**
     * Adds a {@link MeshConfigListener MeshConfigListener} to listen to changes in {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelPreference HotelPreference}
     * @param listener {@link MeshConfigListener MeshConfigListener} to be added
     */
    final void addConfigListener(MeshConfigListener listener)
    {
        if(configListeners==null)
        {
            configListeners = new ArrayList<>();
        }
        configListeners.add(listener);
        Log.i(TAG,"Config Listeners:"+configListeners.size());
    }
    /**
     * Removes a {@link MeshConfigListener MeshConfigListener} to stop listening to changes in {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelPreference HotelPreference}
     * @param listener {@link MeshConfigListener MeshConfigListener} to be removed
     */
    final void removeConfigListener(MeshConfigListener listener)
    {
        configListeners.remove(listener);
        Log.i(TAG,"Config Listeners:"+configListeners.size());
    }

    /**
     * Triggered when App Detects changes in {@link MeshConfig MeshConfig}
     * <br>Trigger: {@link MeshConfigListener#onHotelConfigurationChange(MeshConfig) MeshConfigListener#onHotelConfigurationChange(MeshConfig)}
     * @param config new {@link MeshConfig MeshConfig} data
     */
    final void update(MeshConfig config)
    {
        for(MeshConfigListener l:configListeners)
        {
            l.onHotelConfigurationChange(config);
        }
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Weather---------------------------------------
    /**
     * Adds a {@link MeshWeatherListener MeshWeatherListener} to listen to changes in {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelWeatherPreference HotelWeatherPreference}
     * @param listener {@link MeshWeatherListener MeshWeatherListener} to be added
     */
    final void addWeatherListener(MeshWeatherListener listener)
    {
        if(weatherListeners==null)
        {
            weatherListeners = new ArrayList<>();
        }
        weatherListeners.add(listener);
        Log.i(TAG,"Weather Listeners:"+weatherListeners.size());
    }
    /**
     * Removes a {@link MeshWeatherListener MeshWeatherListener} to stop listening to changes in {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelWeatherPreference HotelWeatherPreference}
     * @param listener {@link MeshWeatherListener MeshWeatherListener} to be added
     */
    final void removeWeatherListener(MeshWeatherListener listener)
    {
        weatherListeners.remove(listener);
        Log.i(TAG,"Weather Listeners:"+weatherListeners.size());
    }
    /**
     * Triggered when App Detects changes in {@link MeshWeatherLocal MeshWeatherLocal}
     * <br>Trigger: {@link MeshConfigListener#onHotelConfigurationChange(MeshConfig) MeshConfigListener#onHotelConfigurationChange(MeshConfig)}
     * @param v2 new {@link MeshWeatherLocal MeshWeatherLocal}
     */
    final void update(MeshWeatherLocal v2)
    {
        for(MeshWeatherListener l:weatherListeners)
        {
            l.onUpdateForWeather(v2);
        }
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Getter-----------------------------------------
    /**
     * @deprecated
     * Sets the FileSystem Path for File System operations
     * @return File System path
     */
    final String getFileSystemPath()
    {
        return settings.fileSystemDirectory();
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Exception=======================================

    /**
     * Thrown when some or all required configuration for {@link BittelApp BittelApp} is missing
     */
    private final class MeshApplicationException extends RuntimeException
    {
        public MeshApplicationException(String message)
        {
            super(message);
        }
    }
    //==============================================================================================
    //===============================================Abstract=======================================

    /**
     * Triggered to run code just right after onCreate is called
     */
    abstract void prepare();

    /**
     * States the Folder in /sdcard/Android where FileSystem files for this app can be found
     * @return Folder Name
     */
    abstract String getDBName();
    //==============================================================================================

}
