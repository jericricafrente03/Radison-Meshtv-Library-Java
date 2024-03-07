package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;

import com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Model.MeshAirMedia;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Settings.AppSettings;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshNotificationListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshSubscriptionUpdateListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshAirmediaListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshConfigListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshGuestListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshSubscriptionListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshWeatherListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshConfig;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshGuest;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshWeatherLocal;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Bill.MeshBillV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity;

/**
 * Required superclass of all Application Instance of MeshTVApps
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public abstract class MeshTVApp extends BittelApp
{
    //===============================================Variable=======================================
    //-----------------------------------------------Constant---------------------------------------
    public static final String TAG = MeshTVApp.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Instance--------------------------------------
    /**
     * Static Instance of {@link MeshTVApp for faster reference and global access to a context MeshTVApp}
     */
    static MeshTVApp app = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=================================================Static=======================================
    /**
     * Returns the static instance of {@link MeshTVApp for faster reference and global access to a context MeshTVApp}
     * @return Instance of {@link MeshTVApp for faster reference and global access to a context MeshTVApp}
     */
    public static MeshTVApp get() {
        return app;
    }
    //==============================================================================================
    //================================================LifeCycle=====================================
    /**
     * Saves an static instance of {@link MeshTVApp for faster reference and global access to a context MeshTVApp} for easier reference
     */
    final void prepare() {
        app = this;
    }
    //==============================================================================================
    //=================================================Method=======================================
    //-------------------------------------------------Action---------------------------------------
    public final void showRealmManager(Context context)
    {
        Intent i = new Intent(context, MeshDBEditorActivity.class);
        context.startActivity(i);
    }
    /**
     * Check-in a {@link MeshGuest MeshGuest}
     * @param guest {@link MeshGuest MeshGuest} to be checked-in
     */
    public final void checkInGuest(MeshGuest guest)
    {
        MeshRealmManager.clear(MeshMessage.class);
        MeshRealmManager.clear(MeshBillV2.class);
        checkIn(guest);
    }
    /**
     * Update data of a {@link MeshGuest MeshGuest} that is already checked-in
     * @param guest Updated {@link MeshGuest MeshGuest} data
     */
    public final void updateGuest(MeshGuest guest)
    {

        update(guest);
    }

    /**
     * Update {@link MeshWeatherLocal MeshWeatherLocal} data
     * @param v2 Updated {@link MeshWeatherLocal MeshWeatherLocal} data
     */
    public final void updateWeather(MeshWeatherLocal v2){update(v2);}

    /**
     * Update {@link MeshConfig MeshConfig} data
     * @param config Updated {@link MeshConfig MeshConfig} data
     */
    public final void updateConfig(MeshConfig config){update(config);}


    public final void updateSubscriber()
    {

        onSubscriptionDataUpdated();
    }
    public final void onEnableSubscription()
    {
        enableSubscription();
    }

    public final void onSubscriptionsUpdated()
    {
        onSubDataUpdate();
    }
    public final void onSubscriptionsReset()
    {
        onSubscriptionReset();
    }
    public final void onSubscriptionsEmpty()
    {
        onSubEmpty();
    }
    public final void onDisableSubscription()
    {
        disableSubscription();
    }

    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------Getter---------------------------------------
    @Override
    final String getDBName() {
        return getDB();
    }
    public String getFSPath()
    {
        return getDB();
    }
    /**
     * Returns data source set through {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Settings.AppSettings AppSettings} Annotation's
     * <br>{@link AppSettings#dataSource() dataSource()} method
     * <br>
     * <br>Values:
     * <br>
     * <br>{@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Constant.AppDataSource#RAW AppDataSource.RAW} - from library's raw folder
     * <br>{@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Constant.AppDataSource#USB AppDataSource.USB} - from a USB attached to STB
     * <br>{@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Constant.AppDataSource#FILE_SYSTEM AppDataSource.FILE_SYSTEM} - from /android/sdcard/
     * <br>{@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Constant.AppDataSource#SERVER AppDataSource.SERVER} - from live data source
     * @return Data source of the App
     */
    public int getDataSourceSetting() {
        return getDataSource();
    }
    /**
     * Returns true if app is a demo and false if not
     * @return Flag if the app is demo or not
     */
    public boolean isDemoSetting() {
        return isDemo();
    }
