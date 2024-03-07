package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.SignageGetter;

/**
 * Allows additional parameters for Requests
 * @author Mars Ray Canizares Araullo
 * @version 2.0
 */
public interface MeshAdditionalParam
{
    /**
     * Sends the current url and parameters to allow additional parameters
     * @param url url before additional parameters
     * @return url with additional parameters
     */
    public abstract String addAdditionalParams(String url);
}
