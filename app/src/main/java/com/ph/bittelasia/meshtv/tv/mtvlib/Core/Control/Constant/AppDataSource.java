package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Constant;

/**
 * Sets the App's data source
 */
public class AppDataSource
{
    /**
     * Data will be retrieved from a server specified in /sdcard/Android/iptv_xmpp.txt
     */
    public static final int SERVER = 0;
    /**
     * Data will be retrieved from the file system
     */
    public static final int FILE_SYSTEM = 1;
    /**
     * Data will be retrieved from an attached USB
     */
    public static final int USB = 2;
    /**
     * Data will be retrieved from the raw resource folder
     */
    public static final int RAW = 3;

}