//    /**
//     * Returns true if app can use System API and false if not
//     * @return Flag if app can use System API
//     */
//    public boolean isSystemCapable(){return isUseSystemCapability();}

    /**
     * Returns true if WiFi is turned off when on Launcher and false if not
     * @return Flag if app turns off Wifi on homescreen
     */
    public boolean hasLimitedWifi(){return isRestrictWifi();}

    public AppSettings getAppSettings(){return getSettings();}
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------Setter---------------------------------------
    //public void setDataSourceSetting(int datasource) {
    //    setDataSource(datasource);
    //}
    //public void setIsDemoSetting(boolean demo) {
    //    setDemo(demo);
    //}
    //public void setIsSystemCapable(boolean capable){setUseSystemCapability(capable);}
    //public void setHasLimitedWifi(boolean limited){setRestrictWifi(limited);}
    //----------------------------------------------------------------------------------------------

    //-----------------------------------------------Permission-------------------------------------
    public void requestPermissions(Activity a)
    {
        askPermissions(a);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Bitmap----------------------------------------
    public Bitmap getCachedBitmap(String url)
    {
        return getBitmap(url);
    }
    public void addBitmapToCache(String url,Bitmap bitmap)
    {
        addBitmap(url,bitmap);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Listener--------------------------------------

    /**
     * Adds a listener to listen to changes in preferences.
     * @param o
     * <br>
     * <br>{@link MeshGuest MeshGuest} - using {@link MeshGuestListener MeshGuestListener}
     * <br>{@link MeshWeatherLocal MeshWeatherLocal} - using {@link MeshWeatherListener MeshWeatherListener}
     * <br>{@link MeshConfig MeshConfig} - using {@link MeshConfigListener MeshConfigListener}
     * <br>{@link MeshAirMedia MeshAirMedia} - using {@link MeshAirmediaListener MeshAirmediaListener}
     */
    public final void addListener(Object o)
    {
        if(o instanceof MeshGuestListener)
        {
            addGuestListener((MeshGuestListener)o);
        }
        if(o instanceof MeshSubscriptionUpdateListener)
        {

            addSubscriptionPackageListener((MeshSubscriptionUpdateListener)o);
        }
        if(o instanceof MeshWeatherListener)
        {
            addWeatherListener((MeshWeatherListener)o);
        }
        if(o instanceof MeshConfigListener)
        {
            addConfigListener((MeshConfigListener) o);
        }
        if(o instanceof MeshAirmediaListener)
        {
            addAirmediaListener((MeshAirmediaListener) o);
        }
        if(o instanceof MeshSubscriptionListener)
        {
            addSubscriptionListener((MeshSubscriptionListener)o);
        }
        if(o instanceof MeshNotificationListener)
        {
            addNotificationListener((MeshNotificationListener) o);

        }
    }
    /**
     * Removes a listener.
     * @param o
     * <br>
     * <br>{@link MeshGuest MeshGuest} - using {@link MeshGuestListener MeshGuestListener}
     * <br>{@link MeshWeatherLocal MeshWeatherLocal} - using {@link MeshWeatherListener MeshWeatherListener}
     * <br>{@link MeshConfig MeshConfig} - using {@link MeshConfigListener MeshConfigListener}
     * <br>{@link MeshAirMedia MeshAirMedia} - using {@link MeshAirmediaListener MeshAirmediaListener}
     */
    public final void removeListener(Object o) {
        if (o instanceof MeshNotificationListener)
        {
            removeNotificationListener((MeshNotificationListener)o);
        }
        if(o instanceof MeshSubscriptionUpdateListener)
        {
            removeSubscriptionPackageListener((MeshSubscriptionUpdateListener)o);
        }
        if(o instanceof MeshGuestListener)
        {
            removeGuestListener((MeshGuestListener)o);
        }
        if(o instanceof MeshWeatherListener)
        {
            removeWeatherListener((MeshWeatherListener)o);
        }
        if(o instanceof MeshConfigListener)
        {
            removeConfigListener((MeshConfigListener) o);
        }
        if(o instanceof MeshAirmediaListener)
        {
            removeAirmediaListener((MeshAirmediaListener) o);
        }
        if(o instanceof MeshSubscriptionListener)
        {
            removeSubscriptionListener((MeshSubscriptionListener)o);
        }
    }
    /**
     * Triggered when there are changes with {@link MeshAirMedia MeshAirMedia}
     * @param airMedia Updated {@link MeshAirMedia MeshAirMedia} data
     */
    public final void onAirMediaUpdate(MeshAirMedia airMedia)
    {
        update(airMedia);
    }
    /**
     * Triggered when AirMedia is ready to use
     */
    public final void onAirMediaReadyToUse()
    {
        onAirMediaReady();
    }
    /**
     * Default state of AirMedia or triggered when AirMedia stops
     */
    public final void onAirMediaNotReadyToUse()
    {
        onAirmediaStop();
    }
    public void notify(MeshMessage meshMessage)
    {
        notifyApp(meshMessage);
    }
    public void ringMessageNotification()
    {
        playNotification();
    }
    public void  emergencyAlert()
    {
        emergencyNotification();
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

    //================================================Abstract======================================
    /**
     * States the Folder in /sdcard/Android where FileSystem files for this app can be found
     * @return Folder Name
     */
    public abstract String getDB();

    //==============================================================================================
}
