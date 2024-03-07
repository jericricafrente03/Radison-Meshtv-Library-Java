package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Control;

import android.os.CountDownTimer;

import android.util.Log;

import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MeshSignageTimer extends CountDownTimer {

    //========================================Variable==============================================
    //----------------------------------------Constant----------------------------------------------
    public static final String TAG=MeshSignageTimer.class.getSimpleName();
    //----------------------------------------------------------------------------------------------

    //----------------------------------------Instance----------------------------------------------
    MeshSignageRuntimeListener listener;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================


    //========================================Constructor===========================================
    //----------------------------------------------------------------------------------------------
    public MeshSignageTimer(long millisInFuture, long countDownInterval,MeshSignageRuntimeListener l) {
        super(millisInFuture, countDownInterval);
        this.listener=l;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

    //=======================================CountDowntimer=========================================
    //----------------------------------------------------------------------------------------------
    @Override
    public void onTick(long l) {
        try {
            if(listener!=null) {
                Calendar          cal  = Calendar.getInstance(TimeZone.getTimeZone(listener.getTimeZone()));
                Date currentLocalTime  = cal.getTime();
                SimpleDateFormat format= new SimpleDateFormat(listener.getDateFormat(),Locale.ENGLISH);
                Date date              = format.parse(format.format(currentLocalTime));
                if (listener.getSignageList() != null) {
                    for (int i = 0; i < listener.getSignageList().size(); i++) {
                        SimpleDateFormat sf = new SimpleDateFormat(listener.getDateFormat(), Locale.ENGLISH);
                        Date d = sf.parse(listener.getSignageList().get(i).getSchedule_start());
                        if(!d.after(date) && !d.before(date)) {
                            for(Fragment fg:listener.getFragments())
                            {
                                if(i==fg.getArguments().getInt("pos"))
                                {
                                    listener.getViewPager().setCurrentItem(i, true);
                                }
                                else
                                {
                                    Log.i(TAG,"no position");
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish() {
     Log.i(TAG,"CountDownTimer is finished");
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
