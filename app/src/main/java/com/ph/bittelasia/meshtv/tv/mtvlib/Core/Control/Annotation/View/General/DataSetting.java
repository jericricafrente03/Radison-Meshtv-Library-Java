package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 * Used by {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment}s to declare what data they will be listening to
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSetting
{
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Bill.MeshBillV2 MeshBillV2}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Bill.MeshBillV2 MeshBillV2}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Bill.MeshBillV2 MeshBillV2}
     */
    boolean listenToBills() default  false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel MeshChannel}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel MeshChannel}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel MeshChannel}
     */
    boolean listenToChannels() default  false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory MeshChannelCategory}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory MeshChannelCategory}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory MeshChannelCategory}
     */
    boolean listenToChannelCategories() default  false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory MeshChannelCategory}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory MeshChannelCategory}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory MeshChannelCategory}
     */
    boolean listenToConciergeCategory() default  false;

    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestItem MeshConciergeRequestItem}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestItem MeshConciergeRequestItem}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestItem MeshConciergeRequestItem}
     */
    boolean listenToConciergeItem() default  false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestService MeshConciergeRequestService}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestService MeshConciergeRequestService}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestService MeshConciergeRequestService}
     */
    boolean listenToConciergeServices() default  false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFood MeshFood}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFood MeshFood}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFood MeshFood}
     */
    boolean listenToFood() default  false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFoodCategory MeshFoodCategory}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFoodCategory MeshFoodCategory}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFoodCategory MeshFoodCategory}
     */
    boolean listenToFoodCategory() default  false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacility MeshFacility}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacility MeshFacility}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacility MeshFacility}
     */
    boolean listenToFacility() default  false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacilityCategory MeshFacilityCategory}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacilityCategory MeshFacilityCategory}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacilityCategory MeshFacilityCategory}
     */
    boolean listenToFacilityCategory() default  false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshAirport MeshAirport}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshAirport MeshAirport}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshAirport MeshAirport}
     */
    boolean listenToAirport() default  false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshDepartureFlight MeshDepartureFlight}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshDepartureFlight MeshDepartureFlight}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshDepartureFlight MeshDepartureFlight}
     */
    boolean listenToDepartureFlight() default  false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshArrivalFlight MeshArrivalFlight}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshArrivalFlight MeshArrivalFlight}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshArrivalFlight MeshArrivalFlight}
     */
    boolean listenToArrivalFlight() default  false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshCity MeshCity}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshCity MeshCity}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshCity MeshCity}
     */
    boolean listenToCity() default  false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshContinent MeshContinent}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for  {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshContinent MeshContinent}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshContinent MeshContinent}
     */
    boolean listenToContinent() default  false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage MeshMessage}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage MeshMessage}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage MeshMessage}
     */
    boolean listenToMessage() default false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Music.MeshMusic MeshMusic}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Music.MeshMusic MeshMusic}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Music.MeshMusic MeshMusic}
     */
    boolean listenToMusic() default false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Music.MeshMusicCategory MeshMusicCategory}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Music.MeshMusicCategory MeshMusicCategory}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Music.MeshMusicCategory MeshMusicCategory}
     */
    boolean listenToMusicCategory() default false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RoomType.MeshRoomType MeshRoomType}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RoomType.MeshRoomType MeshRoomType}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RoomType.MeshRoomType MeshRoomType}
     */
    boolean listenToRoomType() default false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingCategory MeshShoppingCategory}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingCategory MeshShoppingCategory}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingCategory MeshShoppingCategory}
     */
    boolean listenToShoppingCategory() default false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem MeshShoppingItem}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem MeshShoppingItem}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem MeshShoppingItem}
     */
    boolean listenToShoppingItem() default false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Statistics.MeshStat MeshStat}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Statistics.MeshStat MeshStat}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Statistics.MeshStat MeshStat}
     */
    boolean listenToStatistics() default false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStream MeshStream}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStream MeshStream}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStream MeshStream}
     */
    boolean listenToStream() default false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStreamCategory MeshStreamCategory}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStreamCategory MeshStreamCategory}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStreamCategory MeshStreamCategory}
     */
    boolean listenToStreamCategory() default false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Tag.MeshTag MeshTag}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Tag.MeshTag MeshTag}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Tag.MeshTag MeshTag}
     */
    boolean listenToTag() default false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC MeshVC}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC MeshVC}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC MeshVC}
     */
    boolean listenToVC() default false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory MeshVCCategory}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory MeshVCCategory}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory MeshVCCategory}
     */
    boolean listenToVCCategory() default  false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2 MeshWeatherV2}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2 MeshWeatherV2}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2 MeshWeatherV2}
     */
    boolean listenToWeatherV2() default  false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast MeshWeatherForecast}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast MeshWeatherForecast}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast MeshWeatherForecast}
     */
    boolean listenToWeatherForecast() default false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD MeshVOD}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD MeshVOD}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD MeshVOD}
     */
    boolean listenToVOD() default false;
    /**
     * Listens to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshGenre MeshGenre}
     * @return
     * Values:
     * <br><br>
     * True - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will listen to updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshGenre MeshGenre}
     * <br>
     * False (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment} will ignore updates for {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshGenre MeshGenre}
     */
    boolean listenToGenre() default false;


    boolean listenToSubscription() default false;
    boolean listenToSubscriber() default false;
    boolean listenToPackages() default false;
    boolean listenToChannelPackages() default false;
    boolean listenToEPG() default false;

}
