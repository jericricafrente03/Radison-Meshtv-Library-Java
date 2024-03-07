package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Settings;

/**
 * Sets how the app will update the Data upon boot
 * @author Mars Ray Canizares Araullo
 * @version 2.0
 */
public enum  DataMode
{
    /**
     * App will do nothing with the data (DEFAULT)
     */
    DO_NOTHING,
    /**
     * App will request for updated data and update the existing
     */
    UPDATE,
    /**
     * App will first clear the data and replace with new data
     */
    REPLACE,
    /**
     * App will delete all data
     */
    CLEAR
}

