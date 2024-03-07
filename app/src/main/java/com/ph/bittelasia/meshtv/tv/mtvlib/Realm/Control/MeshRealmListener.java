package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control;

import java.util.ArrayList;

public interface MeshRealmListener
{
    public abstract void onRetrieved(Class c, ArrayList<Object> results);
    public abstract void onFailed(Class c, String message);
    public abstract void onEmpty(Class c, String message);
    public abstract void onCleared(Class c);
}
