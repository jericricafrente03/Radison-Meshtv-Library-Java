package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.POST;

import android.content.Context;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners.MeshParamListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
/**
 * Class that requests POST API calls to the server
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
final class MeshPOST
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    static final String TAG = MeshPOST.class.getSimpleName();
    /**
     * Directory of API Calls in the MeshTVServer
     */
    static final String DIR      = "/index.php/apicall/";
    /**
     * API to register STB to server
     */
    static final String REGISTER = "stb_register";
    static final String SUBSCRIBE = "device_register";
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Constructor======================================
    //==============================================================================================
    //==============================================Method==========================================
    /**
     * Post data to the server and waits for a response
     * @param context - retrieves App Context if null
     * @param api - API to be requested
     * @param listener - retrieves parameters from the asynchronous task implementing {@link MeshParamListener MeshParamListener} that invoked this method
     * @return response of API call
     */
    public final String post(Context context, String api, MeshParamListener listener)
    {

        String result = null;
        if(context==null)
        {
            context = MeshTVApp.get().getApplicationContext();
        }

        String source =
                MeshTVPreferenceManager.getHTTPHost(context)
                +":"
                +MeshTVPreferenceManager.getHTTPPort(context)
                +DIR
                +api;

        source = listener.requestParams(source);
        try
        {
            Log.i(TAG,"POSTING:"+source.replaceAll("\\n",""));
            URL url = new URL(source.replaceAll("\\n",""));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(MeshTVPreferenceManager.getTimeOut(context));
            conn.setConnectTimeout(MeshTVPreferenceManager.getConnectionTimeout(context));
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.flush();
            writer.close();
            os.close();
            final StringBuilder output = new StringBuilder("Request URL " + url);
            HashMap<String,String> params = new HashMap<>();
            output.append(System.getProperty("line.separator") + "Request Parameters " + getQuery(params));
            output.append(System.getProperty("line.separator")  + "Response Code " + conn.getResponseCode());
            output.append(System.getProperty("line.separator")  + "Type " + "POST");
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
            e.printStackTrace();
            return e.getMessage();
        }

        return result;
    }

    /**
     * Generates paramaeters
     * @param params HashMap of parameters to be added to the request
     * @return URL encoded parameters
     * @throws UnsupportedEncodingException
     */
    private String getQuery(HashMap<String,String> params) throws UnsupportedEncodingException
    {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (String key : params.keySet())
        {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(params.get(key), "UTF-8"));
        }

        return result.toString();
    }
    //==============================================================================================
}
