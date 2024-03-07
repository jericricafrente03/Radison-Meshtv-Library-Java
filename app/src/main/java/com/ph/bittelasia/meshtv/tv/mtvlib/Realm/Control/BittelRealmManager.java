package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control;

import android.os.Handler;
import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Settings.RealmEditorSettings;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshSubscriptionUpdateListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshConfig;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshGuest;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshIPTV;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Preference.Model.MeshWeatherLocal;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Query.MeshValuePair;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannelCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestService;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFood;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacility;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacilityCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshArrivalFlight;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Flight.MeshDepartureFlight;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshCity;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Geography.MeshContinent;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RealmItem.MeshRealmItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Request.MeshUpdateRequest;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStream;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Stream.MeshStreamCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshSubscription;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVC;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VC.MeshVCCategory;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshGenre;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Weather.MeshWeatherV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.WeatherForecast.MeshWeatherForecast;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaZone;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshMediaZoneAssignment;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshScrollingMessage;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshSignageV2;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshTVFeed;
import com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.MeshType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

class BittelRealmManager
{
    //===============================================Variable=======================================
    //-----------------------------------------------Constant---------------------------------------
    static final String TAG = "Mars-"+BittelRealmManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Static----------------------------------------
    static BittelRealmManager manager = null;
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Instance---------------------------------------
    ArrayList<MeshRealmItem> items = null;
    ArrayList<MeshRealmEventListener> listeners;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //================================================Static========================================
    static BittelRealmManager get()
    {
        if(manager == null)
        {
            manager = new BittelRealmManager();
        }
        return manager;
    }
    //==============================================================================================
    //==============================================Constructor=====================================
    private BittelRealmManager()
    {
        items = new ArrayList<>();
        listeners = new ArrayList<>();
    }
    //==============================================================================================
    //================================================Method========================================
    //------------------------------------------------Items-----------------------------------------
    public void add(RealmEditorSettings settings)
    {
        if(items==null)
        {
            items = new ArrayList<>();
        }
        if(settings.editConfig())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Config");
            i.setC(MeshConfig.class.getSimpleName());
            items.add(i);
        }
        if(settings.editGuest())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Guest");
            i.setC(MeshGuest.class.getSimpleName());
            items.add(i);
        }
        if(settings.editIPTV())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("IPTV");
            i.setC(MeshIPTV.class.getSimpleName());
            items.add(i);
        }
        if(settings.editArrivalFlight())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Arrival Flight");
            i.setC(MeshArrivalFlight.class.getSimpleName());
            items.add(i);
        }
        if(settings.editDepartureFlight())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Departure Flight");
            i.setC(MeshDepartureFlight.class.getSimpleName());
            items.add(i);
        }
        if(settings.editChannel())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Channel");
            i.setC(MeshChannel.class.getSimpleName());
            items.add(i);
        }
        if(settings.editChannelCategory())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Channel Category");
            i.setC(MeshChannelCategory.class.getSimpleName());
            items.add(i);
        }
        if(settings.editConciergeCategory())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Concierge Category");
            i.setC(MeshConciergeCategory.class.getSimpleName());
            items.add(i);
        }
        if(settings.editConciergeItem())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Concierge Item");
            i.setC(MeshConciergeRequestItem.class.getSimpleName());
            items.add(i);
        }
        if(settings.editConciergeService())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Concierge Service");
            i.setC(MeshConciergeRequestService.class.getSimpleName());
            items.add(i);
        }
        if(settings.editFood())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Food");
            i.setC(MeshFood.class.getSimpleName());
            items.add(i);
        }
        if(settings.editFoodCategory())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Food Category");
            i.setC(MeshFood.class.getSimpleName());
            items.add(i);
        }
        if(settings.editFacility())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Facility");
            i.setC(MeshFacility.class.getSimpleName());
            items.add(i);
        }
        if(settings.editFacilityCategory())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Facility Category");
            i.setC(MeshFacilityCategory.class.getSimpleName());
            items.add(i);
        }
        if(settings.editCity())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("City");
            i.setC(MeshCity.class.getSimpleName());
            items.add(i);
        }
        if(settings.editContinent())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Continent");
            i.setC(MeshContinent.class.getSimpleName());
            items.add(i);
        }
        if(settings.editMessage())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Message");
            i.setC(MeshMessage.class.getSimpleName());
            items.add(i);
        }
        if(settings.editShopping())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Shopping");
            i.setC(MeshShoppingItem.class.getSimpleName());
            items.add(i);
        }
        if(settings.editShoppingCategory())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Shopping Category");
            i.setC(MeshShoppingCategory.class.getSimpleName());
            items.add(i);
        }
        if(settings.editStream())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Stream");
            i.setC(MeshStream.class.getSimpleName());
            items.add(i);
        }
        if(settings.editStream())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Stream Category");
            i.setC(MeshStreamCategory.class.getSimpleName());
            items.add(i);
        }
        if(settings.editVC())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Virtual Concierge");
            i.setC(MeshVC.class.getSimpleName());
            items.add(i);
        }
        if(settings.editVCCategory())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("VC Category");
            i.setC(MeshVCCategory.class.getSimpleName());
            items.add(i);
        }
        if(settings.editGenre())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Genre");
            i.setC(MeshGenre.class.getSimpleName());
            items.add(i);
        }
        if(settings.editVOD())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("VOD");
            i.setC(MeshVOD.class.getSimpleName());
            items.add(i);
        }
        if(settings.editWeatherForecast())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Forecast");
            i.setC(MeshWeatherForecast.class.getSimpleName());
            items.add(i);
        }
        if(settings.editWeather())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("Weather");
            i.setC(MeshWeatherLocal.class.getSimpleName());
            items.add(i);
        }
        if(settings.editWeatherV2())
        {
            MeshRealmItem i = new MeshRealmItem();
            i.setDisplayName("WeatherV2");
            i.setC(MeshWeatherV2.class.getSimpleName());
            items.add(i);
        }
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Getter----------------------------------------
    public ArrayList<MeshRealmItem> getItems() {
        return items;
    }
    //----------------------------------------------------------------------------------------------
    //------------------------------------------------Setter----------------------------------------
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------------CRUD-----------------------------------------
    final static void insert(final Object o)
    {
        final String uuid = UUID.randomUUID().toString();
        Log.i(TAG,"insert:"+o.getClass()+"("+uuid+")");
        Handler h = new Handler(MeshTVApp.get().getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final Realm r = Realm.getDefaultInstance();
                r.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.insertOrUpdate((RealmObject) o);

                    }
                }, new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        Log.i(TAG, "Inserted:" + o.getClass() + "(" + uuid + ")");
                        get().onCreate(o);
