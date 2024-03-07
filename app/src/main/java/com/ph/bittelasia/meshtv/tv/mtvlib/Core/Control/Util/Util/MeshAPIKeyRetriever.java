package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util;

import android.content.Context;

/**
 * Retrieves API Key and MAC Address
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshAPIKeyRetriever
{
    /**
     * Retrieves API Key
     * @param context required to get MAC Address
     * @return API Key
     */
    public static String getAPIKey(Context context)
    {
        return BittelMacAddressRetriever.getDeviceMacAddressMD5(context);
    }

    /**
     * Retrieves MAC Address of device
     * @param context required to get MAC Address
     * @return MAC Address of device
     */
    public static String getMAC(Context context)
    {
        return BittelMacAddressRetriever.getEthernetMacAddress(context);
    }
}
