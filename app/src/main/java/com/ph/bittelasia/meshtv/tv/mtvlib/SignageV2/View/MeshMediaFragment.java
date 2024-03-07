package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.View;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Exoplayer.MeshTVPlayerSettings;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.DataSetting;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Data.Control.Listener.MeshDataListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshConfigListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshWeatherListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshConfig;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshWeatherLocal;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.ResourceManager.MeshResourceManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Query.MeshValuePair;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.CustomView.CustomScrollingTextView.MeshTVScrollingContinuousTextView;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.ExoPlayer.Control.MeshTVExoPlayerManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.ExoPlayer.Control.MeshTVPlayerFactory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshRealmManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Control.SignagePreference;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.Control.MediaFragmentSetting;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.Control.MeshVideoManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaZone;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaZoneAssignment;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshScrollingMessage;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

@DataSetting()
public abstract class MeshMediaFragment extends MeshTVFragment<MeshMediaV2>
        implements
        MeshDataListener
        ,MeshRealmListener
        ,MeshWeatherListener
        ,MeshConfigListener
{
    //========================================MeshWeatherListener===================================
    public void onUpdateForWeather(MeshWeatherLocal weatherLocal)
    {
        if(iv_icon!=null)
        {
            setIcon(iv_icon,weatherLocal.getIcon());
        }
        if(tv_temperature!=null)
        {
            setTemperature(tv_temperature,weatherLocal.getTemp_cur());
        }
        if(tv_weather_description!=null)
        {
            setWeatherDescription(tv_weather_description,weatherLocal.getDescription());
        }
        if(tv_humidity!=null)
        {
            setHumidity(tv_humidity,weatherLocal.getHumidity());
        }
    }
    public void setIcon(ImageView iv_icon,String url)
    {
        MeshResourceManager.displayLiveImageFor(getActivity(),iv_icon,url);

    }
    public void setTemperature(TextView tv_temperature,float temp)
    {
        tv_temperature.setText(temp+" °C");
    }
    public void setWeatherDescription(TextView tv_description,String description)
    {
        tv_description.setText(description);
    }
    public void setHumidity(TextView tv_humidity,float humidity)
    {
        tv_humidity.setText(humidity+"");
    }
    public void setWindSpeed()
    {

    }
    //==============================================================================================
    //=========================================MeshConfigListener===================================
    public void onHotelConfigurationChange(MeshConfig config)
    {
        MeshValuePair vp = new MeshValuePair(MeshWeatherV2.TAG_COUNTRY,config.getHotel_country());
        MeshRealmManager.retrieve(MeshWeatherV2.class,this,vp);
    }
    //==============================================================================================
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG                  = MeshMediaFragment.class.getSimpleName();

    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Comparator----------------------------------------
    Comparator<MeshTVFeed> comparator = new Comparator<MeshTVFeed>() {
        @Override
        public int compare(MeshTVFeed o1, MeshTVFeed o2) {
            return o1.getGroup_order()>o2.getGroup_order()?1:-1;
        }
    };
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------View-------------------------------------------
    SimpleExoPlayerView exoPlayerView;
    ImageView iv_image;
    TextView tv_date;
    ListView lv_list;
    TextClock tc_clock;

    ImageView iv_icon;
    TextView tv_temperature;
    TextView tv_weather_description;
    TextView tv_humidity;
    TextView tv_wind_speed;

    MeshTVScrollingContinuousTextView scrollingTextView;
    View blocker;
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    MediaFragmentSetting setting = null;
    MeshTVPlayerSettings playerSetting = null;
    boolean isDrawn = false;
    boolean isFirst = true;
    protected int zone = -1;
    String url;
    SimpleExoPlayer exoPlayer = null;
    MeshMediaV2 selected;
    int ctr = 0;
    MeshMediaZoneAssignment zoneAssignment = null;
    ArrayList<MeshMediaZone> meadiaZone = null;
    ArrayList<MeshMediaV2> mediaList = null;
    Handler handler = null;
    Runnable runnable = new Runnable() {
        @Override
        public void run()
        {

            reset();
            if(ctr>=mediaList.size())
            {
                ctr = 0;
            }
            Log.i(TAG,"061418 - Media - Handler: "+ctr);
            Log.i(TAG,"061418 - Media - MediaList: "+mediaList.size());
            if(mediaList.size()>0)
            {
                selected = mediaList.get(ctr);
                if(selected!=null)
                {
                    Log.i(TAG,"061418 - Media - Selected Name: "+selected.getName());
                    Log.i(TAG,"061418 - Media - Selected URL: "+selected.getUrl());
                }

                if(selected==null)
                {
                    ctr = 0;
                    selected = mediaList.get(ctr);
                }
                try
                {
                    if(selected!=null)
                    {
                        Log.i(TAG,"Play Media: ================================================================");
                        Log.i(TAG,"Play Media ID:"+selected.getId());
                        Log.i(TAG,"Play Media Type ID:"+selected.getType_id());
                        Log.i(TAG,"Play Media Layout ID:"+selected.getLayout_id());
                        Log.i(TAG,"Play Media Orientation:"+selected.getOrientation());
                        Log.i(TAG,"Play Media Group ID:"+selected.getGroup_id());
                        Log.i(TAG,"Play Media URL:"+selected.getUrl());
                        Log.i(TAG,"Play Media: ================================================================");
                        switch (selected.getType_id()) {
                            case MeshType.TYPE_IMAGE:
                                if (iv_image != null) {
                                    Log.i(TAG, "Image View found");
                                    iv_image.setVisibility(View.VISIBLE);
                                    try {
                                        MeshResourceManager.displayLiveImageFor(getActivity(), iv_image, selected.getUrl());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    Log.i(TAG, "Image View is null");
                                }
                                ctr++;
                                handler.postDelayed(this, SignagePreference.getDelay() * 1000);
                                break;
                            case MeshType.TYPE_VIDEO:
                                if (exoPlayerView != null) {
                                    exoPlayerView.setVisibility(View.VISIBLE);
                                    playMedia(selected);
                                }
                                ctr++;
                                break;
                            case MeshType.TYPE_SCROLL:
                                if (exoPlayerView != null) {
                                    exoPlayerView.setVisibility(View.VISIBLE);
                                    playMedia(selected);
                                }
                                ctr++;
                                break;
                            case MeshType.TYPE_FEED:
                                reset();
                                MeshSignageActivity sa = (MeshSignageActivity)getActivity();
                                if (sa!=null)
                                {
                                    sa.attachSpecialFragment(zoneAssignment,selected);
                                }

                                break;
                            case MeshType.TYPE_TIME:
                                reset();
                                MeshSignageActivity sa2 = (MeshSignageActivity)getActivity();
                                if (sa2!=null)
                                {
                                    sa2.attachSpecialFragment(zoneAssignment,selected);
                                }
                                break;
                            case MeshType.TYPE_WEATHER:
                                reset();
                                MeshSignageActivity sa3 = (MeshSignageActivity)getActivity();
                                if (sa3!=null)
                                {
                                    sa3.attachSpecialFragment(zoneAssignment,selected);
                                }
                                break;
                            case MeshType.TYPE_WEATHER_FORECAST:
                                reset();
                                MeshSignageActivity sa4 = (MeshSignageActivity)getActivity();
                                if (sa4!=null)
                                {
                                    sa4.attachSpecialFragment(zoneAssignment,selected);
                                }
                                break;
                            default:
                                handler.postDelayed(this, SignagePreference.getDelay()*1000);
                                break;
                        }

                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }



        }
    };
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================LifeCycle=======================================
    @Override
    public void onPause()
    {
        super.onPause();
        stopExo();
        if(handler!=null)
        {
            try
            {
                handler.post(runnable);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(handler!=null)
        {
            try
            {
                handler.post(runnable);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    //==============================================================================================
    //===============================================Method=========================================
    //-----------------------------------------------Action-----------------------------------------
    final void stopExo()
    {
        if(exoPlayer!=null)
        {
            exoPlayer.stop();
        }
    }
    public final void setZone(MeshMediaZoneAssignment zoneAssignment)
    {
        boolean load = false;
        if(this.zoneAssignment!=null)
        {
            zone = zoneAssignment.getZone();
            if
                    (
                            this.zoneAssignment.getId()!=zoneAssignment.getId()
                            ||this.zoneAssignment.getLayout_id()!=zoneAssignment.getLayout_id()
                            ||this.zoneAssignment.getSignage_id()!=zoneAssignment.getSignage_id()
                            ||this.zoneAssignment.getZone()!=zoneAssignment.getSignage_id()
                    )
            {
                load = true;
            }
            else
            {
                if(isFirst)
                {
                    load = true;
                }
            }
        }
        else
        {
            this.zoneAssignment = zoneAssignment;
            if(isDrawn)
            {
                load = true;
            }
        }
        if(load)
        {
            this.zoneAssignment = zoneAssignment;
            Log.i(TAG,"061418 - Zone Assignment: ======================================================= "+toString());
            Log.i(TAG,"061418 - Zone Assignment - ID:"+zoneAssignment.getId()+" for@"+toString());
            Log.i(TAG,"061418 - Zone Assignment - Zone:"+zoneAssignment.getZone()+" for@"+toString());
            Log.i(TAG,"061418 - Zone Assignment - Signage ID:"+zoneAssignment.getSignage_id()+" for@"+toString());
            Log.i(TAG,"061418 - Zone Assignment - Layout ID:"+zoneAssignment.getLayout_id()+" for@"+toString());
            Log.i(TAG,"061418 - Zone Assignment: ======================================================= "+toString());
            if(isDrawn)
            {
                meadiaZone = new ArrayList<>();
                mediaList = new ArrayList<>();
                MeshValuePair vp = new MeshValuePair(MeshMediaZone.TAG_ZONE_ID,this.zoneAssignment.getId());
                MeshRealmManager.retrieve(
                        MeshMediaZone.class,
                        new MeshRealmListener()
                        {
                            @Override
                            public void onRetrieved(Class aClass, ArrayList<Object> arrayList)
                            {
                                if(aClass==MeshMediaZone.class)
                                {
                                    for(Object o:arrayList)
                                    {
                                        meadiaZone.add((MeshMediaZone)o);
                                    }
                                    MeshValuePair[] mediaValuePair = new MeshValuePair[meadiaZone.size()];
                                    int vpCtr = 0;
                                    for(MeshMediaZone mz : meadiaZone)
                                    {
                                        Log.i(TAG,"061418 - Zone Assignment: ======================================================= "+toString());
                                        Log.i(TAG,"061418 - Zone Assignment - ID:"+mz.getId()+" for@"+toString());
                                        Log.i(TAG,"061418 - Zone Assignment - Zone ID:"+mz.getZone_id()+" for@"+toString());
                                        Log.i(TAG,"061418 - Zone Assignment - Media ID:"+mz.getMedia_id()+" for@"+toString());
                                        Log.i(TAG,"061418 - Zone Assignment - Signage ID:"+mz.getSignage_id()+" for@"+toString());
                                        Log.i(TAG,"061418 - Zone Assignment: ======================================================= "+toString());
                                        MeshValuePair valuePair = new MeshValuePair(MeshMediaV2.TAG_ID,mz.getMedia_id());
                                        valuePair.setString(false);
                                        mediaValuePair[vpCtr] = valuePair;
                                        vpCtr++;
                                    }
                                    MeshRealmManager.retrieveOR(MeshMediaV2.class, new MeshRealmListener()
                                    {
                                        @Override
                                        public void onRetrieved(Class aClass, ArrayList<Object> arrayList)
                                        {
                                            if(aClass==MeshMediaV2.class)
                                            {
                                                MeshSignageActivity activity = null;
                                                try
                                                {
                                                    activity = (MeshSignageActivity)getActivity();
                                                }
                                                catch (Exception e)
                                                {
                                                    e.printStackTrace();
                                                }
                                                for(Object o:arrayList)
                                                {
                                                    MeshMediaV2 media = (MeshMediaV2) o;
                                                    Log.i(TAG,"061418 - Media: ======================================================= "+toString());
                                                    Log.i(TAG,"061418 - Media - ID:"+media.getId()+" for@"+toString());
                                                    Log.i(TAG,"061418 - Media - URL:"+media.getUrl()+" for@"+toString());
                                                    Log.i(TAG,"061418 - Media - Type ID:"+media.getType_id()+" for@"+toString());
                                                    Log.i(TAG,"061418 - Media - Layout ID:"+media.getLayout_id()+" for@"+toString());
                                                    Log.i(TAG,"061418 - Media - Group ID:"+media.getGroup_id()+" for@"+toString());
                                                    Log.i(TAG,"061418 - Media - Orientation:"+media.getOrientation()+" for@"+toString());
                                                    Log.i(TAG,"061418 - Media: ======================================================= "+toString());

                                                    boolean isToAdd = true;

                                                    if(isToAdd)
                                                    {
                                                        mediaList.add(media);
                                                    }

                                                }
                                                MeshVideoManager.get().clearVideos(new MeshVideoManager.DeleteListener() {
                                                    @Override
                                                    public void onAllFilesDeleted() {
                                                        ArrayList<String> urls = new ArrayList<>();
                                                        for(MeshMediaV2 mediaV2:mediaList)
                                                        {
                                                            urls.add(mediaV2.getUrl());
                                                        }
                                                        MeshVideoManager.get().downloadMultiple(new MeshVideoManager.DownloadMultipleListener()
                                                        {
                                                            @Override
                                                            public void onFilesDownloaded()
                                                            {
                                                                Log.i(TAG,"061418 - Media - Launching Handler");
                                                                handler = new Handler();
                                                                handler.post(runnable);
                                                            }
                                                        },urls);
                                                    }
                                                });

                                            }
                                        }
                                        @Override
                                        public void onFailed(Class aClass, String s) { }
                                        @Override
                                        public void onEmpty(Class aClass, String s) { }
                                        @Override
                                        public void onCleared(Class aClass) { }
                                    },mediaValuePair);

                                }
                            }
                            @Override
                            public void onFailed(Class aClass, String s) { }
                            @Override
                            public void onEmpty(Class aClass, String s) { }
                            @Override
                            public void onCleared(Class aClass) { }
                        },vp);
            }
        }

    }
    public final void playMedia(final MeshMediaV2 media)
    {

        Log.i(TAG,"Play Media: ================================================================");
        Log.i(TAG,"Play Media ID:"+media.getId());
        Log.i(TAG,"Play Media Type ID:"+media.getType_id());
        Log.i(TAG,"Play Media Layout ID:"+media.getLayout_id());
        Log.i(TAG,"Play Media Orientation:"+media.getOrientation());
        Log.i(TAG,"Play Media Group ID:"+media.getGroup_id());
        Log.i(TAG,"Play Media URL:"+media.getUrl());
        Log.i(TAG,"Play Media: ================================================================");

        try
        {
            reset();
            switch (media.getType_id())
            {

                case MeshType.TYPE_IMAGE:
                    if(iv_image!=null)
                    {
                        MeshResourceManager.displayLiveImageFor(getActivity(),iv_image,media.getUrl());
                        iv_image.setVisibility(View.VISIBLE);
                    }
                    break;
                case MeshType.TYPE_VIDEO:

                    if (exoPlayerView != null)
                    {
                        if(blocker!=null)
                        {
                            blocker.setVisibility(View.VISIBLE);
                        }

                        exoPlayerView.setVisibility(View.VISIBLE);
                        exoPlayer = MeshTVPlayerFactory.generateSimpleExoPlayer(getActivity());
                        exoPlayer.setPlayWhenReady(true);
                        exoPlayerView.setPlayer(exoPlayer);
                        exoPlayerView.setUseController(playerSetting.hasControls());
                        exoPlayer.addListener(new Player.EventListener() {
                            @Override
                            public void onTimelineChanged(Timeline timeline, @Nullable Object manifest, int reason) {

                            }

                            @Override
                            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

                            }

                            @Override
                            public void onLoadingChanged(boolean isLoading) {

                            }

                            @Override
                            public void onPlayerStateChanged(boolean playWhenReady, int playbackState)
                            {
                                if(playbackState==1)
                                {
                                    if(blocker!=null)
                                    {
                                        blocker.setVisibility(View.VISIBLE);

                                    }
                                }
                                else if(playbackState==2)
                                {
                                    if(blocker!=null)
                                    {
                                        blocker.setVisibility(View.GONE);

                                    }
                                }
                                else if(playbackState == 4)
                                {
                                    if(blocker!=null)
                                    {
                                        blocker.setVisibility(View.VISIBLE);
                                    }
                                    handler.post(runnable);
                                }
                            }

                            @Override
                            public void onIsPlayingChanged(boolean isPlaying) {

                            }

                            @Override
                            public void onRepeatModeChanged(int repeatMode)
                            {

                            }

                            @Override
                            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

                            }

                            @Override
                            public void onPlayerError(ExoPlaybackException error)
                            {

                            }

                            @Override
                            public void onPositionDiscontinuity(int reason) {

                            }
                            @Override
                            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

                            }

                            @Override
                            public void onSeekProcessed() {

                            }
                        });
                        if(media.getUrl()!=null)
                        {
                            String[] urlDivide = media.getUrl().split("/");
                            String local = "/storage/emulated/0/Android/"+urlDivide[urlDivide.length-1];
                            MeshTVExoPlayerManager.play(getActivity(),exoPlayer,"MARS",local);
                        }
                    }
                    break;
                case MeshType.TYPE_SCROLL:
                    break;
                case MeshType.TYPE_FEED:
                    ((MeshSignageActivity)getActivity()).attachSpecialFragment(zoneAssignment,media);
                    break;
                case MeshType.TYPE_WEATHER:
                    ((MeshSignageActivity)getActivity()).attachSpecialFragment(zoneAssignment,media);
                    break;
                case MeshType.TYPE_TIME:
                    reset();
                    ((MeshSignageActivity)getActivity()).attachSpecialFragment(zoneAssignment,media);
                    break;
                case MeshType.TYPE_WEATHER_FORECAST:
                    ((MeshSignageActivity)getActivity()).attachSpecialFragment(zoneAssignment,media);
                    break;
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    private final void reset()
    {
        if (exoPlayerView != null)
        {
            exoPlayerView.setVisibility(View.GONE);
            if(exoPlayer!=null)
            {
                exoPlayer.stop();
            }
        }
        if (iv_image != null)
        {
            iv_image.setVisibility(View.GONE);
        }
        if(blocker!=null)
        {
            blocker.setVisibility(View.GONE);
        }
        if(iv_icon!=null)
        {
            iv_icon.setVisibility(View.GONE);
        }
        if(tv_temperature!=null)
        {
            tv_temperature.setVisibility(View.GONE);
        }
        if(tv_weather_description!=null)
        {
            tv_weather_description.setVisibility(View.GONE);
        }
        if(tv_humidity!=null)
        {
            tv_humidity.setVisibility(View.GONE);
        }
        if(tv_wind_speed!=null)
        {
            tv_wind_speed.setVisibility(View.GONE);
        }
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Getter-----------------------------------------
    String getUrl() {
        return url;
    }
    public SimpleExoPlayerView getExoPlayerView() {
        return exoPlayerView;
    }
    public ImageView getIv_image() {
        return iv_image;
    }
    public TextView getTv_date() {
        return tv_date;
    }
    public ListView getLv_list() {
        return lv_list;
    }
    public TextClock getTc_clock() {
        return tc_clock;
    }
    public ImageView getIv_icon() {
        return iv_icon;
    }
    public TextView getTv_temperature() {
        return tv_temperature;
    }
    public TextView getTv_weather_description() {
        return tv_weather_description;
    }

    public TextView getTv_humidity() {
        return tv_humidity;
    }

    public TextView getTv_wind_speed() {
        return tv_wind_speed;
    }

    public MeshTVScrollingContinuousTextView getScrollingTextView() {
        return scrollingTextView;
    }

    public View getBlocker() {
        return blocker;
    }

    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Setter-----------------------------------------
    final void setUrl(String url)
    {
        this.url = url;
        if(exoPlayerView!=null&&exoPlayer!=null)
        {

            String[] urlDivide = url.split("/");
            String local = "/storage/emulated/0/Android/"+urlDivide[urlDivide.length-1];
            MeshTVExoPlayerManager.play(getActivity(),exoPlayer,"MARS",local);
        }
        else
        {
        }
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================MeshTVFragment=====================================
    @Override
    protected void onDrawDone(View view)
    {
        setting = getClass().getAnnotation(MediaFragmentSetting.class);
        playerSetting = getClass().getAnnotation(MeshTVPlayerSettings.class);
        mediaList = new ArrayList<>();
        if(playerSetting == null)
        {
            throw  new RuntimeException("MeshTVPlayerSettings is required.");
        }
        if(setting!=null) {
            if (setting.videoId() != -1) {
                exoPlayerView = (SimpleExoPlayerView) view.findViewById(setting.videoId());
            }
            if (setting.feedListId() != -1)
            {
                lv_list = (ListView) view.findViewById(setting.feedListId());
            }
            if(setting.imageId()!=-1)
            {
                iv_image = (ImageView) view.findViewById(setting.imageId());
            }
            if(setting.blockerId()!=-1)
            {
                blocker = view.findViewById(setting.blockerId());
            }
            if(setting.tickerId()!=-1)
            {
                scrollingTextView = (MeshTVScrollingContinuousTextView) view.findViewById(setting.tickerId());
                loadScrollingMessage();
            }
            if(setting.dateId()!=-1)
            {

                try
                {
                    tv_date = (TextView) view.findViewById(setting.dateId()) ;
                    SimpleDateFormat df = new SimpleDateFormat(setting.dateFormat());
                    tv_date.setText(df.format(new Date()));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            if(setting.timeId()!=-1)
            {
                tc_clock = (TextClock) view.findViewById(setting.timeId());
                tc_clock.setFormat12Hour(setting.timeFormat());
            }
            if(setting.weatherIconId()!=-1)
            {
                iv_icon = (ImageView)view.findViewById(setting.weatherIconId());
            }
            if(setting.weatherIconId()!=-1)
            {
                iv_icon = (ImageView)view.findViewById(setting.weatherIconId());
            }
            if(setting.temperatureId()!=-1)
            {
                tv_temperature = (TextView) view.findViewById(setting.temperatureId());
            }
            if(setting.weatherDescriptionId()!=-1)
            {
                tv_weather_description = (TextView) view.findViewById(setting.weatherDescriptionId());
            }
            if(setting.humidityId()!=-1)
            {
                tv_humidity = (TextView) view.findViewById(setting.humidityId());
            }
            if(setting.windSpeedId()!=-1)
            {
                tv_wind_speed = (TextView) view.findViewById(setting.windSpeedId());
            }
        }
        else
        {
            throw new RuntimeException("MediaFragmentSetting annotation is required");
        }
        isDrawn = true;
        if(zoneAssignment!=null)
        {
            setZone(zoneAssignment);
        }
    }
    public void loadScrollingMessage()
    {
        if(scrollingTextView!=null)
        {

            MeshValuePair vp =new MeshValuePair(MeshScrollingMessage.TAG_ZONE,zoneAssignment.getZone());
            MeshValuePair vp2 =new MeshValuePair(MeshScrollingMessage.TAG_SIGNAGE_ID,((MeshSignageActivity)getActivity()).getId());
            MeshRealmManager.retrieve(MeshScrollingMessage.class, new MeshRealmListener()
            {
                @Override
                public void onRetrieved(Class aClass, ArrayList<Object> arrayList)
                {
                    if(arrayList.size()>0)
                    {
                        MeshScrollingMessage msm = (MeshScrollingMessage)arrayList.get(0);
                        if(msm.getMessage().length()>0)
                        {
                            scrollingTextView.setVisibility(View.VISIBLE);
                            if(!scrollingTextView.getText().toString().equals(msm.getMessage()))
                            {
                                scrollingTextView.setText(msm.getMessage());
                            }
                        }
                        else
                        {
                            scrollingTextView.setVisibility(View.GONE);
                        }
                    }
                }
                @Override
                public void onFailed(Class aClass, String s)
                {
                    scrollingTextView.setVisibility(View.GONE);
                }
                @Override
                public void onEmpty(Class aClass, String s) {
                    scrollingTextView.setVisibility(View.GONE);
                }
                @Override
                public void onCleared(Class aClass) {
                    scrollingTextView.setVisibility(View.GONE);
                }
            },vp,vp2);
        }

    }
    public void loadScrollingMessage(MeshScrollingMessage meshScrollingMessage)
    {
        if(scrollingTextView!=null)
        {
            if(meshScrollingMessage.getSignage_id()==((MeshSignageActivity)getActivity()).getId())
            {
                if(meshScrollingMessage.getMessage().length()>0)
                {
                    if(!meshScrollingMessage.getMessage().equals(scrollingTextView.getText().toString()))
                    {
                        scrollingTextView.setVisibility(View.VISIBLE);
                        scrollingTextView.setText(meshScrollingMessage.getMessage());
                    }

                }
                else
                {
                    scrollingTextView.setVisibility(View.GONE);
                }
            }

        }

    }
    @Override
    protected final void onDataUpdated(ArrayList arrayList) {

    }
    @Override
    protected final void onNewData(Object o) {

    }
    @Override
    protected final void onDataUpdated(Object o, int i) {

    }
    @Override
    protected final void onDeleteData(int i) {

    }
    @Override
    protected final void onClearData() {

    }
    @Override
    protected final void onDataNotFound(Class aClass) {

    }
    @Override
    protected final void refresh() {

    }
    @Override
    protected final void update(MeshMediaV2 o) {

    }
    //==============================================================================================
    //========================================MeshFragmentListener==================================
    @Override
    public void onNoNetwork(Class aClass) {

    }
    @Override
    public void onNoData(Class aClass) {

    }
    @Override
    public void onParseFailed(Class aClass, String s) {

    }
    @Override
    public void onFileNotFound(Class aClass, String s) {

    }
    @Override
    public void onDataReceived(Class aClass, int i) {

    }
    //==============================================================================================
    //=========================================MeshRealmListener====================================
    @Override
    public void onRetrieved(Class aClass, ArrayList<Object> arrayList)
    {

    }
    @Override
    public void onFailed(Class aClass, String s)
    {

    }
    @Override
    public void onEmpty(Class aClass, String s)
    {

    }
    @Override
    public void onCleared(Class aClass)
    {

    }
    public abstract void displayList(ListView lv, ArrayList<MeshTVFeed> feeds, MeshMediaV2 media);
    //==============================================================================================
}
