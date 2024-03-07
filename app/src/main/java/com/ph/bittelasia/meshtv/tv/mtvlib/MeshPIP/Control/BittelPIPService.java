package com.ph.bittelasia.meshtv.tv.mtvlib.MeshPIP.Control;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.VideoView;

import androidx.annotation.Nullable;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Broadcast.MeshTVBroadcaster;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.FileReader.MeshTVDemoFileReader;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util.MeshUtil;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;

class BittelPIPService extends Service
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = BittelPIPService.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    WindowManager manager = null;
    LinearLayout ll_container = null;
    MediaPlayer mp = null;
    LinearLayout.LayoutParams ll_param = null;
    WindowManager.LayoutParams parameters = null;
    VideoView videoView = null;
    View blocker;
    BroadcastReceiver stop = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            close();
        }
    };
    BroadcastReceiver seek = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            videoView.seekTo(intent.getIntExtra(MeshUtil.PIP_VIDEO_SEEK,0));
        }
    };
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================LifeCycle=========================================
    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.i(TAG,"PIP Create");
        registerReceiver(stop,new IntentFilter(MeshUtil.PIP_VIDEO_STOP));
        registerReceiver(seek,new IntentFilter(MeshUtil.PIP_VIDEO_SEEK));
        manager = (WindowManager) getSystemService(WINDOW_SERVICE);

        mp = new MediaPlayer();
        ll_container = new LinearLayout(this);
        ll_param = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                );
        ll_container.setLayoutParams(ll_param);

        Log.i(TAG,"PIP Create Width:"+BittelPIPPreference.getPIPWidth(getBaseContext()));
        Log.i(TAG,"PIP Create Height:"+BittelPIPPreference.getPIPHeight(getBaseContext()));
        Log.i(TAG,"PIP Create X:"+BittelPIPPreference.getPIPX(getBaseContext()));
        Log.i(TAG,"PIP Create Y:"+BittelPIPPreference.getPIPY(getBaseContext()));
        parameters = new WindowManager.LayoutParams
                (
                        BittelPIPPreference.getPIPWidth(getBaseContext()),
                        BittelPIPPreference.getPIPHeight(getBaseContext()),
                        WindowManager.LayoutParams.TYPE_PHONE,
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                        PixelFormat.TRANSLUCENT
                );
        Log.i(TAG,"PIP Create Parameters");
        parameters.x = BittelPIPPreference.getPIPX(getBaseContext());
        parameters.y = BittelPIPPreference.getPIPY(getBaseContext());
        parameters.gravity = Gravity.CENTER | Gravity.CENTER;
        parameters.type = WindowManager.LayoutParams.TYPE_TOAST;
        Log.i(TAG,"PIP Create X:"+parameters.x);
        Log.i(TAG,"PIP Create Y:"+parameters.y);
        Log.i(TAG,"PIP Create Gravity:"+parameters.gravity);
        Log.i(TAG,"PIP Create Type:"+parameters.type);

        manager.addView(ll_container,parameters);
        Log.i(TAG,"PIP Create View ADDED");
        View v = LayoutInflater.from(ll_container.getContext()).inflate(R.layout.window_layout,ll_container);
        init();
        draw(v);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    //==============================================================================================
    //===============================================Method=========================================
    private final void init()
    {
        Log.i(TAG,"PIP Initiated");
    }
    private final void draw(View v)
    {
        Log.i(TAG,"PIP Drawn");
        videoView = (VideoView) v.findViewById(R.id.vv_vid);
        videoView.setVisibility(View.VISIBLE);
        String url = BittelPIPPreference.getPIPURL(ll_container.getContext());
        if(url.startsWith(MeshTVDemoFileReader.getMediaPath()))
        {
            videoView.setVideoPath(url);
        }
        else
        {
            videoView.setVideoURI(Uri.parse(url));
        }

        blocker= v.findViewById(R.id.rl_blocker);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
        {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer)
            {
                blocker.setVisibility(View.GONE);
                MeshTVBroadcaster.pipReady(getBaseContext());

            }
        });
        videoView.start();
        ll_container.setOnTouchListener(new View.OnTouchListener()
        {
            private WindowManager.LayoutParams updatedParam = parameters;
            int x;
            int y;
            float touchX;
            float touchY;
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        x = updatedParam.x;
                        y = updatedParam.y;
                        touchX = motionEvent.getRawX();
                        touchY = motionEvent.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        updatedParam.x = (int)(x+(motionEvent.getRawX()-touchX));
                        updatedParam.y = (int)(y+(motionEvent.getRawY()-touchY));
                        manager.updateViewLayout(ll_container,updatedParam);
                        break;
                }
                return false;
            }
        });
    }

    private void close()
    {
        if(BittelPIPPreference.getPIPCanSeek(getBaseContext()))
        {
            BittelPIPPreference.setPIPSeek(getBaseContext(),videoView.getCurrentPosition());
        }
        else
        {
            BittelPIPPreference.setPIPSeek(getBaseContext(),-1);
        }
        manager.removeView(ll_container);
        unregisterReceiver(stop);
        unregisterReceiver(seek);
        stopSelf();
    }
    //==============================================================================================
    //===============================================Service========================================
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    //==============================================================================================
}
