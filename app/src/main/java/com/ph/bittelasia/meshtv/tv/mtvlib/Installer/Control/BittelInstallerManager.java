package com.ph.bittelasia.meshtv.tv.mtvlib.Installer.Control;

import android.os.AsyncTask;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners.MeshRequestListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.POST.MeshRegisterTask;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.POST.MeshSubscribeTask;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Settings.AppMode;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

public class BittelInstallerManager implements MeshInstallerListener
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = BittelInstallerManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Static-------------------------------------------
    private static BittelInstallerManager manager;
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    MeshInstallerListener listener;
    String accesscode;
    String account;
    String server;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Static=========================================
    static BittelInstallerManager get()
    {
        if(manager==null)
        {
            manager = new BittelInstallerManager();
        }
        return manager;
    }
    //==============================================================================================
    //=============================================Constructor======================================
    BittelInstallerManager()
    {

    }
    //==============================================================================================
    //=============================================Method===========================================
    void startInstall(MeshInstallerListener listener,String accesscode,String account)
    {
        this.listener = listener;
        this.account = account;
        this.accesscode = accesscode;
        this.server = MeshTVPreferenceManager.getHTTPHost(null)+":"+ MeshTVPreferenceManager.getHTTPPort(null);
        confirmAccessCode();
    }
    void startInstall(MeshInstallerListener listener,String accesscode,String account,String server)
    {
        this.listener = listener;
        this.account = account;
        this.accesscode = accesscode;
        this.server = server;
        confirmAccessCode();
    }
    private void confirmAccessCode()
    {
        InstallerConfirmationTask confirmationTask = new InstallerConfirmationTask(this,accesscode);
        confirmationTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
    }
    private void saveConfiguration()
    {
        if(this.server.equals(MeshTVPreferenceManager.getHTTPHost(null)+":"+ MeshTVPreferenceManager.getHTTPPort(null)))
        {
            InstallerSaveConfigurationTask saveConfigurationTask = new InstallerSaveConfigurationTask(this,account);
            saveConfigurationTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
        }
        else
        {
            InstallerSaveConfigurationTask saveConfigurationTask = new InstallerSaveConfigurationTask(this,account,this.server);
            saveConfigurationTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
        }

    }
    private void register()
    {
        Log.i(TAG,"Trying to register:"+account);
        if(MeshTVApp.get().getAppSettings().appMode()== AppMode.TELECOM)
        {
            Log.i(TAG,"Detected Telecom App");
            new MeshSubscribeTask(MeshTVApp.get().getBaseContext(), new MeshRequestListener() {
                @Override
                public void onFailed(String s) {

                }

                @Override
                public void onResult(String s) {

                }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
        }
        else if(MeshTVApp.get().getAppSettings().appMode()== AppMode.HOTEL)
        {
            Log.i(TAG,"Detected Hotel App");
            new MeshRegisterTask(MeshTVApp.get().getBaseContext(), new MeshRequestListener() {
                @Override
                public void onFailed(String s) {

                }

                @Override
                public void onResult(String s) {

                }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
        }
        loadInitialData();
    }
    //==============================================================================================
    //==========================================MeshInstallerListener===============================
    @Override
    public void onInstallerConfirmed() {
        saveConfiguration();
        listener.onInstallerConfirmed();
    }

    @Override
    public void onInstallerDeclined() {
        listener.onInstallerDeclined();
    }

    @Override
    public void loadInitialData() {
        listener.loadInitialData();
    }

    @Override
    public void onConfigurationSaved()
    {
        register();
        listener.onConfigurationSaved();
    }

    @Override
    public void onConfigurationFailedToSave()
    {
        listener.onConfigurationFailedToSave();
    }
    //==============================================================================================
}
