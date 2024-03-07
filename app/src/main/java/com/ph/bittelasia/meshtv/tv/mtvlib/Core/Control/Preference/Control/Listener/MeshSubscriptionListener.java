package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener;

public interface MeshSubscriptionListener
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = MeshSubscriptionListener.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Abstract=========================================
    public abstract void onDisabled();
    public abstract void onEnabled();
    public abstract void onDataUpdate();
    //==============================================================================================
}
