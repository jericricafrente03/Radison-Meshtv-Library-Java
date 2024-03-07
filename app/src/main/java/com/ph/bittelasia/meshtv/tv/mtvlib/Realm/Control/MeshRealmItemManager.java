package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.RealmItem.MeshRealmField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MeshRealmItemManager
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshRealmItemManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Comparator-----------------------------------------
    private static Comparator<MeshRealmField> fieldComparatorASC = new Comparator<MeshRealmField>() {
        @Override
        public int compare(MeshRealmField f1, MeshRealmField f2) {
            return f1.getOrder()>=f2.getOrder()?1:-1;
        }
    };
    private static Comparator<MeshRealmField> fieldComparatorDESC = new Comparator<MeshRealmField>() {
        @Override
        public int compare(MeshRealmField f1, MeshRealmField f2) {
            return f1.getOrder()>=f2.getOrder()?-1:1;
        }
    };
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=============================================Method===========================================
    //---------------------------------------------Action-------------------------------------------
    public static void sortAscending(ArrayList<MeshRealmField> fields)
    {
        Collections.sort(fields,fieldComparatorASC);
    }
    public static void sortDescending(ArrayList<MeshRealmField> fields)
    {
        Collections.sort(fields,fieldComparatorDESC);
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

}
