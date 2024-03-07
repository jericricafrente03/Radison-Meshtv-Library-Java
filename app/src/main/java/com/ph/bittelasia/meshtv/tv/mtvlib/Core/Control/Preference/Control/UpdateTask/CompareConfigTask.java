package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.UpdateTask;

import android.os.AsyncTask;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshConfig;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

/**
 * Asynchronously compares a {@link MeshConfig MeshConfig} with the data from {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelPreference HotelPreference} triggers {@link MeshConfig#update()  MeshConfig.update()} from the new {@link MeshConfig MeshConfig} and triggers
 * {@link MeshTVApp#updateConfig(MeshConfig) MeshTVApp.MeshConfig()} when any change is found
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class CompareConfigTask extends AsyncTask<Void,Void,Integer>
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    private static final String TAG = CompareConfigTask.class.getSimpleName();
    private static final int NO_CHANGE       =   0;
    private static final int UPDATE          =   1;
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    /**
     * New {@link MeshConfig MeshConfig} to be compared
     */
    MeshConfig config = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================Constructor=========================================

    /**
     * Requires an instance of {@link MeshConfig MeshConfig} from the datasource to compare with {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelPreference HotelPreference} data
     * @param config {@link MeshConfig MeshConfig} to be compared
     */
    public CompareConfigTask(MeshConfig config)
    {
        this.config = config;
    }
    //==============================================================================================
    //===========================================LifeCycle==========================================
    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
    }
    @Override
    protected Integer doInBackground(Void... voids)
    {
        if (!config.getHotel_name().equals(MeshTVPreferenceManager.getHotelName(null)))
        {
            config.update();
            return UPDATE;
        }
        if (!config.getHotel_street().equals(MeshTVPreferenceManager.getHotelStreet(null)))
        {
            config.update();
            return UPDATE;
        }
        if (!config.getHotel_city().equals(MeshTVPreferenceManager.getHotelCity(null)))
        {
            config.update();
            return UPDATE;
        }
        if (!config.getHotel_country().equals(MeshTVPreferenceManager.getHotelCountry(null)))
        {
            config.update();
            return UPDATE;
        }
        if (!config.getHotel_timezone_id().equals(MeshTVPreferenceManager.getHotelTimezone(null)))
        {
            config.update();
            return UPDATE;
        }
        if (!config.getHotel_email().equals(MeshTVPreferenceManager.getHotelEmail(null)))
        {
            config.update();
            return UPDATE;
        }
        if (!config.getHotel_currency().equals(MeshTVPreferenceManager.getHotelCurrency(null)))
        {
            config.update();
            return UPDATE;
        }
        if (!config.getHotel_website().equals(MeshTVPreferenceManager.getHotelWebsite(null)))
        {
            config.update();
            return UPDATE;
        }
        if (!config.getHotel_logo().equals(MeshTVPreferenceManager.getHotelLogo(null)))
        {
            config.update();
            return UPDATE;
        }
        if (!config.getHotel_map_coord().equals(MeshTVPreferenceManager.getHotelCoord(null)))
        {
            config.update();
            return UPDATE;
        }
        if (!config.getHotel_weather_id().equals(MeshTVPreferenceManager.getWeatherID(null)))
        {
            config.update();
            return UPDATE;
        }
        if (!config.getHotel_welcome_message().equals(MeshTVPreferenceManager.getWelcomeMessage(null)))
        {
            config.update();
            return UPDATE;
        }
        if (!config.getHotel_reservation_message().equals(MeshTVPreferenceManager.getReservationMessage(null)))
        {
            config.update();
            return UPDATE;
        }

        if (!config.getHotel_service_request_message().equals(MeshTVPreferenceManager.getServiceMessage(null)))
        {
            config.update();
            return UPDATE;
        }
        if (!config.getHotel_checkout_message().equals(MeshTVPreferenceManager.getCheckOutMessage(null)))
        {
            config.update();
            return UPDATE;
        }
        return NO_CHANGE;
    }
    @Override
    protected void onPostExecute(Integer integer)
    {
        super.onPostExecute(integer);
        switch (integer)
        {
            case UPDATE:
                MeshTVApp.get().updateConfig(config);
                break;
        }
    }
    //==============================================================================================
}
