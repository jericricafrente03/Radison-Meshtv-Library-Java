package com.ph.bittelasia.meshtv.tv.mtvlib.Transaction.Control;

import android.os.AsyncTask;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Constant.AppDataSource;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshCheckOutListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util.MeshAPIKeyRetriever;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Bill.MeshBillV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestService;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFood;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacility;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD;
import com.ph.bittelasia.meshtv.tv.mtvlib.Transaction.Model.MeshCartItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Transaction.Model.MeshTVCart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import io.realm.Realm;

/**
 * Created by mars on 12/22/17.
 */

class BittelCheckOutCartTask extends AsyncTask<Void,Void,Void>
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    static final String TAG = BittelCheckOutCartTask.class.getSimpleName();
    static final String LIVE_TRANS = "/index.php/apicall/meshtransaction/";
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    MeshCheckOutListener listener = null;
    boolean isSuccess = false;
    Class[] classes;
    int size = 0;
    boolean isDemo = true;
    //-----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Constructor=======================================
    public BittelCheckOutCartTask(MeshCheckOutListener listener,boolean isDemo,Class... c)
    {
        classes = c;
        this.listener = listener;
        this.isDemo = isDemo;
    }
    //==============================================================================================
    //===========================================LifeCycle==========================================
    @Override
    protected Void doInBackground(Void... voids)
    {
        ArrayList<MeshCartItem> items = new ArrayList<>();
        items.addAll(MeshTVCart.checkout(classes));
        Log.i(TAG,"isDemo:"+isDemo);
        Log.i(TAG,"items:"+items.size());
        if(isDemo)
        {
            Log.i(TAG,"Billing-DEMO");
            try
            {
                final Realm r = Realm.getDefaultInstance();

                for(final MeshCartItem i:items)
                {
                    size = r.where(MeshBillV2.class).findAll().size();
                    final MeshBillV2 v2 = new MeshBillV2();
                    v2.setId(size);
                    v2.setItem(i.getItemName());
                    v2.setDa(new Date().getTime());
                    v2.setPrice(i.getItemPrice()*i.getQuantity());
                    r.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            realm.insertOrUpdate(v2);
                        }
                    });
                }
                isSuccess = true;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                isSuccess =false;
            }

        }
        else
        {
            Log.i(TAG,"Billing-LIVE");
            try
            {
                for(final MeshCartItem i:items)
                {
                    String result = "";
                    URL url = new URL(
                            (MeshTVPreferenceManager.getHTTPHost(MeshTVApp.get().getApplicationContext())
                                    +":"
                                    +MeshTVPreferenceManager.getHTTPPort(MeshTVApp.get().getApplicationContext())
                                    +LIVE_TRANS
                                    +"/"+MeshAPIKeyRetriever.getAPIKey(MeshTVApp.get().getApplicationContext())
                                    +"/"+MeshTVPreferenceManager.getRoom(MeshTVApp.get().getApplicationContext())
                                    +"/"+getType(i.getItemClass())
                                    +"/"+i.getItemId()
                                    +"/"+i.getQuantity()
                                    +"/"+i.getItemPrice())
                                    .replaceAll("\\n",""));


                    Log.i(TAG,"BILLING:"+url.toString());
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(30000);
                    conn.setConnectTimeout(30000);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line = "";
                    StringBuilder responseOutput = new StringBuilder();
                    while((line = br.readLine()) != null )
                    {
                        responseOutput.append(line);
                    }
                    result =responseOutput.toString();
                    br.close();
                    conn.disconnect();
                }
                isSuccess = true;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                isSuccess =false;
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(isSuccess)
        {
            if(listener!=null)
            {
                listener.onSuccess("Success");
            }
        }
        else
        {
            if(listener!=null)
            {
                listener.onSuccess("Failed");
            }
        }
    }

    public String getType(Class c) {
        if (c == MeshFood.class) {
            return "fnb";
        } else if (c == MeshFacility.class) {
            return "facility";
        } else if (c == MeshShoppingItem.class) {
            return "shopping";
        } else if (c == MeshConciergeRequestItem.class) {
            return "item_request";
        } else if (c == MeshConciergeRequestService.class)
        {
            return "service_request";
        }
        else if (c== MeshVOD.class)
        {
            return "vod";
        }
        else
        {
            return "generic";
        }
    }
    //==============================================================================================
}
