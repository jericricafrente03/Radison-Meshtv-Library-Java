package com.ph.bittelasia.meshtv.tv.mtvlib.ExoPlayer.View.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Exoplayer.MeshTVPlayerSettings;
import com.ph.bittelasia.meshtv.tv.mtvlib.ExoPlayer.Control.MeshTVExoPlayerManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.ExoPlayer.Control.MeshTVPlayerFactory;

abstract class BittelExoplayerFragment extends Fragment
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    public static final String TAG = BittelExoplayerFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------View---------------------------------------------
    SimpleExoPlayerView exoPlayerView = null;
    SimpleExoPlayer exoPlayer = null;
    MeshTVPlayerSettings settings = null;
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    String url = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================LifeCycle=========================================
    public final void onCreate(Bundle instance)
    {
        super.onCreate(instance);
        init();
    }
    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        if(settings.exoplayer()!=0&&settings.exoplayer()!=0)
        {
            View v = inflater.inflate(settings.layout(),container,false);
            exoPlayerView  = (SimpleExoPlayerView) v.findViewById(settings.exoplayer());
            exoPlayer = MeshTVPlayerFactory.generateSimpleExoPlayer(getActivity());
            exoPlayer.setPlayWhenReady(true);
            exoPlayerView.setPlayer(exoPlayer);
            exoPlayerView.setUseController(settings.hasControls());
            return v;
        }
        else
        {
            return null;
        }
    }
    @Override
    public void onPause()
    {
        super.onPause();
        stopExo();
    }
    //==============================================================================================
    //==============================================Method==========================================
    //-----------------------------------------------Init-------------------------------------------
    private final void init()
    {
        settings = getClass().getAnnotation(MeshTVPlayerSettings.class);
        if(settings == null)
        {
            throw  new RuntimeException("MeshTVPlayerSettings is required.");
        }
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Getter-----------------------------------------
    String getUrl() {
        return url;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Setter-----------------------------------------
    final void setUrl(String url)
    {
        this.url = url;
        Log.i(TAG,"Exoplayer View:"+(exoPlayerView==null?"null":"OK"));
        Log.i(TAG,"Exoplayer:"+(exoPlayer==null?"null":"OK"));
        if(exoPlayerView!=null&&exoPlayer!=null)
        {
            MeshTVExoPlayerManager.play(getActivity(),exoPlayer,"MARS",url);
            Log.i(TAG,"Exoplayer: Playing");
        }
        else
        {
            Log.e(TAG,"Exoplayer: Failed to play");
        }
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Action-----------------------------------------
    final void stopExo()
    {
        if(exoPlayer!=null)
        {
            exoPlayer.stop();
        }
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
