package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.WeatherForecast.WeatherForecastFragment5;

import android.content.Context;
import android.widget.GridView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.ResourceManager.MeshResourceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.VH.MeshTVVHolder;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecastDay;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.WeatherForecast.WeatherForecastFragment4.SignageForecastViewHolder4;

import java.util.ArrayList;

@com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.ViewHolder.ViewHolderLayout()
public class SignageForecastAdapter5 extends MeshTVAdapter<MeshWeatherForecastDay>{

    public SignageForecastAdapter5(Context context, GridView gv_view, int layoutResourceId, ArrayList<MeshWeatherForecastDay> data) {
        super(context, gv_view, layoutResourceId, data);
    }

    @Override
    public MeshTVVHolder setViewHolder() {
        return new SignageForecastViewHolder5();
    }

    @Override
    public void updateRow(MeshTVVHolder vh, MeshWeatherForecastDay o) {
        SignageForecastViewHolder5 svh = (SignageForecastViewHolder5)vh;
        svh.getTv_day().setText(o.getDay_of_week());
        svh.getTv_temp().setText(o.getTemp()+" °C");
        svh.getTv_desc().setText(o.getDescription());
        MeshResourceManager.displayLiveImageFor(svh.iv_icon.getContext(),svh.iv_icon,o.getIcon());

    }

    @Override
    public int setLayout() {
        return R.layout.signage_weather_forecast_item_5;
    }
}
