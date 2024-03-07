package com.ph.bittelasia.meshtv.tv.mtvlib.Installer.Control;

import android.os.AsyncTask;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.FileReader.MeshTVFileManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

import org.json.JSONObject;

/**
 * Created by Mars on 3/20/2018.
 */

public class InstallerSaveConfigurationTask extends AsyncTask<Void,Void,Boolean>
{
    //========================================Variable==============================================
    //----------------------------------------Constant----------------------------------------------
    public static final String TAG = InstallerSaveConfigurationTask.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------Instance---------------------------------------------
    String account_id;
    String full_server = null;
    String server = null;
    String xmpp = null;
    int port = -1;
    MeshInstallerListener listener;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================Constructor==========================================
    public InstallerSaveConfigurationTask(MeshInstallerListener listener,String account_id)
    {
        this.account_id = account_id;
        this.listener = listener;
    }
    public InstallerSaveConfigurationTask(MeshInstallerListener listener,String account_id,String full_server)
    {
        this.account_id = account_id;
        this.listener = listener;
        this.full_server = full_server;
    }
    //==============================================================================================
    //========================================LifeCycle=============================================
    @Override
    protected Boolean doInBackground(Void... voids)
    {
        boolean result = false;
        String r = MeshTVFileManager.readFile(MeshTVApp.get().getFSPath()+"/iptv_xmpp.txt");
        try
        {
            JSONObject object = new JSONObject(r);
            object.put("APIKeyPreference_PREF_ROOM",account_id);
            object.put("XMPPPreference_USERNAME",account_id);
            if(full_server!=null)
            {
                port = Integer.valueOf(full_server.split(":")[2]);
                object.put("HTTPPreference_PORT",port);
                server =full_server.split(":")[0]+full_server.split(":")[1];
                object.put("HTTPPreference_HOST",port);
                xmpp = full_server.split(":")[1].replaceAll("/","");
                object.put("XMPPPreference_HOST",port);
            }
            MeshTVFileManager.writeFile(MeshTVApp.get().getFSPath()+"/iptv_xmpp.txt",object.toString());
            MeshTVPreferenceManager.updateIPTV(null);
            MeshTVPreferenceManager.setAccountID(null,account_id);
            result = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
    @Override
    protected void onPostExecute(Boolean result)
    {
        super.onPostExecute(result);
        if(result)
        {
            listener.onConfigurationSaved();
        }
        else
        {
            listener.onConfigurationFailedToSave();
        }
    }
    //==============================================================================================
}
