package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.MeshTVCustomList;

import android.view.View;

import java.util.ArrayList;
/**
 * Adapter used for displaying objects into a {@link MeshTVCustomListView MeshTVCustomListView}
 * @param <T> Class of objects to be displayed, omit to use a generic Object
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public abstract class MeshTVCustomAdapter<T> extends BittelCustomAdapter<T>
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = MeshTVCustomAdapter.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Constructor=======================================
    /**
     * Constructor
     * @param parent Parent View (Usually an instance of {@link MeshTVCustomListView MeshTVCustomListView}
     */
    public MeshTVCustomAdapter(View parent) {
        super(parent);
    }
    /**
     * Constructor
     * @param items list of Items to be displayed
     */
    public MeshTVCustomAdapter(ArrayList<T> items) {
        super(items);
    }
    /**
     * Constructor
     * @param parent Parent View (Usually an instance of {@link MeshTVCustomListView MeshTVCustomListView}
     * @param items list of Items to be displayed
     */
    public MeshTVCustomAdapter(View parent, ArrayList<T> items) {
        super(parent, items);
    }
    //==============================================================================================
    //===============================================Method=========================================
    //-----------------------------------------------Getter-----------------------------------------
    /**
     * Returns the list of all items displayed
     * @return a list of items displayed
     */
    public final ArrayList<T> getAllItems() {
        return getItems();
    }
    /**
     * Returns {@link #selected selected} item
     * @return  {@link #selected selected} item
     */
    public final T getSelectedItem() {
        return getSelected();
    }
    /**
     * Returns {@link #selectedIndex selectedIndex}
     * @return {@link #selectedIndex selectedIndex}
     */
    public final int getSelectedItemIndex() {
        return getSelectedIndex();
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Setter-----------------------------------------
    /**
     * Sets a new set of items to be displayed
     * @param items new items to be displayed
     */
    public final void setAllItems(ArrayList<T> items)
    {
        setItems(items);
    }
    /**
     * Selects an item from the list
     * @param selected newly selected item
     */
    public final void setSelectedItem(T selected)
    {
        setSelected(selected);
    }
    /**
     * Sets the index of the selected item
     * @param selectedIndex index of the selected item
     */
    public final void setSelectedItemIndex(int selectedIndex)
    {
        setSelectedIndex(selectedIndex);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Abstract=========================================
    /**
     * Allows custom implementation on how to bind the object with the adapter
     * @param v reference to the view being displayed
     * @param object the Object to be displayed
     */
    public abstract void bindView(View v,T object);
    //==============================================================================================
}
