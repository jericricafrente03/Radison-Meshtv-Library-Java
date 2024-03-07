package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment3;

import android.view.View;
import android.widget.TextView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.VH.MeshTVVHolder;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;

public class SignageListViewHolder3 extends MeshTVVHolder<MeshTVFeed>
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = SignageListViewHolder3.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------View-------------------------------------------
    com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.CustomScrollingTextView.MeshTVScrollingContinuousTextView tv_owner;
    com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.CustomScrollingTextView.MeshTVScrollingContinuousTextView tv_name;
    TextView tv_location;
    TextView tv_description;
    TextView tv_schedule;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Getter-------------------------------------------
    public com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.CustomScrollingTextView.MeshTVScrollingContinuousTextView getTv_owner() {
        return tv_owner;
    }
    public com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.CustomScrollingTextView.MeshTVScrollingContinuousTextView getTv_name() {
        return tv_name;
    }
    public TextView getTv_description(){return tv_description;}
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
        tv_owner = v.findViewById(R.id.tv_owner);
        tv_name = v.findViewById(R.id.tv_name);
        tv_location = v.findViewById(R.id.tv_location);
        tv_description=v.findViewById(R.id.tv_description);
        tv_schedule = v.findViewById(R.id.tv_schedule);
    }
    //==============================================================================================
}
