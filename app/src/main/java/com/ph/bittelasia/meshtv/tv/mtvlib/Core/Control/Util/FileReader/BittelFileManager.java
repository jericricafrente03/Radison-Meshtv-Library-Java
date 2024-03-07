package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.FileReader;

import android.content.Context;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.ResourceManager.MeshResourceManager;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Reads files from the STBs File System
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
class BittelFileManager
{
    //==========================================Variable============================================
    //------------------------------------------Constant--------------------------------------------
    static final String TAG                              =  BittelFileManager.class.getSimpleName();
    static final String DATE_FORMAT                      = "MMM-dd-yyyy-hh-mm-ss-aa";
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================Methods=============================================
    /**
     * Clears all error logs for maintenance purposes
     */
    static void deleteErrorLogs()
    {
        File dir = null;
        dir = new File("/storage/emulated/0/Android/");
        dir.mkdirs();
        if(dir.isDirectory())
        {
            for(int ctr = 0;ctr<dir.listFiles().length;ctr++)
            {
                if(dir.listFiles()[ctr].getName().toLowerCase().endsWith("error.txt"))
                {
                    dir.listFiles()[ctr].delete();
                }
            }
        }
    }

    /**
     * Deletes a file from /sdcard/Android that matches the filename
     * @param filename filename of the file to be deleted
     */
    static void deleteFile(String filename)
    {
        File dir = null;
        dir = new File("/storage/emulated/0/Android/");
        dir.mkdirs();
        if(dir.isDirectory())
        {
            for(int ctr = 0;ctr<dir.listFiles().length;ctr++)
            {
                if(dir.listFiles()[ctr].getName().toLowerCase().equals(filename))
                {
                    dir.listFiles()[ctr].delete();
                }
            }
        }
    }
    /**
     * Retrieves a list of files
     * @return Line break separated list of filenames
     */
    static String getFiles()
    {
        String result = "";
        try
        {
            File dir = null;
            dir = new File("/storage/emulated/0/Android/");
            dir.mkdirs();
            if(dir.isDirectory())
            {
                for(int ctr = 0;ctr<dir.listFiles().length;ctr++)
                {
                    result = result+dir.listFiles()[ctr].getName()+"\n";
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * Reads the content of a file in /sdcard/Android
     * @param filename filename of file to be read
     * @return contents of the file
     */
    static String readFile(String filename)
    {


        File sdcard = null;
        sdcard = new File("/storage/emulated/0/Android/");
        File file = new File(sdcard,filename.toLowerCase());
        StringBuilder text = new StringBuilder();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null)
            {
                text.append(line);
                text.append('\n');
            }
            br.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return text.toString();

    }
    /**
     * Writes content to a file, if the file does not exist it will create a file named after the filename specified, but if it is already existing it will be overwritten
     * @param filename filename of the file to wirte on
     * @param content content to be written to the file
     */
    static void writeFile(String filename, String content)
    {

        FileOutputStream fos;
        try
        {
            File dir = null;
            dir = new File("/storage/emulated/0/Android/");
            dir.mkdirs();
            File file = new File(dir,filename.toLowerCase());
            if(file==null)
            {
                file.createNewFile();
            }
            FileOutputStream fOut = new FileOutputStream(file.getPath());
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(content.toString());
            myOutWriter.close();
            fOut.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    /**
     * Writes an error log
     * @param fileName filename of the file to write the log concatenated with the date and time
     * @param ex the error to be written on the log
     */
    static void writeError(String fileName, Throwable ex)
    {
        FileOutputStream fos;
        try
        {
            File dir = null;
            dir = new File("/storage/emulated/0/Android/");
            dir.mkdirs();
            File file = new File(dir,fileName+new SimpleDateFormat("MM-dd-yy.HH-mm-ss").format(new Date())+".txt");
            if(file==null)
            {
                file.createNewFile();
            }
            FileOutputStream fOut = new FileOutputStream(file.getPath());
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(fileName+" Crash Report:");
            myOutWriter.append(new Date().toString());
            myOutWriter.append("\n");
            myOutWriter.append(ex.toString());
            myOutWriter.append("\n");

            for(int ctr=0;ctr<ex.getStackTrace().length;ctr++)
            {
                myOutWriter.append("\n"+ex.getStackTrace()[ctr].toString());
            }

            for(int ctr=0;ctr<ex.getCause().getStackTrace().length;ctr++)
            {
                myOutWriter.append("\n ["+ctr+"]File:"+ex.getCause().getStackTrace()[ctr].getFileName());
                myOutWriter.append("\n ["+ctr+"]Method:"+ex.getCause().getStackTrace()[ctr].getMethodName());
                myOutWriter.append("\n ["+ctr+"]Line:"+ex.getCause().getStackTrace()[ctr].getLineNumber());

            }

            myOutWriter.append("\nCause:"+ex.getCause());
            myOutWriter.append("\nMessage:"+ex.getLocalizedMessage());


            myOutWriter.close();
            fOut.close();
        }
        catch (Exception e)
        {e.printStackTrace();}
    }
    /**
     * Writes an untimed error log
     * @param fileName filename of the file to write the log
     * @param ex the error to be written on the log
     */
    static void writeUntimedError(final String fileName, final Throwable ex)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                FileOutputStream fos;
                try {
                    File dir = null;
                    dir = new File("/storage/emulated/0/Android/");

                    dir.mkdirs();
                    File file = new File(dir,fileName+".txt");
                    Log.i("FILE",file.getAbsolutePath());
                    if(file==null)
                    {
                        file.createNewFile();
                    }
                    FileOutputStream fOut = new FileOutputStream(file.getPath());
                    //   FileOutputStream fOut = openFileOutput(file.getName(),MODE_APPEND);
                    OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                    myOutWriter.append(fileName+" Crash Report:");
                    myOutWriter.append(new Date().toString());
                    myOutWriter.append("\n");
                    myOutWriter.append(ex.toString());
                    myOutWriter.append("\n");

                    for(int ctr=0;ctr<ex.getStackTrace().length;ctr++)
                    {
                        myOutWriter.append("\n"+ex.getStackTrace()[ctr].toString());
                    }

                    for(int ctr=0;ctr<ex.getCause().getStackTrace().length;ctr++)
                    {
                        myOutWriter.append("\n ["+ctr+"]File:"+ex.getCause().getStackTrace()[ctr].getFileName());
                        myOutWriter.append("\n ["+ctr+"]Method:"+ex.getCause().getStackTrace()[ctr].getMethodName());
                        myOutWriter.append("\n ["+ctr+"]Line:"+ex.getCause().getStackTrace()[ctr].getLineNumber());

                    }

                    myOutWriter.append("\nCause:"+ex.getCause());
                    myOutWriter.append("\nMessage:"+ex.getLocalizedMessage());


                    myOutWriter.close();
                    fOut.close();
                }
                catch (Exception e)
                {e.printStackTrace();}
            }
        }).run();

    }
    /**
     * Writes an untimed log
     * @param fileName filename of the file to write the log
     * @param log log to be written
     */
    static void writeUntimedLog(final String fileName, final String log)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("log", log);
                FileOutputStream fos;
                try {
                    File dir = null;
                    dir = new File("/storage/emulated/0/Android/");
                    dir.mkdirs();
                    File file = new File(dir,fileName+".txt");
                    Log.i("FILE",file.getAbsolutePath());
                    boolean isNew = false;
                    if(file==null)
                    {
                        file.createNewFile();
                        isNew = true;
                    }
                    else
                    {
                        if((file.length()/1024)/1024>10)
                        {
                            file.delete();
                            file.createNewFile();
                            isNew = true;
                        }

                    }
                    if(isNew)
                    {
                        FileOutputStream fOut = new FileOutputStream(file.getPath());
                        OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                        myOutWriter.append(fileName+" Log:");
                        myOutWriter.append(new Date().toString());
                        myOutWriter.append("\n");
                        myOutWriter.append(new SimpleDateFormat("MM-dd-yy.HH-mm-ss").format(new Date())+":"+log);
                        myOutWriter.close();
                        fOut.close();
                    }
                    else
                    {
                        FileWriter fw = new FileWriter(file,true);
                        fw.append("\n");
                        fw.append(new SimpleDateFormat("MM-dd-yy.HH-mm-ss").format(new Date())+":"+log);
                        fw.close();
                    }



                    //   FileOutputStream fOut = openFileOutput(file.getName(),MODE_APPEND);

                }
                catch (Exception e)
                {e.printStackTrace();}
            }
        }).run();

    }
    //==============================================================================================
    //==========================================Check if Exists=====================================

    /**
     * Checks if the file is already existing in /sdcard/Android
     * @param fileName filename to be searched
     * @return
     * Results:
     * <br><br>
     * true - if the file exists
     * false - if the file does not exist
     */
    static boolean isExisting(String fileName)
    {
        try
        {
            File dir = null;
            dir = new File("/storage/emulated/0/Android/");
            dir.mkdirs();
            File file = new File(dir,fileName);

            if(file.length()<1)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    //==============================================================================================

    //==========================================Get From Raw========================================

    /**
     * Load file from the raw folder
     * @param context required to get resources
     * @param resid the id of the raw file to be read
     * @return the String content of the raw resource
     */
    static String loadFile(Context context, int resid) throws IOException
    {
        InputStream iS;
        int rID = resid;
        iS = context.getResources().openRawResource(rID);
        //create a buffer that has the same size as the InputStream
        byte[] buffer = new byte[iS.available()];
        //read the text file as a stream, into the buffer
        iS.read(buffer);
        //create a output stream to write the buffer into
        ByteArrayOutputStream oS = new ByteArrayOutputStream();
        //write this buffer to the output stream
        oS.write(buffer);
        //Close the Input and Output streams
        oS.close();
        iS.close();
        //return the output stream as a String
        return oS.toString();
    }
    //==============================================================================================
}
