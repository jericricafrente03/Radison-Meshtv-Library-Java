package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment7;

import android.widget.ListView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment.MeshSignageListFragment;

import java.util.ArrayList;

public class MeshSignageListFragment7 extends MeshSignageListFragment
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Static============================================
    public static MeshSignageListFragment7 get(MeshMediaV2 media)
    {
        MeshSignageListFragment7 fragment1 = new MeshSignageListFragment7();
        fragment1.setMediaV2(media);
        return fragment1;
    }
    //==============================================================================================
    //========================================MeshSignageListFragment1==============================
    @Override
    public int setLayoutId() {
        return R.layout.signage_list_fragment7;
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
        return R.layout.signage_list_item7;
    }

    @Override
    public MeshTVAdapter setAdapter(ListView listView, int i, ArrayList<MeshTVFeed> arrayList) {
        return new SignageAdapter7(getActivity(),listView,i,arrayList);
    }
    //==============================================================================================
}
