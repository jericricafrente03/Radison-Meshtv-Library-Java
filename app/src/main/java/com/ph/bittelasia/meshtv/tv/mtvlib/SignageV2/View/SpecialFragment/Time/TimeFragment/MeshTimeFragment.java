package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Time.TimeFragment;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ph.bittelasia.meshtv.tv.mtvlib.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class MeshTimeFragment extends Fragment
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshTimeFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    int layoutId = -1;
    int timeId = -1;
    int dateId = -1;
    SimpleDateFormat dateFormat;
    SimpleDateFormat timeFormat;
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------View--------------------------------------------
    TextClock tc_clock;
    TextView tv_date;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================LifeCycle=========================================
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = null;
        layoutId = setLayoutId();
        v = inflater.inflate(layoutId,container,false);
        return v;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

            if(setDateId()>0)
            {
                dateFormat = new SimpleDateFormat(setDateFormat()==null?"MMM dd, yyyy":setDateFormat());
                tv_date = (TextView) view.findViewById(setDateId());
                updateDate();
            }

            if(setTimeId()>0)
            {
                timeFormat = new SimpleDateFormat(setTimeFormat()==null?"hh:mm aa":setDateFormat());
                tc_clock = (TextClock) view.findViewById(setTimeId());
                updateTime();
            }




    }

    //==============================================================================================
    //===============================================Method=========================================
    //-----------------------------------------------Action-----------------------------------------
    public void updateTime()
    {
        if(tc_clock!=null&&timeFormat!=null)
        {
            tc_clock.setFormat12Hour(setTimeFormat()==null?"hh:mm aa":setTimeFormat());
        }
    }
    public void updateDate()
    {
        if(tv_date!=null&&dateFormat!=null)
        {
            tv_date.setText(dateFormat.format(new Date()));
        }
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Getter-----------------------------------------
    public TextClock getTc_clock() {
        return tc_clock;
    }
    public TextView getTv_date() {
        return tv_date;
    }
    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }
    public SimpleDateFormat getTimeFormat() {
        return timeFormat;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //========================================Abstract==============================================
    public abstract int setLayoutId();
    public abstract int setTimeId();
    public abstract int setDateId();
    public abstract String setDateFormat();
    public abstract String setTimeFormat();
    //==============================================================================================
}
