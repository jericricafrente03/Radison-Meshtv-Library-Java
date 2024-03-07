package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.VOD;

import java.util.ArrayList;

/**
 * Created by Mars on 2/19/2018.
 */

public interface MeshVODListener
{
    public abstract void onBought(boolean isBought);
    public abstract void onClear();
    public abstract void bulkBought(ArrayList<Integer> vods);
}
