package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message;

import android.content.Context;

public class MeshMessageManager
{
    //================================================Variable======================================
    //------------------------------------------------Constant--------------------------------------
    public static final String TAG = MeshMessageManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=================================================Method=======================================
    //-------------------------------------------------Action---------------------------------------
    public static void readMessage(Context context,MeshMessage message,MeshMessageReadListener listener)
    {
        BittelMessageManager.get().read(context,message,listener);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
