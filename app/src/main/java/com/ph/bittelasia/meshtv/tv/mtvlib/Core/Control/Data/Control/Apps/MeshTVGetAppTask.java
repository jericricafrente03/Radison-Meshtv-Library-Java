package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Apps;

import android.os.AsyncTask;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshAppListener;

/**
 * Provides access to retrieve apps from the file system
 * @author Mars Ray Araullo Canizares
 * @version 1.0
 */
public class MeshTVGetAppTask
{
    /**
     * Request for apps from file system
     * @param listener Waits for the response of the request
     */
    public static void request(MeshAppListener listener)
    {
        new BittelGetAppTask(listener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
}
