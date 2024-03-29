package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.GET;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners.MeshRequestListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

/**
 * Created by mars on 1/3/18.
 */
public class MeshGetDepartureTaskTest
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
    public void testDeparture() throws Exception
    {
        MeshGetDepartureTask flightTask = new MeshGetDepartureTask(context, new MeshRequestListener() {
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
        flightTask.execute();
        signal.await();
        boolean success = false;

        try
        {
            JSONObject object = new JSONObject(m);
            assertEquals("get_departure_flights",object.getString("class"));;

            JSONArray data = new JSONArray(object.getString("data"));
            assertTrue(data.length()>0);

            success = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            assertTrue(success);
        }


    }

}