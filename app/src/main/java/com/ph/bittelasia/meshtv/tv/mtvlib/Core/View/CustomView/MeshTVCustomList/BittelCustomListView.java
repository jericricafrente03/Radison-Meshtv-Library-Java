package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.MeshTVCustomList;

import android.content.Context;
import android.content.res.TypedArray;

import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshListItemClickedListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshListItemSelectedListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshEPG;

import java.util.ArrayList;
/**
 * Base class of {@link MeshTVCustomListView MeshTVCustomListView} a custom list used as a substitute for Tabs
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
abstract class BittelCustomListView extends LinearLayout
{

    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String  TAG                     =   BittelCustomListView.class.getSimpleName();
    /**
     * When this type is selected this the items on the list will rotate and will be selected when they hit a specified index
     */
    public static final int     TYPE_CAROUSEL           =   0;
    /**
     * When this type is selected  this the items on the list be selected like how a normal ListView does
     */
    public static final int     TYPE_CONTINUOUS         =   1;
    /**
     * When this type is selected the items are divided into pages
     */
    public static final int     TYPE_PAGED              =   2;
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    /**
     * Adapter to be used to display Items
     */
    MeshTVCustomAdapter adapter             = null;
    /**
     * Type of list to be used
     * <br>
     * <br>Values:
     * <br> {@link #TYPE_CAROUSEL TYPE_CAROUSEL}
     * <br> {@link #TYPE_CONTINUOUS TYPE_CONTINUOUS}
     * <br> {@link #TYPE_PAGED TYPE_PAGED} (DEFAULT)
     */
    int                 type                = TYPE_PAGED;
    /**
     * Used by {@link #TYPE_CAROUSEL TYPE_CAROUSEL} mode the index to be selected
     */
    int                 target              = 0;
    /**
     * Maxed displayed items
     */
    int                 max                 = 5;
    /**
     * Resource ID of layout to be used by item at its neutral state
     */
    int                 layout              = 0;
    /**
     * Resource ID of layout to be used by item at its clicked state
     */
    int                 layout_selected     = 0;
    /**
     * Resource ID of layout to be used by item at its pressed state
     */
    int                 layout_pressed      = 0;
    /**
     * Flag whether the list needs focus to move or not (DEFAULT:false)
     * <br>Values:
     * <br>True - {@link MeshTVCustomListView MeshTVCustomListView} needs to be focused before it can be navigated
     * <br>False - {@link MeshTVCustomListView MeshTVCustomListView} does not need focus to be navigated
     */
    boolean             needsFocus          = false;
    /**
     * Index of items that are currently displayed
     */
    ArrayList<Integer> displayed           = null;
    /**
     * Index of the selected item
     */
    int index = 0;
    /**
     * Index of the first item displayed
     */
    int first = 0;
    /**
     * {@link MeshListItemClickedListener MeshListItemClickedListener} that listens for clicks to any of the items displayed
     */
    MeshListItemClickedListener clickedListener = null;
    /**
     * {@link MeshListItemSelectedListener MeshListItemSelectedListener} that listens for selection of any of the items displayed
     */
    MeshListItemSelectedListener selectedListener = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Constructor=======================================

    /**
     * Default Constructor
     * @param context required by all widgets
     * @param attrs attributes from XML
     */
    public BittelCustomListView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MeshTVCustomListView, 0, 0);
        try
        {
            type = a.getInt(R.styleable.MeshTVCustomListView_type,TYPE_PAGED);
            target = a.getInt(R.styleable.MeshTVCustomListView_target,0);
            max = a.getInt(R.styleable.MeshTVCustomListView_maxViewed,5);
            layout = a.getResourceId(R.styleable.MeshTVCustomListView_item_layout,0);
            if(layout==0)
            {
                throw new RuntimeException("Mars: Error Inflating "+this.getClass().getSimpleName()+" XML File");
            }
            layout_selected = a.getResourceId(R.styleable.MeshTVCustomListView_item_layout_selected,layout);
            layout_pressed = a.getResourceId(R.styleable.MeshTVCustomListView_item_layout_pressed,layout_selected);
            displayed = new ArrayList<>();
            setFocusable(true);
            setFocusableInTouchMode(true);
            needsFocus = a.getBoolean(R.styleable.MeshTVCustomListView_needs_focus,false);
        }
        finally
        {
            a.recycle();
        }
        if(type==TYPE_CAROUSEL)
        {
            index=target;
        }
    }
    //==============================================================================================
    //================================================Method========================================
    //------------------------------------------------Action----------------------------------------

    /**
     * Removes all the views
     */
    public final void clear()
    {
        removeAllViews();
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Navigation--------------------------------------

    /**
     * Moves the selection to the next item or back (RIGHT/DOWN)
     */
    public final void next()
    {
        if(isFocused()||!needsFocus)
        {
            switch (type)
            {
                case TYPE_PAGED:
                    index++;
                    if(index<adapter.getAllItems().size())
                    {
                        if(index>displayed.get(displayed.size()-1))
                        {
                            first=first+max;
                            setDisplayed();
                        }
                        else
                        {
                            drawDisplayed();
                        }
                    }
                    else
                    {
                        index =adapter.getAllItems().size()-1;
                    }
                    break;
                case TYPE_CONTINUOUS:
                    index++;
                    if(index<adapter.getAllItems().size())
                    {
                        if(index>displayed.get(displayed.size()-1))
                        {
                            first++;
                            setDisplayed();
                        }
                        else
                        {
                            drawDisplayed();
                        }
                    }
                    else
                    {
                        index = adapter.getAllItems().size()-1;
                    }
                    break;
                case TYPE_CAROUSEL:
                    index = target;
                    first++;
                    if(first%adapter.getAllItems().size()==0)
                    {
                        first=0;
                    }
                    setDisplayed();
                    break;
            }
        }

    }
    /**
     * Moves the selection to the previous item or back (LEFT/UP)
     */
    public final void prev()
    {
        if(isFocused()||!needsFocus)
        {
            switch (type)
            {
                case TYPE_PAGED:
                    index--;
                    if(index>=0)
                    {
                        if(index<displayed.get(0))
                        {
                            first=first-max;
                            setDisplayed();
                        }
                        else
                        {
                            drawDisplayed();
                        }
                    }
                    else
                    {
                        index = 0;
                    }
                    break;
                case TYPE_CONTINUOUS:
                    index--;
                    if(index>=0)
                    {
                        if(index<displayed.get(0))
                        {
                            first=first-1;
                            setDisplayed();
                        }
                        else
                        {
                            drawDisplayed();
                        }
                    }
                    else
                    {
                        index = 0;
                    }
                    break;
                case TYPE_CAROUSEL:
                    index = target;
                    first--;
                    if(first<0)
                    {
                        first=adapter.getAllItems().size();
                    }
                    setDisplayed();
                    break;
            }
        }

    }

    /**
     * Triggers click event to the currently selected item
     */
    public final void select()
    {
        if(isFocused()||!needsFocus)
        {
            if(clickedListener!=null)
            {
                clickedListener.onClicked(adapter.getSelected());
            }
            else
            {

            }
        }

    }
    public final void select(int index)
    {
        Log.i(TAG,"Selecting - ================================================================");
        Log.i(TAG,"Selecting - select("+index+")");
        boolean channelOutbound = false;
        int ctr = 0;
        if(adapter!=null)
        {
            if(adapter.getAllItems().get(0) instanceof MeshChannel)
            {
                channelOutbound = true;
                for(Object o:adapter.getAllItems())
                {

                    MeshChannel channel = (MeshChannel)o;
                    Log.i(TAG,"Selecting - Channel:"+channel.getId());
                    Log.i(TAG,"Selecting - Channel:"+channel.getOrder_no());
                    Log.i(TAG,"Selecting - Channel:"+channel.getChannel_title());
                    if(channel.getOrder_no()==index)
                    {
                        Log.i(TAG,"Selecting - GOTCHA!");
                        channelOutbound = false;
                        index = ctr;
                        break;
                    }
                    ctr++;
                }
            }
            if(!channelOutbound)
            {
                switch (type)
                {
                    case TYPE_CAROUSEL:
                        Log.i(TAG,"Selecting - updated select("+index+")");
                        Log.i(TAG,"Selecting - valid index");
                        if(adapter!=null)
                        {
                            Log.i(TAG,"Selecting - adapter found");
                            adapter.setSelectedItemIndex(index);
                            if(clickedListener!=null)
                            {
                                Log.i(TAG,"Selecting - clickListener found");
                                clickedListener.onClicked(adapter.getSelected());
                                int mid = (max -1)/2;
                                first = index-mid;

                                Log.i(TAG,"Selecting - mid(1):"+mid);
                                Log.i(TAG,"Selecting - first(1):"+first);
                                if(first<0)
                                {
                                    first = first+adapter.getAllItems().size();
                                }
                                else
                                {
                                    mid=first+mid;
                                }

                                Log.i(TAG,"Selecting - mid(2):"+mid);
                                Log.i(TAG,"Selecting - first(2):"+first);
                                setIndex(index);
                            }
                            else
                            {
                                Log.i(TAG,"Selecting - clickListener null");
                            }
                        }
                        else
                        {
                            Log.i(TAG,"Selecting - adapter null");
                        }
                        break;

                    case TYPE_CONTINUOUS:
                        Log.i(TAG,"Selecting - updated select("+index+")");
                        Log.i(TAG,"Selecting - valid index");
                        Log.i(TAG,"Selecting - continuous");
                        setIndex(index);
                        break;
                }


            }

        }

        Log.i(TAG,"Selecting - ================================================================");
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------Displayed--------------------------------------------

    /**
     * Sets the index of the selected item
     * @param index index to be selected
     */
    final void setIndex(int index)
    {
        if(adapter.getAllItems().get(0) instanceof MeshChannel)
        {
            this.index = index;
            setDisplayed();
        }

    }

    /**
     * Updates the list of displayed Items
     */
    private final void setDisplayed()
    {
        final String tag  = "setDisplayed()";
        int maxCounter;
        if(displayed==null)
        {
            displayed = new ArrayList<>();
        }
        displayed.clear();
        switch (type)
        {
            case TYPE_PAGED:

                maxCounter = first;
                for(int ctr = 0; ctr<max;ctr++)
                {
                    displayed.add(first+ctr);
                    maxCounter++;
                    if(maxCounter>adapter.getAllItems().size()-1)
                    {
                        break;
                    }
                }
                drawDisplayed();
                break;
            case TYPE_CONTINUOUS:
                if(adapter.getAllItems().get(0) instanceof MeshChannel)
                {
                    if (first == -1)
                    {
                        first = 0;
                    }
                    boolean isFound = false;
                    do
                    {
                        maxCounter = first;
                        Log.i(TAG,"setDisplayed() - =================================================================");
                        Log.i(TAG,"setDisplayed(): "+first);
                        Log.i(TAG,"setDisplayed(): "+max);

                        displayed.clear();
                        for(int c = 0;c<max;c++)
                        {
                            if (c < adapter.getAllItems().size())
                            {
                                Log.i(TAG,"setDisplayed() - ------------------------------------------------------------------");
                                Log.i(TAG,"setDisplayed() MAX:"+max);
                                Log.i(TAG,"setDisplayed() C:"+c);
                                Log.i(TAG,"setDisplayed() ORDER:"+((MeshChannel)adapter.getAllItems().get(c)).getOrder_no());
                                Log.i(TAG,"setDisplayed() INDEX:"+index);
                                Log.i(TAG,"setDisplayed() FIRST:"+first);
                                Log.i(TAG,"setDisplayed() - ------------------------------------------------------------------");
                                if((c+first)>adapter.getAllItems().size())
                                {
                                    if(((MeshChannel)adapter.getAllItems().get(first)).getOrder_no()-1==index)
                                    {
                                        Log.i(TAG,"setDisplayed() - FOUND");
                                        isFound = true;
                                    }
                                    else
                                    {
                                        Log.i(TAG,"setDisplayed() - "+(((MeshChannel)adapter.getAllItems().get(first)).getOrder_no()-1)+" != "+index);
                                    }

                                    if(c+first<adapter.getAllItems().size())
                                    {
                                        displayed.add(first);
                                    }
                                    else
                                    {
                                        displayed.add(adapter.getAllItems().size()-1);
                                    }

                                }
                                else
                                {
                                    Log.w(TAG, "TEST-123 FIRST:" + first);
                                    Log.w(TAG, "TEST-123 C:" + c);
                                    Log.w(TAG, "TEST-123 ITEMS:" + adapter.getAllItems().size());
                                    Log.w(TAG, "TEST-123 INDEX:" + index);

                                    if (first != -1)
                                    {

                                        if(c+first<adapter.getAllItems().size())
                                        {
                                            if(((MeshChannel)adapter.getAllItems().get(c+first)).getOrder_no()-1==index)
                                            {
                                                Log.i(TAG,"setDisplayed() - FOUND");
                                                isFound = true;

                                            }
                                            else
                                            {
                                                Log.i(TAG,"setDisplayed() - "+(((MeshChannel)adapter.getAllItems().get(c+first)).getOrder_no()-1)+" != "+index);
                                            }

                                            if(c+first<adapter.getAllItems().size())
                                            {
                                                displayed.add(c+first);
                                                isFound=true;
                                            }
                                            else
                                            {
                                                displayed.add(adapter.getAllItems().size()-1);
                                                isFound = true;
                                            }
                                        }

                                    }
                                    else
                                    {
                                        first = 0;
                                        displayed.add(c+first);
                                        isFound = true;
                                    }


                                }


                                maxCounter++;
                            }

                        }

                        if(!isFound)
                        {
                            if(first>(index-1))
                            {
                                if(first>-1)
                                {
                                    first--;
                                }
                                else
                                {
                                    isFound = true;
                                }

                            }
                            else
                            {
                                first++;
                            }
                        }



                        Log.i(TAG,"setDisplayed() - =================================================================");
                    }while (!isFound);



                    drawDisplayed();
                }
                else
                {
                    maxCounter = first;
                    for(int ctr = 0; ctr<max;ctr++)
                    {
                        displayed.add(first+ctr);
                        maxCounter++;
                        if(maxCounter>adapter.getAllItems().size()-1)
                        {
                            break;
                        }
                    }
                    drawDisplayed();
                }

                break;
            case TYPE_CAROUSEL:

                for(int ctr = 0; ctr<max;ctr++)
                {
                    if(first+ctr<adapter.getAllItems().size())
                    {
                        displayed.add(first+ctr);
                    }
                    else
                    {
                        displayed.add((first+ctr)%adapter.getAllItems().size());
                    }
                }
                drawDisplayed();
                break;
        }

        Log.i(TAG,"drawDisplayed() DISPLAYED:"+displayed.size());

    }


    /**
     * Draws all items included in {@link #displayed displayed}
     */
    private final void drawDisplayed()
    {
        removeAllViews();

        if(type==TYPE_CAROUSEL)
        {

            int ctr = 0;
            for(int i : displayed)
            {
                if(index==ctr)
                {
                    adapter.setSelectedItem(adapter.getAllItems().get(i));
                    adapter.setSelectedItemIndex(i);
                    View v = LayoutInflater.from(getContext()).inflate(layout_selected,this,false);
                    adapter.bindView(v,adapter.getAllItems().get(i));
                    addView(v);
                    if(selectedListener!=null)
                    {
                        selectedListener.onSelected(adapter.getSelected());
                    }
                }
                else
                {
                    View v = LayoutInflater.from(getContext()).inflate(layout,this,false);
                    adapter.bindView(v,adapter.getAllItems().get(i));
                    addView(v);
                }
                ctr++;
            }
        }
        else
        {
            Log.i(TAG,"drawDisplayed() - ========================================================================");
            Log.i(TAG,"drawDisplayed() - ADAPTER SIZE:"+adapter.getAllItems().size());
            Log.i(TAG,"drawDisplayed() - DISPLAYED SIZE:"+displayed.size());

            for(final int i : displayed)
            {

                Log.i(TAG,"drawDisplayed() - ------------------------------------------------------------------------");
                Log.i(TAG,"drawDisplayed() - DISPLAYED:"+i);

                if(index==i)
                {
                    Log.i(TAG,"drawDisplayed() - SELECTED");
                    adapter.setSelectedItem(adapter.getAllItems().get(i));
                    adapter.setSelectedItemIndex(i);
                    View v = LayoutInflater.from(getContext()).inflate(layout_selected,this,false);
                    v.setClickable(true);
                    v.setFocusable(true);
                    v.setFocusableInTouchMode(true);
                    v.setOnHoverListener(new OnHoverListener()
                    {
                        @Override
                        public boolean onHover(View view, MotionEvent motionEvent)
                        {
                            index = i;
                            setDisplayed();
                            return false;
                        }
                    });
                    v.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MeshTVApp.get().getApplicationContext(),"TEST",Toast.LENGTH_LONG).show();

                        }
                    });
                    adapter.bindView(v,adapter.getAllItems().get(i));
                    addView(v);

                    if(selectedListener!=null)
                    {
                        if(adapter!=null)
                        {
                            if(adapter.getSelected()!=null)
                            {
                                selectedListener.onSelected(adapter.getSelected());
                            }
                        }

                    }
                }
                else
                {
                    Log.i(TAG,"drawDisplayed() - NOT SELECTED");
                    View v = LayoutInflater.from(getContext()).inflate(layout,this,false);
                    v.setClickable(true);
                    v.setFocusableInTouchMode(true);
                    v.setFocusable(true);


                    v.setOnHoverListener(new OnHoverListener()
                    {
                        @Override
                        public boolean onHover(View v, MotionEvent event) {
                            index = i;
                            adapter.setSelectedItem(adapter.getAllItems().get(index));
                            adapter.setSelectedItemIndex(index);
                            setDisplayed();
                            return true;
                        }
                    });
                    v.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View view)
                        {
                            Toast.makeText(MeshTVApp.get().getApplicationContext(),"TEST",Toast.LENGTH_LONG).show();
                        }
                    });
                    adapter.bindView(v,adapter.getAllItems().get(i));

                    addView(v);
                }

                Log.i(TAG,"drawDisplayed() - ------------------------------------------------------------------------");

            }
            Log.i(TAG,"drawDisplayed() - ========================================================================");

        }
        setAddStatesFromChildren(true);

    }

    //----------------------------------------------------------------------------------------------

    //-----------------------------------------------Update-----------------------------------------
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Getter----------------------------------------

    /**
     * Returns a reference to the {@link MeshTVCustomAdapter MeshTVCustomAdapter} being displayed
     * @return displayed {@link MeshTVCustomAdapter MeshTVCustomAdapter}
     */
    public final MeshTVCustomAdapter getAdapter() {return adapter;}
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Setter----------------------------------------

    /**
     * Changes the {@link MeshTVCustomAdapter MeshTVCustomAdapter} being displayed
     * @param adapter new {@link MeshTVCustomAdapter MeshTVCustomAdapter} to be displayed
     */
    public final void setAdapter(MeshTVCustomAdapter adapter)
    {
        Log.i(TAG,"=================================setAdapter==================================");
        this.adapter = adapter;
        removeAllViews();
        Log.i(TAG,"setAdapter : "+adapter.getAllItems().size());
        Log.i(TAG,"=================================setAdapter==================================");
        setDisplayed();
    }

    /**
     * Sets the {@link MeshListItemClickedListener MeshListItemClickedListener} to listen to Click Events
     * @param clickedListener {@link MeshListItemClickedListener MeshListItemClickedListener} to listen to Click Events
     */
    public void setClickedListener(MeshListItemClickedListener clickedListener) {
        this.clickedListener = clickedListener;
    }
    /**
     * Sets the {@link MeshListItemSelectedListener MeshListItemSelectedListener} to listen to Selection Events
     * @param selectedListener {@link MeshListItemSelectedListener MeshListItemSelectedListener} to listen to Selection Events
     */
    public void setSelectedListener(MeshListItemSelectedListener selectedListener) {
        this.selectedListener = selectedListener;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Listener=======================================

    //==============================================================================================
}
