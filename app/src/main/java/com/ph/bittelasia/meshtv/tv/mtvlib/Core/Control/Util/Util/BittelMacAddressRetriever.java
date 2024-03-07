package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;


import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Retrieves the mac address and hash it to md5 for API Key
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
class BittelMacAddressRetriever
{
    //============================================Variable==========================================
    //==============================================================================================
    //=============================================Method===========================================

    /**
     * Retrieve API Key
     * @param context required to get WiFi MAC in case the Ethernet MAC was not found
     * @return API Key
     */
    public static String getDeviceMacAddressMD5(Context context)
    {
        if(context == null)
        {
            context = MeshTVApp.get().getApplicationContext();
        }
//        String appVersion = MeshTVPreferenceManager.getIP.getVersion();
        String appVersion = MeshTVPreferenceManager.getVersion(null);
        return convertToHash(getEthernetMacAddress(context).replaceAll(":","").toLowerCase(), appVersion);
    }

    /**
     * Hash the retrieved MAC Address to MD5 using AppVersion
     * @param macAddress retrieved MAC Address
     * @param appVersion current version of app
     * @return hashed MAC Address
     */
    private static String convertToHash(String macAddress, String appVersion) {
        StringBuffer sb = null;

        String newMacAddr = macAddress.replace(":", "");
        newMacAddr = newMacAddr.toLowerCase();
        newMacAddr += appVersion;
        newMacAddr = newMacAddr.replaceAll("\\n","");
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(newMacAddr.getBytes());

            byte byteData[] = md.digest();

            sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * Retrieve Ethernet MAC Address
     * @param context required to get WiFi MAC Address just in case ethernet MAC was not found
     * @return Ethernet MAC Address
     */
    public static String getEthernetMacAddress(Context context) {
        try {
            StringBuffer fileData = new StringBuffer(1000);
            BufferedReader reader = new BufferedReader(new FileReader("/sys/class/net/eth0/address"));
            char[] buf = new char[1024];
            int numRead = 0;
            while ((numRead = reader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                fileData.append(readData);
            }
            reader.close();
            if(fileData!=null)
            {
                return fileData.toString();
            }
            else
            {
                return getWifiMacAddress(context);

            }

        }
        catch (Exception e)
        {

            return getWifiMacAddress(context);
        }
    }

    /**
     * Gets the wifi MAC Address
     * @param context required to get WifiManager
     * @return Wifi MAC Address
     */
    public static String getWifiMacAddress(Context context)
    {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(true);
        WifiInfo wInfo = wifiManager.getConnectionInfo();
        return wInfo.getMacAddress();
    }
    //==============================================================================================
}
