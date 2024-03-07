package com.ph.bittelasia.meshtv.tv.mtvlib.PackageManager.Control;


public interface MeshTVGenericPackageListener
{
    public abstract void onInstalled(String packagename);
    public abstract void onUninstalled(String packagename);
}
