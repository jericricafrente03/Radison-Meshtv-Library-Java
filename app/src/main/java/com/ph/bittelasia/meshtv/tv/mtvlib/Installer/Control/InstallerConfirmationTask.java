package com.ph.bittelasia.meshtv.tv.mtvlib.Installer.Control;

import android.os.AsyncTask;

public class InstallerConfirmationTask extends AsyncTask<Void,Void,Boolean>
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    public static final String TAG = InstallerConfirmationTask.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Instance-------------------------------------------
    MeshInstallerListener listener;
    String accesscode;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Constructor========================================
    public InstallerConfirmationTask(MeshInstallerListener listener,String accesscode)
    {
        this.listener = listener;
        this.accesscode = accesscode;
    }
    //==============================================================================================
    //===========================================LifeCycle==========================================
    @Override
    protected Boolean doInBackground(Void... voids)
    {
        return accesscode.equals("1234");
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        if(result)
        {
            listener.onInstallerConfirmed();
        }
        else
        {
            listener.onInstallerDeclined();
        }
    }
    //==============================================================================================
}
