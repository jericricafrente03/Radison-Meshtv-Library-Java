package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.GET;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners.MeshRequestListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Parser.MeshParser;
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
public class MeshGetXBillTaskTest {
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
    public void testXBill() throws Exception
    {

        MeshGetXBillTask xBillTask = new MeshGetXBillTask(context, new MeshRequestListener() {
            @Override
            public void onFailed(String message) {

            }

            @Override
            public void onResult(String result) {
                m = result;
                signal.countDown();
            }
        });
        xBillTask.execute();
        signal.await();
        boolean success = false;
        try
        {
            try
            {
                JSONObject object = new JSONObject(m);
                assertEquals("view_bill2",object.getString("class"));;
                JSONArray data = new JSONArray(object.getString("data"));
                if(data.length()>0)
                {
                    assertTrue(MeshParser.parseBills(object.getString("data")).size()==data.length());
                }

                success = true;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                assertTrue(success);
            }
            success = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            assertTrue(success);
        }


    }
}