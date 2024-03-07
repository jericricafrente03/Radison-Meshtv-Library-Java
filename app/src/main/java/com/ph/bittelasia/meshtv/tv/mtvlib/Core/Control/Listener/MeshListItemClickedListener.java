package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener;

/**
 * Listens to click events on {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.MeshTVCustomList.MeshTVCustomListView MeshTVCustomListView }
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public interface MeshListItemClickedListener
{
    /**
     * Triggered when an item was clicked on the list
     * @param clickedItem Clicked item
     */
    public abstract void onClicked(Object clickedItem);
}
