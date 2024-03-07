package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomMessage.PopUp;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.CustomMessage.PopUpSettings;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Dialog.MeshTVDialogFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;

abstract class BittelPopUpDialog extends MeshTVDialogFragment
{
    //==========================================Variable============================================
    //------------------------------------------Constant--------------------------------------------
    public static final String TAG = BittelPopUpDialog.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Instance--------------------------------------------
    MeshMessage message;
    boolean isDrawn = false;
    PopUpSettings settings = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=====================================MeshTVDialogFragment=====================================
    @Override
    public void drawDone()
    {
        isDrawn = true;
        settings = getClass().getAnnotation(PopUpSettings.class);
        if(settings==null)
        {
            throw new RuntimeException("PopUpSettings Annotation is Required");
        }
        if(message!=null)
        {
            displayMessage(message);
        }
    }
    //==============================================================================================
    //===========================================Method=============================================
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

    //============================================Abstract==========================================
    public abstract void displayMessage(MeshMessage meshMessage);
    //==============================================================================================
}
