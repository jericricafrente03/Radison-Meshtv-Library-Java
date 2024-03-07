package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener;

/**
 * Listens to Airmedia Events
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public interface MeshAirmediaListener
{
    /**
     * Triggered when Airmedia is ready
     */
    public abstract void onReady();

    /**
     * Triggered when Airmedia was stopped
     */
    public abstract void onStop();

    /**
     * Triggered when AirMedia Credentials was updated
     */
    public abstract void onCredentialsUpdated();
}
