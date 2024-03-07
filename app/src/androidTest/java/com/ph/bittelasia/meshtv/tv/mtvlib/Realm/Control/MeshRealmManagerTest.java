package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.GET.MeshGetExtraTask;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Manager.MeshTVDataManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Parser.MeshParser;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util.MeshRawReader;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Query.MeshValuePair;
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
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Request.MeshUpdateRequest;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Request.MeshUpdateRequestListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RoomType.MeshRoomType;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStream;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStreamCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshGenre;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast;
import com.ph.bittelasia.meshtv.tv.mtvlib.TestInterface.MeshAPITester;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import io.realm.Realm;
import io.realm.RealmResults;

import static org.junit.Assert.*;

public class MeshRealmManagerTest
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = MeshRealmManagerTest.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Instance---------------------------------------
    @Rule
    public ActivityTestRule<MeshAPITester>  tester = new ActivityTestRule<MeshAPITester>(MeshAPITester.class);
    Context context = null;
    CountDownLatch cd;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //================================================LifeCycle=====================================
    @Before
    public void setUp() throws Exception
    {
        context = InstrumentationRegistry.getContext();
    }
    //==============================================================================================
    //=============================================Test=============================================
    @Test
    public void testListeners() throws Exception
    {
        Log.i(TAG,"============================================================================");
        Log.i(TAG,"Initiating Mock Listeners");

        MeshRealmEventListener l1= new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {

            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmEventListener l2= new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {

            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmEventListener l3= new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {

            }

            @Override
            public void onClear(Class c) {

            }
        };

        MeshRealmManager.clearListener();
        assertEquals(0,MeshRealmManager.getListeners().size());
        MeshRealmManager.addListener(l1);
        assertEquals(1,MeshRealmManager.getListeners().size());
        MeshRealmManager.addListener(l1);
        assertEquals(1,MeshRealmManager.getListeners().size());
        MeshRealmManager.addListener(l2);
        assertEquals(2,MeshRealmManager.getListeners().size());
        MeshRealmManager.addListener(l2);
        assertEquals(2,MeshRealmManager.getListeners().size());
        MeshRealmManager.addListener(l3);
        assertEquals(3,MeshRealmManager.getListeners().size());
        MeshRealmManager.addListener(l3);
        assertEquals(3,MeshRealmManager.getListeners().size());
        MeshRealmManager.addListener(l3);
        assertEquals(3,MeshRealmManager.getListeners().size());
        MeshRealmManager.clearListener();
        assertEquals(0,MeshRealmManager.getListeners().size());
        MeshRealmManager.addListener(l1);
        MeshRealmManager.addListener(l2);
        MeshRealmManager.addListener(l3);
        assertEquals(3,MeshRealmManager.getListeners().size());
        MeshRealmManager.removeListener(l3);
        assertEquals(2,MeshRealmManager.getListeners().size());
        MeshRealmManager.removeListener(l2);
        assertEquals(1,MeshRealmManager.getListeners().size());
        MeshRealmManager.removeListener(l3);
        assertEquals(1,MeshRealmManager.getListeners().size());
        MeshRealmManager.removeListener(l2);
        assertEquals(1,MeshRealmManager.getListeners().size());
        MeshRealmManager.removeListener(l1);
        assertEquals(0,MeshRealmManager.getListeners().size());

        Log.i(TAG,"============================================================================");
    }
    //==============================================================================================
    //============================================Method============================================
    //------------------------------------------MeshChannel-----------------------------------------
    @Test
    public void testMeshChannel() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshChannel> channels = new ArrayList<>();
        cd = new CountDownLatch(1);
        channels.addAll( MeshParser.parseChannels(MeshRawReader.read(R.raw.get_all_tv_channel)));
        final CountDownLatch cd1 = new CountDownLatch(channels.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<channels.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshChannel ch1 = channels.get(ctr);
                    MeshChannel ch2 = ((MeshChannel)o);
                    Log.i(TAG,"CH1:"+ch1.getChannel_title()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getChannel_title()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(channels.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),channels.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshChannel.class);
        cd.await();

        MeshRealmManager.insert(channels.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshChannel.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshChannel ch:channels)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();


        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshChannel.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(channels.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();


        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshChannel)
                {
                    MeshChannel ch = (MeshChannel) o;
                    ch.setChannel_title("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshChannel)
                {
                    MeshChannel ch = (MeshChannel) o;
                    Log.i(TAG,"Channel:"+ch.getChannel_title());

                }
                cd.countDown();
            }
        });
        request.setC(MeshChannel.class);
        request.setId(MeshChannel.TAG_ID);
        request.setIdValue(channels.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshChannel.TAG_ID,channels.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshChannel.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshChannel)results.get(0)).getChannel_title());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };

        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(channels.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshChannel)o);
        }
        cd.await();

        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------

    //--------------------------------------MeshChannelCategory-------------------------------------
    @Test
    public void testMeshChannelCategory() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshChannelCategory> categories = new ArrayList<>();
        cd = new CountDownLatch(1);
        categories.addAll( MeshParser.parseChannelCategories(MeshRawReader.read(R.raw.get_tv_channel_category)));
        final CountDownLatch cd1 = new CountDownLatch(categories.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<categories.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshChannelCategory ch1 = categories.get(ctr);
                    MeshChannelCategory ch2 = ((MeshChannelCategory)o);
                    Log.i(TAG,"CH1:"+ch1.getCategory_name()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getCategory_name()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(categories.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),categories.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshChannelCategory.class);
        cd.await();

        MeshRealmManager.insert(categories.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshChannelCategory.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshChannelCategory ch:categories)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();



        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshChannelCategory.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(categories.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();


        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshChannelCategory)
                {
                    MeshChannelCategory ch = (MeshChannelCategory) o;
                    ch.setCategory_name("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshChannelCategory)
                {
                    MeshChannelCategory ch = (MeshChannelCategory) o;
                    Log.i(TAG,"Channel:"+ch.getCategory_name());

                }
                cd.countDown();
            }
        });
        request.setC(MeshChannelCategory.class);
        request.setId(MeshChannelCategory.TAG_ID);
        request.setIdValue(categories.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshChannelCategory.TAG_ID,categories.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshChannelCategory.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshChannelCategory)results.get(0)).getCategory_name());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(categories.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshChannelCategory)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------MeshConciergeCategory-----------------------------------
    @Test
    public void testMeshConciergeCategory() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshConciergeCategory> categories = new ArrayList<>();
        cd = new CountDownLatch(1);
        categories.addAll( MeshParser.parseConciergeCategories(MeshRawReader.read(R.raw.get_concierge_category)));
        final CountDownLatch cd1 = new CountDownLatch(categories.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<categories.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshConciergeCategory ch1 = categories.get(ctr);
                    MeshConciergeCategory ch2 = ((MeshConciergeCategory)o);
                    Log.i(TAG,"CH1:"+ch1.getCategory_name()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getCategory_name()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(categories.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),categories.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshConciergeCategory.class);
        cd.await();

        MeshRealmManager.insert(categories.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshConciergeCategory.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshConciergeCategory ch:categories)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();



        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshConciergeCategory.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results)
            {
                assertEquals(categories.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();

        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshConciergeCategory)
                {
                    MeshConciergeCategory ch = (MeshConciergeCategory) o;
                    ch.setCategory_name("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshConciergeCategory)
                {
                    MeshConciergeCategory ch = (MeshConciergeCategory) o;
                    Log.i(TAG,"Channel:"+ch.getCategory_name());

                }
                cd.countDown();
            }
        });
        request.setC(MeshConciergeCategory.class);
        request.setId(MeshConciergeCategory.TAG_ID);
        request.setIdValue(categories.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshConciergeCategory.TAG_ID,categories.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshConciergeCategory.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshConciergeCategory)results.get(0)).getCategory_name());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(categories.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshConciergeCategory)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------MeshConciergeRequestItem---------------------------------
    @Test
    public void testMeshConciergeRequestItem() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshConciergeRequestItem> items = new ArrayList<>();
        cd = new CountDownLatch(1);
        items.addAll( MeshParser.parseConciergeItems(MeshRawReader.read(R.raw.get_all_item_request)));
        final CountDownLatch cd1 = new CountDownLatch(items.size()-1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<items.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshConciergeRequestItem ch1 = items.get(ctr);
                    MeshConciergeRequestItem ch2 = ((MeshConciergeRequestItem)o);
                    Log.i(TAG,"CH1:"+ch1.getItem_name()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getItem_name()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(items.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),items.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshConciergeRequestItem.class);
        cd.await();

        MeshRealmManager.insert(items.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshConciergeRequestItem.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshConciergeRequestItem ch:items)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();



        cd = new CountDownLatch(1);

        MeshRealmManager.retrieve(MeshConciergeRequestItem.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(items.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshConciergeRequestItem)
                {
                    MeshConciergeRequestItem ch = (MeshConciergeRequestItem) o;
                    ch.setItem_name("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshConciergeRequestItem)
                {
                    MeshConciergeRequestItem ch = (MeshConciergeRequestItem) o;
                    Log.i(TAG,"Channel:"+ch.getItem_name());

                }
                cd.countDown();
            }
        });
        request.setC(MeshConciergeRequestItem.class);
        request.setId(MeshConciergeRequestItem.TAG_ID);
        request.setIdValue(items.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshConciergeRequestItem.TAG_ID,items.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshConciergeRequestItem.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshConciergeRequestItem)results.get(0)).getItem_name());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(items.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshConciergeRequestItem)o);
        }
        cd.await();

        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------MeshConciergeRequestService-------------------------------
    @Test
    public void testMeshConciergeRequestService() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshConciergeRequestService> items = new ArrayList<>();
        cd = new CountDownLatch(1);
        items.addAll( MeshParser.parseConciergeServices(MeshRawReader.read(R.raw.get_all_service_request)));
        final CountDownLatch cd1 = new CountDownLatch(items.size()-1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<items.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshConciergeRequestService ch1 = items.get(ctr);
                    MeshConciergeRequestService ch2 = ((MeshConciergeRequestService)o);
                    Log.i(TAG,"CH1:"+ch1.getItem_name()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getItem_name()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(items.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),items.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshConciergeRequestService.class);
        cd.await();

        MeshRealmManager.insert(items.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshConciergeRequestService.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshConciergeRequestService ch:items)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();


        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshConciergeRequestService.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                for(Object o:results)
                {
                    Log.i(TAG,((MeshConciergeRequestService)o).getItem_name()+" - "+((MeshConciergeRequestService)o).getId());
                }
                for(Object o:items)
                {
                    Log.i(TAG,((MeshConciergeRequestService)o).getItem_name()+" 2- "+((MeshConciergeRequestService)o).getId());
                }
                assertEquals(4,results.size());
                cd.countDown();
            }
            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();
        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshConciergeRequestService.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(4,results.size());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        });
        cd.await();

        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshConciergeRequestService)
                {
                    MeshConciergeRequestService ch = (MeshConciergeRequestService) o;
                    ch.setItem_name("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshConciergeRequestService)
                {
                    MeshConciergeRequestService ch = (MeshConciergeRequestService) o;
                    Log.i(TAG,"Channel:"+ch.getItem_name());

                }
                cd.countDown();
            }
        });
        request.setC(MeshConciergeRequestService.class);
        request.setId(MeshConciergeRequestService.TAG_ID);
        request.setIdValue(items.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshConciergeRequestService.TAG_ID,items.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshConciergeRequestService.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshConciergeRequestService)results.get(0)).getItem_name());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(items.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshConciergeRequestService)o);
        }
        cd.await();

        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------MeshFood-------------------------------------------
    @Test
    public void testMeshFood() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshFood> menu = new ArrayList<>();
        cd = new CountDownLatch(1);
        menu.addAll( MeshParser.parseFood(MeshRawReader.read(R.raw.get_all_f_and_b_item)));
        final CountDownLatch cd1 = new CountDownLatch(menu.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<menu.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshFood ch1 = menu.get(ctr);
                    MeshFood ch2 = ((MeshFood)o);
                    Log.i(TAG,"CH1:"+ch1.getItem_name()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getItem_name()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(menu.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),menu.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshFood.class);
        cd.await();

        MeshRealmManager.insert(menu.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshFood.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshFood ch:menu)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshFood.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(menu.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();

        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshFood)
                {
                    MeshFood ch = (MeshFood) o;
                    ch.setItem_name("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshFood)
                {
                    MeshFood ch = (MeshFood) o;
                    Log.i(TAG,"Channel:"+ch.getItem_name());

                }
                cd.countDown();
            }
        });
        request.setC(MeshFood.class);
        request.setId(MeshFood.TAG_ID);
        request.setIdValue(menu.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshFood.TAG_ID,menu.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshFood.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshFood)results.get(0)).getItem_name());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(menu.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshFood)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------MeshFoodCategory-------------------------------------------
    @Test
    public void testMeshFoodCategory() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshFoodCategory> menu = new ArrayList<>();
        cd = new CountDownLatch(1);
        menu.addAll( MeshParser.parseFoodCategory(MeshRawReader.read(R.raw.get_f_and_b_category)));
        final CountDownLatch cd1 = new CountDownLatch(menu.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<menu.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshFoodCategory ch1 = menu.get(ctr);
                    MeshFoodCategory ch2 = ((MeshFoodCategory)o);
                    Log.i(TAG,"CH1:"+ch1.getCategory_name()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getCategory_name()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(menu.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),menu.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshFoodCategory.class);
        cd.await();

        MeshRealmManager.insert(menu.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshFoodCategory.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshFoodCategory ch:menu)
        {
              objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();



        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshFoodCategory.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(menu.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();


        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshFoodCategory)
                {
                    MeshFoodCategory ch = (MeshFoodCategory) o;
                    ch.setCategory_name("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshFoodCategory)
                {
                    MeshFoodCategory ch = (MeshFoodCategory) o;
                    Log.i(TAG,"Channel:"+ch.getCategory_name());

                }
                cd.countDown();
            }
        });
        request.setC(MeshFoodCategory.class);
        request.setId(MeshFoodCategory.TAG_ID);
        request.setIdValue(menu.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshFoodCategory.TAG_ID,menu.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshFoodCategory.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshFoodCategory)results.get(0)).getCategory_name());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(menu.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshFoodCategory)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------MeshFacility----------------------------------------
    @Test
    public void testMeshFacility() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshFacility> facilities = new ArrayList<>();
        cd = new CountDownLatch(1);
        facilities.addAll( MeshParser.parseFacilities(MeshRawReader.read(R.raw.get_all_facilities)));
        final CountDownLatch cd1 = new CountDownLatch(facilities.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<facilities.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshFacility ch1 = facilities.get(ctr);
                    MeshFacility ch2 = ((MeshFacility)o);
                    Log.i(TAG,"CH1:"+ch1.getItem_name()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getItem_name()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(facilities.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),facilities.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshFacility.class);
        cd.await();

        MeshRealmManager.insert(facilities.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshFacility.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshFacility ch:facilities)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();


        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshFacility.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(facilities.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();


        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshFacility)
                {
                    MeshFacility ch = (MeshFacility) o;
                    ch.setItem_name("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshFacility)
                {
                    MeshFacility ch = (MeshFacility) o;
                    Log.i(TAG,"Channel:"+ch.getItem_name());

                }
                cd.countDown();
            }
        });
        request.setC(MeshFacility.class);
        request.setId(MeshFacility.TAG_ID);
        request.setIdValue(facilities.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshFacility.TAG_ID,facilities.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshFacility.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshFacility)results.get(0)).getItem_name());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(facilities.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshFacility)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------MeshFacilityCategory------------------------------------
    @Test
    public void testMeshFacilityCategory() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshFacilityCategory> categories = new ArrayList<>();
        cd = new CountDownLatch(1);
        categories.addAll( MeshParser.parseFacilityCategories(MeshRawReader.read(R.raw.get_facility_category)));
        final CountDownLatch cd1 = new CountDownLatch(categories.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<categories.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshFacilityCategory ch1 = categories.get(ctr);
                    MeshFacilityCategory ch2 = ((MeshFacilityCategory)o);
                    Log.i(TAG,"CH1:"+ch1.getCategory_name()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getCategory_name()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(categories.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),categories.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshFacilityCategory.class);
        cd.await();

        MeshRealmManager.insert(categories.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshFacilityCategory.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshFacilityCategory ch:categories)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();


        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshFacilityCategory.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(categories.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();;

        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshFacilityCategory)
                {
                    MeshFacilityCategory ch = (MeshFacilityCategory) o;
                    ch.setCategory_name("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshFacilityCategory)
                {
                    MeshFacilityCategory ch = (MeshFacilityCategory) o;
                    Log.i(TAG,"Channel:"+ch.getCategory_name());

                }
                cd.countDown();
            }
        });
        request.setC(MeshFacilityCategory.class);
        request.setId(MeshFacilityCategory.TAG_ID);
        request.setIdValue(categories.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshFacilityCategory.TAG_ID,categories.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshFacilityCategory.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshFacilityCategory)results.get(0)).getCategory_name());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(categories.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshFacilityCategory)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------MeshAirport-----------------------------------------
    @Test
    public void testMeshAirport() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshAirport> airports = new ArrayList<>();
        cd = new CountDownLatch(1);
        airports.addAll( MeshParser.parseAirports(MeshRawReader.read(R.raw.get_airport_name)));
        final CountDownLatch cd1 = new CountDownLatch(airports.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<airports.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshAirport ch1 = airports.get(ctr);
                    MeshAirport ch2 = ((MeshAirport)o);
                    Log.i(TAG,"CH1:"+ch1.getName()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getName()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(airports.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),airports.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshAirport.class);
        cd.await();

        MeshRealmManager.insert(airports.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshAirport.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshAirport ch:airports)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();



        MeshRealmManager.retrieve(MeshAirport.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(airports.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();
        cd = new CountDownLatch(1);

        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshAirport)
                {
                    MeshAirport ch = (MeshAirport) o;
                    ch.setName("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshAirport)
                {
                    MeshAirport ch = (MeshAirport) o;
                    Log.i(TAG,"Channel:"+ch.getName());

                }
                cd.countDown();
            }
        });
        request.setC(MeshAirport.class);
        request.setId(MeshAirport.TAG_ID);
        request.setIdValue(airports.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshAirport.TAG_ID,airports.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshAirport.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshAirport)results.get(0)).getName());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(airports.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshAirport)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------MeshArrivalFlight--------------------------------------
    @Test
    public void testArrivalFlight() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshArrivalFlight> flights = new ArrayList<>();
        cd = new CountDownLatch(1);
        flights.addAll( MeshParser.parseArrivalFlights(MeshRawReader.read(R.raw.get_arrival_flights)));
        final CountDownLatch cd1 = new CountDownLatch(flights.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<flights.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshArrivalFlight ch1 = flights.get(ctr);
                    MeshArrivalFlight ch2 = ((MeshArrivalFlight)o);
                    Log.i(TAG,"CH1:"+ch1.getFlight_number()+"("+ch1.getArrival_datetime()+")");
                    Log.i(TAG,"CH2:"+ch2.getFlight_number()+"("+ch2.getArrival_datetime()+")");
                    assertEquals(ch1.getFlight_number(),ch2.getFlight_number());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(flights.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),flights.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshArrivalFlight.class);
        cd.await();

        MeshRealmManager.insert(flights.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshArrivalFlight.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshArrivalFlight ch:flights)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();



        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshArrivalFlight.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(flights.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();

        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshArrivalFlight)
                {
                    MeshArrivalFlight ch = (MeshArrivalFlight) o;
                    ch.setCarrier("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshArrivalFlight)
                {
                    MeshArrivalFlight ch = (MeshArrivalFlight) o;
                    Log.i(TAG,"Channel:"+ch.getCarrier());

                }
                cd.countDown();
            }
        });
        request.setC(MeshArrivalFlight.class);
        request.setId(MeshArrivalFlight.TAG_FLIGHT_NUMBER);
        request.setIdValue(flights.get(0).getFlight_number());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshArrivalFlight.TAG_FLIGHT_NUMBER,flights.get(0).getFlight_number());
        vp.setString(true);
        MeshRealmManager.retrieve(MeshArrivalFlight.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshArrivalFlight)results.get(0)).getCarrier());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(flights.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshArrivalFlight)o);
        }
        cd.await();

        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------MeshDepartureFlights------------------------------------
    @Test
    public void testMeshDepartureFlights() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshDepartureFlight> departure = new ArrayList<>();
        cd = new CountDownLatch(1);
        departure.addAll( MeshParser.parseDepartureFlights(MeshRawReader.read(R.raw.get_departure_flights)));
        final CountDownLatch cd1 = new CountDownLatch(departure.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<departure.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshDepartureFlight ch1 = departure.get(ctr);
                    MeshDepartureFlight ch2 = ((MeshDepartureFlight)o);
                    Log.i(TAG,"CH1:"+ch1.getFlight_number()+"("+ch1.getCarrier()+")");
                    Log.i(TAG,"CH2:"+ch2.getFlight_number()+"("+ch2.getCarrier()+")");
                    assertEquals(ch1.getFlight_number(),ch2.getFlight_number());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(departure.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),departure.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshDepartureFlight.class);
        cd.await();

        MeshRealmManager.insert(departure.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshDepartureFlight.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshDepartureFlight ch:departure)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();



        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshDepartureFlight.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(departure.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();
        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshDepartureFlight)
                {
                    MeshDepartureFlight ch = (MeshDepartureFlight) o;
                    ch.setCarrier("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshDepartureFlight)
                {
                    MeshDepartureFlight ch = (MeshDepartureFlight) o;
                    Log.i(TAG,"Channel:"+ch.getCarrier());

                }
                cd.countDown();
            }
        });
        request.setC(MeshDepartureFlight.class);
        request.setId(MeshDepartureFlight.TAG_FLIGHT_NUMBER);
        request.setIdValue(departure.get(0).getFlight_number());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshDepartureFlight.TAG_FLIGHT_NUMBER,departure.get(0).getFlight_number());
        vp.setString(true);
        MeshRealmManager.retrieve(MeshDepartureFlight.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshDepartureFlight)results.get(0)).getCarrier());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(departure.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshDepartureFlight)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------MeshMessage-----------------------------------------
    @Test
    public void testMeshMessage() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshMessage> inbox = new ArrayList<>();
        cd = new CountDownLatch(1);
        inbox.addAll( MeshParser.parseMessage(MeshRawReader.read(R.raw.get_message)));
        final CountDownLatch cd1 = new CountDownLatch(inbox.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<inbox.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshMessage ch1 = inbox.get(ctr);
                    MeshMessage ch2 = ((MeshMessage)o);
                    Log.i(TAG,"CH1:"+ch1.getId()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getId()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(inbox.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),inbox.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshMessage.class);
        cd.await();

        MeshRealmManager.insert(inbox.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshMessage.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshMessage ch:inbox)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();



        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshMessage.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(inbox.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });

        cd.await();

        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshMessage)
                {
                    MeshMessage ch = (MeshMessage) o;
                    ch.setMessg_text("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshMessage)
                {
                    MeshMessage ch = (MeshMessage) o;
                    Log.i(TAG,"Channel:"+ch.getMessg_text());

                }
                cd.countDown();
            }
        });
        request.setC(MeshMessage.class);
        request.setId(MeshMessage.TAG_ID);
        request.setIdValue(inbox.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshMessage.TAG_ID,inbox.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshMessage.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshMessage)results.get(0)).getMessg_text());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(inbox.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshMessage)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------MeshRoomType-----------------------------------------
    @Test
    public void testMeshRoomType() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshRoomType> types = new ArrayList<>();
        cd = new CountDownLatch(1);
        types.addAll( MeshParser.parseRoomType(MeshRawReader.read(R.raw.get_all_room_type)));
        final CountDownLatch cd1 = new CountDownLatch(types.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<types.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshRoomType ch1 = types.get(ctr);
                    MeshRoomType ch2 = ((MeshRoomType)o);
                    Log.i(TAG,"CH1:"+ch1.getCategory_name()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getCategory_name()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(types.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),types.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshRoomType.class);
        cd.await();

        MeshRealmManager.insert(types.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshRoomType.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshRoomType ch:types)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();



        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshRoomType.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(types.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();


        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshRoomType)
                {
                    MeshRoomType ch = (MeshRoomType) o;
                    ch.setCategory_name("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshRoomType)
                {
                    MeshRoomType ch = (MeshRoomType) o;
                    Log.i(TAG,"Channel:"+ch.getCategory_name());

                }
                cd.countDown();
            }
        });
        request.setC(MeshRoomType.class);
        request.setId(MeshRoomType.TAG_ID);
        request.setIdValue(types.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshRoomType.TAG_ID,types.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshRoomType.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshRoomType)results.get(0)).getCategory_name());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(types.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshRoomType)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------MeshSHoppingItem---------------------------------------
    @Test
    public void MeshShoppingItem() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshShoppingItem> items = new ArrayList<>();
        cd = new CountDownLatch(1);
        items.addAll( MeshParser.parseShoppingItem(MeshRawReader.read(R.raw.get_all_shopping_item)));
        final CountDownLatch cd1 = new CountDownLatch(items.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<items.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshShoppingItem ch1 = items.get(ctr);
                    MeshShoppingItem ch2 = ((MeshShoppingItem)o);
                    Log.i(TAG,"CH1:"+ch1.getItem_name()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getItem_name()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(items.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),items.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshShoppingItem.class);
        cd.await();

        MeshRealmManager.insert(items.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshShoppingItem.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshShoppingItem ch:items)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();


        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshShoppingItem.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(items.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();


        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshShoppingItem)
                {
                    MeshShoppingItem ch = (MeshShoppingItem) o;
                    ch.setItem_name("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshShoppingItem)
                {
                    MeshShoppingItem ch = (MeshShoppingItem) o;
                    Log.i(TAG,"Channel:"+ch.getItem_name());

                }
                cd.countDown();
            }
        });
        request.setC(MeshShoppingItem.class);
        request.setId(MeshShoppingItem.TAG_ID);
        request.setIdValue(items.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshShoppingItem.TAG_ID,items.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshShoppingItem.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshShoppingItem)results.get(0)).getItem_name());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(items.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshShoppingItem)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------MeshShoppingCategory------------------------------------
    @Test
    public void testMeshShoppingCategory() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshShoppingCategory> ca = new ArrayList<>();
        cd = new CountDownLatch(1);
        ca.addAll( MeshParser.parseShoppingCategory(MeshRawReader.read(R.raw.get_shopping_category)));
        final CountDownLatch cd1 = new CountDownLatch(ca.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<ca.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshShoppingCategory ch1 = ca.get(ctr);
                    MeshShoppingCategory ch2 = ((MeshShoppingCategory)o);
                    Log.i(TAG,"CH1:"+ch1.getCategory_name()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getCategory_name()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(ca.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),ca.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshShoppingCategory.class);
        cd.await();

        MeshRealmManager.insert(ca.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshShoppingCategory.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshShoppingCategory ch:ca)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();


        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshShoppingCategory.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(ca.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();


        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshShoppingCategory)
                {
                    MeshShoppingCategory ch = (MeshShoppingCategory) o;
                    ch.setCategory_name("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshShoppingCategory)
                {
                    MeshShoppingCategory ch = (MeshShoppingCategory) o;
                    Log.i(TAG,"Channel:"+ch.getCategory_name());

                }
                cd.countDown();
            }
        });
        request.setC(MeshShoppingCategory.class);
        request.setId(MeshShoppingCategory.TAG_ID);
        request.setIdValue(ca.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshShoppingCategory.TAG_ID,ca.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshShoppingCategory.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshShoppingCategory)results.get(0)).getCategory_name());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(ca.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshShoppingCategory)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------MeshStream-----------------------------------------
    @Test
    public void testMeshStream() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshStream> streams = new ArrayList<>();
        cd = new CountDownLatch(1);
        streams.addAll( MeshParser.parseStreams(MeshRawReader.read(R.raw.get_live_stream_series)));
        final CountDownLatch cd1 = new CountDownLatch(streams.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<streams.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshStream ch1 = streams.get(ctr);
                    MeshStream ch2 = ((MeshStream)o);
                    Log.i(TAG,"CH1:"+ch1.getTitle()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getTitle()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(streams.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),streams.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshStream.class);
        cd.await();

        MeshRealmManager.insert(streams.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshStream.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshStream ch:streams)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();


        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshStream.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(streams.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.removeListener(l1);
        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshStream)
                {
                    MeshStream ch = (MeshStream) o;
                    ch.setTitle("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshStream)
                {
                    MeshStream ch = (MeshStream) o;
                    Log.i(TAG,"Channel:"+ch.getTitle());

                }
                cd.countDown();
            }
        });
        request.setC(MeshStream.class);
        request.setId(MeshStream.TAG_ID);
        request.setIdValue(streams.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshStream.TAG_ID,streams.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshStream.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshStream)results.get(0)).getTitle());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(streams.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshStream)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------MeshStreamCategory---------------------------------------
    @Test
    public void testMeshStreamCategory() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshStreamCategory> ca = new ArrayList<>();
        cd = new CountDownLatch(1);
        ca.addAll( MeshParser.parseStreamCategory(MeshRawReader.read(R.raw.get_live_stream_category)));
        final CountDownLatch cd1 = new CountDownLatch(ca.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<ca.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshStreamCategory ch1 = ca.get(ctr);
                    MeshStreamCategory ch2 = ((MeshStreamCategory)o);
                    Log.i(TAG,"CH1:"+ch1.getCategory_name()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getCategory_name()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(ca.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),ca.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshStreamCategory.class);
        cd.await();

        MeshRealmManager.insert(ca.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshStreamCategory.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshStreamCategory ch:ca)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();



        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshStreamCategory.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(ca.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();


        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshStreamCategory)
                {
                    MeshStreamCategory ch = (MeshStreamCategory) o;
                    ch.setCategory_name("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshStreamCategory)
                {
                    MeshStreamCategory ch = (MeshStreamCategory) o;
                    Log.i(TAG,"Channel:"+ch.getCategory_name());

                }
                cd.countDown();
            }
        });
        request.setC(MeshStreamCategory.class);
        request.setId(MeshStreamCategory.TAG_ID);
        request.setIdValue(ca.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshStreamCategory.TAG_ID,ca.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshStreamCategory.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshStreamCategory)results.get(0)).getCategory_name());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(ca.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshStreamCategory)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------MeshVC---------------------------------------------
    @Test
    public void testMeshVC() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshVC> vcs = new ArrayList<>();
        cd = new CountDownLatch(1);
        vcs.addAll( MeshParser.parseVC(MeshRawReader.read(R.raw.get_all_establishments_v3)));
        final CountDownLatch cd1 = new CountDownLatch(vcs.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<vcs.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshVC ch1 = vcs.get(ctr);
                    MeshVC ch2 = ((MeshVC)o);
                    Log.i(TAG,"CH1:"+ch1.getEstablishment_name()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getEstablishment_name()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(vcs.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),vcs.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshVC.class);
        cd.await();

        MeshRealmManager.insert(vcs.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshVC.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshVC ch:vcs)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();



        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshVC.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(vcs.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();


        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshVC)
                {
                    MeshVC ch = (MeshVC) o;
                    ch.setEstablishment_name("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshVC)
                {
                    MeshVC ch = (MeshVC) o;
                    Log.i(TAG,"Channel:"+ch.getEstablishment_name());

                }
                cd.countDown();
            }
        });
        request.setC(MeshVC.class);
        request.setId(MeshVC.TAG_ID);
        request.setIdValue(vcs.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshVC.TAG_ID,vcs.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshVC.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshVC)results.get(0)).getEstablishment_name());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(vcs.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshVC)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------MeshVCCategory-----------------------------------------
    @Test
    public void testMeshVCCategory() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshVCCategory> ca = new ArrayList<>();
        cd = new CountDownLatch(1);
        ca.addAll( MeshParser.parseVCCategory(MeshRawReader.read(R.raw.get_maps_categories)));
        final CountDownLatch cd1 = new CountDownLatch(ca.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<ca.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshVCCategory ch1 = ca.get(ctr);
                    MeshVCCategory ch2 = ((MeshVCCategory)o);
                    Log.i(TAG,"CH1:"+ch1.getName()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getName()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(ca.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),ca.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshVCCategory.class);
        cd.await();

        MeshRealmManager.insert(ca.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshVCCategory.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshVCCategory ch:ca)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshVCCategory.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(ca.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();


        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshVCCategory)
                {
                    MeshVCCategory ch = (MeshVCCategory) o;
                    ch.setDescription("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshVCCategory)
                {
                    MeshVCCategory ch = (MeshVCCategory) o;
                    Log.i(TAG,"Channel:"+ch.getName());

                }
                cd.countDown();
            }
        });
        request.setC(MeshVCCategory.class);
        request.setId(MeshVCCategory.TAG_ID);
        request.setIdValue(ca.get(0).getId());


        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshVCCategory.TAG_ID,ca.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshVCCategory.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshVCCategory)results.get(0)).getDescription());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(ca.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshVCCategory)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------MeshVOD-------------------------------------------
    @Test
    public void testVOD() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshVOD> vods = new ArrayList<>();
        cd = new CountDownLatch(1);
        vods.addAll( MeshParser.parseVOD(MeshRawReader.read(R.raw.get_vod)));
        final CountDownLatch cd1 = new CountDownLatch(vods.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<vods.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshVOD ch1 = vods.get(ctr);
                    MeshVOD ch2 = ((MeshVOD)o);
                    Log.i(TAG,"CH1:"+ch1.getTitle()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getTitle()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(vods.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),vods.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshVOD.class);
        cd.await();

        MeshRealmManager.insert(vods.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshVOD.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshVOD ch:vods)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();



        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshVOD.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(12,results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();


        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshVOD)
                {
                    MeshVOD ch = (MeshVOD) o;
                    ch.setTitle("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshVOD)
                {
                    MeshVOD ch = (MeshVOD) o;
                    Log.i(TAG,"Channel:"+ch.getTitle());

                }
                cd.countDown();
            }
        });
        request.setC(MeshVOD.class);
        request.setId(MeshVOD.TAG_ID);
        request.setIdValue(vods.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshVOD.TAG_ID,vods.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshVOD.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshVOD)results.get(0)).getTitle());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(vods.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshVOD)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------

    //-----------------------------------------------MeshGenre----------------------------------------
    @Test
    public void testMeshGenre() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshGenre> genres = new ArrayList<>();
        cd = new CountDownLatch(1);
        genres.addAll( MeshParser.parseGenre(MeshRawReader.read(R.raw.get_genres)));
        final CountDownLatch cd1 = new CountDownLatch(genres.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<genres.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshGenre ch1 = genres.get(ctr);
                    MeshGenre ch2 = ((MeshGenre)o);
                    Log.i(TAG,"CH1:"+ch1.getMeshLabel()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getMeshLabel()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(genres.get(ctr));
                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),genres.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshGenre.class);
        cd.await();

        MeshRealmManager.insert(genres.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshGenre.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshGenre ch:genres)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshGenre.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(genres.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();
        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshGenre)
                {
                    MeshGenre ch = (MeshGenre) o;
                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshGenre)
                {
                    MeshGenre ch = (MeshGenre) o;
                    Log.i(TAG,"Channel:"+ch.getGenre());

                }
                cd.countDown();
            }
        });
        request.setC(MeshGenre.class);
        request.setId(MeshGenre.TAG_ID);
        request.setIdValue(genres.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshGenre.TAG_ID,genres.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshGenre.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(genres.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshGenre)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------

    //-----------------------------------------MeshWeatherV2----------------------------------------
    @Test
    public void testWeatherV2() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshWeatherV2> wea = new ArrayList<>();
        cd = new CountDownLatch(1);
        wea.addAll( MeshParser.parseWeatherV2(MeshRawReader.read(R.raw.all_weather)));
        final CountDownLatch cd1 = new CountDownLatch(wea.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<wea.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshWeatherV2 ch1 = wea.get(ctr);
                    MeshWeatherV2 ch2 = ((MeshWeatherV2)o);
                    Log.i(TAG,"CH1:"+ch1.getCountry()+"("+ch1.getId()+")");
                    Log.i(TAG,"CH2:"+ch2.getCountry()+"("+ch2.getId()+")");
                    assertEquals(ch1.getId(),ch2.getId());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(wea.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),wea.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshWeatherV2.class);
        cd.await();

        MeshRealmManager.insert(wea.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshWeatherV2.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshWeatherV2 ch:wea)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();


        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshWeatherV2.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(wea.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();

        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshWeatherV2)
                {
                    MeshWeatherV2 ch = (MeshWeatherV2) o;
                    ch.setDescription("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshWeatherV2)
                {
                    MeshWeatherV2 ch = (MeshWeatherV2) o;
                    Log.i(TAG,"Channel:"+ch.getDescription());

                }
                cd.countDown();
            }
        });
        request.setC(MeshWeatherV2.class);
        request.setId(MeshWeatherV2.TAG_ID);
        request.setIdValue(wea.get(0).getId());

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshWeatherV2.TAG_ID,wea.get(0).getId());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshWeatherV2.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshWeatherV2)results.get(0)).getDescription());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }

            @Override
            public void onDelete(Class c) {
                cd.countDown();
            }

            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(wea.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshWeatherV2)o);
        }
        cd.await();




        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------MeshForecast-----------------------------------------
    @Test
    public void testForecast() throws Exception
    {
        Log.i(TAG,"============================================================================");
        final ArrayList<MeshWeatherForecast> forecasts = new ArrayList<>();
        cd = new CountDownLatch(1);
        forecasts.addAll( MeshParser.parseForecast(MeshRawReader.read(R.raw.weather_forecast)));
        final CountDownLatch cd1 = new CountDownLatch(forecasts.size()-1);
        final CountDownLatch cd2 = new CountDownLatch(1);
        MeshRealmManager.clearListener();
        MeshRealmEventListener l1= new MeshRealmEventListener()
        {
            int ctr = 0;

            @Override
            public void onCreate(Object o)
            {
                if(ctr<forecasts.size()-1)
                {
                    Log.i(TAG,"Index:"+ctr);
                    Log.i(TAG,"CD:"+cd1.getCount());
                    MeshWeatherForecast ch1 = forecasts.get(ctr);
                    MeshWeatherForecast ch2 = ((MeshWeatherForecast)o);
                    Log.i(TAG,"CH1:"+ch1.getCountry()+"("+ch1.getCountry()+")");
                    Log.i(TAG,"CH2:"+ch2.getCountry()+"("+ch2.getCountry()+")");
                    assertEquals(ch1.getCountry(),ch2.getCountry());
                    ctr++;
                    cd1.countDown();
                    MeshRealmManager.insert(forecasts.get(ctr));

                }
            }

            @Override
            public void onCreateBulk(ArrayList<Object> os)
            {
                assertEquals(os.size(),forecasts.size());
                cd.countDown();
            }

            @Override
            public void onDelete(Class c)
            {
                Log.i(TAG,"CD:"+cd.getCount());
                cd.countDown();
            }

            @Override
            public void onClear(Class c)
            {
                Log.i(TAG,"Cleared:"+c.getSimpleName());
                cd.countDown();
            }
        };
        Log.i(TAG,"Adding Listener");
        MeshRealmManager.addListener(l1);
        assertTrue(MeshRealmManager.getListeners().contains(l1));
        Log.i(TAG,"Listener Added");

        MeshRealmManager.clear(MeshWeatherForecast.class);
        cd.await();

        MeshRealmManager.insert(forecasts.get(0));
        cd1.await();

        cd = new CountDownLatch(1);
        MeshRealmManager.clear(MeshWeatherForecast.class);
        cd.await();

        ArrayList<Object> objs = new ArrayList<>();
        for(MeshWeatherForecast ch:forecasts)
        {
            objs.add(ch);
        }

        cd = new CountDownLatch(1);
        MeshRealmManager.insertBulk(objs);
        cd.await();



        cd = new CountDownLatch(1);
        MeshRealmManager.retrieve(MeshWeatherForecast.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(forecasts.size(),results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }
        });
        cd.await();

        cd = new CountDownLatch(1);

        MeshRealmManager.removeListener(l1);

        final MeshUpdateRequest request = new MeshUpdateRequest(new MeshUpdateRequestListener() {
            @Override
            public void setUpdates(Object o) {
                if(o instanceof MeshWeatherForecast)
                {
                    MeshWeatherForecast ch = (MeshWeatherForecast) o;
                    ch.setCity("ABS-CBN");

                }
            }

            @Override
            public void updateDone(Object o) {
                if(o instanceof MeshWeatherForecast)
                {
                    MeshWeatherForecast ch = (MeshWeatherForecast) o;
                    Log.i(TAG,"Channel:"+ch.getCountry());

                }
                cd.countDown();
            }
        });
        request.setC(MeshWeatherForecast.class);
        request.setId(MeshWeatherForecast.TAG_CITY);
        request.setIdValue("Manila");

        MeshRealmManager.update(request);
        cd.await();
        cd = new CountDownLatch(1);


        MeshValuePair vp = new MeshValuePair(MeshWeatherForecast.TAG_CITY,"ABS-CBN");
        vp.setString(true);
        MeshRealmManager.retrieve(MeshWeatherForecast.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                assertEquals(1,results.size());
                assertEquals("ABS-CBN",((MeshWeatherForecast)results.get(0)).getCity());
                Log.i(TAG,"RET SIZE:"+results.size());
                cd.countDown();
            }

            @Override
            public void onFailed(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onEmpty(Class c, String message) {
                 //assertNotNull(message,null);
            }

            @Override
            public void onCleared(Class c) {

            }

        },vp);
        cd.await();
        MeshRealmManager.removeListener(l1);

        MeshRealmEventListener l2 = new MeshRealmEventListener() {
            @Override
            public void onCreate(Object o) {

            }

            @Override
            public void onCreateBulk(ArrayList<Object> os) {

            }
            @Override
            public void onDelete(Class c)
            {
                cd.countDown();
            }
            @Override
            public void onClear(Class c) {

            }
        };
        MeshRealmManager.addListener(l2);
        cd = new CountDownLatch(forecasts.size()-1);
        for(Object o:objs)
        {
            Log.i(TAG,"CD z:"+cd.getCount());
            MeshRealmManager.delete((MeshWeatherForecast)o);
        }
        cd.await();

        Log.i(TAG,"============================================================================");

    }
    //----------------------------------------------------------------------------------------------

    //==============================================================================================




}