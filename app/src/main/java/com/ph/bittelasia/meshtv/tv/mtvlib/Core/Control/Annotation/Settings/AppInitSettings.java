package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Settings;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AppInitSettings
{

    //=============================================Events===========================================
    boolean register() default false;
    boolean reportAnalytics() default false;
    //==============================================================================================
    //=============================================Data=============================================
    //--------------------------------------------System--------------------------------------------
    DataMode updateIPTV() default DataMode.UPDATE;
    DataMode updateConfig() default DataMode.UPDATE;
    DataMode updateUser() default DataMode.DO_NOTHING;
    DataMode updateMessage() default DataMode.DO_NOTHING;
    DataMode updateWeather() default DataMode.DO_NOTHING;
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Data----------------------------------------------
    DataMode updateBill() default DataMode.DO_NOTHING;
    DataMode updateChannel() default DataMode.DO_NOTHING;
    DataMode updateChannelCategory() default DataMode.DO_NOTHING;
    DataMode updateConciergeCategory() default DataMode.DO_NOTHING;
    DataMode updateConciergeItem() default DataMode.DO_NOTHING;
    DataMode updateConciergeService() default DataMode.DO_NOTHING;
    DataMode updateFood() default DataMode.DO_NOTHING;
    DataMode updateFoodCategory() default DataMode.DO_NOTHING;
    DataMode updateFacility() default DataMode.DO_NOTHING;
    DataMode updateFacilityCategory() default DataMode.DO_NOTHING;
    DataMode updateAirport() default DataMode.DO_NOTHING;
    DataMode updateArrivalFlight() default DataMode.DO_NOTHING;
    DataMode updateDepartureFlight() default DataMode.DO_NOTHING;
    DataMode updateRoomType() default DataMode.DO_NOTHING;
    DataMode updateShoppingItem() default DataMode.DO_NOTHING;
    DataMode updateShoppingCategory() default DataMode.DO_NOTHING;
    DataMode updatePackage() default DataMode.DO_NOTHING;
    DataMode updatePackageChannel() default DataMode.DO_NOTHING;
    DataMode updatePackageSubscription() default DataMode.DO_NOTHING;
    DataMode updateVC() default DataMode.DO_NOTHING;
    DataMode updateVCCategory() default DataMode.DO_NOTHING;
    DataMode updateGenre() default DataMode.DO_NOTHING;
    DataMode updateVOD() default DataMode.DO_NOTHING;
    DataMode updateForecast() default DataMode.DO_NOTHING;
    DataMode updateEPG() default DataMode.DO_NOTHING;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
