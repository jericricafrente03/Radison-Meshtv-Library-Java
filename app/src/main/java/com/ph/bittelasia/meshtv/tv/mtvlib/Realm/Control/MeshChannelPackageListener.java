package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control;
public interface MeshChannelPackageListener
{
    public abstract void onPackageChannelsLoaded();
    public abstract void onPackageChannelsFailedToLoad(String message);
}
