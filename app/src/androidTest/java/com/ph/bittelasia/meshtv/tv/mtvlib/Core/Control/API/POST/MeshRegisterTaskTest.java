package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.POST;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners.MeshRequestListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVTestApp;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

/**
 * Created by mars on 1/3/18.
 */
public class MeshRegisterTaskTest
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

        MeshRegisterTask registerTask = new MeshRegisterTask(context, new MeshRequestListener() {
            @Override
            public void onFailed(String message) {

            }

            @Override
            public void onResult(String result) {
                m = result;
                signal.countDown();
            }
        });
        registerTask.execute();
        signal.await();
        boolean success = false;
        try
        {
            JSONObject object = new JSONObject(m);
            JSONObject data = new JSONObject(object.getString("data"));
            assertEquals("success",data.getString("result"));
            assertEquals("STB has been registered",data.getString("reasons"));
            assertEquals(MeshTVPreferenceManager.getRoom(context),data.getString("room_number"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            assertTrue(success);
        }


    }
}