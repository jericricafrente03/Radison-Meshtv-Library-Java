package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.WeatherForecast.WeatherForecastFragment;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Manager.MeshTVDataManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Query.MeshValuePair;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecastDay;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.WeatherForecast.WeatherForecastFragment1.SignageForecastAdapter1;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.WeatherForecast.WeatherForecastFragment2.SignageForecastAdapter2;

import java.util.ArrayList;

public abstract class MeshWeatherForecastFragment extends Fragment implements MeshRealmListener,MeshDataListener
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    public static final String TAG = MeshWeatherForecastFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------View---------------------------------------------
    private GridView gv_view;
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    int layoutId            = -1;
    int gridId              = -1;
    int gridItemLayoutId    = -1;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================LifeCycle=========================================
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        Log.i(TAG,"6-13-18 : creating MeshWeatherForecastFragment");
        View v = null;
        layoutId = setLayout();
        if(layoutId>0)
        {
            v = inflater.inflate(layoutId,container,false);
        }

        Log.i(TAG,"6-13-18 : View "+(v==null?"creation failed":"created"));
        return v;

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG,"6-13-18 : referencing grid view");
        gridId = setGridId();
        if(gridId>0)
        {
            gv_view = view.findViewById(gridId);
        }
        Log.i(TAG,"6-13-18 : Grid View "+(gv_view==null?"not found":"found"));

        onDrawDone(view);
        requestFromRealm();
    }
    //==============================================================================================
    //========================================MeshRealmListener=====================================
    @Override
    public void onRetrieved(Class c, ArrayList<Object> results)
    {
        Log.i(TAG,"6-13-18 : Received data from Realm");
        if(c==MeshWeatherForecast.class)
        {
            Log.i(TAG,"6-13-18 : Received data size:"+results.size());
            Log.i(TAG,"WEATHER FORECASTS:"+results.size());
            MeshWeatherForecast forecast = (MeshWeatherForecast)results.get(0);
            MeshTVAdapter adapter = generateAdapter(getActivity(),getGv_view(),setGridItemLayout(),forecast);
            gv_view.setAdapter(adapter);
        }

    }
    @Override
    public void onFailed(Class c, String message) {

    }
    @Override
    public void onEmpty(Class c, String message)
    {
        MeshTVDataManager.requestData(MeshWeatherV2.class,this);
    }

    @Override
    public void onCleared(Class c) {

    }
    //==============================================================================================
    //============================================Method============================================
    //--------------------------------------------Action--------------------------------------------
    public void requestFromRealm()
    {
        Log.i(TAG+"-61318","REQUEST FROM REALM ==========================================");
        Log.i(TAG+"-61318","Country:"+MeshTVPreferenceManager.getHotelCountry(getActivity()));
        MeshValuePair vp = new MeshValuePair(MeshWeatherForecast.TAG_COUNTRY, MeshTVPreferenceManager.getHotelCountry(getActivity()));
        vp.setString(true);
        MeshRealmManager.retrieve(MeshWeatherForecast.class,this,vp);
        Log.i(TAG+"-61318","REQUEST FROM REALM ==========================================");
    }

    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Getter--------------------------------------------
    public GridView getGv_view() {
        return gv_view;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //========================================MeshDataListener======================================
    @Override
    public void onNoNetwork(Class c) {

    }
    @Override
    public void onNoData(Class c) {

    }
    @Override
    public void onParseFailed(Class c, String message) {

    }
    @Override
    public void onFileNotFound(Class c, String message) {

    }
    @Override
    public void onDataReceived(Class c, int size)
    {
        if(c==MeshWeatherForecast.class)
        {
            if(size>0)
            {
                requestFromRealm();
            }


        }
    }
    //==============================================================================================
    //=======================================Abstract===============================================
    public abstract int setLayout();
    public abstract int setGridId();
    public abstract int setGridItemLayout();
    public abstract void onDrawDone(View v);
    public abstract MeshTVAdapter generateAdapter(Context c, GridView gv_view, int layout, MeshWeatherForecast forecast);
    //==============================================================================================
}
