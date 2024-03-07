package com.ph.bittelasia.meshtv.tv.mtvlib.OSM.View;

import android.os.Handler;
import android.view.View;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.OSM.MapSettings;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Manager.MeshTVPreferenceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.OSM.Control.MeshResourceProxy;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC;

import org.osmdroid.api.IMapController;


//import org.osmdroid.bonuspack.overlays.InfoWindow;
//import org.osmdroid.bonuspack.overlays.Marker;
import org.osmdroid.api.Marker;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;


abstract class BittelOSMFragment extends MeshTVFragment<MeshVC>
{
    //===============================================Variable=======================================
    //-----------------------------------------------Constant---------------------------------------
    public static final String TAG = BittelOSMFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Instance---------------------------------------
    MapSettings settings = null;
    MeshVC vc = null;
    boolean isMapFocused = false;
    IMapController controller;
    GeoPoint hotel;
    Marker marker = null;
    Handler handler;
    Runnable initMapRunnable = new Runnable() {
        @Override
        public void run() {
            focusOnHotel();
        }
    };
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------View-----------------------------------------
    MapView mapView = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================MeshTVFragment===================================
    @Override
    protected final void onDrawDone(View v)
    {
        this.handler = new Handler();
        this.settings = (MapSettings) this.getClass().getAnnotation(MapSettings.class);
        if(settings==null)
        {
            throw  new RuntimeException("MapSettings Annotation is required!");
        }
        mapView     = (MapView) v.findViewById(settings.mapViewId());
        MeshResourceProxy mResourceProxy = new MeshResourceProxy(getActivity().getApplicationContext());

        controller  = mapView.getController();
        if(mapView==null)
        {
            throw  new RuntimeException("MapView widget is required!");
        }
        else
        {
            initMap();
        }
        handler.postDelayed(initMapRunnable,3000);
        initHotelMarker();
        onMapDrawn(v);

    }
    //==============================================================================================
    //===============================================Method=========================================
    //------------------------------------------------Init------------------------------------------
    private void initMap()
    {
        hotel = new GeoPoint
                (settings.hotelLat(),
                        settings.hotelLon()
                );

        mapView.setMaxZoomLevel(8);
        mapView.setMinZoomLevel(16);
        mapView.setFocusable(true);
        mapView.setFocusableInTouchMode(true);
        mapView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                isMapFocused = b;
                if(b)
                {
                    onMapFocused();
                }
                else
                {
                    onMapNotFocused();
                }
            }
        });

        mapView.setTileSource(TileSourceFactory.MAPQUESTOSM);
//        mapView.setTileSource(
//                new XYTileSource("Mapnik", settings.minZoom(), settings.maxZoom(), 256, ".png", new String[]{}));
        mapView.setClickable(false);
        mapView.setBuiltInZoomControls(true);
        if(settings.defaultZoom()<settings.maxZoom()||settings.defaultZoom()>settings.minZoom())
        {
            throw  new RuntimeException("Zoom level should be in the range of "+settings.minZoom()+" to "
                    +settings.maxZoom());
        }
        mapView.setMaxZoomLevel(settings.maxZoom());
        mapView.setMinZoomLevel(settings.minZoom());
        mapView.getController().setZoom(settings.defaultZoom());
        mapView.setBuiltInZoomControls(true);
        mapView.setUseDataConnection(false);
        mapView.getOverlays().clear();
    }
    private void initHotelMarker()
    {
        if(mapView!=null)
        {
//            Marker marker = new Marker(mapView,new MeshResourceProxy(getActivity()));
//
//
//            marker.setPosition(hotel);
//
//            marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
//            marker.setIcon(getResources().getDrawable(settings.hotelIcon()));
//            marker.setTitle(MeshTVPreferenceManager.getHotelName(getActivity()));
//            marker.setIcon(getResources().getDrawable(settings.hotelIcon()));
//            mapView.getOverlays().add(marker);

        }
    }
    public void addMarkerToMap(MeshVC item)
    {
        try
        {
            if(mapView!=null)
            {
//                mapView.getOverlays().clear();
//                initHotelMarker();
//                GeoPoint mGeo = new GeoPoint(item.getLatitude(),item.getLongitude());
//                if(marker!=null)
//                {
//
//                    marker.closeInfoWindow();
//                }
//                marker = new Marker(mapView);
//                marker.setPosition(mGeo);
//                mapView.getController().setCenter(mGeo);
//                if(settings.markerIcon()>0)
//                {
//                    marker.setIcon(getResources().getDrawable(settings.markerIcon()));
//                }
//                marker.setInfoWindow(setInfoWindow(mapView,item));
//                marker.getInfoWindow().open(null, mGeo, 0, -50);
//                mapView.getOverlays().add(marker);


            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Getter-----------------------------------------
    public MapView getMapView() {
        return mapView;
    }
    public MeshVC getVc() {
        return vc;
    };

    public boolean isMapFocused() {
        return isMapFocused;
    }

    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Setter-----------------------------------------
    public void setVc(MeshVC vc) {
        this.vc = vc;
        addMarkerToMap(vc);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Navigation--------------------------------------
    public void focus()
    {
        if(mapView!=null)
        {
            mapView.requestFocus();
        }
    }
    public void focusOnHotel()
    {
        IMapController controller = mapView.getController();
        controller.setCenter(hotel);
        controller.zoomIn();
    }
    public void zoomIn()
    {
        if(mapView!=null)
        {
            IMapController controller = mapView.getController();
            controller.zoomIn();
        }
    }
    public void zoomOut()
    {
        if(mapView!=null)
        {
            IMapController controller = mapView.getController();
            controller.zoomOut();
        }
    }
    public void moveUp()
    {
        if(mapView!=null)
        {
            IMapController controller = mapView.getController();
            controller.scrollBy(0,-50);
        }
    }
    public void moveDown()
    {
        if(mapView!=null)
        {
            IMapController controller = mapView.getController();
            controller.scrollBy(0,50);
        }
    }
    public void moveLeft()
    {
        if(mapView!=null)
        {
            IMapController controller = mapView.getController();
            controller.scrollBy(-50,0);
        }
    }
    public void moveRight()
    {
        if(mapView!=null)
        {
            IMapController controller = mapView.getController();
            controller.scrollBy(50,0);
        }
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Abstract========================================
    public abstract void onMapDrawn(View v);
    public abstract void onMapFocused();
    public abstract void onMapNotFocused();
//    public abstract InfoWindow setInfoWindow(MapView mv, MeshVC vc);
    //==============================================================================================
}
