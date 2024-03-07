package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.TemporaryAPIs;

import android.content.Context;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;

public class MeshTVTempDataManager
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final int DATA_DIRECT     = -1;
    public static final int DATA_REQUEST    = -2;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================

    /**
     * Updates data without listening to the response
     * @param c Class of data requested
     */
    public static void requestData(Class c,MeshTVTemporaryAPIListener temp)
    {
        BittelTempDataManager.requestData(c,temp);
    }

    /**
     * Request Data and wait for response using a {@link MeshDataListener MeshDataListener}
     * @param c Class of data requested
     * @param listener waits for the response of the request
     */
    public static void requestData(Class c, MeshDataListener listener,MeshTVTemporaryAPIListener temp)
    {
        BittelTempDataManager.requestData(c,listener,temp);
    }

    /**
     * Request Data and wait for response using a {@link MeshDataListener MeshDataListener}
     * @param context custom context will use Application context if null
     * @param datasource custom datasource
     * @param c Class of data requested
     * @param listener waits for the response of the request
     */
    public static void requestData(Context context,int datasource,Class c, MeshDataListener listener,MeshTVTemporaryAPIListener temp)
    {
        BittelTempDataManager.requestData(context,datasource,c,listener,temp);
    }

    /**
     * Request Data and wait for response using a {@link MeshDataListener MeshDataListener}
     * @param context custom context will use Application context if null
     * @param source custom datasource
     * @param listener waits for the response of the request
     * @param data data from XMPP
     */
    public static void requestData(Context context,int source,MeshDataListener listener,String data,MeshTVTemporaryAPIListener temp)
    {
        BittelTempDataManager.requestData(context,source,listener,data,temp);
    }


    //==============================================================================================
}
