package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.GET;

import android.content.Context;
import android.os.AsyncTask;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners.MeshParamListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners.MeshRequestListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util.MeshAPIKeyRetriever;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

/**
 * Requests for Map Category Data
 * {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory MeshVCCategory}
 * <br>
 * Implements {@link MeshParamListener MeshParamListener} to set parameters for the API call
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshGetVCCategoryTask extends AsyncTask<Void,Void,String> implements MeshParamListener {

    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = MeshGetVCCategoryTask.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    /**
     * Listens for the result of the request
     */
    MeshRequestListener listener = null;
    /**
     * Required by {@link MeshGET MeshGET} - if set to null will use App Context
     */
    Context context = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Constructor=====================================
    /**
     * Default constructor
     * @param context -  required to request data from server
     * @param listener - listens for request results
     */
    public MeshGetVCCategoryTask(Context context, MeshRequestListener listener) {
        if (context == null) {
            this.context = MeshTVApp.get().getApplicationContext();

        } else {
            this.context = context;
        }
        this.listener = listener;
    }

    //==============================================================================================
    //===============================================LifeCycle======================================
    @Override
    protected String doInBackground(Void... voids) {

        MeshGET get = new MeshGET();
        return get.get(context, MeshGET.MAP_CATEGORIES, this);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(listener!=null)
        {
            listener.onResult(s);
        }


    }

    //==============================================================================================
    //============================================MeshParamListener=================================
    /**
     * Listens to MeshGET if it is requesting for Parameters
     * @param url - current parameters
     * @return final parameters
     */
    @Override
    public String requestParams(String url) {
        return url=url+"/"+ MeshAPIKeyRetriever.getAPIKey(context).replaceAll(":","").toLowerCase();
    }
    //==============================================================================================
}
