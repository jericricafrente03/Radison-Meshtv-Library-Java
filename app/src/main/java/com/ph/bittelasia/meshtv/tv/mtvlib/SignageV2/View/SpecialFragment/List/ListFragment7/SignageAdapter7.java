package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment7;

import android.content.Context;
import android.graphics.Color;
import android.widget.ListView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.ViewHolder.ViewHolderLayout;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.ResourceManager.MeshResourceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.VH.MeshTVVHolder;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;

import java.util.ArrayList;

@ViewHolderLayout()
public class SignageAdapter7 extends MeshTVAdapter<MeshTVFeed>
{

    ArrayList<MeshTVFeed> fs;
    public SignageAdapter7(Context context, ListView lv_list, int layoutResourceId, ArrayList<MeshTVFeed> data) {
        super(context, lv_list, layoutResourceId, data);
        fs = new ArrayList<>();
        fs.addAll(data);
    }

    @Override
    public MeshTVVHolder setViewHolder()
    {
        return new SignageListViewHolder7();
    }

    @Override
    public void updateRow(MeshTVVHolder vh, MeshTVFeed o)
    {
        boolean isOdd = false;
        int ctr = 0;
        for(MeshTVFeed f:fs)
        {
            if(f.getId()==o.getId())
            {
                isOdd=(ctr%2)!=0;
                break;
            }
            ctr++;
        }
        if(isOdd)
        {
            vh.getV().setBackgroundColor(Color.parseColor("#00000000"));
        }
        else
        {
            vh.getV().setBackgroundColor(Color.parseColor("#88FFFFFF"));
        }
        SignageListViewHolder7 v = (SignageListViewHolder7) vh;
        v.getTv_event().setText(o.getTitle());
        v.getTv_description().setText(o.getDescription());
        v.getTv_location().setText(o.getLocation());
        v.getTv_time().setText(o.getSchedule());
        MeshResourceManager.displayLiveImageFor(v.getIv_logo().getContext(),v.getIv_logo(),o.getImage());
    }

    @Override
    public int setLayout()
    {

        return R.layout.signage_list_item7;
    }
}
