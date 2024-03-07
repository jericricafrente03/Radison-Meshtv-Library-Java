package com.ph.bittelasia.meshtv.tv.mtvlib.PackageManager.Control;


import android.app.Activity;
import android.content.BroadcastReceiver;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.MeshTVPackageListener;

public class MeshTVPackageManager
{
    public static BroadcastReceiver listen(Activity a,MeshTVGenericPackageListener listener)
    {
        return BittelPackageManager.listen(listener,a);
    }
    public static void ignore(Activity a,BroadcastReceiver receiver)
    {
        BittelPackageManager.ignore(receiver,a);
    }
}
