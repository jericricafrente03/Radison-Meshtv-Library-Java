package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.FileReader;

/**
 * Reads files from USB
 * <br>Modes:
 * <br>1. Looks for either USB-A or USB-B for sdk < 23
 * <br>2. Looks for any attached USB for sdk >= 23
 * @author Mars Ray Canizares Araullo
 * @version  1.0
 */
public class MeshTVDemoFileReader
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = MeshTVDemoFileReader.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Method==========================================
    /**
     * Retrieves the directory wher media files could be found
     * @return full path to the /media directory
     */
    public static String getMediaPath(){return BittelDemoFileReader.getMediaPath();}
    /**
     * Looks for a file from all the USB Paths
     * @param filename filename to search for
     * @return contents of the file
     */
    public static String getContents(String filename){return BittelDemoFileReader.getFile(filename);}
    //==============================================================================================

}
