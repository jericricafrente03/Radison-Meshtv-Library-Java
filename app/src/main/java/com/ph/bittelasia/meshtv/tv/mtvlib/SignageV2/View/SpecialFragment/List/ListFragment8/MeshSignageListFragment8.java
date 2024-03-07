package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment8;

import android.widget.ListView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment.MeshSignageListFragment;

import java.util.ArrayList;

public class MeshSignageListFragment8 extends MeshSignageListFragment
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Static============================================
    public static MeshSignageListFragment8 get(MeshMediaV2 media)
    {
        MeshSignageListFragment8 fragment1 = new MeshSignageListFragment8();
        fragment1.setMediaV2(media);
        return fragment1;
    }
    //==============================================================================================
    //========================================MeshSignageListFragment1==============================
    @Override
    public int setLayoutId() {
        return R.layout.signage_list_fragment8;
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
        return new SignageAdapter8(getActivity(),listView,i,arrayList);
    }
    //==============================================================================================
}
