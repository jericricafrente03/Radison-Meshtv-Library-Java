package com.ph.bittelasia.meshtv.tv.mtvlib.ExoPlayer.View.Fragment;

/**
 * Created by mars on 12/18/17.
 */

public abstract class MeshTVExoplayerFragment extends BittelExoplayerFragment
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshTVExoplayerFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Action-------------------------------------------
    public final void stopPlayer()
    {
        stopExo();
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Getter-------------------------------------------
    public final String getOBJUrl()
    {
        return getUrl();
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public final void setObjectURL(String url)
    {
        setUrl(url);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================


}