package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RealmItem;

import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2;

import java.util.ArrayList;
import java.util.HashMap;

public class MeshRealmEntry
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = MeshRealmEntry.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    Class mClass;
    ArrayList<MeshRealmField> fields;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Constructor=======================================
    public MeshRealmEntry(Object o)
    {
        fields = new ArrayList<>();
        mClass = o.getClass();
        build(o);
    }
    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Build-------------------------------------------
    private void build(Object o)
    {
        Log.i(TAG,"Building");
        if(mClass== MeshChannel.class)
        {
            MeshChannel channel = (MeshChannel)o;
            MeshRealmField id = new MeshRealmField("ID:","This must not be empty",MeshChannel.TAG_ID,0,channel.getId(),false);
            MeshRealmField tittle = new MeshRealmField("Channel:","Name of Channel",MeshChannel.TAG_TITLE,1,channel.getChannel_title(),true);
            MeshRealmField description = new MeshRealmField("Description:","Short Channel Description",MeshChannel.TAG_DESCRIPTION,2,channel.getChannel_description(),true);
            MeshRealmField catId = new MeshRealmField("Category:","Choose One",MeshChannel.TAG_CATEGORY_ID,3,channel.getChannel_category_id(),true);
            MeshRealmField url = new MeshRealmField("Logo:","Provide Logo URL",MeshChannel.TAG_IMAGE_URL,4,channel.getChannel_image(),true);
            MeshRealmField uri = new MeshRealmField("Channel URI:","Provide URI of Channel Source",MeshChannel.TAG_URI,5,channel.getChannel_uri(),true);
            fields.add(id);
            fields.add(tittle);
            fields.add(description);
            fields.add(catId);
            fields.add(url);
            fields.add(uri);
        }
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Getter------------------------------------------
    public Class getmClass() {
        return mClass;
    }
    public ArrayList<MeshRealmField> getFields()
    {return fields;}
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Setter------------------------------------------
    public void setmClass(Class mClass) {
        this.mClass = mClass;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
