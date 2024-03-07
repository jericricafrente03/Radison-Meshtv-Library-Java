package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Apps;

import android.view.View;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.ResourceManager.MeshResourceManager;
import org.json.JSONObject;

/**
 * Used to represent Apps/Features of the MeshTV App
 * <br>Gets data from /sdcard/Android/(App Name)/app_desc.txt
 *@author Mars Ray Canizares Araullo
 *@version 1.0
 */
public class MeshApp
{
    //==========================================Variable============================================
    //------------------------------------------Constant--------------------------------------------
    public static final String TAG = MeshApp.class.getSimpleName();
    /**
     * Tag for {@link #id id}
     */
    public static final String TAG_ID               = "id";
    /**
     * Tag for {@link #displayName displayName}
     */
    public static final String TAG_DISPLAYNAME      = "display_name";
    /**
     * Tag for {@link #app app}
     */
    public static final String TAG_APP              = "app";
    /**
     * Tag for {@link #icon icon}
     */
    public static final String TAG_ICON             = "icon";
    /**
     * Tag for {@link #iconSelected iconSelected}
     */
    public static final String TAG_ICON_SELECTED    = "icon_selected";
    /**
     * Tag for {@link #enabled enabled}
     */
    public static final String TAG_ENABLED          = "enabled";
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Instance-------------------------------------------
    /**
     * id of application used for identifying the application
     * <br>Default IDs:
     * <br>01. TV App (0)
     * <br>02. Airmedia App (1)
     * <br>03. Hotel Facility (2)
     * <br>04. Virtual Concierge (3)
     * <br>05. Weather (4)
     * <br>06. Messaging (5)
     * <br>07. Dining (6)
     * <br>08. Concierge (7)
     * <br>09. Le Club (8)
     * <br>10. Billing (9)
     * <br>11. Flights (10)
     * <br>12. VOD (11(
     */
    int id;
    /**
     * The name displayed for the app
     */
    String displayName;
    /**
     * Complete Filename of the Activity to be launched for this feature/app
     */
    String app;
    /**
     * Icon to be displayed on its default state
     */
    int icon;
    /**
     * Icon to be displayed on its selected state
     */
    int iconSelected;
    /**
     * Values:
     * <br>true - displayed
     * <br>false - hidden
     */
    int enabled;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=========================================Constructor==========================================
    public MeshApp()
    {

    }
    /**
     * Constructor that parses data from a JSON formatted String
     * @param data data to be parsed
     */
    public MeshApp(String data)
    {
        try
        {
            JSONObject object = new JSONObject(data);
            id = object.getInt(TAG_ID);
            displayName = object.getString(TAG_DISPLAYNAME);
            app = object.getString(TAG_APP);
            icon = MeshResourceManager.get().getResourceId(object.getString(TAG_ICON));
            iconSelected= MeshResourceManager.get().getResourceId(object.getString(TAG_ICON_SELECTED));
            enabled = object.getInt(TAG_ENABLED);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //==============================================================================================
    //===========================================Method=============================================
    //-------------------------------------------Getter---------------------------------------------
    /**
     * Gets the {@link #id id} of the {@link MeshApp MeshApp}
     * @return {@link #id id} of the {@link MeshApp MeshApp}
     */
    public int getId() {
        return id;
    }
    /**
     * Gets the {@link #displayName displayName} of the {@link MeshApp MeshApp}
     * @return {@link #displayName displayName} of the {@link MeshApp MeshApp}
     */
    public String getDisplayName() {
        return displayName;
    }
    /**
     * Gets the {@link #app app} of the {@link MeshApp MeshApp}
     * @return {@link #app app} of the {@link MeshApp MeshApp}
     */
    public String getApp() {
        return app;
    }
    /**
     * Gets the {@link #icon icon} of the {@link MeshApp MeshApp}
     * @return {@link #icon icon} of the {@link MeshApp MeshApp}
     */
    public int getIcon() {
        return icon;
    }
    /**
     * Gets the {@link #iconSelected iconSelected} of the {@link MeshApp MeshApp}
     * @return {@link #iconSelected iconSelected} of the {@link MeshApp MeshApp}
     */
    public int getIconSelected() {
        return iconSelected;
    }
    /**
     * Gets the {@link #enabled enabled} of the {@link MeshApp MeshApp}
     * @return {@link #enabled enabled} of the {@link MeshApp MeshApp}
     */
    public int getEnabled() {
        return enabled;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Setter---------------------------------------------
    /**
     * Sets the {@link #id id} of the {@link MeshApp MeshApp}
     * @param id new  {@link #id id}of the {@link MeshApp MeshApp}
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Sets the {@link #displayName displayName} of the {@link MeshApp MeshApp}
     * @param displayName new  {@link #displayName displayName}of the {@link MeshApp MeshApp}
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    /**
     * Sets the {@link #app app} of the {@link MeshApp MeshApp}
     * @param app new  {@link #app app}of the {@link MeshApp MeshApp}
     */
    public void setApp(String app) {
        this.app = app;
    }
    /**
     * Sets the {@link #icon icon} of the {@link MeshApp MeshApp}
     * @param icon new  {@link #icon icon}of the {@link MeshApp MeshApp}
     */
    public void setIcon(int icon) {
        this.icon = icon;
    }
    /**
     * Sets the {@link #iconSelected iconSelected} of the {@link MeshApp MeshApp}
     * @param iconSelected new  {@link #iconSelected iconSelected}of the {@link MeshApp MeshApp}
     */
    public void setIconSelected(int iconSelected) {
        this.iconSelected = iconSelected;
    }
    /**
     * Sets the {@link #enabled enabled} of the {@link MeshApp MeshApp}
     * @param enabled new  {@link #enabled enabled}of the {@link MeshApp MeshApp}
     */
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
