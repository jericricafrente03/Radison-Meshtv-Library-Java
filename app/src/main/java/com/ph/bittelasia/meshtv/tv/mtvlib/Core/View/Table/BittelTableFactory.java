package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Table;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshEPG;

import java.util.ArrayList;

abstract class BittelTableFactory<T,Rows,Columns>
{
    //===============================================Variable=======================================
    //-----------------------------------------------Constant---------------------------------------
    public static final String TAG = BittelTableFactory.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------View-----------------------------------------
    TableLayout table;
    ScrollView sv;
    HorizontalScrollView hsv;

    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Instance--------------------------------------
    private ArrayList<Rows> rows;
    private ArrayList<Columns> columns;
    private ArrayList<T> items;
    private T selected;
    private int selectedIndex = -1;
    private View parent;
    private int backgroundColorResId;
    private int itemLayout = -1;
    private int columnHeaderLayout = -1;
    private int rowHeaderLayout = -1;
    private int parentID = -1;
    private TableLayout.LayoutParams tableLayoutParams;
    TableRow.LayoutParams tableRowParams;
    private Activity activity;
    MeshTVTableListener listener;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Constructor====================================

    public BittelTableFactory(Activity activity, int backgroundColorResId)
    {
        this.activity = activity;
        parent = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        this.items = new ArrayList<>();
        this.columns = new ArrayList<>();
        this.rows = new ArrayList<>();
        this.sv = new ScrollView(parent.getContext());
        this.hsv = new HorizontalScrollView(parent.getContext());
        this.backgroundColorResId = backgroundColorResId;
        if(parent == null)
        {
            throw  new RuntimeException("Please provide a reference to the root view");
        }
        this.parent = parent;
        tableRowParams = new TableRow.LayoutParams();
//        tableRowParams.setMargins(1, 1, 1, 1);
//        tableRowParams.weight = 1;
    }
    public BittelTableFactory(MeshTVFragment fragment, int backgroundColorResId)
    {
        this.activity = fragment.getActivity();
        parent = fragment.getFragmentView();
        this.items = new ArrayList<>();
        this.columns = new ArrayList<>();
        this.rows = new ArrayList<>();
        this.sv = new ScrollView(parent.getContext());
        this.hsv = new HorizontalScrollView(parent.getContext());
        this.backgroundColorResId = backgroundColorResId;
        if(parent == null)
        {
            throw  new RuntimeException("Please provide a reference to the root view");
        }
        tableRowParams = new TableRow.LayoutParams();
//        tableRowParams.setMargins(1, 1, 1, 1);
//        tableRowParams.weight = 1;
    }
    public BittelTableFactory(MeshTVFragment fragment, int backgroundColorResId,int parentID)
    {
        this.activity = fragment.getActivity();
        parent = fragment.getFragmentView();
        this.parentID = parentID;
        this.items = new ArrayList<>();
        this.columns = new ArrayList<>();
        this.rows = new ArrayList<>();
        this.sv = new ScrollView(parent.getContext());
        this.hsv = new HorizontalScrollView(parent.getContext());
        this.backgroundColorResId = backgroundColorResId;
        tableRowParams = new TableRow.LayoutParams();
    }
    //==============================================================================================
    //============================================Method============================================
    //--------------------------------------------Schedule------------------------------------------
    final protected void createScheduleLayout()
    {
        Log.i(TAG,"createSchedule =============================================================");
        tableLayoutParams = new TableLayout.LayoutParams();
        table = new TableLayout(parent.getContext());
        table.setBackgroundColor(this.backgroundColorResId);
        hsv.addView(table);
        sv.addView(hsv);
        if(parentID==-1)
        {
            activity.setContentView(sv);
        }
        else
        {
            ((LinearLayout)activity.findViewById(parentID)).addView(sv);
        }
        Log.i(TAG,"createSchedule =============================================================");
        attachScheduleColumns();
        attachScheduleRow();
    }
    final protected void attachScheduleColumns()
    {
        Log.i(TAG,"attachScheduleColumns =============================================================");
        TableRow tableRow = new TableRow(parent.getContext());
        LayoutInflater inflater2 = LayoutInflater.from(table.getContext());
        View v1 = inflater2.inflate(columnHeaderLayout,(ViewGroup) table.getParent(),false);
        bindFirstColumn(v1,"Today");
        tableRow.setBackgroundColor(this.backgroundColorResId);
        tableRow.addView(v1,tableRowParams);
        for(Columns c:columns)
        {
            Log.i(TAG,"ATTACHING SCHEDULE COLUMNS:"+columnHeaderLayout);
            tableRow.setBackgroundColor(this.backgroundColorResId);
            LayoutInflater inflater = LayoutInflater.from(table.getContext());
            View v = inflater.inflate(columnHeaderLayout,(ViewGroup) table.getParent(),false);
            bindColumn(v,c);
            tableRow.addView(v,tableRowParams);
        }
        table.addView(tableRow,tableLayoutParams);
        Log.i(TAG,"attachScheduleColumns =============================================================");
    }
    final protected void attachScheduleRow()
    {
        Log.i(TAG,"attachScheduleRow =============================================================");
        int span = getHeaderSpan();
        for(Rows r:rows)
        {
            Log.i(TAG,"attachScheduleRow - ATTACHING SCHEDULED ROWS:"+rowHeaderLayout);
            TableRow.LayoutParams rowSpanLayout = new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
            rowSpanLayout.span = span;
            TableRow tableRow = new TableRow(parent.getContext());
            tableRow.setBackgroundColor(this.backgroundColorResId);
            LayoutInflater inflater = LayoutInflater.from(table.getContext());
            View v = inflater.inflate(rowHeaderLayout,(ViewGroup) table.getParent(),false);
            v.setLayoutParams(rowSpanLayout);
            tableRow.addView(v,rowSpanLayout);
            bindRowHeader(v,r);
            Log.i(TAG,"attachScheduleRow - Columns:"+columns.size());
            MeshEPG prev = null;
            for(int ctr =0;ctr<columns.size();ctr++)
            {
                Log.i(TAG, "attachScheduleRow - Attaching Items");
                Columns c = columns.get(ctr);
                T t = getToDisplay(c, r);
                if (prev == null)
                {
                    Log.i(TAG, "Not Duplicate");
                    LayoutInflater inflater2 = LayoutInflater.from(table.getContext());
                    View v2 = inflater2.inflate(itemLayout, (ViewGroup) table.getParent(), false);
                    int span2 = getSpan(t);
                    if (span > 0)
                    {
                        if (t != null)
                        {
                            Log.i(TAG, "CUSTOM SPAN:" + t.getClass().getSimpleName());
                            if (t instanceof MeshEPG)
                            {
                                MeshEPG epg = (MeshEPG) t;
                                Log.i(TAG, "EPG:" + epg.getProgram_name());
                            }
                        }
                        TableRow.LayoutParams rowP = span(v2, span2);
                        tableRow.addView(v2, rowP);
                        bind(v2, t);
                    }
                    else
                    {
                        Log.i(TAG, "REGULAR SPAN");
                        tableRow.addView(v2, tableRowParams);
                        bind(v2, t);
                    }
                    prev = (MeshEPG) t;
                }
                else
                {
                    if(t!=null)
                    {
                        if(prev.getId() != ((MeshEPG) t).getId())
                        {
                            Log.i(TAG, "Not Duplicate");
                            LayoutInflater inflater2 = LayoutInflater.from(table.getContext());
                            View v2 = inflater2.inflate(itemLayout, (ViewGroup) table.getParent(), false);
                            int span2 = getSpan(t);
                            if (span > 0)
                            {
                                if (t != null)
                                {
                                    Log.i(TAG, "CUSTOM SPAN:" + t.getClass().getSimpleName());
                                    if (t instanceof MeshEPG)
                                    {
                                        MeshEPG epg = (MeshEPG) t;
                                        Log.i(TAG, "EPG:" + epg.getProgram_name());
                                    }
                                }
                                TableRow.LayoutParams rowP = span(v2, span2);
                                tableRow.addView(v2, rowP);
                                bind(v2, t);
                            }
                            else
                            {
                                Log.i(TAG, "REGULAR SPAN");
                                tableRow.addView(v2, tableRowParams);
                                bind(v2, t);
                            }
                            prev = (MeshEPG) t;
                        }
                        else
                        {
                            Log.i(TAG, "Duplicate");
                        }
                    }
                    else
                    {

                    }
                }
            }
            table.addView(tableRow,tableLayoutParams);
        }
        Log.i(TAG,"attachScheduleRow =============================================================");
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------View---------------------------------------------
    final protected void createTableLayout()
    {
        tableLayoutParams = new TableLayout.LayoutParams();
        table = new TableLayout(parent.getContext());
        table.setBackgroundColor(this.backgroundColorResId);

        hsv.addView(table);
        sv.addView(hsv);
        activity.setContentView(sv);
        attachColumns();
        attachRows();
    }
    final private void attachColumns()
    {
        TableRow tableRow = new TableRow(parent.getContext());
        for(Columns c:columns)
        {
            Log.i(TAG,"ATTACHING COLUMNS");
            tableRow.setBackgroundColor(this.backgroundColorResId);
            LayoutInflater inflater = LayoutInflater.from(table.getContext());
            View v = inflater.inflate(columnHeaderLayout,(ViewGroup) table.getParent(),false);
            bindColumn(v,c);
            tableRow.addView(v,tableRowParams);
        }
        table.addView(tableRow,tableLayoutParams);
    }
    final private void attachRows()
    {
        Log.i(TAG,"ROWS");
        int span = getHeaderSpan();
        for(Rows r:rows)
        {
            Log.i(TAG,"ATTACHING ROWS");
            TableRow.LayoutParams rowSpanLayout = new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
            rowSpanLayout.span = span;
            TableRow tableRow = new TableRow(parent.getContext());
            tableRow.setBackgroundColor(this.backgroundColorResId);
            LayoutInflater inflater = LayoutInflater.from(table.getContext());
            View v = inflater.inflate(rowHeaderLayout,(ViewGroup) table.getParent(),false);
            v.setLayoutParams(rowSpanLayout);
            tableRow.addView(v,rowSpanLayout);
            bindRowHeader(v,r);
            attachCells(filter(items,r),tableRow);
            table.addView(tableRow,tableLayoutParams);
        }
    }
    final private void attachCells(ArrayList<T> display,TableRow row)
    {
        Log.i(TAG,"CELLS");
        if(display!=null)
        {
            ArrayList<T> displayed = new ArrayList<>();
            for(T i:display)
            {
                boolean dupe = false;

                for(T i2:displayed)
                {
                    dupe =checkDuplicate(i,i2);
                    if(dupe)
                    {
                        break;
                    }
                }

                if(!dupe)
                {
                    Log.i(TAG,"ATTACHING CELLS");
                    LayoutInflater inflater = LayoutInflater.from(table.getContext());
                    View v = inflater.inflate(itemLayout,(ViewGroup) table.getParent(),false);
                    int span = getSpan(i);
                    Log.i(TAG,"SPAN:"+span);
                    if(span>0)
                    {
                        Log.i(TAG,"CUSTOM SPAN");
                        TableRow.LayoutParams rowP = span(v,span);
                        row.addView(v,rowP);
                        bind(v,i);
                    }
                    else
                    {
                        Log.i(TAG,"REGULAR SPAN");
//                    row.addView(v,tableRowParams);
//                    bind(v,i);
                        TableRow.LayoutParams rowP = span(v,span);
                        row.addView(v,rowP);
                        bind(v,i);
                    }
                    displayed.add(i);
                }


            }
        }

    }

    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Action--------------------------------------------
    final private void draw()
    {
        if (parent != null)
        {
            if(items!=null)
            {
                if(items.size()>0)
                {
                    for(T o:items)
                    {
                        bind(parent,o);
                    }
                }
            }
        }
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Getter--------------------------------------------
    final protected ArrayList<T> getItems() {
        return items;
    }
    final protected ArrayList<Rows> getRows() {
        return rows;
    }
    final protected ArrayList<Columns> getColumns() {
        return columns;
    }
    final protected T getSelected() {
        return selected;
    }
    final protected int getSelectedIndex() {
        return selectedIndex;
    }

    final protected int getItemLayout() {
        return itemLayout;
    }
    final protected int getColumnHeaderLayout() {
        return columnHeaderLayout;
    }
    final protected int getRowHeaderLayout() {
        return rowHeaderLayout;
    }
    final protected MeshTVTableListener getListener() {
        return listener;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Setter--------------------------------------------
    final protected void setColumns(ArrayList<Columns> columns)
    {
        this.columns = new ArrayList<>();
        this.columns.addAll(columns);
    }
    final protected void setListener(MeshTVTableListener listener) {
        this.listener = listener;
    }
    final protected void setRows(ArrayList<Rows> rows)
    {
        this.rows = new ArrayList<>();
        this.rows.addAll(rows);
    }
    final protected void setItems(ArrayList<T> items)
    {
        this.items = new ArrayList<>();
        this.items.addAll(items);
    }
    final protected void setSelected(T selected) {
        this.selected = selected;
    }
    final protected void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }


    final protected void setItemLayout(int itemLayout) {
        this.itemLayout = itemLayout;
    }

    final protected  void setColumnHeaderLayout(int columnHeaderLayout) {
        this.columnHeaderLayout = columnHeaderLayout;
    }

    final protected  void setRowHeaderLayout(int rowHeaderLayout) {
        this.rowHeaderLayout = rowHeaderLayout;
    }

    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Span---------------------------------------------
    final protected TableRow.LayoutParams span(View v,int span)
    {
        TableRow.LayoutParams rowSpanLayout = new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        rowSpanLayout.span = span;
        v.setLayoutParams(rowSpanLayout);
        return rowSpanLayout;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Abstract==========================================
    protected abstract void bind(View v,T object);
    protected abstract void bindColumn(View v,Columns object);
    protected abstract void bindFirstColumn(View v,String s);
    protected abstract void bindRowHeader(View v,Rows object);
    protected abstract int getHeaderSpan();
    protected abstract int getSpan(T object);
    protected abstract T getToDisplay(Columns c,Rows r);
    protected abstract ArrayList<T> filter(ArrayList<T> items,Rows r);
    protected abstract boolean checkDuplicate(T o1,T o2);
    //==============================================================================================
}
