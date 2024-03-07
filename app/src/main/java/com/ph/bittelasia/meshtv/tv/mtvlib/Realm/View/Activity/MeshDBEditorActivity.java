package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity;

import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Fragment.MeshTVRealmListFragment;

public abstract class MeshDBEditorActivity extends AppCompatActivity
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static String TAG = MeshDBEditorActivity.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Fragment---------------------------------------
    MeshTVRealmListFragment list = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================LifeCycle=======================================
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bittel_realm_layout);
        list = getList();
        getSupportFragmentManager().beginTransaction().add(R.id.ll_list,list).commit();
    }
    //==============================================================================================
    //===============================================Abstract=======================================
    public abstract MeshTVRealmListFragment getList();
    //==============================================================================================


}
