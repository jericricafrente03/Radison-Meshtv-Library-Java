package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control;

import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackageChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshSubscription;

import java.util.ArrayList;

public class MeshChannelPackageManager
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshChannelPackageManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Static===========================================
    public static final void loadPackages(MeshChannelPackageListener listener)
    {
        Log.i(TAG,"Loading Packages");
        BittelChannelPackageManager.get().loadPackages(listener);
    }
    public static final boolean isSubscribed(MeshChannel channel)
    {
        return BittelChannelPackageManager.get().isSubscribed(channel);
    }
    public static final ArrayList<MeshPackageChannel> getListedPackageChannels()
    {
        return BittelChannelPackageManager.get().getPackageChannels();
    }

    public static final ArrayList<MeshSubscription> getSubscriptions()
    {
        return BittelChannelPackageManager.get().getSubscriptions();
    }
    public static final void clearAll()
    {
        BittelChannelPackageManager.get().clearPackages();
    }
    //==============================================================================================
}
