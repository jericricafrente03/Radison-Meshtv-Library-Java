package com.ph.bittelasia.meshtv.tv.mtvlib.ExoPlayer.Control;

import android.content.Context;
import android.net.Uri;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.android.exoplayer2.util.Assertions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UDPDataSource implements DataSource
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = UDPDataSource.class.getSimpleName();
    public static final String SCHEME_UDP = "udp";
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    private Context context;
    private TransferListener listener;
    private DataSource baseDataSource;
    private DataSource udpDataSource;
    private DataSource dataSource;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Constructor======================================
    public UDPDataSource (Context context, TransferListener listener, String useragent, boolean allowCrossProtocolRedirects)
    {
        this(context,listener,useragent, DefaultHttpDataSource.DEFAULT_CONNECT_TIMEOUT_MILLIS,
                DefaultHttpDataSource.DEFAULT_READ_TIMEOUT_MILLIS,allowCrossProtocolRedirects);
    }
    public UDPDataSource(Context context,TransferListener listener,String useragent,int connectionTimeoutMillis, int readTimeoutMillis, boolean allowCrossProtocolRedirects)
    {
        this(context,listener,new DefaultHttpDataSource(useragent,null,listener,connectionTimeoutMillis,readTimeoutMillis,allowCrossProtocolRedirects,null));
    }
    public UDPDataSource(Context context,TransferListener listener,DataSource baseDataSource)
    {
        this.context = context;
        this.listener = listener;
        this.baseDataSource = Assertions.checkNotNull(baseDataSource);
    }
    //==============================================================================================
    //===============================================DataSource=====================================

    @Override
    public void addTransferListener(TransferListener transferListener) {
        
    }

    @Override
    public long open(DataSpec dataSpec) throws IOException {
        Assertions.checkState(dataSource==null);
        String scheme = dataSpec.uri.getScheme();
        if(SCHEME_UDP.endsWith(scheme))
        {

            dataSource = getUDPDataSource();
        }
        else
        {
            dataSource = baseDataSource;
        }
        return dataSource.open(dataSpec);
    }

    @Override
    public int read(byte[] buffer, int offset, int readLength) throws IOException {
        return dataSource.read(buffer,offset,readLength);
    }

    @Override
    public Uri getUri() {
        return dataSource==null?null:dataSource.getUri();
    }

    @Override
    public Map<String, List<String>> getResponseHeaders() {
        return null;
    }

    @Override
    public void close() throws IOException {
        if(dataSource!=null)
        {
            try
            {
                dataSource.close();
            }
            finally {
                dataSource = null;
            }
        }
    }

    //==============================================================================================
    //===============================================UDP============================================
    private DataSource getUDPDataSource()
    {
        if(udpDataSource==null)
        {
            udpDataSource = new UdpDataSource(listener);
        }
        return udpDataSource;
    }
    //==============================================================================================
}