//                        r.close();
                    }
                }, new Realm.Transaction.OnError() {
                    @Override
                    public void onError(Throwable error) {
                        Log.i(TAG, "Failed to Insert:" + o.getClass() + "(" + uuid + ")");
                        Log.i(TAG, "Failed to Insert:" +error.getLocalizedMessage());
//                        r.close();
                    }
                });
            }
        };
        h.post(runnable);
    }




    final static void insertBulk(final ArrayList<Object> os)
    {
        final String uuid = UUID.randomUUID().toString();
        if(os!=null)
        {
            if(os.size()>0)
            {
                Log.i(TAG, "insertBulk:("+os.get(0).getClass()+") - "+os.size());

                Handler h = new Handler(MeshTVApp.get().getMainLooper());
                Runnable runnable = new Runnable()
                {
                    @Override
                    public void run() {
                        final Realm r = Realm.getDefaultInstance();
                        r.executeTransactionAsync(new Realm.Transaction()
                        {
                            @Override
                            public void execute(Realm realm)
                            {
                                Log.i(TAG, "Inserting...");
                                Object sample = os.get(0);
                                if(sample instanceof MeshScrollingMessage)
                                {
                                    Log.i(TAG, "insertBulk - detected MeshScrollingMessages");
                                    RealmResults<MeshScrollingMessage> scrollingMessages = realm.where(MeshScrollingMessage.class).findAll();
                                    Log.i(TAG, "insertBulk - Deleting:"+scrollingMessages.size());
                                    for(MeshScrollingMessage s:scrollingMessages)
                                    {
                                        s.deleteFromRealm();
                                    }
                                    Log.i(TAG, "insertBulk - Count:"+scrollingMessages.size());
                                }
                                if(sample instanceof MeshMediaV2)
                                {
                                    Log.i(TAG, "insertBulk - detected MeshMediaV2");
                                    RealmResults<MeshMediaV2> medias = realm.where(MeshMediaV2.class).findAll();
                                    Log.i(TAG, "insertBulk - Deleting:"+medias.size());
                                    for(MeshMediaV2 s:medias)
                                    {
                                        s.deleteFromRealm();
                                    }
                                    Log.i(TAG, "insertBulk - Count:"+medias.size());
                                }
                                if(sample instanceof MeshSignageV2)
                                {
                                    Log.i(TAG, "insertBulk - detected MeshSignageV2");
                                    RealmResults<MeshSignageV2> medias = realm.where(MeshSignageV2.class).findAll();
                                    Log.i(TAG, "insertBulk - Deleting:"+medias.size());
                                    for(MeshSignageV2 s:medias)
                                    {
                                        s.deleteFromRealm();
                                    }
                                    Log.i(TAG, "insertBulk - Count:"+medias.size());
                                }
                                if(sample instanceof MeshType)
                                {
                                    Log.i(TAG, "insertBulk - detected MeshType");
                                    RealmResults<MeshType> medias = realm.where(MeshType.class).findAll();
                                    Log.i(TAG, "insertBulk - Deleting:"+medias.size());
                                    for(MeshType s:medias)
                                    {
                                        s.deleteFromRealm();
                                    }
                                    Log.i(TAG, "insertBulk - Count:"+medias.size());
                                }
                                if(sample instanceof MeshMediaZoneAssignment)
                                {
                                    Log.i(TAG, "insertBulk - detected MeshMediaZoneAssignment");
                                    RealmResults<MeshMediaZoneAssignment> medias = realm.where(MeshMediaZoneAssignment.class).findAll();
                                    Log.i(TAG, "insertBulk - Deleting:"+medias.size());
                                    for(MeshMediaZoneAssignment s:medias)
                                    {
                                        s.deleteFromRealm();
                                    }
                                    Log.i(TAG, "insertBulk - Count:"+medias.size());
                                }
                                if(sample instanceof MeshMediaZone)
                                {
                                    Log.i(TAG, "insertBulk - detected MeshMediaZone");
                                    RealmResults<MeshMediaZone> medias = realm.where(MeshMediaZone.class).findAll();
                                    Log.i(TAG, "insertBulk - Deleting:"+medias.size());
                                    for(MeshMediaZone s:medias)
                                    {
                                        s.deleteFromRealm();
                                    }
                                    Log.i(TAG, "insertBulk - Count:"+medias.size());
                                }
                                if(sample instanceof MeshTVFeed)
                                {
                                    Log.i(TAG, "insertBulk - detected MeshTVFeed");
                                    RealmResults<MeshTVFeed> medias = realm.where(MeshTVFeed.class).findAll();
                                    Log.i(TAG, "insertBulk - Deleting:"+medias.size());
                                    for(MeshTVFeed s:medias)
                                    {
                                        s.deleteFromRealm();
                                    }
                                    Log.i(TAG, "insertBulk - Count:"+medias.size());
                                }
                                int ctr = 0;
                                for(final Object o:os)
                                {
                                    Log.i(TAG, "Inserting:" + o.getClass());
                                    realm.insertOrUpdate((RealmObject) o);
                                    ctr++;
                                    Log.i(TAG, "insertBulk: progress "+ctr+"/"+os.size());
                                }
                                get().onCreateBulk(os);

                            }
                        },new Realm.Transaction.OnSuccess() {
                            @Override

                            public void onSuccess() {
                                Log.i(TAG, "Inserted Bulk :"+uuid);


                            }
                        }, new Realm.Transaction.OnError() {
                            @Override
                            public void onError(Throwable error) {
                                Log.i(TAG, "Failed to Insert : "+uuid+" - "+error.getLocalizedMessage());

                            }
                        });
                    }
                };
                h.post(runnable);
            }
        }

    }
    final static void retrieve(final Class c,final MeshRealmListener listener)
    {

        Handler h = new Handler(MeshTVApp.get().getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final Realm r = Realm.getDefaultInstance();
                final RealmResults<RealmObject> results = r.where(c).findAllAsync();
                results.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<RealmObject>>()
                {
                    @Override
                    public void onChange(RealmResults<RealmObject> x, OrderedCollectionChangeSet changeSet)
                    {
                        ArrayList<Object> os = new ArrayList<>();
                        os.addAll(Arrays.asList(x.toArray()));
                        if(os.size()>0)
                        {
                            listener.onRetrieved(c,os);
                        }
                        else
                        {
                            listener.onEmpty(c,"No Data Found");

                        }


                        results.removeChangeListener(this);
//                        r.close();
                    }
                });
            }
        };

        h.post(runnable);
    }


    final static void retrieve(final Class c, final MeshRealmListener listener, final MeshValuePair... vp)
    {


        Handler h = new Handler(MeshTVApp.get().getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                final Realm r = Realm.getDefaultInstance();
                RealmQuery<RealmObject> query = r.where(c);//.equalTo(MeshTag.TAG_NAME,"Grapefruit");
                for(MeshValuePair v:vp)
                {
                    if(v.isString())
                    {
                        Log.i(TAG,"RETRIEVING:STRING:"+v.getFieldName()+" "+v.getValue());
                        query.equalTo(v.getFieldName(),v.getValue().toString());
                    }
                    else
                    {
                        Log.i(TAG,"RETRIEVING:INT:"+v.getFieldName()+" "+v.getValue());
                        query.equalTo(v.getFieldName(),(int)v.getValue());
                    }
                }
                final RealmResults<RealmObject> results = query.findAllAsync();
                results.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<RealmObject>>()
                {
                    @Override
                    public void onChange(RealmResults<RealmObject> x, OrderedCollectionChangeSet changeSet)
                    {
                        ArrayList<Object> os = new ArrayList<>();
                        os.addAll(Arrays.asList(x.toArray()));
                        if(os.size()>0)
                        {
                            Log.i(TAG, "RETRIEVED");
                            listener.onRetrieved(c,os);
                        }
                        else
                        {
                            Log.i(TAG,"NO DATA");
                            listener.onEmpty(c,"No Data Found");
                        }
                        results.removeChangeListener(this);
//                        r.close();
                    }


                });
            }
        };

        h.post(runnable);


    }

    final static void update (final MeshUpdateRequest request)
    {

        final Handler h = new Handler(MeshTVApp.get().getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run()
            {
                final Realm r = Realm.getDefaultInstance();

                Log.i(TAG,"Class:"+(request.getC()==null?"null":"not_null - "+request.getC().getSimpleName()));;
                Log.i(TAG,"ID:"+(request.getId()==null?"null":"not_null - "+request.getId()));;
                Log.i(TAG,"Value:"+(request.getIdValue()==null?"null":"not_null - "+request.getIdValue()));;
                Log.i(TAG,"Realm:"+(r==null?"null":"not_null"));

                RealmResults<RealmObject>realmResults = null;
                if(request.getIdValue() instanceof Integer)
                {
                    realmResults = r.where(request.getC())
                            .equalTo(request.getId(),(Integer) request.getIdValue())
                            .findAllAsync();
                }
                else if (request.getIdValue() instanceof String)
                {
                    realmResults = r.where(request.getC())
                            .equalTo(request.getId(),(String) request.getIdValue())
                            .findAllAsync();
                }


                realmResults.addChangeListener(new RealmChangeListener<RealmResults<RealmObject>>() {
                    @Override
                    public void onChange(RealmResults<RealmObject> realmObjects)
                    {
                        for(final RealmObject o:realmObjects)
                        {
                            r.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm)
                                {
                                    request.getListener().setUpdates(o);
                                    request.getListener().updateDone(o);
                                }
                            });
                        }
//                        r.close();
                    }
                });
            };
        };
        h.post(runnable);

    }


    final static void retrieveOR(final Class c, final MeshRealmListener listener, final MeshValuePair... vp)
    {


        Handler h = new Handler(MeshTVApp.get().getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                final Realm r = Realm.getDefaultInstance();
                RealmQuery<RealmObject> query = r.where(c);//.equalTo(MeshTag.TAG_NAME,"Grapefruit");
                boolean first = true;
                for(MeshValuePair v:vp)
                {
                    if(v.isString())
                    {

                        if(!first)
                        {
                            query.or().equalTo(v.getFieldName(),v.getValue().toString());
                        }
                        else
                        {
                            query.equalTo(v.getFieldName(),v.getValue().toString());
                        }
                        Log.i(TAG,"RETRIEVING:STRING:"+v.getFieldName()+" "+v.getValue());
                    }
                    else
                    {
                        if(!first)
                        {
                            query.or().equalTo(v.getFieldName(),(int)v.getValue());
                        }
                        else
                        {
                            query.equalTo(v.getFieldName(),(int)v.getValue());
                        }
                        Log.i(TAG,"RETRIEVING:INT:"+v.getFieldName()+" "+v.getValue());


                    }
                    first = false;
                }
                Log.i(TAG,"Query:"+query.toString());

                final RealmResults<RealmObject> results = query.findAllAsync();
                results.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<RealmObject>>()
                {
                    @Override
                    public void onChange(RealmResults<RealmObject> x, OrderedCollectionChangeSet changeSet)
                    {
                        ArrayList<Object> os = new ArrayList<>();
                        os.addAll(Arrays.asList(x.toArray()));
                        if(os.size()>0)
                        {
                            Log.i(TAG, "RETRIEVED");
                            listener.onRetrieved(c,os);
                        }
                        else
                        {
                            Log.i(TAG,"NO DATA");
                            listener.onEmpty(c,"No Data Found");
                        }
                        results.removeChangeListener(this);
//                        r.close();
                    }


                });
            }
        };

        h.post(runnable);


    }
    final static void delete(final Object o)
    {
        final String uuid = UUID.randomUUID().toString();
        Log.i(TAG,"delete:"+o.getClass()+"("+uuid+")");
        Handler h = new Handler(MeshTVApp.get().getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final Realm r = Realm.getDefaultInstance();
                r.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm)
                    {
                        if(o instanceof MeshChannel)
                        {
                            MeshChannel ch = (MeshChannel)o;
                            RealmResults<MeshChannel>channels = realm.where(MeshChannel.class).equalTo(MeshChannel.TAG_ID,ch.getId()).findAll();
                            for(MeshChannel c:channels)
                            {
                                c.deleteFromRealm();
                                get().onDelete(MeshChannel.class);
                            }
                        }

                    }
                }, new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        Log.i(TAG, "Deleted:" + o.getClass() + "(" + uuid + ")");
