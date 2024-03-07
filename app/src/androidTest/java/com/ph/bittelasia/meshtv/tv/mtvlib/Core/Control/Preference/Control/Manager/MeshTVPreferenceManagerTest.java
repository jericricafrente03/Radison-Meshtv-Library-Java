package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshAppListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Parser.MeshParser;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshGuestListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshGuest;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util.MeshRawReader;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVTestApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmEventListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;
import com.ph.bittelasia.meshtv.tv.mtvlib.TestInterface.MeshAPITester;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

public class MeshTVPreferenceManagerTest
{
    MeshTVTestApp app;
    @Rule
    public ActivityTestRule<MeshAPITester> activityTestRule = new ActivityTestRule<MeshAPITester>(MeshAPITester.class);
    CountDownLatch cd;
    private Context context;
    @Before
    public void setUp() throws Exception {
        context = InstrumentationRegistry.getContext();
    }
    @Test
    public void testGuestPreference() throws Exception {

        MeshTVPreferenceManager.resetGuest(context);

        assertEquals(MeshTVPreferenceManager.getGuestFirstName(context), "Welcome");
        assertEquals(MeshTVPreferenceManager.getGuestLastName(context), "Guest");
        assertEquals(MeshTVPreferenceManager.getGuestLandline(context), "+6325555555");
        assertEquals(MeshTVPreferenceManager.getGuestAddress(context), "MeshTV");
        assertEquals(MeshTVPreferenceManager.getGuestCity(context), "Manila");
        assertEquals(MeshTVPreferenceManager.getGuestCountry(context), "Philippines");
        assertEquals(MeshTVPreferenceManager.getGuestPostal(context), "1747");
        assertEquals(MeshTVPreferenceManager.getGuestEmail(context), "support@bittelasia.com");
        assertEquals(MeshTVPreferenceManager.getGuestBirthDate(context), "1972-12-20");
        assertEquals(MeshTVPreferenceManager.getGuestMobile(context), "+6329499999999");

        MeshTVPreferenceManager.setGuestFirstName(context, "Mars");
        MeshTVPreferenceManager.setGuestLastName(context, "Araullo");
        MeshTVPreferenceManager.setGuestLandline(context, "+639999999");
        MeshTVPreferenceManager.setGuestAddress(context, "House");
        MeshTVPreferenceManager.setGuestCity(context, "Las Pinas");
        MeshTVPreferenceManager.setGuestCountry(context, "Pinas");
        MeshTVPreferenceManager.setGuestPostal(context, "1746");
        MeshTVPreferenceManager.setGuestEmail(context, "mars.araullo@bittelasia.com");
        MeshTVPreferenceManager.setGuestBirthDate(context, "1988-11-02");
        MeshTVPreferenceManager.setGuestMobile(context, "+639499991111");

        assertEquals(MeshTVPreferenceManager.getGuestFirstName(context), "Mars");
        assertEquals(MeshTVPreferenceManager.getGuestLastName(context), "Araullo");
        assertEquals(MeshTVPreferenceManager.getGuestLandline(context), "+639999999");
        assertEquals(MeshTVPreferenceManager.getGuestAddress(context), "House");
        assertEquals(MeshTVPreferenceManager.getGuestCity(context), "Las Pinas");
        assertEquals(MeshTVPreferenceManager.getGuestCountry(context), "Pinas");
        assertEquals(MeshTVPreferenceManager.getGuestPostal(context), "1746");
        assertEquals(MeshTVPreferenceManager.getGuestEmail(context), "mars.araullo@bittelasia.com");
        assertEquals(MeshTVPreferenceManager.getGuestBirthDate(context), "1988-11-02");
        assertEquals(MeshTVPreferenceManager.getGuestMobile(context), "+639499991111");
    }
    @Test
    public void testHotelPreference() throws Exception
    {
        MeshTVPreferenceManager.resetConfig(context);

        assertEquals(MeshTVPreferenceManager.getHotelName(context),"hotel_name");
        assertEquals(MeshTVPreferenceManager.getHotelStreet(context),"hotel_street");
        assertEquals(MeshTVPreferenceManager.getHotelCity(context),"hotel_city");
        assertEquals(MeshTVPreferenceManager.getHotelCountry(context),"hotel_country");
        assertEquals(MeshTVPreferenceManager.getHotelTimezone(context),"hotel_timezone_id");
        assertEquals(MeshTVPreferenceManager.getHotelEmail(context),"hotel_email");
        assertEquals(MeshTVPreferenceManager.getHotelCurrency(context),"hotel_currency");
        assertEquals(MeshTVPreferenceManager.getHotelWebsite(context),"hotel_website");
        assertEquals(MeshTVPreferenceManager.getHotelLogo(context),"hotel_logo");
        assertEquals(MeshTVPreferenceManager.getHotelCoord(context),"hotel_map_coord");
        assertEquals(MeshTVPreferenceManager.getWelcomeMessage(context),"welcome_message");
        assertEquals(MeshTVPreferenceManager.getReservationMessage(context),"reservation_message");
        assertEquals(MeshTVPreferenceManager.getCheckOutMessage(context),"checkout_message");
        assertEquals(MeshTVPreferenceManager.getWeatherID(context),"hotel_weather_id");

        MeshTVPreferenceManager.setHotelName(context,"Novotel-Yangon");
        MeshTVPreferenceManager.setHotelStreet(context,"Turkey St.");
        MeshTVPreferenceManager.setHotelCity(context,"Paranaque");
        MeshTVPreferenceManager.setHotelCountry(context,"Philippines");
        MeshTVPreferenceManager.setHotelTimezone(context,"Asia/Manila");
        MeshTVPreferenceManager.setHotelEmail(context,"mmmmmm@m.com");
        MeshTVPreferenceManager.setHotelCurrency(context,"$");
        MeshTVPreferenceManager.setHotelWebsite(context,"yahoo.com");
        MeshTVPreferenceManager.setHotelLogo(context,"logo");
        MeshTVPreferenceManager.setHotelCoord(context,"199.2221,2.13123");
        MeshTVPreferenceManager.setWelcomeMessage(context,"Welcome!");
        MeshTVPreferenceManager.setReservationMessage(context,"Reserved for!");
        MeshTVPreferenceManager.setCheckOutMessage(context,"Checkout");
        MeshTVPreferenceManager.setWeatherID(context,"Weather");


        assertEquals(MeshTVPreferenceManager.getHotelName(context),"Novotel-Yangon");
        assertEquals(MeshTVPreferenceManager.getHotelStreet(context),"Turkey St.");
        assertEquals(MeshTVPreferenceManager.getHotelCity(context),"Paranaque");
        assertEquals(MeshTVPreferenceManager.getHotelCountry(context),"Philippines");
        assertEquals(MeshTVPreferenceManager.getHotelTimezone(context),"Asia/Manila");
        assertEquals(MeshTVPreferenceManager.getHotelEmail(context),"mmmmmm@m.com");
        assertEquals(MeshTVPreferenceManager.getHotelCurrency(context),"$");
        assertEquals(MeshTVPreferenceManager.getHotelWebsite(context),"yahoo.com");
        assertEquals(MeshTVPreferenceManager.getHotelLogo(context),"logo");
        assertEquals(MeshTVPreferenceManager.getHotelCoord(context),"199.2221,2.13123");
        assertEquals(MeshTVPreferenceManager.getWelcomeMessage(context),"Welcome!");
        assertEquals(MeshTVPreferenceManager.getReservationMessage(context),"Reserved for!");
        assertEquals(MeshTVPreferenceManager.getCheckOutMessage(context),"Checkout");
        assertEquals(MeshTVPreferenceManager.getWeatherID(context),"Weather");

    }


