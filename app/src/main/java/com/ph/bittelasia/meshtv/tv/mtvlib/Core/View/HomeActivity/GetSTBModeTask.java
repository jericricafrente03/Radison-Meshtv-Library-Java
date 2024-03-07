package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.HomeActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util.MeshAPIKeyRetriever;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetSTBModeTask extends AsyncTask<Void,Void,Void>
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG                      = GetSTBModeTask.class.getSimpleName();
    public static final String STB_MODE                 = "mode";
    public static final int DIGITAL_OFFLINE             = 0;
    public static final int DIGITAL_IPTV                = 1;
    public static final int DIGITAL_SIGNAGE             = 2;
    public static final String DIGITAL_OFFLINE_TEXT     = "0";
    public static final String DIGITAL_IPTV_TEXT        = "1";
    public static final String DIGITAL_SIGNAGE_TEXT     = "2";
    static final String DIR                             = "/index.php/apicall/";
    static final String API                             = "get_stb_mode";
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    STBModeListener listener;
    int mode = DIGITAL_OFFLINE;
    String result = null;
    Context context;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Constructor========================================
    public GetSTBModeTask(STBModeListener listener)
    {
        this.listener = listener;
    }
    //==============================================================================================
    //============================================AsyncTask=========================================
    @Override
    protected Void doInBackground(Void... voids)
    {



        result = null;
        if(context==null)
        {
            context = MeshTVApp.get().getApplicationContext();
        }

        String source =
                MeshTVPreferenceManager.getHTTPHost(context)
                        +":"
                        +MeshTVPreferenceManager.getHTTPPort(context)
                        +DIR
                        +API
                        +"/"+ MeshAPIKeyRetriever.getAPIKey(context).replaceAll(":","").toLowerCase();
//
//        source = listener.requestParams(source);
        try
        {
            Log.i(TAG,"GETTING:"+source);
            URL url = new URL(source.replaceAll("\\n",""));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(MeshTVPreferenceManager.getTimeOut(context));
            conn.setConnectTimeout(MeshTVPreferenceManager.getConnectionTimeout(context));
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            StringBuilder responseOutput = new StringBuilder();

            while((line = br.readLine()) != null ) {
                responseOutput.append(line);
            }
            result =responseOutput.toString();
        }
        catch (Exception e)
        {
            result = "{\"mode\":\"1\"}";
            e.printStackTrace();
        }


        try
        {
            JSONObject object = new JSONObject(result);
            mode = getMode(object.getString(STB_MODE));
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
        if(listener!=null)
        {
            switch (mode)
            {
                case DIGITAL_OFFLINE:
                    listener.onOffline();
                    break;
                case DIGITAL_IPTV:
                    listener.onIPTV();
                    break;
                case DIGITAL_SIGNAGE:
                    listener.onDigitalSignage();
                    break;
            }
        }

    }

    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Getter------------------------------------------
    public int getMode(String mode)
    {
        switch (mode)
        {
            case DIGITAL_OFFLINE_TEXT:
                return DIGITAL_OFFLINE;
            case DIGITAL_IPTV_TEXT:
                return DIGITAL_IPTV;
            case DIGITAL_SIGNAGE_TEXT:
                return DIGITAL_SIGNAGE;
        }

        return DIGITAL_OFFLINE;
    }

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Listener=========================================
    public interface STBModeListener
    {
        public abstract void onDigitalSignage();
        public abstract void onIPTV();
        public abstract void onOffline();
    }
    //==============================================================================================
}
