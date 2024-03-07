package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Apps.MeshApp;

import java.util.ArrayList;

/**
 * Listen to response of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Apps.MeshTVGetAppTask MeshTVGetAppTask}
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public interface MeshAppListener
{
    /**
     * Triggered when at least 1 app is found
     * @param apps Array of Results
     */
    public abstract void onAppsLoaded(ArrayList<MeshApp> apps);

    /**
     * Triggered when no Apps were found
     */
    public abstract void onAppsNotFound();
}
