package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Query;

import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmListener;

/**
 * Name value pair used for realm queries using {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmManager#retrieve(Class, MeshRealmListener, MeshValuePair...) MeshRealmManager.retrieve(Class, MeshRealmListener, MeshValuePair...)}
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshValuePair
{
    //==========================================Variable============================================
    //------------------------------------------Constant--------------------------------------------
    public static final String TAG = MeshValuePair.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Instance--------------------------------------------
    /**
     * Field/Column name of the data to be used to filter the search
     */
    String fieldName;
    /**
     * Value of the Field/Column used to filter the search
     */
    Object value;
    /**
     * Values:
     * <br>True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmManager MeshRealmManager} will treat {@link #value value} as a String
     * <br>False - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmManager MeshRealmManager} will treat {@link #value value} as an integer
     */
    boolean isString = true;
    //----------------------------------------------------------------------------------------------
    // =============================================================================================
    //==========================================Constructor=========================================

    /**
     * Default constructor that takes the Field/Column name and the value being looked for
     * @param fieldName Field/Column name of the filter
     * <br>Most Objects has a static value of their field/column names (e.g., {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage#TAG_ID MeshMessage.TAG_ID} which pertains to the ID of the {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage MeshMessage})
     * @param value value of the field being queried (e.g., 1 will look for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage#id com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage#id} with the value 1)
     */
    public MeshValuePair(String fieldName,Object value)
    {
        this.fieldName = fieldName;
        this.value = value;
        if(value instanceof String)
        {
            isString = true;
        }
        else
        {
            isString = false;
        }
        Log.i(TAG,"Fieldname:"+fieldName);
        Log.i(TAG,"Value:"+value);
        Log.i(TAG,"Is String:"+isString);


    }
    //==============================================================================================
    //===========================================Method=============================================
    //-------------------------------------------Getter---------------------------------------------
    /**
     * Gets the {@link #fieldName fieldName} of the {@link MeshValuePair MeshValuePair}
     * @return {@link #fieldName fieldName} of the {@link MeshValuePair MeshValuePair}
     */
    public String getFieldName() {
        return fieldName;
    }
    /**
     * Gets the {@link #value value} of the {@link MeshValuePair MeshValuePair}
     * @return {@link #value value} of the {@link MeshValuePair MeshValuePair}
     */
    public Object getValue() {
        return value;
    }
    /**
     * Gets the {@link #isString isString} of the {@link MeshValuePair MeshValuePair}
     * @return {@link #isString isString} of the {@link MeshValuePair MeshValuePair}
     */
    public boolean isString() {
        return isString;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Setter---------------------------------------------
    /**
     * Sets {@link MeshValuePair MeshValuePair} {@link #fieldName fieldName}
     * @param fieldName new {@link MeshValuePair MeshValuePair}  {@link #fieldName fieldName}
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    /**
     * Sets {@link MeshValuePair MeshValuePair} {@link #value value}
     * @param value new {@link MeshValuePair MeshValuePair}  {@link #value value}
     */
    public void setValue(Object value) {
        this.value = value;
    }
    /**
     * Sets {@link MeshValuePair MeshValuePair} {@link #isString isString}
     * @param isString new {@link MeshValuePair MeshValuePair}  {@link #isString isString}
     */
    public void setString(boolean isString) {
        this.isString = isString;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
