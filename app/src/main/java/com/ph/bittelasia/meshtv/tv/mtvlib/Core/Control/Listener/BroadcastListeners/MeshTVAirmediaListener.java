package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners;

/**
 * Listens to AirMedia Events
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public interface MeshTVAirmediaListener
{
    /**
     * Triggered when Airmedia is Ready
     */
    public abstract void airmediaReady();

    /**
     * Triggered when Airmedia was closed
     */
    public abstract void airmediaNotReady();
}
