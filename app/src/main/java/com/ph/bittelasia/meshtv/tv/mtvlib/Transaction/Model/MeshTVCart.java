package com.ph.bittelasia.meshtv.tv.mtvlib.Transaction.Model;

import java.util.ArrayList;

public class MeshTVCart
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = MeshTVCart.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Action------------------------------------------
    public static void add(MeshCartItem item)
    {
        BittelCart.get().add(item);
    }
    public static void reduce(MeshCartItem item)
    {
        BittelCart.get().reduce(item);
    }
    public static void remove(MeshCartItem item)
    {
        BittelCart.get().remove(item);
    }

    public static void clear()
    {
        BittelCart.get().clear();
    }
    public static ArrayList<MeshCartItem> display(Class... classes)
    {
        return BittelCart.get().display(classes);
    }
    public static ArrayList<MeshCartItem> checkout(Class... classes)
    {
        return BittelCart.get().checkout(classes);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

}
