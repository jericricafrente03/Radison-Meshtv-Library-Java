package com.ph.bittelasia.meshtv.tv.mtvlib.PackageManager.Control;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.MeshTVPackageListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.TestInterface.MeshAPITester;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

public class MeshTVPackageManagerTest
{
    @Rule
    public ActivityTestRule<MeshAPITester> activityTestRule = new ActivityTestRule<MeshAPITester>(MeshAPITester.class);
    Context context;
    CountDownLatch cd;
    String packageName = null;

    @Before
    public void setUp() throws Exception
    {
        context = InstrumentationRegistry.getContext();
        cd = new CountDownLatch(1);
    }

    @Test
    public void listen() throws Exception
    {
//        MeshTVPackageManager.listen(activityTestRule.getActivity(), new MeshTVGenericPackageListener() {
//            @Override
//            public void onInstalled(String p)
//            {
//                packageName = p;
//                cd.countDown();
//            }
//
//            @Override
//            public void onUninstalled(String p)
//            {
//                packageName = p;
//                cd.countDown();
//            }
//
//        });
//        cd.await();
//        assertEquals("com.waxrain.airplaydmr",packageName);

    }
}