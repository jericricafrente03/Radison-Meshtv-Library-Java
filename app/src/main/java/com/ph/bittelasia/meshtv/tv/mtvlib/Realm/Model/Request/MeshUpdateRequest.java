package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Request;

public class MeshUpdateRequest
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = MeshUpdateRequest.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    Class c;
    String id;
    Object idValue;
    MeshUpdateRequestListener listener;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Constructor========================================
    public MeshUpdateRequest(MeshUpdateRequestListener listener)
    {
        this.listener = listener;
    }
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    public Class getC() {
        return c;
    }
    public String getId() {
        return id;
    }
    public Object getIdValue() {
        return idValue;
    }
    public MeshUpdateRequestListener getListener() {
        return listener;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public void setC(Class c) {
        this.c = c;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setIdValue(Object idValue) {
        this.idValue = idValue;
    }
    public void setListener(MeshUpdateRequestListener listener) {
        this.listener = listener;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
