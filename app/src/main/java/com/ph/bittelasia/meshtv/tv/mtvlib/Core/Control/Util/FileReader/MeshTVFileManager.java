package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.FileReader;
/**
 * Reads files from the STBs File System
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshTVFileManager
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = MeshTVFileManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Method=========================================
    /**
     * Clears all error logs for maintenance purposes
     */
    public static void deleteErrorLogs()
    {
        BittelFileManager.deleteErrorLogs();
    }
    /**
     * Deletes a file from /sdcard/Android that matches the filename
     * @param filename filename of the file to be deleted
     */
    public static void deleteFile(String filename)
    {
        BittelFileManager.deleteFile(filename);
    }
    /**
     * Retrieves a list of files
     * @return Line break separated list of filenames
     */
    public static String getFiles()
    {
       return BittelFileManager.getFiles();
    }
    /**
     * Reads the content of a file in /sdcard/Android
     * @param filename filename of file to be read
     * @return contents of the file
     */
    public static String readFile(String filename)
    {
        return BittelFileManager.readFile(filename);
    }
    /**
     * Writes content to a file, if the file does not exist it will create a file named after the filename specified, but if it is already existing it will be overwritten
     * @param filename filename of the file to wirte on
     * @param content content to be written to the file
     */
    public static void writeFile(String filename, String content)
    {
        BittelFileManager.writeFile(filename,content);
    }
    /**
     * Writes an error log
     * @param fileName filename of the file to write the log concatenated with the date and time
     * @param ex the error to be written on the log
     */
    public static void writeError(String fileName, Throwable ex)
    {
        BittelFileManager.writeError(fileName,ex);
    }
    /**
     * Writes an untimed error log
     * @param fileName filename of the file to write the log
     * @param ex the error to be written on the log
     */
    public static void writeUntimedError(String fileName, Throwable ex)
    {
        BittelFileManager.writeUntimedError(fileName,ex);
    }
    /**
     * Writes an untimed log
     * @param fileName filename of the file to write the log
     * @param log log to be written
     */
    public static void writeUntimedLog(String fileName, String log)
    {
        BittelFileManager.writeUntimedLog(fileName,log);
    }
    //==============================================================================================
}
