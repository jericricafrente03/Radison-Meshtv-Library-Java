package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter;

import android.content.Context;
import android.widget.GridView;
import android.widget.ListView;


import java.util.ArrayList;

/**
 * Adapter to be used for List or Grid objects to be displayed on a {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment}
 * <br>Requires:
 * <br>1. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.ViewHolder.ViewHolderLayout ViewHolderLayout} Annotation
 * @param <T> the Class of the object to be displayed omit to use a generic Object
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public abstract class MeshTVAdapter<T> extends BittelAdapter<T>
{
    //=============================================Constructor======================================
    /**
     * Constructor for an Adapter to be displayed in a List
     * @param context required by {@link android.widget.ArrayAdapter ArrayAdapter}
     * @param lv_list {@link ListView ListView} to display the adapter
     * @param layoutResourceId {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.ViewHolder.ViewHolderLayout ViewHolderLayout}
     * @param data list of items to display
     */
    public MeshTVAdapter(Context context, ListView lv_list, int layoutResourceId, ArrayList<T> data) {
        super(context, lv_list, layoutResourceId, data);
    }
    /**
     * Constructor for an Adapter to be displayed in a Grid
     * @param context required by {@link android.widget.ArrayAdapter ArrayAdapter}
     * @param gv_view {@link GridView GridView} to display the adapter
     * @param layoutResourceId {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.ViewHolder.ViewHolderLayout ViewHolderLayout}
     * @param data list of items to display
     */
    public MeshTVAdapter(Context context, GridView gv_view, int layoutResourceId, ArrayList<T> data) {
        super(context, gv_view, layoutResourceId, data);
    }
    @Override
    public int setLayout()
    {
        return -1;
    }
    //==============================================================================================
}
