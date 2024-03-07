package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control;

import java.util.ArrayList;

public interface MeshRealmEventListener
{
    public abstract void onCreate(Object o);
    public abstract void onCreateBulk(ArrayList<Object> os);
    public abstract void onDelete(Class c);
    public abstract void onClear(Class c);
}
