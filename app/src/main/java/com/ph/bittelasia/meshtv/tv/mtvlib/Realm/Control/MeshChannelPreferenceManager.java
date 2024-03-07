package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control;

import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel;

public class MeshChannelPreferenceManager
{
    //===============================================Variable=======================================
    //-----------------------------------------------Constant---------------------------------------
    public static final String TAG = MeshChannelPreferenceManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //================================================Method========================================
    //------------------------------------------------Stack-----------------------------------------
    public static void push(MeshChannel channel)
    {
        if(channel!=null)
        {
            int ch1 = MeshTVPreferenceManager.getCurrentID(null);
            int ch2 = MeshTVPreferenceManager.getPrev1Id(null);
            int ch3 = MeshTVPreferenceManager.getPrev2Id(null);
            int temp = -1;
            boolean isAlreadyIncluded = false;
            if (ch1 == channel.getId())
            {
                //do nothing
            }
            else
            {
                if (ch2 == channel.getId() || ch3 == channel.getId())
                {
                    isAlreadyIncluded = true;
                }
                if(isAlreadyIncluded)
                {
                    temp = ch1;
                    ch1 = channel.getId();
                    if(ch2==ch1)
                    {
                        ch2 = temp;
                    }
                    else if (ch3 == ch1)
                    {
                        int temp2 = ch2;
                        ch2 = temp;
                        ch3 = temp2;
                    }
                }
                else
                {
                    temp = ch1;
                    ch1 = channel.getId();
                    int temp2 = ch2;
                    ch2 = temp;
                    ch3 = temp2;
                }
            }


            MeshTVPreferenceManager.setCurrentID(null,ch1);

            MeshTVPreferenceManager.setCurrentURL(null,channel.getChannel_uri());
            MeshTVPreferenceManager.setCurrentIndex(null,channel.getOrder_no());
            MeshTVPreferenceManager.setCurrentName(null,channel.getChannel_title());
            MeshTVPreferenceManager.setCurrentImage(null,channel.getChannel_image());

            MeshTVPreferenceManager.setPrev1Id(null,ch2);
            MeshTVPreferenceManager.setPrev2Id(null,ch3);

            Log.i(TAG,"Current ID : "+ch1);
            Log.i(TAG,"Prev One ID : "+ch2);
            Log.i(TAG,"Prev Two ID : "+ch3);
        }
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
