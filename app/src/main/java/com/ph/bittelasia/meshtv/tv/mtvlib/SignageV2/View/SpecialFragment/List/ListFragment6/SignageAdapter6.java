package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment6;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.ViewHolder.ViewHolderLayout;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.ResourceManager.MeshResourceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.VH.MeshTVVHolder;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;


import java.util.ArrayList;

@ViewHolderLayout()
public class SignageAdapter6 extends MeshTVAdapter<MeshTVFeed>
{
    public static final String TAG=SignageAdapter6.class.getSimpleName();

    public SignageAdapter6(Context context, ListView lv_list, int layoutResourceId, ArrayList<MeshTVFeed> data) {
        super(context, lv_list, layoutResourceId, data);
    }

    @Override
    public MeshTVVHolder setViewHolder()
    {
        return new SignageListViewHolder6();
    }

    @Override
    public void updateRow(MeshTVVHolder vh, MeshTVFeed o)
    {
        SignageListViewHolder6 v = (SignageListViewHolder6) vh;
        v.getTv_location().setText(o.getLocation());
        v.getTv_owner().setText(o.getOwner());
        v.getTv_name().setText(o.getTitle());
        v.getTv_description().setText(o.getDescription());
        v.getTv_schedule().setText(o.getSchedule());
        MeshResourceManager.displayLiveImageFor(v.iv_event.getContext(),v.getIv_event(),o.getImage());
        Log.i(TAG,"get location: "+o.getLocation());
        Log.i(TAG,"get owner: "+o.getOwner());
        Log.i(TAG,"get title: "+o.getTitle());
        Log.i(TAG,"get desc: "+o.getDescription());
        Log.i(TAG,"get schedule: "+o.getSchedule());
        Log.i(TAG,"get image: "+o.getImage());
    }

    @Override
    public int setLayout() {
        return R.layout.signage_list_item6;
    }
}
