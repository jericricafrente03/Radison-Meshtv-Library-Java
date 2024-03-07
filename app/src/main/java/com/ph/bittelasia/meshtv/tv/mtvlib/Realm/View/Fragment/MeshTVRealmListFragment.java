package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Fragment;

import android.view.View;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RealmItem.MeshRealmItem;

import java.util.ArrayList;

public abstract class MeshTVRealmListFragment extends MeshTVFragment implements MeshRealmListener
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    public static final String TAG = MeshTVRealmListFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Instance-------------------------------------------
    Class c;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================MeshTVFragment=======================================
    @Override
    protected void onDrawDone(View v)
    {

    }
    @Override
    protected void onNewData(Object o)
    {

    }
    @Override
    protected void onDeleteData(int index)
    {

    }
    @Override
    protected void onClearData()
    {

    }
    @Override
    protected void refresh()
    {

    }
    @Override
    protected void update(Object item)
    {

    }
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    public Class getC()
    {
        return c;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public void setC(Class c) {
        this.c = c;
        if(c== MeshRealmItem.class)
        {
            ArrayList<Object> os = new ArrayList<>();
            for(Object o:MeshRealmManager.getAll())
            {
                os.add(o);
            }
            onRetrieved(c,os);
        }
        else
        {
            MeshRealmManager.retrieve(c,this);
        }
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=======================================MeshRealmListener======================================
    //==============================================================================================
}
