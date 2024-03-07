package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment4;

import android.widget.ListView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment.MeshSignageListFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment1.SignageAdapter1;

import java.util.ArrayList;

public class MeshSignageListFragment4 extends MeshSignageListFragment {
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshSignageListFragment4.class.getSimpleName();
    //----------------------------------------------------------------------------------------------

    //==============================================================================================
    //=============================================Static===========================================
    public static MeshSignageListFragment4 get(MeshMediaV2 media) {
        MeshSignageListFragment4 fragment4 = new MeshSignageListFragment4();
        fragment4.setMediaV2(media);
        return fragment4;
    }

    //==============================================================================================
    //============================================LifeCycle=========================================
    //==============================================================================================
    //=====================================MeshSignageListFragment==================================
    @Override
    public int setLayoutId() {
        return R.layout.signage_list_fragment4;
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
        return R.layout.signage_list_item4;
    }

    @Override
    public MeshTVAdapter setAdapter(ListView lv_list, int layoutResourceId, ArrayList<MeshTVFeed> data) {
        return new SignageAdapter4(getActivity(), lv_list, layoutResourceId, data);
    }
//==============================================================================================
}