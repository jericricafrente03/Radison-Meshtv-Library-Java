package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners;

import android.content.Intent;

/**
 * Listens to Package events
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public interface MeshTVPackageListener
{
    /**
     * Triggered when app is installed
     * @param packagename Package name of installed app
     */
    public abstract void appInstalled(String packagename);

    /**
     * Triggered when app is uninstalled
     * @param packagename Package name of uninstalled app
     */
    public abstract void appUnInstalled(String packagename);
}
