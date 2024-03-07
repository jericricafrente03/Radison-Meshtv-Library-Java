package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Adapter;

import android.content.Context;
import android.widget.ListView;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.VH.MeshTVVHolder;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestService;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFood;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFoodCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacility;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacilityCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshArrivalFlight;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshDepartureFlight;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshCity;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshContinent;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Music.MeshMusic;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Music.MeshMusicCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RealmItem.MeshRealmItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RoomType.MeshRoomType;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStream;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStreamCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshGenre;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast;

import java.util.ArrayList;

abstract class BittelRealmAdapter extends MeshTVAdapter
{
    //===============================================Variable=======================================
    //-----------------------------------------------Constant---------------------------------------
    public static final String TAG = BittelRealmAdapter.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Constructor======================================
    public BittelRealmAdapter(Context context, ListView lv_list, int layoutResourceId, ArrayList data) {
        super(context, lv_list, layoutResourceId, data);
    }
    //==============================================================================================
    //============================================MeshTVAdapter=====================================
    @Override
    public void updateRow(MeshTVVHolder vh, Object o)
    {
        if(o instanceof  MeshChannel)
        {
            onBindChannel(vh,(MeshChannel)o);
        }
        else if(o instanceof  MeshChannelCategory)
        {
            onBindChannelCategory(vh,(MeshChannelCategory)o);
        }
        else if(o instanceof  MeshConciergeCategory)
        {
            onBindConciergeCategory(vh,(MeshConciergeCategory)o);
        }
        else if(o instanceof  MeshConciergeRequestService)
        {
            onBindConciergeRequestService(vh,(MeshConciergeRequestService)o);
        }
        else if(o instanceof  MeshConciergeRequestItem)
        {
            onBindConciergeRequestItem(vh,(MeshConciergeRequestItem)o);
        }
        else if (o instanceof  MeshFood)
        {
            onBindFood(vh,(MeshFood) o);
        }
        else if (o instanceof  MeshFoodCategory)
        {
            onBindFoodCategory(vh,(MeshFoodCategory) o);
        }
        else if (o instanceof  MeshFacility)
        {
            onBindFacility(vh,(MeshFacility) o);
        }
        else if (o instanceof  MeshFacilityCategory)
        {
            onBindFacilityCategory(vh,(MeshFacilityCategory) o);
        }
        else if (o instanceof  MeshArrivalFlight)
        {
            onBindArrivalFlight(vh,(MeshArrivalFlight) o);
        }
        else if (o instanceof  MeshDepartureFlight)
        {
            onBindDepartureFlight(vh,(MeshDepartureFlight) o);
        }
        else if (o instanceof  MeshCity)
        {
            onBindCity(vh,(MeshCity) o);
        }
        else if (o instanceof  MeshContinent)
        {
            onBindContinent(vh,(MeshContinent) o);
        }
        else if (o instanceof  MeshMessage)
        {
            onBindMessage(vh,(MeshMessage) o);
        }
        else if (o instanceof  MeshMusic)
        {
            onBindMusic(vh,(MeshMusic) o);
        }
        else if (o instanceof  MeshMusicCategory)
        {
            onBindMusicCategory(vh,(MeshMusicCategory) o);
        }
        else if (o instanceof  MeshRealmItem)
        {
            onBindRealmItem(vh,(MeshRealmItem) o);
        }
        else if (o instanceof  MeshRoomType)
        {
            onBindRoomType(vh,(MeshRoomType) o);
        }
        else if (o instanceof  MeshShoppingItem)
        {
            onBindShopping(vh,(MeshShoppingItem) o);
        }
        else if (o instanceof  MeshShoppingCategory)
        {
            onBindShoppingCategory(vh,(MeshShoppingCategory) o);
        }
        else if (o instanceof  MeshStream)
        {
            onBindStream(vh,(MeshStream) o);
        }
        else if (o instanceof  MeshStreamCategory)
        {
            onBindStreamCategory(vh,(MeshStreamCategory) o);
        }
        else if (o instanceof  MeshVC)
        {
            onBindVC(vh,(MeshVC) o);
        }
        else if (o instanceof  MeshVCCategory)
        {
            onBindVCCategory(vh,(MeshVCCategory) o);
        }
        else if (o instanceof  MeshGenre)
        {
            onBindGenre(vh,(MeshGenre) o);
        }
        else if (o instanceof  MeshVOD)
        {
            onBindVOD(vh,(MeshVOD) o);
        }
        else if (o instanceof  MeshWeatherForecast)
        {
            onBindWeatherForecast(vh,(MeshWeatherForecast) o);
        }
        else if (o instanceof  MeshWeatherV2)
        {
            onBindWeatehrV2(vh,(MeshWeatherV2) o);
        }
    }
    //==============================================================================================
    //==============================================Abstract========================================
    public abstract void onBindChannel(MeshTVVHolder vh,MeshChannel channel);
    public abstract void onBindChannelCategory(MeshTVVHolder vh,MeshChannelCategory channelCategory);
    public abstract void onBindConciergeCategory(MeshTVVHolder vh,MeshConciergeCategory conciergeCategory);
    public abstract void onBindConciergeRequestItem(MeshTVVHolder vh,MeshConciergeRequestItem item);
    public abstract void onBindConciergeRequestService(MeshTVVHolder vh,MeshConciergeRequestService service);
    public abstract void onBindFood(MeshTVVHolder vh,MeshFood food);
    public abstract void onBindFoodCategory(MeshTVVHolder vh,MeshFoodCategory foodCategory);
    public abstract void onBindFacility(MeshTVVHolder vh,MeshFacility facility);
    public abstract void onBindFacilityCategory(MeshTVVHolder vh,MeshFacilityCategory facilityCategory);
    public abstract void onBindArrivalFlight(MeshTVVHolder vh,MeshArrivalFlight arrivalFlight);
    public abstract void onBindDepartureFlight(MeshTVVHolder vh,MeshDepartureFlight departureFlight);
    public abstract void onBindCity(MeshTVVHolder vh,MeshCity city);
    public abstract void onBindContinent(MeshTVVHolder vh,MeshContinent continent);
    public abstract void onBindMessage(MeshTVVHolder vh,MeshMessage message);
    public abstract void onBindMusic(MeshTVVHolder vh,MeshMusic music);
    public abstract void onBindMusicCategory(MeshTVVHolder vh,MeshMusicCategory musicCategory);
    public abstract void onBindRealmItem(MeshTVVHolder vh,MeshRealmItem item);
    public abstract void onBindRoomType(MeshTVVHolder vh,MeshRoomType type);
    public abstract void onBindShopping(MeshTVVHolder vh,MeshShoppingItem item);
    public abstract void onBindShoppingCategory(MeshTVVHolder vh,MeshShoppingCategory category);
    public abstract void onBindStream(MeshTVVHolder vh,MeshStream stream);
    public abstract void onBindStreamCategory(MeshTVVHolder vh,MeshStreamCategory category);
    public abstract void onBindVC(MeshTVVHolder vh,MeshVC vc);
    public abstract void onBindVCCategory(MeshTVVHolder vh,MeshVCCategory category);
    public abstract void onBindGenre(MeshTVVHolder vh,MeshGenre genre);
    public abstract void onBindVOD(MeshTVVHolder vh,MeshVOD vod);
    public abstract void onBindWeatherForecast(MeshTVVHolder vh,MeshWeatherForecast forecast);
    public abstract void onBindWeatehrV2(MeshTVVHolder vh,MeshWeatherV2 weather);

    //==============================================================================================

}