//                        r.close();
                        get().onDelete(o.getClass());
                    }
                }, new Realm.Transaction.OnError() {
                    @Override
                    public void onError(Throwable error) {
                        Log.i(TAG, "Failed to Delete:" + o.getClass() + "(" + uuid + ")");
                        Log.i(TAG, "Failed to Delete:" +error.getLocalizedMessage());
//                        r.close();

                    }
                });
            }
        };
        h.post(runnable);
    }
    final static void clear(final Class c)
    {
        final String uuid = UUID.randomUUID().toString();
        Log.i(TAG,"clear:"+c.getSimpleName()+"("+uuid+")");
        Handler h = new Handler(MeshTVApp.get().getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final Realm r = Realm.getDefaultInstance();
                r.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.delete(c);

                    }
                }, new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        Log.i(TAG, "Cleared:" + c.getSimpleName() + "(" + uuid + ")");
//                        r.close();
                        get().onClear(c);

                    }
                }, new Realm.Transaction.OnError() {
                    @Override
                    public void onError(Throwable error) {
                        Log.i(TAG, "Failed to Clear:" +c.getSimpleName() + "(" + uuid + ")");
                        Log.i(TAG, "Failed to Clear:" +error.getLocalizedMessage());
//                        r.close();

                    }
                });
            }
        };
        h.post(runnable);
    }
    final static void clear(final Class c,final  MeshRealmListener listener)
    {
        final String uuid = UUID.randomUUID().toString();
        Log.i(TAG,"clear:"+c.getSimpleName()+"("+uuid+")");
        Handler h = new Handler(MeshTVApp.get().getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final Realm r = Realm.getDefaultInstance();
                r.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.delete(c);

                    }
                }, new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        Log.i(TAG, "Cleared:" + c.getSimpleName() + "(" + uuid + ")");
