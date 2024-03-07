package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.Control;

import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.TemporaryAPIs.MeshTVTempDataManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.TemporaryAPIs.MeshTVTemporaryAPIListener;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshSignage;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshLayoutV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaZone;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaZoneAssignment;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshScrollingMessage;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshSignageV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshType;

import java.util.ArrayList;

public class MeshTVSignageBackgroundDataUpdate
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    public static final String TAG = MeshTVSignageBackgroundDataUpdate.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Instance--------------------------------------------
     MeshDataListener listener = new MeshDataListener() {
        @Override
        public void onNoNetwork(Class c) {

        }

        @Override
        public void onNoData(Class c) {

        }

        @Override
        public void onParseFailed(Class c, String message) {

        }

        @Override
        public void onFileNotFound(Class c, String message) {

        }

        @Override
        public void onDataReceived(Class c, int size) {

        }
    };
    BackgroundUpdateListener l;
    ArrayList<Object> signages;
    ArrayList<Object> layouts;
    ArrayList<Object> assignments;
    ArrayList<Object> medias;
    ArrayList<Object> types;
    ArrayList<Object> messages;
    ArrayList<Object> feeds;
    ArrayList<Object> mediaZones;

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Constructor=======================================
    public MeshTVSignageBackgroundDataUpdate(BackgroundUpdateListener l)
    {
        this.l = l;
        signages = new ArrayList<>();
        layouts = new ArrayList<>();
        assignments = new ArrayList<>();
        medias = new ArrayList<>();
        types = new ArrayList<>();
        messages = new ArrayList<>();
        feeds = new ArrayList<>();
        mediaZones = new ArrayList<>();
    }
    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Request-----------------------------------------
    public  void requestSignage()
    {
        final String METHOD_NAME = "requestSignage";
        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
        MeshTVTempDataManager.requestData(MeshSignageV2.class, listener, new MeshTVTemporaryAPIListener() {
            @Override
            public void onFail(Class c)
            {
                Log.i(TAG,METHOD_NAME+" - "+" "+c.getSimpleName()+" : 0");
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                requestLayout();
            }

            @Override
            public void onSuccess(Class c, ArrayList<Object> result)
            {
                Log.i(TAG,METHOD_NAME+" - "+" "+c.getSimpleName()+" : "+result.size());
                for(Object o:result)
                {
                    signages.add((MeshSignageV2) o);
                }
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                requestLayout();
            }
        });
    }
    private   void requestLayout()
    {
        final String METHOD_NAME = "requestLayout";
        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
        MeshTVTempDataManager.requestData(MeshLayoutV2.class, listener, new MeshTVTemporaryAPIListener() {
            @Override
            public void onFail(Class c) {
                Log.i(TAG,METHOD_NAME+" - "+" "+c.getSimpleName()+" : 0");
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                requestZoneAssignment();
            }

            @Override
            public void onSuccess(Class c, ArrayList<Object> result) {
                Log.i(TAG,METHOD_NAME+" - "+" "+c.getSimpleName()+" : "+result.size());
                for(Object o:result)
                {
                    layouts.add((MeshLayoutV2) o);
                }
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                requestZoneAssignment();
            }
        });
    }
    private   void requestZoneAssignment()
    {
        final String METHOD_NAME = "requestZoneAssignment";
        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
        MeshTVTempDataManager.requestData(MeshMediaZoneAssignment.class, listener, new MeshTVTemporaryAPIListener() {
            @Override
            public void onFail(Class c) {
                Log.i(TAG,METHOD_NAME+" - "+" "+c.getSimpleName()+" : 0");
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                requestMediaZone();
            }

            @Override
            public void onSuccess(Class c, ArrayList<Object> result) {
                Log.i(TAG,METHOD_NAME+" - "+" "+c.getSimpleName()+" : "+result.size());
                for(Object o:result)
                {
                    assignments.add((MeshMediaZoneAssignment) o);
                }
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                requestMediaZone();
            }
        });
    }
    private   void requestMediaZone()
    {
        final String METHOD_NAME = "requestMediaZone";
        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
        MeshTVTempDataManager.requestData(MeshMediaZone.class, listener, new MeshTVTemporaryAPIListener() {
            @Override
            public void onFail(Class c) {
                Log.i(TAG,METHOD_NAME+" - "+" "+c.getSimpleName()+" : 0");
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                requestType();
            }

            @Override
            public void onSuccess(Class c, ArrayList<Object> result) {
                Log.i(TAG,METHOD_NAME+" - "+" "+c.getSimpleName()+" : "+result.size());
                for(Object o:result)
                {
                    mediaZones.add((MeshMediaZone) o);
                }
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                requestType();
            }
        });
    }
    private   void requestType()
    {
        final String METHOD_NAME = "requestType";
        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
        MeshTVTempDataManager.requestData(MeshType.class,listener,new MeshTVTemporaryAPIListener() {
            @Override
            public void onFail(Class c) {
                Log.i(TAG,METHOD_NAME+" - "+" "+c.getSimpleName()+" : 0");
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                requestScrollingMessage();
            }

            @Override
            public void onSuccess(Class c, ArrayList<Object> result) {
                Log.i(TAG,METHOD_NAME+" - "+" "+c.getSimpleName()+" : "+result.size());
                for(Object o:result)
                {
                    types.add((MeshType) o);
                }
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                requestScrollingMessage();
            }
        });
    }
    private   void requestScrollingMessage()
    {
        final String METHOD_NAME = "requestScrollingMessage";
        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
        MeshTVTempDataManager.requestData(MeshScrollingMessage.class, listener, new MeshTVTemporaryAPIListener() {
            @Override
            public void onFail(Class c) {
                Log.i(TAG,METHOD_NAME+" - "+" "+c.getSimpleName()+" : 0");
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                requestFeed();
            }

            @Override
            public void onSuccess(Class c, ArrayList<Object> result) {
                Log.i(TAG,METHOD_NAME+" - "+" "+c.getSimpleName()+" : "+result.size());
                for(Object o:result)
                {
                    messages.add((MeshScrollingMessage) o);
                }
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                requestFeed();
            }
        });
    }
    private   void requestFeed()
    {
        final String METHOD_NAME = "requestFeed";
        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
        MeshTVTempDataManager.requestData(MeshTVFeed.class, listener, new MeshTVTemporaryAPIListener() {
            @Override
            public void onFail(Class c) {
                Log.i(TAG,METHOD_NAME+" - "+" "+c.getSimpleName()+" : 0");
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                requestMedia();
            }

            @Override
            public void onSuccess(Class c, ArrayList<Object> result) {
                Log.i(TAG,METHOD_NAME+" - "+" "+c.getSimpleName()+" : "+result.size());
                for(Object o:result)
                {
                    feeds.add((MeshTVFeed) o);
                }
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                requestMedia();
            }
        });
    }
    private   void requestMedia()
    {
        final String METHOD_NAME = "requestMedia";
        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
        MeshTVTempDataManager.requestData(MeshMediaV2.class, listener, new MeshTVTemporaryAPIListener() {
            @Override
            public void onFail(Class c) {
                Log.i(TAG,METHOD_NAME+" - "+" "+c.getSimpleName()+" : 0");
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                terminate();
            }

            @Override
            public void onSuccess(Class c, ArrayList<Object> result) {
                Log.i(TAG,METHOD_NAME+" - "+" "+c.getSimpleName()+" : "+result.size());
                for(Object o:result)
                {
                    medias.add((MeshMediaV2) o);
                }
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                terminate();
            }
        });
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Update-----------------------------------------
    private void updateSignage()
    {
        final String METHOD_NAME = "updateSignage";
        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
        MeshRealmManager.clear(MeshSignageV2.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

            }

            @Override
            public void onFailed(Class c, String message) {

            }

            @Override
            public void onEmpty(Class c, String message) {
                if(message.equals("NOTHING_TO_CLEAR"))
                {
                    Log.i(TAG,METHOD_NAME+" - "+" data not found");
                    MeshRealmManager.insertBulk(signages);
                    Log.i(TAG,METHOD_NAME+" - "+" data updated");
                    Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                    updateLayout();
                }
            }

            @Override
            public void onCleared(Class c) {
                Log.i(TAG,METHOD_NAME+" - "+" data cleared");
                MeshRealmManager.insertBulk(signages);
                Log.i(TAG,METHOD_NAME+" - "+" data updated");
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                updateLayout();
            }
        });
    }
    private void updateLayout()
    {
        final String METHOD_NAME = "updateLayout";
        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
        MeshRealmManager.clear(MeshLayoutV2.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

            }

            @Override
            public void onFailed(Class c, String message) {

            }

            @Override
            public void onEmpty(Class c, String message) {
                if(message.equals("NOTHING_TO_CLEAR"))
                {
                    Log.i(TAG,METHOD_NAME+" - "+" data not found");
                    MeshRealmManager.insertBulk(layouts);
                    Log.i(TAG,METHOD_NAME+" - "+" data updated");
                    Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                    updateZoneAssignment();
                }
            }

            @Override
            public void onCleared(Class c) {
                Log.i(TAG,METHOD_NAME+" - "+" data cleared");
                MeshRealmManager.insertBulk(layouts);
                Log.i(TAG,METHOD_NAME+" - "+" data updated");
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                updateZoneAssignment();

            }
        });
    }
    private void updateZoneAssignment()
    {
        final String METHOD_NAME = "updateZineAssignment";
        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
        MeshRealmManager.clear(MeshMediaZoneAssignment.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

            }

            @Override
            public void onFailed(Class c, String message) {

            }

            @Override
            public void onEmpty(Class c, String message) {
                if(message.equals("NOTHING_TO_CLEAR"))
                {
                    Log.i(TAG,METHOD_NAME+" - "+" data not found");
                    MeshRealmManager.insertBulk(assignments);
                    Log.i(TAG,METHOD_NAME+" - "+" data updated");
                    Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                    updateMediaZone();
                }
            }

            @Override
            public void onCleared(Class c) {
                Log.i(TAG,METHOD_NAME+" - "+" data cleared");
                MeshRealmManager.insertBulk(assignments);
                Log.i(TAG,METHOD_NAME+" - "+" data updated");
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                updateMediaZone();
            }
        });
    }
    private void updateMediaZone()
    {
        final String METHOD_NAME = "updateMediaZone";
        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
        MeshRealmManager.clear(MeshMediaZone.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

            }

            @Override
            public void onFailed(Class c, String message) {

            }

            @Override
            public void onEmpty(Class c, String message) {
                if(message.equals("NOTHING_TO_CLEAR"))
                {
                    Log.i(TAG,METHOD_NAME+" - "+" data not found");
                    MeshRealmManager.insertBulk(mediaZones);
                    Log.i(TAG,METHOD_NAME+" - "+" data updated");
                    Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                    updateType();
                }
            }

            @Override
            public void onCleared(Class c) {
                Log.i(TAG,METHOD_NAME+" - "+" data cleared");
                MeshRealmManager.insertBulk(mediaZones);
                Log.i(TAG,METHOD_NAME+" - "+" data updated");
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                updateType();
            }
        });
    }
    private void updateType()
    {
        final String METHOD_NAME = "updateType";
        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
        MeshRealmManager.clear(MeshType.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

            }

            @Override
            public void onFailed(Class c, String message) {

            }

            @Override
            public void onEmpty(Class c, String message) {
                if(message.equals("NOTHING_TO_CLEAR"))
                {
                    Log.i(TAG,METHOD_NAME+" - "+" data not found");
                    MeshRealmManager.insertBulk(types);
                    Log.i(TAG,METHOD_NAME+" - "+" data updated");
                    Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                    updateScrollingMessage();
                }
            }

            @Override
            public void onCleared(Class c) {
                Log.i(TAG,METHOD_NAME+" - "+" data cleared");
                MeshRealmManager.insertBulk(types);
                Log.i(TAG,METHOD_NAME+" - "+" data updated");
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                updateScrollingMessage();
            }
        });
    }
    private void updateScrollingMessage()
    {
        final String METHOD_NAME = "updateScrollingMessage";
        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
        MeshRealmManager.clear(MeshScrollingMessage.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

            }

            @Override
            public void onFailed(Class c, String message) {

            }

            @Override
            public void onEmpty(Class c, String message) {
                if(message.equals("NOTHING_TO_CLEAR"))
                {
                    Log.i(TAG,METHOD_NAME+" - "+" data not found");
                    MeshRealmManager.insertBulk(messages);
                    Log.i(TAG,METHOD_NAME+" - "+" data updated");
                    Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                    updateFeed();
                }
            }

            @Override
            public void onCleared(Class c) {
                Log.i(TAG,METHOD_NAME+" - "+" data cleared");
                MeshRealmManager.insertBulk(messages);
                Log.i(TAG,METHOD_NAME+" - "+" data updated");
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                updateFeed();
            }
        });
    }
    private void updateFeed()
    {
        final String METHOD_NAME = "updateFeed";
        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
        MeshRealmManager.clear(MeshTVFeed.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

            }

            @Override
            public void onFailed(Class c, String message) {

            }

            @Override
            public void onEmpty(Class c, String message) {
                if(message.equals("NOTHING_TO_CLEAR"))
                {
                    Log.i(TAG,METHOD_NAME+" - "+" data not found");
                    MeshRealmManager.insertBulk(feeds);
                    Log.i(TAG,METHOD_NAME+" - "+" data updated");
                    Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                    updateMedia();
                }
            }

            @Override
            public void onCleared(Class c) {
                Log.i(TAG,METHOD_NAME+" - "+" data cleared");
                MeshRealmManager.insertBulk(feeds);
                Log.i(TAG,METHOD_NAME+" - "+" data updated");
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                updateMedia();
            }
        });
    }
    private void updateMedia()
    {
        final String METHOD_NAME = "updateMedia";
        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
        MeshRealmManager.clear(MeshMediaV2.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

            }

            @Override
            public void onFailed(Class c, String message) {

            }

            @Override
            public void onEmpty(Class c, String message) {
                if(message.equals("NOTHING_TO_CLEAR"))
                {
                    Log.i(TAG,METHOD_NAME+" - "+" data not found");
                    MeshRealmManager.insertBulk(medias);
                    Log.i(TAG,METHOD_NAME+" - "+" data updated");
                    Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                    l.done();
                }
            }

            @Override
            public void onCleared(Class c) {
                Log.i(TAG,METHOD_NAME+" - "+" data cleared");
                MeshRealmManager.insertBulk(medias);
                Log.i(TAG,METHOD_NAME+" - "+" data updated");
                Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
                l.done();
            }
        });
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Terminate---------------------------------------
    private void terminate()
    {
        final String METHOD_NAME = "terminate";
        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");

        Log.i(TAG,METHOD_NAME+" - "+" ========================================================");
        l.done();
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Listener=======================================
    public interface BackgroundUpdateListener
    {
        public abstract void done();
    }
    //===============================================================================================
}
