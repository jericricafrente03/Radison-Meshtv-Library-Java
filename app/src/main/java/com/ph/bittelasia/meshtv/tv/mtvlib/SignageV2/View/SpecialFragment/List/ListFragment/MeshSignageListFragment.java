package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View.SpecialFragment.List.ListFragment;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Query.MeshValuePair;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacility;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;

import java.util.ArrayList;

public abstract class MeshSignageListFragment extends Fragment
{
    //=========================================Variable=============================================
    //-----------------------------------------Constant---------------------------------------------
    public static final String TAG = MeshSignageListFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------View-----------------------------------------------
    private ListView lv_signage;
    private TextView tv_title;
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------Instance---------------------------------------------
    private int layoutId;
    private int listId;
    private int textId;
    private int itemLayout;
    private ArrayList<MeshTVFeed> feeds;
    private MeshTVAdapter adapter;
    private MeshMediaV2 mediaV2;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //========================================LifeCycle=============================================

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = null;
        layoutId = setLayoutId();
        feeds = new ArrayList<>();
        if(layoutId>0)
        {
            v= inflater.inflate(layoutId,container,false);
        }
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        listId = setFeedListId();
        textId = setTitleId();
        itemLayout = setItemLayout();
        if(listId>0)
        {
            lv_signage = view.findViewById(listId);
        }
        if(textId>0)
        {
            tv_title = view.findViewById(textId);
            if(mediaV2!=null)
            {
                tv_title.setText(mediaV2.getName());
            }
        }
        updateList();

    }

    //==============================================================================================
    //==========================================Method==============================================
    //------------------------------------------Action----------------------------------------------
    public void clearFeeds()
    {
        if(feeds==null)
        {
            feeds = new ArrayList<>();
        }
        feeds.clear();
    }
    public void updateList()
    {
        if(lv_signage!=null&&feeds!=null)
        {
            if (itemLayout > 0)
            {
                lv_signage.setAdapter(setAdapter(lv_signage, itemLayout, feeds));
            }
        }
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Getter----------------------------------------------

    public TextView getTv_title() {
        return tv_title;
    }

    public ArrayList<MeshTVFeed> getFeeds()
    {
        if(feeds==null)
        {
            feeds = new ArrayList<>();
        }
        return feeds;
    }
    public int getFeedsCount()
    {
        if(feeds==null)
        {
            feeds = new ArrayList<>();
        }
        return feeds.size();
    }

    public MeshMediaV2 getMediaV2() {
        return mediaV2;
    }

    public ListView getLv_signage() {
        return lv_signage;
    }
    public MeshTVAdapter getAdapter() {
        return adapter;
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Setter----------------------------------------------
    public void setFeeds(ArrayList<MeshTVFeed> feeds)
    {
        this.feeds = new ArrayList<>();
        this.feeds.addAll(feeds);
        updateList();
    }

    public void setMediaV2(MeshMediaV2 mediaV2) {
        this.mediaV2 = mediaV2;
        if(tv_title!=null)
        {
            tv_title.setText(mediaV2.getName());
        }
        MeshValuePair vp = new MeshValuePair(MeshTVFeed.TAG_GROUP_ID,mediaV2.getGroup_id());
        vp.setString(false);
        MeshRealmManager.retrieve(MeshTVFeed.class, new MeshRealmListener() {
            @Override
            public void onRetrieved(Class c, ArrayList<Object> results) {

                if(c==MeshTVFeed.class)
                {
                    feeds = new ArrayList<>();
                    for(Object o:results)
                    {
                        feeds.add((MeshTVFeed) o);
                    }
                    updateList();
                }
                else
                {
                    Log.i(TAG,"Not a Feed");
                }


            }

            @Override
            public void onFailed(Class c, String message) {

            }

            @Override
            public void onEmpty(Class c, String message) {

            }

            @Override
            public void onCleared(Class c) {

            }
        },vp);
    }

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================Abstract=============================================
    public abstract int setLayoutId();
    public abstract int setFeedListId();
    public abstract int setTitleId();
    public abstract int setItemLayout();
    public abstract MeshTVAdapter setAdapter(ListView lv_list, int layoutResourceId, ArrayList<MeshTVFeed> data);
    //==============================================================================================

}
