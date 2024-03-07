package com.ph.bittelasia.meshtv.tv.mtvlib.Transaction.Model;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD.MeshVOD;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mars on 1/2/18.
 */
public class BittelCartTest
{
    @Test
    public void checkCart() throws Exception
    {
        MeshVOD vod = new MeshVOD();
        vod.setId(1);
        vod.setTitle("sss");
        vod.setTag("s");
        vod.setBought(0);
        vod.setImg("fdsf");
        vod.setFull("sss");
        vod.setPlot("ss");
        vod.setLength(100);
        vod.setPrice(15);
        vod.setRating("1");
        vod.setTrailer("s");
        MeshCartItem item = new MeshCartItem(vod,15);
        assertEquals(item.getImg(),vod.getImg());
        assertEquals(item.getItemClass(),vod.getClass());
        assertEquals(item.getItemId(),vod.getId());
        assertEquals(item.getItemPrice(),vod.getPrice(),vod.getPrice());
        assertEquals(item.getQuantity(),1);
        MeshTVCart.add(item);
        assertEquals(1, MeshTVCart.display(MeshVOD.class).size());
        MeshTVCart.add(item);
        assertEquals(2, MeshTVCart.display(MeshVOD.class).get(0).getQuantity());
        MeshTVCart.reduce(item);
        assertEquals(1, MeshTVCart.display(MeshVOD.class).get(0).getQuantity());
        MeshTVCart.reduce(item);
        assertEquals(0, MeshTVCart.display(MeshVOD.class).size());





    }
}