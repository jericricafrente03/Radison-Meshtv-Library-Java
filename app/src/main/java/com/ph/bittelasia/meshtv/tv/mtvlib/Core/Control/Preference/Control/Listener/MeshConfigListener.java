package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshConfig;

/**
 * Listens to changes in {@link MeshConfig MeshConfig}
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public interface MeshConfigListener
{
    /**
     * Triggered when there are changes in {@link MeshConfig MeshConfig}
     * @param config updated {@link MeshConfig MeshConfig}
     */
    public abstract void onHotelConfigurationChange(MeshConfig config);
}
