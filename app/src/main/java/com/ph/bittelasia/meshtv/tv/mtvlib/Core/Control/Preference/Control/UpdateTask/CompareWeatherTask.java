package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.UpdateTask;

import android.os.AsyncTask;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshGuest;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshWeatherLocal;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
/**
 * Asynchronously compares a {@link MeshWeatherLocal MeshWeatherLocal} with the data from
 * {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelWeatherPreference HotelWeatherPreference}
 * <br>Triggers:
 * <br>1. {@link MeshWeatherLocal#update()}  MeshGuest.update()} on any discrepancy found
 * <br>2. {@link MeshTVApp#updateWeather(MeshWeatherLocal)  MeshTVApp.updateWeather(MeshWeatherLocal)}
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class CompareWeatherTask extends AsyncTask<Void,Void,Integer>
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    private static final String TAG          =   "Mars-"+CompareWeatherTask.class.getSimpleName();
    private static final int UPDATE          =   1;
    private static final int NO_CHANGE       =   0;
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    /**
     * New {@link MeshWeatherLocal MeshWeatherLocal} to be compared
     */
    MeshWeatherLocal weatherLocal = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Constructor========================================
    /**
     * Requires an instance of {@link MeshWeatherLocal MeshWeatherLocal} from the datasource to compare with
     * {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.HotelWeatherPreference HotelWeatherPreference} data
     * @param weatherLocal {@link MeshWeatherLocal MeshWeatherLocal} to be compared
     */
    public CompareWeatherTask(MeshWeatherLocal weatherLocal)
    {
        this.weatherLocal = weatherLocal;
    }
    //==============================================================================================
    //============================================LifeCycle=========================================
    @Override
    protected final void onPreExecute()
    {
        super.onPreExecute();

    }
    @Override
    protected final Integer doInBackground(Void... voids)
    {
       if(!String.valueOf(weatherLocal.getLon()).equals(MeshTVPreferenceManager.getHotelWeatherCoordLon(null)))
       {
           weatherLocal.update();
           return UPDATE;
       }
        if(!String.valueOf(weatherLocal.getLat()).equals(MeshTVPreferenceManager.getHotelWeatherCoordLat(null)))
        {
            weatherLocal.update();
            return UPDATE;
        }
        if(weatherLocal.getCountry().equals(MeshTVPreferenceManager.getHotelWeatherSysCountry(null)))
        {
            weatherLocal.update();
            return UPDATE;
        }
        if(weatherLocal.getLoc_name().equals(MeshTVPreferenceManager.getHotelWeatherCity(null)))
        {
            weatherLocal.update();
            return UPDATE;
        }
        if(String.valueOf(weatherLocal.getSunrise()).equals(MeshTVPreferenceManager.getHotelWeatherSysSunrise(null)))
        {
            weatherLocal.update();
            return UPDATE;
        }
        if(String.valueOf(weatherLocal.getSunset()).equals(MeshTVPreferenceManager.getHotelWeatherSysSunset(null)))
        {
            weatherLocal.update();
            return UPDATE;
        }
        if(String.valueOf(weatherLocal.getDescription()).equals(MeshTVPreferenceManager.getHotelWeatherWeatherDesc(null)))
        {
            weatherLocal.update();
            return UPDATE;
        }
        if(String.valueOf(weatherLocal.getIcon()).equals(MeshTVPreferenceManager.getHotelWeatherWeatherIcon(null)))
        {
            weatherLocal.update();
            return UPDATE;
        }
        if(String.valueOf(weatherLocal.getTemp_cur()).equals(MeshTVPreferenceManager.getHotelWeatherMainTemp(null)))
        {
            weatherLocal.update();
            return UPDATE;
        }
        if(String.valueOf(weatherLocal.getTemp_max()).equals(MeshTVPreferenceManager.getHotelWeatherMainTempMax(null)))
        {
            weatherLocal.update();
            return UPDATE;
        }
        if(String.valueOf(weatherLocal.getTemp_min()).equals(MeshTVPreferenceManager.getHotelWeatherMainTempMin(null)))
        {
            weatherLocal.update();
            return UPDATE;
        }
        if(String.valueOf(weatherLocal.getHumidity()).equals(MeshTVPreferenceManager.getHotelWeatherMainHumidity(null)))
        {
            weatherLocal.update();
            return UPDATE;
        }
        if(String.valueOf(weatherLocal.getPressure()).equals(MeshTVPreferenceManager.getHotelWeatherMainPressure(null)))
    {
        weatherLocal.update();
        return UPDATE;
    }
        if(String.valueOf(weatherLocal.getTimezone()).equals(MeshTVPreferenceManager.getHotelWeatherTimezone(null)))
        {
            weatherLocal.update();
            return UPDATE;
        }
        return NO_CHANGE;
    }
    @Override
    protected final void onPostExecute(Integer i)
    {
        super.onPostExecute(i);
        switch (i)
        {
            case UPDATE:

                MeshTVApp.get().updateWeather(weatherLocal);
                break;
        }
    }
    //==============================================================================================
}
