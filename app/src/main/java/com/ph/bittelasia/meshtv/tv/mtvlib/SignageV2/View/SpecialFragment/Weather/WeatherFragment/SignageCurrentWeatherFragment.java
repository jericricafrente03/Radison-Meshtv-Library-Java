package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Weather.WeatherFragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshWeatherLocal;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.ResourceManager.MeshResourceManager;

import java.text.SimpleDateFormat;

public abstract class SignageCurrentWeatherFragment extends Fragment
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = SignageCurrentWeatherFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------View--------------------------------------------
    TextView    tv_date         =   null;
    TextClock   tc_clock        =   null;
    ImageView   iv_icon         =   null;
    TextView    tv_temp         =   null;
    TextView    tv_humidity     =   null;
    TextView    tv_description  =   null;
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    MeshWeatherLocal local  = null;
    int layoutId            = -1;
    int tvDateId            = -1;
    int tcClockId           = -1;
    int ivIconId            = -1;
    int tempId              = -1;
    int humidityId          = -1;
    int descriptionId       = -1;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================LifeCycle==========================================
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = null;
        layoutId            = setLayoutId();
        tvDateId            = setDateId();
        tcClockId           = setTimeId();
        ivIconId            = setIconId();
        tempId              = setTempId();
        humidityId          = setHumidityId();
        descriptionId       = setDescriptionId();

        if(layoutId<1)
        {
            return null;
        }
        v = inflater.inflate(layoutId,container,false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        if(tvDateId>0)
        {
            tv_date = view.findViewById(tvDateId);
            try
            {
                SimpleDateFormat dateFormat = new SimpleDateFormat(setDateFormat()==null?"MMM dd, yyyy":setDateFormat());
                tv_date.setText(dateFormat.format(setDateFormat()));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if(tcClockId>0)
        {
            tc_clock = view.findViewById(tcClockId);
            tc_clock.setFormat12Hour(setTimeFormat()==null?"hh:mm aa":setDateFormat());
        }
        if(ivIconId>0)
        {
            iv_icon = view.findViewById(ivIconId);
        }
        if(tempId>0)
        {
            tv_temp = view.findViewById(tempId);
        }
        if(humidityId>0)
        {
            tv_humidity = view.findViewById(humidityId);
        }
        if(descriptionId>0)
        {
            tv_description = view.findViewById(descriptionId);
        }
        onDrawDone(view);
    }
    //==============================================================================================
    //============================================Method============================================
    //--------------------------------------------Setter--------------------------------------------
    public void setLocal(MeshWeatherLocal local)
    {
        this.local = local;
        if(iv_icon!=null)
        {
            MeshResourceManager.displayLiveImageFor(getActivity(),iv_icon,local.getIcon());
        }
        if(tv_temp!=null)
        {
            tv_temp.setText(local.getTemp_cur()+" °C");
        }
        if(tv_humidity!=null)
        {
            tv_humidity.setText(local.getHumidity()+"");
        }
        if(tv_description!=null)
        {
            tv_description.setText(local.getDescription());
        }
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Getter--------------------------------------------
    public TextView getTv_date() {
        return tv_date;
    }
    public TextClock getTc_clock() {
        return tc_clock;
    }
    public ImageView getIv_icon() {
        return iv_icon;
    }
    public TextView getTv_temp() {
        return tv_temp;
    }
    public TextView getTv_humidity() {
        return tv_humidity;
    }
    public TextView getTv_description() {
        return tv_description;
    }
    public MeshWeatherLocal getLocal() {
        return local;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Setter--------------------------------------------
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Abstract===========================================
    public abstract int setLayoutId();
    public abstract int setDateId();
    public abstract int setTimeId();
    public abstract int setIconId();
    public abstract int setTempId();
    public abstract int setHumidityId();
    public abstract int setDescriptionId();
    public abstract String setDateFormat();
    public abstract String setTimeFormat();
    public abstract void onDrawDone(View v);
    //==============================================================================================

}
