package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
/**
 * Manages the IPTV preference of the STB
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
class IPTVPreference
{
    //================================================Variable======================================
    //------------------------------------------------Constant--------------------------------------
    static final String TAG                         = IPTVPreference.class.getSimpleName();
    /**
     * Tag for room number
     */
    static final String TAG_ROOM                    = "APIKeyPreference_PREF_ROOM";
    /**
     * Tag for XMPP username
     */
    static final String TAG_XMPP_USERNAME           = "XMPPPreference_USERNAME";
    /**
     * Tag for XMPP password
     */
    static final String TAG_XMPP_PASSWORD           = "XMPPPreference_PASSWORD";
    /**
     * Tag for XMPP service
     */
    static final String TAG_XMPP_SERVICE            = "XMPPPreference_SERVICE";
    /**
     * Tag for XMPP Host
     */
    static final String TAG_XMPP_HOST               = "XMPPPreference_HOST";
    /**
     * Tag for XMPP port
     */
    static final String TAG_XMPP_PORT               = "XMPPPreference_PORT";
    /**
     * Tag for HTTP host
     */
    static final String TAG_HTTP_HOST               = "HTTPPreference_HOST";
    /**
     * Tag for HTTP port
     */
    static final String TAG_HTTP_PORT               = "HTTPPreference_PORT";
    /**
     * Tag for HTTP request timeout
     */
    static final String TAG_HTTP_TIMEOUT            = "HTTPPreference_TIMEOUT";
    /**
     * Tag for HTTP connection timeout
     */
    static final String TAG_HTTP_CON_TIMEOUT        = "HTTPPreference_CONTIMEOUT";
    /**
     * Tag for MeshTV version
     */
    static final String TAG_VER                     = "APIKeyPreference_PREF_VERSION";
    /**
     * Default Room number
     */
    static final String DEFAULT_ROOM                = "NS";
    /**
     * Default XMPP Username
     */
    static final String DEFAULT_XMPP_USERNAME       = "NS";
    /**
     * Default XMPP Password
     */
    static final String DEFAULT_XMPP_PASSWORD       = "hello123";
    /**
     * Default XMPP Service
     */
    static final String DEFAULT_XMPP_SERVICE        = "NS";
    /**
     * Default XMPP Host
     */
    static final String DEFAULT_XMPP_HOST           = "NS";
    /**
     * Default XMPP Port
     */
    static final int DEFAULT_XMPP_PORT              = 5222;
    /**
     * Default HTTP Host
     */
    static final String DEFAULT_HTTP_HOST           = "NS";
    /**
     * Default HTTP Port
     */
    static final int DEFAULT_HTTP_PORT              = 6060;
    /**
     * Default HTTP Request timeout
     */
    static final int DEFAULT_HTTP_TIMEOUT           = 30000;
    /**
     * Default HTTP Connection timeout
     */
    static final int DEFAULT_HTTP_CON_TIMEOUT       = 30000;
    /**
     * Default MeshTV Version
     */
    static final String DEFAULT_VER                 = "4.0";
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===================================================Room=======================================
    /**
     * Retrieve room preference
     * @param context required to access preference
     * @return room preference
     */
    static final String getRoom(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        String result = preferences.getString(TAG_ROOM,DEFAULT_ROOM);
        return result;
    }
    /**
     * Sets the room preference
     * @param context required to access preference
     * @param value new value for room
     */
    static final void setRoom(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TAG_ROOM,value);
        editor.commit();
    }
    //==============================================================================================
    //==================================================Username====================================
    /**
     * Retrieve username preference
     * @param context required to access preference
     * @return username preference
     */
    static final String getUsername(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        String result = preferences.getString(TAG_XMPP_USERNAME,DEFAULT_XMPP_USERNAME);
        return result;
    }
    /**
     * Sets the username preference
     * @param context required to access preference
     * @param value new value for username
     */
    static final void setUsername(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TAG_XMPP_USERNAME,value);
        editor.commit();
    }
    //==============================================================================================
    //==================================================Password====================================
    /**
     * Retrieve password preference
     * @param context required to access preference
     * @return password preference
     */
    static final String getPassword(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        String result = preferences.getString(TAG_XMPP_PASSWORD,DEFAULT_XMPP_PASSWORD);
        return result;
    }
    /**
     * Sets the password preference
     * @param context required to access preference
     * @param value new value for password
     */
    static final void setPassword(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TAG_XMPP_PASSWORD,value);
        editor.commit();
    }
    //==============================================================================================
    //==================================================Service=====================================
    /**
     * Retrieve service preference
     * @param context required to access preference
     * @return service preference
     */
    static final String getService(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        String result = preferences.getString(TAG_XMPP_SERVICE,DEFAULT_XMPP_SERVICE);
        return result;
    }
    /**
     * Retrieve service preference
     * @param context required to access preference
     * @return service preference
     */
    static final void setService(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TAG_XMPP_SERVICE,value);
        editor.commit();
    }
    //==============================================================================================
    //===================================================XHost======================================
    /**
     * Retrieve XMPP Host preference
     * @param context required to access preference
     * @return XMPP Host preference
     */
    static final String getXMPPHost(Context context)
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
        String result = preferences.getString(TAG_XMPP_HOST,DEFAULT_XMPP_HOST);
        return result;
    }
    /**
     * Retrieve XMPP Host preference
     * @param context required to access preference
     * @return XMPP Host preference
     */
    static final void setXMPPHost(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TAG_XMPP_HOST,value);
        editor.commit();
    }
    //==============================================================================================
    //===================================================XPort======================================
    /**
     * Retrieve XMPP Port preference
     * @param context required to access preference
     * @return XMPP Port preference
     */
    static final int getXMPPPort(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        int result = preferences.getInt(TAG_XMPP_PORT,DEFAULT_XMPP_PORT);

        return result;
    }
    /**
     * Sets the XMPP Port preference
     * @param context required to access preference
     * @param value new value for XMPP Port
     */
    static final void setXMPPPort(Context context,int value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(TAG_XMPP_PORT, value);
        editor.commit();
    }
    //==============================================================================================
    //===================================================HPort======================================
    /**
     * Retrieve HTTP Port preference
     * @param context required to access preference
     * @return HTTP Port preference
     */
    static final int getHTTPPort(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        int result = preferences.getInt(TAG_HTTP_PORT,DEFAULT_HTTP_PORT);

        return result;
    }
    /**
     * Sets the HTTP Port preference
     * @param context required to access preference
     * @param value new value for HTTP Port
     */
    static final void setHTTPPort(Context context,int value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(TAG_HTTP_PORT,value);
        editor.commit();
    }
    //==============================================================================================
    //===================================================HHost======================================
    /**
     * Retrieve HTTP Host preference
     * @param context required to access preference
     * @return HTTP Host preference
     */
    static final String getHTTPHost(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        String result = preferences.getString(TAG_HTTP_HOST,DEFAULT_HTTP_HOST);

        return result;
    }
    /**
     * Sets the HTTP Host preference
     * @param context required to access preference
     * @param value new value for HTTP Host
     */
    static final void setHTTPHost(Context context,String value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TAG_HTTP_HOST,value);
        editor.commit();
    }
    //==============================================================================================
    //==================================================Timeout=====================================
    /**
     * Retrieve HTTP Request Timeout preference
     * @param context required to access preference
     * @return HTTP Request Timeout preference
     */
    static final int getTimeout(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        int result = preferences.getInt(TAG_HTTP_TIMEOUT,DEFAULT_HTTP_TIMEOUT);

        return result;
    }
    /**
     * Sets the HTTP Request Timeout preference
     * @param context required to access preference
     * @param value new value for HTTP Request Timeout
     */
    static final void setTimeout(Context context,int value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(TAG_HTTP_TIMEOUT,value);
        editor.commit();
    }
    //==============================================================================================
    //============================================Connection Timeout================================

    /**
     * Retrieve HTTP Connection Timeout preference
     * @param context required to access preference
     * @return HTTP Connection Timeout preference
     */
    static final int getConTimeout(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        int result = preferences.getInt(TAG_HTTP_CON_TIMEOUT,DEFAULT_HTTP_CON_TIMEOUT);

        return result;
    }
    /**
     * Sets the HTTP Connection Timeout preference
     * @param context required to access preference
     * @param value new value for HTTP Connection Timeout
     */
    static final void setConTimeout(Context context,int value)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(TAG_HTTP_CON_TIMEOUT,value);
        editor.commit();
    }
    //==============================================================================================
    //==================================================Version=====================================
    /**
     * Retrieve version preference
     * @param context required to access preference
     * @return version preference
     */
    static final String getVersion(Context context)
    {
        SharedPreferences preferences = null;
        if(context == null)
        {
            preferences = MeshTVApp.get().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
        else
        {
            preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }        String result = preferences.getString(TAG_VER,DEFAULT_VER);

        return result;
    }

    /**
     * Sets the version preference
     * @param context required to access preference
     * @param value new value for version
     */
    static final void setVersion(Context context,String value)
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
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TAG_VER,value);
        editor.commit();
    }
    //==============================================================================================
}
