package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Constant.AppDataSource;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Listener.MeshCheckOutListener;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp;
import com.ph.bittelasia.meshtv.tv.mtvlib.Transaction.Control.MeshBittelCheckOut;
import com.ph.bittelasia.meshtv.tv.mtvlib.Transaction.Model.MeshCartItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Transaction.Model.MeshTVCart;

import java.util.ArrayList;

import io.realm.Realm;

class BittelVODManager
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    static final String TAG =  BittelVODManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Static-----------------------------------------
    static  BittelVODManager manager = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Static=========================================
    static BittelVODManager get()
    {
        if(manager == null)
        {
            manager = new BittelVODManager();
        }
        return manager;
    }
    //==============================================================================================
    //===============================================Construct======================================
    private BittelVODManager()
    {

    }
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Action-------------------------------------------
    synchronized void rent(final MeshVOD vod, final MeshVODListener listener)
    {
        Realm r  = Realm.getDefaultInstance();
        final int id = vod.getId();
        MeshCartItem item = new MeshCartItem(vod,vod.getPrice());
        MeshTVCart.add(item);
        MeshBittelCheckOut.checkout(
                new MeshCheckOutListener()
                                {
                                    @Override
                                    public void onFail(String s) {}
                                    @Override
                                    public void onSuccess(String s) {}
                                }, MeshTVApp.get().getDataSourceSetting()!= AppDataSource.SERVER,MeshVOD.class);
        r.executeTransactionAsync(new Realm.Transaction() {
                                      @Override
                                      public void execute(Realm realm) {
                                            MeshVODBought bought = new MeshVODBought();
                                            bought.setId(id);
                                            realm.copyToRealmOrUpdate(bought);

                                      }
                                  },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        listener.onBought(true);
                    }
                },
                new Realm.Transaction.OnError() {
                    @Override
                    public void onError(Throwable error) {
                        listener.onBought(false);
                    }
                }
        );
    }
    public void clear(final MeshVODListener listener)
    {
        Realm r  = Realm.getDefaultInstance();
        r.executeTransactionAsync(new Realm.Transaction() {
                                      @Override
                                      public void execute(Realm realm)
                                      {
                                          realm.delete(MeshVODBought.class);
                                      }
                                  },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        listener.onClear();
                    }
                },
                new Realm.Transaction.OnError() {
                    @Override
                    public void onError(Throwable error) {

                    }
                }
        );
    }
    public void isRented(final MeshVODListener listener, final int id)
    {
        Realm r  = Realm.getDefaultInstance();

        r.executeTransactionAsync(


                new Realm.Transaction() {
                                      @Override
                                      public void execute(Realm realm)
                                      {
                                          listener.onBought( realm.where(MeshVODBought.class).equalTo(MeshVODBought.TAG_ID,id).findFirst()!=null);
                                      }
                                  }
        );
    }
    public void isRented(ArrayList<MeshVOD> vods, final MeshVODListener listener)
    {
        final ArrayList<Integer> rentedList = new ArrayList<>();
        for(MeshVOD vod:vods)
        {
            rentedList.add(vod.getId());
        }
        Realm r  = Realm.getDefaultInstance();
        r.executeTransactionAsync(


                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm)
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.addAll(rentedList);
                        for(Integer i:temp)
                        {
                            if(realm.where(MeshVODBought.class).equalTo(MeshVODBought.TAG_ID,i).findFirst()==null)
                            {
                                rentedList.remove(i);
                            }
                        }
                        listener.bulkBought(rentedList);
                    }
                }
        );


    }

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
