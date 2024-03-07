package com.ph.bittelasia.meshtv.tv.mtvlib.ExoPlayer.Control;

import android.content.Context;

import com.google.android.exoplayer2.ExoPlayer;

/**
 * Manages the ExoPlayer
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshTVExoPlayerManager
{
    /**
    * Plays the video from the given url
    * <br>
    * <br>Supports:
    * <br>1. Supports UDP
    * <br>2. Supports HTTP
    * @param context Required for datasource factory
    * @param exoPlayer An instance of an {@link ExoPlayer ExoPlayer} to play the video
    * @param user A string to identify what app is playing the video
    * @param uri Uri the video can be found
    */
    public static void play(Context context, ExoPlayer exoPlayer,String user,String uri)
    {
        BittelExoplayerManager.play(context,exoPlayer,user,uri);
    }
}
