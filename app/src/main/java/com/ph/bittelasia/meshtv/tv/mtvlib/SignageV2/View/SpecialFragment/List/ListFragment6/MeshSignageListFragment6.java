package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment6;

import android.widget.ListView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment.MeshSignageListFragment;


import java.util.ArrayList;

public class MeshSignageListFragment6 extends MeshSignageListFragment {
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshSignageListFragment6.class.getSimpleName();
    //----------------------------------------------------------------------------------------------

    //==============================================================================================
    //=============================================Static===========================================
    public static MeshSignageListFragment6 get(MeshMediaV2 media) {
        MeshSignageListFragment6 fragment6 = new MeshSignageListFragment6();
        fragment6.setMediaV2(media);
        return fragment6;
    }

    //==============================================================================================
    //============================================LifeCycle=========================================
    //==============================================================================================
    //=====================================MeshSignageListFragment==================================
    @Override
    public int setLayoutId() {
        return R.layout.signage_list_fragment6;
    }

    @Override
    public int setFeedListId() {
        return R.id.lv_list6;
    }

    @Override
    public int setTitleId() {
        return R.id.tv_title;
    }

    @Override
    public int setItemLayout() {
        return R.layout.signage_list_item6;
    }

    @Override
    public MeshTVAdapter setAdapter(ListView lv_list, int layoutResourceId, ArrayList<MeshTVFeed> data) {
        return new SignageAdapter6(getActivity(), lv_list, layoutResourceId, data);
    }
//==============================================================================================
}