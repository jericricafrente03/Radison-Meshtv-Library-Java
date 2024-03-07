package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshArrivalFlight;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshDepartureFlight;

/**
 * Manages Search for specific objects
 */
class BittelSearchManager
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    static final String TAG = BittelSearchManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Method============================================
    static synchronized boolean isMatch(Object o,String searchString)
    {
        boolean result = false;

        if(o instanceof MeshArrivalFlight)
        {
            MeshArrivalFlight flight = (MeshArrivalFlight) o;
            if (flight.getArrival_datetime().toLowerCase().contains(searchString.toLowerCase()))
            {
                return true;
            }
            else if (flight.getCarrier().toLowerCase().contains(searchString.toLowerCase()))
            {
                return true;
            }
            else if (flight.getFlight_number().toLowerCase().contains(searchString.toLowerCase())) {
                return true;
            }
            else if (flight.getOrigin().toLowerCase().contains(searchString.toLowerCase()))
            {
                return true;
            }
        }
        else if(o instanceof MeshDepartureFlight)
        {
            MeshDepartureFlight flight = (MeshDepartureFlight) o;
            if (flight.getDeparture_datetime().toLowerCase().contains(searchString.toLowerCase()))
            {
                return true;
            }
            else if (flight.getCarrier().toLowerCase().contains(searchString.toLowerCase()))
            {
                return true;
            }
            else if (flight.getFlight_number().toLowerCase().contains(searchString.toLowerCase())) {
                return true;
            }
            else if (flight.getDestination().toLowerCase().contains(searchString.toLowerCase()))
            {
                return true;
            }
        }
        return result;
    }
    //==============================================================================================
}
