package com.ph.bittelasia.meshtv.tv.mtvlib.Analytics.Control;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Apps.MeshApp;
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
/**
 * Creates {@link MeshStat MeshStat} to monitor IPTV usage
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshAnalyticsManager
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG = MeshAnalyticsManager.class.getSimpleName();
    /**
     * Used when Airmedia was used for Android
     */
    public static final int OS_ANDROID = 0;
    /**
     * Used when Airmedia was used for iOS
     */
    public static final int OS_IOS = 1;
    /**
     * Used when Airmedia was used for Windows
     */
    public static final int OS_WINDOWS = 2;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Method==========================================
    //-----------------------------------------------Tick-------------------------------------------
    /**
     * Adds a {@link MeshStat MeshStat} every time a Airmedia was opened
     * @param os
     * OS Airmedia was used for:
     * <br>
     * Android : 0 ({@link #OS_ANDROID OS_ANDROID})
     * <br>
     * IOS : 1 ({@link #OS_IOS OS_IOS})
     * <br>
     * Windows : 2 ({@link #OS_WINDOWS OS_WINDOWS})
     */
   public static final synchronized void tickAirMedia(int os)
    {
        BittelAnalyticsManager.tickAirmedia(os);
    }
    /**
     * Adds a {@link MeshStat MeshStat} for usage of:
     * <br>1. {@link MeshApp MeshApp}
     * <br>2. {@link MeshChannel MeshChannel}
     * <br>3. {@link MeshChannelCategory MeshChannelCategory}
     * <br>4. Airmedia OS
     * <br>5. {@link MeshChannelCategory MeshChannelCategory}
     * <br>6. {@link MeshRoomType MeshRoomType}
     * <br>7. {@link MeshFacility MeshFacility}
     * <br>8. {@link MeshFacilityCategory MeshFacilityCategory}
     * <br>9. {@link MeshVC MeshVC}
     * <br>10. {@link MeshVCCategory MeshVC}
     * <br>11. {@link MeshFood MeshFood}
     * <br>12. {@link MeshFoodCategory MeshFoodCategory}
     * <br>13. {@link MeshWeatherForecast MeshWeatherForecast}
     * <br>14. {@link MeshShoppingItem MeshShoppingItem}
     * <br>15. {@link MeshShoppingCategory MeshShoppingCategory}
     * <br>15. {@link MeshConciergeRequestService MeshConciergeRequestService}
     * <br>15. {@link MeshConciergeRequestItem MeshConciergeRequestItem}
     * @param o Object that was used
     */
    public static final synchronized void tick(Object o)
    {
        if(o instanceof MeshApp)
        {
            BittelAnalyticsManager.tickApps((MeshApp)o);
        }
        else if(o instanceof MeshChannel)
        {
            BittelAnalyticsManager.tickChannels((MeshChannel)o);
        }
        else if(o instanceof MeshChannelCategory)
        {
            BittelAnalyticsManager.tickChannelCategory((MeshChannelCategory) o);
        }
        else if(o instanceof MeshRoomType)
        {
            BittelAnalyticsManager.tickRoomType((MeshRoomType) o);
        }
        else if(o instanceof MeshFacility)
        {
            BittelAnalyticsManager.tickHotelFacility((MeshFacility) o);
        }
        else if(o instanceof MeshFacilityCategory)
        {
            BittelAnalyticsManager.tickHotelFacilityCategory((MeshFacilityCategory) o);
        }
        else if(o instanceof MeshVC)
        {
            BittelAnalyticsManager.tickVC((MeshVC) o);
        }
        else if(o instanceof MeshVCCategory)
        {
            BittelAnalyticsManager.tickVCCategory((MeshVCCategory) o);
        }
        else if(o instanceof MeshFood)
        {
            BittelAnalyticsManager.tickDining((MeshFood) o);
        }
        else if(o instanceof MeshFoodCategory)
        {
            BittelAnalyticsManager.tickDiningCategory((MeshFoodCategory) o);
        }
        else if(o instanceof MeshWeatherForecast)
        {
            BittelAnalyticsManager.tickWeatherForecst((MeshWeatherForecast) o);
        }
        else if(o instanceof MeshShoppingItem)
        {
            BittelAnalyticsManager.tickShoppingItem((MeshShoppingItem) o);
        }
        else if(o instanceof MeshShoppingCategory)
        {
            BittelAnalyticsManager.tickShoppingCategory((MeshShoppingCategory) o);
        }
        else if(o instanceof MeshConciergeRequestService)
        {
            BittelAnalyticsManager.tickService((MeshConciergeRequestService) o);
        }
        else if(o instanceof MeshConciergeRequestItem)
        {
            BittelAnalyticsManager.tickItem((MeshConciergeRequestItem) o);
        }
        else if(o instanceof MeshVOD)
        {
            BittelAnalyticsManager.tickItem((MeshVOD) o);
        }
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
