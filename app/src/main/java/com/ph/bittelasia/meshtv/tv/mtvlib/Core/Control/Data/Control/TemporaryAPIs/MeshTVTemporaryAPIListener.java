package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.TemporaryAPIs;

import java.util.ArrayList;

public interface MeshTVTemporaryAPIListener
{
    public abstract void onFail(Class c);
    public abstract void onSuccess(Class c, ArrayList<Object> result);
}
