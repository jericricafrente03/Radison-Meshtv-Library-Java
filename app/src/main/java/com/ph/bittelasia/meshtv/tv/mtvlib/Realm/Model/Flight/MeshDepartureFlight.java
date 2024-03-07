package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshDepartureFlight extends RealmObject implements MeshObjectInterface
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    @Ignore
    public static final String TAG = MeshDepartureFlight.class.getSimpleName();
    @Ignore
    public static final String TAG_DESTINATION = "destination";
    @Ignore
    public static final String TAG_DEPARTURE_DATETIME = "departure_datetime";
    @Ignore
    public static final String TAG_FLIGHT_NUMBER = "flight_number";
    @Ignore
    public static final String TAG_CARRIER = "carrier";
    @Ignore
    public static final String TAG_STATUS = "status";
    @Ignore
    public static final String TAG_ONTIME_STATUS = "ontime_status";
    @Ignore
    public static final String TAG_MINOFF = "min_off";
    @Ignore
    public static final String DATE_FORMAT = "yyyy-MM-dd kk:mm:ss";
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Properties----------------------------------------
    @PrimaryKey
    private String flight_number;
    private String carrier;
    private String status;
    private String min_off;
    private String ontime_status;
    private String departure_datetime;
    private String destination;
    private Date departureDate;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Method============================================
    //--------------------------------------------Getter--------------------------------------------
    public String getDeparture_datetime() {
        return departure_datetime;
    }
    public String getDestination() {
        return destination;
    }
    public Date getDepartureDate() {
        return departureDate;
    }
    public String getOntime_status() {
        return ontime_status;
    }
    public String getFlight_number() {
        return flight_number;
    }
    public String getCarrier() {
        return carrier;
    }
    public String getStatus() {
        return status;
    }
    public String getMin_off() {
        return min_off;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Setter--------------------------------------------
    public void setDeparture_datetime(String departure_datetime) {
        this.departure_datetime = departure_datetime;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setMin_off(String min_off) {
        this.min_off = min_off;
    }
    public void setOntime_status(String ontime_status) {
        this.ontime_status = ontime_status;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=====================================MeshObjectInterface======================================
    @Override
    public int getMeshID() {
        return 0;
    }
    @Override
    public String getMeshLabel() {
        return flight_number;
    }
    @Override
    public String getMeshDescription() {
        return destination;
    }
    @Override
    public int getMeshQuantity() {
        return 0;
    }
    @Override
    public double getMeshPrice() {
        return 0;
    }
    @Override
    public String getMeshIMG() {
        return null;
    }
    //==============================================================================================
}
