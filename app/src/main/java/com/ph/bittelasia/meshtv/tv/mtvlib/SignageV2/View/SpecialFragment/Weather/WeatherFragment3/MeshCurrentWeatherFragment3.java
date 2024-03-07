package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Weather.WeatherFragment3;

import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Weather.WeatherFragment.BittelSignageCurrentWeatherFragment;

public class MeshCurrentWeatherFragment3 extends BittelSignageCurrentWeatherFragment
{
    //=========================================Variable=============================================
    //-----------------------------------------Constant---------------------------------------------
    public static final String TAG = MeshCurrentWeatherFragment3.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================BittelSignageCurrentWeatherFragment===============================
    @Override
    public int setLayoutId() {
        return R.layout.digital_signage_weather_layout3;
    }

    @Override
    public int setDateId() {
        return 0;
    }

    @Override
    public int setTimeId() {
        return 0;
    }

    @Override
    public int setIconId() {
        return R.id.iv_weather;
    }

    @Override
    public int setTempId() {
        return R.id.tv_temp;
    }

    @Override
    public int setHumidityId() {
        return R.id.tv_humidity;
    }

    @Override
    public int setDescriptionId() {
        return R.id.tv_desc;
    }

    @Override
    public String setDateFormat() {
        return null;
    }

    @Override
    public String setTimeFormat() {
        return null;
    }
    //==============================================================================================
}
