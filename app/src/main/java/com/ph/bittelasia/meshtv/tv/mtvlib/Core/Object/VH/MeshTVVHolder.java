package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.VH;

import android.view.View;

/**
 * Used by {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter MeshTVAdapter}
 * to reference views and widgets for each row.
 * <br>This supports {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Widget.BindWidget BindWidget} Annotation
 * @param <T> Object that is to be displayed. Must match the Object displayed by the {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter MeshTVAdapter}, omitting this will use a generic Object
 */
public abstract class MeshTVVHolder<T> extends BittelViewHolder<T>
{
    //==============================================Method==========================================
    /**
     * Returns reference to the view displayed
     * @return reference to the view displayed
     */
    public View getViewHolderView()
    {
        return getV();
    }
    //==============================================================================================
    //==========================================BittelViewHolder====================================
    /**
     * Triggered when view has been inflated and the widgets are binded. Override to reference widgets not supported by {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Widget.BindWidget BindWidget}
     * @param v reference of the view mainly used for widgets not supported by {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Widget.BindWidget BindWidget}
     */
    @Override
    public void initViews(View v) {

    }
    //==============================================================================================
}
