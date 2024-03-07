package com.ph.bittelasia.meshtv.tv.mtvlib.Transaction.Model;

import android.widget.ProgressBar;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Concierge.MeshConciergeRequestService;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Dining.MeshFood;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Facility.MeshFacility;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Shopping.MeshShoppingItem;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD;

import java.util.ArrayList;

/**
 * Created by mars on 12/22/17.
 */

public class MeshCartItem
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshCartItem.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    int     itemId      = -1;
    String  itemName    = null;
    Class   itemClass   = null;
    double  itemPrice   = 0;
    int     quantity    = 1;
    String  img = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Constructor========================================
    public MeshCartItem(MeshFood food)
    {
        itemId = food.getId();
        itemName = food.getItem_name();
        itemClass = MeshFood.class;
        itemPrice = food.getUnit_price();
        img = food.getImg_uri();
    }
    public MeshCartItem(MeshShoppingItem item)
    {
        itemId = item.getId();
        itemName = item.getItem_name();
        itemClass = MeshShoppingItem.class;
        itemPrice = item.getUnit_price();
        img = item.getImg_uri();
    }
    public MeshCartItem(MeshConciergeRequestItem item)
    {
        itemId = item.getId();
        itemName = item.getItem_name();
        itemClass = MeshConciergeRequestItem.class;
        itemPrice = item.getUnit_price();
        img = item.getImg_uri();
    }
    public MeshCartItem(MeshConciergeRequestService item)
    {
        itemId = item.getId();
        itemName = item.getItem_name();
        itemClass = MeshConciergeRequestService.class;
        itemPrice = item.getUnit_price();
        img = item.getImg_uri();
    }
    public MeshCartItem(MeshVOD vod,double price)
    {
        itemId = vod.getId();
        itemName = vod.getTitle();
        itemClass = MeshVOD.class;
        itemPrice = price;
        img = vod.getImg();
    }
    public MeshCartItem(MeshFacility facility,double price)
    {
        itemId = facility.getId();
        itemName = facility.getItem_name();
        itemClass = MeshFacility.class;
        itemPrice = price;
        img = facility.getImg_uri();
    }
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Action-------------------------------------------
    public static ArrayList<MeshCartItem> summarizeCart(ArrayList<MeshCartItem> raw)
    {
        ArrayList<MeshCartItem> results = new ArrayList<>();
        for(MeshCartItem i:raw)
        {
            int ctr = 0;
            boolean found = false;
            for(MeshCartItem i2:results)
            {
                if(i2.getItemClass()==i.getItemClass()&&i2.getItemId()==i.getItemId())
                {
                    found = true;
                    break;
                }
                else
                {
                    ctr++;
                }
            }
            if(found)
            {
                results.get(ctr).setQuantity(results.get(ctr).getQuantity()+i.getQuantity());
            }
            else
            {
                results.add(i);
            }
        }

        return results;
    }
    public void add()
    {
        quantity++;
    }
    public void reduce()
    {
        quantity--;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Getter-------------------------------------------
    public int getItemId() {
        return itemId;
    }
    public String getItemName() {
        return itemName;
    }
    public Class getItemClass() {
        return itemClass;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getImg() {
        return img;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setItemClass(Class itemClass) {
        this.itemClass = itemClass;
    }
    public void setItemPrice(double itemPrice) {this.itemPrice = itemPrice;}
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setImg(String img) {
        this.img = img;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
