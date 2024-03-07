package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;

public interface MeshNotificationListener
{
    public abstract void onNotify(MeshMessage message);
}
