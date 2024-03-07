package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Getter;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Model.MeshAirMedia;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Constant.AppDataSource;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Manager.MeshTVDataManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshConfig;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshGuest;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.ResourceManager.MeshResourceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util.MeshRawReader;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVTestApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory;
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
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStream;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStreamCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Tag.MeshTag;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast;
import com.ph.bittelasia.meshtv.tv.mtvlib.TestInterface.MeshAPITester;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;


import java.util.concurrent.CountDownLatch;


public class MeshTVGetTaskTest
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = MeshTVGetTaskTest.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    Context context;
    CountDownLatch cd;
    MeshTVApp app;
    int result = 0;
    Class c = null;
    @Rule
    public ActivityTestRule<MeshAPITester> mActivityRule = new ActivityTestRule<>(MeshAPITester.class);
    MeshDataListener listener = new MeshDataListener() {
        @Override
        public void onNoNetwork(Class c)
        {
            result = -1;
            cd.countDown();
        }

        @Override
        public void onNoData(Class c) {
            result = -2;
            cd.countDown();
        }

        @Override
        public void onParseFailed(Class c, String message) {
            result = -3;
            cd.countDown();
        }

        @Override
        public void onFileNotFound(Class c, String message) {
            result = -4;
            cd.countDown();
        }

        @Override
        public void onDataReceived(Class cs, int size)
        {
            c = cs;
            result = size;
            cd.countDown();
        }
    };
    //----------------------------------------------------------------------------------------------

    //==============================================================================================
    //=============================================LifeCycle========================================
    @Before
    public void setUp() throws Exception
    {
        context = InstrumentationRegistry.getContext();
        app=(MeshTVTestApp)mActivityRule.getActivity().getApplication();
        c = null;
        result = 0;
        MeshTVPreferenceManager.updateIPTV(context);
    }
    //==============================================================================================
    //===============================================Test===========================================
    //--------------------------------------------DataDirect----------------------------------------
    @Test
    public void testTVChannelsDataDirect() throws Exception
    {
        int res = R.raw.get_all_tv_channel;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshChannel.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testTVChannelCategoriesDataDirect() throws Exception
    {
        int res = R.raw.get_tv_channel_category;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshChannelCategory.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testDepartureFlightsDataDirect() throws Exception
    {
        int res = R.raw.get_departure_flights;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshDepartureFlight.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testConciergeRequestItemDataDirect() throws Exception
    {
        int res = R.raw.get_all_item_request;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshConciergeRequestItem.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;

    }
    @Test
    public void testConciergeRequestServiceDataDirect() throws Exception
    {
        int res = R.raw.get_all_service_request;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshConciergeRequestService.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testFoodDataDirect() throws Exception
    {
        int res = R.raw.get_all_f_and_b_item;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshFood.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;

    }
    @Test
    public void testFoodCategoryDataDirect() throws Exception
    {
        int res = R.raw.get_f_and_b_category;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshFoodCategory.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testFacilityDataDirect() throws Exception
    {
        int res = R.raw.get_all_facilities;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshFacility.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testFacilityCategoryDataDirect() throws Exception
    {
        int res = R.raw.get_facility_category;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshFacilityCategory.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;

    }
    @Test
    public void testAirportDataDirect() throws Exception
    {
        int res = R.raw.get_airport_name;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshAirport.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;

    }
    @Test
    public void testDepartureDataDirect() throws Exception
    {
        int res = R.raw.get_departure_flights;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshDepartureFlight.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;

    }
    @Test
    public void testArrivalDataDirect() throws Exception
    {
        int res = R.raw.get_arrival_flights;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshArrivalFlight.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;

    }
    @Test
    public void testMessageDataDirect() throws Exception
    {
        int res = R.raw.get_message;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshMessage.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testShoppingCategoryDataDirect() throws Exception
    {
        int res = R.raw.get_shopping_category;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshShoppingCategory.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testShoppingItemDataDirect() throws Exception
    {
        int res = R.raw.get_all_shopping_item;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshShoppingItem.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;

    }
    @Test
    public void testStreamItemDataDirect() throws Exception
    {
        int res = R.raw.get_live_stream_series;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshStream.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;

    }
    @Test
    public void testStreamCategoryDataDirect() throws Exception
    {
        int res = R.raw.get_live_stream_category;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshStreamCategory.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testExtraDataDirect() throws Exception
    {
        int res = R.raw.get_extras;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshTag.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;

    }
    @Test
    public void testVCCategoryDataDirect() throws Exception
    {
        int res = R.raw.get_maps_categories;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshVCCategory.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testVCDataDirect() throws Exception
    {
        int res = R.raw.get_all_establishments_v3;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshVC.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;

    }
    @Test
    public void testWeatherFCDataDirect() throws Exception
    {
        int res = R.raw.weather_forecast;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshWeatherForecast.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;

    }
    @Test
    public void testWeatherDataDirect() throws Exception
    {
        int res = R.raw.all_weather;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshWeatherV2.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;

    }
    @Test
    public void testConfigDataDirect() throws Exception
    {
        int res = R.raw.get_config;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshConfig.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testGuestDataDirect() throws Exception
    {
        int res = R.raw.get_customer;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshGuest.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;


    }
    @Test
    public void testAirmediaDataDirect() throws Exception
    {
        int res = R.raw.get_airmedia_user;
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(res));
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshAirMedia.class);
        Log.i(TAG,"Data :"+MeshRawReader.read(res));
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;

    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------DataRequest---------------------------------------
    @Test
    public void testTVChannelsDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.TV);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshChannel.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testTVChannelCategoriesDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.TV_CATEGORY);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshChannelCategory.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;

    }
    @Test
    public void testDepartureFlightsDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.DEPARTURE_FLIGHT);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshDepartureFlight.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;

    }
    @Test
    public void testConciergeRequestItemDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.ITEM_REQ);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshConciergeRequestItem.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;

    }
    @Test
    public void testConciergeRequestServiceDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.SVC_REQ);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshConciergeRequestService.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;

    }
    @Test
    public void testFoodDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.FOOD);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshFood.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testFoodCategoryDDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.FOOD_CATEGORY);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshFoodCategory.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testFacilityDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.FACILITY);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshFacility.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testFacilityCategoryDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.FACILITY_CATEGORY);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshFacilityCategory.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testAirportDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.AIRPORT_NAME);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshAirport.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testDepartureDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.DEPARTURE_FLIGHT);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshDepartureFlight.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testArrivalDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.ARRIVAL_FLIGHT);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshArrivalFlight.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testMessageDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.MESSAGE);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshMessage.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testShoppingCategoryDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.SHOPPING_CATEGORY);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshShoppingCategory.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testShoppingItemDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.SHOPPING_ITEM);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshShoppingItem.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }

    /**
     * Not implemented yet
     * @throws Exception
     */
    public void testStreamItemDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(R.raw.get_live_stream_series));
        cd.await();
        assertEquals(c,MeshStream.class);
        assertTrue(0<=result);
        result = 0;
    }
    /**
     * Not implemented yet
     * @throws Exception
     */
    public void testStreamCategoryDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(R.raw.get_live_stream_category));
        cd.await();
        assertEquals(c,MeshStreamCategory.class);
        assertTrue(0<=result);
        result = 0;
    }
    /**
     * Not implemented yet
     * @throws Exception
     */
    public void testExtraDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_DIRECT,listener, MeshRawReader.read(R.raw.get_extras));
        cd.await();
        assertEquals(c,MeshTag.class);
        assertTrue(0<=result);
        result = 0;
    }

    @Test
    public void testVCCategoryDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.MAP_CATEGORIES);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshVCCategory.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testVCDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.VC);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshVC.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testWeatherFCDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.WEATHER_FORECAST);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshWeatherForecast.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testWeatherDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.WEATHER);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshWeatherV2.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testConfigDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.CONFIG);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshConfig.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testGuestDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.CUSTOMER);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshGuest.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;
    }
    @Test
    public void testAirmediaDataRequest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,MeshTVDataManager.DATA_REQUEST,listener,MeshGET.AIRMEDIA_USER);
        cd.await();
        Log.i(TAG,"===========================================================================");
        Log.i(TAG,"Class :"+c.getSimpleName());
        assertEquals(c,MeshAirMedia.class);
        Log.i(TAG,"Result :"+result);
        assertTrue(0<=result);
        Log.i(TAG,"===========================================================================");
        result = 0;;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Raw--------------------------------------------
    @Test
    public void testConciergeCategoryFromRaw() throws Exception
    {

        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.RAW, MeshConciergeCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testTVChannelsFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.RAW, MeshChannel.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testTVChannelCategoriesFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.RAW, MeshChannelCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testConciergeRequestItemFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.RAW, MeshConciergeRequestItem.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testConciergeRequestServiceFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.RAW, MeshConciergeRequestService.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testFoodFromFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.RAW, MeshFood.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testFoodCategoryFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.RAW, MeshFoodCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testFacilityFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.RAW, MeshFacility.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testFacilityCategoryFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.RAW, MeshFacilityCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testAirportFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.RAW, MeshAirport.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testDepartureFlightsFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.RAW, MeshDepartureFlight.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testArrivalFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.RAW, MeshArrivalFlight.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testShoppingCategoryFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.RAW, MeshShoppingCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testShoppingItemFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.RAW, MeshShoppingItem.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testStreamItemFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.RAW, MeshStream.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testStreamCategoryFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.RAW, MeshStreamCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testExtraFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.RAW, MeshTag.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testVCCategoryFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.RAW, MeshVCCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testVCFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.RAW, MeshVC.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testWeatherFCFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.RAW, MeshWeatherForecast.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testWeatherFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.RAW, MeshWeatherV2.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testConfigFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.RAW, MeshConfig.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testGuestFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.RAW, MeshGuest.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testAirmediaFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.RAW, MeshAirMedia.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testContinentFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.RAW, MeshContinent.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testCityFromRaw() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.RAW, MeshCity.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------FileSystem----------------------------------------
    @Test
    public void testConciergeCategoryFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.FILE_SYSTEM, MeshConciergeCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testTVChannelsFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.FILE_SYSTEM, MeshChannel.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testTVChannelCategoriesFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.FILE_SYSTEM, MeshChannelCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testConciergeRequestItemFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.FILE_SYSTEM, MeshConciergeRequestItem.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testConciergeRequestServiceFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.FILE_SYSTEM, MeshConciergeRequestService.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testFoodFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.FILE_SYSTEM, MeshFood.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testFoodCategoryFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.FILE_SYSTEM, MeshFoodCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testFacilityFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.FILE_SYSTEM, MeshFacility.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testFacilityCategoryFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.FILE_SYSTEM, MeshFacilityCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testAirportFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.FILE_SYSTEM, MeshAirport.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testDepartureFlightsFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.FILE_SYSTEM, MeshDepartureFlight.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testArrivalFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.FILE_SYSTEM, MeshArrivalFlight.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testShoppingCategoryFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.FILE_SYSTEM, MeshShoppingCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testShoppingItemFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.FILE_SYSTEM, MeshShoppingItem.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testStreamItemFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.FILE_SYSTEM, MeshStream.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testStreamCategoryFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.FILE_SYSTEM, MeshStreamCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testExtraFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.FILE_SYSTEM, MeshTag.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testVCCategoryFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.FILE_SYSTEM, MeshVCCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testVCFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.FILE_SYSTEM, MeshVC.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testWeatherFCFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.FILE_SYSTEM, MeshWeatherForecast.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testWeatherFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.FILE_SYSTEM, MeshWeatherV2.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testConfigFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.FILE_SYSTEM, MeshConfig.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testGuestFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.FILE_SYSTEM, MeshGuest.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testAirmediaFromFileSystem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context,AppDataSource.FILE_SYSTEM, MeshAirMedia.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Live-------------------------------------------
    @Test
    public void testTVChannels() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshChannel.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testTVChannelCategories() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshChannelCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testDepartureFlights() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshDepartureFlight.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testConciergeRequestItem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshConciergeRequestItem.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testConciergeRequestService() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshConciergeRequestService.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testFood() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshFood.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testFoodCategory() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshFoodCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testFacility() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshFacility.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testFacilityCategory() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshFacilityCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testAirport() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshAirport.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testDeparture() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshDepartureFlight.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testArrival() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshArrivalFlight.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testMessage() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshMessage.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testShoppingCategory() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshShoppingCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testShoppingItem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshShoppingItem.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }

    @Test
    public void testVCCategory() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshVCCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testVC() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshVC.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testWeatherFC() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshWeatherForecast.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testWeather() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshWeatherV2.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testConfig() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshConfig.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testGuest() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshGuest.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    @Test
    public void testAirmedia() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshAirMedia.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }

    /**
     * Not Implemented Yet
     * @throws Exception
     */
    public void testStreamItem() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshStream.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    /**
     * Not Implemented Yet
     * @throws Exception
     */
    public void testStreamCategory() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshStreamCategory.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    /**
     * Not Implemented Yet
     * @throws Exception
     */
    public void testExtra() throws Exception
    {
        cd = new CountDownLatch(1);
        result = 0;
        MeshTVDataManager.requestData(context, AppDataSource.SERVER, MeshTag.class, new MeshDataListener() {
            @Override
            public void onNoNetwork(Class c)
            {
                result = -1;
                cd.countDown();
            }

            @Override
            public void onNoData(Class c) {
                result = -2;
                cd.countDown();
            }

            @Override
            public void onParseFailed(Class c, String message) {
                result = -3;
                cd.countDown();
            }

            @Override
            public void onFileNotFound(Class c, String message) {
                result = -4;
                cd.countDown();
            }

            @Override
            public void onDataReceived(Class c, int size)
            {
                result = size;
                cd.countDown();
            }
        });
        cd.await();
        assertTrue(0<=result);
        result = 0;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

}