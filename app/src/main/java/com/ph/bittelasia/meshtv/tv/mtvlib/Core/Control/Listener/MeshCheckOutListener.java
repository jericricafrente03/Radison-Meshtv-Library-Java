package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener;

/**
 * Listens to Check-out Event
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public interface MeshCheckOutListener
{
    /**
     * Triggered when checkout failed
     * @param message reason why check-out failed
     */
    public abstract void onFail(String message);

    /**
     * Triggered when checkout succeeded
     * @param message success message
     */
    public abstract void onSuccess(String message);
}
