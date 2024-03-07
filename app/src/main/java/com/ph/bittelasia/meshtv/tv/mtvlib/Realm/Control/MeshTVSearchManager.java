package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control;

/**
 * Created by Mars on 1/17/2018.
 */

public class MeshTVSearchManager
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    static final String TAG = MeshTVSearchManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Method============================================
    public static synchronized boolean isMatch(Object o,String searchString)
    {

        return BittelSearchManager.isMatch(o,searchString);
    }
    //==============================================================================================
}
