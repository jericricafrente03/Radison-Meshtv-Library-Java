package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment5;

import android.widget.ListView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment.MeshSignageListFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment4.SignageAdapter4;

import java.util.ArrayList;

public class MeshSignageListFragment5 extends MeshSignageListFragment {
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshSignageListFragment5.class.getSimpleName();
    //----------------------------------------------------------------------------------------------

    //==============================================================================================
    //=============================================Static===========================================
    public static MeshSignageListFragment5 get(MeshMediaV2 media) {
        MeshSignageListFragment5 fragment5 = new MeshSignageListFragment5();
        fragment5.setMediaV2(media);
        return fragment5;
    }

    //==============================================================================================
    //============================================LifeCycle=========================================
    //==============================================================================================
    //=====================================MeshSignageListFragment==================================
    @Override
    public int setLayoutId() {
        return R.layout.signage_list_fragment5;
    }

    @Override
    public int setFeedListId() {
        return R.id.lv_list;
    }

    @Override
    public int setTitleId() {
        return R.id.tv_title;
    }

    @Override
    public int setItemLayout() {
        return R.layout.signage_list_item5;
    }

    @Override
    public MeshTVAdapter setAdapter(ListView lv_list, int layoutResourceId, ArrayList<MeshTVFeed> data) {
        return new SignageAdapter5(getActivity(), lv_list, layoutResourceId, data);
    }
//==============================================================================================
}