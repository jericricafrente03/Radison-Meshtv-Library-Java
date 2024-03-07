package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Parser;

import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshSubscriber;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Bill.MeshBillV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshEPG;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackageChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshSubscription;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestService;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFood;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFoodCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacility;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacilityCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshAirport;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshArrivalFlight;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshDepartureFlight;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshCity;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshContinent;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RoomType.MeshRoomType;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Statistics.MeshStat;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStream;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStreamCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Tag.MeshTag;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshTelecomBill;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshGenre;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVODBought;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshCompany;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshLayout;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshSchedule;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshSignage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model.MeshSignageSchedule;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshLayoutV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaZone;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaZoneAssignment;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshScrollingMessage;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshSignageV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshType;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Parses JSONData to corresponding data depending on their class
 * <br>
 * <br>
 * Version 2.0 added support for:
 * <br>1. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackage MeshPackage}
 * <br>2. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackageChannel MeshPackageChannel}
 * <br>3. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshSubscription MeshSubscription}
 * @author Mars Ray Canizares Araullo
 * @version 2.0
 */
class BittelParser
{
    //===============================================Variable=======================================
    //-----------------------------------------------Constant---------------------------------------
    public static final String TAG = BittelParser.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Airport========================================

    /**
     * Parse data to a list of {@link MeshAirport MeshAirport}s
     * @param data String data to be parsed
     * @return list of {@link MeshAirport MeshAirport}s
     */
    static ArrayList<MeshAirport> parseAirports(String data)
    {
        ArrayList<MeshAirport> airports = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshAirport ap = parseAirport(array.getString(ctr));
                if(ap!=null)
                {
                    airports.add(ap);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return airports;
    }

    /**
     * Parse data into a {@link MeshAirport MeshAirport}
     * @param data String data to be parsed
     * @return instance of {@link MeshAirport MeshAirport}
     */
    private static MeshAirport parseAirport(String data)
    {
        MeshAirport airport = new MeshAirport();
        try
        {
            JSONObject object = new JSONObject(data);
            airport.setId(object.getInt(MeshAirport.TAG_ID));
            airport.setActive(object.getInt(MeshAirport.TAG_ACTIVE));
            airport.setClassification(object.getInt(MeshAirport.TAG_CLASSIFICATION));

            airport.setCity(object.getString(MeshAirport.TAG_CITY));
            airport.setCitycode(object.getString(MeshAirport.TAG_CITYCODE));
            airport.setCountrycode(object.getString(MeshAirport.TAG_COUNTRY_CODE));
            airport.setCountryname(object.getString(MeshAirport.TAG_COUNTRY_NAME));
            airport.setFs(object.getString(MeshAirport.TAG_FS));
            airport.setIata(object.getString(MeshAirport.TAG_IATA));
            airport.setIcao(object.getString(MeshAirport.TAG_ICAO));
            airport.setName(object.getString(MeshAirport.TAG_NAME));
            airport.setRegionname(object.getString(MeshAirport.TAG_REGION_NAME));

            airport.setLatitude(Double.valueOf(object.getString(MeshAirport.TAG_LAT)));
            airport.setLongitude(Double.valueOf(object.getString(MeshAirport.TAG_LONG)));

            return airport;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //===============================================Arrival========================================
    /**
     * Parse data to a list of {@link MeshArrivalFlight MeshArrivalFlight}s
     * @param data String data to be parsed
     * @return list of {@link MeshArrivalFlight MeshArrivalFlight}s
     */
    static ArrayList<MeshArrivalFlight> parseArrivalFlights(String data)
    {
        ArrayList<MeshArrivalFlight> arrival = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshArrivalFlight ap = parseArrivalFlight(array.getString(ctr));
                if(ap!=null)
                {
                    arrival.add(ap);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return arrival;
    }
    /**
     * Parse data into a {@link MeshArrivalFlight MeshArrivalFlight}
     * @param data String data to be parsed
     * @return instance of {@link MeshArrivalFlight MeshArrivalFlight}
     */
    private static MeshArrivalFlight parseArrivalFlight(String data)
    {
        MeshArrivalFlight arrivalFlight = new MeshArrivalFlight();
        try
        {
            JSONObject object = new JSONObject(data);
            arrivalFlight.setFlight_number(object.getString(MeshArrivalFlight.TAG_FLIGHT_NUMBER));
            arrivalFlight.setOrigin(object.getString(MeshArrivalFlight.TAG_ORIGIN));
            arrivalFlight.setMin_off(object.getString(MeshArrivalFlight.TAG_MINOFF));
            arrivalFlight.setStatus(object.getString(MeshArrivalFlight.TAG_STATUS));
            arrivalFlight.setOntime_status(object.getString(MeshArrivalFlight.TAG_ONTIME_STATUS));
            arrivalFlight.setArrival_datetime(object.getString(MeshArrivalFlight.TAG_ARRIVAL_DATETIME));
            arrivalFlight.setCarrier(object.getString(MeshArrivalFlight.TAG_CARRIER));
            arrivalFlight.setArrivalDate(new SimpleDateFormat(MeshArrivalFlight.DATE_FORMAT).parse(arrivalFlight.getArrival_datetime()));

            return arrivalFlight;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //=================================================Bill=========================================
    /**
     * Parse data to a list of {@link MeshBillV2 MeshBillV2}s
     * @param data String data to be parsed
     * @return list of {@link MeshBillV2 MeshBillV2}s
     */
    static ArrayList<MeshBillV2> parseBills(String data)
    {
        ArrayList<MeshBillV2> bills = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshBillV2 ap = parseBill(array.getString(ctr));
                if(ap!=null)
                {
                    bills.add(ap);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return bills;
    }
    /**
     * Parse data into a {@link MeshBillV2 MeshBillV2}
     * @param data String data to be parsed
     * @return instance of {@link MeshBillV2 MeshBillV2}
     */
    private static MeshBillV2 parseBill(String data)
    {
        MeshBillV2 bill = new MeshBillV2();
        try
        {
            JSONObject object = new JSONObject(data);
            bill.setId(object.getInt(MeshBillV2.TAG_ID));
            bill.setPrice(object.getDouble(MeshBillV2.TAG_BI));
            bill.setItem(object.getString(MeshBillV2.TAG_BD));
            bill.setDa(object.getDouble(MeshBillV2.TAG_DA));
            bill.setTi(object.getInt(MeshBillV2.TAG_TI));
            return bill;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //===============================================Channel========================================
    /**
     * Parse data to a list of {@link MeshChannel MeshChannel}s
     * @param data String data to be parsed
     * @return list of {@link MeshChannel MeshChannel}s
     */
    static ArrayList<MeshChannel> parseChannels(String data)
    {
        ArrayList<MeshChannel> channels = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshChannel ch = parseChannel(array.getString(ctr));
                if(ch!=null)
                {
                    channels.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return channels;
    }
    /**
     * Parse data into a {@link MeshChannel MeshChannel}
     * @param data String data to be parsed
     * @return instance of {@link MeshChannel MeshChannel}
     */
    private static MeshChannel parseChannel(String data)
    {
        MeshChannel channel = new MeshChannel();
        try
        {
            JSONObject object = new JSONObject(data);
            channel.setId(object.getInt(MeshChannel.TAG_ID));
            channel.setChannel_category_id(object.getInt(MeshChannel.TAG_CATEGORY_ID));
            channel.setChannel_description(object.getString(MeshChannel.TAG_DESCRIPTION));
            channel.setChannel_image(object.getString(MeshChannel.TAG_IMAGE_URL));
            channel.setChannel_title(object.getString(MeshChannel.TAG_TITLE));
            channel.setChannel_uri(object.getString(MeshChannel.TAG_URI));
            if(object.has(MeshChannel.TAG_ORDER))
            {
                channel.setOrder_no(object.getInt(MeshChannel.TAG_ORDER));
            }
            return channel;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //==========================================ChannelCategory=====================================
    /**
     * Parse data to a list of {@link MeshChannelCategory MeshChannelCategories}
     * @param data String data to be parsed
     * @return list of {@link MeshChannelCategory MeshChannelCategories}
     */
    static ArrayList<MeshChannelCategory> parseChannelCategories(String data)
    {
        ArrayList<MeshChannelCategory> categories = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshChannelCategory ch = parseChannelCategory(array.getString(ctr));
                if(ch!=null)
                {
                    categories.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return categories;
    }

    /**
     * Parse data into a {@link MeshChannelCategory MeshChannelCategory}
     * @param data String data to be parsed
     * @return instance of {@link MeshChannelCategory MeshChannelCategory}
     */
    private static MeshChannelCategory parseChannelCategory(String data)
    {
        MeshChannelCategory category = new MeshChannelCategory();
        try
        {
            JSONObject object = new JSONObject(data);
            category.setId(object.getInt(MeshChannel.TAG_ID));
            category.setId(object.getInt(MeshChannelCategory.TAG_ID));
            category.setCategory_description(object.getString(MeshChannelCategory.TAG_DESC));
            category.setCategory_name(object.getString(MeshChannelCategory.TAG_NAME));
            return category;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //===============================================City===========================================
    /**
     * Parse data to a list of {@link MeshCity MeshCities}
     * @param data String data to be parsed
     * @return list of {@link MeshCity MeshCities}
     */
    static ArrayList<MeshCity> parseCities(String data)
    {
        ArrayList<MeshCity> cities = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshCity ch = parseCity(array.getString(ctr));
                if(ch!=null)
                {
                    cities.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return cities;
    }
    /**
     * Parse data into a {@link MeshCity MeshCity}
     * @param data String data to be parsed
     * @return instance of {@link MeshCity MeshCity}
     */
    private static MeshCity parseCity(String data)
    {
        MeshCity city = new MeshCity();
        try
        {
            JSONObject object = new JSONObject(data);
            city.setId(object.getInt(MeshCity.TAG_ID));
            city.setCont_id(object.getInt(MeshCity.TAG_CONT_ID));
            city.setName(object.getString(MeshCity.TAG_NAME));
            city.setCntry(object.getString(MeshCity.TAG_COUNTRY));
            city.setCntry_code(object.getString(MeshCity.TAG_COUNTRY_CODE));
            city.setCode(object.getString(MeshCity.TAG_CODE));
            city.setTzone(object.getString(MeshCity.TAG_TZONE));
            return city;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //============================================Continent=========================================
    /**
     * Parse data to a list of {@link MeshContinent MeshContinent}s
     * @param data String data to be parsed
     * @return list of {@link MeshContinent MeshContinent}s
     */
    static ArrayList<MeshContinent> parseContinents(String data)
    {
        ArrayList<MeshContinent> continents = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshContinent ch = parseContinent(array.getString(ctr));
                if(ch!=null)
                {
                    continents.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return continents;
    }
    /**
     * Parse data into a {@link MeshContinent MeshContinent}
     * @param data String data to be parsed
     * @return instance of {@link MeshContinent MeshContinent}
     */
    private static MeshContinent parseContinent(String data)
    {
        MeshContinent continent = new MeshContinent();
        try
        {
            JSONObject object = new JSONObject(data);
            continent.setId(object.getInt(MeshContinent.TAG_ID));
            continent.setName(object.getString(MeshContinent.TAG_NAME));

            return continent;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //=======================================ConciergeCategories====================================
    /**
     * Parse data to a list of {@link MeshConciergeCategory MeshConciergeCategories}
     * @param data String data to be parsed
     * @return list of {@link MeshConciergeCategory MeshConciergeCategories}
     */
    static ArrayList<MeshConciergeCategory> parseConciergeCategories(String data)
    {
        ArrayList<MeshConciergeCategory> arrival = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshConciergeCategory ap = parseConciergeCategory(array.getString(ctr));
                if(ap!=null)
                {
                    arrival.add(ap);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return arrival;
    }
    /**
     * Parse data into a {@link MeshConciergeCategory MeshConciergeCategory}
     * @param data String data to be parsed
     * @return instance of {@link MeshConciergeCategory MeshConciergeCategory}
     */
    private static MeshConciergeCategory parseConciergeCategory(String data)
    {
        MeshConciergeCategory category = new MeshConciergeCategory();
        try
        {
            JSONObject object = new JSONObject(data);
            category.setCategory_description(object.getString(MeshConciergeCategory.TAG_DESC));
            category.setCategory_image(object.getString(MeshConciergeCategory.TAG_IMAGE));
            category.setCategory_name(object.getString(MeshConciergeCategory.TAG_NAME));
            category.setId(object.getInt(MeshConciergeCategory.TAG_ID));
            return category;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //============================================Departure=========================================
    /**
     * Parse data to a list of {@link MeshDepartureFlight MeshDepartureFlight}s
     * @param data String data to be parsed
     * @return list of {@link MeshDepartureFlight MeshDepartureFlight}s
     */
    static ArrayList<MeshDepartureFlight> parseDepartureFlights(String data)
    {
        ArrayList<MeshDepartureFlight> flights = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshDepartureFlight ch = parseDepartureFlight(array.getString(ctr));
                if(ch!=null)
                {
                    flights.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return flights;
    }
    /**
     * Parse data into a {@link MeshDepartureFlight MeshDepartureFlight}
     * @param data String data to be parsed
     * @return instance of {@link MeshDepartureFlight MeshDepartureFlight}
     */
    private static MeshDepartureFlight parseDepartureFlight(String data)
    {
        MeshDepartureFlight flight = new MeshDepartureFlight();
        try
        {
            JSONObject object = new JSONObject(data);
            flight.setFlight_number(object.getString(MeshDepartureFlight.TAG_FLIGHT_NUMBER));
            flight.setDestination(object.getString(MeshDepartureFlight.TAG_DESTINATION));
            flight.setMin_off(object.getString(MeshDepartureFlight.TAG_MINOFF));
            flight.setStatus(object.getString(MeshDepartureFlight.TAG_STATUS));
            flight.setOntime_status(object.getString(MeshDepartureFlight.TAG_ONTIME_STATUS));
            flight.setDeparture_datetime(object.getString(MeshDepartureFlight.TAG_DEPARTURE_DATETIME));
            flight.setCarrier(object.getString(MeshDepartureFlight.TAG_CARRIER));
            flight.setDepartureDate(new SimpleDateFormat(MeshDepartureFlight.DATE_FORMAT).parse(flight.getDeparture_datetime()));
            return flight;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //===============================================Tag============================================
    /**
     * Parse data to a list of {@link MeshTag MeshTag}s
     * @param data String data to be parsed
     * @return list of {@link MeshTag MeshTag}s
     */
    static ArrayList<MeshTag> parseTags(String data)
    {
        ArrayList<MeshTag> tags = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshTag ch = parseTag(array.getString(ctr));
                if(ch!=null)
                {
                    tags.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return tags;
    }
    /**
     * Parse data into a {@link MeshTag MeshTag}
     * @param data String data to be parsed
     * @return instance of {@link MeshTag MeshTag}
     */
    private static MeshTag parseTag(String data)
    {
        Log.i(TAG,"ERROR MESHTAG:"+data);
        MeshTag tag = new MeshTag();
        try
        {
            JSONObject object = new JSONObject(data);
            tag.setId(object.getInt(MeshTag.TAG_ID));
            tag.setName(object.getString(MeshTag.TAG_NAME));
            tag.setParent(object.getString(MeshTag.TAG_PARENT));
            tag.setDescription(object.getString(MeshTag.TAG_DESC));
            tag.setImg(object.getString(MeshTag.TAG_IMG));
            tag.setIsCustom(object.getInt(MeshTag.TAG_IS_CUSTOM));
            tag.setParentID(object.getInt(MeshTag.TAG_PARENTID));
            tag.setPrice(Double.valueOf(object.getString(MeshTag.TAG_PRICE)));

            return tag;
        }
        catch (Exception e)
        {
            Log.i(TAG,"ERROR MESHTAG:"+e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //============================================Facility==========================================
    /**
     * Parse data to a list of {@link MeshFacility MeshFacilities}
     * @param data String data to be parsed
     * @return list of {@link MeshFacility MeshFacilities}
     */
    static ArrayList<MeshFacility> parseFacilities(String data)
    {
        ArrayList<MeshFacility> facilities = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshFacility ch = parseFacility(array.getString(ctr));
                if(ch!=null)
                {
                    facilities.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return facilities;
    }
    /**
     * Parse data into a {@link MeshFacility MeshFacility}
     * @param data String data to be parsed
     * @return instance of {@link MeshFacility MeshFacility}
     */
    private static MeshFacility parseFacility(String data)
    {
        MeshFacility facility = new MeshFacility();
        try
        {
            JSONObject object = new JSONObject(data);
            facility.setId(object.getInt(MeshFacility.TAG_ID));
            facility.setCategory_id(object.getInt(MeshFacility.TAG_CATEGORY_ID));
            facility.setItem_description(object.getString(MeshFacility.TAG_DESC));
            facility.setItem_name(object.getString(MeshFacility.TAG_ITEM_NAME));
            facility.setImg_uri(object.getString(MeshFacility.TAG_IMG_URI));
            facility.setUnit_price(Double.valueOf(object.getString(MeshFacility.TAG_UNIT_PRICE)));

            return facility;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //========================================FacilityCategory======================================
    /**
     * Parse data to a list of {@link MeshFacilityCategory MeshFacilityCategories}
     * @param data String data to be parsed
     * @return list of {@link MeshFacilityCategory MeshFacilityCategories}
     */
    static ArrayList<MeshFacilityCategory> parseFacilityCategories(String data)
    {
        ArrayList<MeshFacilityCategory> categories = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshFacilityCategory ch = parseFacilityCategory(array.getString(ctr));
                if(ch!=null)
                {
                    categories.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return categories;
    }
    /**
     * Parse data into a {@link MeshFacilityCategory MeshFacilityCategory}
     * @param data String data to be parsed
     * @return instance of {@link MeshFacilityCategory MeshFacilityCategory}
     */
    private static MeshFacilityCategory parseFacilityCategory(String data)
    {
        MeshFacilityCategory category = new MeshFacilityCategory();
        try
        {
            JSONObject object = new JSONObject(data);
            category.setId(object.getInt(MeshFacilityCategory.TAG_ID));
            category.setCategory_name(object.getString(MeshFacilityCategory.TAG_NAME));
            category.setCategory_description(object.getString(MeshFacilityCategory.TAG_DESC));
            if(object.has(MeshFacilityCategory.TAG_IMAGE))
            {
                category.setImg_uri(object.getString(MeshFacilityCategory.TAG_IMAGE));
            }
            if(object.has(MeshFacilityCategory.TAG_IMAGE_PREVIEW))
            {
                category.setImg_preview(object.getString(MeshFacilityCategory.TAG_IMAGE_PREVIEW));
            }

            return category;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //===============================================Food===========================================
    /**
     * Parse data to a list of {@link MeshFood MeshFood}s
     * @param data String data to be parsed
     * @return list of {@link MeshFood MeshFood}s
     */
    static ArrayList<MeshFood> parseFoods(String data)
    {
        ArrayList<MeshFood> foods = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshFood ch = parseFood(array.getString(ctr));
                if(ch!=null)
                {
                    foods.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return foods;
    }
    /**
     * Parse data into a {@link MeshFood MeshFood}
     * @param data String data to be parsed
     * @return instance of {@link MeshFood MeshFood}
     */
    private static MeshFood parseFood(String data)
    {
        MeshFood food = new MeshFood();
        try
        {
            JSONObject object = new JSONObject(data);
            food.setId(object.getInt(MeshFood.TAG_ID));
            food.setCategory_id(object.getInt(MeshFood.TAG_CATEGORY_ID));
            food.setCombo_items(object.getString(MeshFood.TAG_COMBO));
            food.setImg_uri(object.getString(MeshFood.TAG_IMG_URI));
            food.setItem_description(object.getString(MeshFood.TAG_DESC));
            food.setItem_name(object.getString(MeshFood.TAG_ITEM_NAME));
            food.setUnit_price(Double.valueOf(object.getString(MeshFood.TAG_UNIT_PRICE)));
            return food;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //===========================================FoodCategory=======================================
    /**
     * Parse data to a list of {@link MeshFoodCategory MeshFoodCategories}
     * @param data String data to be parsed
     * @return list of {@link MeshFoodCategory MeshFoodCategories}
     */
    static ArrayList<MeshFoodCategory> parseFoodCategories(String data)
    {
        ArrayList<MeshFoodCategory> categories = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshFoodCategory ch = parseFoodCategory(array.getString(ctr));
                if(ch!=null)
                {
                    categories.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return categories;
    }
    /**
     * Parse data into a {@link MeshFoodCategory MeshFoodCategory}
     * @param data String data to be parsed
     * @return instance of {@link MeshFoodCategory MeshFoodCategory}
     */
    private static MeshFoodCategory parseFoodCategory(String data)
    {
        MeshFoodCategory category = new MeshFoodCategory();
        try {
            JSONObject object = new JSONObject(data);
            category.setId(object.getInt(MeshFoodCategory.TAG_ID));
            category.setCategory_name(object.getString(MeshFoodCategory.TAG_NAME));
            category.setCategory_description(object.getString(MeshFoodCategory.TAG_DESC));

            return category;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //=============================================Forecast=========================================
    /**
     * Parse data to a list of {@link MeshWeatherForecast MeshWeatherForecast}s
     * @param data String data to be parsed
     * @return list of {@link MeshWeatherForecast MeshWeatherForecast}s
     */
    static ArrayList<MeshWeatherForecast> parseForecasts(String data)
    {
        ArrayList<MeshWeatherForecast> forecasts = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshWeatherForecast ch = parseForecast(array.getString(ctr));
                if(ch!=null)
                {
                    forecasts.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return forecasts;
    }
    /**
     * Parse data into a {@link MeshWeatherForecast MeshWeatherForecast}
     * @param data String data to be parsed
     * @return instance of {@link MeshWeatherForecast MeshWeatherForecast}
     */
    private static MeshWeatherForecast parseForecast(String data)
    {
        MeshWeatherForecast forecast = new MeshWeatherForecast();
        try {
            JSONObject object = new JSONObject(data);
            forecast.setCountry(object.getString(MeshWeatherForecast.TAG_COUNTRY));
            forecast.setForecast(object.getString(MeshWeatherForecast.TAG_FORECAST));
            forecast.setCity(object.getString(MeshWeatherForecast.TAG_CITY));


            return forecast;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //=============================================Genre============================================
    /**
     * Parse data to a list of {@link MeshGenre MeshGenre}s
     * @param data String data to be parsed
     * @return list of {@link MeshGenre MeshGenre}s
     */
    static ArrayList<MeshGenre> parseGenres(String data)
    {
        ArrayList<MeshGenre> genres = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshGenre ch = parseGenre(array.getString(ctr));
                if(ch!=null)
                {
                    genres.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return genres;
    }
    /**
     * Parse data into a {@link MeshGenre MeshGenre}
     * @param data String data to be parsed
     * @return instance of {@link MeshGenre MeshGenre}
     */
    private static MeshGenre parseGenre(String data)
    {
        MeshGenre genre = new MeshGenre();
        try {
            JSONObject object = new JSONObject(data);
            genre.setId(object.getInt(MeshGenre.TAG_ID));
            genre.setGenre(object.getString(MeshGenre.TAG_NAME));

            return genre;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //=============================================Message==========================================
    /**
     * Parse data to a list of {@link MeshMessage MeshMessage}s
     * @param data String data to be parsed
     * @return list of {@link MeshMessage MeshMessage}s
     */
    static ArrayList<MeshMessage> parseMessages(String data)
    {
        ArrayList<MeshMessage> messages = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshMessage ch = parseMessage(array.getString(ctr));
                if(ch!=null)
                {
                    messages.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return messages;
    }
    /**
     * Parse data into a {@link MeshMessage MeshMessage}
     * @param data String data to be parsed
     * @return instance of {@link MeshMessage MeshMessage}
     */
    private static MeshMessage parseMessage(String data)
    {
        MeshMessage message = new MeshMessage();
        try
        {
            JSONObject object = new JSONObject(data);
            message.setId(object.getInt(MeshMessage.TAG_ID));
            if(object.has(MeshMessage.TAG_ROOMNO))
            {
                message.setRoom_id(object.getString(MeshMessage.TAG_ROOMNO));
            }
            else if(object.has(MeshMessage.TAG_ACCOUNT))
            {
                message.setRoom_id(object.getString(MeshMessage.TAG_ACCOUNT));
            }
            else if(object.has(MeshMessage.TAG_USER_ID))
            {
                message.setRoom_id(object.getString(MeshMessage.TAG_USER_ID));
            }
            message.setMessg_subject(object.getString(MeshMessage.TAG_SUBJECT));
            message.setMessg_datetime(object.getString(MeshMessage.TAG_DATE));
            message.setMessg_from(object.getString(MeshMessage.TAG_FROM));
            message.setMessg_text(object.getString(MeshMessage.TAG_MESSAGE));
            message.setMessg_status(object.getInt(MeshMessage.TAG_STATUS));


            if(object.has(MeshMessage.TAG_IMG))
            {
                message.setMessg_img(object.getString(MeshMessage.TAG_IMG));
            }
            if(object.has(MeshMessage.TAG_VID))
            {
                message.setMessg_vid(object.getString(MeshMessage.TAG_VID));
            }
            if(object.has(MeshMessage.TAG_TYPE))
            {
                message.setMessg_type(object.getInt(MeshMessage.TAG_TYPE));
            }
            if(object.has(MeshMessage.TAG_DIS_TIME))
            {
                message.setMessg_display_time(object.getInt(MeshMessage.TAG_DIS_TIME));
            }

            return message;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //==========================================MeshRoomType========================================
    /**
     * Parse data to a list of {@link MeshRoomType MeshRoomType}s
     * @param data String data to be parsed
     * @return list of {@link MeshRoomType MeshRoomType}s
     */
    static ArrayList<MeshRoomType> parseRoomTypes(String data)
    {
        ArrayList<MeshRoomType> types = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshRoomType ch = parseRoomType(array.getString(ctr));
                if(ch!=null)
                {
                    types.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return types;
    }
    /**
     * Parse data into a {@link MeshRoomType MeshRoomType}
     * @param data String data to be parsed
     * @return instance of {@link MeshRoomType MeshRoomType}
     */
    private static MeshRoomType parseRoomType(String data)
    {
        MeshRoomType room = new MeshRoomType();
        try {
            JSONObject object = new JSONObject(data);
            room.setId(object.getInt(MeshRoomType.TAG_ID));
            room.setCategory_name(object.getString(MeshRoomType.TAG_NAME));
            room.setCategory_description(object.getString(MeshRoomType.TAG_DESC));
            room.setAmenities(object.getString(MeshRoomType.TAG_AMENITIES));
            room.setFacilityCategoryId(object.getInt(MeshRoomType.TAG_CATEGORY_ID));
            room.setImages(object.getString(MeshRoomType.TAG_IMAGES));
            room.setOrderNo(object.getInt(MeshRoomType.TAG_ORDER));

            return room;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //==========================================MeshShopping========================================
    /**
     * Parse data to a list of {@link MeshShoppingItem MeshShoppingItem}s
     * @param data String data to be parsed
     * @return list of {@link MeshShoppingItem MeshShoppingItem}s
     */
    static ArrayList<MeshShoppingItem> parseShoppingItems(String data)
    {
        ArrayList<MeshShoppingItem> items = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshShoppingItem ch = parseShoppingItem(array.getString(ctr));
                if(ch!=null)
                {
                    items.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return items;
    }
    /**
     * Parse data to a list of {@link MeshShoppingItem MeshShoppingItem}s
     * @param data String data to be parsed
     * @return list of {@link MeshShoppingItem MeshShoppingItem}s
     */
    private static MeshShoppingItem parseShoppingItem(String data)
    {
        MeshShoppingItem item = new MeshShoppingItem();
        try
        {
            JSONObject object = new JSONObject(data);
            item.setId(object.getInt(MeshShoppingItem.TAG_ID));
            item.setUnit_price(Double.valueOf(object.getString(MeshShoppingItem.TAG_UNIT_PRICE)));
            item.setImg_uri(object.getString(MeshShoppingItem.TAG_IMG_URI));
            item.setItem_description(object.getString(MeshShoppingItem.TAG_DESC));
            item.setItem_name(object.getString(MeshShoppingItem.TAG_ITEM_NAME));
            item.setShopping_category_id(Integer.valueOf(object.getString(MeshShoppingItem.TAG_CATEGORY_ID)));
            return item;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //======================================MeshShoppingCategory====================================
    /**
     * Parse data to a list of {@link MeshShoppingCategory MeshShoppingCategories}
     * @param data String data to be parsed
     * @return list of {@link MeshShoppingCategory MeshShoppingCategories}
     */
    static ArrayList<MeshShoppingCategory> parseShoppingCategories(String data)
    {
        ArrayList<MeshShoppingCategory> categories = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshShoppingCategory ch = parseShoppingCategory(array.getString(ctr));
                if(ch!=null)
                {
                    categories.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return categories;
    }
    /**
     * Parse data into a {@link MeshShoppingCategory MeshShoppingCategory}
     * @param data String data to be parsed
     * @return instance of {@link MeshShoppingCategory MeshShoppingCategory}
     */
    private static MeshShoppingCategory parseShoppingCategory(String data)
    {
        MeshShoppingCategory category = new MeshShoppingCategory();
        try
        {
            JSONObject object = new JSONObject(data);
            category.setId(object.getInt(MeshShoppingCategory.TAG_ID));
            category.setCategory_description(object.getString(MeshShoppingCategory.TAG_DESC));
            category.setCategory_name(object.getString(MeshShoppingCategory.TAG_NAME));

            return category;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //=============================================MeshStat=========================================
    /**
     * Parse data to a list of {@link MeshStat MeshStat}s
     * @param data String data to be parsed
     * @return list of {@link MeshStat MeshStat}s
     */
    static ArrayList<MeshStat> parseStats(String data)
    {
        ArrayList<MeshStat> stats = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshStat ch = parseStat(array.getString(ctr));
                if(ch!=null)
                {
                    stats.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return stats;
    }
    /**
     * Parse data into a {@link MeshStat MeshStat}
     * @param data String data to be parsed
     * @return instance of {@link MeshStat MeshStat}
     */
    private static MeshStat parseStat(String data)
    {
        MeshStat stat = new MeshStat();
        try
        {
            JSONObject object = new JSONObject(data);
            stat.setId(object.getString(MeshStat.TAG_ID));
            stat.setName(object.getString(MeshStat.TAG_NAME));
            stat.setType(object.getString(MeshStat.TAG_TYPE));
            stat.setTick(object.getInt(MeshStat.TAG_TICK));
            stat.setItem_id(object.getInt(MeshStat.TAG_ITEM_ID));
            stat.setDate(object.getString(MeshStat.TAG_DATE));

            return stat;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //==============================================Stream==========================================
    /**
     * Parse data to a list of {@link MeshStream MeshStream}s
     * @param data String data to be parsed
     * @return list of {@link MeshStream MeshStream}s
     */
    static ArrayList<MeshStream> parseStreams(String data)
    {
        ArrayList<MeshStream> streams = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshStream ch = parseStream(array.getString(ctr));
                if(ch!=null)
                {
                    streams.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return streams;
    }

    /**
     * Parse data into a {@link MeshStream MeshStream}
     * @param data String data to be parsed
     * @return instance of {@link MeshStream MeshStream}
     */
    private static MeshStream parseStream(String data)
    {
        MeshStream stream = new MeshStream();
        try
        {
            JSONObject object = new JSONObject(data);
            stream.setId(object.getInt(MeshStream.TAG_ID));
            stream.setCategory(object.getInt(MeshStream.TAG_CATEGORY));
            stream.setTitle(object.getString(MeshStream.TAG_TITLE));
            stream.setCountry(object.getString(MeshStream.TAG_COUNTRY));
            stream.setDescription(object.getString(MeshStream.TAG_DESCRIPTION));
            stream.setReleased(object.getString(MeshStream.TAG_BROADCAST_START));
            stream.setTags(object.getString(MeshStream.TAG_TAGS));
            stream.setEpisodes(object.getString(MeshStream.TAG_EPISODES));
            stream.setImage(object.getString(MeshStream.TAG_IMAGE_URL));
            stream.setStatus(object.getString(MeshStream.TAG_STATUS));


            return stream;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //==========================================StreamCategory======================================
    /**
     * Parse data to a list of {@link MeshStreamCategory MeshStreamCategories}
     * @param data String data to be parsed
     * @return list of {@link MeshStreamCategory MeshStreamCategories}
     */
    static ArrayList<MeshStreamCategory> parseStreamCategories(String data)
    {
        ArrayList<MeshStreamCategory> categories = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshStreamCategory ch = parseStreamCategory(array.getString(ctr));
                if(ch!=null)
                {
                    categories.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return categories;
    }
    /**
     * Parse data into a {@link MeshStreamCategory MeshStreamCategory}
     * @param data String data to be parsed
     * @return instance of {@link MeshStreamCategory MeshStreamCategory}
     */
    private static MeshStreamCategory parseStreamCategory(String data)
    {
        MeshStreamCategory category = new MeshStreamCategory();
        try
        {
            JSONObject object = new JSONObject(data);
            category.setId(object.getInt(MeshStreamCategory.TAG_ID));
            category.setCategory_description(object.getString(MeshStreamCategory.TAG_CATEGORY_DESCRIPTION));
            category.setCategory_name(object.getString(MeshStreamCategory.TAG_CATEGORY_NAME));



            return category;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //=================================================VC===========================================
    /**
     * Parse data to a list of {@link MeshVC MeshVC}s
     * @param data String data to be parsed
     * @return list of {@link MeshVC MeshVC}s
     */
    static ArrayList<MeshVC> parseVCs(String data)
    {
        ArrayList<MeshVC> vcs = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshVC ch = parseVC(array.getString(ctr));
                if(ch!=null)
                {
                    vcs.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return vcs;
    }
    /**
     * Parse data into a {@link MeshVC MeshVC}
     * @param data String data to be parsed
     * @return instance of {@link MeshVC MeshVC}
     */
    private static MeshVC parseVC(String data)
    {
        MeshVC vc = new MeshVC();
        try
        {
            JSONObject object = new JSONObject(data);
            vc.setId(object.getInt(MeshVC.TAG_ID));
            vc.setCategory_id(object.getInt(MeshVC.TAG_CAT_ID));
            vc.setEstablishment_name(object.getString(MeshVC.TAG_E_NAME));
            vc.setLatitude(object.getDouble(MeshVC.TAG_LAT));
            vc.setLongitude(object.getDouble(MeshVC.TAG_LONG));
            vc.setEstablishment_addr(object.getString(MeshVC.TAG_E_ADDRESS));
            vc.setContact_no(object.getString(MeshVC.TAG_CONTACT_NO));
            vc.setImg_url(object.getString(MeshVC.TAG_IMAGE_URL));
            vc.setQr_code(object.getString(MeshVC.TAG_QR_CODE_URL));
            vc.setRating(object.getDouble(MeshVC.TAG_RATING));
            vc.setEstablishment_route(object.getString(MeshVC.TAG_ROUTES));

            return vc;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //=============================================VCCategory=======================================
    /**
     * Parse data to a list of {@link MeshVCCategory MeshVCCategories}
     * @param data String data to be parsed
     * @return list of {@link MeshVCCategory MeshVCCategories}
     */
    static ArrayList<MeshVCCategory> parseVCCategories(String data)
    {
        ArrayList<MeshVCCategory> categories = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshVCCategory ch = parseVCCategory(array.getString(ctr));
                if(ch!=null)
                {
                    categories.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return categories;
    }
    /**
     * Parse data into a {@link MeshVCCategory MeshVCCategory}
     * @param data String data to be parsed
     * @return instance of {@link MeshVCCategory MeshVCCategory}
     */
    private static MeshVCCategory parseVCCategory(String data)
    {
        MeshVCCategory vcCategory = new MeshVCCategory();
        try
        {
            JSONObject object = new JSONObject(data);
            vcCategory.setId(object.getInt(MeshVCCategory.TAG_ID));
            vcCategory.setName(object.getString(MeshVCCategory.TAG_NAME));
            vcCategory.setDescription(object.getString(MeshVCCategory.TAG_DESCRIPTION));
            vcCategory.setImg_uri(object.getString(MeshVCCategory.TAG_IMG));
            vcCategory.setImg_preview(object.getString(MeshVCCategory.TAG_PREVIEW));


            return vcCategory;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================

    //=================================================VOD==========================================
    /**
     * Parse data to a list of {@link MeshVOD MeshVOD}s
     * @param data String data to be parsed
     * @return list of {@link MeshVOD MeshVOD}s
     */
    static ArrayList<MeshVOD> parseVODs(String data)
    {
        ArrayList<MeshVOD> vods = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshVOD ch = parseVOD(array.getString(ctr));
                if(ch!=null)
                {
                    vods.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return vods;
    }
    /**
     * Parse data into a {@link MeshVOD MeshVOD}
     * @param data String data to be parsed
     * @return instance of {@link MeshVOD MeshVOD}
     */
    private static MeshVOD parseVOD(String data)
    {
        MeshVOD vod = new MeshVOD();
        try
        {
            JSONObject object = new JSONObject(data);
            vod.setId(object.getInt(MeshVOD.TAG_ID));
            vod.setTitle(object.getString(MeshVOD.TAG_TITLE));
            vod.setTrailer(object.getString(MeshVOD.TAG_TRAILER));
            vod.setBought(object.getInt(MeshVOD.TAG_BOUGHT));
            vod.setFull(object.getString(MeshVOD.TAG_FULL));
            vod.setImg(object.getString(MeshVOD.TAG_IMG));
            vod.setLength(object.getInt(MeshVOD.TAG_LENGTH));
            vod.setPlot(object.getString(MeshVOD.TAG_PLOT));
            vod.setTag(object.getString(MeshVOD.TAG_GENRE));
            vod.setRating(object.getString(MeshVOD.TAG_RATING));
            vod.setPrice(Double.valueOf(object.optString(MeshVOD.TAG_PRICE)));
            return vod;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================

    //=================================================VOD==========================================
    /**
     * Parse data to a list of {@link MeshVODBought MeshVODBought}s
     * @param data String data to be parsed
     * @return list of {@link MeshVODBought MeshVODBought}s
     */
    static ArrayList<MeshVODBought> parseVODsBought(String data)
    {
        ArrayList<MeshVODBought> vods = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr = 0; ctr<array.length(); ctr++)
            {
                MeshVODBought ch = parseVODBought(array.getString(ctr));
                if(ch!=null)
                {
                    vods.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return vods;
    }
    /**
     * Parse data into a {@link MeshVODBought MeshVODBought}
     * @param data String data to be parsed
     * @return instance of {@link MeshVODBought MeshVODBought}
     */
    private static MeshVODBought parseVODBought(String data)
    {
        MeshVODBought vod = new MeshVODBought();
        try
        {
            JSONObject object = new JSONObject(data);
            vod.setId(object.getInt(MeshVODBought.TAG_ID));
            return vod;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //==============================================WeatherV2=======================================
    /**
     * Parse data into a {@link MeshWeatherV2 MeshWeatherV2}
     * @param data String data to be parsed
     * @return instance of {@link MeshWeatherV2 MeshWeatherV2}
     */
    static ArrayList<MeshWeatherV2> parseWeatherV2s(String data)
    {
        ArrayList<MeshWeatherV2> weatherV2s = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshWeatherV2 ch = parseWeatherV2(array.getString(ctr));
                if(ch!=null)
                {
                    weatherV2s.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return weatherV2s;
    }
    /**
     * Parse data into a {@link MeshWeatherV2 MeshWeatherV2}
     * @param data String data to be parsed
     * @return instance of {@link MeshWeatherV2 MeshWeatherV2}
     */
    private static MeshWeatherV2 parseWeatherV2(String data)
    {
        MeshWeatherV2 weatherV2 = new MeshWeatherV2();
        try
        {
            JSONObject object = new JSONObject(data);
            weatherV2.setId(object.getInt(MeshWeatherV2.TAG_ID));
            weatherV2.setLoc_id(object.getInt(MeshWeatherV2.TAG_LOC_ID));
            weatherV2.setLon(object.getInt(MeshWeatherV2.TAG_LON));
            weatherV2.setLat(object.getInt(MeshWeatherV2.TAG_LAT));
            weatherV2.setCountry(object.getString(MeshWeatherV2.TAG_COUNTRY));
            weatherV2.setLoc_name(object.getString(MeshWeatherV2.TAG_LOCATION));
            weatherV2.setSunrise(object.getLong(MeshWeatherV2.TAG_SUNRISE));
            weatherV2.setSunset(object.getLong(MeshWeatherV2.TAG_SUNSET));
            weatherV2.setDescription(object.getString(MeshWeatherV2.TAG_DESC));
            weatherV2.setIcon(object.getString(MeshWeatherV2.TAG_ICON));
            weatherV2.setTemp_cur(Float.valueOf(object.getString(MeshWeatherV2.TAG_TEMP_CUR)));
            weatherV2.setTemp_min(Float.valueOf(object.getString(MeshWeatherV2.TAG_TEMP_MIN)));
            weatherV2.setTemp_max(Float.valueOf(object.getString(MeshWeatherV2.TAG_TEMP_MAX)));
            weatherV2.setHumidity(Float.valueOf(object.getString(MeshWeatherV2.TAG_HUMIDITY)));
            weatherV2.setPressure(Float.valueOf(object.getString(MeshWeatherV2.TAG_PRESSURE)));
            weatherV2.setTimezone(Float.valueOf(object.getString(MeshWeatherV2.TAG_TIMEZONE)));
            weatherV2.setWind_speed(Float.valueOf(object.getString(MeshWeatherV2.TAG_WIND_SPEED)));


            return weatherV2;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //==============================================ReqItems=======================================
    /**
     * Parse data into a {@link MeshConciergeRequestItem MeshConciergeRequestItem}
     * @param data String data to be parsed
     * @return instance of {@link MeshConciergeRequestItem MeshConciergeRequestItem}
     */
    static ArrayList<MeshConciergeRequestItem> parseRequestItems(String data)
    {
        ArrayList<MeshConciergeRequestItem> items = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshConciergeRequestItem ch = parseRequestItem(array.getString(ctr));
                if(ch!=null)
                {
                    items.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return items;
    }
    /**
     * Parse data into a {@link MeshConciergeRequestItem MeshConciergeRequestItem}
     * @param data String data to be parsed
     * @return instance of {@link MeshConciergeRequestItem MeshConciergeRequestItem}
     */
    private static MeshConciergeRequestItem parseRequestItem(String data)
    {
        MeshConciergeRequestItem item = new MeshConciergeRequestItem();
        try
        {
            JSONObject object = new JSONObject(data);
            item.setId(object.getInt(MeshConciergeRequestItem.TAG_ID));
            item.setImg_uri(object.getString(MeshConciergeRequestItem.TAG_IMG_URI));
            if(object.has(MeshConciergeRequestItem.TAG_CATEGORY_ID))
            {
                item.setCategory_id(object.getInt(MeshConciergeRequestItem.TAG_CATEGORY_ID));
            }

            item.setItem_description(object.getString(MeshConciergeRequestItem.TAG_DESC));
            item.setItem_name(object.getString(MeshConciergeRequestItem.TAG_ITEM_NAME));
            if(object.has(MeshConciergeRequestItem.TAG_UNIT_PRICE))
            {
                item.setUnit_price(Double.valueOf(object.getString(MeshConciergeRequestItem.TAG_UNIT_PRICE)));
            }


            return item;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================
    //==============================================ReqItems=======================================
    /**
     * Parse data into a {@link MeshConciergeRequestService MeshConciergeRequestService}
     * @param data String data to be parsed
     * @return instance of {@link MeshConciergeRequestService MeshConciergeRequestService}
     */
    static ArrayList<MeshConciergeRequestService> parseRequestServices(String data)
    {
        ArrayList<MeshConciergeRequestService> services = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshConciergeRequestService ch = parseRequestService(array.getString(ctr));
                if(ch!=null)
                {
                    services.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return services;
    }
    /**
     * Parse data into a {@link MeshConciergeRequestService MeshConciergeRequestService}
     * @param data String data to be parsed
     * @return instance of {@link MeshConciergeRequestService MeshConciergeRequestService}
     */
    private static MeshConciergeRequestService parseRequestService(String data)
    {
        MeshConciergeRequestService service = new MeshConciergeRequestService();
        try
        {
            JSONObject object = new JSONObject(data);
            service.setId(object.getInt(MeshConciergeRequestService.TAG_ID));
            service.setImg_uri(object.getString(MeshConciergeRequestService.TAG_IMG_URI));
            if(object.has(MeshConciergeRequestService.TAG_CATEGORY_ID))
            {
                service.setCategory_id(object.getInt(MeshConciergeRequestService.TAG_CATEGORY_ID));
            }

            service.setItem_description(object.getString(MeshConciergeRequestService.TAG_DESC));
            service.setItem_name(object.getString(MeshConciergeRequestService.TAG_ITEM_NAME));
            if(object.has(MeshConciergeRequestService.TAG_UNIT_PRICE))
            {
                service.setUnit_price(Double.valueOf(object.getString(MeshConciergeRequestService.TAG_UNIT_PRICE)));
            }


            return service;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //==============================================================================================

    //=============================================v 2.0============================================
    //------------------------------------------MeshPackage-----------------------------------------
    /**
     * Parse data into a {@link MeshPackage MeshPackage}
     * @param data String data to be parsed
     * @return instance of {@link MeshPackage MeshPackage}
     */
    static ArrayList<MeshPackage> parsePackages(String data)
    {
        ArrayList<MeshPackage> packages = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshPackage ch = parsePackage(array.getString(ctr));
                if(ch!=null)
                {
                    packages.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return packages;
    }
    /**
     * Parse data into a {@link MeshPackage MeshPackage}
     * @param data String data to be parsed
     * @return instance of {@link MeshPackage MeshPackage}
     */
    private static MeshPackage parsePackage(String data)
    {
        MeshPackage pack = new MeshPackage();
        try
        {
            JSONObject object = new JSONObject(data);
            pack.setId(object.getInt(MeshPackage.TAG_ID));
            pack.setName(object.getString(MeshPackage.TAG_NAME));
            pack.setDate(object.getString(MeshPackage.TAG_DATE));
            pack.setDescription(object.getString(MeshPackage.TAG_DESC));
            pack.setCost(object.getDouble(MeshPackage.TAG_COST));
            pack.setMode(object.getInt(MeshPackage.TAG_MODE));
            return pack;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------MeshPackageChannel--------------------------------------
    /**
     * Parse data into a {@link MeshPackageChannel MeshPackageChannel}
     * @param data String data to be parsed
     * @return instance of {@link MeshPackageChannel MeshPackageChannel}
     */
    static ArrayList<MeshPackageChannel> parsePackageChannels(String data)
    {
        ArrayList<MeshPackageChannel> packages = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshPackageChannel ch = parsePackageChannel(array.getString(ctr));
                if(ch!=null)
                {
                    packages.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return packages;
    }
    /**
     * Parse data into a {@link MeshPackageChannel MeshPackageChannel}
     * @param data String data to be parsed
     * @return instance of {@link MeshPackageChannel MeshPackageChannel}
     */
    private static MeshPackageChannel parsePackageChannel(String data)
    {
        MeshPackageChannel packageChannel = new MeshPackageChannel();
        try
        {
            JSONObject object = new JSONObject(data);
            packageChannel.setId(object.getInt(MeshPackageChannel.TAG_ID));
            packageChannel.setPackage_id(object.getInt(MeshPackageChannel.TAG_PACKAGE_ID));
            packageChannel.setChannel_id(object.getInt(MeshPackageChannel.TAG_CHANNEL_ID));
            return packageChannel;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------

    //---------------------------------------MeshSubscription---------------------------------------
    /**
     * Parse data into a {@link MeshSubscription MeshSubscription}
     * @param data String data to be parsed
     * @return instance of {@link MeshSubscription MeshSubscription}
     */
    static ArrayList<MeshSubscription> parseSubscriptions(String data)
    {
        ArrayList<MeshSubscription> packages = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshSubscription ch = parseSubscription(array.getString(ctr));
                if(ch!=null)
                {
                    packages.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return packages;
    }
    /**
     * Parse data into a {@link MeshSubscription MeshSubscription}
     * @param data String data to be parsed
     * @return instance of {@link MeshSubscription MeshSubscription}
     */
    private static MeshSubscription parseSubscription(String data)
    {
        MeshSubscription pack = new MeshSubscription();
        try
        {
            JSONObject object = new JSONObject(data);
            pack.setId(object.getInt(MeshSubscription.TAG_ID));
            pack.setCustomer_id(object.getString(MeshSubscription.TAG_CUSTOMER_ID));
            pack.setPackage_id(object.getInt(MeshSubscription.TAG_PACKAGE_ID));
            return pack;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------

    //----------------------------------------MeshSubscriber----------------------------------------
    /**
     * Parse data into a {@link MeshSubscriber MeshSubscriber}
     * @param data String data to be parsed
     * @return instance of {@link MeshSubscriber MeshSubscriber}
     */
    @Deprecated
    static ArrayList<MeshSubscriber> parseSubscribers(String data)
    {
        ArrayList<MeshSubscriber> packages = new ArrayList<>();
        try
        {

            JSONObject object = new JSONObject(data);
            if(!object.has(MeshSubscriber.TAG_ACCOUNT_ID))
            {
                object = new JSONObject(object.getString("data"));
            }
            Log.i(TAG,"Parsing:"+object);
            MeshSubscriber pack = new MeshSubscriber();
            pack.setAccount_id(object.getString(MeshSubscriber.TAG_ACCOUNT_ID));
            pack.setTitle(object.getString(MeshSubscriber.TAG_TITLE));
            pack.setLastname(object.getString(MeshSubscriber.TAG_LASTNAME));
            pack.setFirstname(object.getString(MeshSubscriber.TAG_FIRSTNAME));
            pack.setMiddlename(object.getString(MeshSubscriber.TAG_MIDDLENAME));
            pack.setContact_no(object.getString(MeshSubscriber.TAG_CONTACT_NO));
            pack.setMobile_no(object.getString(MeshSubscriber.TAG_MOBILE_NO));
            pack.setEmail(object.getString(MeshSubscriber.TAG_EMAIL));
            pack.setHouse_no(object.getString(MeshSubscriber.TAG_HOUSE_NO));
            pack.setSubdivision(object.getString(MeshSubscriber.TAG_SUBDIVISION));
            pack.setBarangay(object.getString(MeshSubscriber.TAG_BARANGAY));
            pack.setCity(object.getString(MeshSubscriber.TAG_CITY));
            pack.setCountry_code(object.getString(MeshSubscriber.TAG_COUNTRY_CODE));
            pack.setPostal_code(object.getString(MeshSubscriber.TAG_POSTAL_CODE));
            pack.setStatus(object.getInt(MeshSubscriber.TAG_STATUS));
            packages.add(pack);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return packages;
    }
    /**
     * Parse data into a {@link MeshSubscription MeshSubscription}
     * @param data String data to be parsed
     * @return instance of {@link MeshSubscription MeshSubscription}
     */
    @Deprecated
    private static MeshSubscriber parseSubscriber(String data)
    {
        MeshSubscriber pack = new MeshSubscriber();
        try
        {
            JSONObject object = new JSONObject(data);
            pack.setAccount_id(object.getString(MeshSubscriber.TAG_ACCOUNT_ID));
            pack.setTitle(object.getString(MeshSubscriber.TAG_TITLE));
            pack.setLastname(object.getString(MeshSubscriber.TAG_LASTNAME));
            pack.setFirstname(object.getString(MeshSubscriber.TAG_FIRSTNAME));
            pack.setMiddlename(object.getString(MeshSubscriber.TAG_MIDDLENAME));
            pack.setContact_no(object.getString(MeshSubscriber.TAG_CONTACT_NO));
            pack.setMobile_no(object.getString(MeshSubscriber.TAG_MOBILE_NO));
            pack.setEmail(object.getString(MeshSubscriber.TAG_EMAIL));
            pack.setHouse_no(object.getString(MeshSubscriber.TAG_HOUSE_NO));
            pack.setSubdivision(object.getString(MeshSubscriber.TAG_SUBDIVISION));
            pack.setBarangay(object.getString(MeshSubscriber.TAG_BARANGAY));
            pack.setCity(object.getString(MeshSubscriber.TAG_CITY));
            pack.setCountry_code(object.getString(MeshSubscriber.TAG_COUNTRY_CODE));
            pack.setPostal_code(object.getString(MeshSubscriber.TAG_POSTAL_CODE));
            pack.setStatus(object.getInt(MeshSubscriber.TAG_STATUS));
            return pack;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------MeshEPG-------------------------------------------
    /**
     * Parse data into a {@link MeshPackageChannel MeshPackageChannel}
     * @param data String data to be parsed
     * @return instance of {@link MeshPackageChannel MeshPackageChannel}
     */
    static ArrayList<MeshEPG> parseEPGs(String data)
    {
        ArrayList<MeshEPG> epgs = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshEPG ch = parseEPG(array.getString(ctr));
                if(ch!=null)
                {
                    epgs.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return epgs;
    }
    /**
     * Parse data into a {@link MeshPackageChannel MeshPackageChannel}
     * @param data String data to be parsed
     * @return instance of {@link MeshPackageChannel MeshPackageChannel}
     */
    private static MeshEPG parseEPG(String data)
    {
        MeshEPG epg = new MeshEPG();
        try
        {
            JSONObject object = new JSONObject(data);
            epg.setId(object.getInt(MeshEPG.TAG_ID));
            epg.setChannel_id(object.getInt(MeshEPG.TAG_CHANNEL_ID));
            epg.setProgram_name(object.getString(MeshEPG.TAG_PROGRAM_NAME));
            epg.setProgram_description(object.getString(MeshEPG.TAG_PROGRAM_DESCRIPTION));
            epg.setProgram_image(object.getString(MeshEPG.TAG_PROGRAM_IMAGE));
            epg.setStart(object.getString(MeshEPG.TAG_START));
            epg.setEnd(object.getString(MeshEPG.TAG_END));
            epg.setDay_no(object.getInt(MeshEPG.TAG_DAY));
            epg.setEnabled(object.getInt(MeshEPG.TAG_ENABLED));
            return epg;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------MeshTelecomBill---------------------------------------
    /**
     * Parse data into a {@link MeshTelecomBill MeshTelecomBill}
     * @param data String data to be parsed
     * @return instance of {@link MeshTelecomBill MeshTelecomBill}
     */
    static ArrayList<MeshTelecomBill> parseTeleBills(String data)
    {
        ArrayList<MeshTelecomBill> bills = new ArrayList<>();
        try
        {
            JSONObject object = new JSONObject(data);
            JSONArray array = new JSONArray(object.getString("data"));
            for(int ctr=0;ctr<array.length();ctr++)
            {
                MeshTelecomBill ch = parseTeleBill(array.getString(ctr));
                if(ch!=null)
                {
                    bills.add(ch);
                }
                else
                {
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return bills;
    }
    /**
     * Parse data into a {@link MeshTelecomBill MeshTelecomBill}
     * @param data String data to be parsed
     * @return instance of {@link MeshTelecomBill MeshTelecomBill}
     */
    private static MeshTelecomBill parseTeleBill(String data)
    {
        MeshTelecomBill bill = new MeshTelecomBill();
        try
        {
            JSONObject object = new JSONObject(data);
            bill.setBill_id(object.getInt(MeshTelecomBill.TAG_ID));
            bill.setAccount_number(object.getString(MeshTelecomBill.TAG_ACCOUNT_NO));
            bill.setAccount_name(object.getString(MeshTelecomBill.TAG_ACCOUNT_NAME));
            bill.setAddress(object.getString(MeshTelecomBill.TAG_ADDRESS));
            bill.setBalance(object.getDouble(MeshTelecomBill.TAG_BALANCE));
            bill.setOutlet_fee(object.getDouble(MeshTelecomBill.TAG_OUTLET_FEE));
            bill.setMaintenance_fee(object.getDouble(MeshTelecomBill.TAG_MAINTENANCE_FEE));
            bill.setSubscription_fee(object.getDouble(MeshTelecomBill.TAG_SUBSCRIPTION_FEE));
            bill.setInternet_fee(object.getDouble(MeshTelecomBill.TAG_INTERNET_FEE));
            bill.setPhone_fee(object.getDouble(MeshTelecomBill.TAG_PHONE_FEE));
            bill.setBandwidth_fee(object.getDouble(MeshTelecomBill.TAG_BANDWIDTH_FEE));
            bill.setBilling_start(object.getString(MeshTelecomBill.TAG_BILL_START));
            bill.setBilling_end(object.getString(MeshTelecomBill.TAG_BILL_END));
            bill.setPayment_received(object.getDouble(MeshTelecomBill.TAG_PAYMENT));
            bill.setYear(object.getInt(MeshTelecomBill.TAG_YEAR));
            bill.setPackage_list(object.getString(MeshTelecomBill.TAG_PACKAGELIST));
            bill.setAnnouncement(object.getString(MeshTelecomBill.TAG_ANNOUNCEMENT));
            return bill;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------

    //-----------------------------------------MeshSignage------------------------------------------

    /**
     * Parse data into {@link MeshSignage MeshSignage}
     * @param data String to be parsed
     * @return instance of {@link MeshSignage }
     */
    private static MeshSignage parseSignage(String data)
    {
        try
        {
            MeshSignage signage = new MeshSignage();
            JSONObject object     = new JSONObject(data);
            signage.setId(object.getInt(MeshSignage.TAG_ID));
            signage.setCompanyId(object.getInt(MeshSignage.TAG_COMPANY_ID));
            signage.setCounter(object.getInt(MeshSignage.TAG_COUNTER));
            signage.setRuntime(object.getInt(MeshSignage.TAG_RUNTIME));
            signage.setSchedule_start(object.getString(MeshSignage.TAG_SCHEDULE_START));
            signage.setSchedule_end(object.getString(MeshSignage.TAG_SCHEDULE_END));
            signage.setMedia(object.getString(MeshSignage.TAG_MEDIA));
            signage.setFileType(object.getString(MeshSignage.TAG_FILETYPE));
            signage.setSystemMedia(object.getBoolean(MeshSignage.TAG_ISSYSTEMMEDIA));
            signage.setDescription(object.getString(MeshSignage.TAG_DESCRIPTION));
            signage.setDisplay_name(object.optString(MeshSignage.TAG_DISPLAY_NAME));
            return signage;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Parse data into a {@link MeshSignage MeshSignage}
     * @param data String data to be parsed
     * @return instance of {@link MeshSignage MeshSignage}
     */
    static   ArrayList<MeshSignage> parseSignages(String data)
    {
        try {
            ArrayList<MeshSignage> signages = new ArrayList<>();
            JSONObject object = new JSONObject(data);
            JSONArray  array = new JSONArray(object.getString("data"));
            for(int x=0;x<array.length();x++)
            {
                MeshSignage signage=parseSignage(array.getString(x));
                if(signage!=null)
                {
                    signages.add(signage);
                }
                else
                {
                    return null;
                }
            }
            return signages;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------

    //-----------------------------------------MeshCompany------------------------------------------
    /**
     * Parse data into {@link MeshCompany MeshCompany}
     * @param data String to be parsed
     * @return instance of {@link MeshCompany }
     */
    private static MeshCompany parseCompany(String data)
    {
        try
        {
            MeshCompany company=new MeshCompany();
            JSONObject  object = new JSONObject(data);
            company.setId(object.getInt(MeshCompany.TAG_ID));
            company.setCompanyName(object.getString(MeshCompany.TAG_COMPANY_NAME));
            company.setCompanyAddress(object.getString(MeshCompany.TAG_COMPANY_ADDRESS));
            company.setCompanyContact(object.getString(MeshCompany.TAG_CONTACT));
            company.setDiscount(object.getDouble(MeshCompany.TAG_DISCOUNT));
            return company;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Parse data into a {@link MeshCompany MeshCompany}
     * @param data String data to be parsed
     * @return instance of {@link MeshCompany MeshCompany}
     */
    static ArrayList<MeshCompany> parseCompanies(String data)
    {
        try
        {
          ArrayList<MeshCompany> companies=new ArrayList<>();
          JSONObject  object = new JSONObject(data);
          JSONArray   array  = new JSONArray(object.getString("data"));
            for(int x=0;x<array.length();x++)
            {
                MeshCompany company=parseCompany(array.getString(x));
                if(company!=null)
                {
                    companies.add(company);
                }
                else
                {
                    return null;
                }
            }
            return companies;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------MeshLayout-------------------------------------------

    private static MeshLayout parseLayout(String data)
    {
        try
        {
            MeshLayout layout=new MeshLayout();
            JSONObject  object = new JSONObject(data);
            layout.setId(object.getInt(MeshLayout.TAG_ID));
            return layout;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static ArrayList<MeshLayout> parseLayouts(String data)
    {
        try
        {
            ArrayList<MeshLayout> layouts=new ArrayList<>();
            JSONObject  object = new JSONObject(data);
            JSONArray   array  = new JSONArray(object.getString("data"));
            for(int x=0;x<array.length();x++)
            {
                MeshLayout layout=parseLayout(array.getString(x));
                if(layout!=null)
                {
                    layouts.add(layout);
                }
                else
                {
                    return null;
                }
            }
            return layouts;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------MeshSchedule-------------------------------------------

    private static MeshSchedule parseSchedule(String data)
    {
        try
        {
            MeshSchedule schedule=new MeshSchedule();
            JSONObject  object = new JSONObject(data);
            schedule.setId(object.getInt(MeshSchedule.TAG_ID));
            schedule.setDefault_timeout(object.getInt(MeshSchedule.TAG_DEF_TIMEOUT));
            schedule.setEnd(object.getString(MeshSchedule.TAG_END));
            schedule.setStart(object.getString(MeshSchedule.TAG_START));
            schedule.setLayout_id(object.getInt(MeshSchedule.TAG_LAYOUT_ID));
            return schedule;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static ArrayList<MeshSchedule> parseSchedules(String data)
    {
        try
        {
            ArrayList<MeshSchedule> schedules=new ArrayList<>();
            JSONObject  object = new JSONObject(data);
            JSONArray   array  = new JSONArray(object.getString("data"));
            for(int x=0;x<array.length();x++)
            {
                MeshSchedule schedule=parseSchedule(array.getString(x));
                if(schedule!=null)
                {
                    schedules.add(schedule);
                }
                else
                {
                    return null;
                }
            }
            return schedules;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------MeshSignageSchedule-------------------------------------------

    private static MeshSignageSchedule parseSignageSchedule(String data)
    {
        try
        {
            MeshSignageSchedule ss=new MeshSignageSchedule();
            JSONObject  object = new JSONObject(data);
            ss.setId(object.getInt(MeshSchedule.TAG_ID));
            ss.setSchedule_id(object.getInt(MeshSignageSchedule.TAG_SCHEDULE_ID));
            ss.setSignage_id(object.getInt(MeshSignageSchedule.TAG_SIGNAGE_ID));
            return ss;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static ArrayList<MeshSignageSchedule> parseSignageSchedules(String data)
    {
        try
        {
            ArrayList<MeshSignageSchedule> schedules=new ArrayList<>();
            JSONObject  object = new JSONObject(data);
            JSONArray   array  = new JSONArray(object.getString("data"));
            for(int x=0;x<array.length();x++)
            {
                MeshSignageSchedule signageSchedule=parseSignageSchedule(array.getString(x));
                if(signageSchedule!=null)
                {
                    schedules.add(signageSchedule);
                }
                else
                {
                    return null;
                }
            }
            return schedules;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------

    //==============================================================================================
    //======================================MeshDigitalSignageV2====================================
    //---------------------------------------MeshSignageSchedule------------------------------------

    private static MeshLayoutV2 parseMeshLayoutV2(String data)
    {
        try
        {
            MeshLayoutV2 ss=new MeshLayoutV2();
            JSONObject  object = new JSONObject(data);
            ss.setId(object.getInt(MeshLayoutV2.TAG_ID));
            ss.setName(object.getString(MeshLayoutV2.TAG_LAYOUT));
            ss.setZones(object.getInt(MeshLayoutV2.TAG_ZONE));
            ss.setPreview_url(object.getString(MeshLayoutV2.TAG_PREVIEW_URL));
            return ss;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static ArrayList<MeshLayoutV2> parseMeshLayoutV2s(String data)
    {
        try
        {
            ArrayList<MeshLayoutV2> schedules=new ArrayList<>();
            JSONObject  object = new JSONObject(data);
            JSONArray   array  = new JSONArray(object.getString("data"));
            for(int x=0;x<array.length();x++)
            {
                MeshLayoutV2 signageSchedule=parseMeshLayoutV2(array.getString(x));
                if(signageSchedule!=null)
                {
                    schedules.add(signageSchedule);
                }
                else
                {
                    return null;
                }
            }
            return schedules;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------MeshMediaV2----------------------------------------

    private static MeshMediaV2 parseMediaV2(String data)
    {
        try
        {
            MeshMediaV2 ss=new MeshMediaV2();
            JSONObject  object = new JSONObject(data);
            ss.setId(object.getInt(MeshMediaV2.TAG_ID));
            ss.setType_id(object.getInt(MeshMediaV2.TAG_TYPE_ID));
            ss.setUrl(object.getString(MeshMediaV2.TAG_URL));
            ss.setName(object.getString(MeshMediaV2.TAG_NAME));
            ss.setLayout_id(object.getInt(MeshMediaV2.TAG_LAYOUT_ID));
            ss.setOrientation(object.getInt(MeshMediaV2.TAG_ORIENTATION));
            ss.setGroup_id(object.getInt(MeshMediaV2.TAG_GROUP_ID));

            return ss;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static ArrayList<MeshMediaV2> parseMediaV2s(String data)
    {
        try
        {
            ArrayList<MeshMediaV2> schedules=new ArrayList<>();
            JSONObject  object = new JSONObject(data);
            JSONArray   array  = new JSONArray(object.getString("data"));
            for(int x=0;x<array.length();x++)
            {
                MeshMediaV2 signageSchedule=parseMediaV2(array.getString(x));
                if(signageSchedule!=null)
                {
                    schedules.add(signageSchedule);
                }
                else
                {
                    return null;
                }
            }
            return schedules;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------MeshMediaZone---------------------------------------

    private static MeshMediaZone parseMediaZone(String data)
    {
        try
        {
            MeshMediaZone ss=new MeshMediaZone();
            JSONObject  object = new JSONObject(data);
            ss.setId(object.getInt(MeshMediaZone.TAG_ID));
            ss.setMedia_id(object.getInt(MeshMediaZone.TAG_MEDIA_ID));
            ss.setZone_id(object.getInt(MeshMediaZone.TAG_ZONE_ID));
            ss.setSignage_id(object.getInt(MeshMediaZone.TAG_SIGNAGE_ID));
            ss.setTime(object.getInt(MeshMediaZone.TAG_TIME));
            return ss;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static ArrayList<MeshMediaZone> parseMediaZones(String data)
    {
        try
        {
            ArrayList<MeshMediaZone> schedules=new ArrayList<>();
            JSONObject  object = new JSONObject(data);
            JSONArray   array  = new JSONArray(object.getString("data"));
            for(int x=0;x<array.length();x++)
            {
                MeshMediaZone signageSchedule=parseMediaZone(array.getString(x));
                if(signageSchedule!=null)
                {
                    schedules.add(signageSchedule);
                }
                else
                {
                    return null;
                }
            }
            return schedules;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------MeshMediaZoneAssignment----------------------------------
    private static MeshMediaZoneAssignment parseMediaZoneAssignment(String data)
    {
        try
        {
            MeshMediaZoneAssignment ss=new MeshMediaZoneAssignment();
            JSONObject  object = new JSONObject(data);
            ss.setId(object.getInt(MeshMediaZoneAssignment.TAG_ID));
            ss.setLayout_id(object.getInt(MeshMediaZoneAssignment.TAG_LAYOUT_ID));
            ss.setSignage_id(object.getInt(MeshMediaZoneAssignment.TAG_SIGNAGE_ID));
            ss.setZone(object.getInt(MeshMediaZoneAssignment.TAG_ZONE));
            return ss;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    static ArrayList<MeshMediaZoneAssignment> parseMediaZoneAssignments(String data)
    {
        try
        {
            ArrayList<MeshMediaZoneAssignment> schedules=new ArrayList<>();
            JSONObject  object = new JSONObject(data);
            JSONArray   array  = new JSONArray(object.getString("data"));
            for(int x=0;x<array.length();x++)
            {
                MeshMediaZoneAssignment signageSchedule=parseMediaZoneAssignment(array.getString(x));
                if(signageSchedule!=null)
                {
                    schedules.add(signageSchedule);
                }
                else
                {
                    return null;
                }
            }
            return schedules;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------MeshSignageV2---------------------------------------

    private static MeshSignageV2 parseSignageV2(String data)
    {
        try
        {
            MeshSignageV2 ss=new MeshSignageV2();
            JSONObject  object = new JSONObject(data);
            ss.setId(object.getInt(MeshSignageV2.TAG_ID));
            ss.setLayout_id(object.getInt(MeshSignageV2.TAG_LAYOUT_ID));
            ss.setBackground(object.getString(MeshSignageV2.TAG_BACKGROUND));
            ss.setOrientation(object.getInt(MeshSignageV2.TAG_ORIENTATION));
            return ss;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static ArrayList<MeshSignageV2> parseSignageV2s(String data)
    {
        try
        {
            ArrayList<MeshSignageV2> schedules=new ArrayList<>();
            JSONObject  object = new JSONObject(data);
            JSONArray   array  = new JSONArray(object.getString("data"));
            for(int x=0;x<array.length();x++)
            {
                MeshSignageV2 signageSchedule=parseSignageV2(array.getString(x));
                if(signageSchedule!=null)
                {
                    schedules.add(signageSchedule);
                }
                else
                {
                    return null;
                }
            }
            return schedules;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------MeshType-----------------------------------------

    private static MeshType parseType(String data)
    {
        try
        {
            MeshType ss=new MeshType();
            JSONObject  object = new JSONObject(data);
            ss.setId(object.getInt(MeshType.TAG_ID));
            ss.setName(object.getString(MeshType.TAG_NAME));
            ss.setDescription(object.getString(MeshType.TAG_DESCRIPTION));
            return ss;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static ArrayList<MeshType> parseTypes(String data)
    {
        try
        {
            ArrayList<MeshType> schedules=new ArrayList<>();
            JSONObject  object = new JSONObject(data);
            JSONArray   array  = new JSONArray(object.getString("data"));
            for(int x=0;x<array.length();x++)
            {
                MeshType signageSchedule=parseType(array.getString(x));
                if(signageSchedule!=null)
                {
                    schedules.add(signageSchedule);
                }
                else
                {
                    return null;
                }
            }
            return schedules;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------MeshScrollingMessage-------------------------------------
    private static MeshScrollingMessage parseScrollingMessage(String data)
    {
        try
        {
            MeshScrollingMessage ss=new MeshScrollingMessage();
            JSONObject  object = new JSONObject(data);
            ss.setId(object.getInt(MeshScrollingMessage.TAG_ID));
            ss.setZone(object.getInt(MeshScrollingMessage.TAG_ZONE));
            ss.setSignage_id(object.getInt(MeshScrollingMessage.TAG_SIGNAGE_ID));
            ss.setTime(object.getInt(MeshScrollingMessage.TAG_TIME));
            ss.setMessage(object.getString(MeshScrollingMessage.TAG_MESSAGE));
            return ss;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static ArrayList<MeshScrollingMessage> parseScrollingMessages(String data)
    {
        try
        {
            ArrayList<MeshScrollingMessage> schedules=new ArrayList<>();
            JSONObject  object = new JSONObject(data);
            JSONArray   array  = new JSONArray(object.getString("data"));
            for(int x=0;x<array.length();x++)
            {
                MeshScrollingMessage signageSchedule=parseScrollingMessage(array.getString(x));
                if(signageSchedule!=null)
                {
                    schedules.add(signageSchedule);
                }
                else
                {
                    return null;
                }
            }
            return schedules;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------MeshFeed-------------------------------------------
    private static MeshTVFeed parseFeed(String data)
    {
        try
        {
            MeshTVFeed ss=new MeshTVFeed();
            JSONObject  object = new JSONObject(data);
            ss.setId(object.getInt(MeshTVFeed.TAG_ID));
            ss.setSignage_id(object.getInt(MeshTVFeed.TAG_SIGNAGE_ID));
            ss.setGroup_id(object.getInt(MeshTVFeed.TAG_GROUP_ID));
            ss.setGroup_order(object.getInt(MeshTVFeed.TAG_GROUP_ORDER));
            ss.setSource(object.getString(MeshTVFeed.TAG_SOURCE));
            ss.setTitle(object.getString(MeshTVFeed.TAG_TITLE));
            ss.setDescription(object.getString(MeshTVFeed.TAG_DESCRIPTION));
            ss.setSchedule(object.getString(MeshTVFeed.TAG_SCHEDULE));
            ss.setImage(object.getString(MeshTVFeed.TAG_IMAGE));
            ss.setOwner(object.getString(MeshTVFeed.TAG_OWNER));
            ss.setLocation(object.getString(MeshTVFeed.TAG_LOCATION));
            return ss;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static ArrayList<MeshTVFeed> parseFeeds(String data)
    {
        try
        {
            ArrayList<MeshTVFeed> schedules=new ArrayList<>();
            JSONObject  object = new JSONObject(data);
            JSONArray   array  = new JSONArray(object.getString("data"));
            for(int x=0;x<array.length();x++)
            {
                MeshTVFeed signageSchedule=parseFeed(array.getString(x));
                if(signageSchedule!=null)
                {
                    schedules.add(signageSchedule);
                }
                else
                {
                    return null;
                }
            }
            return schedules;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================


}
