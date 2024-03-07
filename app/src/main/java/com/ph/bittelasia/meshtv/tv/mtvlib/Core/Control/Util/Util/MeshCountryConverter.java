package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Util;

import java.util.HashMap;

/**
 * Used for converting country code to whole name and vice versa
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshCountryConverter
{
    /**
     * Get country id using country code
     * @param countryCode ISO country code
     * @return corresponding id
     */
    public static int getID(String countryCode)
    {
        int result = -1;
        HashMap<String,Integer> countries = new HashMap<>();
        countries.put("SA",0);
        countries.put("IL",1);
        countries.put("KW",2);
        countries.put("OM",3);
        countries.put("QA",4);
        countries.put("BH",5);
        countries.put("TR",6);
        countries.put("RU",7);
        countries.put("FI",8);
        countries.put("MU",9);
        countries.put("ZA",10);
        countries.put("PK",11);
        countries.put("BD",12);
        countries.put("LK",13);
        countries.put("IN",14);
        countries.put("MV",15);
        countries.put("MM",16);
        countries.put("VN",17);
        countries.put("TH",18);
        countries.put("ID",19);
        countries.put("LA",20);
        countries.put("TW",21);
        countries.put("PH",22);
        countries.put("MY",23);
        countries.put("CN",24);
        countries.put("HK",25);
        countries.put("BN",26);
        countries.put("MO",27);
        countries.put("KH",28);
        countries.put("KR",29);
        countries.put("JP",30);
        countries.put("SG",31);
        countries.put("AU",32);
        countries.put("NZ",33);
        countries.put("DK",34);
        countries.put("UK",35);
        countries.put("CH",36);
        countries.put("SE",37);
        countries.put("AT",38);
        countries.put("BE",39);
        countries.put("DE",40);
        countries.put("LU",41);
        countries.put("IR",42);
        countries.put("FR",43);
        countries.put("ES",44);
        countries.put("NO",45);
        countries.put("IT",46);
        countries.put("MX",47);
        countries.put("US",48);
        countries.put("CA",49);
        countries.put("NL",50);
        result = countries.get(countryCode);
        countries.clear();
        return result;

    }
    /**
     * Get country code using country id
     * @param id country id
     * @return corresponding ISO country code
     */
    public static String getCountryCode(int id)
    {
        String result = null;
        HashMap<Integer,String> countries = new HashMap<>();
        countries.put(0,"SA");
        countries.put(1,"IL");
        countries.put(2,"KW");
        countries.put(3,"OM");
        countries.put(4,"QA");
        countries.put(5,"BH");
        countries.put(6,"TR");
        countries.put(7,"RU");
        countries.put(8,"FI");
        countries.put(9,"MU");
        countries.put(10,"ZA");
        countries.put(11,"PK");
        countries.put(12,"BD");
        countries.put(13,"LK");
        countries.put(14,"IN");
        countries.put(15,"MV");
        countries.put(16,"MM");
        countries.put(17,"VN");
        countries.put(18,"TH");
        countries.put(19,"ID");
        countries.put(20,"LA");
        countries.put(21,"TW");
        countries.put(22,"PH");
        countries.put(23,"MY");
        countries.put(24,"CN");
        countries.put(25,"HK");
        countries.put(26,"BN");
        countries.put(27,"MO");
        countries.put(28,"KH");
        countries.put(29,"KR");
        countries.put(30,"JP");
        countries.put(31,"SG");
        countries.put(32,"AU");
        countries.put(33,"NZ");
        countries.put(34,"DK");
        countries.put(35,"UK");
        countries.put(36,"CH");
        countries.put(37,"SE");
        countries.put(38,"AT");
        countries.put(39,"BE");
        countries.put(40,"DE");
        countries.put(41,"LU");
        countries.put(42,"IR");
        countries.put(43,"FR");
        countries.put(44,"ES");
        countries.put(45,"NO");
        countries.put(46,"IT");
        countries.put(47,"MX");
        countries.put(48,"US");
        countries.put(49,"CA");
        countries.put(50,"NL");
        result = countries.get(id);
        countries.clear();
        return result;
    }
    /**
     * Get country full name using country code
     * @param countryCode ISO country code
     * @return full country name
     */
    public static String getCountryFullname(String countryCode)
    {
        String result = null;
        HashMap<String,String> countries=new HashMap<>();
        countries.put("SA","Saudi Arabia");
        countries.put("IL","Israel");
        countries.put("KW","Kuwait");
        countries.put("OM","Oman");
        countries.put("QA","Qatar");
        countries.put("BH","Bahrain");
        countries.put("TR","Turkey");
        countries.put("RU","Russia");
        countries.put("FI","Finland");
        countries.put("MU","Mauritius");
        countries.put("ZA","South Africa");
        countries.put("PK","Pakistan");
        countries.put("BD","Bangladesh");
        countries.put("LK","Sri Lanka");
        countries.put("IN","India");
        countries.put("MV","Maldives");
        countries.put("MM","Myanmar");
        countries.put("VN","Vietnam");
        countries.put("TH","Thailand");
        countries.put("ID","Indonesia");
        countries.put("LA","Laos");
        countries.put("TW","Taiwan");
        countries.put("PH","Philippines");
        countries.put("MY","Malaysia");
        countries.put("CN","China");
        countries.put("HK","Hong Kong");
        countries.put("BN","Brunei");
        countries.put("MO","Macau");
        countries.put("KH","Cambodia");
        countries.put("KR","South Korea");
        countries.put("JP","Japan");
        countries.put("SG","Singapore");
        countries.put("AU","Australia");
        countries.put("NZ","New Zealand");
        countries.put("DK","Denmark");
        countries.put("UK","Ukraine");
        countries.put("CH","Chile");
        countries.put("SE","Sweden");
        countries.put("AT","Austria");
        countries.put("BE","Belgium");
        countries.put("DE","Germany");
        countries.put("LU","Luxembourg");
        countries.put("IR","Iran");
        countries.put("FR","France");
        countries.put("ES","Spain");
        countries.put("NO","Norway");
        countries.put("IT","Italy");
        countries.put("MX","Mexico");
        countries.put("US","United States");
        countries.put("CA","Canada");
        countries.put("NL","Netherlands");
        result = countries.get(countryCode);
        countries.clear();
        return result;
    }
}
