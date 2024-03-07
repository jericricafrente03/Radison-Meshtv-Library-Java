package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener;

/**
 * Listens to result of {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Getter.MeshTVGetTask MeshTVGetTask}
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public interface MeshDataListener
{
    /**
     * Triggered when server is unreachable
     * @param c Class requested
     */
    public void onNoNetwork(Class c);
    /**
     * Triggered when no data is received
     * @param c Class requested
     */
    public void onNoData(Class c);

    /**
     * Triggered when no message was parsed
     * @param c Class requested
     * @param message Reason while parsing failed
     */
    public void onParseFailed(Class c,String message);

    /**
     * Triggered when file is not found
     * @param c Class Requested
     * @param message Reason while file was not found
     */
    public void onFileNotFound(Class c,String message);

    /**
     * Triggered when Data was received
     * @param c Class requested
     * @param size number of objects prased
     */
    public void onDataReceived(Class c,int size);

}
