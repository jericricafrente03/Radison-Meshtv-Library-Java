package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshGuest;
/**
 * Listens to changes in {@link MeshGuest MeshGuest}
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public interface MeshGuestListener
{
    /**
     * Triggred on Check-in
     * @param guest Guest that Checked-in
     */
    public abstract void checkIn(MeshGuest guest);
    /**
     * Triggred on updates with {@link MeshGuest MeshGuest}
     * @param guest updated {@link MeshGuest MeshGuest}
     */
    public abstract void onGuestUpdate(MeshGuest guest);
}
