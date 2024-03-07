package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

/**
 * Created by Mars on 3/5/2018.
 */

class ChannelPreferenceManager {
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    static final String TAG = ChannelPreferenceManager.class.getSimpleName();

    static final String CHANNEL_CURRENT_ID = "current_id";
    static final String CHANNEL_CURRENT_URL = "current_url";
    static final String CHANNEL_CURRENT_INDEX = "current_index";
    static final String CHANNEL_CURRENT_NAME = "current_name";
    static final String CHANNEL_CURRENT_IMG = "current_img";
    static final String CHANNEL_PREV_ONE = "channel_prev_1";
    static final String CHANNEL_PREV_TWO = "channel_prev_2";
    static final int CHANNEL_CURRENT_ID_DEF = -1;
    static final String CHANNEL_CURRENT_URL_DEF = null;
    static final int CHANNEL_CURRENT_INDEX_DEF = -1;
    static final String CHANNEL_CURRENT_NAME_DEF = null;
    static final String CHANNEL_CURRENT_IMG_DEF = null;
    static final int CHANNEL_PREV_ONE_DEF = -1;
    static final int CHANNEL_PREV_TWO_DEF = -1;

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Action=========================================
    static final void reset(Context context)
    {
        setCurrentID(context,CHANNEL_CURRENT_ID_DEF);
        setCurrentUrl(context,CHANNEL_CURRENT_URL_DEF);
        setCurrentIndex(context,CHANNEL_CURRENT_INDEX_DEF);
        setCurrentName(context,CHANNEL_CURRENT_NAME_DEF);
        setChannelCurrentImage(context,CHANNEL_CURRENT_IMG_DEF);
        setPrev1ID(context,CHANNEL_PREV_ONE_DEF);
        setPrev2ID(context,CHANNEL_PREV_TWO_DEF);
    }

    //==============================================================================================
    //==============================================Preference======================================
    private static final SharedPreferences getPreference(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        return preferences;
    }
    private static final SharedPreferences.Editor getEditor(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        return preferences.edit();
    }
    //==============================================================================================

    //=============================================Current ID======================================
    /**
     * Retrieve id of the current channel being tuned in
     * @param context required to access preference
     * @return id of current channel
     */
    static final int getCurrentID(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        int result = preferences.getInt(CHANNEL_CURRENT_ID,CHANNEL_CURRENT_ID_DEF);
        return result;
    }
    /**
     * Sets the current channel id being tuned in
     * @param context required to access preference
     * @param value new value for channel id
     */
    static final void setCurrentID(Context context,int value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putInt(CHANNEL_CURRENT_ID,value);
        editor.commit();
    }
    //==============================================================================================

    //=================================================URL==========================================
    /**
     * Retrieve url of the current channel being tuned in
     * @param context required to access preference
     * @return url of current channel
     */
    static final String getCurrentURL(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(CHANNEL_CURRENT_URL,CHANNEL_CURRENT_URL_DEF);
        return result;
    }
    /**
     * Sets the current channel url being tuned in
     * @param context required to access preference
     * @param value new value for channel url
     */
    static final void setCurrentUrl(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(CHANNEL_CURRENT_URL,value);
        editor.commit();
    }
    //==============================================================================================
    //===========================================Current Index======================================
    /**
     * Retrieve index of the current channel being tuned in
     * @param context required to access preference
     * @return index of current channel
     */
    static final int getCurrentIndex(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        int result = preferences.getInt(CHANNEL_CURRENT_INDEX,CHANNEL_CURRENT_INDEX_DEF);
        return result;
    }
    /**
     * Sets the current channel index being tuned in
     * @param context required to access preference
     * @param value new value for channel id
     */
    static final void setCurrentIndex(Context context,int value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putInt(CHANNEL_CURRENT_INDEX,value);
        editor.commit();
    }
    //==============================================================================================
    //===========================================Current Name=======================================
    /**
     * Retrieve index of the name of current channel being tuned in
     * @param context required to access preference
     * @return name of current channel
     */
    static final String getCurrentName(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(CHANNEL_CURRENT_NAME,CHANNEL_CURRENT_NAME_DEF);
        return result;
    }
    /**
     * Sets the name of current channel being tuned in
     * @param context required to access preference
     * @param value new name of current channel
     */
    static final void setCurrentName(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(CHANNEL_CURRENT_NAME,value);
        editor.commit();
    }
    //==============================================================================================
    //==========================================Current Image======================================
    /**
     * Retrieve index of the image url of current channel being tuned in
     * @param context required to access preference
     * @return image url of current channel
     */
    static final String getChannelCurrentImage(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        String result = preferences.getString(CHANNEL_CURRENT_IMG,CHANNEL_CURRENT_IMG_DEF);
        return result;
    }
    /**
     * Sets the image url of current channel being tuned in
     * @param context required to access preference
     * @param value new image url of current channel
     */
    static final void setChannelCurrentImage(Context context,String value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(CHANNEL_CURRENT_IMG,value);
        editor.commit();
    }
    //==============================================================================================
    //==============================================Prev1 ID========================================
    /**
     * Retrieve id of the prev1 channel being tuned in
     * @param context required to access preference
     * @return id of prev1 channel
     */
    static final int getPrev1ID(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        int result = preferences.getInt(CHANNEL_PREV_ONE,CHANNEL_PREV_ONE_DEF);
        return result;
    }
    /**
     * Sets the prev1 channel id being tuned in
     * @param context required to access preference
     * @param value new value for prev1 channel id
     */
    static final void setPrev1ID(Context context,int value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putInt(CHANNEL_PREV_ONE,value);
        editor.commit();
    }
    //==============================================================================================
    //==============================================Prev2 ID========================================
    /**
     * Retrieve id of the prev2 channel being tuned in
     * @param context required to access preference
     * @return id of prev2 channel
     */
    static final int getPrev2ID(Context context)
    {
        SharedPreferences preferences = getPreference(context);
        int result = preferences.getInt(CHANNEL_PREV_TWO,CHANNEL_PREV_TWO_DEF);
        return result;
    }
    /**
     * Sets the prev2 channel id being tuned in
     * @param context required to access preference
     * @param value new value for prev2 channel id
     */
    static final void setPrev2ID(Context context,int value)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putInt(CHANNEL_PREV_TWO,value);
        editor.commit();
    }
    //==============================================================================================

}
