package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD;


import java.util.ArrayList;

public class MeshVODManager
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = MeshVODManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Static=========================================
    //-----------------------------------------------Action-----------------------------------------
    public static synchronized void rent(MeshVOD vod,MeshVODListener listener)
    {
        BittelVODManager.get().rent(vod,listener);
    }
    public static synchronized void clear(MeshVODListener listener)
    {
        BittelVODManager.get().clear(listener);
    }
    public static synchronized void isRented(MeshVODListener listener,int id)
    {
        BittelVODManager.get().isRented(listener,id);
    }
    public static synchronized void isRented(ArrayList<MeshVOD> vods,MeshVODListener listener)
    {
        BittelVODManager.get().isRented(vods,listener);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
  }
