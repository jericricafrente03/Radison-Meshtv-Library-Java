package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control;

import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Query.MeshValuePair;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackage;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshPackageChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshSubscription;

import java.util.ArrayList;

class BittelChannelPackageManager
{

    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = BittelChannelPackageManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Static-----------------------------------------
    private static BittelChannelPackageManager manager;
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    ArrayList<MeshPackageChannel> packageChannels;
    ArrayList<MeshPackage> packages;
    ArrayList<MeshSubscription> subscriptions;
    boolean isLoaded = false;
    int ctr = 0;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Static=========================================
    public final static BittelChannelPackageManager get()
    {
        if(manager==null)
        {
            manager = new BittelChannelPackageManager();
        }
        return manager;
    }
    //==============================================================================================
    //=============================================Constructor======================================
    private BittelChannelPackageManager()
    {
        packageChannels = new ArrayList<>();
        subscriptions = new ArrayList<>();
        packages = new ArrayList<>();
    }
    //==============================================================================================
    //================================================Methods=======================================
    //------------------------------------------------Action----------------------------------------
    final void clearPackages()
    {
        subscriptions = new ArrayList<>();
        packageChannels = new ArrayList<>();
        packages = new ArrayList<>();
    }
    final void loadPackages(final MeshChannelPackageListener listener)
    {
        isLoaded =false;
        ctr = 0;
        Log.i(TAG,"loadpackages - STARTED");
        MeshRealmManager.retrieve(MeshSubscription.class,
                new MeshRealmListener() {
                    @Override
                    public void onRetrieved(Class c, ArrayList<Object> results)
                    {
                        Log.i(TAG,"loadpackages - ============================================================");
                        Log.i(TAG,"loadpackages - RETRIEVED:"+c.getSimpleName());
                        Log.i(TAG,"loadpackages - RESULTS:"+results.size());
                        Log.i(TAG,"loadpackages - ============================================================");
                        if(c == MeshSubscription.class)
                        {
                            Log.i(TAG,"loadpackages - size:"+results.size());
                            subscriptions.clear();
                            for(Object o:results)
                            {
                                addSubscription((MeshSubscription)o);
                            }
                            packageChannels.clear();
                            for(MeshSubscription s:subscriptions)
                            {
                                Log.i(TAG,"loadpackages - Getting Details of Subscription - ID:"+s.getId());
                                MeshRealmManager.retrieve(MeshPackageChannel.class, new MeshRealmListener() {
                                    @Override
                                    public void onRetrieved(Class c, ArrayList<Object> results) {
                                        if (c == MeshPackageChannel.class)
                                        {

                                            for(Object o:results)
                                            {
                                                MeshPackageChannel pCh = (MeshPackageChannel) o;
                                                for(MeshSubscription s:subscriptions)
                                                {
                                                    if(s.getPackage_id()==pCh.getPackage_id())
                                                    {
                                                        addChannel(pCh);
                                                        break;
                                                    }
                                                }

                                            }
                                            if(packageChannels.size()>0)
                                            {
                                                listener.onPackageChannelsLoaded();
                                                isLoaded = true;
                                            }
                                            else
                                            {
                                                listener.onPackageChannelsFailedToLoad("No data loaded");
                                            }


                                        }
                                    }

                                    @Override
                                    public void onFailed(Class c, String message) {
                                        Log.i(TAG,"loadpackages - ============================================================");
                                        Log.i(TAG,"loadpackages - FAILED:"+c.getSimpleName());
                                        Log.i(TAG,"loadpackages - MESSAGE:"+message);
                                        Log.i(TAG,"loadpackages - ============================================================");
                                    }

                                    @Override
                                    public void onEmpty(Class c, String message) {
                                        Log.i(TAG,"loadpackages - ============================================================");
                                        Log.i(TAG,"loadpackages - EMPTY:"+c.getSimpleName());
                                        Log.i(TAG,"loadpackages - MESSAGE:"+message);
                                        Log.i(TAG,"loadpackages - ============================================================");
                                    }

                                    @Override
                                    public void onCleared(Class c) {
                                        Log.i(TAG,"loadpackages - ============================================================");
                                        Log.i(TAG,"loadpackages - CLEARED:"+c.getSimpleName());
                                        Log.i(TAG,"loadpackages - ============================================================");
                                    }
                                });
                            }

                        }
                    }

                    @Override
                    public void onFailed(Class c, String message) {
                        Log.i(TAG,"loadpackages - failed:"+message);
                    }

                    @Override
                    public void onEmpty(Class c, String message) {

                    }

                    @Override
                    public void onCleared(Class c) {

                    }
                });


    }
    final synchronized void addSubscription(MeshSubscription sub)
    {
        Log.i(TAG,"==================================================");
        Log.i(TAG,"Adding Subscription - ID:"+sub.getId());
        Log.i(TAG,"Adding Subscription - Package ID:"+sub.getPackage_id());
        Log.i(TAG,"Adding Subscription - Sub ID:"+sub.getCustomer_id());
        Log.i(TAG,"==================================================");
        subscriptions.add(sub);
    }

    final synchronized void addChannel(MeshPackageChannel pc)
    {

        Log.i(TAG,"==================================================");
        Log.i(TAG,"Adding Package Channel - ID:"+pc.getId());
        Log.i(TAG,"Adding Package Channel - PKG ID:"+pc.getPackage_id());
        Log.i(TAG,"Adding Package Channel - CH ID:"+pc.getChannel_id());
        Log.i(TAG,"==================================================");
        boolean isDupe = false;
        for(MeshPackageChannel ch:packageChannels)
        {
            if(ch.getChannel_id()==pc.getChannel_id())
            {
                isDupe=true;
                break;
            }
        }
        if(!isDupe)
        {
            packageChannels.add(pc);

        }
    }
    final boolean isSubscribed(MeshChannel channel)
    {

        Log.i(TAG,"isSubscribed - =============================================================");
        Log.i(TAG,"isSubscribed - Channel:"+channel.getChannel_title()+" ("+channel.getId()+")");
        Log.i(TAG,"isSubscribed - Channels Packaged : "+packageChannels.size());
        for(MeshPackageChannel pc:packageChannels)
        {

            Log.i(TAG,"isSubscribed - ---------------------------------------------------------");
            try
            {
                Log.i(TAG,"isSubscribed - ID: "+pc.getId());
                Log.i(TAG,"isSubscribed - Package ID: "+pc.getPackage_id());
                Log.i(TAG,"isSubscribed - Channel Package ID: "+pc.getChannel_id());
                if(pc.getChannel_id()==channel.getId())
                {
                    return true;
                }
            }
            catch (Exception e)
            {
                Log.i(TAG,"isSubscribed - Error Encountered");
                e.printStackTrace();
            }
            Log.i(TAG,"isSubscribed - ---------------------------------------------------------");
        }
        Log.i(TAG,"isSubscribed - =============================================================");

        return false;
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Getter-----------------------------------------
    final ArrayList<MeshPackageChannel> getPackageChannels() {
        return packageChannels;
    }
    final ArrayList<MeshPackage> getPackages() {
        return packages;
    }
    final ArrayList<MeshSubscription> getSubscriptions() {
        return subscriptions;
    }
    final boolean isLoaded() {
        return isLoaded;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
