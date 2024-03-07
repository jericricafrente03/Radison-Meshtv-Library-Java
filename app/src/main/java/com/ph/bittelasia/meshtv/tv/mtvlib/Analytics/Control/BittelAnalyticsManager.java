package com.ph.bittelasia.meshtv.tv.mtvlib.Analytics.Control;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util.MeshCountryConverter;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Apps.MeshApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestService;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFood;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFoodCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacility;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacilityCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RoomType.MeshRoomType;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Statistics.MeshStat;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Creates {@link MeshStat MeshStat} to monitor IPTV usage
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
final class BittelAnalyticsManager
{
    //===============================================Variable=======================================
    //-----------------------------------------------Constant---------------------------------------
    static final String TAG = BittelAnalyticsManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //================================================Method========================================
    //-------------------------------------------------Tick-----------------------------------------
    /**
     * Adds a {@link MeshStat MeshStat} every time a {@link MeshApp MeshApp} is opened
     * @param app {@link MeshApp MeshApp} that was opened
     */
    static final synchronized void tickApps(MeshApp app)
    {

        if(app!=null)
        {
            MeshStat stat = new MeshStat();
            stat.setId(UUID.randomUUID().toString());
            stat.setName(app.getDisplayName());
            getDate(stat);
            stat.setTick(1);
            stat.setType(MeshStat.TAG_TV_APPS);
            stat.setItem_id(app.getId());
            MeshRealmManager.insert(stat);
        }
    }
    /**
     * Adds a {@link MeshStat MeshStat} every time a {@link MeshChannel MeshChannel} is opened
     * @param channel {@link MeshChannel MeshChannel} that was opened
     */
    static final synchronized void tickChannels(MeshChannel channel)
    {

        if(channel!=null)
        {
            MeshStat stat = new MeshStat();
            stat.setId(UUID.randomUUID().toString());
            stat.setName(channel.getChannel_title());
            getDate(stat);
            stat.setTick(1);
            stat.setType(MeshStat.TAG_TV_CHANNELS);
            stat.setItem_id(channel.getId());
            MeshRealmManager.insert(stat);
        }
    }
    /**
     * Adds a {@link MeshStat MeshStat} every time a {@link MeshChannelCategory MeshChannelCategory} is opened
     * @param category {@link MeshChannelCategory MeshChannelCategory} that was opened
     */
    static final synchronized void tickChannelCategory(MeshChannelCategory category)
    {
        if(category!=null)
        {
            MeshStat stat = new MeshStat();
            stat.setId(UUID.randomUUID().toString());
            stat.setName(category.getCategory_name());
            getDate(stat);
            stat.setTick(1);
            stat.setType(MeshStat.TAG_TV_CHANNELS_CATEGORY);
            stat.setItem_id(category.getId());
            MeshRealmManager.insert(stat);
        }
    }
    /**
     * Adds a {@link MeshStat MeshStat} every time a Airmedia was opened
     * @param os
     * OS Airmedia was used for:
     * <br>
     * Android : 0
     * <br>
     * IOS : 1
     * <br>
     * Windows : 2
     */
    static final synchronized void tickAirmedia(int os)
    {

            MeshStat stat = new MeshStat();
            stat.setId(UUID.randomUUID().toString());
            stat.setName(os==0?"Android":os==1?"IOS":"Windows");
            getDate(stat);
            stat.setTick(1);
            stat.setType(MeshStat.TAG_TV_AIRMEDIA);
            stat.setItem_id(os);
            MeshRealmManager.insert(stat);

    }
    /**
     * Adds a {@link MeshStat MeshStat} every time a {@link MeshRoomType MeshRoomType} is opened
     * @param type {@link MeshRoomType MeshRoomType} that was opened
     */
    static final synchronized void tickRoomType(MeshRoomType type)
    {
        if(type!=null)
        {
            MeshStat stat = new MeshStat();
            stat.setId(UUID.randomUUID().toString());
            stat.setName(type.getCategory_name());
            getDate(stat);
            stat.setTick(1);
            stat.setType(MeshStat.TAG_TV_HOTEL_ROOM_TYPE);
            stat.setItem_id(type.getId());
            MeshRealmManager.insert(stat);
        }
    }
    /**
     * Adds a {@link MeshStat MeshStat} every time a {@link MeshFacility MeshFacility} is opened
     * @param facility {@link MeshFacility MeshFacility} that was opened
     */
    static final synchronized void tickHotelFacility(MeshFacility facility)
    {
        if(facility!=null)
        {
            MeshStat stat = new MeshStat();
            stat.setId(UUID.randomUUID().toString());
            stat.setName(facility.getItem_name());
            getDate(stat);
            stat.setTick(1);
            stat.setType(MeshStat.TAG_TV_HOTEL_FACILITY);
            stat.setItem_id(facility.getId());
            MeshRealmManager.insert(stat);
        }
    }
    /**
     * Adds a {@link MeshStat MeshStat} every time a {@link MeshFacilityCategory MeshFacilityCategory} is opened
     * @param category {@link MeshFacilityCategory MeshFacilityCategory} that was opened
     */
    static final synchronized void tickHotelFacilityCategory(MeshFacilityCategory category)
    {
        if(category!=null)
        {
            MeshStat stat = new MeshStat();
            stat.setId(UUID.randomUUID().toString());
            stat.setName(category.getCategory_name());
            getDate(stat);
            stat.setTick(1);
            stat.setType(MeshStat.TAG_TV_HOTEL_FACILITY_CAT);
            stat.setItem_id(category.getId());
            MeshRealmManager.insert(stat);
        }
    }
    /**
     * Adds a {@link MeshStat MeshStat} every time a {@link MeshVC MeshVC} is opened
     * @param vc {@link MeshFacilityCategory MeshFacilityCategory} that was opened
     */
    static final synchronized void tickVC(MeshVC vc)
    {
        if(vc!=null)
        {
            MeshStat stat = new MeshStat();
            stat.setId(UUID.randomUUID().toString());
            stat.setName(vc.getEstablishment_name());
            getDate(stat);
            stat.setTick(1);
            stat.setType(MeshStat.TAG_TV_EXPLORE);
            stat.setItem_id(vc.getId());
            MeshRealmManager.insert(stat);
        }
    }
    /**
     * Adds a {@link MeshStat MeshStat} every time a {@link MeshVCCategory MeshVCCategory} is opened
     * @param vcCategory {@link MeshFacilityCategory MeshFacilityCategory} that was opened
     */
    static final synchronized void tickVCCategory(MeshVCCategory vcCategory)
    {
        if(vcCategory!=null)
        {
            MeshStat stat = new MeshStat();
            stat.setId(UUID.randomUUID().toString());
            stat.setName(vcCategory.getName());
            getDate(stat);
            stat.setTick(1);
            stat.setType(MeshStat.TAG_TV_EXPLORE_CAT);
            stat.setItem_id(vcCategory.getId());
            MeshRealmManager.insert(stat);
        }
    }
    /**
     * Adds a {@link MeshStat MeshStat} every time a {@link MeshFood MeshFood} is opened
     * @param food {@link MeshFood MeshFood} that was opened
     */
    static final synchronized void tickDining(MeshFood food)
    {
        if(food!=null)
        {
            MeshStat stat = new MeshStat();
            stat.setId(UUID.randomUUID().toString());
            stat.setName(food.getItem_name());
            getDate(stat);
            stat.setTick(1);
            stat.setType(MeshStat.TAG_TV_DINING);
            stat.setItem_id(food.getId());
            MeshRealmManager.insert(stat);
        }
    }
    /**
     * Adds a {@link MeshStat MeshStat} every time a {@link MeshFoodCategory MeshFoodCategory} is opened
     * @param category {@link MeshFoodCategory MeshFoodCategory} that was opened
     */
    static final synchronized void tickDiningCategory(MeshFoodCategory category)
    {
        if(category!=null)
        {
            MeshStat stat = new MeshStat();
            stat.setId(UUID.randomUUID().toString());
            stat.setName(category.getCategory_name());
            getDate(stat);
            stat.setTick(1);
            stat.setType(MeshStat.TAG_TV_DINING_CATEGORY);
            stat.setItem_id(category.getId());
            MeshRealmManager.insert(stat);
        }
    }
    /**
     * Adds a {@link MeshStat MeshStat} every time a {@link MeshWeatherForecast MeshWeatherForecast} is opened
     * @param forecast {@link MeshWeatherForecast MeshWeatherForecast} that was opened
     */
    static final synchronized void tickWeatherForecst(MeshWeatherForecast forecast)
    {
        if(forecast!=null)
        {
            MeshStat stat = new MeshStat();
            stat.setId(UUID.randomUUID().toString());
            stat.setName(forecast.getCountry());
            getDate(stat);
            stat.setTick(1);
            stat.setType(MeshStat.TAG_TV_WEATHER_FORECAST);
            stat.setItem_id(MeshCountryConverter.getID(forecast.getCountry()));
            MeshRealmManager.insert(stat);
        }
    }
    /**
     * Adds a {@link MeshStat MeshStat} every time a {@link MeshShoppingItem MeshShoppingItem} is opened
     * @param item {@link MeshShoppingItem MeshShoppingItem} that was opened
     */
    static final synchronized void tickShoppingItem(MeshShoppingItem item)
    {
        if(item!=null)
        {
            MeshStat stat = new MeshStat();
            stat.setId(UUID.randomUUID().toString());
            stat.setName(item.getItem_name());
            getDate(stat);
            stat.setTick(1);
            stat.setType(MeshStat.TAG_TV_SHOPPING);
            stat.setItem_id(item.getId());
            MeshRealmManager.insert(stat);
        }
    }
    /**
     * Adds a {@link MeshStat MeshStat} every time a {@link MeshShoppingCategory MeshShoppingCategory} is opened
     * @param category {@link MeshShoppingCategory MeshShoppingCategory} that was opened
     */
    static final synchronized void tickShoppingCategory(MeshShoppingCategory category)
    {
        if(category!=null)
        {
            MeshStat stat = new MeshStat();
            stat.setId(UUID.randomUUID().toString());
            stat.setName(category.getCategory_name());
            getDate(stat);
            stat.setTick(1);
            stat.setType(MeshStat.TAG_TV_SHOPPING_CATEGORY);
            stat.setItem_id(category.getId());
            MeshRealmManager.insert(stat);
        }
    }
    /**
     * Adds a {@link MeshStat MeshStat} every time a {@link MeshConciergeRequestService MeshConciergeRequestService} is opened
     * @param service {@link MeshConciergeRequestService MeshConciergeRequestService} that was opened
     */
    static final synchronized void tickService(MeshConciergeRequestService service)
    {
        if(service!=null)
        {
            MeshStat stat = new MeshStat();
            stat.setId(UUID.randomUUID().toString());
            stat.setName(service.getItem_name());
            getDate(stat);
            stat.setTick(1);
            stat.setType(MeshStat.TAG_TV_SERVICE);
            stat.setItem_id(service.getId());
            MeshRealmManager.insert(stat);
        }
    }
    /**
     * Adds a {@link MeshStat MeshStat} every time a {@link MeshConciergeRequestItem MeshConciergeRequestItem} is opened
     * @param item {@link MeshConciergeRequestItem MeshConciergeRequestItem} that was opened
     */
    static final synchronized void tickItem(MeshConciergeRequestItem item)
    {
        if(item!=null)
        {
            MeshStat stat = new MeshStat();
            stat.setId(UUID.randomUUID().toString());
            stat.setName(item.getItem_name());
            getDate(stat);
            stat.setTick(1);
            stat.setType(MeshStat.TAG_TV_ITEM);
            stat.setItem_id(item.getId());
            MeshRealmManager.insert(stat);
        }
    }
    static final synchronized void tickItem(MeshVOD item)
    {
        if(item!=null)
        {
            MeshStat stat = new MeshStat();
            stat.setId(UUID.randomUUID().toString());
            stat.setName(item.getTitle());
            getDate(stat);
            stat.setTick(1);
            stat.setType(MeshStat.TAG_TV_VOD);
            stat.setItem_id(item.getId());
            MeshRealmManager.insert(stat);
        }
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Util--------------------------------------------

    /**
     * Retrieves the current date based on the format {@link MeshStat#DATE_FORMAT DATE_FORMAT}
     * @param stat {@link MeshStat MeshStat} to update date
     */
    private static final synchronized void getDate(MeshStat stat)
    {
        try
        {
            stat.setDate(new SimpleDateFormat(MeshStat.DATE_FORMAT).format(new Date()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
