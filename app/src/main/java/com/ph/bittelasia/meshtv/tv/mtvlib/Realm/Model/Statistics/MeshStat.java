package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Statistics;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshStat extends RealmObject implements MeshObjectInterface
{
    //===============================================Variable=======================================
    //-----------------------------------------------Constant---------------------------------------
    @Ignore
    public static final String TAG                          = MeshStat.class.getSimpleName();
    @Ignore
    public static final String TAG_ID                       = "id";
    @Ignore
    public static final String TAG_TYPE                     = "type";
    @Ignore
    public static final String TAG_NAME                     = "name";
    @Ignore
    public static final String TAG_ITEM_ID                  = "item_id";
    @Ignore
    public static final String TAG_TICK                     = "tick";
    @Ignore
    public static final String TAG_DATE                     = "date";
    @Ignore
    public static final String DATE_FORMAT                  = "MMM dd yyyy - hh:mm aa";
    @Ignore
    public static final String TAG_TV_APPS                  = "tv_app";
    @Ignore
    public static final String TAG_TV_CHANNELS              = "tv_channels";
    @Ignore
    public static final String TAG_TV_CHANNELS_CATEGORY     = "tv_channels_category";
    @Ignore
    public static final String TAG_TV_AIRMEDIA              = "tv_airmedia";
    @Ignore
    public static final String TAG_TV_HOTEL_ROOM_TYPE       = "tv_hotel_room_type";
    @Ignore
    public static final String TAG_TV_HOTEL_FACILITY        = "tv_hotel_facility";
    @Ignore
    public static final String TAG_TV_HOTEL_FACILITY_CAT    = "tv_hotel_facility_category";
    @Ignore
    public static final String TAG_TV_EXPLORE               = "tv_explore_item";
    @Ignore
    public static final String TAG_TV_EXPLORE_CAT           = "tv_explore_category";
    @Ignore
    public static final String TAG_TV_DINING                = "tv_dining";
    @Ignore
    public static final String TAG_TV_DINING_CATEGORY       = "tv_dining_category";
    @Ignore
    public static final String TAG_TV_WEATHER_FORECAST      = "tv_weather_forecast";
    @Ignore
    public static final String TAG_TV_SHOPPING              = "tv_shopping";
    @Ignore
    public static final String TAG_TV_SHOPPING_CATEGORY     = "tv_shopping_category";
    @Ignore
    public static final String TAG_TV_SERVICE               = "tv_services";
    @Ignore
    public static final String TAG_TV_ITEM                  = "tv_items";
    @Ignore
    public static final String TAG_TV_VOD                  = "tv_vod";
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Instance---------------------------------------
    @PrimaryKey
    String id = null;
    String type;
    String name;
    int item_id;
    int tick;
    String date;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Constructor=====================================
    public MeshStat() {}
    //==============================================================================================
    //=================================================Method=======================================
    //-------------------------------------------------Getter---------------------------------------
    public String getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public int getItem_id() {
        return item_id;
    }
    public int getTick() {
        return tick;
    }
    public String getDate() {
        return date;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------Setter---------------------------------------
    public void setId(String id) {
        this.id = id;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
    public void setTick(int tick) {
        this.tick = tick;
    }
    public void setDate(String date) {
        this.date = date;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //================================================Abstract======================================
    @Override
    public int getMeshID() {return item_id;}
    @Override
    public String getMeshLabel() {return name;}
    @Override
    public String getMeshDescription() {return type;}
    @Override
    public int getMeshQuantity() {return 0;}
    @Override
    public double getMeshPrice() {return 0;}
    @Override
    public String getMeshIMG() {return null;}
    //==============================================================================================

}

