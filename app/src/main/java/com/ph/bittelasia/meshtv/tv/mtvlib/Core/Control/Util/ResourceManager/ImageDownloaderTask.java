package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.ResourceManager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;


import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
/**
 * Looks for the file from the file system first and if not found will load from the URL provided
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
class ImageDownloaderTask extends AsyncTask<Void,Void,Void>
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = ImageDownloaderTask.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    /**
     * Url of the image
     */
    String url;
    /**
     * Filename of the image
     */
    String fileName;
    /**
     * File if found in File System
     */
    File cacheFile;
    /**
     * Resulting Bitmap
     */
    Bitmap bitmap;
    /**
     * WeakReference to the ImageView that will display the BitMap
     */
    WeakReference<ImageView> imageViewWeakReference;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================Constructor==========================================
    /**
     *Default Constructor
     * @param iv imageview that would display the result
     * @param url url of the file to be downloaded
     * @param fileName filename to be searched from file system
     */
    public ImageDownloaderTask(ImageView iv, String url, String fileName)
    {
        this.url = url;
        this.fileName = fileName;
        this.imageViewWeakReference = new WeakReference<ImageView>(iv);
        Log.i(TAG,"Downloading:"+url);
        Log.i(TAG,"Downloading->"+fileName);
    }
    //==============================================================================================
    //==========================================LifeCycle===========================================
    @Override
    protected Void doInBackground(Void... params)
    {
        try
        {
            bitmap =  MeshTVApp.get().getCachedBitmap(fileName);
            if(bitmap==null)
            {
                find();
                if(bitmap==null)
                {

                    URL wallpaperURL = new URL(url);
                    URLConnection connection = wallpaperURL.openConnection();
                    Log.i(TAG,"DOWNLOADING-IMAGE:"+url);
                    InputStream inputStream = new BufferedInputStream(connection.getInputStream(), 10240);
                    File cacheDir = new File("/storage/emulated/0/Android/");
                    cacheFile = new File(cacheDir,fileName);
                    FileOutputStream outputStream = new FileOutputStream(cacheFile);
                    byte buffer[] = new byte[1024];
                    int dataSize;
                    int loadedSize = 0;
                    while ((dataSize = inputStream.read(buffer)) != -1)
                    {
//                loadedSize += dataSize;
//                publishProgress(loadedSize);
                        outputStream.write(buffer, 0, dataSize);
                    }

                    outputStream.close();
                    bitmap = BitmapFactory.decodeFile(cacheFile.getAbsolutePath());
                }
                else
                {
                }
                MeshTVApp.get().addBitmapToCache(fileName,bitmap);
            }
            else
            {
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid)
    {
        super.onPostExecute(aVoid);
        if(imageViewWeakReference.get()!=null)
        {
            if(bitmap!=null)
            {
                imageViewWeakReference.get().setImageBitmap(bitmap);
            }
            else
            {
            }
        }
        else
        {
        }
    }
    //==============================================================================================
    //============================================Method============================================
    /**
     * Looks for the File corresponding to the filename
     */
    public void find() {
        File cacheDir = new File("/storage/emulated/0/Android/");
        if (cacheDir != null)
        {
            File[] files = cacheDir.listFiles();
            for (int i = 0; i < files.length; i++)
            {

                if (files[i].getName().toLowerCase().equals(fileName))
                {
                    bitmap = BitmapFactory.decodeFile(files[i].getAbsolutePath());
                }
            }
        }
    }
    //==============================================================================================

}
