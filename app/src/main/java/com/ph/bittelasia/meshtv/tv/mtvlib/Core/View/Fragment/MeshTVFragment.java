package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment;

import android.util.Log;
import android.view.View;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.DataSetting;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.Layout;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.MeshTVAirmediaListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.MeshTVPIPListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.MeshTVPackageListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshTVFragmentListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Query.MeshValuePair;

import java.util.ArrayList;
/**
 * Works like a regular Fragment but has a lot of
 * additional features for faster development.
 * <br>
 * <br>Requires:
 * <br>1. {@link Layout Layout}
 * <br>2. {@link DataSetting DataSetting}
 * <br>
 * <br>Supports:
 * <br>1. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Init Init}
 * <br>2. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Terminate Terminate}
 * <br>3. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimedMethod}
 * <br>4. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Widget.BindWidget BindWidget}
 * <br>
 * <br>Listens to:
 * <br>1. {@link MeshTVPIPListener MeshTVPIPListener}
 * <br>2. {@link MeshTVAirmediaListener MeshTVAirmediaListener}
 * <br>3. {@link MeshTVPackageListener MeshTVPackageListener}
 * <br>4. {@link MeshTVFragmentListener MeshTVFragmentListener}
 * @param <T> Class of object to be displayed in the Fragment, omit to use a generic Object.
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 *
 */
public abstract class MeshTVFragment<T> extends BittelFragment<T>
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = "Mars-"+MeshTVFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    /**
     * Reference to the inflated view
     */
    View fragmentView = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Method=========================================
    //-----------------------------------------------Action-----------------------------------------
    /**
     * Clears the content of the fragment
     */
    public void clearSelection() {clear();}
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Getter-----------------------------------------

    /**
     * Returns the inflated view
     * @return View inflated by the fragment
     */
    public View getFragmentView() {
        return fragmentView;
    }

    /**
     * Returns the item selected
     * @return item selected
     */
    public T getSelectedItem(){return getItem();}

    /**
     * Returns the full list of items displayed
     * @return list of items displayed in the fragment
     */
    public ArrayList<T> getSelection(){return getItems();}

    /**
     * Returns reference of the parent activity if it implements {@link MeshTVFragmentListener MeshTVFragmentListener}
     * @return parent Activity that implements {@link MeshTVFragmentListener MeshTVFragmentListener}
     */
    public MeshTVFragmentListener getListener(){return getFragmentListener();}
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Setter-----------------------------------------

    /**
     * Updates the item selected
     * @param item item selected
     */
    public void setSelectedItem(T item){setItem(item);}

    /**
     * Sets a new list of items to be displayed
     * @param items items to be displayed
     */
    public void setSelection(ArrayList<T> items){setItems(items);}

    /**
     * Sets a new filter for the items to be displayed
     * @param valuePair new filter for the items to be displayed
     */
    public void setFilter(MeshValuePair valuePair)
    {
        setValuePair(valuePair);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================BittelFragment====================================

    /**
     * Triggered when the fragment is inflated
     * <br>triggers {@link #onDrawDone(View) onDrawDone(View)} method
     * @param v inflated view
     */
    @Override
    protected final void draw(View v)
    {
        this.fragmentView = v;
        onDrawDone(v);
    }
    //==============================================================================================
    //========================================BittelFragmentEvents==================================

    /**
     * Receives a list of updated items and passes them to {@link #onDataUpdated(ArrayList) onDataUpdated(ArrayList)}
     * <br>Triggers: {@link #onDataUpdated(ArrayList) onDataUpdated(ArrayList)}
     * @param items updated items
     */
    @Override
    protected final void update(ArrayList<T> items) {
        if(fragmentView!=null)
        {
            onDataUpdated(items);
        }
    }

    /**
     * Receives an updated item that just got inserted to the database
     * <br>Triggers: {@link #onInsert(Object) onInsert(Object)}
     * @param o inserted item
     */
    @Override
    protected void onInsert(Object o)
    {
        onNewData(o);
    }

    /**
     * Receives the index of a deleted item
     * <br>Triggers: {@link #onDeleteData(int) onDeleteData(int)}
     * @param index index of  item
     */

    @Override
    protected void onDelete(int index)
    {
        onDeleteData(index);
    }

    /**
     * Triggered when data was cleared from realm
     * <br>Triggers: {@link #onClearData() onClearData()}
     */
    @Override
    protected void onClear() {
        onClearData();
    }
    /**
     * Triggered when an item was updated
     * <br>Triggers: {@link #onDataUpdated(Object, int) onDataUpdated(Object, int)}
     */
    @Override
    protected void onUpdate(Object o, int index)
    {
        onDataUpdated(o,index);
    }

    /**
     * Triggered when no data matching the Class was found in Realm
     * <br>Triggers: {@link #onNoData(Class) onNoData(Class)}
     * @param c Class of item
     */
    @Override
    protected void onNoData(Class c)
    {
        Log.i(TAG,"No Data Found");

        onDataNotFound(c);
    }

    /**
     * Triggered when the list was forcefully updated
     * <br>Triggers: {@link #refresh() refresh()}
     */
    @Override
    final void forceUpdate() {
        refresh();
    }
    //==============================================================================================
    //==============================================Abstract========================================

    /**
     * Triggered when the view has been created
     * @param v root view of this fragment
     */
    protected abstract void onDrawDone(View v);
    /**
     * Triggered when data was updated and updates to a collection of elements is needed
     * @param items updated elements
     */
    protected abstract void onDataUpdated(ArrayList<T> items);

    /**
     * Triggered when one of the Objects being listened to receives a new item in realm
     * @param o new item inserted to realm
     */
    protected abstract void onNewData(Object o);
    /**
     * Triggered when one of the Objects being listened to receives an update
     * @param o updated item
     */
    protected abstract void onDataUpdated(Object o, int index);
    /**
     * Triggered when one of the Objects being listened to deletes an item
     * @param index index of deleted item
     */
    protected abstract void onDeleteData(int index);
    /**
     * Triggered when one of the Objects being has its data cleared
     */
    protected abstract void onClearData();

    /**
     * Triggered when a request was done but no data was found for the Class
     * @param c class of data requested
     */
    protected abstract void onDataNotFound(Class c);

    /**
     * Triggered when the fragment receives a forced update request
     */
    protected abstract void refresh();

    //==============================================================================================

    public int getLayout()
    {
        return 0;
    }
}
