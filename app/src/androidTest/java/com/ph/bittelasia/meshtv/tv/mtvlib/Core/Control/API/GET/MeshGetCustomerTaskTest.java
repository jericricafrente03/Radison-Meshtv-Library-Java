package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.GET;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners.MeshRequestListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshGuest;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

/**
 * Created by mars on 1/3/18.
 */
public class MeshGetCustomerTaskTest
{
    String m = null;
    CountDownLatch signal = null;
    private Context context;

    @Before
    public void setUp() throws Exception
    {
        signal = new CountDownLatch(1);
        context = InstrumentationRegistry.getContext();
        MeshTVPreferenceManager.updateIPTV(context);

    }

    @After
    public void tearDown() throws Exception {
        signal.countDown();
        context = null;
    }

    @Test
    public void testRegister() throws Exception
    {

        MeshGetCustomerTask registerTask = new MeshGetCustomerTask(context, new MeshRequestListener() {
            @Override
            public void onFailed(String message) {

            }

            @Override
            public void onResult(String result) {
                m = result;
                signal.countDown();
            }
        }, new MeshDataListener() {
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
            public void onDataReceived(Class c, int size) {

            }
        });
        registerTask.execute();
        signal.await();
        boolean success = false;
        try
        {
            JSONObject object = new JSONObject(m);
            assertEquals("get_customer",object.getString("class"));
            JSONObject data = new JSONObject(object.getString("data"));
            assertEquals("success",data.getString("result"));
            assertEquals(MeshTVPreferenceManager.getRoom(context),data.getString("room_number"));

            MeshGuest guest = new MeshGuest(context);
            guest.setAddress("7 HAI");
            guest.setBirthDate("88-11-02");
            guest.setCity("Paranaque");
            guest.setCountry("Philippines");
            guest.setEmail("mraraullo@gmail.com");
            guest.setFirstname("Mars Ray");
            guest.setLandline("8467020");
            guest.setMobile("0949903350");
            guest.setPostal("1747");
            guest.setLastname("Araullo");
            guest.update(context);

            assertEquals(guest.getAddress(),MeshTVPreferenceManager.getGuestAddress(context));
            assertEquals(guest.getBirthDate(),MeshTVPreferenceManager.getGuestBirthDate(context));
            assertEquals(guest.getCity(),MeshTVPreferenceManager.getGuestCity(context));
            assertEquals(guest.getCountry(),MeshTVPreferenceManager.getGuestCountry(context));
            assertEquals(guest.getEmail(),MeshTVPreferenceManager.getGuestEmail(context));
            assertEquals(guest.getFirstname(),MeshTVPreferenceManager.getGuestFirstName(context));
            assertEquals(guest.getLandline(),MeshTVPreferenceManager.getGuestLandline(context));
            assertEquals(guest.getLastname(),MeshTVPreferenceManager.getGuestLastName(context));
            assertEquals(guest.getMobile(),MeshTVPreferenceManager.getGuestMobile(context));
            assertEquals(guest.getPostal(),MeshTVPreferenceManager.getGuestPostal(context));


            MeshGuest guest2 = new MeshGuest(object.getString("data"));
            guest2.update(context);

            assertNotEquals(guest.getAddress(),MeshTVPreferenceManager.getGuestAddress(context));
            assertNotEquals(guest.getBirthDate(),MeshTVPreferenceManager.getGuestBirthDate(context));
            assertNotEquals(guest.getCity(),MeshTVPreferenceManager.getGuestCity(context));
            assertNotEquals(guest.getCountry(),MeshTVPreferenceManager.getGuestCountry(context));
            assertNotEquals(guest.getEmail(),MeshTVPreferenceManager.getGuestEmail(context));
            assertNotEquals(guest.getFirstname(),MeshTVPreferenceManager.getGuestFirstName(context));
            assertNotEquals(guest.getLandline(),MeshTVPreferenceManager.getGuestLandline(context));
            assertNotEquals(guest.getLastname(),MeshTVPreferenceManager.getGuestLastName(context));
            assertNotEquals(guest.getMobile(),MeshTVPreferenceManager.getGuestMobile(context));
            assertNotEquals(guest.getPostal(),MeshTVPreferenceManager.getGuestPostal(context));

            assertEquals(guest2.getAddress(),MeshTVPreferenceManager.getGuestAddress(context));
            assertEquals(guest2.getBirthDate(),MeshTVPreferenceManager.getGuestBirthDate(context));
            assertEquals(guest2.getCity(),MeshTVPreferenceManager.getGuestCity(context));
            assertEquals(guest2.getCountry(),MeshTVPreferenceManager.getGuestCountry(context));
            assertEquals(guest2.getEmail(),MeshTVPreferenceManager.getGuestEmail(context));
            assertEquals(guest2.getFirstname(),MeshTVPreferenceManager.getGuestFirstName(context));
            assertEquals(guest2.getLandline(),MeshTVPreferenceManager.getGuestLandline(context));
            assertEquals(guest2.getLastname(),MeshTVPreferenceManager.getGuestLastName(context));
            assertEquals(guest2.getMobile(),MeshTVPreferenceManager.getGuestMobile(context));
            assertEquals(guest2.getPostal(),MeshTVPreferenceManager.getGuestPostal(context));

            success = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            assertTrue(success);
        }


    }
}