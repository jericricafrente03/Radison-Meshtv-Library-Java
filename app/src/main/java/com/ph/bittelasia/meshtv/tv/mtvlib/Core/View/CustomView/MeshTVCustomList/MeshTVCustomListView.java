package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.MeshTVCustomList;

import android.content.Context;

import android.util.AttributeSet;

import androidx.annotation.Nullable;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshListItemClickedListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshListItemSelectedListener;
/**
 *
 * A custom list used as a substitute for Tabs
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshTVCustomListView extends BittelCustomListView
{
    //========================================Constructor===========================================
    /**
     * Default constructor
     * @param context required by all Widgets
     * @param attrs attributes from XML
     */
    public MeshTVCustomListView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
    }
    //==============================================================================================
    //===========================================Method=============================================
    //-------------------------------------------Action---------------------------------------------
    /**
     * Refresh a specific item on the list
     * @param index index of the item to be refereshed
     */
    public void refresh(int index)
    {
        setIndex(index);
    }

    /**
     * Clicks a currently selected item
     */
    public void doSelect()
    {
        select();
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Setter---------------------------------------------
    /**
     * Sets the {@link MeshListItemSelectedListener MeshListItemSelectedListener} to listen for select events
     * @param listener {@link MeshListItemSelectedListener MeshListItemSelectedListener} to listen for select events
     */
    public void setSelectListener(MeshListItemSelectedListener listener)
    {
        setSelectedListener(listener);
    }

    /**
     * Sets the {@link MeshListItemClickedListener MeshListItemClickedListener} to listen for click events
     * @param listener {@link MeshListItemClickedListener MeshListItemClickedListener} to listen for click events
     */
    public void setClickListener(MeshListItemClickedListener listener)
    {
        setClickedListener(listener);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================



}
