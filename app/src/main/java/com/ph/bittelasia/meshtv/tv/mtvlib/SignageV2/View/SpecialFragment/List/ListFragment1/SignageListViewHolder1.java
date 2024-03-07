package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Widget.BindWidget;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.VH.MeshTVVHolder;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;

public class SignageListViewHolder1 extends MeshTVVHolder<MeshTVFeed>
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = SignageListViewHolder1.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------View-------------------------------------------
    ImageView iv_event;
    TextView tv_owner;
    TextView tv_name;
    TextView tv_location;
    TextView tv_schedule;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    public ImageView getIv_event() {
        return iv_event;
    }
    public TextView getTv_owner() {
        return tv_owner;
    }
    public TextView getTv_name() {
        return tv_name;
    }
    public TextView getTv_location() {
        return tv_location;
    }
    public TextView getTv_schedule() {
        return tv_schedule;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

    //==========================================MeshTVVHolder=======================================
    @Override
    public void inflate(View v) {
        super.inflate(v);
        iv_event = v.findViewById(R.id.iv_event);
        tv_owner = v.findViewById(R.id.tv_owner);
        tv_name = v.findViewById(R.id.tv_name);
        tv_location = v.findViewById(R.id.tv_location);
        tv_schedule = v.findViewById(R.id.tv_schedule);


    }
    //==============================================================================================

}
