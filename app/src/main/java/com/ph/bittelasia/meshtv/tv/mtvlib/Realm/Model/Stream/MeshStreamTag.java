package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Tag.MeshTag;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mars on 6/5/17.
 */

public class MeshStreamTag
{

    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshStreamTag.class.getSimpleName();
    public static final String TAG_TAG               = "tag";

    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    String tag = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Constructor=======================================
    public MeshStreamTag(String data)
    {
        try
        {
            JSONObject ob = new JSONObject(data);
            tag = ob.getString(TAG_TAG);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Factory------------------------------------------
    public static ArrayList<MeshStreamTag> generate(String array)
    {
        ArrayList<MeshStreamTag> tags = new ArrayList<>();
        try
        {
            JSONArray array1 = new JSONArray(array);
            for(int ctr = 0; array1.length()>ctr;ctr++)
            {
                try
                {
                    tags.add(new MeshStreamTag(array1.getString(ctr)));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }



            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return tags;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Getter-------------------------------------------

    public String getTag() {
        return tag;
    }


    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------

    public void setTag(String tag) {
        this.tag = tag;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

}
