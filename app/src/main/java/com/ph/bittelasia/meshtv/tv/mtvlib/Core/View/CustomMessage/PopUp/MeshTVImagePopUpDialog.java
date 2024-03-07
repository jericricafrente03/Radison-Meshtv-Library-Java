package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomMessage.PopUp;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.ResourceManager.MeshResourceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.CustomScrollingTextView.MeshTVScrollingTextView;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;


public abstract class MeshTVImagePopUpDialog extends BittelPopUpDialog
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshTVImagePopUpDialog.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    Handler h;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            dismiss();
        }
    };
    MeshMessage meshMessage;
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------View--------------------------------------------
    ImageView iv_image;
    TextView tv_message;
    MeshTVScrollingTextView tv_message_scrolling;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================BittelPopUpDialog===================================
    @Override
    public void drawDone()
    {
        super.drawDone();
        if(getImageId()>-1)
        {
            iv_image = (ImageView)getView().findViewById(getImageId());
        }
        if(isScrolling())
        {
            if(getTextId()>-1)
            {
                tv_message_scrolling = (MeshTVScrollingTextView)getView().findViewById(getTextId());
            }
        }
        else
        {
            if(getTextId()>-1)
            {
                tv_message = (TextView)getView().findViewById(getTextId());
            }
        }
        if(meshMessage!=null)
        {
            displayMessage(meshMessage);
        }

    }
    @Override
    public void displayMessage(MeshMessage meshMessage)
    {
        this.meshMessage  = meshMessage;
        if(isTimed())
        {
            if(h==null)
            {
                h = new Handler();
            }
            h.removeCallbacks(runnable);
            h.postDelayed(runnable,meshMessage.getMessg_display_time()*1000);
        }
        if(iv_image!=null)
        {
            MeshResourceManager.displayLiveImageFor(getActivity(),iv_image,meshMessage.getMessg_img());
        }
        if(tv_message!=null)
        {
            tv_message.setText(meshMessage.getMessg_text());
        }
        if(tv_message_scrolling!=null)
        {
            tv_message_scrolling.setText(meshMessage.getMessg_text());
            tv_message_scrolling.setDisplayTime(meshMessage.getMessg_display_time());
        }
    }
    //==============================================================================================
}
