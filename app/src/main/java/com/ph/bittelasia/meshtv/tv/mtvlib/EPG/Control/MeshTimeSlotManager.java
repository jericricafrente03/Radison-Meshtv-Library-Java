package com.ph.bittelasia.meshtv.tv.mtvlib.EPG.Control;

import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General.TimedMethod;
import com.ph.bittelasia.meshtv.tv.mtvlib.EPG.Model.MeshTimeSlot;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshEPG;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshEPGTableFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MeshTimeSlotManager
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    public static final String TAG = MeshTimeSlotManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Static-------------------------------------------
    private static MeshTimeSlotManager manager = null;
    private static Comparator<MeshTimeSlot> timeSlotComparator = new Comparator<MeshTimeSlot>() {
        @Override
        public int compare(MeshTimeSlot o1, MeshTimeSlot o2) {
            return o1.getId()>o2.getId()?1:-1;
        }
    };
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    private ArrayList<MeshTimeSlot> timeSlots = null;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================Static==========================================
    public static MeshTimeSlotManager get()
    {
        if(manager==null)
        {
            manager = new MeshTimeSlotManager();
        }
        return manager;
    }
    //==============================================================================================
    //=============================================Constructor======================================
    private MeshTimeSlotManager()
    {
        timeSlots = new ArrayList<>();
    }
    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Action------------------------------------------
    public MeshEPG getWhatWillBeOn(ArrayList<MeshEPG> epgs,MeshTimeSlot timeSlot)
    {
        for(MeshEPG epg:epgs)
        {
            if(timeSlot.isScheduled(epg))
            {
                return epg;
            }
        }
        return null;
    }
    private void filterTimeSlots()
    {

        ArrayList<MeshTimeSlot> temp = new ArrayList<>();
        for(MeshTimeSlot timeSlot:timeSlots)
        {
            if(!timeSlot.isDone())
            {
                temp.add(timeSlot);
            }
        }
        timeSlots.clear();
        timeSlots.addAll(temp);
        Collections.sort(timeSlots,timeSlotComparator);
    }
    private int isDuplicate(MeshTimeSlot tslot)
    {
        int ctr = 0;
        for(MeshTimeSlot ts:timeSlots)
        {
               if(tslot.getId()==ts.getId())
               {
                   return ctr;
               }
               ctr++;
        }
        return -1;
    }
    public void addTimeSlots(MeshTimeSlot timeSlot)
    {
        if(timeSlots==null)
        {
            timeSlots = new ArrayList<>();
        }
        int index = isDuplicate(timeSlot);
        if(index==-1)
        {
            timeSlots.add(timeSlot);
        }
        else
        {
            timeSlots.set(index,timeSlot);
        }
        filterTimeSlots();

    }
    public void removeTimeslot(MeshTimeSlot timeSlot)
    {
        if(timeSlots==null)
        {
            timeSlots = new ArrayList<>();
        }
        int index = isDuplicate(timeSlot);
        if(index!=-1)
        {

            timeSlots.remove(index);
        }
        filterTimeSlots();
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Getter------------------------------------------
    public ArrayList<MeshTimeSlot> getTimeSlots() {
        filterTimeSlots();
        return timeSlots;
    }
    public int getSpan(MeshEPG epg)
    {
        Log.i(TAG,"======================================== getSpan ==============================");
        filterTimeSlots();
        Log.i(TAG,"getSpan EPG :"+epg.getProgram_name());
        Log.i(TAG,"getSpan EPG Start :"+epg.getStart());
        Log.i(TAG,"getSpan EPG End :"+epg.getEnd());
        Log.i(TAG,"getSpan :"+timeSlots.size());
        int ctr = 0;
        for(MeshTimeSlot ts:timeSlots)
        {
            if(ts.isScheduled(epg))
            {
                Log.i(TAG,"getSpan :"+ts.getTime());
                ctr++;
            }
        }
        Log.i(TAG,"getSpan Result:"+ctr);

        Log.i(TAG,"======================================== getSpan ==============================");
        return ctr;
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Setter------------------------------------------
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
