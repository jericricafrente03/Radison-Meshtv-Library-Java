package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Table;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshEPGTableFactory;

import java.util.ArrayList;

public abstract class MeshTVTableFactory<T,Rows,Columns> extends BittelTableFactory<T,Rows,Columns>
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = MeshTVTableFactory.class.getSimpleName();


    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Constructor======================================
    public MeshTVTableFactory(Activity activity, int backgroundColorResId) {
        super(activity, backgroundColorResId);
    }
    public MeshTVTableFactory(MeshTVFragment fragment, int backgroundColorResId) {
        super(fragment, backgroundColorResId);
    }
    public MeshTVTableFactory(MeshTVFragment fragment, int backgroundColorResId,int containerID) {
        super(fragment, backgroundColorResId,containerID);
    }
    //==============================================================================================
    //================================================Method========================================
    //------------------------------------------------View------------------------------------------
    public void createTable()
    {
        createTableLayout();
    }
    public void createSchedule()
    {
        createScheduleLayout();
    }
    public void spanCell(View v,int span)
    {
        span(v,span);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Getter------------------------------------------
    public ArrayList<Columns> getAdapterColumns()
    {
        return getColumns();
    }
    public ArrayList<Rows> getAdapterRows()
    {
        return getRows();
    }
    public ArrayList<T> getAdapterItems()
    {
        return getItems();
    }
    public TableLayout getTable()
    {
        return table;
    }
    public MeshTVTableListener getTableListener() {
        return getListener();
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Setter------------------------------------------
    public void setAdapterColumns(ArrayList<Columns> columns) {
        setColumns(columns);
    }
    public void setAdapterRows(ArrayList<Rows> rows)
    {
        setRows(rows);
    }
    public void setAdapterItems(ArrayList<T> items)
    {
        setItems(items);
    }
    public void setLayout(int layout)
    {
        setItemLayout(layout);
    }
    public void setColumnLayout(int columnLayout)
    {
        setColumnHeaderLayout(columnLayout);
    }
    public void setRowLayout(int rowLayout)
    {
        setRowHeaderLayout(rowLayout);
    }

    public void setTableListener(MeshTVTableListener listener) {
       setListener(listener);
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------BittelTableAdapter----------------------------

    @Override
    final protected void bind(View v, T object) {
        bindItem(v,object);
    }

    @Override
    final protected void bindColumn(View v, Columns object) {
        bindColumnItem(v,object);
    }

    @Override
    final protected void bindRowHeader(View v, Rows object) {
        bindRowItem(v,object);
    }

    @Override
    final protected void bindFirstColumn(View v, String s) {
        bindFirstColumnItem(v,s);
    }

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==================================================Abstract====================================
    public abstract void bindItem(View v,T object);
    public abstract void bindColumnItem(View v,Columns object);
    public abstract void bindRowItem(View v,Rows object);
    public abstract void bindFirstColumnItem(View v, String item);
    //==============================================================================================
}