//                        r.close();
                        get().onClear(c);
                        listener.onCleared(c);

                    }
                }, new Realm.Transaction.OnError() {
                    @Override
                    public void onError(Throwable error) {
                        Log.i(TAG, "Failed to Clear:" +c.getSimpleName() + "(" + uuid + ")");
                        Log.i(TAG, "Failed to Clear:" +error.getLocalizedMessage());
                        listener.onEmpty(c,"NOTHING_TO_CLEAR");
                        //r.close();

                    }
                });
            }
        };
        h.post(runnable);
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------------Listener------------------------------------

    final ArrayList<MeshRealmEventListener> getListeners() {
        return listeners;
    }

    final void addListener(MeshRealmEventListener listener)
    {
        if(!listeners.contains(listener))
        {
            listeners.add(listener);
        }

    }
    final void removeListener(MeshRealmEventListener listener)
    {
        if(listeners.contains(listener))
        {
            listeners.remove(listener);
        }

    }
    final void clearListeners()
    {
        listeners.clear();
    }
    final void onCreate(Object o)
    {
        for(MeshRealmEventListener e:listeners)
        {
            e.onCreate(o);

        }
    }
    final void onCreateBulk(ArrayList<Object> os)
    {
        Log.i(TAG,"createBulk - ===============================================================");
        for(MeshRealmEventListener e:listeners)
        {
            e.onCreateBulk(os);

        }
        Log.i(TAG,"createBulk - size:"+os.size());

        if(os.get(0) instanceof MeshSubscription)
        {
            Log.i(TAG,"createBulk - MeshSubscription");
            MeshTVApp.get().onSubscriptionsUpdated();
            Log.i(TAG,"createBulk - "+MeshSubscription.class.getSimpleName());
        }
        else
        {
            Log.i(TAG,"createBulk - not "+MeshSubscription.class.getSimpleName());
        }
        Log.i(TAG,"createBulk - ===============================================================");
    }
    final void onDelete(Class c)
    {
        for(MeshRealmEventListener e:listeners)
        {
            e.onDelete(c);
        }
    }
    final void onClear(Class c)
    {
        for(MeshRealmEventListener e:listeners)
        {
            e.onClear(c);
        }
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
