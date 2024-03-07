package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment2;

import android.widget.ListView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment.MeshSignageListFragment;
import java.util.ArrayList;

public class MeshSignageListFragment2 extends MeshSignageListFragment {
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshSignageListFragment2.class.getSimpleName();
    //----------------------------------------------------------------------------------------------

    //==============================================================================================
    //=============================================Static===========================================
    public static MeshSignageListFragment2 get(MeshMediaV2 media) {
        MeshSignageListFragment2 fragment2 = new MeshSignageListFragment2();
        fragment2.setMediaV2(media);
        return fragment2;
    }

    //==============================================================================================
    //============================================LifeCycle=========================================
    //==============================================================================================
    //=====================================MeshSignageListFragment==================================
    @Override
    public int setLayoutId() {
        return R.layout.signage_list_fragment2;
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
        return R.layout.signage_list_item2;
    }

    @Override
    public MeshTVAdapter setAdapter(ListView lv_list, int layoutResourceId, ArrayList<MeshTVFeed> data) {
        return new SignageAdapter2(getActivity(), lv_list, layoutResourceId, data);
    }
//==============================================================================================
}