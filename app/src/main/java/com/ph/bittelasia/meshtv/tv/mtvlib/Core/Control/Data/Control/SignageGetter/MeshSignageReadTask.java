package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.SignageGetter;

import android.content.Context;
import android.os.AsyncTask;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners.MeshParamListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Settings.AppMode;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util.MeshAPIKeyRetriever;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

/**
 * Request to read messages
 * @author Mars Ray Canizares Araullo
 * <br>
 * Implements {@link MeshParamListener MeshParamListener} to set parameters for the API call
 * @version 1.0
 */
public class MeshSignageReadTask extends AsyncTask<Void,Void,Void> implements MeshParamListener
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = MeshSignageReadTask.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    /**
     * ID of message to be read
     */
    int message;
    /**
     * Result from the request
     */
    String result = null;
    /**
     * Required by {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.GET.MeshGET MeshSignageGET} - if set to null will use App Context
     */
    Context context;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Constructor=======================================

    /**
     * @param context Required by {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.GET.MeshGET MeshSignageGET} - if set to null will use App Context
     * @param id ID of message to be read
     */
    public MeshSignageReadTask(Context context, int id)
    {
        this.context = context;
        this.message = id;
    }
    //==============================================================================================
    //===========================================MeshSignageReadTask=======================================
    @Override
    protected Void doInBackground(Void... voids)
    {
        MeshSignageGET get = new MeshSignageGET();
        result=get.get(context,"read_message",this);
        return null;
    }
    //==============================================================================================
    //===========================================MeshParamListener==================================
    /**
     * Listens to MeshSignageGET if it is requesting for Parameters
     * @param source - current parameters
     * @return final parameters
     */
    @Override
    public String requestParams(String source)
    {
        source=source+"/"+ MeshAPIKeyRetriever.getAPIKey(context).replaceAll(":","").toLowerCase();
        if(MeshTVApp.get().getAppSettings().appMode()== AppMode.HOTEL)
        {
            source=source+"/"+ MeshTVPreferenceManager.getRoom(context);
        }
        else if(MeshTVApp.get().getAppSettings().appMode()== AppMode.TELECOM)
        {
            source=source+"/"+ MeshTVPreferenceManager.getAccountID(context);
        }
        source=source+"/"+ message;
        return source;
    }
    //==============================================================================================
}
