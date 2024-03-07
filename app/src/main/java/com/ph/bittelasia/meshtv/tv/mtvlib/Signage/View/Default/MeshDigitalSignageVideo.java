package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.View.Default;

import android.os.Bundle;

import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Constant.AppDataSource;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.FileReader.MeshTVDemoFileReader;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.ExoPlayer.View.Fragment.MeshTVExoplayerFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Control.MeshDigitalSigangeVideoListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshSignage;

public abstract class MeshDigitalSignageVideo extends MeshTVExoplayerFragment
{
    //==========================================Variable============================================
    //------------------------------------------Constant--------------------------------------------
    public static final String TAG = MeshDigitalSignageVideo.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------View----------------------------------------------
    public MeshDigitalSignageVideo signageVideo;
    public static MeshDigitalSignageVideo fragment;
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Instance-------------------------------------------
    public MeshDigitalSigangeVideoListener videoListener;
    public SimpleExoPlayerView sv;
    MeshSignage meshSignage;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================Constructor=========================================
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================LifeCycle==========================================
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        sv = view.findViewById(setSimpleExoplayerView());
        sv.getVideoSurfaceView().bringToFront();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        play();
    }

    @Override
    public void onPause()
    {
        super.onPause();

    }
    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Action------------------------------------------
    public void play()
    {
        if(sv!=null)
        {
            sv.setUseController(false);
            if(MeshTVApp.get().getDataSourceSetting()== AppDataSource.SERVER)
            {
                setObjectURL(meshSignage.getMedia());
            }
            else
            {
                setObjectURL(MeshTVDemoFileReader.getMediaPath() + meshSignage.getMedia());
            }
            sv.getPlayer().addListener(new Player.EventListener() {

                @Override
                public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {
                    Log.i(TAG+"-state", "timeline: "+timeline.getPeriodCount()+" ->manifest: "+manifest);
                }

                @Override
                public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
                    Log.i(TAG+"-state", "track: "+trackGroups.length);
                }

                @Override
                public void onLoadingChanged(boolean isLoading)
                {
                    Log.i(TAG+"-state", "loading change: " + isLoading);
                }

                @Override
                public void onPlayerStateChanged(boolean playWhenReady, int playbackState)
                {
                    if (playWhenReady) {
                        switch (playbackState)
                        {
                            case 1: //STATE_IDLE
                                Log.i(TAG+"-state", "STATE_IDLE");
                                if(getListener()!=null)
                                {
                                    getListener().onIdle();
                                }
//                                setErrorVisibility(true);
                                break;
                            case 2: //STATE_BUFFERING
                                Log.i(TAG+"-state", "STATE_BUFFERING");
                                if(getListener()!=null)
                                {
                                    getListener().onBuffering();
                                }
                                break;
                            case 3: //STATE_READY
                                Log.i(TAG+"-state", "STATE_READY");
                                if(getListener()!=null)
                                {
                                    getListener().onReady();
                                }
//                                setErrorVisibility(false);
                                break;
                            case 4: //STATE_ENDED
                                Log.i(TAG+"-state", "STATE_ENDED");
                                if(getListener()!=null)
                                {
                                    getListener().onEnd();
                                }
                                break;
                        }
                    }else
                    {
//                        setErrorVisibility(true);
                    }
                }

                @Override
                public void onIsPlayingChanged(boolean isPlaying) {

                }

                @Override
                public void onRepeatModeChanged(int repeatMode) {
                    Log.i(TAG+"-state", "repeatmode");
                }

                @Override
                public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

                }

                @Override
                public void onPlayerError(ExoPlaybackException error) {
                    Log.i(TAG+"-state", "playerror");
//                    setErrorVisibility(true);
                }

                @Override
                public void onPositionDiscontinuity(int reason) {
                    Log.i(TAG, "discontinue:  "+reason );
                }

                @Override
                public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                    Log.i(TAG+"-state", "playback");
                }

                @Override
                public void onSeekProcessed() {

                }
            });


        }

    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Getter-----------------------------------------

    public MeshDigitalSigangeVideoListener getListener() {
        return videoListener;
    }

    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Setter-----------------------------------------

    public void setMeshSignage(MeshSignage meshSignage) {
        this.meshSignage = meshSignage;
        play();
    }
    public void setListener(MeshDigitalSigangeVideoListener listener)
    {
        this.videoListener = listener;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Abstract========================================
    public abstract int setSimpleExoplayerView();
    //==============================================================================================

}
