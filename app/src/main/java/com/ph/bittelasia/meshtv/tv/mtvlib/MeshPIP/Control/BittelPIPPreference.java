package com.ph.bittelasia.meshtv.tv.mtvlib.MeshPIP.Control;

import android.content.Context;
import android.content.SharedPreferences;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;

/**
 * Created by mars on 12/7/17.
 */

class BittelPIPPreference
{
    //===============================================Variable=======================================
    //-----------------------------------------------Constant---------------------------------------
    public static final String TAG              = BittelPIPPreference.class.getSimpleName();
    public static final String TAG_WIDTH        = BittelPIPPreference.class.getSimpleName()+"_width";
    public static final String TAG_HEIGHT       = BittelPIPPreference.class.getSimpleName()+"_height";
    public static final String TAG_X            = BittelPIPPreference.class.getSimpleName()+"_x";
    public static final String TAG_Y            = BittelPIPPreference.class.getSimpleName()+"_y";
    public static final String TAG_URL          = BittelPIPPreference.class.getSimpleName()+"_uri";
    public static final String TAG_SEEK         = BittelPIPPreference.class.getSimpleName()+"_seek";
    public static final String TAG_CAN_SEEK     = BittelPIPPreference.class.getSimpleName()+"_seekable";
    public static final String TAG_IS_MOVABLE   = BittelPIPPreference.class.getSimpleName()+"_movable";
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Instance---------------------------------------

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //================================================Method========================================
    //------------------------------------------------Width-----------------------------------------
    static int getPIPWidth(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        return preferences.getInt(TAG_WIDTH,0);
    }
    static void setPIPWidth(Context context,int width)
    {
        SharedPreferences preferences = context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(TAG_WIDTH,width);
        editor.commit();
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Height----------------------------------------
    static int getPIPHeight(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        return preferences.getInt(TAG_HEIGHT,0);
    }
    static void setPIPHeight(Context context,int height)
    {
        SharedPreferences preferences = context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(TAG_HEIGHT,height);
        editor.commit();
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------------x-------------------------------------------
    static int getPIPX(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        return preferences.getInt(TAG_X,0);
    }
    static void setPIPX(Context context,int x)
    {
        SharedPreferences preferences = context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(TAG_X,x);
        editor.commit();
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------------y-------------------------------------------
    static int getPIPY(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        return preferences.getInt(TAG_Y,0);
    }
    static void setPIPY(Context context,int y)
    {
        SharedPreferences preferences = context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(TAG_Y,y);
        editor.commit();
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------URL-------------------------------------------
    static String getPIPURL(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        return preferences.getString(TAG_URL,"n/a");
    }
    static void setPIPURL(Context context,String url)
    {
        SharedPreferences preferences = context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TAG_URL,url);
        editor.commit();
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Seek------------------------------------------
    static long getPIPSeek(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        return preferences.getLong(TAG_SEEK,0);
    }
    static void setPIPSeek(Context context,long seek)
    {
        SharedPreferences preferences = context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(TAG_SEEK,seek);
        editor.commit();
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Can Seek------------------------------------------
    static boolean getPIPCanSeek(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        return preferences.getBoolean(TAG_CAN_SEEK,false);
    }
    static void setPIPCanSeek(Context context,boolean canSeek)
    {
        SharedPreferences preferences = context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(TAG_CAN_SEEK,canSeek);
        editor.commit();
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Is Movable----------------------------------------
    static boolean isMovable(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        return preferences.getBoolean(TAG_IS_MOVABLE,true);
    }
    static void setIsMovable(Context context,boolean canSeek)
    {
        SharedPreferences preferences = context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(TAG_IS_MOVABLE,canSeek);
        editor.commit();
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================


}
