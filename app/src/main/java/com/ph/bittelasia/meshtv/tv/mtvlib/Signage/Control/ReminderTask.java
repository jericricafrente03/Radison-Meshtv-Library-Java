package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Control;

import android.app.Activity;
import android.content.Context;


import androidx.viewpager.widget.ViewPager;

import java.util.Timer;
import java.util.TimerTask;

public abstract class ReminderTask extends TimerTask {

    public abstract Activity getActivity();

    public abstract int getCurrentPage();

    public abstract int pageCount();

    public abstract Timer getTimer();

    public abstract ViewPager getPager();


    @Override
    public void run() {
       getActivity().runOnUiThread(new Runnable() {
            public void run() {

                if (getCurrentPage() > pageCount()) {
                    getTimer().cancel();
                } else {
                    getPager().setCurrentItem(getCurrentPage());
                }
            }
        });
    }
}
