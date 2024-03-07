package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.TimeMethod;

import android.os.Handler;

/**
 * Represents timed methods which are methods that are invoked on a specified delay. This enables developer to suspend and resume timed methods.
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshTimedMethod
{
    //============================================Variable==========================================
    //--------------------------------------------Instance------------------------------------------
    /**
     * Handler that will execute the Timed Metho
     */
    Handler handler;
    /**
     * Runnable that the handler will execute
     */
    Runnable runnable;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Action-------------------------------------------

    /**
     * Pauses or suspends a Timed Method
     */
    public void pause()
    {
        try
        {
            handler.removeCallbacks(runnable);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Resumes a timed method
     */
    public void resume()
    {
        handler.post(runnable);
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Getter-------------------------------------------

    /**
     * Gets the {@link #handler handler} of the {@link MeshTimedMethod MeshTimedMethod}
     * @return {@link #handler handler} of the {@link MeshTimedMethod MeshTimedMethod}
     */
    public Handler getHandler() {
        return handler;
    }

    /**
     * Gets the {@link #runnable runnable} of the {@link MeshTimedMethod MeshTimedMethod}
     * @return {@link #runnable runnable} of the {@link MeshTimedMethod MeshTimedMethod}
     */
    public Runnable getRunnable() {
        return runnable;
    }

    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------

    /**
     * Sets the {@link #handler handler} of the {@link MeshTimedMethod MeshTimedMethod}
     * @param handler new {@link #handler handler} {@link MeshTimedMethod MeshTimedMethod}
     */
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    /**
     * Sets the {@link #runnable runnable} of the {@link MeshTimedMethod MeshTimedMethod}
     * @param runnable new {@link #runnable runnable} {@link MeshTimedMethod MeshTimedMethod}
     */
    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
