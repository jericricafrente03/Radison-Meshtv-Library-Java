package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.OSM;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation: Used for setting up {@link com.ph.bittelasia.meshtv.tv.mtvlib.OSM.View.MeshTVOSMFragment MeshTVOSMFragment}
 * <br>
 * <br>
 * Target: Class
 * <br>
 * Required by: {@link com.ph.bittelasia.meshtv.tv.mtvlib.OSM.View.MeshTVOSMFragment MeshTVOSMFragment}
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapSettings
{

    /**
     * Resource ID of the hotel icon
     * @return Resource ID of the hotel icon
     */
    int hotelIcon();

    /**
     * Resource ID of the marker icon
     * @return Resource ID of the marker icon
     */
    int markerIcon();

    /**
     * Resource ID of the MapView object
     * @return Resource ID of the MapView object
     */
    int mapViewId();

    /**
     * Default zoom when map is drawn
     * @return Default zoom when map is drawn
     */
    int defaultZoom() default 14;

    /**
     * Sets the farthest zoom of the map
     * @return Sets the farthest zoom of the map
     */
    int minZoom() default 16;

    /**
     * Sets the closest zoom of the map
     * @return Sets the closest zoom of the map
     */
    int maxZoom() default 8;

    /**
     * Sets the default position of the hotel (Longitude) (Default: 96.1320)
     * @return Sets the default position of the hotel (Longitude)
     */
    double hotelLon() default 96.1320;
    /**
     * Sets the default position of the hotel (Latitude) (Default: 16.8201)
     * @return Sets the default position of the hotel (Latitude)
     */
    double hotelLat() default 16.8201;

    /**
     * Sets the northern border of the map (Default: 14.6558384256)
     * @return Sets the northern border of the map
     */
    double nBorder() default 14.6558384256;
    /**
     * Sets the southern border of the map (Default: 14.4714167622)
     * @return Sets the southern border of the map
     */
    double sBorder() default 14.4714167622;
    /**
     * Sets the eastern border of the map (Default: 121.0796356201)
     * @return Sets the eastern border of the map
     */
    double eBorder() default 121.0796356201;
    /**
     * Sets the western border of the map (Default: 120.9539794922)
     * @return Sets the western border of the map
     */
    double wBorder() default 120.9539794922;

}
