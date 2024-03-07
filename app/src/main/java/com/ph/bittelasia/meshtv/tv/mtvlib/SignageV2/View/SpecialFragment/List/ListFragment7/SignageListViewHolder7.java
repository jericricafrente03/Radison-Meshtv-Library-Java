package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment7;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.VH.MeshTVVHolder;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment1.SignageListViewHolder1;

public class SignageListViewHolder7 extends MeshTVVHolder<MeshTVFeed>
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = SignageListViewHolder1.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------View-------------------------------------------
    ImageView iv_logo;
    TextView tv_event;
    TextView tv_description;
    TextView tv_location;
    TextView tv_time;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    public ImageView getIv_logo() {
        return iv_logo;
    }
    public TextView getTv_event() {
        return tv_event;
    }
    public TextView getTv_description() {
        return tv_description;
    }
    public TextView getTv_location() {
        return tv_location;
    }
    public TextView getTv_time() {
        return tv_time;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==========================================MeshTVVHolder=======================================
    @Override
    public void inflate(View v)
    {
        super.inflate(v);
        iv_logo = v.findViewById(R.id.iv_logo);
        tv_event = v.findViewById(R.id.tv_event);
        tv_description = v.findViewById(R.id.tv_description);
        tv_location = v.findViewById(R.id.tv_location);
        tv_time = v.findViewById(R.id.tv_time);
    }
    //==============================================================================================

}
