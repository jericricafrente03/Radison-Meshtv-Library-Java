package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.MeshTVCustomList;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Adapter used for displaying objects into a {@link MeshTVCustomListView MeshTVCustomListView}
 * @param <T> Class of objects to be displayed, omit to use a generic Object
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
abstract class BittelCustomAdapter<T>
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = BittelCustomAdapter.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    /**
     * Parent View (Usually an instance of {@link MeshTVCustomListView MeshTVCustomListView}
     */
    private View parent;
    /**
     * List of items to be displayed
     */
    private ArrayList<T> items;
    /**
     * Selected item
     */
    private T selected;
    /**
     * Index of selected item
     */
    private int selectedIndex;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Constructor=======================================
    /**
     * Constructor
     * @param items list of Items to be displayed
     */
    public BittelCustomAdapter(ArrayList<T> items) {
        this.items = new ArrayList<>();
        this.items.addAll(items);
        if(items.size()>0)
        {
            selected = items.get(0);
        }


    }
    /**
     * Constructor
     * @param parent Parent View (Usually an instance of {@link MeshTVCustomListView MeshTVCustomListView}
     */
    public BittelCustomAdapter(View parent) {
        this.parent = parent;
        this.items = new ArrayList<>();
        if(items.size()>0)
        {
            selected = items.get(0);
        }
    }
    /**
     * Constructor
     * @param parent Parent View (Usually an instance of {@link MeshTVCustomListView MeshTVCustomListView}
     * @param items list of Items to be displayed
     */
    public BittelCustomAdapter(View parent, ArrayList<T> items) {
        this.parent = parent;
        this.items = new ArrayList<>();
        this.items.addAll(items);
        if(items.size()>0)
        {
            selected = items.get(0);
        }
    }
    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Getter------------------------------------------
    /**
     * Returns the list of all items displayed
     * @return a list of items displayed
     */
    final ArrayList<T> getItems() {
        return items;
    }
    /**
     * Returns {@link #selected selected} item
     * @return  {@link #selected selected} item
     */
    final T getSelected() {
        return selected;
    }
    /**
     * Returns {@link #selectedIndex selectedIndex}
     * @return {@link #selectedIndex selectedIndex}
     */
    final int getSelectedIndex() {
        return selectedIndex;
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Setter------------------------------------------
    /**
     * Sets a new set of items to be displayed
     * @param items new items to be displayed
     */
    final void setItems(ArrayList<T> items) {
        this.items = new ArrayList<>();
        this.items.addAll(items);
    }
    /**
     * Selects an item from the list
     * @param selected newly selected item
     */
    final void setSelected(T selected) {
        this.selected = selected;
    }
    /**
     * Sets the index of the selected item
     * @param selectedIndex index of the selected item
     */
    final void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
