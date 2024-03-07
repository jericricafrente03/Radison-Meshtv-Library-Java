package com.ph.bittelasia.meshtv.tv.mtvlib.EPG.Model;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mars on 4/5/2018.
 */
    public class MeshTimeSlotTest {


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIsDone() throws Exception {
        String time_test = "10:50 AM";
        MeshTimeSlot meshTimeSlot = new MeshTimeSlot();
        meshTimeSlot.setId(0);
        meshTimeSlot.setTime(time_test);
        assertEquals(0,meshTimeSlot.getId());
        assertEquals(time_test,meshTimeSlot.getTime());

        assertTrue(meshTimeSlot.isDone());

    }


}