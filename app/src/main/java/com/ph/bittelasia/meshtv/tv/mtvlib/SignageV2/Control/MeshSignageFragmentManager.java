package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.Control;

import android.util.Log;

import androidx.fragment.app.Fragment;

import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshType;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment1.MeshSignageListFragment1;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment2.MeshSignageListFragment2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment3.MeshSignageListFragment3;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment4.MeshSignageListFragment4;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment5.MeshSignageListFragment5;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment6.MeshSignageListFragment6;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment7.MeshSignageListFragment7;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment8.MeshSignageListFragment8;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment9.MeshSignageListFragment9;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Time.TimeFragment1.MeshTimeFragmentLayout1;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Time.TimeFragment2.MeshTimeFragmentLayout2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Time.TimeFragment3.MeshTimeFragmentLayout3;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Time.TimeFragment4.MeshTimeFragmentLayout4;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Time.TimeFragment5.MeshTimeFragmentLayout5;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Time.TimeFragment6.MeshTimeFragmentLayout6;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Time.TimeFragment7.MeshTimeFragmentLayout7;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Weather.WeatherFragment1.MeshCurrentWeatherFragment1;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Weather.WeatherFragment2.MeshCurrentWeatherFragment2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Weather.WeatherFragment3.MeshCurrentWeatherFragment3;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Weather.WeatherFragment4.MeshCurrentWeatherFragment4;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Weather.WeatherFragment5.MeshCurrentWeatherFragment5;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.WeatherForecast.WeatherForecastFragment1.MeshWeatherForecastFragment1;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.WeatherForecast.WeatherForecastFragment2.MeshWeatherForecastFragment2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.WeatherForecast.WeatherForecastFragment3.MeshWeatherForecastFragment3;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.WeatherForecast.WeatherForecastFragment4.MeshWeatherForecastFragment4;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.WeatherForecast.WeatherForecastFragment5.MeshWeatherForecastFragment5;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.WeatherForecast.WeatherForecastFragment6.MeshWeatherForecastFragment6;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.WeatherForecast.WeatherForecastFragment7.MeshWeatherForecastFragment7;

