package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Parser;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util.MeshRawReader;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;
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
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshEpisode;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStream;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStreamCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStreamTag;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Tag.MeshTag;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshDirection;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshRouteCoords;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshGenre;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecastDay;
import com.ph.bittelasia.meshtv.tv.mtvlib.TestInterface.MeshAPITester;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MeshParserTest
{
    //=========================================Variable=============================================
    //-----------------------------------------Instance---------------------------------------------
    Context context = null;
    MeshTVApp app = null;
    @Rule
    public ActivityTestRule<MeshAPITester> activityTestRule  = new ActivityTestRule<MeshAPITester>(MeshAPITester.class);
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================LifeCycle============================================
    @Before
    public void setUp() throws Exception {
        context = InstrumentationRegistry.getContext();
        app = (MeshTVApp) activityTestRule.getActivity().getApplicationContext();

    }
    //==============================================================================================
    //===========================================Test===============================================
    @Test
    public void testAirports() throws Exception
    {
        ArrayList<MeshAirport> airports = MeshParser.parseAirports(MeshRawReader.read(R.raw.get_airport_name));
        assertEquals(1,airports.size());
        MeshAirport airport = airports.get(0);
        assertEquals(504,airport.getId());
        assertEquals("RGN",airport.getFs());
        assertEquals("RGN",airport.getIata());
        assertEquals("VYYY",airport.getIcao());
        assertEquals("Yangon International Airport",airport.getName());
        assertEquals("Mingaladon",airport.getCity());
        assertEquals("RGN",airport.getCitycode());
        assertEquals("MM",airport.getCountrycode());
        assertEquals("Myanmar",airport.getCountryname());
        assertEquals("Asia",airport.getRegionname());
        assertEquals(16.900101,airport.getLatitude(),airport.getLatitude());
        assertEquals(96.134201,airport.getLongitude(),airport.getLongitude());
        assertEquals(1,airport.getActive());
        assertEquals(2,airport.getClassification());

    }
    @Test
    public void testArrivalFlights() throws Exception
    {
        ArrayList<MeshArrivalFlight> flights = MeshParser.parseArrivalFlights(MeshRawReader.read(R.raw.get_arrival_flights));
        assertEquals(2,flights.size());
        MeshArrivalFlight flight = flights.get(0);
        assertEquals("2015-01-28 17:37:00",flight.getArrival_datetime());
        assertNotNull(flight.getArrivalDate());
        assertEquals("KLM",flight.getCarrier());
        assertEquals("847",flight.getFlight_number());
        assertEquals("0",flight.getMin_off());
        assertEquals("On-Time",flight.getOntime_status());
        assertEquals("Montreal",flight.getOrigin());
        assertEquals("Enroute",flight.getStatus());

    }
    @Test
    public void testChannel() throws Exception
    {
        ArrayList<MeshChannel> channels = MeshParser.parseChannels(MeshRawReader.read(R.raw.get_all_tv_channel));
        assertEquals(33,channels.size());
        MeshChannel channel = channels.get(0);
        assertEquals(1,channel.getId());
        assertEquals("CNN",channel.getChannel_title());
        assertEquals("CNN",channel.getChannel_description());
        assertEquals(1,channel.getChannel_category_id());
        assertEquals("udp://@239.255.0.2:1234",channel.getChannel_uri());
        assertEquals("images/tvs/2435a45b85628172c5a47122144a7c67.jpg",channel.getChannel_image());

    }
    @Test
    public void testChannelCategory() throws Exception
    {
        ArrayList<MeshChannelCategory> categories = MeshParser.parseChannelCategories(MeshRawReader.read(R.raw.get_tv_channel_category));
        assertEquals(6,categories.size());
        MeshChannelCategory cat = categories.get(0);
        assertEquals(1,cat.getId());
        assertEquals("News",cat.getCategory_name());
        assertEquals("News",cat.getCategory_description());
    }
    @Test
    public void testCity() throws Exception
    {
        ArrayList<MeshCity> cities = MeshParser.parseCities(MeshRawReader.read(R.raw.search_city));
        assertEquals(193,cities.size());
        MeshCity city = cities.get(0);
        assertEquals(2240449,city.getId());
        assertEquals("Angola",city.getCntry());
        assertEquals("AO",city.getCntry_code());
        assertEquals("aot",city.getCode());
        assertEquals("1",city.getTzone());
        assertEquals("Luanda",city.getName());
    }
    @Test
    public void testContinent() throws Exception
    {
        ArrayList<MeshContinent> continents = MeshParser.parseContinents(MeshRawReader.read(R.raw.get_continents));
        assertEquals(6,continents.size());
        MeshContinent continent = continents.get(0);
        assertEquals(1,continent.getId());
        assertEquals("Africa",continent.getName());
    }
    @Test
    public void testConciergeCategories() throws Exception
    {
        ArrayList<MeshConciergeCategory> categories = MeshParser.parseConciergeCategories(MeshRawReader.read(R.raw.get_concierge_category));
        assertEquals(2,categories.size());
        MeshConciergeCategory category = categories.get(0);
        assertEquals(0,category.getId());
        assertEquals("NA",category.getCategory_image());
        assertEquals("Services",category.getCategory_name());
        assertEquals("All",category.getCategory_description());
    }
    @Test
    public void testDepartureFlight() throws Exception
    {
        ArrayList<MeshDepartureFlight> flights = MeshParser.parseDepartureFlights(MeshRawReader.read(R.raw.get_departure_flights));
        assertEquals(4,flights.size());
        MeshDepartureFlight flight = flights.get(1);
        assertEquals("Delta Airlines",flight.getCarrier());
        assertEquals( "2015-01-28 14:40:00",flight.getDeparture_datetime());
        assertEquals("Montreal",flight.getDestination());
        assertEquals("125",flight.getFlight_number());
        assertEquals("5",flight.getMin_off());
        assertEquals("Late",flight.getOntime_status());
        assertEquals("Enroute",flight.getStatus());
        assertNotNull(flight.getDepartureDate());
    }
    @Test
    public void testTags() throws Exception
    {
        ArrayList<MeshTag> tags = MeshParser.parseTags(MeshRawReader.read(R.raw.get_extras));
        assertEquals(10,tags.size());
        MeshTag tag = tags.get(0);
        assertEquals(1,tag.getId());
        assertEquals(1,tag.getParentID());
        assertEquals("MeshFoodItem",tag.getParent());
        assertEquals("American 123Breakfast",tag.getName());
        assertEquals("dine_american_bf",tag.getImg());
        assertEquals(2,tag.getIsCustom());
        assertEquals(0,tag.getPrice(),0);
        assertEquals("",tag.getDescription());

    }
    @Test
    public void testFacilities() throws Exception
    {
        ArrayList<MeshFacility> facilities = MeshParser.parseFacilities(MeshRawReader.read(R.raw.get_all_facilities));
        assertEquals(3,facilities.size());
        MeshFacility facility = facilities.get(0);
        assertEquals(2,facility.getId());
        assertEquals("In Balance Fitness Center",facility.getItem_name());
        assertEquals("Free (in-house guests)",facility.getItem_description());
        assertEquals(0,facility.getUnit_price(),0);
        assertEquals(1,facility.getCategory_id());
        assertEquals("http://155.94.175.130:6060//images/facilities/Gym.jpg",facility.getImg_uri());


    }
    @Test
    public void testFacilityCategory() throws Exception
    {
        ArrayList<MeshFacilityCategory> categories = MeshParser.parseFacilityCategories(MeshRawReader.read(R.raw.get_facility_category));
        assertEquals(2,categories.size());
        MeshFacilityCategory category = categories.get(0);
        assertEquals(1,category.getId());
        assertEquals("Sports and Leisure",category.getCategory_name());
        assertEquals("Sports and Leisure",category.getCategory_description());
        assertEquals("",category.getImg_preview());
        assertEquals("",category.getImg_uri());


    }
    @Test
    public void testFood() throws Exception
    {
        ArrayList<MeshFood> foods = MeshParser.parseFood(MeshRawReader.read(R.raw.get_all_f_and_b_item));
        assertEquals(15,foods.size());
        MeshFood food = foods.get(0);
        assertEquals(1,food.getId());
        assertEquals(1,food.getCategory_id());
        assertEquals("Uncle Robert's Favorite",food.getItem_name());
        assertEquals("Two eggs cooked to order with Grits, Sawmill Gravy, homemade Buttermilk Biscuits, real butter and the best Preserves, Jam n’ Apple Butter (on request) we could find. Served with Fried Apples or 	Hashbrown Casserole and your choice of Hickory-Smoked Country Ham, Sugar Cured Ham, U.S. Farm-Raised Catfish Fillet, 8 oz. Hamburger Steak, Grilled Pork Chop, or Fried Chicken Tenderloin.",food.getItem_description());
        assertEquals(35.00,food.getUnit_price(),food.getUnit_price());
        assertEquals("br_uncletristan.jpg",food.getImg_uri());
    }
    @Test
    public void testFoodCategory() throws Exception
    {
        ArrayList<MeshFoodCategory> categories = MeshParser.parseFoodCategory(MeshRawReader.read(R.raw.get_f_and_b_category));
        assertEquals(3,categories.size());
        MeshFoodCategory category = categories.get(0);
        assertEquals(1,category.getId());
        assertEquals("Breakfast",category.getCategory_name());
        assertEquals("Breakfast",category.getCategory_description());

    }
    @Test
    public void testWeatherForecast() throws Exception
    {
        ArrayList<MeshWeatherForecast> forecasts = MeshParser.parseForecast(MeshRawReader.read(R.raw.weather_forecast));
        assertEquals(51,forecasts.size());
        MeshWeatherForecast forecast = forecasts.get(0);
        assertEquals("SA",forecast.getCountry());
        assertEquals("Riyadh",forecast.getCity());
        ArrayList<MeshWeatherForecastDay> days = new ArrayList<>();
        days.addAll(MeshWeatherForecastDay.parse(forecast.getForecast()));
        assertEquals(7,days.size());
        MeshWeatherForecastDay day = days.get(0);
        assertEquals(1,day.getDay());
        assertEquals("Tuesday",day.getDay_of_week());
        assertEquals("Sunny",day.getDescription());
        assertEquals(25,day.getHumidity(),25);
        assertEquals("/images/weather/01d.png",day.getIcon());
        assertEquals(29,day.getTemp(),29);
        assertEquals(23,day.getTemp_min(),29);
        assertEquals(34,day.getTemp_max(),34);
        assertEquals(7.8,day.getWind_speed(),7.8);

    }
    @Test
    public void testGenre() throws Exception
    {
        ArrayList<MeshGenre> genres = MeshParser.parseGenre(MeshRawReader.read(R.raw.get_genres));
        assertEquals(11,genres.size());
        MeshGenre genre = genres.get(0);
        assertEquals("Adventure",genre.getGenre());
        assertEquals(1,genre.getId());


    }
    @Test
    public void testMessage() throws Exception
    {
        ArrayList<MeshMessage> messages = MeshParser.parseMessage(MeshRawReader.read(R.raw.get_message));
        assertEquals(1,messages.size());
        MeshMessage message = messages.get(0);
        assertEquals(message.getMessg_from(),"Mars");
        assertEquals(message.getMessg_datetime(),"2018-01-09 02:02:02");

        assertEquals(29,message.getId());
        assertEquals("Mars",message.getMessg_from());
        assertEquals("sssss",message.getMessg_subject());
        assertEquals("sss",message.getMessg_text());
        assertEquals("1007",message.getRoom_id());
        assertEquals("2018-01-09 02:02:02",message.getMessg_datetime());
        assertEquals(0,message.getMessg_status());
    }
    @Test
    public void testRoomType() throws Exception
    {
        ArrayList<MeshRoomType> types = MeshParser.parseRoomType(MeshRawReader.read(R.raw.get_all_room_type));
        assertEquals(1,types.size());
        MeshRoomType type = types.get(0);
        assertEquals("Standard Room",type.getCategory_description());
        assertEquals("Standard Room",type.getCategory_name());
        assertEquals(1,type.getId());
    }
    @Test
    public void testShoppingItem() throws Exception
    {
        ArrayList<MeshShoppingItem> items = MeshParser.parseShoppingItem(MeshRawReader.read(R.raw.get_all_shopping_item));
        assertEquals(57,items.size());
        MeshShoppingItem item = items.get(0);
        assertEquals(1,item.getId());
        assertEquals("camara_digital_canon_ixus_145_black_hd_ad_l2.jpg",item.getImg_uri());
        assertEquals("16MP 8x optical zoom DIGIC 4+ Image Stabilizer (IS) System 720p HD recording<br>2.7-inch type monitor <br>Autofocus: Continuous, Servo AF <br>Shutter Speed 1 - 1/2000sec.<br>Storage: SD card (sold separately)",
                item.getItem_description());
        assertEquals("Canon IXUS 145 16MP Digital Camera",item.getItem_name());
        assertEquals(6,item.getShopping_category_id());
        assertEquals(199.99,item.getUnit_price(),299);
    }
    @Test
    public void testShoppingItemCategory() throws Exception
    {
        ArrayList<MeshShoppingCategory> items = MeshParser.parseShoppingCategory(MeshRawReader.read(R.raw.get_shopping_category));
        assertEquals(4,items.size());
        MeshShoppingCategory category = items.get(0);
        assertEquals(6,category.getId());
        assertEquals("Featured",category.getCategory_name());
        assertEquals("Featured Products",category.getCategory_description());

    }
    @Test
    public void testStreamItem() throws Exception
    {
        ArrayList<MeshStream> items = MeshParser.parseStreams(MeshRawReader.read(R.raw.get_live_stream_series));
        assertEquals(30,items.size());
        MeshStream item = items.get(0);
        assertEquals(1,item.getId());
        assertEquals(1,item.getCategory());
        assertEquals("The K2",item.getTitle());
        assertEquals("Korea",item.getCountry());
        assertEquals("2016",item.getReleased());
        assertEquals("Ongoing",item.getStatus());
        assertEquals("ls_k2.jpg",item.getImage());
        ArrayList<MeshStreamTag> tags = new ArrayList<>();
        tags.addAll(MeshStreamTag.generate(item.getTags()));
        assertEquals(3,tags.size());
        assertEquals("Action",tags.get(0).getTag());
        assertEquals("Melodrama",tags.get(1).getTag());
        assertEquals("Political",tags.get(2).getTag());
        assertEquals(
                "This drama is about a patriotic bodyguard who was abandoned by his country and colleagues, a hidden daughter of leading Presidential candidate who regards love as a tool for revenge, and the First Lady contender who hides her ambition and charisma behind a kind and friendly personality. Kim Je Ha (Ji Chang Wook) is former solider for hire. He is also called K2. He is hired as a bodyguard by Choi Yoo Jin (Song Yoon Ah). Choi Yoo Jin is the wife of a presidential candidate, Jang Se Joon (Jo Sung Ha) and the daughter from a chaebol family. Meanwhile, Go Anna (Im Yoon Ah) is the secret daughter of the presidential hopeful. She is also a recluse."
                ,item.getDescription());
        ArrayList<MeshEpisode> episodes = new ArrayList<>();
        episodes.addAll(MeshEpisode.generate(item.getEpisodes()));
        assertEquals(10,episodes.size());
        MeshEpisode episode = episodes.get(0);
        assertEquals("n/a",episode.getTitle());
        assertEquals("10",episode.getNumber());
        assertEquals("",episode.getDescription());
        assertEquals("n/a",episode.getImg());
        assertEquals("livestream/korean/k2.mp4",episode.getUrl());
    }
    @Test
    public void testStreamCategory() throws Exception
    {
        ArrayList<MeshStreamCategory> categories = MeshParser.parseStreamCategory(MeshRawReader.read(R.raw.get_live_stream_category));
        assertEquals(3,categories.size());
        MeshStreamCategory category = categories.get(0);
        assertEquals("KOREAN DRAMA",category.getCategory_description());
        assertEquals("KOREAN DRAMA",category.getCategory_name());
        assertEquals(1,category.getId());
    }
    @Test
    public void testVC() throws Exception
    {
        ArrayList<MeshVC> vcs = MeshParser.parseVC(MeshRawReader.read(R.raw.get_all_establishments_v3));
        assertEquals(22,vcs.size());

        MeshVC vc = vcs.get(0);
        assertEquals(1,vc.getId());
        assertEquals(1,vc.getCategory_id());
        assertEquals("Inya Day Spa",vc.getEstablishment_name());
        assertEquals(96.139107,vc.getLongitude(),0);
        assertEquals(16.816681,vc.getLatitude(),0);
        assertEquals("16/2 Inya Road, Kamayut Tsp",vc.getEstablishment_addr());
        assertEquals("http://192.168.5.207:6060/images/maps/qr_16.816681-96.139107.png",vc.getQr_code());
        assertEquals("http://192.168.5.207:6060/images/virtual_concierge/inya_day_spa.jpg",vc.getImg_url());
        assertEquals(1.0,vc.getRating(),0);

        ArrayList<MeshRouteCoords> directions = new ArrayList<>();

        directions.addAll(MeshRouteCoords.parse(vc.getEstablishment_route()));
        assertEquals(26,directions.size());

        MeshRouteCoords c = directions.get(0);
        assertEquals(96.132431,c.getLon(),0);
        assertEquals(16.82032,c.getLat(),0);

        ArrayList<MeshDirection> d1 = new ArrayList<>();
        d1.addAll(MeshDirection.parse(vc.getEstablishment_route()));
        assertEquals(4,d1.size());

        MeshDirection direction = d1.get(0);

        assertEquals(0,direction.getSequenceNumber());
        assertEquals(16.82032,direction.getTurnCoordsLat(),0);
        assertEquals(96.132431,direction.getTurnCoordsLon(),0);
        assertEquals("0.487 mile",direction.getDistance());
        assertEquals("images/maps/icon-dirs-start_sm.gif",direction.getIconUrl());
        assertEquals("Start out going south on - Pyay Prome Rd toward Hanthawaddy Road.",direction.getNarrative());

    }
    @Test
    public void testVCCategory() throws Exception
    {
        ArrayList<MeshVCCategory> categories = MeshParser.parseVCCategory(MeshRawReader.read(R.raw.get_maps_categories));
        assertEquals(6,categories.size());
        MeshVCCategory category = categories.get(0);
        assertEquals(1,category.getId());
        assertEquals("Spa Shops and Galleries",category.getName());
        assertEquals("",category.getDescription());
        assertEquals("",category.getImg_preview());
        assertEquals("",category.getImg_uri());
    }
    @Test
    public void testVOD() throws Exception
    {
        ArrayList<MeshVOD> vods = MeshParser.parseVOD(MeshRawReader.read(R.raw.get_vod));
        assertEquals(12,vods.size());
        MeshVOD vod = vods.get(0);
        assertEquals(1,vod.getId());
        assertEquals("Hell or High Water",vod.getTitle());
        assertEquals("A divorced father and his ex-con brother resort to a desperate scheme in order to save their family’s ranch in West Texas. ",
                vod.getPlot());
        assertEquals("vod_hellhiwater",vod.getImg());
        assertEquals("trailer_hellhiwater.mp4",vod.getTrailer());
        assertEquals("full_hellhiwater.mp4",vod.getFull());
        assertEquals(102,vod.getLength());
        assertEquals("R",vod.getRating());
        assertEquals(0,vod.getBought());

        ArrayList<MeshGenre> genres = new ArrayList<>();
        genres.addAll(MeshGenre.getGenre(vod));
        assertEquals(2,genres.size());
        assertEquals("Crime",genres.get(0).getGenre());
        assertEquals("Drama",genres.get(1).getGenre());
        assertTrue(MeshGenre.checkGenre(vod,"Crime"));
        assertTrue(MeshGenre.checkGenre(vod,"Drama"));
        assertFalse(MeshGenre.checkGenre(vod,"Comedy"));
        assertFalse(MeshGenre.checkGenre(vod,"Adventure"));


    }
    @Test
    public void testWeather() throws Exception
    {
        ArrayList<MeshWeatherV2> weathers = MeshParser.parseWeatherV2(MeshRawReader.read(R.raw.all_weather));
        assertEquals(51,weathers.size());
        MeshWeatherV2 weatherV2 = weathers.get(0);
        assertEquals(1,weatherV2.getId());
        assertEquals(2761369,weatherV2.getLoc_id());
        assertEquals(16.3721,weatherV2.getLon(),1);
        assertEquals(48.2085,weatherV2.getLat(),1);
        assertEquals("AT",weatherV2.getCountry());
        assertEquals("Vienna",weatherV2.getLoc_name());
        assertEquals(1508195820,weatherV2.getSunrise(),0);
        assertEquals(1508234520,weatherV2.getSunset(),0);
        assertEquals("Fog",weatherV2.getDescription());
        assertEquals("images/weather/50n.png",weatherV2.getIcon());
        assertEquals(8,weatherV2.getTemp_cur(),1);
        assertEquals(20.8,weatherV2.getTemp_max(),1);
        assertEquals(12,weatherV2.getTemp_min(),1);
        assertEquals(1,weatherV2.getTimezone(),0);
        assertEquals(4.30,weatherV2.getWind_speed(),1);
        assertEquals(100,weatherV2.getHumidity(),1);
        assertEquals(1026,weatherV2.getPressure(),1);
    }
    @Test
    public void testConciergeItem() throws Exception
    {
        ArrayList<MeshConciergeRequestItem> items = MeshParser.parseConciergeItems(MeshRawReader.read(R.raw.get_all_item_request));
        assertEquals(15,items.size());
        MeshConciergeRequestItem item = items.get(0);
        assertEquals(1,item.getId());
        assertEquals("th11.jpg",item.getImg_uri());
        assertEquals("Single toothbrush (individually packaged)",item.getItem_description());
        assertEquals("Toothbrush",item.getItem_name());
        assertEquals(0,item.getUnit_price(),0);
    }
    @Test
    public void testConciergeService() throws Exception
    {
        ArrayList<MeshConciergeRequestService> services = MeshParser.parseConciergeServices(MeshRawReader.read(R.raw.get_all_service_request));
        assertEquals(4,services.size());
        MeshConciergeRequestService service = services.get(0);
        assertEquals(6,service.getId());
        assertEquals("airport_pickup.jpg",service.getImg_uri());
        assertEquals("Airport Car Pickup/DropOff",service.getItem_description());
        assertEquals("Airport Car Pickup/DropOff",service.getItem_name());
        assertEquals(0,service.getUnit_price(),0);
    }
    //==============================================================================================
}