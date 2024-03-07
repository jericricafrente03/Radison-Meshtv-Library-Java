package com.ph.bittelasia.meshtv.tv.mtvlib.Installer.Control;

public interface MeshInstallerListener
{
    public abstract void onInstallerConfirmed();
    public abstract void onInstallerDeclined();
    public abstract void loadInitialData();
    public abstract void onConfigurationSaved();
    public abstract void onConfigurationFailedToSave();
}