public class MeshSignageFragmentManager
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = MeshSignageFragmentManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================MeshFragmentManager==================================
    public static Fragment getFragment(MeshMediaV2 media)
    {
        Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
        Log.i(TAG," GENFRAG-06-18-18 : Retrieving Fragment for Media ID:"+media.getId());
        switch (media.getType_id())
        {
            case MeshType.TYPE_FEED:
                Log.i(TAG," GENFRAG-06-18-18 : Media Type (FEED)");
                break;
            case MeshType.TYPE_TIME:
                Log.i(TAG," GENFRAG-06-18-18 : Media Type (TIME)");
                break;
            case MeshType.TYPE_WEATHER:
                Log.i(TAG," GENFRAG-06-18-18 : Media Type (WEATHER)");
                break;
            case MeshType.TYPE_WEATHER_FORECAST:
                Log.i(TAG," GENFRAG-06-18-18 : Media Type (WEATHER_FORECAST)");
                break;
        }
        Log.i(TAG," GENFRAG-06-18-18 : Layout ID : "+media.getLayout_id());
        switch (media.getLayout_id())
        {
            case 14:
                Log.i(TAG," GENFRAG-06-18-18 : FEED FRAGMENT (1)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return MeshSignageListFragment1.get(media);
            case 15:
                Log.i(TAG," GENFRAG-06-18-18 : TIME FRAGMENT (1)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshTimeFragmentLayout1();
            case 16:
                Log.i(TAG," GENFRAG-06-18-18 : TIME FRAGMENT (2)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshTimeFragmentLayout2();
            case 17:
                Log.i(TAG," GENFRAG-06-18-18 : TIME FRAGMENT (3)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshTimeFragmentLayout3();
            case 18:
                Log.i(TAG," GENFRAG-06-18-18 : TIME FRAGMENT (4)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshTimeFragmentLayout4();
            case 19:
                Log.i(TAG," GENFRAG-06-18-18 : TIME FRAGMENT (5)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshTimeFragmentLayout5();
            case 20:
                Log.i(TAG," GENFRAG-06-18-18 : TIME FRAGMENT (6)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshTimeFragmentLayout6();
            case 21:
                Log.i(TAG," GENFRAG-06-18-18 : FEED FRAGMENT (2)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return MeshSignageListFragment2.get(media);
            case 22:
                Log.i(TAG," GENFRAG-06-18-18 : FEED FRAGMENT (3)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return MeshSignageListFragment3.get(media);
            case 23:
                Log.i(TAG," GENFRAG-06-18-18 : FEED FRAGMENT (4)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return MeshSignageListFragment4.get(media);
            case 24:
                Log.i(TAG," GENFRAG-06-18-18 : FEED FRAGMENT (5)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return MeshSignageListFragment5.get(media);
            case 25:
                Log.i(TAG," GENFRAG-06-18-18 : FEED FRAGMENT (6)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return MeshSignageListFragment6.get(media);
            case 26:
                Log.i(TAG," GENFRAG-06-18-18 : WEATHER FORECAST FRAGMENT (2)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshWeatherForecastFragment2();
            case 27:
                Log.i(TAG," GENFRAG-06-18-18 : WEATHER FORECAST FRAGMENT (3)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshWeatherForecastFragment3();
            case 28:
                Log.i(TAG," GENFRAG-06-18-18 : WEATHER FORECAST FRAGMENT (4)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshWeatherForecastFragment4();
            case 29:
                Log.i(TAG," GENFRAG-06-18-18 : WEATHER FORECAST FRAGMENT (5)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshWeatherForecastFragment5();
            case 30:
                Log.i(TAG," GENFRAG-06-18-18 : WEATHER FORECAST FRAGMENT (6)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshWeatherForecastFragment6();
            case 31:
                Log.i(TAG," GENFRAG-06-18-18 : WEATHER FORECAST FRAGMENT (1)");

                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshWeatherForecastFragment1();
            case 32:
                Log.i(TAG," GENFRAG-06-18-18 : WEATHER FRAGMENT (1)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshCurrentWeatherFragment1();
            case 33:
                Log.i(TAG," GENFRAG-06-18-18 : WEATHER FRAGMENT (2)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshCurrentWeatherFragment2();
            case 34:
                Log.i(TAG," GENFRAG-06-18-18 : WEATHER FRAGMENT (3)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshCurrentWeatherFragment3();
            case 35:
                Log.i(TAG," GENFRAG-06-18-18 : WEATHER FRAGMENT (4)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshCurrentWeatherFragment4();
            case 39:
                Log.i(TAG," GENFRAG-06-18-18 : TIME FRAGMENT (7)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshTimeFragmentLayout7();
            case 40:
                Log.i(TAG," GENFRAG-06-18-18 : WEATHER FRAGMENT (5)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshCurrentWeatherFragment5();
            case 41:
                Log.i(TAG," GENFRAG-06-18-18 : FEED FRAGMENT (7)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return  MeshSignageListFragment7.get(media);
            case 42:
                Log.i(TAG," GENFRAG-06-18-18 : FEED FRAGMENT (8)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return  MeshSignageListFragment8.get(media);
            case 44:
                Log.i(TAG," GENFRAG-06-18-18 : FEED FRAGMENT (9)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return  MeshSignageListFragment9.get(media);
            case 45:
                Log.i(TAG," GENFRAG-06-18-18 : WEATHER FORECAST FRAGMENT (7)");
                Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
                return new MeshWeatherForecastFragment7();
        }
        Log.i(TAG," GENFRAG-06-18-18 : FRAGMENT NOT FOUND");
        Log.i(TAG," GENFRAG-06-18-18 : ============================================================================");
        return null;
    }
    //==============================================================================================

}