package com.ph.bittelasia.meshtv.tv.mtvlib.MeshOverlay;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.ResourceManager.MeshResourceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.CustomScrollingTextView.MeshTVScrollingTextView;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;

public class MeshPopUpService extends Service
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = MeshPopUpService.class.getSimpleName();
    public static final String STOP = com.ph.bittelasia.meshtv.tv.mtvlib.MeshOverlay.MeshOverlayService.class.getCanonicalName()+"_STOP";
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Instance---------------------------------------
    WindowManager manager = null;
    LinearLayout ll_container = null;
    LinearLayout.LayoutParams ll_param = null;
    WindowManager.LayoutParams parameters = null;
    BroadcastReceiver stop = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            close();
        }
    };
    Handler h;
    int timeout;
    String message;
    MeshTVScrollingTextView tv_scroll;
    ImageView iv_ad;
    ImageView iv_close;
    ImageView iv_full;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            close();
        }
    };
    View v;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================LifeCycle=======================================
    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.i(TAG,"onCreate()");
        h = new Handler();
        registerReceiver(stop,new IntentFilter(STOP));
        manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        ll_container = new LinearLayout(this);
        ll_param = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        ll_container.setLayoutParams(ll_param);
        parameters = new WindowManager.LayoutParams
                (
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.TYPE_PHONE,
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                        PixelFormat.TRANSLUCENT
                );
        parameters.x = WindowManager.LayoutParams.MATCH_PARENT;
        parameters.y = WindowManager.LayoutParams.WRAP_CONTENT;
        parameters.gravity = Gravity.BOTTOM | Gravity.LEFT;
        parameters.type = WindowManager.LayoutParams.TYPE_TOAST;



//        manager.addView(ll_container,parameters);

       v = LayoutInflater.from(ll_container.getContext()).inflate(R.layout.meshtv_pop_up_layout,ll_container);

        init();
        draw(v);
        timeout = MeshTVPreferenceManager.getScrollTimeout(getBaseContext());
        message = MeshTVPreferenceManager.getScrollingMessage(getBaseContext());


        tv_scroll =(MeshTVScrollingTextView)v.findViewById(R.id.tv_notification);
        tv_scroll.setBackgroundColor(Color.parseColor("#aa000000"));
        iv_ad = (ImageView) v.findViewById(R.id.iv_banner);
        iv_full = (ImageView) v.findViewById(R.id.btn_full);
        iv_close = (ImageView) v.findViewById(R.id.btn_close);
        MeshResourceManager.displayLiveImageFor(getBaseContext(),iv_ad,MeshTVPreferenceManager.getNotificationIMGURL(getBaseContext()));
        manager.addView(v,parameters);
        tv_scroll.setDisplayTime(timeout);
        tv_scroll.setText(message);
        h.postDelayed(runnable,timeout);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
    //==============================================================================================

    //===============================================Method=========================================
    private final void init()
    {

    }
    private final void draw(View v)
    {

    }
    private void close()
    {
        manager.removeView(v);
        unregisterReceiver(stop);
        stopSelf();
    }
    //==============================================================================================

    //===============================================Service========================================
    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
    //==============================================================================================
}
