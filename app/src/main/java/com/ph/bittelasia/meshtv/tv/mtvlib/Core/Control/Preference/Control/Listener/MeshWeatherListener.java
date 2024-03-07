package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener;


import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshWeatherLocal;
/**
 * Listens to changes in {@link MeshWeatherLocal MeshWeatherLocal}
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public interface MeshWeatherListener
{
    /**
     * Triggred on updates with {@link MeshWeatherLocal MeshWeatherLocal}
     * @param weatherLocal updated {@link MeshWeatherLocal MeshWeatherLocal}
     */
    public abstract void onUpdateForWeather(MeshWeatherLocal weatherLocal);
}
