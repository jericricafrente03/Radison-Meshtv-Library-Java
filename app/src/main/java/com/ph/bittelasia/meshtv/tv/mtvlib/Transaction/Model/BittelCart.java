package com.ph.bittelasia.meshtv.tv.mtvlib.Transaction.Model;

import android.util.Log;

import java.util.ArrayList;

final class BittelCart
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    static final String TAG = BittelCart.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Static------------------------------------------
    private static BittelCart cart;
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    ArrayList<MeshCartItem> items;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Static===========================================
    public final static BittelCart get()
    {
        if(cart == null)
        {
            cart = new BittelCart();
        }
        return cart;
    }
    //==============================================================================================
    //==========================================Constructor=========================================
    private BittelCart()
    {
        items = new ArrayList<>();
    }
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Action-------------------------------------------
    public final void add(MeshCartItem item)
    {
        Log.i(TAG,"adding:"+item.getItemClass().getSimpleName()+":"+item.getItemName());
        boolean isFound = false;
        for(MeshCartItem i:items)
        {
            if(i.getItemId()==item.getItemId()&&item.getItemClass()==i.getItemClass())
            {
                Log.i(TAG,"MATCH");

                i.add();
                isFound = true;
                break;
            }
        }
        if(!isFound)
        {
            Log.i(TAG,"New Entry:"+item.getItemName());
            items.add(item);
        }
        else
        {
            Log.i(TAG,"Updated:"+item.getItemName());
        }

        Log.i(TAG,"Cart:"+items.size());

    }
    public final void reduce(MeshCartItem item)
    {
        boolean isToRemove = false;
        int ctr = 0;
        for(MeshCartItem i:items)
        {
            if(i.getItemId()==item.getItemId()&&item.getItemClass()==i.getItemClass())
            {
                if(i.getQuantity()==1)
                {
                    isToRemove = true;

                }
                else
                {
                    i.reduce();
                }
                break;
            }
            ctr++;
        }
        if(isToRemove)
        {
            items.remove(ctr);
        }

    }
    public final void remove(MeshCartItem item)
    {
        items.remove(item);
    }
    public final ArrayList<MeshCartItem> display(Class... classes)
    {

        ArrayList<MeshCartItem> results = new ArrayList<>();


        for(MeshCartItem i:items)
        {
            Log.i(TAG,"Checking:"+i.getItemName()+"("+i.getItemClass().getSimpleName()+")");
            for(Class c:classes)
            {
                Log.i(TAG,"Retrieving:"+c.getSimpleName());
                Log.i(TAG,"Class:"+i.getItemClass().getSimpleName());
                if(i.getItemClass()==c)
                {
                    Log.i(TAG,"Retrieved:"+results.size());
                    results.add(i);
                    break;
                }
            }
        }
        Log.i(TAG,"Retrieved:"+results.size());
        return results;
    }
    public final void clear()
    {
        items.clear();
    }
    public final ArrayList<MeshCartItem> checkout(Class... classes)
    {
        Log.i(TAG,"Checkout:");
        for(int ctr =0;ctr<classes.length;ctr++)
        {
            Log.i(TAG,"("+ctr+"): "+classes[ctr].getSimpleName());
        }

        ArrayList<MeshCartItem> results = new ArrayList<>();
        ArrayList<MeshCartItem> co = new ArrayList<>();

        for(MeshCartItem i:items)
        {
            Log.i(TAG,"===================================");
            boolean removed = false;
            Log.i(TAG,"Item:"+i.getItemName());
            Log.i(TAG,"Class:"+i.getItemClass().getSimpleName());
            for(Class c:classes)
            {
                if(i.getItemClass()==c)
                {
                    removed = true;
                    break;
                }
            }
            if(!removed)
            {
                Log.i(TAG,"Not Checked-out");
                results.add(i);
            }
            else
            {
                Log.i(TAG,"Checked-out");
                co.add(i);
            }
        }

        items.clear();
        items.addAll(results);
        Log.i(TAG,"Items:"+items.size());
        Log.i(TAG,"Check-out:"+co.size());
        for(MeshCartItem i:co)
        {
            Log.i(TAG," - "+i.getItemName());
        }

        return co;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
