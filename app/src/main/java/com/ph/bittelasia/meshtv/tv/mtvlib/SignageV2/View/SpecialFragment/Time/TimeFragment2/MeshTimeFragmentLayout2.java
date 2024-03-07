package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Time.TimeFragment2;

import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.Time.TimeFragment.MeshTimeFragment;

public class MeshTimeFragmentLayout2 extends MeshTimeFragment {

    @Override
    public int setLayoutId() {
        return R.layout.signage_time_layout_2;
    }

    @Override
    public int setTimeId() {
        return R.id.tc_clock;
    }

    @Override
    public int setDateId() {
        return R.id.tv_date;
    }

    @Override
    public String setDateFormat() {
        return "MMM dd, yyyy |";
    }

    @Override
    public String setTimeFormat() {
        return " hh:mm a";
    }
}
