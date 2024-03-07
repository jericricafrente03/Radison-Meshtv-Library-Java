package com.ph.bittelasia.meshtv.tv.mtvlib.Installer.Control;

public class MeshTVInstallerManager
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshTVInstallerManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    public static void startInstall(MeshInstallerListener listener,String accesscode,String account)
    {
        BittelInstallerManager.get().startInstall(listener,accesscode,account);
    }
    public static void startInstall(MeshInstallerListener listener,String accesscode,String account,String server)
    {
        BittelInstallerManager.get().startInstall(listener,accesscode,account,server);
    }
    //==============================================================================================
}