    @Test
    public void testHotelWeatherPreference() throws Exception
    {
        MeshTVPreferenceManager.resetHotelWeather(context);


        MeshTVPreferenceManager.resetHotelWeather(context);
        assertEquals(MeshTVPreferenceManager.getHotelWeatherCoordLat(context),"121.49");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherCoordLon(context),"38.58");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherSysCountry(context),"MY");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherSysSunrise(context),"1422026271");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherSysSunset(context),"1522062283");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherWeatherDesc(context),"Sunny");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherWeatherIcon(context),"/images/weather/50n.png");

        assertEquals(MeshTVPreferenceManager.getHotelWeatherCity(context),"Malaysia");

        assertEquals(MeshTVPreferenceManager.getHotelWeatherTimezone(context),"+8");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherMainTemp(context),"27.29");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherMainPressure(context),"1028");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherMainHumidity(context),"81");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherMainTempMin(context),"14.245");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherMainTempMax(context),"15.245");

        MeshTVPreferenceManager.setHotelWeatherCoordLat(context,"1.1");
        MeshTVPreferenceManager.setHotelWeatherCoordLon(context,"1.1");
        MeshTVPreferenceManager.setHotelWeatherSysCountry(context,"PH");
        MeshTVPreferenceManager.setHotelWeatherSysSunrise(context,"122222222");
        MeshTVPreferenceManager.setHotelWeatherSysSunset(context,"21111111");
        MeshTVPreferenceManager.setHotelWeatherWeatherDesc(context,"Fog");
        MeshTVPreferenceManager.setHotelWeatherWeatherIcon(context,"images");
        MeshTVPreferenceManager.setHotelWeatherCity(context,"Las Pinas");
        MeshTVPreferenceManager.setHotelWeatherTimezone(context,"+9");
        MeshTVPreferenceManager.setHotelWeatherMainTemp(context,"37");
        MeshTVPreferenceManager.setHotelWeatherMainPressure(context,"0");
        MeshTVPreferenceManager.setHotelWeatherMainHumidity(context,"18");
        MeshTVPreferenceManager.setHotelWeatherMainTempMin(context,"19");
        MeshTVPreferenceManager.setHotelWeatherMainTempMax(context,"20");

        assertEquals(MeshTVPreferenceManager.getHotelWeatherCoordLat(context),"1.1");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherCoordLat(context),"1.1");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherSysCountry(context),"PH");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherSysSunrise(context),"122222222");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherSysSunset(context),"21111111");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherWeatherDesc(context),"Fog");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherWeatherIcon(context),"images");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherCity(context),"Las Pinas");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherTimezone(context),"+9");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherMainTemp(context),"37");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherMainPressure(context),"0");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherMainHumidity(context),"18");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherMainTempMin(context),"19");
        assertEquals(MeshTVPreferenceManager.getHotelWeatherMainTempMax(context),"20");
    }

    @Test
    public void testResetIPTV() throws Exception
    {
        MeshTVPreferenceManager.resetIPTV(context);
        assertEquals("NS",MeshTVPreferenceManager.getRoom(context));
        assertEquals("NS",MeshTVPreferenceManager.getXUsername(context));
        assertEquals("hello123",MeshTVPreferenceManager.getPassword(context));
        assertEquals("NS",MeshTVPreferenceManager.getService(context));
        assertEquals("NS",MeshTVPreferenceManager.getXMPPHost(context));
        assertEquals(5222,MeshTVPreferenceManager.getXMPPPort(context));
        assertEquals("NS",MeshTVPreferenceManager.getHTTPHost(context));
        assertEquals(6060,MeshTVPreferenceManager.getHTTPPort(context));
        assertEquals(30000,MeshTVPreferenceManager.getTimeOut(context));
        assertEquals(30000,MeshTVPreferenceManager.getConnectionTimeout(context));
        assertEquals("4.0",MeshTVPreferenceManager.getVersion(context));
    }

    @Test
    public void testResetUpdateIPTV() throws Exception
    {
        MeshTVPreferenceManager.updateIPTV(context);
        assertEquals("401",MeshTVPreferenceManager.getRoom(context));
        assertEquals("401",MeshTVPreferenceManager.getXUsername(context));
        assertEquals("hello123",MeshTVPreferenceManager.getPassword(context));
        assertEquals("localhost",MeshTVPreferenceManager.getService(context));
        assertEquals("155.94.175.130",MeshTVPreferenceManager.getXMPPHost(context));
        assertEquals(5222,MeshTVPreferenceManager.getXMPPPort(context));
        assertEquals("http://155.94.175.130",MeshTVPreferenceManager.getHTTPHost(context));
        assertEquals(6060,MeshTVPreferenceManager.getHTTPPort(context));
        assertEquals(30000,MeshTVPreferenceManager.getTimeOut(context));
        assertEquals(30000,MeshTVPreferenceManager.getConnectionTimeout(context));
        assertEquals("4.0",MeshTVPreferenceManager.getVersion(context));
    }
    String fg = "";
    String lg = "";
    @Test
    public void testCheckInCheckOut() throws Exception
    {
        final String tag = "testCheckInCheckOut()";
        Log.i(tag,"STARTED");
        MeshTVPreferenceManager.resetGuest(context);
        fg = "";
        lg = "";
        cd = new CountDownLatch(1);
        Log.i(tag,"cd - start");
        MeshGuestListener l1 = new MeshGuestListener() {
            @Override
            public void checkIn(MeshGuest guest)
            {
                fg = guest.getFirstname();
                lg = guest.getLastname();
                cd.countDown();
            }

            @Override
            public void onGuestUpdate(MeshGuest guest) {

            }
        };
        app = (MeshTVTestApp) activityTestRule.getActivity().getApplication();
        app.addListener(l1);
        MeshGuest guest = new MeshGuest(context);
        guest.setLastname("Araullo");
        Log.i(tag,"cd - Firstname:"+guest.getLastname());
        guest.setFirstname("Mars");
        Log.i(tag,"cd - Lastname:"+guest.getFirstname());
        guest.compare();
        cd.await();
        Log.i(tag,"cd - done");
        app.removeListener(l1);
        assertEquals("Mars",fg);
        assertEquals("Araullo",lg);

        ArrayList<Object> os = new ArrayList<>();
        for(MeshMessage m:MeshParser.parseMessage(MeshRawReader.read(R.raw.get_message)))
        {
            os.add(m);
        }
        Log.i(tag,"Messages - "+os.size());




        final CountDownLatch cd_message = new CountDownLatch(1);
        Log.i(tag,"cd_message - started");
        MeshRealmEventListener lMessage = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {
                Log.i(tag,"Messages - written");
                cd_message.countDown();
            }

            @Override
            public void onDelete(Class c) {

            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(lMessage);
        MeshRealmManager.insertBulk(os);
        cd_message.await();
        MeshRealmManager.removeListener(lMessage);

        Log.i(tag,"cd_message - done");

        final CountDownLatch cd1 = new CountDownLatch(1);
        Log.i(tag,"cd1 - start");
        MeshRealmManager.retrieve(MeshMessage.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {
                if(results.size()>0)
                {
                    Log.i(tag,"Messages - saved");
                    cd1.countDown();
                }
                else
                {
                    Log.i(tag,"Messages - not saved");
                    assertNotNull("No Message Found",null);
                }
            }

            @Override
            public void onFailed(Class c, String message) {
                Log.i(tag,"Messages - not saved:"+message);
                assertNotNull("No Message Found",null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                Log.i(tag,"Messages - not saved:"+message);
                assertNotNull("No Message Found",null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });

        cd1.await();
        Log.i(tag,"cd1 - ok");
        final CountDownLatch cd2 = new CountDownLatch(1);
        Log.i(tag,"cd2 - start");
        MeshGuestListener l2 = new MeshGuestListener() {
            @Override
            public void checkIn(MeshGuest guest) {
                fg = guest.getFirstname();
                lg = guest.getLastname();
                cd2.countDown();
            }

            @Override
            public void onGuestUpdate(MeshGuest guest) {

            }
        };
        app.addListener(l2);

        MeshGuest guest2 = new MeshGuest(context);
        guest2.setFirstname("Welcome");
        Log.i(tag,"cd2 - Lastname:"+guest2.getLastname());
        guest2.setLastname("Guest");
        Log.i(tag,"cd2 - Firstname:"+guest2.getFirstname());
        guest2.compare();
        cd2.await();
        Log.i(tag,"cd2 - done");
        assertEquals("Welcome",fg);
        assertEquals("Guest",lg);

        final CountDownLatch cd3 = new CountDownLatch(1);
        Log.i(tag,"cd3 - start");
        MeshRealmManager.retrieve(MeshMessage.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {
                Log.i(tag,"cd3 - retrieved");
                if(results.size()==0)
                {
                    cd3.countDown();
                }
                else
                {
                    assertNotNull("Message Should not be found",null);
                }
            }

            @Override
            public void onFailed(Class c, String message) {
                Log.i(tag,"cd3 - retrieved");
            }

            @Override
            public void onEmpty(Class c, String message) {
                Log.i(tag,"cd3 - empty");
                cd3.countDown();
            }

            @Override
            public void onCleared(Class c) {

            }
        });


        cd3.await();
        Log.i(tag,"cd3 - done");
    }





}