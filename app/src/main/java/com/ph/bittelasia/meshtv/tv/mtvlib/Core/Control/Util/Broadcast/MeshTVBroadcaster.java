package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.MeshTVAirmediaListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.MeshTVPIPListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.MeshTVPackageListener;

/**
 * Provides easy way to control BroadcastReceivers and Broadcasts
 * <br>Broadcasts supported:
 * <br>1. PIP
 * <br>2. Package Listener
 * <br>3. Airmedia
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshTVBroadcaster
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = MeshTVBroadcaster.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //--------------------------------------------Broadcast-----------------------------------------

    /**
     * Sends Broadcast to stop all PIPs
     * @param context required to send Broadcasts
     */
    public static synchronized void stopPIP(Context context) {BittelBroadcaster.stopPIP(context);}

    /**
     * Notifies all listeners that PIP is ready to Play
     * @param context required to send Broadcasts
     */
    public static synchronized void pipReady(Context context) {BittelBroadcaster.pipReady(context);}
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Listen-------------------------------------------

    /**
     * Creates a BroadcastReceiver that listens to PIP ready events
     * @param context required to register the BroadcastReceiver
     * @param listener {@link MeshTVPIPListener MeshTVPIPListener} that gets notified when PIP is ready
     * @return created BroadcastReceiver
     */
    public static synchronized BroadcastReceiver listenToPIPReady(Context context, MeshTVPIPListener listener)
    {return BittelBroadcaster.listenToPIPReady(context,listener);}

    /**
     * Creates a BroadcastReceiver that listens to Airmedia events
     * @param context required to register the BroadcastReceiver
     * @param listener the {@link MeshTVAirmediaListener MeshTVAirmediaListener} that gets notified when Airmedia is ready or not ready
     * @return created BroadcastReceiver
     */
    public static synchronized BroadcastReceiver listenToAirmedia(Context context, MeshTVAirmediaListener listener)
    {
        return BittelBroadcaster.listenToAirmedia(context,listener);
    }
    /**
     * Creates a BroadcastReceiver when apps get installed/uninstalled
     * @param context required to register the BroadcastReceiver
     * @param listener the {@link MeshTVPackageListener MeshTVPackageListener} that gets notified when apps get installed/uninstalled
     * @return created BroadcastReceiver
     */
    public static synchronized BroadcastReceiver listenToPackages(Context context, MeshTVPackageListener listener)
    {
        return BittelBroadcaster.listenToPackages(context,listener);
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Ignore-------------------------------------------
    /**
     * Unregisters the receiver making the context ignore broadcasts associated to it
     * @param context context to remove the receiver from
     * @param receiver receiver to remove
     */
    public static synchronized final void ignore(Context context,BroadcastReceiver receiver)
    {context.unregisterReceiver(receiver);}
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
