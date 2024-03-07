package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.FileReader;

import android.os.Build;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Reads files from USB
 * <br>Modes:
 * <br>1. Looks for either USB-A or USB-B for sdk < 23
 * <br>2. Looks for any attached USB for sdk >= 23
 * @author Mars Ray Canizares Araullo
 * @version  1.0
 */
class BittelDemoFileReader
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG                  = BittelDemoFileReader.class.getSimpleName();
    /**
     * Path of USB-A
     */
    public static final String PATH_TO_USB1         = "/storage/external_storage/sda1/";
    /**
     * Path of USB-B
     */
    public static final String PATH_TO_USB2         = "/storage/external_storage/sdb1/";
    /**
     * Path to /sdcard/Android/
     */
    public static final String PATH_TO_FS           = "/storage/emulated/0/Android/";
    /**
     * Storage for media files in the USB
     */
    public static final String MEDIA                = "media/";
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================

    /**
     * Retrieves the directory wher media files could be found
     * @return full path to the /media directory
     */
    static synchronized String getMediaPath()
    {
        if(Build.VERSION_CODES.M>android.os.Build.VERSION.SDK_INT)
        {
            File dir = new File(PATH_TO_USB1 + MEDIA);
            if (dir == null) {
                dir = new File(PATH_TO_USB2 + MEDIA);
            }
            else
            {
                return dir.getPath();
            }
            if (dir == null)
            {
                return null;
            }


        }
        else
        {
            File dir = null;


            for(String s:getUSBs())
            {
                dir = new File("/storage/"+s +"/"+MEDIA);
                if(dir!=null)
                {
                    Log.i(TAG,"Media DIR:"+"/storage/"+s+"/"+MEDIA);
                    return "/storage/"+s+"/"+MEDIA;
                }
            }

        }
        return null;
    }
    /**
     * Retrieves all attached USBs
     * @return List of USB names
     */
    private static synchronized ArrayList<String> getUSBs()
    {
        ArrayList<String> result = new ArrayList<>();

        File dir = new File("/storage/");
        if(dir.isDirectory())
        {
           result.addAll(Arrays.asList(dir.list())) ;
           result.remove("emulated");
           result.remove("self");
        }
        return result;

    }
    /**
     * Looks for a file from all the USB Paths
     * @param filename filename to search for
     * @return contents of the file
     */
    static String getFile(String filename)
    {
        File dir = new File(PATH_TO_FS+ MeshTVApp.get().getClass().getSimpleName());
        if(dir==null)
        {
            if(Build.VERSION_CODES.M>android.os.Build.VERSION.SDK_INT)
            {
                if(dir==null)
                {
                    dir = new File(PATH_TO_USB1+MeshTVApp.get().getClass().getSimpleName());
                }
                if(dir==null)
                {
                    dir = new File(PATH_TO_USB2+MeshTVApp.get().getClass().getSimpleName());
                }
            }
            else
            {
                dir = null;

                for(String s:getUSBs())
                {
                    dir = new File("/storage/"+s + "/"+MeshTVApp.get().getClass().getSimpleName());
                    if(dir!=null)
                    {
                        break;
                    }
                }
            }
        }


        Log.i(TAG,"DIR:"+dir.getPath());
        if(dir!=null)
        {
            String result = null;
            File file = new File(dir,filename);
            try
            {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                StringBuilder text = new StringBuilder();
                while ((line = br.readLine()) != null)
                {
                    text.append(line);
                    text.append('\n');
                }
                result = text.toString();
                br.close();

            }
            catch (IOException e)
            {
                e.printStackTrace();
                Log.e(TAG,"getFile("+filename+"):"+e.getMessage()+"");
            }
            Log.i(TAG,"getFile("+filename+"):"+result);
            return result;
        }
        else
        {
            Log.e(TAG,"getFile("+filename+")");
            return null;
        }
    }
    //==============================================================================================
}
