package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomMessage.PopUp;


import android.view.View;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.CustomMessage.PopUpSettings;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;

import java.util.ArrayList;

public abstract class BittelPopPupFragment extends MeshTVFragment<Object>
{

    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = BittelPopPupFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    MeshMessage message;
    boolean isDrawn = false;
    PopUpSettings settings = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    @Override
    protected void onDrawDone(View v) {
        isDrawn = true;
        settings = getClass().getAnnotation(PopUpSettings.class);
        if(settings==null)
        {
            throw new RuntimeException("PopUpSettings Annotation is Required");
        }
        if(message!=null)
        {

        }
    }

    @Override
    protected void onDataUpdated(ArrayList<Object> items) {

    }

    @Override
    protected void onNewData(Object o) {

    }

    @Override
    protected void onDataUpdated(Object o, int index) {

    }

    @Override
    protected void onDeleteData(int index) {

    }

    @Override
    protected void onClearData() {

    }

    @Override
    protected void onDataNotFound(Class c) {

    }

    @Override
    protected void refresh() {

    }

    @Override
    protected void update(Object item) {

    }
    //==============================================================================================
    //=============================================Method===========================================
    //-------------------------------------------Setter---------------------------------------------
    public void setMessage(MeshMessage message)
    {
        this.message = message;
        if(isDrawn)
        {
            displayMessage(message);
        }
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Getter--------------------------------------------
    public int getTextId()
    {
        if(settings!=null)
        {
            return settings.messageId();
        }

        return -1;
    }
    public int getImageId()
    {
        if(settings!=null)
        {
            return settings.imageId();
        }
        return -1;
    }
    public int getVideoContainer()
    {
        if(settings!=null)
        {
            return settings.videoContainerId();
        }
        return -1;
    }
    public boolean isScrolling()
    {
        if(settings!=null)
        {
            return settings.isScrollingMessage();
        }
        return false;
    }
    public boolean isTimed()
    {
        if(settings!=null)
        {
            return settings.isTimedPopUp();
        }
        return false;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Abstract=========================================
    public abstract void displayMessage(MeshMessage meshMessage);
    //==============================================================================================

}
