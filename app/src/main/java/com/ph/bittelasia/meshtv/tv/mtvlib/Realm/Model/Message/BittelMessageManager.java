package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message;

import android.content.Context;
import android.os.AsyncTask;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Getter.MeshReadTask;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshNotificationListener;

import io.realm.Realm;
import io.realm.RealmResults;

class BittelMessageManager
{
    //===============================================Variable=======================================
    //-----------------------------------------------Constant---------------------------------------
    static final String TAG = BittelMessageManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Static----------------------------------------\
    static BittelMessageManager manager = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //================================================Static========================================
    static BittelMessageManager get()
    {
        if(manager==null)
        {
            manager = new BittelMessageManager();
        }
        return manager;
    }
    //==============================================================================================
    //===============================================Construct======================================
    private BittelMessageManager()
    {

    }
    //==============================================================================================
    //=================================================Method=======================================
    //-------------------------------------------------Action---------------------------------------
    synchronized void read(Context context,final MeshMessage meshMessage, final MeshMessageReadListener listener)
    {
        Realm r = Realm.getDefaultInstance();
        final int id = meshMessage.getId();
        new MeshReadTask(context,meshMessage.getId()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
        r.executeTransactionAsync(new Realm.Transaction() {
                                      @Override
                                      public void execute(Realm realm) {
                                          RealmResults<MeshMessage> messages = realm.where(MeshMessage.class).equalTo(MeshMessage.TAG_ID,id).findAll();
                                          if(messages.size()>0)
                                          {
                                              MeshMessage m = messages.first();
                                              m.setMessg_status(2);
                                              realm.copyToRealmOrUpdate(m);
                                          }
                                      }
                                  }, new Realm.Transaction.OnSuccess() {
                                      @Override
                                      public void onSuccess() {
                                          listener.isRead(true);
                                      }
                                  },
                new Realm.Transaction.OnError() {
                    @Override
                    public void onError(Throwable error) {
                        listener.isRead(false);
                    }
                });
    }

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
