package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control;

import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Settings.RealmEditorSettings;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Query.MeshValuePair;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RealmItem.MeshRealmItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Request.MeshUpdateRequest;


import java.util.ArrayList;

public class MeshRealmManager
{
    //===============================================Variable=======================================
    //-----------------------------------------------Constant---------------------------------------
    public static final String TAG = "Mars-"+BittelRealmManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //================================================Method========================================
    //------------------------------------------------Editor----------------------------------------
    public static final void setUp(RealmEditorSettings settings)
    {
        BittelRealmManager.get().add(settings);
    }
    public static final ArrayList<MeshRealmItem> getAll()
    {
        return BittelRealmManager.get().getItems();
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------MeshRealmEventListener--------------------------------
    public static final void addListener(MeshRealmEventListener listener)
    {
        BittelRealmManager.get().addListener(listener);
    }
    public static final void removeListener(MeshRealmEventListener listener)
    {
        BittelRealmManager.get().removeListener(listener);
    }
    public static final void clearListener()
    {
        BittelRealmManager.get().clearListeners();
    }
    public static final ArrayList<MeshRealmEventListener> getListeners()
    {
       return BittelRealmManager.get().getListeners();
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------CRUD-----------------------------------------
    public static final void insert(Object o)
    {
        Log.i(TAG,"INSERTING:"+o.getClass());
        BittelRealmManager.insert(o);
    }
    public static final void insertBulk(ArrayList<Object> os)
    {
        if(os.size()>0)
        {
            Log.i(TAG,"INSERTING "+os.get(0).getClass()+" Bulk:"+os.size());

            BittelRealmManager.insertBulk(os);
        }
        else
        {
            Log.i(TAG,"INSERTING FAILED EMPTY RESULTS");
        }

    }
    public static final void retrieve(Class c,MeshRealmListener listener)
    {
        Log.i(TAG,"RETRIEVING:"+c.getSimpleName());
        BittelRealmManager.retrieve(c,listener);
    }
    public static final void retrieve(Class c, MeshRealmListener listener, MeshValuePair... vp)
    {
        Log.i(TAG,"RETRIEVING:"+c.getSimpleName());
        BittelRealmManager.retrieve(c,listener,vp);
    }
    public static final void  retrieveOR(final Class c, final MeshRealmListener listener, final MeshValuePair... vp)
    {
        Log.i(TAG,"RETRIEVING:"+c.getSimpleName());
        BittelRealmManager.retrieveOR(c,listener,vp);
    }

    public final static void update (MeshUpdateRequest request)
    {
        BittelRealmManager.update(request);
    }
    public static final void delete(Object o)
    {
        Log.i(TAG,"DELETING:"+o.getClass());
        BittelRealmManager.delete(o);
    }
    public static final void clear(Class c)
    {
        Log.i(TAG,"Clearing:"+c.getSimpleName());
        BittelRealmManager.clear(c);
    }
    public static final void clear(Class c,MeshRealmListener listener)
    {
        Log.i(TAG,"Clearing:"+c.getSimpleName());
        BittelRealmManager.clear(c,listener);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
