package com.ph.bittelasia.meshtv.tv.mtvlib.ExoPlayer.Control;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;


/**
 * Manages the ExoPlayer
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
final class BittelExoplayerManager
{
    //===============================================Variable=======================================
    //-----------------------------------------------Constant---------------------------------------
    final static String TAG = BittelExoplayerManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=================================================AV===========================================

    /**
     * Plays the video from the given url
     * <br>
     * <br>Supports:
     * <br>1. Supports UDP
     * <br>2. Supports HTTP
     * @param context Required for datasource factory
     * @param player An instance of an {@link ExoPlayer ExoPlayer} to play the video
     * @param useragent A string to identify what app is playing the video
     * @param uri Uri the video can be found
     */
    final static void play(Context context, ExoPlayer player, String useragent, String uri)
    {

        if(player!=null)
        {
            if(uri.startsWith("udp://")) {
                DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
                TransferListener s = new TransferListener() {
                    @Override
                    public void onTransferInitializing(DataSource source, DataSpec dataSpec, boolean isNetwork) {

                    }

                    @Override
                    public void onTransferStart(DataSource source, DataSpec dataSpec, boolean isNetwork) {

                    }

                    @Override
                    public void onBytesTransferred(DataSource source, DataSpec dataSpec, boolean isNetwork, int bytesTransferred) {

                    }

                    @Override
                    public void onTransferEnd(DataSource source, DataSpec dataSpec, boolean isNetwork) {

                    }
                };
                UDPDataSourceFactory dataSourceFactory = new UDPDataSourceFactory(context,s,
                        new DefaultDataSourceFactory(context, Util.getUserAgent(context,useragent),bandwidthMeter).createDataSource());
                ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
                Uri u = Uri.parse(uri);
                MediaSource videoSource = new ExtractorMediaSource(u,dataSourceFactory,extractorsFactory,null,null);
                player.prepare(videoSource);
                player.setPlayWhenReady(true);
            }
            else
            {
                DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
                DataSource.Factory datasourceFactory = new DefaultDataSourceFactory(context,Util.getUserAgent(context,useragent),bandwidthMeter);
                ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
                MediaSource videosource = new ExtractorMediaSource(Uri.parse(uri),datasourceFactory,extractorsFactory,null,null);
                player.prepare(videosource);
                player.setPlayWhenReady(true);
            }
        }
        else
        {
            Log.e(TAG,"play() - "+"Player not found");
        }
    }
    //==============================================================================================
}
