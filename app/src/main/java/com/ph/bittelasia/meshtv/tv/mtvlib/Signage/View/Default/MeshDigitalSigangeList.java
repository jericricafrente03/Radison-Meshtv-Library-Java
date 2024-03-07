package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.View.Default;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Constant.AppDataSource;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Manager.MeshTVDataManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Control.SignagePreference;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshSignage;

import java.util.ArrayList;

public abstract class MeshDigitalSigangeList extends MeshTVFragment<MeshSignage> implements MeshDataListener,MeshRealmListener
{

    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    public static final String TAG = MeshDigitalSigangeList.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Instance-------------------------------------------
    MeshTVAdapter adapter = null;
    ArrayList<MeshSignage> signages;
    int selected= -1;
    Handler handler;
    Runnable r = new Runnable() {
        @Override
        public void run()
        {
            Log.i(TAG,"========================================================================");
            if(lv_list!=null)
            {
                Log.i(TAG,(lv_list==null?"List is null":"List is not null"));
                if(signages.size()>0)
                {

                    selected = lv_list.getSelectedItemPosition();
                    Log.i(TAG,"Signage is :"+selected);
                    if (1 == signages.size()-selected)
                    {
                        selected = -1;
                        Log.i(TAG,"Signage is equal to max :"+selected);
                    }
                    else
                    {
                        Log.i(TAG,"Signage is less than max :"+selected);
                    }
                    if (selected <= signages.size())
                    {
                        selected++;
                        lv_list.setSelection(selected);
                        Log.i(TAG,"Signage Selected :"+selected);
                    }
                    else
                        {

                        selected = 1;
                        lv_list.setSelection(selected);
                            Log.i(TAG,"Signage :"+selected);
                    }

                }
                else
                {
                    Log.i(TAG,"Signage is empty");
                }

            }
            else
            {
                Log.i(TAG,(lv_list==null?"List is null":"List is not null"));
            }
            Log.i(TAG,"========================================================================");


        }
    };
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------View---------------------------------------------
    public ListView lv_list;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================MeshTVFragment=======================================
    @Override
    protected void onDrawDone(View view) {
        signages = new ArrayList<>();
        handler = new Handler();
        lv_list = getListView();
        MeshRealmManager.retrieve(MeshSignage.class,this);

    }
    @Override
    protected void onDataUpdated(ArrayList arrayList)
    {

            signages = new ArrayList<>();
            for (Object o : arrayList)
            {
                signages.add((MeshSignage)o);
            }
            adapter = setAdapter(signages);
            lv_list.setAdapter(adapter);
            lv_list.requestFocus();
            lv_list.setSelection(0);
            lv_list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    getListener().onSelected(signages.get(position));
                    if (signages.get(position).getFileType().equals(MeshSignage.TYPE_IMAGE)) {
                        handler.postDelayed(r, SignagePreference.getDelay()*1000);
                    }
                    else
                    {
                        handler.removeCallbacks(r);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            selected=-1;
            handler.post(r);

    }
    @Override
    protected void onNewData(Object o) {

    }
    @Override
    protected void onDataUpdated(Object o, int i) {

    }
    @Override
    protected void onDeleteData(int i) {

    }
    @Override
    protected void onClearData() {

    }
    @Override
    protected void onDataNotFound(Class aClass) {

    }
    @Override
    protected void refresh() {

    }
    @Override
    protected void update(MeshSignage o) {

    }
    //==============================================================================================
    //==========================================MeshDataListener====================================
    @Override
    public void onNoNetwork(Class aClass) {

    }

    @Override
    public void onNoData(Class aClass) {

    }

    @Override
    public void onParseFailed(Class aClass, String s) {

    }

    @Override
    public void onFileNotFound(Class aClass, String s) {

    }

    @Override
    public void onDataReceived(Class aClass, int i) {
        MeshRealmManager.retrieve(MeshSignage.class,this);
    }


    //==============================================================================================
    //=======================================MeshRealmListener======================================
    @Override
    public void onRetrieved(Class aClass, ArrayList<Object> arrayList)
    {
        if(aClass==MeshSignage.class)
        {
            signages = new ArrayList<>();
            for (Object o : arrayList)
            {
                signages.add((MeshSignage)o);
            }
            adapter = setAdapter(signages);
            lv_list.setAdapter(adapter);
            lv_list.requestFocus();
            lv_list.setSelection(0);
            lv_list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    getListener().onSelected(signages.get(position));
                    if(signages.get(position).getFileType().equals(MeshSignage.TYPE_IMAGE))
                    {
                        handler.postDelayed(r,SignagePreference.getDelay()*1000);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            selected=-1;
            handler.post(r);
        }

    }
    public void update()
    {
        handler.post(r);
    }

    @Override
    public void onFailed(Class aClass, String s)
    {

    }

    @Override
    public void onEmpty(Class aClass, String s)
    {
        MeshTVDataManager.requestData(getActivity(), setDataSource(),MeshSignage.class,this);

    }

    @Override
    public void onCleared(Class aClass)
    {

    }


    //==============================================================================================
    //============================================Abstract==========================================
    public abstract MeshTVAdapter setAdapter(ArrayList<MeshSignage> signages);
    public abstract ListView getListView();
    public abstract int setDataSource();
    //==============================================================================================
}
