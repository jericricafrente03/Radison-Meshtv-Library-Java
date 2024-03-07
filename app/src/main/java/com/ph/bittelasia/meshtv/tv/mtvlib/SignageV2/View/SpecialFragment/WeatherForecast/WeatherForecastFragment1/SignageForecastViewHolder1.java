package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.WeatherForecast.WeatherForecastFragment1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.ViewHolder.ViewHolderLayout;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.VH.MeshTVVHolder;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecastDay;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment1.SignageListViewHolder1;
@ViewHolderLayout
public class SignageForecastViewHolder1 extends MeshTVVHolder<MeshWeatherForecastDay>
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = SignageForecastViewHolder1.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------View-------------------------------------------
    ImageView iv_icon;
    TextView tv_day;
    TextView tv_temp;
    TextView tv_desc;

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    public ImageView getIv_icon() {
        return iv_icon;
    }
    public TextView getTv_day() {
        return tv_day;
    }
    public TextView getTv_temp() {
        return tv_temp;
    }
    public TextView getTv_desc() {
        return tv_desc;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

    //==========================================MeshTVVHolder=======================================
    @Override
    public void inflate(View v) {
        super.inflate(v);
        iv_icon = v.findViewById(R.id.iv_icon);
        tv_day = v.findViewById(R.id.tv_day);
        tv_temp = v.findViewById(R.id.tv_temp);
        tv_desc = v.findViewById(R.id.tv_desc);



    }
    //==============================================================================================

}
