package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Represents data of Arriving Flights
 * @author Mars Ray Araullo
 */
public class MeshArrivalFlight extends RealmObject implements MeshObjectInterface
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    /**
     * TAG for logs
     */
    @Ignore
    public static final String TAG = MeshArrivalFlight.class.getSimpleName();
    /**
     *Tag for {@link #origin origin}
     */
    @Ignore
    public static final String TAG_ORIGIN = "origin";
    /**
     *Tag for {@link #arrival_datetime arrival_datetime}
     */
    @Ignore
    public static final String TAG_ARRIVAL_DATETIME = "arrival_datetime";
    /**
     *Tag for {@link #flight_number flight_number}
     */
    @Ignore
    public static final String TAG_FLIGHT_NUMBER = "flight_number";
    /**
     *Tag for {@link #carrier carrier}
     */
    @Ignore
    public static final String TAG_CARRIER = "carrier";
    /**
     *Tag for {@link #status status}
     */
    @Ignore
    public static final String TAG_STATUS = "status";
    /**
     *Tag for {@link #ontime_status ontime_status}
     */
    @Ignore
    public static final String TAG_ONTIME_STATUS = "ontime_status";
    /**
     *Tag for {@link #min_off min_off}
     */
    @Ignore
    public static final String TAG_MINOFF = "min_off";
    /**
     *Date format used for MeshArrivalFlight Objects
     */
    @Ignore
    public static final String DATE_FORMAT = "yyyy-MM-dd kk:mm:ss";
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Properties----------------------------------------
    /**
     * Flight number of the flight (Primary Key)
     */
    @PrimaryKey
    private String flight_number;
    /**
     * Airline of the flight
     */
    private String carrier;
    /**
     * Current status of the flight
     */
    private String status;
    /**
     * Minutes the flight was late
     */
    private String min_off;
    /**
     * Status whether a flight is on-time or not
     */
    private String ontime_status;
    /**
     * Expected arrival date and time (String in {@link #DATE_FORMAT DATE_FORMAT})
     */
    private String arrival_datetime;
    /**
     * Origin of the flight (Airport)
     */
    private String origin;
    /**
     * Expected arrival date and time (Date in {@link #DATE_FORMAT DATE_FORMAT})
     */
    private Date arrivalDate;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Method============================================
    //--------------------------------------------Getter--------------------------------------------
    /**
     * Returns {@link #arrivalDate arrivalDate} in String using {@link #DATE_FORMAT DATE_FORMAT}
     * @return {@link #arrival_datetime arrival_datetime}
     */
    public String getArrival_datetime() {
        return arrival_datetime;
    }
    /**
     * Returns {@link #origin origin}
     * @return {@link #origin origin}
     */
    public String getOrigin() {
        return origin;
    }
    /**
     * Returns {@link #arrivalDate arrivalDate}
     * @return {@link #arrivalDate arrivalDate}
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }
    /**
     * Returns {@link #ontime_status ontime_status}
     * @return {@link #ontime_status ontime_status}
     */
    public String getOntime_status() {
        return ontime_status;
    }
    /**
     * Returns {@link #flight_number flight_number}
     * @return {@link #flight_number flight_number}
     */
    public String getFlight_number() {
        return flight_number;
    }
    /**
     * Returns {@link #carrier carrier}
     * @return {@link #carrier carrier}
     */
    public String getCarrier() {
        return carrier;
    }
    /**
     * Returns {@link #status status}
     * @return {@link #status status}
     */
    public String getStatus() {
        return status;
    }
    /**
     * Returns {@link #min_off min_off}
     * @return {@link #min_off min_off}
     */
    public String getMin_off() {
        return min_off;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Setter--------------------------------------------
    /**
     * Updates the value of {@link #arrival_datetime arrival_datetime}
     * @param arrival_datetime {@link #arrival_datetime arrival_datetime} should be in {@link #DATE_FORMAT DATE_FORMAT}
     */
    public void setArrival_datetime(String arrival_datetime) {this.arrival_datetime = arrival_datetime;}
    /**
     * Updates the value of {@link #origin origin}
     * @param origin {@link #origin origin}
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    /**
     * Updates the value of {@link #arrivalDate arrivalDate}
     * @param arrivalDate {@link #arrivalDate arrivalDate}
     */
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    /**
     * Updates the value of {@link #flight_number flight_number} - (Primary Key - cannot be changed once set)
     * @param flight_number {@link #flight_number flight_number}
     */
    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }
    /**
     * Updates the value of {@link #carrier carrier}
     * @param carrier {@link #carrier carrier}
     */
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
    /**
     * Updates the value of {@link #status status}
     * @param status {@link #status status}
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * Updates the value of {@link #min_off min_off}
     * @param min_off {@link #min_off min_off}
     */
    public void setMin_off(String min_off) {
        this.min_off = min_off;
    }
    /**
     * Updates the value of {@link #ontime_status ontime_status}
     * @param ontime_status {@link #ontime_status ontime_status}
     */
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
        return origin;
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
