package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.TemporaryAPIs;

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
class BittelTempDataManager
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = BittelTempDataManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    static void requestData(Class c, MeshDataListener listener,MeshTVTemporaryAPIListener temp)
    {
        new MeshTVTempGetTask(c,listener,temp).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
    static void requestData(Class c,MeshTVTemporaryAPIListener temp)
    {
        new MeshTVTempGetTask(c,null,temp).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
    static void requestData(Context context,int datasource,Class c, MeshDataListener listener,MeshTVTemporaryAPIListener temp)
    {
        new MeshTVTempGetTask(context,datasource,c,listener,temp).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
    static void requestData(Context context,int source, MeshDataListener listener,String data,MeshTVTemporaryAPIListener temp)
    {
        new MeshTVTempGetTask(context,source,listener,data,temp).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
    static void requestData(Class c, MeshDataListener listener,MeshAdditionalParam additionalParam,MeshTVTemporaryAPIListener temp)
    {
        new MeshTVTempGetTask(c,listener,additionalParam,temp).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

}
