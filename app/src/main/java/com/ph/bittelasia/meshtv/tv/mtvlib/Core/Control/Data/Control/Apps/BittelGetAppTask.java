package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Apps;

import android.os.AsyncTask;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshAppListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.FileReader.MeshTVFileManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Apps.MeshApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Retrieves the list of apps from /sdcard/Android/<SET_NAME>/app_desc.txt
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class BittelGetAppTask extends AsyncTask<Void,Void,Void>
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    public static final String TAG = BittelGetAppTask.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    /**
     * Listens if it was able to load the apps from the filesystem or not
     */
    private MeshAppListener listener = null;
    /**
     * List of apps loaded
     */
    private ArrayList<MeshApp> apps;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Constructor========================================

    /***
     * Default Constructor
     * @param listener Listens to the result of the request
     */
    public BittelGetAppTask(MeshAppListener listener)
    {
        this.listener = listener;
        this.apps = new ArrayList<>();
    }
    //==============================================================================================
    //============================================LifeCycle=========================================
    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids)
    {
        try {
            apps = new ArrayList<>();
            Log.i(TAG,"Getting Data From:"+"/" + MeshTVApp.get().getClass().getSimpleName() + "/app_desc.txt");
            String data = MeshTVFileManager.readFile("/" + MeshTVApp.get().getClass().getSimpleName() + "/app_desc.txt");
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("apps"));
            for (int ctr = 0; ctr < array.length(); ctr++)
            {
                MeshApp app = new MeshApp(array.getString(ctr));
                if(app.getEnabled()==1)
                {
                    apps.add(app);
                }

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
        if(apps.size()>0)
        {
            listener.onAppsLoaded(apps);
        }
        else
        {
            listener.onAppsNotFound();
        }
    }
    //==============================================================================================
}
