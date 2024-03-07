package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.Layout;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.ViewHolder.ViewHolderLayout;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.VH.MeshTVVHolder;

import java.util.ArrayList;


/**
 * Generic Adapter for all Lists and Grids of MeshTV
 * <br>Requires:
 * <br>1. {@link ViewHolderLayout ViewHolderLayout } annotation
 * @param <T> Object to be displayed by the adapter, omit to use a generic Object
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
abstract class BittelAdapter<T> extends ArrayAdapter<T>
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = BittelAdapter.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------View--------------------------------------------
    /**
     * ListView that displays all objects within the adapter
     */
    ListView lv_list;
    /**
     * GridView that displays all objects within the adapter
     */
    GridView gv_view;
    /**
     * ViewHolderLayout to store the inflated views per item
     */
    ViewHolderLayout layout;
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    /**
     * index of a selected item
     */
    int selected = 0;
    /**
     * index of the selected item before the current
     */
    int previous = 0;
    /**
     * Index of the clicked item
     */
    int clicked = -1;
    /**
     * Context required by ArrayAdapters
     */
    Context context;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Constructor========================================
    /**
     * Constructor if you are going to use a list to display the items
     * @param context required by ArrayAdapters
     * @param lv_list list to display the items
     * @param layoutResourceId default resource id of the row to be displayed
     * @param data list of items to be displayed
     */
    public BittelAdapter(Context context, ListView lv_list, int layoutResourceId, ArrayList<T> data)
    {
        super(context,layoutResourceId,data);
        this.lv_list = lv_list;
        this.context = context;
        init();
    }

    /**
     * Constructor if you are going to use a grid to display the items
     * @param context required by ArrayAdapters
     * @param gv_view grid to display the items
     * @param layoutResourceId default resource id of the row to be displayed
     * @param data list of items to be displayed
     */
    public BittelAdapter(Context context, GridView gv_view, int layoutResourceId, ArrayList<T> data)
    {
        super(context,layoutResourceId,data);
        this.gv_view = gv_view;
        this.context = context;
        init();
    }
    //==============================================================================================
    //========================================ArrayAdapter==========================================
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View row = convertView;
        MeshTVVHolder viewHolder = null;
        if (row==null)
        {

            if(position==selected)
            {
                row = inflateSelected(LayoutInflater.from(parent.getContext()));
            }
            else if(position==clicked)
            {
                row = inflateClicked(LayoutInflater.from(parent.getContext()));
            }
            else
            {
                row = inflate(LayoutInflater.from(parent.getContext()));
            }

            viewHolder =  setViewHolder();
            viewHolder.inflate(row);
            row.setTag(viewHolder);
        }

        viewHolder =  (MeshTVVHolder) row.getTag();
        updateRow(viewHolder,getItem(position));
        return row;
    }

    //==============================================================================================
    //===========================================Method=============================================
    //--------------------------------------------Init----------------------------------------------
    /**
     * Initializes Adapter by referencing to the {@link ViewHolderLayout ViewHolderLayout} Annotation
     */
    private void init()
    {
        layout = getClass().getAnnotation(ViewHolderLayout.class);
//        if(layout==null)
//        {
//            throw new RuntimeException("Mars: ViewHolderLayout Annotation is required");
//        }

    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Draw----------------------------------------------

    /**
     * Inflates the view when clicked using {@link ViewHolderLayout#layout() ViewHolderLayout.layout()}
     * @param inflater LayoutInflater
     * @return Inflated View
     */
    public View inflate(LayoutInflater inflater)
    {
        if(layout.layout()>0)
        {
            return inflater.inflate(layout.layout(),null,false);
        }
        else
        {
            return inflater.inflate(setLayout(),null,false);
        }

    }
    /**
     * Inflates the view when clicked using {@link ViewHolderLayout#layoutSelected() ViewHolderLayout.layoutSelected()}
     * @param inflater LayoutInflater
     * @return Inflated View
     */
    public View inflateSelected(LayoutInflater inflater)
    {
        int l = 0;
            try
            {
                l = layout.layoutSelected();
                if(l<1)
                {
                    l = setLayout();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        if(l<1)
        {
            l = setLayout();
        }
            Log.i(TAG,inflater==null?"NULL":"NOT NULL");
            Log.i(TAG,"LAYOUT:"+l);
            if(l<1)
            {
                return inflate(inflater);
            }
            return inflater.inflate(l,null,false);

    }
    /**
     * Inflates the view when clicked using {@link ViewHolderLayout#layoutCLicked() ViewHolderLayout.layoutCLicked()}
     * @param inflater LayoutInflater
     * @return Inflated View
     */
    public View inflateClicked(LayoutInflater inflater)
    {

            int l = layout.layoutCLicked();
            if(l==0)
            {
                l = layout.layout();
            }
            return inflater.inflate(l,null,false);

    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------CRUD----------------------------------------------

    /**
     * Adds an object to the adapter
     * @param o object to be added
     */
    public void create(T o)
    {
        add(o);
        notifyDataSetChanged();
    }

    /**
     * Retrieves an item from the list using its index
     * @param index index of the item to be retrieved
     * @return Item that matches the index
     */
    public T retrieve(int index)
    {
        return getItem(index);
    }

    /**
     * Updates an item on the list
     * @param o item to replace the old one
     * @param index index of the item to be replaced
     */
    public void update(T o, int index)
    {
        update(o,index);
        if(lv_list!=null)
        {
            View v = lv_list.getChildAt(index-lv_list.getFirstVisiblePosition());
            updateRow((MeshTVVHolder)v.getTag(),o);
        }
        if(gv_view!=null)
        {
            View v = gv_view.getChildAt(index-gv_view.getFirstVisiblePosition());
            updateRow((MeshTVVHolder)v.getTag(),o);
        }
    }

    /**
     * Updates a certain row on the list
     * @param index row to be updated
     */
    public void update(int index)
    {
        if(lv_list!=null)
        {
            View v = lv_list.getChildAt(index - lv_list.getFirstVisiblePosition());
            updateRow((MeshTVVHolder) v.getTag(),getItem(index));
        }
        if(gv_view!=null)
        {
            View v = gv_view.getChildAt(index - gv_view.getFirstVisiblePosition());
            updateRow((MeshTVVHolder) v.getTag(),getItem(index));
        }

    }

    /**
     * Delete a certain item from a list
     * @param index row to be deleted
     */
    public void delete(int index)
    {
        remove(retrieve(index));
        notifyDataSetChanged();
    }

    /**
     * clears the adapter
     */
    public void clear()
    {
        clear();
        notifyDataSetChanged();
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Getter---------------------------------------------

    /**
     * Get the ListView that display the items
     * @return reference to the ListView
     */
    public ListView getLv_list() {
        return lv_list;
    }
    /**
     * Get the GridView that display the items
     * @return reference to the GridView
     */
    public GridView getGv_view() {
        return gv_view;
    }

    /**
     * Index of a selected item
     * @return selected index
     */
    public int getSelected() {
        return selected;
    }

    /**
     * Index of the previously selected item
     * @return index of previously selected item
     */
    public int getPrevious() {
        return previous;
    }

    /**
     * Index of the clicked item
     * @return index of the previously clicked item
     */
    public int getClicked() {
        return clicked;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Setter---------------------------------------------

    /**
     * Sets the list to display all the items
     * @param lv_list reference to the list to display the items
     */
    public void setLv_list(ListView lv_list) {
        this.lv_list = lv_list;
    }
    /**
     * Sets the grid to display all the items
     * @param gv_view reference to the grid to display the items
     */
    public void setGv_view(GridView gv_view) {
        this.gv_view = gv_view;
    }

    /**
     * Sets the index of selected item
     * @param selected index of selected item
     */
    public void setSelected(int selected) {
        this.selected = selected;
    }
    /**
     * Sets the index of previously selected item
     * @param previous index of previously selected item
     */
    public void setPrevious(int previous) {
        this.previous = previous;
    }
    /**
     * Sets the index of clicked item
     * @param clicked index of clicked item
     */
    public void setClicked(int clicked) {
        this.clicked = clicked;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================Abstract============================================

    /**
     * Sets the implementation of {@link MeshTVVHolder MeshTVVHolder} to be used by the adapter
     * @return implementation of {@link MeshTVVHolder MeshTVVHolder} to be used by the adapter
     */
    public abstract MeshTVVHolder setViewHolder();

    /**
     * Binds the object and the viewholder
     * @param vh ViewHolder to be used to display the object
     * @param o Object to be binded to the view holder
     */
    public abstract void updateRow(MeshTVVHolder vh, T o);
    public abstract int setLayout();
    //==============================================================================================

}
