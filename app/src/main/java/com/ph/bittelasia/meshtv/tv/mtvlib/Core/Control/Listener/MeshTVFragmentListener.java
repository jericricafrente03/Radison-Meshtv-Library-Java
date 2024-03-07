package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener;

/**
 * Listens to click and select events from {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment}
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public interface MeshTVFragmentListener
{
    //=======================================Variable===============================================
    //---------------------------------------Constant-----------------------------------------------
    public static final String TAG =  MeshTVFragmentListener.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //========================================Interface=============================================
    /**
     * Triggered when an item is clicked
     * @param o Clicked Item
     */
    public abstract void onClicked(Object o);

    /**
     * Triggered when an item is selected
     * @param o Selected Item
     */
    public abstract void onSelected(Object o);
    //==============================================================================================
}
