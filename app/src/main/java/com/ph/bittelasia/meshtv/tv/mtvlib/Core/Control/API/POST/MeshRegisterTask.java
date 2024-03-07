package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.POST;

import android.content.Context;
import android.os.AsyncTask;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners.MeshParamListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners.MeshRequestListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util.MeshAPIKeyRetriever;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
/**
 * Registers STB to the Server
 * <br>
 * Implements {@link MeshParamListener MeshParamListener} to set parameters for the API call
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshRegisterTask extends AsyncTask<Void,Void,String> implements MeshParamListener
{
    //==========================================Variable============================================
    //------------------------------------------Constant--------------------------------------------
    public static final String TAG = MeshRegisterTask.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Instance--------------------------------------------
    MeshRequestListener listener = null;
    Context context = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================Constructor=========================================
    /**
     * Default constructor
     * @param context -  required to request data from server
     * @param listener - listens for request results
     */
    public MeshRegisterTask(Context context, MeshRequestListener listener)
    {
        if(context==null)
        {
            this.context = MeshTVApp.get().getApplicationContext();

        }
        else
        {
            this.context = context;
        }
        this.listener = listener;
    }
    //==============================================================================================
    //===========================================LifeCycle==========================================
    @Override
    protected String doInBackground(Void... voids)
    {
        MeshPOST post = new MeshPOST();
        return  post.post(context,MeshPOST.REGISTER,this);
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        if(listener!=null)
        {
            listener.onResult(s);
        }

    }
    //==============================================================================================
    //========================================MeshParamListener=====================================
    /**
     * Listens to MeshPOST if it is requesting for Parameters
     * @param url - current parameters
     * @return final parameters
     */
    @Override
    public String requestParams(String url)
    {
        url=url+"/"+ MeshAPIKeyRetriever.getAPIKey(context).replaceAll(":","").toLowerCase();
        url=url+"/"+ MeshAPIKeyRetriever.getMAC(context).replaceAll(":","").toLowerCase();
        url=url+"/"+ MeshTVPreferenceManager.getRoom(context);
        return url;
    }
    //==============================================================================================
}
