package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Getter;

import android.content.Context;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.API.Listeners.MeshParamListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Manager.MeshTVDataManager;

/**
 * Provide access to data requests
 * {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshAirport MeshAirport}
 * <br>
 * Implements {@link MeshParamListener MeshParamListener} to set parameters for the API call
 * <br>
 * <br>Version 2.0 added support for:
 * <br>1. {@link MeshAdditionalParam MeshAdditionalParam}
 * @author Mars Ray Canizares Araullo
 * @version 2.0
 */
public class MeshTVGetTask extends BittelGetTask
{
    /**
     * Requests data and receives response through {@link MeshDataListener MeshDataListener}
     * @param c - Class of Data requested
     * @param listener - receives the response
     */
    public MeshTVGetTask(Class c, MeshDataListener listener)
    {
        super(c, listener);
    }
    /**
     * Requests data and receives response through {@link MeshDataListener MeshDataListener}
     * @param context - custom context if null will use Application Context
     * @param datasource - custom datasource that overrides what is set in AppSetting
     * @param c - Class of Data requested
     * @param listener - receives the response
     */
    public MeshTVGetTask(Context context,int datasource,Class c, MeshDataListener listener)
    {
        super(context,datasource,c, listener);

    }

    /**
     * Requests data and receives response through {@link MeshDataListener MeshDataListener}
     * @param context - custom context if null will use Application Context
     * @param source - custom datasource that overrides what is set in AppSetting
     * @param listener - receives the response
     * @param data - data from XMPP
     */
    public MeshTVGetTask(Context context,int source,MeshDataListener listener,String data)
    {
        super(context,source,listener,data);

    }
    /**
     * @param c Requested class of data
     * @param listener Listens for the result of the request
     * @param additionalParam interface to add additional parameters to the query
     */
    public MeshTVGetTask(Class c, MeshDataListener listener,MeshAdditionalParam additionalParam)
    {
        super(c,listener,additionalParam);
    }
}
