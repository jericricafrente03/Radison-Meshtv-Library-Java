package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.Control;

import android.os.AsyncTask;
import android.util.Log;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MeshTVMediaClearTask extends AsyncTask <Void,Integer,Void>
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = MeshTVMediaClearTask.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    MediaClearListener listener;
    int fileCount = 0;
    File dir;
    int ctr = 0;
    ArrayList<String> files = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Constructor=======================================
    public MeshTVMediaClearTask(MediaClearListener listener)
    {
        Log.i(TAG,"Started MeshTVMediaClearTask : =============================================\n");
        this.listener = listener;
        Log.i(TAG,"Listener: "+(this.listener==null?"Not Found":"Found")+"\n");
        this.files = new ArrayList<>();
        Log.i(TAG,"List: "+(this.listener==null?"Not Found":"Initiated")+"\n");
    }
    //==============================================================================================
    //======================================MeshTVMediaClearTask====================================
    @Override
    protected Void doInBackground(Void... voids)
    {

        dir = new File("/storage/emulated/0/Android/");
        Log.i(TAG,"Directory: "+(this.dir!=null?"Found":"Not Found")+"\n");
        if(dir!=null)
        {
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name)
                {
                    return name.endsWith(".mp4");
                }
            };
            if(files==null)
            {
                files = new ArrayList<>();
            }
            files.addAll(Arrays.asList(dir.list(filter)));
            fileCount = files.size();
            Log.i(TAG,"Media to be deleted:"+fileCount);
            ctr = 0;
            for(String s:files)
            {
                Log.i(TAG,"--------------------------------------------------------------------\n");
                Log.i(TAG,"Deleting:"+s);
                File f = new File(dir,s+"\n");
                f.delete();
                ctr++;
                onProgressUpdate(ctr,fileCount);
                if(listener!=null)
                {
                    listener.onDeleted(s);
                }
                Log.i(TAG,"Deleted:"+s+"\n");
                Log.i(TAG,"--------------------------------------------------------------------\n");
            }
            onProgressUpdate();
        }
        else
        {
            Log.i(TAG,"Terminated could not find file directory\n");
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.i(TAG,""+ctr+"/"+fileCount);
        if(listener!=null)
        {
            listener.onProgress(ctr,fileCount);
        }

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.i(TAG,"Ending MeshTVMediaClearTask : =============================================+\n");
        listener.onDone();
    }

    //==============================================================================================
    //=============================================Listener=========================================
    public interface MediaClearListener
    {
        public abstract void onProgress(int done, int total);
        public abstract void onDeleted(String filename);
        public abstract void onDone();
    }
    //==============================================================================================
}
