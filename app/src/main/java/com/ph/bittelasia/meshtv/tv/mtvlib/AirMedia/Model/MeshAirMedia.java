package com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Model;

import com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Control.MeshTVAirMediaPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshTVSearchManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshArrivalFlight;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Represents Airmedia Credentials
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshAirMedia
{
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG          = MeshAirMedia.class.getSimpleName();
    /**
     * Tag for device name
     */
    public static final String TAG_DEVICE   = "device_name";
    /**
     * Tag for device password
     */
    public static final String TAG_PASSWORD = "device_password";
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    /**
     * Airmedia device name
     */
    private String device_name = null;
    /**
     * Airmedia password
     */
    private String device_password = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Constructor=======================================
    /**
     * Default constructor retrieves credentials from {@link MeshTVAirMediaPreferenceManager MeshTVAirMediaPreferenceManager}
     */
    public MeshAirMedia()
    {
        device_name = MeshTVAirMediaPreferenceManager.getDeviceName();
        device_password = MeshTVAirMediaPreferenceManager.getDevicePassword();
    }
    /**
     * Constructor that parses  credentials from a JSONObject formatted String
     */
    public MeshAirMedia(String data)
    {
        try
        {
            JSONObject object = new JSONObject(data);
            device_name = object.getString(TAG_DEVICE);
            device_password = object.getString(TAG_PASSWORD);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Action------------------------------------------
    /**
     * Save the value of {@link #device_name device_name} and {@link #device_password device_password} to {@link MeshTVAirMediaPreferenceManager MeshTVAirMediaPreferenceManager}
     */
    public void update()
    {
        MeshTVAirMediaPreferenceManager.setDeviceName(device_name);
        MeshTVAirMediaPreferenceManager.setDevicePassword(device_password);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Getter------------------------------------------
    /**
     * Gets the Airmedia {@link #device_name device_name}
     * @return Airmedia {@link #device_name device_name}
     */
    public String getDevice_name() {
        return device_name;
    }
    /**
     * Gets the Airmedia {@link #device_password device_password}
     * @return Airmedia {@link #device_password device_password}
     *
     */
    public String getDevice_password() {
        return device_password;
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Setter------------------------------------------
    /**
     * Sets Airmedia {@link #device_name device_name}
     * @param device_name new Airmedia {@link #device_name device_name}
     */
    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }
    /**
     * Sets Airmedia {@link #device_password device_password}
     * @param device_password new Airmedia {@link #device_password device_password}
     */
    public void setDevice_password(String device_password) {
        this.device_password = device_password;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
