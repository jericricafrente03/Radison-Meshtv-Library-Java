package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mars on 1/3/18.
 */
public class BittelMacAddressRetrieverTest {
    private Context context;

    @Before
    public void setUp() throws Exception {
        context = InstrumentationRegistry.getContext();
    }


    @Test
    public void getMacAddress() throws Exception
    {
        assertEquals(32,BittelMacAddressRetriever.getDeviceMacAddressMD5(context).length());
    }
}