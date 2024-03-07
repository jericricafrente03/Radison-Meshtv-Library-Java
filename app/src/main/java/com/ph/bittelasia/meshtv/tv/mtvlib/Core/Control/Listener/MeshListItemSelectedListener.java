package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener;
/**
 * Listens to select events on {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.MeshTVCustomList.MeshTVCustomListView MeshTVCustomListView }
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public interface MeshListItemSelectedListener
{
    /**
     * Triggered when an item was selected on the list
     * @param selected Selected item
     */
    public abstract void onSelected(Object selected);
}
