package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.UpdateTask;

import android.os.AsyncTask;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshGuest;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshSubscriber;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;


public class CompareSubscriberTask extends AsyncTask<Void,Void,Void>
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    private static final String TAG          =   "Mars-"+CompareSubscriberTask.class.getSimpleName();
    private static final int CHECKIN         =   1;
    private static final int UPDATE          =   2;
    private static final int NO_CHANGE       =   0;
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    boolean subscriptionChanged = false;
    boolean subscriptionDataChanged = false;
    MeshSubscriber subscriber = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Constructor========================================

    public CompareSubscriberTask(MeshSubscriber subscriber)
    {
        this.subscriber = subscriber;
    }
    //==============================================================================================
    //============================================LifeCycle=========================================
    @Override
    protected final void onPreExecute()
    {
        super.onPreExecute();

    }
    @Override
    protected final Void doInBackground(Void... voids)
    {
        Log.i(TAG,"Subscription:Processing");
        MeshSubscriber s = new MeshSubscriber();
        Log.i(TAG,"Subscription: PREVIOUS STATUS:"+s.getStatus());
        Log.i(TAG,"Subscription: NEW STATUS:"+subscriber.getStatus());
        if(s.getStatus()!=subscriber.getStatus())
        {

            subscriptionChanged = true;
        }

        if(
                !s.getAccount_id().equals(subscriber.getAccount_id())
                ||!s.getTitle().equals(subscriber.getTitle())
                ||!s.getLastname().equals(subscriber.getLastname())
                ||!s.getFirstname().equals(subscriber.getFirstname())
                ||!s.getMiddlename().equals(subscriber.getMiddlename())
                ||!s.getContact_no().equals(subscriber.getContact_no())
                ||!s.getMobile_no().equals(subscriber.getMobile_no())
                ||!s.getEmail().equals(subscriber.getEmail())
                ||!s.getHouse_no().equals(subscriber.getHouse_no())
                ||!s.getSubdivision().equals(subscriber.getSubdivision())
                ||!s.getBarangay().equals(subscriber.getBarangay())
                ||!s.getCity().equals(subscriber.getCity())
                ||!s.getCountry_code().equals(subscriber.getCountry_code())
                ||!s.getPostal_code().equals(subscriber.getPostal_code())
                )
        {
            subscriptionDataChanged = true;
        }


        if(subscriptionChanged||subscriptionDataChanged)
        {
            subscriber.updatePreference();
        }

        return null;
    }
    @Override
    protected final void onPostExecute(Void i)
    {
        super.onPostExecute(i);

        if(MeshTVApp.get()!=null)
        {
            Log.i(TAG,"Subscription:App Detected");
            if(subscriptionDataChanged)
            {
                Log.i(TAG,"Subscription has Changed:UPDATING DATA");
                MeshTVApp.get().updateSubscriber();
            }
            if(subscriptionChanged)
            {
                Log.i(TAG,"Subscription has Changed:UPDATING STATUS");
                switch (subscriber.getStatus())
                {
                    case MeshSubscriber.STATUS_DISABLED:
                        subscriber.disable();
                        break;
                    case MeshSubscriber.STATUS_ENABLED:
                        subscriber.enable();
                        break;
                }
            }
        }

    }
    //==============================================================================================
}
