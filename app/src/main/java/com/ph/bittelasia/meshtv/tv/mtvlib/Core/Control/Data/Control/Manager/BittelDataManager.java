package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Manager;

import android.content.Context;
import android.os.AsyncTask;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Getter.MeshAdditionalParam;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Getter.MeshTVGetTask;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;

/**
 * <br>Version 2.0 added support for:
 * <br>1. {@link MeshAdditionalParam MeshAdditionalParam}
 * @author Mars Ray Canizares Araullo
 * @version 2.0
 */
class BittelDataManager
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = BittelDataManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    static void requestData(Class c, MeshDataListener listener)
    {
        new MeshTVGetTask(c,listener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
    static void requestData(Class c)
    {
        new MeshTVGetTask(c,null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
    static void requestData(Context context,int datasource,Class c, MeshDataListener listener)
    {
        new MeshTVGetTask(context,datasource,c,listener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
    static void requestData(Context context,int source, MeshDataListener listener,String data)
    {
        new MeshTVGetTask(context,source,listener,data).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
    static void requestData(Class c, MeshDataListener listener,MeshAdditionalParam additionalParam)
    {
        new MeshTVGetTask(c,listener,additionalParam).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

}
