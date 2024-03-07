package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Dialog;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.Layout;

/**
 * MeshTV's implementation for DialogFragments
 * <br>
 * <br>Requires:
 * <br>1. {@link Layout Layout} for layout
 * <br>
 * <br>Note: Width and Height of the DialogFragment can be overridden during onResume
 * <br>int width = getResources().getDimensionPixelSize(R.dimen.ss_cart_width);
 * <br>int height = getResources().getDimensionPixelSize(R.dimen.ss_book_height);
 * <br>getDialog().getWindow().setLayout(width, height);
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public abstract class MeshTVDialogFragment extends BittelDialogFragment
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = MeshTVDialogFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=======================================MeshTVDialogFragment===================================
    /**
     * Triggers {@link #drawDone() drawDone()} event for the subclasses
     */
    @Override
    public final void referenceViews() {
        drawDone();
    }
    //==============================================================================================
    //============================================Abstract==========================================

    /**
     * Allows to work on the DialogFragment after everything is inflated
     */
    public abstract void drawDone();
    //==============================================================================================
}
