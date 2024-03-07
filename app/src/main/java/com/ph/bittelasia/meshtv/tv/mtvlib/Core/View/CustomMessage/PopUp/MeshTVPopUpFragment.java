package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomMessage.PopUp;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.ResourceManager.MeshResourceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.CustomScrollingTextView.MeshTVScrollingTextView;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;

public class MeshTVPopUpFragment extends BittelPopPupFragment
{

    //================================================Variable======================================
    //------------------------------------------------Constant--------------------------------------
    public static final String TAG = MeshTVPopUpFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Instance--------------------------------------
    Handler h;
    PopUpCallBack cb = null;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(cb!=null)
            {
                cb.onHide();
            }
        }
    };
    MeshMessage meshMessage;
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------------View----------------------------------------
    ImageView iv_image;
    TextView tv_message;
    MeshTVScrollingTextView tv_message_scrolling;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================LifeCycle======================================
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if(getActivity() instanceof  PopUpCallBack)
        {
            cb = (PopUpCallBack) getActivity();
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        cb = null;
    }
    //==============================================================================================
    //================================================Method========================================
    //------------------------------------------------Action----------------------------------------
    public void fullsize()
    {
        if(meshMessage!=null)
        {

            if(cb!=null)
            {
                if(h!=null)
                {
                    h.removeCallbacks(runnable);
                }
                cb.onRequestFullSize(meshMessage);
            }

        }
    }
    public void close()
    {
        if(cb!=null)
        {
            cb.onHide();
        }
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Setter----------------------------------------
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================BittelPopUpFragment===============================
    @Override
    protected void onDrawDone(View v) {
        super.onDrawDone(v);
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
    //==========================================MeshTVPopUpFragmentCallBack=========================
    public interface PopUpCallBack
    {
        public abstract void onRequestFullSize(MeshMessage meshMessage);
        public abstract void onHide();
    }
    //==============================================================================================
}
