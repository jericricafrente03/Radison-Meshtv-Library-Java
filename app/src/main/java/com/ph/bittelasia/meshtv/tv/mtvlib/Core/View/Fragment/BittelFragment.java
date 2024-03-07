package com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Manager.MeshAnnotationManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.DataSetting;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.Layout;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.MeshTVAirmediaListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.MeshTVPIPListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.BroadcastListeners.MeshTVPackageListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshNotificationListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshTVFragmentListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshConfigListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshGuestListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Control.Listener.MeshWeatherListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshConfig;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshGuest;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshWeatherLocal;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.Broadcast.MeshTVBroadcaster;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Query.MeshValuePair;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Bill.MeshBillV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshEPG;
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
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Music.MeshMusic;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Music.MeshMusicCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RoomType.MeshRoomType;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Statistics.MeshStat;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStream;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStreamCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Tag.MeshTag;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackageChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshSubscriber;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshSubscription;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshGenre;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast;

import java.lang.reflect.Method;
import java.util.ArrayList;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Base class of all {@link MeshTVFragment MeshTVFragment}s. Works like a regular Fragment but has a lot of
 * additional features for faster development.
 * <br>
 * <br>Requires:
 * <br>1. {@link Layout Layout}
 * <br>2. {@link DataSetting DataSetting}
 * <br>
 * <br>Supports:
 * <br>1. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Init Init}
 * <br>2. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Terminate Terminate}
 * <br>3. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimedMethod}
 * <br>4. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Widget.BindWidget BindWidget}
 * <br>
 * <br>Listens to:
 * <br>1. {@link MeshTVPIPListener MeshTVPIPListener}
 * <br>2. {@link MeshTVAirmediaListener MeshTVAirmediaListener}
 * <br>3. {@link MeshTVPackageListener MeshTVPackageListener}
 * <br>4. {@link MeshTVFragmentListener MeshTVFragmentListener}
 * @param <T> Class of object to be displayed in the Fragment, omit to use a generic Object.
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
abstract class BittelFragment<T> extends Fragment
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = "Mars-"+BittelFragment.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Annotation---------------------------------------
    /**
     * Layout to be inflated by the Fragment
     */
    Layout layout = null;
    /**
     * Sets what data the Fragment will be listening to
     */
    DataSetting dataSetting = null;
    /**
     * List of all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Init Init} annotated Methods
     */
    private ArrayList<Method> initMethods;
    /**
     * List of all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Terminate Terminate} annotated Methods
     */
    private ArrayList<Method> termMethods;
    /**
     * List of all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimedMethod} annotated Methods
     */
    private ArrayList<Method> timedMethods;
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------View-----------------------------------------
    /**
     * Reference to the inflated view
     */
    View v;
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    /**
     * Selected item
     */
    T item = null;
    /**
     * Index of selected item
     */
    int selectedIndex = -1;
    /**
     * List of all items to be displayed
     */
    ArrayList<T> items = null;
    /**
     * Handler used to display all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimeMethod} annotated methods
     */
    Handler h;
    /**
     * Reference to the Realm
     */
    Realm r = null;
    /**
     * If not null the Activity could listen to {@link MeshTVPIPListener MeshTVPIPListener} events
     */
    private BroadcastReceiver pipReceiver = null;
    /**
     * If not null the Activity could listen to {@link MeshTVAirmediaListener MeshTVAirmediaListener} events
     */
    private BroadcastReceiver airmediaReceiver = null;
    /**
     * If not null the Activity could listen to {@link MeshTVPackageListener MeshTVPackageListener} events
     */
    private BroadcastReceiver packageReceiver = null;
    /**
     * Reference to all RealmObjects being listened to
     */
    ArrayList< RealmResults<RealmObject>> listeners;
    /**
     * If the parent Activity implements {@link MeshTVFragmentListener MeshTVFragmentListener} will trigger events as call back
     */
    MeshTVFragmentListener fragmentListener = null;
    /**
     * {@link MeshValuePair MeshValuePair} used to filter lists
     */
    MeshValuePair valuePair;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================LifeCycle========================================

    /**
     * Tasks:
     * <br>See if the Parent Activity implements {@link MeshTVFragmentListener MeshTVFragmentListener} if yes
     * sets a reference for it using {@link #fragmentListener fragmentListener}
     * @param context
     */
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if(getActivity() instanceof MeshTVFragmentListener)
        {
            fragmentListener = (MeshTVFragmentListener) getActivity();
        }
    }
    /**
     *
     * Tasks:
     * <br>See if the Parent Activity implements {@link MeshTVFragmentListener MeshTVFragmentListener} if yes
     * sets a reference for it using {@link #fragmentListener fragmentListener}
     * @param activity
     *
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(getActivity() instanceof MeshTVFragmentListener)
        {
            fragmentListener = (MeshTVFragmentListener) getActivity();
        }
    }
    /**
     * Tasks:
     * <br>Invokes {@link #init()} init()} method
     * @param savedInstanceState
     */
    @Override
    public final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    /**
     * Inflates the fragment using the value of {@link #layout layout} as the Layout Resource ID
     * @return view inflated
     */
    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        if(layout!=null)
        {
            v = inflater.inflate(layout.value(),container,false);
        }
        else
        {
            v = inflater.inflate(getLayout(),container,false);
        }

        return v;
    }


    /**
     * Tasks:
     * <br>1. Start all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimeMethod} annotated methods
     * <br>2. Start Listening to implemented listeners:
     * <br>- {@link MeshConfigListener MeshConfigListener}
     * <br>- {@link MeshWeatherListener MeshWeatherListener}
     * <br>- {@link MeshGuestListener MeshGuestListener}
     * <br>- {@link MeshTVPIPListener MeshTVPIPListener}
     * <br>- {@link MeshTVAirmediaListener MeshTVAirmediaListener}
     * <br>- {@link MeshTVPackageListener MeshTVPackageListener}
     */
    @Override
    public void onResume() {
        super.onResume();
        h = new Handler();
        MeshAnnotationManager.startTimedMethods(timedMethods, h, this);
        listen();
        if (this instanceof MeshGuestListener||this instanceof MeshConfigListener||this instanceof MeshWeatherListener||this instanceof MeshNotificationListener)
        {
            MeshTVApp.get().addListener(this);
        }
        if(this instanceof MeshConfigListener)
        {
            new MeshConfig().display();
        }
        if(this instanceof MeshWeatherListener)
        {
            new MeshWeatherLocal().display();
        }
        if(this instanceof MeshGuestListener)
        {
            new MeshGuest().display();
        }
        if(this instanceof MeshTVPIPListener)
        {
            MeshTVPIPListener listener = (MeshTVPIPListener) this;
            pipReceiver = MeshTVBroadcaster.listenToPIPReady(getActivity(),listener);
        }
        if(this instanceof MeshTVAirmediaListener)
        {
            MeshTVAirmediaListener listener = (MeshTVAirmediaListener)this;
            airmediaReceiver = MeshTVBroadcaster.listenToAirmedia(getActivity(),listener);
        }
        if(this instanceof MeshTVAirmediaListener)
        {
            MeshTVPackageListener listener = (MeshTVPackageListener)this;
            packageReceiver = MeshTVBroadcaster.listenToPackages(getActivity(),listener);
        }
    }
    /**
     * Tasks:
     * <br>1. Stops all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimeMethod} annotated methods
     * <br>2. Stop Listening to implemented listeners:
     * <br>- {@link MeshConfigListener MeshConfigListener}
     * <br>- {@link MeshWeatherListener MeshWeatherListener}
     * <br>- {@link MeshGuestListener MeshGuestListener}
     * <br>- {@link MeshTVPIPListener MeshTVPIPListener}
     * <br>- {@link MeshTVAirmediaListener MeshTVAirmediaListener}
     * <br>- {@link MeshTVPackageListener MeshTVPackageListener}
     */
    @Override
    public void onPause()
    {
        super.onPause();
        MeshAnnotationManager.stopTimedMethods(h);
        ignore();
        if (this instanceof MeshGuestListener||this instanceof MeshConfigListener||this instanceof MeshWeatherListener||this instanceof MeshNotificationListener)
        {
            MeshTVApp.get().removeListener(this);
        }
        if(pipReceiver!=null)
        {
            MeshTVBroadcaster.ignore(getActivity(),pipReceiver);
        }
        if(airmediaReceiver!=null)
        {
            MeshTVBroadcaster.ignore(getActivity(),airmediaReceiver);
        }
        if(packageReceiver!=null)
        {
            MeshTVBroadcaster.ignore(getActivity(),packageReceiver);
        }

    }

    /**
     *Task:
     *<br>1. Reference all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Widget.BindWidget BindWidget} annotated widgets
     *<br>2. Trigger {@link #draw(View) draw(View)} method to bind objects to the view
     */
    @Override
    public final void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MeshAnnotationManager.bindWidgets(this);
        draw(view);
    }

    /**
     *Task:
     *<br>1. Invoke {@link #terminate() terminate()} method
     */
    @Override
    public final void onDestroy() {
        super.onDestroy();
        terminate();
    }

    /**
     * Removes reference to the Parent Activity
     */
    @Override
    public void onDetach() {
        super.onDetach();
        if(getActivity() instanceof MeshTVFragmentListener)
        {
            fragmentListener = null;
        }
    }
    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Action------------------------------------------
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Init-------------------------------------------
    /**
     * Initializes the {@link MeshTVFragment MeshTVFragment}
     * <br>Steps:
     * <br>1. Make reference with the required {@link Layout Layout} annotation
     * <br>2. Retrieves all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Init Init} annotated methods
     * <br>3. Retrieves all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Terminate Terminate} annotated methods
     * <br>4. Retrieves all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimedMethod} annotated methods
     * <br>5. Runs all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event.Init Init} annotated methods
     */
    private final void init()
    {
        valuePair = new MeshValuePair("new","new");
        layout = getClass().getAnnotation(Layout.class);
//        if(layout==null)
//        {
//            throw new BittelFragmentException(TAG+": Layout Annotation is required");
//        }
        listeners = new ArrayList<>();
        initMethods = new ArrayList<>();
        initMethods.addAll(MeshAnnotationManager.getInit(getClass()));
        termMethods = new ArrayList<>();
        termMethods.addAll(MeshAnnotationManager.getTerminate(getClass()));
        timedMethods = new ArrayList<>();
        timedMethods.addAll(MeshAnnotationManager.getTimed(getClass()));
        MeshAnnotationManager.runMethods(initMethods,this);
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Getter------------------------------------------

    /**
     * Retrieves {@link #fragmentListener fragmentListenr}
     * @return {@link #fragmentListener fragmentListenr}
     */
    public MeshTVFragmentListener getFragmentListener() {
        return fragmentListener;
    }
    /**
     * Retrieves {@link #v v}
     * @return {@link #v v}
     */
    final View getV() {
        return v;
    }
    /**
     * Retrieves {@link #item item}
     * @return {@link #item item}
     */
    final T getItem() {
        return item;
    }
    /**
     * Retrieves {@link #selectedIndex selectedIndex}
     * @return {@link #selectedIndex selectedIndex}
     */
    final int getSelectedIndex() {
        return selectedIndex;
    }
    /**
     * Retrieves {@link #items items}
     * @return {@link #items items}
     */
    final ArrayList<T> getItems() {
        return items;
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Setter------------------------------------------
    final void setItem(T item)
    {
        this.item = item;
        update(this.item);
    }
    final void setItems(ArrayList<T> items)
    {
        this.items=new ArrayList<>();
        this.items.addAll(items);
        update(this.items);
    }

   final void setValuePair(MeshValuePair valuePair) {
        this.valuePair = valuePair;
        forceUpdate();
    }

    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Action--------------------------------------------

    /**
     * Clears all items and trigger {@link #onClear() onClear()} method
     */
    final void clear()
    {
        items.clear();
        item = null;
        onClear();
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Terminate------------------------------------------

    /**
     * Terminates all {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod TimedMethod}s
     */
    private final void terminate()
    {
        Log.i(TAG,"terminate()");
        Log.i(TAG,"Terminating Fragment");
        MeshAnnotationManager.runMethods(termMethods,this);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Realm===========================================

    /**
     * Processes {@link #dataSetting dataSetting} to listen to selected Objects
     */
    private final void listen()
    {
        listeners = new ArrayList<>();
        dataSetting = getClass().getAnnotation(DataSetting.class);
        if(dataSetting!=null)
        {
            r = Realm.getDefaultInstance();
            if(dataSetting.listenToBills())
            {
                listenTo(MeshBillV2.class);
            }
            if(dataSetting.listenToChannels())
            {
                listenTo(MeshChannel.class);
            }
            if(dataSetting.listenToChannelCategories())
            {
                listenTo(MeshChannelCategory.class);
            }
            if(dataSetting.listenToConciergeCategory())
            {
                listenTo(MeshConciergeCategory.class);
            }
            if(dataSetting.listenToConciergeItem())
            {
                listenTo(MeshConciergeRequestItem.class);
            }
            if(dataSetting.listenToConciergeServices())
            {
                listenTo(MeshConciergeRequestService.class);
            }
            if(dataSetting.listenToFood())
            {
                listenTo(MeshFood.class);
            }
            if(dataSetting.listenToFoodCategory())
            {
                listenTo(MeshFoodCategory.class);
            }
            if(dataSetting.listenToFacility())
            {
                listenTo(MeshFacility.class);
            }
            if(dataSetting.listenToFacilityCategory())
            {
                listenTo(MeshFacilityCategory.class);
            }
            if(dataSetting.listenToAirport())
            {
                listenTo(MeshAirport.class);
            }
            if(dataSetting.listenToDepartureFlight())
            {
                listenTo(MeshDepartureFlight.class);
            }
            if(dataSetting.listenToArrivalFlight())
            {
                listenTo(MeshArrivalFlight.class);
            }
            if(dataSetting.listenToCity())
            {
                listenTo(MeshCity.class);
            }
            if(dataSetting.listenToContinent())
            {
                listenTo(MeshContinent.class);
            }
            if(dataSetting.listenToMessage())
            {
                listenTo(MeshMessage.class);
            }
            if(dataSetting.listenToMusic())
            {
                listenTo(MeshMusic.class);
            }
            if(dataSetting.listenToMusicCategory())
            {
                listenTo(MeshMusicCategory.class);
            }
            if(dataSetting.listenToRoomType())
            {
                listenTo(MeshRoomType.class);
            }
            if(dataSetting.listenToShoppingCategory())
            {
                listenTo(MeshShoppingCategory.class);
            }
            if(dataSetting.listenToShoppingItem())
            {
                listenTo(MeshShoppingItem.class);
            }
            if(dataSetting.listenToStatistics())
            {
                listenTo(MeshStat.class);
            }
            if(dataSetting.listenToStream())
            {
                listenTo(MeshStream.class);
            }
            if(dataSetting.listenToStreamCategory())
            {
                listenTo(MeshStreamCategory.class);
            }
            if(dataSetting.listenToTag())
            {
                listenTo(MeshTag.class);
            }
            if(dataSetting.listenToVC())
            {
                listenTo(MeshVC.class);
            }
            if(dataSetting.listenToVCCategory())
            {
                listenTo(MeshVCCategory.class);
            }
            if(dataSetting.listenToVOD())
            {
                listenTo(MeshVOD.class);
            }
            if(dataSetting.listenToWeatherV2())
            {
                listenTo(MeshWeatherV2.class);
            }
            if(dataSetting.listenToWeatherForecast())
            {
                listenTo(MeshWeatherForecast.class);
            }
            if(dataSetting.listenToGenre())
            {
                listenTo(MeshGenre.class);
            }
            if(dataSetting.listenToSubscriber())
            {
                listenTo(MeshSubscriber.class);
            }
            if(dataSetting.listenToSubscription())
            {
                listenTo(MeshSubscription.class);
            }
            if(dataSetting.listenToPackages())
            {
                listenTo(MeshPackage.class);
            }

            if(dataSetting.listenToChannelPackages())
            {
                listenTo(MeshPackageChannel.class);
            }

            if(dataSetting.listenToEPG())
            {
                listenTo(MeshEPG.class);
            }
        }

    }

    /**
     * Explicitly listen to an object by sending its Class
     * @param c Class to listen to
     */
    private final void listenTo(final Class c)
    {
        Log.i(TAG,"Listening To:"+c.getSimpleName());
        RealmQuery<RealmObject> query = r.where(c);
        RealmResults<RealmObject> results = query.findAllAsync();
        listeners.add(results);
        results.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<RealmObject>>()
        {
            @Override
            public void onChange(RealmResults<RealmObject> collection, OrderedCollectionChangeSet changeSet)
            {
                Log.i(TAG,"Updating:"+c.getSimpleName());
                Log.i(TAG,"Collection:"+collection.size());
                if(changeSet!=null)
                {
                    Log.i(TAG,"Change Detected");
                    if(changeSet.getInsertions()!=null)
                    {
                        for(int i:changeSet.getInsertions())
                        {
                            Log.i(TAG,"Something was Inserted");
                            onInsert(collection.get(i));
                        }
                    }
                    if(changeSet.getDeletions()!=null)
                    {
                        for(int i:changeSet.getDeletions())
                        {
                            Log.i(TAG,"Something was Deleted");
                            onDelete(i);
                        }
                    }
                    if(changeSet.getChanges()!=null)
                    {
                        for(int i:changeSet.getChanges())
                        {
                            Log.i(TAG,"Something was Updated");
                            onUpdate(collection.get(i),i);
                        }
                    }
                }
                if(collection.size()==0)
                {
                    Log.i(TAG,"No Data Found");
                    onNoData(c);
                }

            }
        });
    }

    /**
     * Clears all listeners
     */
    private void ignore()
    {
        for (RealmResults l : listeners)
        {
            l.removeAllChangeListeners();
        }
        listeners.clear();
        if(r!=null)
        {
            r.close();
        }
    }
    //==============================================================================================
    //=============================================Abstract=========================================

    /**
     * Triggered when the view has been inflated
     * @param v inflated view
     */
    abstract void draw(View v);

    /**
     * Triggered when an item was updated
     * @param item updated item
     */
    protected abstract void update(T item);
    /**
     * Triggered when an array of items was updated
     * @param items updated items
     */
    abstract void update(ArrayList<T> items);
    /**
     * Triggered when an new item that is being listened to gets inserted
     * @param o inserted item
     */
    abstract void onInsert(Object o);
    /**
     * Triggered when an item that is being listened to gets updated
     * @param o updated item
     */
    abstract void onUpdate(Object o,int index);
    /**
     * Triggered when an item that is being listened to gets deleted
     * @param index index of  item
     */
    abstract void onDelete(int index);
    /**
     * Triggered when an item that is being listened to gets cleared
\     */
    abstract void onClear();
    /**
     * Triggered when an item that is being listened returns no data
     * @param c Class of item
     */
    abstract void onNoData(Class c);

    abstract void forceUpdate();
    public abstract int getLayout();
    //==============================================================================================
    //============================================Exception=========================================
    /**
     * Exception thrown when some instance of {@link MeshTVFragment MeshTVFragment} misses some or all of the required settings
     */
    private static final class BittelFragmentException extends RuntimeException
    {
        private BittelFragmentException(String message)
        {
            super(message);
        }
    }
    //==============================================================================================

}
