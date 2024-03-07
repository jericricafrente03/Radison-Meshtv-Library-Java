package com.ph.bittelasia.meshtv.tv.mtvlib.PackageManager.Control;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.*;

import java.text.BreakIterator;

class BittelPackageManager
{
    static BroadcastReceiver listen(final MeshTVGenericPackageListener listener, Activity a)
    {
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent)
            {
                if(intent.getAction().equals(Intent.ACTION_PACKAGE_ADDED)||intent.getAction().equals(Intent.ACTION_PACKAGE_INSTALL))
                {
                    listener.onInstalled(intent.getData().toString().replaceFirst("package:",""));
                }
                else if (intent.getAction().equals(Intent.ACTION_PACKAGE_REMOVED))
                {
                    listener.onUninstalled(intent.getData().toString().replaceFirst("package:",""));
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
        intentFilter.addAction(Intent.ACTION_PACKAGE_INSTALL);
        intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        intentFilter.addDataScheme("package");
        a.registerReceiver(receiver, intentFilter);
        return receiver;
    }

    static void ignore(BroadcastReceiver receiver,Activity a)
    {
        a.unregisterReceiver(receiver);
    }

}
