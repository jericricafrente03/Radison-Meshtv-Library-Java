package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.ResourceManager.MeshResourceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Query.MeshValuePair;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.Control.AttachSignageFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshLayoutV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaZone;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaZoneAssignment;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshPendingSignage;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshSignageV2;

import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class MeshSignageActivity extends AppCompatActivity
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    public static final String TAG              = MeshSignageActivity.class.getSimpleName();
    public static final String TAG_SIGNAGE_ID   = "id";
    public static final String TAG_LAYOUT_ID    = "layout_id";
    public static final String TAG_BACKGROUND   = "background";
    public static final String TAG_ORIENTATION   = "orientation";
    public static final String SIGNAGE_CLOSE    = "close";
    public static final String SIGNAGE_PORTRAIT    = "portrait";
    public static final String SIGNAGE_LANDSCAPE    = "landscape";
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Instance-------------------------------------------
    private int id = 0;
    private int ctr = 0;
    private int layout_id = 0;
    private int orientation = 0;
    private String background = "";
    private ArrayList<MeshMediaZoneAssignment> zoneAssignments;
    private BroadcastReceiver receiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            finish();
        }
    };
    private MeshLayoutV2 layoutV2;
    private ArrayList<MeshPendingSignage> pendingSignage;
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------View--------------------------------------------
    private ImageView iv_bg;
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Receiver------------------------------------------
    BroadcastReceiver portrait = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        }
    };
    BroadcastReceiver landscape = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    };
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Static===========================================
    public static void launch(Activity activity,Class c, MeshSignageV2 signageV2)
    {
        Log.i(TAG,"============================================================================");
        Log.i(TAG,"Launching from Activity");
        Log.i(TAG,"Launching from Activity:"+c.getSimpleName());
        Intent i = new Intent(activity,c);
        i.putExtra(TAG_SIGNAGE_ID,signageV2.getId());
        Log.i(TAG,"ID:"+signageV2.getId());
        i.putExtra(TAG_ORIENTATION,signageV2.getOrientation());
        Log.i(TAG,"ORIENTATION:"+signageV2.getOrientation());
        i.putExtra(TAG_LAYOUT_ID,signageV2.getLayout_id());
        Log.i(TAG,"LAYOUT ID:"+signageV2.getLayout_id());
        i.putExtra(TAG_BACKGROUND,signageV2.getBackground());
        Log.i(TAG,"Background:"+signageV2.getBackground());
        Log.i(TAG,"Activity Launched");
        Log.i(TAG,"============================================================================");
        activity.startActivity(i);
    }
    public static void launch(Application application,Class c, MeshSignageV2 signageV2)
    {
        Log.i(TAG,"============================================================================");
        Log.i(TAG,"Launching from Application");
        Log.i(TAG,"Launching from Application:"+c.getSimpleName());
        Intent i = new Intent(application,c);
        i.putExtra(TAG_SIGNAGE_ID,signageV2.getId());
        Log.i(TAG,"ID:"+signageV2.getId());
        i.putExtra(TAG_ORIENTATION,signageV2.getOrientation());
        Log.i(TAG,"ORIENTATION:"+signageV2.getOrientation());
        i.putExtra(TAG_LAYOUT_ID,signageV2.getLayout_id());
        Log.i(TAG,"LAYOUT ID:"+signageV2.getLayout_id());
        i.putExtra(TAG_BACKGROUND,signageV2.getBackground());
        Log.i(TAG,"Background:"+signageV2.getBackground());
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Log.i(TAG,"Activity Launched");
        Log.i(TAG,"============================================================================");
        application.startActivity(i);
    }
    //==============================================================================================
    //===========================================LifeCycle==========================================
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        pendingSignage = new ArrayList<>();
        Log.i(TAG, "Creating Signage");
        id = getIntent().getIntExtra(TAG_SIGNAGE_ID, -1);
        Log.i(TAG, "ID:" + id);
        orientation = getIntent().getIntExtra(TAG_ORIENTATION, -1);
        Log.i(TAG, "ORIENTATION:" + orientation);
        layout_id = getLayout_id(getIntent().getIntExtra(TAG_LAYOUT_ID, 1));
        Log.i(TAG, "LAYOUT ID:" + layout_id);
        background = getIntent().getStringExtra(TAG_BACKGROUND);
        Log.i(TAG, "BACKGROUND:" + background);
        if (layout_id > -1)
        {
            setContentView(layout_id);
            Log.i(TAG,"LAYOUT FOUND");
        }
        else
        {
            Log.i(TAG,"LAYOUT NOT FOUND");
        }
        MeshValuePair vp = new MeshValuePair(MeshLayoutV2.TAG_ID,getIntent().getIntExtra(TAG_LAYOUT_ID,1));
        Log.i(TAG,"Searching for:"+vp.getFieldName()+"@"+vp.getValue());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshLayoutV2.class, new MeshRealmListener()
        {
            @Override
            public void onRetrieved(Class aClass, ArrayList<Object> arrayList)
            {
                layoutV2 = (MeshLayoutV2)arrayList.get(0);
                Log.i(TAG,"Zones:"+layoutV2.getZones());
                if(layoutV2.getZones()>0)
                {
                    Log.i(TAG,"Zones Found:"+layoutV2.getZones());
                    ctr = 0;
                    loadZones();
                }
                else
                {
                    Log.i(TAG,"Zones Not Found");
                    onNoZoneFound();
                }
            }
            @Override
            public void onFailed(Class aClass, String s)
            {
                Log.i(TAG,"Layout Failed");
                onNoLayoutMatch();
            }

            @Override
            public void onEmpty(Class aClass, String s)
            {
                Log.i(TAG,"Layout Not Found");
                onNoLayoutMatch();
            }

            @Override
            public void onCleared(Class aClass)
            {
                Log.i(TAG,"Layout Cleared");
            }
        },vp);

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(portrait,new IntentFilter(SIGNAGE_PORTRAIT));
        registerReceiver(landscape,new IntentFilter(SIGNAGE_LANDSCAPE));
        registerReceiver(receiver,new IntentFilter(SIGNAGE_CLOSE));
        try
        {
            iv_bg = (ImageView) findViewById(R.id.iv_bg);
            if(iv_bg!=null)
            {
                MeshResourceManager.displayLiveImageFor(this,iv_bg,background);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        unregisterReceiver(receiver);
        unregisterReceiver(portrait);
        unregisterReceiver(landscape);
    }
    //==============================================================================================
    //============================================Event=============================================
    @Override
    public void onBackPressed()
    {

    }
    //==============================================================================================
    //============================================Method============================================
    //--------------------------------------------Action--------------------------------------------
    private void loadZones()
    {
        MeshValuePair vp = new MeshValuePair(MeshMediaZoneAssignment.TAG_LAYOUT_ID,layoutV2.getId());
        MeshValuePair vp2 = new MeshValuePair(MeshMediaZoneAssignment.TAG_SIGNAGE_ID,id);
        Log.i(TAG, "Loading Zones:" + vp.getFieldName()+"@"+vp.getValue());
        Log.i(TAG, "Loading Zones:" + vp2.getFieldName()+"@"+vp2.getValue());
        MeshRealmManager.retrieve(MeshMediaZoneAssignment.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class aClass, ArrayList<Object> arrayList)
            {
                if(arrayList.size()>0)
                {
                    zoneAssignments = new ArrayList<>();
                    for(Object o:arrayList)
                    {
                        zoneAssignments.add((MeshMediaZoneAssignment) o);
                    }
                    Log.i(TAG, "Loading Zones:"+zoneAssignments.size());
                    attachAllSignageFragments();
                }
                else
                {
                    Log.i(TAG, "Loading Zones: RETRIEVED EMPTY");
                }
            }

            @Override
            public void onFailed(Class aClass, String s)
            {
            }

            @Override
            public void onEmpty(Class aClass, String s)
            {
                Log.i(TAG, "Loading Zones: EMPTY");
            }

            @Override
            public void onCleared(Class aClass)
            {
                Log.i(TAG, "Loading Zones: CLEAREAD");
            }
        },vp,vp2);
    }
    private void loadMediaZOnes()
    {
        MeshValuePair vp = new MeshValuePair(MeshMediaZone.TAG_ZONE_ID,zoneAssignments.get(ctr).getId());

        MeshRealmManager.retrieve(MeshMediaZone.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class aClass, ArrayList<Object> arrayList)
            {
                ctr++;
                if(ctr<zoneAssignments.size())
                {
                    loadZones();
                }
            }

            @Override
            public void onFailed(Class aClass, String s) {
                ctr++;
                if(ctr<zoneAssignments.size())
                {
                    loadZones();
                }
            }

            @Override
            public void onEmpty(Class aClass, String s) {
                ctr++;
                if(ctr<zoneAssignments.size())
                {
                    loadZones();
                }
            }

            @Override
            public void onCleared(Class aClass) {

            }
        },vp);

    }
    public void onNoZoneFound()
    {

    }
    public void onNoLayoutMatch()
    {

    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Layout--------------------------------------------
    private int getLayout_id(int layout_id_code)
    {
        switch (layout_id_code)
        {
            case 1:
                Log.i(TAG,"Using Layout 1");
                return R.layout.digital_signage_template1_layout;
            case 2:
                Log.i(TAG,"Using Layout 2");
                return R.layout.digital_signage_template2_layout;
            case 3:
                Log.i(TAG,"Using Layout 3");
                return R.layout.digital_signage_template3_layout;
            case 4:
                Log.i(TAG,"Using Layout 4");
                return R.layout.digital_signage_template4_layout;
            case 5:
                Log.i(TAG,"Using Layout 5");
                return R.layout.digital_signage_template5_layout;
            case 6:
                Log.i(TAG,"Using Layout 6");
                return R.layout.digital_signage_template6_layout;
            case 7:
                Log.i(TAG,"Using Layout 7");
                return R.layout.digital_signage_template7_layout;
            case 8:
                Log.i(TAG,"Using Layout 8");
                return R.layout.digital_signage_template8_layout;
            case 9:
                Log.i(TAG,"Using Layout 9");
                return R.layout.digital_signage_template9_layout;

            case 10:
                Log.i(TAG,"Using Layout 10");
                return R.layout.digital_signage_template10_layout;

            case 11:
                Log.i(TAG,"Using Layout 11");
                return R.layout.digital_signage_template11_layout;
            case 12:
                Log.i(TAG,"Using Layout 12");
                return R.layout.digital_signage_template12_layout;
            case 36:
                Log.i(TAG,"Using Layout 14");
                return R.layout.digital_signage_template14_layout;
            case 37:
                Log.i(TAG,"Using Layout 15");
                return R.layout.digital_signage_template15_layout;
            case 38:
                Log.i(TAG,"Using Layout 16");
                return R.layout.digital_signage_template16_layout;
            case 43:
                Log.i(TAG,"Using Layout 17");
                return R.layout.digital_signage_template13_layout;
            case 46:
                Log.i(TAG,"Using Layout 18");
                return R.layout.digital_signage_template18_layout;
            case 47:
                Log.i(TAG,"Using Layout 19");
                return R.layout.digital_signage_template19_layout;
        }
        Log.i(TAG,"Using Default Layout");
        return R.layout.digital_signage_template1_layout;
    }
    private void attachAllSignageFragments()
    {

        Log.i(TAG, "Attaching Signage Fragments");
        for(Method m:getClass().getMethods())
        {
            AttachSignageFragment asf = m.getAnnotation(AttachSignageFragment.class);
            if(asf!=null)
            {
                Log.i(TAG, "------------------------------------------------------------------");
                Log.i(TAG, "Attaching Signage Fragments");
                MeshMediaZoneAssignment assignment = null;
                for(MeshMediaZoneAssignment a:zoneAssignments)
                {
                    if(a.getZone()==asf.zone())
                    {
                        assignment =a;
                        Log.i(TAG, "Assignment Found");
                        break;
                    }
                }
                if(assignment!=null)
                {
                    Fragment f = null;
                    try
                    {

                        f = (Fragment) m.invoke(this,assignment,getIntent().getIntExtra(TAG_LAYOUT_ID,1));
                        if(f!=null)
                        {
                            Fragment fExisting = getSupportFragmentManager().findFragmentById(getZoneID(assignment.getZone()));
                            if(fExisting!=null)
                            {
                                getSupportFragmentManager().beginTransaction().remove(fExisting).commit();
                            }
                            getSupportFragmentManager().beginTransaction().add(getZoneID(assignment.getZone()),f,"ZONE_"+assignment.getZone()).commit();
                            Log.i(TAG, "Fragment Found");
                        }
                        else
                        {
                            Log.i(TAG, "Fragment not Found");
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }



                }
                else
                {
                    Log.i(TAG, "Assignment Not Found");
                    //no zone was assigned to this fragment

                }

                Log.i(TAG, "------------------------------------------------------------------");
            }
            else
            {
                Log.i(TAG, "NON ASF");
            }
        }


    }
    public int getZoneID(int zone)
    {
        switch (zone)
        {
            case 1:
                return R.id.ll_zone1;
            case 2:
                return R.id.ll_zone2;
            case 3:
                return R.id.ll_zone3;
            case 4:
                return R.id.ll_zone4;
            case 5:
                return R.id.ll_zone5;
            default:
                return R.id.ll_zone1;
        }
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Getter--------------------------------------------
    public int getId() {
        return id;
    }
    public int getOrientation() {
        return orientation;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Abstract===========================================
    public abstract void attachSpecialFragment(MeshMediaZoneAssignment assignment,MeshMediaV2 media);
    //==============================================================================================
}
