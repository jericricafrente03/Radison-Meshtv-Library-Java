package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.Control;

import android.os.AsyncTask;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaV2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MeshVideoManager {

    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static String TAG = MeshVideoManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Static-------------------------------------------
    private static MeshVideoManager manager = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Static===========================================
    public static final MeshVideoManager get()
    {
        if(manager==null)
        {
            manager = new MeshVideoManager();
        }
        return manager;
    }
    //==============================================================================================
    //============================================Constructor=======================================
    private MeshVideoManager()
    {

    }
    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Action------------------------------------------

    public void download(DownloadListener listener, String url)
    {
        new DownloadTask(listener,url).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
    public void downloadMultiple(DownloadMultipleListener listener, ArrayList<String> urls)
    {
        new DownloadMultipleTask(listener,urls).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
    public void clearVideos(DeleteListener listener)
    {
        new DeleteTask(listener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
//    public void on()
//    {
//        MeshVideoManager.get().clearVideos(new com.ph.bittelasia.meshtv.tv.mtvlib.Video.Control.MeshVideoManager.DeleteListener() {
//            @Override
//            public void onAllFilesDeleted()
//            {
//                Log.i(TAG, "Videos Clearead");
//                for(Object o:os)
//                {
//
//                    MeshMediaV2 mv2 = (MeshMediaV2) o;
//                    Log.i(TAG, "Downloading:"+mv2.getUrl());
//                    com.ph.bittelasia.meshtv.tv.mtvlib.Video.Control.MeshVideoManager.get().download(mv2.getUrl());
//                }
//            }
//        });
//    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================DeleteTask========================================
    public interface DeleteListener
    {
        public abstract void onAllFilesDeleted();
    }
    public class DeleteTask extends AsyncTask<Void,Void,Void>
    {
        DeleteListener deleteListener = null;

        public DeleteTask(DeleteListener deleteListener)
        {
            this.deleteListener = deleteListener;
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            File cacheDir = new File("/storage/emulated/0/Android/");
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name)
                {
                    return name.endsWith(".mp4");
                }
            };
            for(String s:cacheDir.list(filter))
            {
                File f = new File(cacheDir,s);
                f.delete();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            this.deleteListener.onAllFilesDeleted();
        }
    }
    //==============================================================================================
    //============================================DownloadTask======================================
    public interface DownloadListener
    {
        public abstract void onFileDownloaded();
    }
    public class DownloadTask extends AsyncTask<Void,Void,Void>
    {

        String url = null;
        String fileName = null;
        File cacheFile;
        DownloadListener listener;

        public DownloadTask(DownloadListener listener,String url)
        {
            this.listener = listener;
            this.url = url;
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            fileName = getFilename();
            try
            {
                if(fileName.toLowerCase().endsWith("mp4"))
                {
                    URL wallpaperURL = new URL(url);
                    URLConnection connection = wallpaperURL.openConnection();
                    InputStream inputStream = new BufferedInputStream(connection.getInputStream(), 10240);
                    File cacheDir = new File("/storage/emulated/0/Android/");
                    cacheFile = new File(cacheDir,fileName);
                    FileOutputStream outputStream = new FileOutputStream(cacheFile);
                    byte buffer[] = new byte[1024];
                    int dataSize;
                    while ((dataSize = inputStream.read(buffer)) != -1)
                    {
                        outputStream.write(buffer, 0, dataSize);
                    }

                    outputStream.close();
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            listener.onFileDownloaded();
        }

        private String getFilename()
        {

            String[] urlDivided = url.split("/");
            return urlDivided[urlDivided.length-1];
        }

    }
    //==============================================================================================
    //=========================================DownloadMultipleTask==================================
    public interface DownloadMultipleListener
    {
        public abstract void onFilesDownloaded();
    }
    public class DownloadMultipleTask extends AsyncTask<Void,Void,Void>
    {

        String url = null;
        String fileName = null;
        File cacheFile;
        ArrayList<String> urls;
        DownloadMultipleListener listener;

        public DownloadMultipleTask(DownloadMultipleListener listener,ArrayList<String> urls)
        {
            this.urls = new ArrayList<>();
            this.urls.addAll(urls);
            this.listener = listener;
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            for(String u :urls)
            {
                url = u;
                fileName = getFilename();
                try
                {

                    URL wallpaperURL = new URL(url);
                    URLConnection connection = wallpaperURL.openConnection();
                    InputStream inputStream = new BufferedInputStream(connection.getInputStream(), 10240);
                    File cacheDir = new File("/storage/emulated/0/Android/");
                    cacheFile = new File(cacheDir,fileName);
                    FileOutputStream outputStream = new FileOutputStream(cacheFile);
                    byte buffer[] = new byte[1024];
                    int dataSize;
                    while ((dataSize = inputStream.read(buffer)) != -1)
                    {
                        outputStream.write(buffer, 0, dataSize);
                    }

                    outputStream.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            listener.onFilesDownloaded();
        }

        private String getFilename()
        {

            String[] urlDivided = url.split("/");
            return urlDivided[urlDivided.length-1];
        }

    }
    //==============================================================================================
}
