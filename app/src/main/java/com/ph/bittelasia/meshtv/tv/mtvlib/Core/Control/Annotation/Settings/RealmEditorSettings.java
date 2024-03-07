package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Settings;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation: Sets what MeshTV Objects the RealmEditor can Edit
 * <br>
 * <br>
 * Required by :
 * <br>{@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp MeshTVApp }
 * <br>Configures:
 * <br>{@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RealmEditorSettings
{
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel MeshChannel}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editChannel() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory MeshChannelCategory}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editChannelCategory() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeCategory MeshConciergeCategory}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editConciergeCategory() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestItem MeshConciergeRequestItem}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editConciergeItem() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestService MeshConciergeRequestService}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editConciergeService() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFood MeshFood}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editFood() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFoodCategory MeshFoodCategory}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editFoodCategory() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacility MeshFacility}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editFacility() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacilityCategory MeshFacilityCategory}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editFacilityCategory() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshArrivalFlight MeshArrivalFlight}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editArrivalFlight() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshDepartureFlight MeshDepartureFlight}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editDepartureFlight() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshCity MeshCity}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editCity() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshContinent MeshContinent}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editContinent() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage MeshMessage}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editMessage() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RoomType.MeshRoomType MeshRoomType}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editRoomType() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Music.MeshMusic MeshMusic}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editMusic() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Music.MeshMusicCategory MeshMusicCategory}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editMusicCategory() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem MeshShoppingItem}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editShopping() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingCategory MeshShoppingCategory}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editShoppingCategory() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStream MeshStream}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editStream() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStreamCategory MeshStreamCategory}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editStreamCategory() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD MeshVOD}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editVOD() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshGenre MeshGenre}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editGenre() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast MeshWeatherForecast}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editWeatherForecast() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC MeshVC}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editVC() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory MeshVCCategory}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editVCCategory() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshConfig MeshConfig}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editConfig() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshGuest MeshGuest}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editGuest() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshWeatherLocal MeshWeatherLocal}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editWeather() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2 MeshWeatherV2}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editWeatherV2() default false;
    /**
     * Enables {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.View.Activity.MeshDBEditorActivity MeshDBEditorActivity}
     * to edit {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshIPTV MeshIPTV}
     * @return
     * Result:
     * <br> true - enabled
     * <br> false - disabled
     */
    boolean editIPTV() default false;
    @Deprecated
    boolean saveBackUp() default false;
}
