package com.ph.bittelasia.meshtv.tv.mtvlib.ExoPlayer.Control;

import android.content.Context;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.ResourceManager.MeshResourceManager;

/**
 * Creates different implementations of {@link SimpleExoPlayer SimpleExoPlayer} depending on the type requested
 * <br>
 * <br>Supported:
 * <br>1. {@link #SIMPLE_PLAYER SIMPLE_PLAYER}
 * <br>2. {@link #DASH_PLAYER DASH_PLAYER} (Not implemented yet)
 * <br>3. {@link #EXTRACTOR_PLAYER EXTRACTOR_PLAYER} (Not implemented yet)
 * <br>4. {@link #HLS_PLAYER HLS_PLAYER} (Not implemented yet)
 * <br>5. {@link #SMOOTH_STREAM_PLAYER SMOOTH_STREAM_PLAYER} (Not implemented yet)
 */
class BittelPlayerFactory
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    static final String TAG = BittelPlayerFactory.class.getSimpleName();
    static final int SIMPLE_PLAYER = 0;
    static final int DASH_PLAYER = 1;
    static final int EXTRACTOR_PLAYER =2;
    static final int HLS_PLAYER = 3;
    static final int SMOOTH_STREAM_PLAYER = 4;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Generate==========================================

    /**
     * Generates a {@link SimpleExoPlayer SimpleExoPlayer} depending on the type reqyesred
     * @param context required by {@link ExoPlayerFactory ExoPlayerFactory}
     * @param type type of {@link SimpleExoPlayer SimpleExoPlayer}
     * @return {@link SimpleExoPlayer SimpleExoPlayer}
     */
    static SimpleExoPlayer generate(Context context,int type)
    {
        BandwidthMeter meter = new DefaultBandwidthMeter();

        TrackSelection.Factory trackSelectionFactory = new AdaptiveTrackSelection.Factory(meter);
        TrackSelector selector = new DefaultTrackSelector(trackSelectionFactory);
        switch (type)
        {
            case SIMPLE_PLAYER:
                return ExoPlayerFactory.newSimpleInstance(context,selector);
        }
        return null;
    }
    //==============================================================================================
}
