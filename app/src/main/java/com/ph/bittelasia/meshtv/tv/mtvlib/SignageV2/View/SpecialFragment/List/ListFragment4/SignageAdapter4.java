package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment4;

import android.content.Context;
import android.widget.ListView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.ViewHolder.ViewHolderLayout;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.ResourceManager.MeshResourceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.VH.MeshTVVHolder;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment3.SignageListViewHolder3;

import java.util.ArrayList;

@ViewHolderLayout()
public class SignageAdapter4 extends MeshTVAdapter<MeshTVFeed>
{


    public SignageAdapter4(Context context, ListView lv_list, int layoutResourceId, ArrayList<MeshTVFeed> data) {
        super(context, lv_list, layoutResourceId, data);
    }

    @Override
    public MeshTVVHolder setViewHolder()
    {
        return new SignageListViewHolder4();
    }

    @Override
    public void updateRow(MeshTVVHolder vh, MeshTVFeed o)
    {
        SignageListViewHolder4 v = (SignageListViewHolder4) vh;
        v.getTv_location().setText(o.getLocation());
        v.getTv_owner().setText(o.getOwner());
        v.getTv_name().setText(o.getTitle());
        v.getTv_description().setText(o.getDescription());
        v.getTv_schedule().setText(o.getSchedule());
        MeshResourceManager.displayLiveImageFor(v.iv_event.getContext(),v.getIv_event(),o.getImage());
    }

    @Override
    public int setLayout() {
        return R.layout.signage_list_item4;
    }
}
