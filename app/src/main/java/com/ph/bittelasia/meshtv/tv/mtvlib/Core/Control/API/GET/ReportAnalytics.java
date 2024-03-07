package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.GET;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners.MeshParamListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners.MeshRequestListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util.MeshAPIKeyRetriever;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Statistics.MeshStat;

import io.realm.Realm;
import io.realm.RealmResults;
/**
 * Reports Analytics Data to server
 * {@link MeshStat MeshStat}
 * <br>
 * Implements {@link MeshParamListener MeshParamListener} to set parameters for the API call
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public final class ReportAnalytics extends AsyncTask<Void,Void,String> implements MeshParamListener
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = ReportAnalytics.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    /**
     * Stat to be reported
     */
    private MeshStat stat = null;
    /**
     * Listens for the result of the request
     */
    MeshRequestListener listener = null;
    /**
     * Required by {@link MeshGET MeshGET} - if set to null will use App Context
     */
    Context context = null;
    /**
     * Used as a reference for inner classes
     */
    MeshParamListener param = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Constructor========================================
    /**
     * Default constructor
     * @param context -  required to request data from server
     * @param listener - listens for request results
     */
    public ReportAnalytics(Context context, MeshRequestListener listener)
    {
        param = this;
        this.stat = stat;
        if (context == null)
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
    //============================================LifeCycle=========================================
    @Override
    protected final String doInBackground(Void... voids)
    {
            Realm r  = Realm.getDefaultInstance();
        r.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<MeshStat> stats = realm.where(MeshStat.class).findAll();
                Log.i(TAG,"Reporting:"+stats.size());
                for(MeshStat s:stats)
                {
                    Log.i(TAG,"Reporting:"+s.getType()+"("+s.getItem_id()+")");
                    stat=s;
                    MeshGET get = new MeshGET();
                    get.get(context, "stb_analytics", param);
                }
                realm.delete(MeshStat.class);
            }
        });
        return null;
    }
    @Override
    protected final void onPostExecute(String s)
    {

    }
    //==============================================================================================
    //============================================MeshParamListener=================================
    /**
     * Listens to MeshGET if it is requesting for Parameters
     * @param url - current parameters
     * @return final parameters
     */
    @Override
    public final String requestParams(String url) {
        url=url+"/"+ MeshAPIKeyRetriever.getAPIKey(context).replaceAll(":","").toLowerCase();
        url=url+"/"+stat.getType();
        url=url+"/"+stat.getItem_id();
        url=url+"/"+stat.getTick();
        Log.i(TAG,"Reporting:"+stat.getType()+"("+stat.getItem_id()+") @ "+stat.getTick());
        return url;

    }
    //==============================================================================================

}
