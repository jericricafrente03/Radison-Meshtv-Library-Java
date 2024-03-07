package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RealmItem.Adapter;

import android.content.Context;
import android.widget.ListView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.VH.MeshTVVHolder;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RealmItem.MeshRealmField;

import java.util.ArrayList;

/**
 * Created by mars on 1/2/18.
 */

public class MeshRealmFieldAdapter extends MeshTVAdapter<MeshRealmField>
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshRealmFieldAdapter.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Constructor========================================
    public MeshRealmFieldAdapter(Context context, ListView lv_list, int layoutResourceId, ArrayList<MeshRealmField> data) {
        super(context, lv_list, layoutResourceId, data);
    }
    //==============================================================================================
    //==========================================MeshTVAdapter=======================================
    @Override
    public MeshTVVHolder setViewHolder() {
        return new MeshRealmFieldViewHolder();
    }
    @Override
    public void updateRow(MeshTVVHolder vh, MeshRealmField o)
    {


    }
    //==============================================================================================
}
