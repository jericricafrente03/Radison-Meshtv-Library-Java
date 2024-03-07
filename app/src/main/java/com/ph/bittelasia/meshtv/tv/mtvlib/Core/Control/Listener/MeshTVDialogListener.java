package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener;

/**
 * Listens to results from {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Dialog.MeshTVDialogFragment MeshTVDialogFragment}
 * @author Mars Ray Canizare Araullo
 */
public interface MeshTVDialogListener
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    public static final String TAG = MeshTVDialogListener.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Event=============================================
    /**
     * Triggered when a {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Dialog.MeshTVDialogFragment MeshTVDialogFragment}
     * successfully finished a transaction
     * @param o
     */
    public abstract void onResult(Object o);
    /**
     * Triggered when a {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Dialog.MeshTVDialogFragment MeshTVDialogFragment}
     * was cancelled before transaction was finished
     */
    public abstract void onCancel();
    //==============================================================================================

}
