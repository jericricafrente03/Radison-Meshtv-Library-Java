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

public abstract class MeshTVRealmAdapter extends BittelRealmAdapter
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static String TAG = MeshTVRealmAdapter.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Constructor=======================================
    public MeshTVRealmAdapter(Context context, ListView lv_list, int layoutResourceId, ArrayList data) {
        super(context, lv_list, layoutResourceId, data);
    }
    //==============================================================================================
    //========================================BittelRealmAdapter====================================
    @Override
    public void onBindChannel(MeshTVVHolder vh, MeshChannel channel) {

    }

    @Override
    public void onBindChannelCategory(MeshTVVHolder vh, MeshChannelCategory channelCategory) {

    }

    @Override
    public void onBindConciergeCategory(MeshTVVHolder vh, MeshConciergeCategory conciergeCategory) {

    }

    @Override
    public void onBindConciergeRequestItem(MeshTVVHolder vh, MeshConciergeRequestItem item) {

    }

    @Override
    public void onBindConciergeRequestService(MeshTVVHolder vh, MeshConciergeRequestService service) {

    }

    @Override
    public void onBindFood(MeshTVVHolder vh, MeshFood food) {

    }

    @Override
    public void onBindFoodCategory(MeshTVVHolder vh, MeshFoodCategory foodCategory) {

    }

    @Override
    public void onBindFacility(MeshTVVHolder vh, MeshFacility facility) {

    }

    @Override
    public void onBindFacilityCategory(MeshTVVHolder vh, MeshFacilityCategory facilityCategory) {

    }

    @Override
    public void onBindArrivalFlight(MeshTVVHolder vh, MeshArrivalFlight arrivalFlight) {

    }

    @Override
    public void onBindDepartureFlight(MeshTVVHolder vh, MeshDepartureFlight departureFlight) {

    }

    @Override
    public void onBindCity(MeshTVVHolder vh, MeshCity city) {

    }

    @Override
    public void onBindContinent(MeshTVVHolder vh, MeshContinent continent) {

    }

    @Override
    public void onBindMessage(MeshTVVHolder vh, MeshMessage message) {

    }

    @Override
    public void onBindMusic(MeshTVVHolder vh, MeshMusic music) {

    }

    @Override
    public void onBindMusicCategory(MeshTVVHolder vh, MeshMusicCategory musicCategory) {

    }

    @Override
    public void onBindRealmItem(MeshTVVHolder vh, MeshRealmItem item) {

    }

    @Override
    public void onBindRoomType(MeshTVVHolder vh, MeshRoomType type) {

    }

    @Override
    public void onBindShopping(MeshTVVHolder vh, MeshShoppingItem item) {

    }

    @Override
    public void onBindShoppingCategory(MeshTVVHolder vh, MeshShoppingCategory category) {

    }

    @Override
    public void onBindStream(MeshTVVHolder vh, MeshStream stream) {

    }

    @Override
    public void onBindStreamCategory(MeshTVVHolder vh, MeshStreamCategory category) {

    }

    @Override
    public void onBindVC(MeshTVVHolder vh, MeshVC vc) {

    }

    @Override
    public void onBindVCCategory(MeshTVVHolder vh, MeshVCCategory category) {

    }

    @Override
    public void onBindGenre(MeshTVVHolder vh, MeshGenre genre) {

    }

    @Override
    public void onBindVOD(MeshTVVHolder vh, MeshVOD vod) {

    }

    @Override
    public void onBindWeatherForecast(MeshTVVHolder vh, MeshWeatherForecast forecast) {

    }

    @Override
    public void onBindWeatehrV2(MeshTVVHolder vh, MeshWeatherV2 weather) {

    }
    //==============================================================================================

}
