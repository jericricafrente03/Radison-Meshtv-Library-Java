package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Manager.MeshAnnotationManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Activity.ActivitySetting;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.Layout;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.MeshTVAirmediaListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.MeshTVPIPListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.MeshTVPackageListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshNotificationListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshSubscriptionUpdateListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshSubscriptionListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Broadcast.MeshTVBroadcaster;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

import com.ph.bittelasia.meshtv.tv.mtvlib.R;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Base class of MeshTV Activities.
 * <br>
 * <br>Requires:
 * <br>1. {@link Layout Layout}
 * <br>2. {@link ActivitySetting ActivitySetting}
 * <br>
 * <br>Supports:
 * <br>1. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Init Init}
 * <br>2. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Activity.AttachFragment AttachFragment}
 * <br>3. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Terminate Terminate}
 * <br>4. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimedMethod}
 * <br>5. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Widget.BindWidget BindWidget}
 * <br>
 * <br>Listens to:
 * <br>1. {@link MeshTVPIPListener MeshTVPIPListener}
 * <br>2. {@link MeshTVAirmediaListener MeshTVAirmediaListener}
 * <br>3. {@link MeshTVPackageListener MeshTVPackageListener}
 * <br>
 */
abstract class BittelActivity extends AppCompatActivity
{
    //==========================================Variable============================================
    //------------------------------------------Constant--------------------------------------------
    public static final String TAG = "Mars-"+BittelActivity.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Annotation------------------------------------------
    /***
     * {@link Layout Layout} sets the Resource ID of the layout to be inflated for the Activity
     */
    private Layout layout;
    /**
     * {@link ActivitySetting ActivitySetting} used to configure the {@link BittelActivity BittelActivity}:
     * <br>1. Set if the Activity is in fullscreen or not (DEFAULT:true)
     * <br>2. Set if the Activity could request dangerouse permissions from the user (Marshmallow and up)
     * <br>3. Flags an Activity if it can play videos. Opening the activity will close PIP if opened
     */
    private ActivitySetting setting;
    /**
     * List of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Init Init}
     * annotated methods to be invoked during the onCreate stage of the Activity.
     */
    private ArrayList<Method> initMethods;
    /**
     * List of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Activity.AttachFragment AttachFragment} annotated methods to be invoked during onCreate which attaches Fragments to the Activity.
     */
    private ArrayList<Method> attachFragments;
    /**
     * List of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Terminate Terminate}
     * annotated methods to be invoked during the onDestroy stage of the Activity.
     */
    private ArrayList<Method> termMethods;
    /**
     * List of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimedMethod}
     * annotated methods to be invoked periodically depending on the delay set. Starts at onResume and stops at onPause.
     */
    private ArrayList<Method> timedMethods;

    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Instance-------------------------------------------
    /**
     * Handler that invokes the timed methods
     */
    Handler h;
    /**
     * If not null the Activity could listen to {@link MeshTVPIPListener MeshTVPIPListener} events
     */
    private BroadcastReceiver pipReceiver = null;
    /**
     * If not null the Activity could listen to {@link MeshTVAirmediaListener MeshTVAirmediaListener} events
     */
    private BroadcastReceiver airmediaReceiver = null;
    /**
     * If not null the Activity could listen to {@link MeshTVPackageListener MeshTVPackageListener} events
     */
    private BroadcastReceiver packageReceiver = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================LifeCycle===========================================
    /**
     * Events:
     * <br>1. Invokes {@link #init() init()} method
     * <br>2. Checks if the Activity can Play Videos if Yes it send a stop signal for PIP
     * <br>3. Invokes {@link #draw() draw()} method
     * @param savedInstanceState
     */
    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        init();
        if(setting.playsVideos())
        {
            MeshTVBroadcaster.stopPIP(this);
        }
        draw();
    }

    /**
     * Events:
     * <br>1. Start all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimedMethod} annotated methods
     * <br>2. Sets the Activity to Full Screen or Not depending on {@link ActivitySetting#isFullScreen()}  ActivitySetting.isFullScreen()}
     * <br>3. Starts to listen to (Activity should Implement the corresponding listener for it to start listening to their events):
     * <br>- {@link MeshTVPIPListener MeshTVPIPListener}
     * <br>- {@link MeshTVAirmediaListener MeshTVAirmediaListener}
     * <br>- {@link MeshTVPackageListener MeshTVPackageListener}
     */
    @Override
    public void onResume()
    {
        super.onResume();
        if(this instanceof MeshNotificationListener)
        {
            MeshTVApp.get().addListener(this);
        }
        if(this instanceof MeshSubscriptionListener)
        {
            MeshTVApp.get().addListener(this);
        }
        h = new Handler();
        final Object o = this;
        MeshAnnotationManager.startTimedMethods(timedMethods,h,this);
        if(setting.isFullScreen())
        {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
        if(this instanceof MeshTVPIPListener)
        {
            MeshTVPIPListener listener = (MeshTVPIPListener) this;
            pipReceiver = MeshTVBroadcaster.listenToPIPReady(this,listener);
        }
        if(this instanceof MeshTVAirmediaListener)
        {
            MeshTVAirmediaListener listener = (MeshTVAirmediaListener)this;
            airmediaReceiver = MeshTVBroadcaster.listenToAirmedia(this,listener);
        }
        if(this instanceof MeshTVPackageListener)
        {
            MeshTVPackageListener listener = (MeshTVPackageListener)this;
            packageReceiver = MeshTVBroadcaster.listenToPackages(this,listener);
        }
        if(this instanceof MeshSubscriptionUpdateListener)
        {
            MeshTVApp.get().addListener(this);
        }
    }
    /**
     * Events:
     * <br>1. Stops all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimeMethod} annotated methods
     * <br>2. Unregister all receivers for:
     * <br>- {@link MeshTVAirmediaListener MeshTVAirmediaListener}
     * <br>- {@link MeshTVPIPListener MeshTVPIPListener}
     * <br>- {@link MeshTVPackageListener MeshTVPackageListener}
     */
    @Override
    public void onPause()
    {
        super.onPause();

        if(this instanceof MeshNotificationListener)
        {
            MeshTVApp.get().removeListener(this);
        }

        if(this instanceof MeshSubscriptionListener)
        {
            MeshTVApp.get().removeListener(this);
        }

        if(this instanceof MeshSubscriptionUpdateListener)
        {
            MeshTVApp.get().removeListener(this);
        }

        MeshAnnotationManager.stopTimedMethods(h);

        if(pipReceiver!=null)
        {
            MeshTVBroadcaster.ignore(this,pipReceiver);
        }

        if(airmediaReceiver!=null)
        {
            MeshTVBroadcaster.ignore(this,airmediaReceiver);
        }

        if(packageReceiver!=null)
        {
            MeshTVBroadcaster.ignore(this,packageReceiver);
        }

    }

    /**
     * Triggers {@link #terminate() terminate()}
     */
    protected void onDestroy()
    {
        super.onDestroy();
        terminate();
    }
    //==============================================================================================
    //===========================================Method=============================================
    //--------------------------------------------Init----------------------------------------------
    /**
     * Initializes the {@link MeshTVActivity MeshTVActivity}
     * <br>Steps:
     * <br>1. Make reference with the required {@link Layout Layout} annotation
     * <br>2. Make reference with the required {@link ActivitySetting ActivitySetting} annotation
     * <br>3. Retrieves all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Init Init} annotated methods
     * <br>4. Retrieves all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Terminate Terminate} annotated methods
     * <br>5. Retrieves all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Activity.AttachFragment AttachFragment} annotated methods
     * <br>6. Retrieves all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimedMethod} annotated methods
     * <br>7. Checks if {@link MeshTVActivity MeshTVActivity} is allowed to request for permissions, launches a request if so.
     */
    private final void init()
    {
        layout = getClass().getAnnotation(Layout.class);
        if(layout==null)
        {
            throw new BittelActivityException(TAG+": Layout Annotation is required");
        }
        setting = getClass().getAnnotation(ActivitySetting.class);
        if(setting==null)
        {
            throw new BittelActivityException(TAG+": ActivitySetting Annotation is required");
        }
        if(setting.isManualSetUp())
        {
            Log.i(TAG,"SET-UP: MANUAL");
            Log.i(TAG,"SET-UP: Account ID ("+MeshTVPreferenceManager.getAccountID(this)+")");
            if(MeshTVPreferenceManager.getAccountID(this).equals("account_id"))
            {
                Log.i(TAG,"SET-UP: STATUS (CONFIGURING)");
                onShoulRegister();
            }
            else
            {
                Log.i(TAG,"SET-UP: STATUS (CONFIGURED)");
            }

        }
        else
        {
            Log.i(TAG,"SET-UP: AUTO");
        }
        initMethods = new ArrayList<>();
        initMethods.addAll(MeshAnnotationManager.getInit(getClass()));
        termMethods = new ArrayList<>();
        termMethods.addAll(MeshAnnotationManager.getTerminate(getClass()));
        attachFragments = new ArrayList<>();
        attachFragments.addAll(MeshAnnotationManager.getFragment(getClass()));
        timedMethods = new ArrayList<>();
        timedMethods.addAll(MeshAnnotationManager.getTimed(getClass()));
        MeshAnnotationManager.runMethods(initMethods,this);
        if(setting.requestPermissions())
        {
            MeshTVApp.get().requestPermissions(this);
        }
    }

    /**
     * Draws the Activity
     * <br>Events:
     * <br>1. Inflate the Resource Layout form {@link Layout Layout}
     * <br>NOTE: If layout value is -22 will use bittel_realm_layout
     * <br>2. Sets if the {@link BittelActivity BittelActivity} should be in full screen or not
     * <br>3. Attaches Fragments
     * <br>4. BindWidgets
     */
    private final void draw()
    {
        Log.i(TAG,"draw()");
        Log.i(TAG,"Drawing Fragments");
        if(layout.value()==-22)
        {
            setContentView(R.layout.bittel_realm_layout);
        }
        else
        {
            setContentView(layout.value());
        }
        if(setting.isFullScreen())
        {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            if(getSupportActionBar()!=null)
            {
                getSupportActionBar().hide();
            }

        }
        MeshAnnotationManager.attachFragments(attachFragments,getSupportFragmentManager(),this);
        MeshAnnotationManager.bindWidgets(this);
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Quick-Tune-----------------------------------------
    boolean quickTune(KeyEvent event)
    {
        switch (event.getAction())
        {
            case KeyEvent.ACTION_UP:

                switch (event.getKeyCode())
                {
                    case KeyEvent.KEYCODE_0:
                        quickTuneDisplay(0);
                        return true;
                    case KeyEvent.KEYCODE_1:
                        quickTuneDisplay(1);
                        return true;
                    case KeyEvent.KEYCODE_2:
                        quickTuneDisplay(2);
                        return true;
                    case KeyEvent.KEYCODE_3:
                        quickTuneDisplay(3);
                        return true;
                    case KeyEvent.KEYCODE_4:
                        quickTuneDisplay(4);
                        return true;
                    case KeyEvent.KEYCODE_5:
                        quickTuneDisplay(5);
                        return true;
                    case KeyEvent.KEYCODE_6:
                        quickTuneDisplay(6);
                        return true;
                    case KeyEvent.KEYCODE_7:
                        quickTuneDisplay(7);
                        return true;
                    case KeyEvent.KEYCODE_8:
                        quickTuneDisplay(8);
                        return true;
                    case KeyEvent.KEYCODE_9:
                        quickTuneDisplay(9);
                        return true;
                }
                break;
        }
        return false;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Terminate------------------------------------------

    /**
     * Stops all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimedMethod} annotated Methods
     */
    private final void terminate()
    {
        Log.i(TAG,"terminate()");
        Log.i(TAG,"Terminating Activity");
        MeshAnnotationManager.runMethods(termMethods,this);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Abstract==========================================
    abstract void onShoulRegister();
    abstract void quickTuneDisplay(int i);
    //==============================================================================================
    //============================================Exception=========================================

    /**
     * Exception thrown when some instance of {@link BittelActivity BittelActivity} misses some or all of the required settings
     */
    private final class BittelActivityException extends RuntimeException
    {
        private BittelActivityException(String message)
        {
            super(message);
        }
    }
    //==============================================================================================

}
