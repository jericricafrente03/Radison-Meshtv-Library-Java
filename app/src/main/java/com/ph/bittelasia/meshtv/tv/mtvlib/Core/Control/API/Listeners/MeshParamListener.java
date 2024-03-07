package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners;

/**
 * Used to request for extra parameters for api calls
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public interface MeshParamListener
{
    /**
     * Send the current url to append the additional parametrers
     * @param source original url
     * @return final url
     */
    public abstract String requestParams(String source);
}
