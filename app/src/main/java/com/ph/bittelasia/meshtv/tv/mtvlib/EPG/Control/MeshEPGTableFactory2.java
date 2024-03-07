package com.ph.bittelasia.meshtv.tv.mtvlib.EPG.Control;

import android.util.Log;
import android.view.View;

import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Table.TableAnnotation;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Table.MeshHeader;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Table.MeshTVTableFactory;
import com.ph.bittelasia.meshtv.tv.mtvlib.EPG.Model.MeshTimeSlot;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control.MeshEPGManager;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshChannel;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshEPG;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Telecom.MeshEPGTableFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class MeshEPGTableFactory2 extends MeshTVTableFactory<MeshEPG,MeshChannel,MeshTimeSlot>
{

    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    public static final String TAG = MeshEPGTableFactory2.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    MeshEPG prev = null;
    boolean isFirstHeader = true;
    TableAnnotation tableAnnotation;
    //==============================================================================================
    //===========================================Constructor========================================
    public MeshEPGTableFactory2(MeshTVFragment fragment, int backgroundColorResId, int containerID)
    {
        super(fragment, backgroundColorResId,containerID);
        tableAnnotation = getClass().getAnnotation(TableAnnotation.class);
        if(tableAnnotation!=null)
        {
            Log.i(TAG,"Table Annotation is not null");

            setLayout(tableAnnotation.layout());
            if(tableAnnotation.columnLayout()!=-1)
            {
                setColumnHeaderLayout(tableAnnotation.columnLayout());
                Log.i(TAG,"Column Layout from Annotation:"+tableAnnotation.columnLayout());
            }
            else
            {
                setColumnHeaderLayout(tableAnnotation.layout());
                Log.i(TAG,"Column Layout from Default");
            }
            if(tableAnnotation.rowLayout()!=-1)
            {
                setRowHeaderLayout(tableAnnotation.rowLayout());
                Log.i(TAG,"Row Layout from Annotation:"+tableAnnotation.rowLayout());
            }
            else
            {
                setRowHeaderLayout(tableAnnotation.layout());
                Log.i(TAG,"Row Layout from Default");
            }
        }
        else
        {
            Log.i(TAG,"Table Annotation is null");
        }



        ArrayList<String> times = new ArrayList<>();
        times.add("");
        times.add("12:00 AM");
        times.add("12:30 AM");
        times.add("01:00 AM");
        times.add("01:30 AM");
        times.add("02:00 AM");
        times.add("02:30 AM");
        times.add("03:00 AM");
        times.add("03:30 AM");
        times.add("04:00 AM");
        times.add("04:30 AM");
        times.add("05:00 AM");
        times.add("05:30 AM");
        times.add("06:00 AM");
        times.add("06:30 AM");
        times.add("07:00 AM");
        times.add("07:30 AM");
        times.add("08:00 AM");
        times.add("08:30 AM");
        times.add("09:00 AM");
        times.add("09:30 AM");
        times.add("10:00 AM");
        times.add("10:30 AM");
        times.add("11:00 AM");
        times.add("11:30 AM");
        times.add("12:00 PM");
        times.add("12:30 PM");
        times.add("01:00 PM");
        times.add("01:30 PM");
        times.add("02:00 PM");
        times.add("02:30 PM");
        times.add("03:00 PM");
        times.add("03:30 PM");
        times.add("04:00 PM");
        times.add("04:30 PM");
        times.add("05:00 PM");
        times.add("05:30 PM");
        times.add("06:00 PM");
        times.add("06:30 PM");
        times.add("07:00 PM");
        times.add("07:30 PM");
        times.add("08:00 PM");
        times.add("08:30 PM");
        times.add("09:00 PM");
        times.add("09:30 PM");
        times.add("10:00 PM");
        times.add("10:30 PM");
        times.add("11:00 PM");
        times.add("11:30 PM");
        int ctr = 0;
        for(String s:times)
        {
            MeshTimeSlot h = new MeshTimeSlot();
            h.setId(ctr);
            h.setTime(s);
            MeshTimeSlotManager.get().addTimeSlots(h);
            ctr++;
        }
        setAdapterColumns(MeshTimeSlotManager.get().getTimeSlots());
    }
    public MeshEPGTableFactory2(MeshTVFragment fragment, int backgroundColorResId)
    {
        super(fragment, backgroundColorResId);
        tableAnnotation = getClass().getAnnotation(TableAnnotation.class);
        if(tableAnnotation!=null)
        {
            setLayout(tableAnnotation.layout());
            if(tableAnnotation.columnLayout()!=-1)
            {
                setColumnHeaderLayout(tableAnnotation.columnLayout());
            }
            else
            {
                setColumnHeaderLayout(tableAnnotation.layout());
            }
            if(tableAnnotation.rowLayout()!=-1)
            {
                setRowHeaderLayout(tableAnnotation.rowLayout());
            }
            else
            {
                setRowHeaderLayout(tableAnnotation.layout());
            }
        }
        ArrayList<String> times = new ArrayList<>();
        times.add("12:00 AM");
        times.add("12:30 AM");
        times.add("01:00 AM");
        times.add("01:30 AM");
        times.add("02:00 AM");
        times.add("02:30 AM");
        times.add("03:00 AM");
        times.add("03:30 AM");
        times.add("04:00 AM");
        times.add("04:30 AM");
        times.add("05:00 AM");
        times.add("05:30 AM");
        times.add("06:00 AM");
        times.add("06:30 AM");
        times.add("07:00 AM");
        times.add("07:30 AM");
        times.add("08:00 AM");
        times.add("08:30 AM");
        times.add("09:00 AM");
        times.add("09:30 AM");
        times.add("10:00 AM");
        times.add("10:30 AM");
        times.add("11:00 AM");
        times.add("11:30 AM");
        times.add("12:00 PM");
        times.add("12:30 PM");
        times.add("01:00 PM");
        times.add("01:30 PM");
        times.add("02:00 PM");
        times.add("02:30 PM");
        times.add("03:00 PM");
        times.add("03:30 PM");
        times.add("04:00 PM");
        times.add("04:30 PM");
        times.add("05:00 PM");
        times.add("05:30 PM");
        times.add("06:00 PM");
        times.add("06:30 PM");
        times.add("07:00 PM");
        times.add("07:30 PM");
        times.add("08:00 PM");
        times.add("08:30 PM");
        times.add("09:00 PM");
        times.add("09:30 PM");
        times.add("10:00 PM");
        times.add("10:30 PM");
        times.add("11:00 PM");
        times.add("11:30 PM");
        int ctr = 0;
        for(String s:times)
        {
            MeshTimeSlot h = new MeshTimeSlot();
            h.setId(ctr);
            h.setTime(s);
            MeshTimeSlotManager.get().addTimeSlots(h);
            ctr++;
        }
        setAdapterColumns(MeshTimeSlotManager.get().getTimeSlots());
    }
    //==============================================================================================
    //===========================================MeshTVTableFactory=================================
    @Override
    public void bindItem(View view, MeshEPG meshEPG)
    {
        Log.i(TAG,"======================================bindItem================================");
        if(meshEPG!=null)
        {

            Log.i(TAG,"bindItem NAME:"+meshEPG.getProgram_name());
            Log.i(TAG,"bindItem START:"+meshEPG.getProgram_name()+" - "+meshEPG.getStart());
            Log.i(TAG,"bindItem END:"+meshEPG.getProgram_name()+" - "+meshEPG.getEnd());boolean isIncluded = MeshEPGManager.checkInclude(meshEPG);

            if(prev!=null)
            {

                Log.i(TAG,"bindItem : NEW EPG (VISBLE)");
                prev=meshEPG;
                view.setVisibility(View.VISIBLE);
                display(view,meshEPG);

            }
            else
            {
                Log.i(TAG,"bindItem : Bind Item (FIRST)");
                prev=meshEPG;
                view.setVisibility(View.VISIBLE);
                display(view,meshEPG);
            }
        }
        else
        {
            Log.i(TAG,"Bind Item No EPG Matched");
            view.setVisibility(View.INVISIBLE);
            display(view,meshEPG);
        }
        Log.i(TAG,"======================================bindItem================================");
    }

    @Override
    public void bindColumnItem(View view, MeshTimeSlot meshHeader)
    {
        Log.i(TAG,"======================================bindColumnItem================================");
        Log.i(TAG,"bindColumnItem : "+meshHeader.getTime());
        try
        {
            display(view,meshHeader);
        }
        catch (Exception e)
        {
            Log.i(TAG,"bindColumnItem : "+e.getMessage());
            e.printStackTrace();
        }
        Log.i(TAG,"======================================bindColumnItem================================");


    }

    @Override
    public void bindRowItem(View view, MeshChannel meshChannel)
    {
        Log.i(TAG,"======================================bindRowItem================================");
        Log.i(TAG,"bindRowItem : "+meshChannel.getChannel_title());
        display(view,meshChannel);
        Log.i(TAG,"======================================bindRowItem================================");

    }

    @Override
    protected int getHeaderSpan() {
        Log.i(TAG,"Get Header Span");
        return 1;
    }

    @Override
    protected int getSpan(MeshEPG meshEPG)
    {
        Log.i(TAG,"======================================getSpan================================");
        if(meshEPG!=null)
        {
            Log.i(TAG,"getSpan : "+meshEPG.getProgram_name());
            int result =  MeshTimeSlotManager.get().getSpan(meshEPG);
            Log.i(TAG,"getSpan : "+result);
            Log.i(TAG,"======================================getSpan================================");
             return result;
        }
        else
        {
            Log.i(TAG,"getSpan : (DEFAULT) "+1);
            Log.i(TAG,"======================================getSpan================================");
            return 1;
        }
    }
    @Override
    protected MeshEPG getToDisplay(MeshTimeSlot meshHeader, MeshChannel meshChannel)
    {
        Log.i(TAG,"==========================getToDisplay=====================================");
        Log.i(TAG,"getToDisplay CHANNEL:"+meshChannel.getChannel_title());
        for(MeshEPG epg:getItems())
        {
            if(epg.getChannel_id()==meshChannel.getId())
            {
                if(meshHeader.isScheduled(epg))
                {
                    Log.i(TAG,"getToDisplay EPG:"+epg.getProgram_name());
                    Log.i(TAG,"==========================getToDisplay=====================================");
                    return epg;
                }
            }

        }

        Log.i(TAG,"getToDisplay EPG:NULL");
        Log.i(TAG,"==========================getToDisplay=====================================");
        return null;
    }

    @Override
    protected ArrayList<MeshEPG> filter(ArrayList<MeshEPG> arrayList, MeshChannel meshChannel)
    {
        Log.i(TAG,"==========================filter=====================================");
        ArrayList<MeshEPG> epgs = new ArrayList<>();

        for(MeshEPG epg:arrayList)
        {
            if(epg.getChannel_id()==meshChannel.getId())
            {
                Log.i(TAG,"filter: --------------------------------------------------------------");
                Log.i(TAG,"filter: "+epg.getProgram_name());
                Log.i(TAG,"filter: in");
                epgs.add(epg);
                Log.i(TAG,"filter: --------------------------------------------------------------");
            }
        }
        Log.i(TAG,"filter: "+epgs.size());
        Log.i(TAG,"==========================filter=====================================");
        return epgs;
    }
    //==============================================================================================
    //============================================Abstract==========================================
    public abstract void display(View v,Object o);

    @Override
    public void setAdapterRows(ArrayList<MeshChannel> meshChannels)
    {
        Comparator<MeshChannel> comparator = new Comparator<MeshChannel>() {
            @Override
            public int compare(MeshChannel o1, MeshChannel o2) {
                return o1.getOrder_no()>o2.getOrder_no()?1:-1;
            }
        };
        Collections.sort(meshChannels,comparator);
        super.setAdapterRows(meshChannels);
    }
    //==============================================================================================
}
