package com.ph.bittelasia.meshtv.tv.mtvlib.ExoPlayer.Control;

import android.content.Context;

import com.google.android.exoplayer2.SimpleExoPlayer;


/**
 * Creates different implementations of {@link SimpleExoPlayer SimpleExoPlayer} depending on the type requested
 * <br>
 * <br>Supported:
 * <br>1. {@link #SIMPLE_PLAYER SIMPLE_PLAYER}
 * <br>2. {@link #DASH_PLAYER DASH_PLAYER} (Not implemented yet)
 * <br>3. {@link #EXRACTOR_PLAYER EXRACTOR_PLAYER} (Not implemented yet)
 * <br>4. {@link #HLS_PLAYER HLS_PLAYER} (Not implemented yet)
 * <br>5. {@link #SMOOTH_STREAM_PLAYER SMOOTH_STREAM_PLAYER} (Not implemented yet)
 */
public class MeshTVPlayerFactory
{
    //===============================================Variable=======================================
    //-----------------------------------------------Constant---------------------------------------
    public static final String TAG = MeshTVPlayerFactory.class.getSimpleName();
    public static final  int SIMPLE_PLAYER = BittelPlayerFactory.SIMPLE_PLAYER;
    public static final  int DASH_PLAYER = BittelPlayerFactory.DASH_PLAYER;
    public static final  int EXRACTOR_PLAYER = BittelPlayerFactory.EXTRACTOR_PLAYER;
    public static final  int HLS_PLAYER = BittelPlayerFactory.HLS_PLAYER;
    public static final  int SMOOTH_STREAM_PLAYER = BittelPlayerFactory.SMOOTH_STREAM_PLAYER;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Method=========================================
    public static SimpleExoPlayer generateSimpleExoPlayer(Context context)
    {
        return BittelPlayerFactory.generate(context,SIMPLE_PLAYER);
    }
    //==============================================================================================
}
