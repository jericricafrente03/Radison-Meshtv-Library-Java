package com.ph.bittelasia.meshtv.tv.mtvlib.ExoPlayer.Control;


import android.content.Context;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.TransferListener;

public class UDPDataSourceFactory implements DataSource.Factory
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = UDPDataSourceFactory.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    Context context;
    TransferListener listener;
    DataSource dataSource;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Constructor======================================
    public UDPDataSourceFactory(Context context,TransferListener listener,DataSource dataSource)
    {
        this.context = context;
        this.listener = listener;
        this.dataSource = dataSource;
    }
    //==============================================================================================
    //==========================================DataSource.Factory==================================

    @Override
    public DataSource createDataSource() {
        return new UDPDataSource(context,listener,dataSource);
    }

    //==============================================================================================
}
