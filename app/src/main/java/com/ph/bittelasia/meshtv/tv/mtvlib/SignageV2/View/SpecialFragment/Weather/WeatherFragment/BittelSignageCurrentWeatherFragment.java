package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Weather.WeatherFragment;

import android.view.View;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshConfigListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshWeatherListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshConfig;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshWeatherLocal;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmListener;

import java.util.ArrayList;

public abstract class BittelSignageCurrentWeatherFragment extends SignageCurrentWeatherFragment
    implements
        MeshWeatherListener,
        MeshRealmListener,
        MeshConfigListener
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = BittelSignageCurrentWeatherFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------View-------------------------------------------
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //======================================SignageCurrentWeatherFragment===========================
    @Override
    public void onDrawDone(View v)
    {
        MeshWeatherLocal local = new MeshWeatherLocal();
        setLocal(local);
        MeshTVApp.get().addListener(this);
    }
    //==============================================================================================
    //=========================================MeshWeatherListener==================================
    @Override
    public void onUpdateForWeather(MeshWeatherLocal weatherLocal)
    {
        setLocal(weatherLocal);
    }
    //==============================================================================================
    //=========================================MeshRealmListener====================================
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

    }
    //==============================================================================================
    //=========================================MeshConfigListener===================================
    @Override
    public void onHotelConfigurationChange(MeshConfig config) {

    }
    //==============================================================================================

}
