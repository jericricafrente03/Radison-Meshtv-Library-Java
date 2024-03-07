package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Control;



import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshSignage;

import java.util.ArrayList;

public interface MeshSignageRuntimeListener {

    public abstract ArrayList<MeshSignage> getSignageList();

    public abstract ArrayList<Fragment> getFragments();

    public abstract String getDateFormat();

    public abstract String getTimeZone();

    public abstract ViewPager getViewPager();

}
