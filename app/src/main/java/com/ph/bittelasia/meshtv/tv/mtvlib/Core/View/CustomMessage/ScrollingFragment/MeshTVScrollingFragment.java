package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomMessage.ScrollingFragment;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;

/**
 * Created by Mars on 4/2/2018.
 */

public abstract class MeshTVScrollingFragment extends BittelScrollingFragment
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = MeshTVScrollingFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Setter------------------------------------------
    public void setMSG(MeshMessage message)
    {
        setMessage(message);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
