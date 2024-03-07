package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners;

/**
 * Waits for response from API Calls
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public interface MeshRequestListener
{
    /**
     * Triggered when API call has failed
     * @param message failure message
     */
    public abstract void onFailed(String message);

    /**
     * Triggered when API calls has suceeded
     * @param result success message
     */
    public abstract void onResult(String result);

}
