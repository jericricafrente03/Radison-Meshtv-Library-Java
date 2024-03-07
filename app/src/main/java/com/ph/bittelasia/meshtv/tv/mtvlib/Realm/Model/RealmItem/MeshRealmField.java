package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RealmItem;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MeshRealmField
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = MeshRealmField.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    int order = -1;
    String displayName = null;
    String hint = null;
    String tag = null;
    Class dataType = null;
    DecimalFormat decimalFormat = null;
    ArrayList<Object> choices = null;
    boolean editable = true;
    Object value;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Constructor======================================
    public MeshRealmField(String tag, int order,Object o,boolean editable)
    {
        this.tag = tag;
        this.order = order;
        this.dataType = o.getClass();
        this.editable = editable;
        this.value = o;
    }
    public MeshRealmField(String displayName,String tag, int order,Object o,boolean editable)
    {
        this.displayName = displayName;
        this.tag = tag;
        this.order = order;
        this.dataType = o.getClass();
        this.editable = editable;
        this.value = o;

    }
    public MeshRealmField(String displayName,String hint,String tag, int order,Object o,boolean editable)
    {
        this.displayName = displayName;
        this.hint = hint;
        this.tag = tag;
        this.order = order;
        this.dataType = o.getClass();
        this.editable = editable;
        this.value = o;

    }
    //==============================================================================================
    //===============================================Method=========================================
    //-----------------------------------------------Getter-----------------------------------------
    public Object getValue() {
        return value;
    }
    public String getDisplayName() {
        return displayName;
    }
    public String getHint() {
        return hint;
    }
    public boolean isEditable() {return editable;}
    public String getTag() {
        return tag;
    }
    public int getOrder() {
        return order;
    }
    public Class getDataType() {
        return dataType;
    }
    public DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Setter-----------------------------------------
    public void setValue(Object value) {
        this.value = value;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public void setHint(String hint) {
        this.hint = hint;
    }
    public void setEditable(boolean editable) {this.editable = editable;}
    public void setTag(String tag) {
        this.tag = tag;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public void setDataType(Class dataType) {
        this.dataType = dataType;
    }
    public void setDecimalFormat(DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
