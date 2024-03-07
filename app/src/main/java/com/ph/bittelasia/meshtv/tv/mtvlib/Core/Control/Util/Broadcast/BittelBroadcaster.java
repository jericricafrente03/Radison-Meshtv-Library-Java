package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.MeshTVAirmediaListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.MeshTVPIPListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.MeshTVPackageListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util.MeshUtil;

/**
 * Provides easy way of managing BroadcastReceivers and Broadcasts
 * <br>Broadcasts supported:
 * <br>1. PIP
 * <br>2. Package Listener
 * <br>3. Airmedia
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
final class BittelBroadcaster
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    static final String TAG = BittelBroadcaster.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Method=========================================
    //----------------------------------------------Broadcast---------------------------------------

    /**
     * Stops a running PIP
     * @param context required to send Broadcasts
     */
    static synchronized final void stopPIP(Context context)
    {
        Log.i(TAG,"stopPIP()  - requesting");
        if(context!=null)
        {
            context.sendBroadcast(new Intent(MeshUtil.PIP_VIDEO_STOP));
            Log.i(TAG,"stopPIP()  - request sent");
        }
        else
        {
            Log.e(TAG,"stopPIP()  - request failed");
        }
    }

    /**
     * Notifies listeners that PIP is ready to play
     * @param context required tot send Broadcasts
     */
    static synchronized final void pipReady(Context context)
    {
        Log.i(TAG,"pipReady()  - requesting");
        if(context!=null)
        {
            context.sendBroadcast(new Intent(MeshUtil.PIP_VIDEO_READY));
            Log.i(TAG,"pipReady()  - request sent");
        }
        else
        {
            Log.e(TAG,"pipReady()  - request failed");
        }
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Listen-----------------------------------------

    /**
     * Creates a BroadcastReceiver that listens to PIP ready events
     * @param context required to register the BroadcastReceiver
     * @param listener the {@link MeshTVPIPListener MeshTVPIPListener} that gets notified when PIP is ready
     * @return created BroadcastReceiver
     */
    static synchronized final BroadcastReceiver listenToPIPReady(Context context,final MeshTVPIPListener listener)
    {
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                listener.onPIPReady();
            }
        };
        context.registerReceiver(receiver,new IntentFilter(MeshUtil.PIP_VIDEO_READY));
        return receiver;
    }
    /**
     * Creates a BroadcastReceiver that listens to Airmedia events
     * @param context required to register the BroadcastReceiver
     * @param listener the {@link MeshTVAirmediaListener MeshTVAirmediaListener} that gets notified when Airmedia is ready or not ready
     * @return created BroadcastReceiver
     */
    static synchronized final BroadcastReceiver listenToAirmedia(Context context, final MeshTVAirmediaListener listener)
    {
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent)
            {
                switch (intent.getAction())
                {
                    case "com.waxrain.airplaydmr.action.SERVICE_READY":
                        listener.airmediaReady();
                        break;
                    case "com.waxrain.airplaydmr.action.SERVICE_NOTREADY":
                        listener.airmediaNotReady();
                        break;
                }
            }
        };
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.waxrain.airplaydmr.action.SERVICE_READY");
        filter.addAction("com.waxrain.airplaydmr.action.SERVICE_NOTREADY");
        context.registerReceiver(receiver,filter);
        return receiver;
    }
    /**
     * Creates a BroadcastReceiver when apps get installed/uninstalled
     * @param context required to register the BroadcastReceiver
     * @param listener the {@link MeshTVPackageListener MeshTVPackageListener} that gets notified when apps get installed/uninstalled
     * @return created BroadcastReceiver
     */
    static synchronized final BroadcastReceiver listenToPackages(Context context, final MeshTVPackageListener listener)
    {
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, final Intent intent)
            {
                switch (intent.getAction())
                {
                    case Intent.ACTION_PACKAGE_ADDED:
                    case Intent.ACTION_PACKAGE_INSTALL:
                        listener.appInstalled(intent.getData().toString().replaceFirst("package:",""));
                        break;
//                    case Intent.ACTION_PACKAGE_REMOVED:
                    case Intent.ACTION_PACKAGE_FULLY_REMOVED:
                        listener.appUnInstalled(intent.getData().toString().replaceFirst("package:",""));
                        break;
                }
            }
        };
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_PACKAGE_ADDED);
        filter.addAction(Intent.ACTION_PACKAGE_INSTALL);
//        filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        filter.addAction(Intent.ACTION_PACKAGE_FULLY_REMOVED);
        filter.addDataScheme("package");
        context.registerReceiver(receiver,filter);
        return receiver;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Ignore-----------------------------------------

    /**
     * Unregisters the receiver making the context ignore broadcasts associated to it
     * @param context context to remove the receiver from
     * @param receiver receiver to remove
     */
    static synchronized final void ignore(Context context,BroadcastReceiver receiver)
    {
        context.unregisterReceiver(receiver);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

}
