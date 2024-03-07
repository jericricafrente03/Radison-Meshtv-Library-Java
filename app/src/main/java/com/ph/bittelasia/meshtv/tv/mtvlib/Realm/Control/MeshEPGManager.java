package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Control;

import android.util.Log;
import android.view.MotionEvent;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshEPG;
import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Message.MeshMessage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class MeshEPGManager
{
    //==============================================Variable========================================
    //----------------------------------------------Constant----------------------------------------
    public static final String TAG = MeshEPGManager.class.getSimpleName();
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Instance----------------------------------------
    private static Comparator<MeshEPG> dateComparatorASC = new Comparator<MeshEPG>()
    {
        @Override
        public int compare(MeshEPG o1, MeshEPG o2)
        {
            Date d1 = null;
            Date d2 = null;
            try
            {
                SimpleDateFormat df = new SimpleDateFormat(MeshEPG.TIMEFORMAT);
                d1 = df.parse(o1.getStart());
                d2 = df.parse(o2.getStart());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return d1.after(d2)?1:-1;
        }
    };
    private static Comparator<MeshEPG> dateComparatorDESC = new Comparator<MeshEPG>()
    {
        @Override
        public int compare(MeshEPG o1, MeshEPG o2)
        {
            Date d1 = null;
            Date d2 = null;
            try
            {
                SimpleDateFormat df = new SimpleDateFormat(MeshEPG.TIMEFORMAT);
                d1 = df.parse(o1.getStart());
                d2 = df.parse(o2.getStart());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return d1.before(d2)?1:-1;
        }
    };
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===============================================Method=========================================
    //------------------------------------------------Sort------------------------------------------
    public static void sortAscending(ArrayList<MeshEPG> epgs)
    {
        Collections.sort(epgs,dateComparatorASC);
    }
    public static void sortDescending(ArrayList<MeshEPG> epgs)
    {
        Collections.sort(epgs,dateComparatorDESC);
    }
    public static MeshEPG getCurrent(ArrayList<MeshEPG> epgs)
    {
        for(MeshEPG epg:epgs)
        {
            Date start = null;
            Date end = null;

            try
            {
                SimpleDateFormat df = new SimpleDateFormat(MeshEPG.TIMEFORMAT);
                start = df.parse(epg.getStart());
                end = df.parse(epg.getEnd());
                Date d = new Date();
                if(d.after(start)&&d.before(end))
                {
                    return epg;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static MeshEPG getNext(ArrayList<MeshEPG> epgs)
    {
        sortAscending(epgs);
        boolean isFound = false;
        int ctr = 0;
        for(MeshEPG epg:epgs)
        {
            Date start = null;
            Date end = null;
            try
            {
                SimpleDateFormat df = new SimpleDateFormat(MeshEPG.TIMEFORMAT);
                start = df.parse(epg.getStart());
                end = df.parse(epg.getEnd());
                Date d = new Date();
                if(d.after(start)&&d.before(end))
                {
                    isFound = true;
                    break;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            ctr++;
        }
        if(isFound)
        {

            int next = ctr+1;
            if(next<epgs.size())
            {
                return epgs.get(next);
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }
    //----------------------------------------------------------------------------------------------
    //-----------------------------------------------Action-----------------------------------------
    public static int getEPGDayNo(Calendar calendar)
    {
        Log.i(TAG,"===============================getEPGDayNo================================");
        switch (calendar.get(Calendar.DAY_OF_WEEK))
        {
            case Calendar.SUNDAY:
                Log.i(TAG,"getEPGDayNo - RESULT (SUNDAY):"+ MeshEPG.SUNDAY);
                return MeshEPG.SUNDAY;

            case Calendar.MONDAY:
                Log.i(TAG,"getEPGDayNo - RESULT (MONDAY):"+ MeshEPG.MOMNDAY);
                return MeshEPG.MOMNDAY;

            case Calendar.TUESDAY:
                Log.i(TAG,"getEPGDayNo - RESULT (TUESDAY):"+ MeshEPG.TUESDAY);
                return MeshEPG.TUESDAY;

            case Calendar.WEDNESDAY:
                Log.i(TAG,"getEPGDayNo - RESULT (WEDNESDAY):"+ MeshEPG.WEDNESDAY);
                return MeshEPG.WEDNESDAY;

            case Calendar.THURSDAY:
                Log.i(TAG,"getEPGDayNo - RESULT (THURSDAY):"+ MeshEPG.THURSDAY);
                return MeshEPG.THURSDAY;

            case Calendar.FRIDAY:
                Log.i(TAG,"getEPGDayNo - RESULT (FRIDAY):"+ MeshEPG.FRIDAY);
                return MeshEPG.FRIDAY;

            case Calendar.SATURDAY:
                Log.i(TAG,"getEPGDayNo - RESULT (SATURDAY):"+ MeshEPG.SATURDAY);
                return MeshEPG.SATURDAY;
        }
        Log.i(TAG,"getEPGDayNo - RESULT"+1);

        Log.i(TAG,"===============================getEPGDayNo================================");

        return 1;
    }
    public static boolean checkTimeSlot(String timeslot)
    {
        Log.i(TAG,"===============================checkTimeSlot================================");
        Log.i(TAG,"checkTimeSlot - TIMESLOT: "+timeslot);
        SimpleDateFormat df = new SimpleDateFormat("hh:mm aa");
        try
        {
            Calendar col =  Calendar.getInstance();
            col.setTime(df.parse(timeslot));
            int minute = col.get(Calendar.MINUTE);
            int hour = col.get(Calendar.HOUR_OF_DAY);
            Log.i(TAG,"checkTimeSlot - COL: "+col.getTime());

            Calendar c = Calendar.getInstance();
            c.set(Calendar.HOUR_OF_DAY,hour);
            c.set(Calendar.MINUTE,minute);
            c.set(Calendar.SECOND,0);
            c.add(Calendar.MINUTE,30);

            Log.i(TAG,"checkTimeSlot - C: "+c.getTime());

            Date d = new Date();
            Log.i(TAG,"checkTimeSlot - Current: "+d);
            if(c.getTime().after(d)||c.getTime().equals(d))
            {
                Log.i(TAG,"checkTimeSlot : true");
                Log.i(TAG,"===============================checkTimeSlot================================");
                return true;
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.i(TAG,"checkTimeSlot : error: "+e.getMessage());
        }
        Log.i(TAG,"checkTimeSlot : false");
        Log.i(TAG,"===============================checkTimeSlot================================");
        return false;
    }

    public final static boolean checkInclude(MeshEPG epg)
    {
        Log.i(TAG,"===============================checkInclude================================");
        Log.i(TAG,"checkInclude : EPG - "+epg.getProgram_name());
        SimpleDateFormat df = new SimpleDateFormat(MeshEPG.TIMEFORMAT);
        String s = epg.getStart();
        Log.i(TAG,"checkInclude : Start - "+s);

        String en = epg.getEnd();
        Log.i(TAG,"checkInclude : End - "+en);

        try
        {
            Calendar start =  Calendar.getInstance();
            start.setTime(df.parse(s));
            Log.i(TAG,"checkInclude : Parsed Start - "+start.getTime());

            Calendar end =  Calendar.getInstance();
            end.setTime(df.parse(en));
            Log.i(TAG,"checkInclude : Parsed End - "+end.getTime());

            Date d = new Date();
            Log.i(TAG,"checkInclude : Parsed Date - "+d);

            if(start.getTime().before(d)&&end.getTime().after(d))
            {
                Log.i(TAG,"checkInclude : true");
                Log.i(TAG,"===============================checkInclude================================");
                return true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.i(TAG,"checkInclude : error - "+e.getMessage());
        }
        Log.i(TAG,"checkInclude : false");
        Log.i(TAG,"===============================checkInclude================================");

        return false;
    }

    public static boolean checkInclude(String timeslot,MeshEPG epg)
    {

        Log.i(TAG,"===============================checkInclude-2================================");
        Log.i(TAG,"checkInclude-2 : EPG - "+epg.getProgram_name());
        Log.i(TAG,"checkInclude-2 : Timeslot - "+timeslot);
        SimpleDateFormat df = new SimpleDateFormat(MeshEPG.TIMEFORMAT);
        SimpleDateFormat ts = new SimpleDateFormat("hh:mm aa");
        String s = epg.getStart();
        Log.i(TAG,"checkInclude-2 : Start - "+s);
        String en = epg.getEnd();
        Log.i(TAG,"checkInclude-2 : End - "+en);
        try
        {
            Calendar tsTemp = Calendar.getInstance();
            tsTemp.setTime(ts.parse(timeslot));

            Calendar tsFinal = Calendar.getInstance();
            tsFinal.set(Calendar.MINUTE,tsTemp.get(Calendar.MINUTE));
            tsFinal.set(Calendar.HOUR_OF_DAY,tsTemp.get(Calendar.HOUR_OF_DAY));
            tsFinal.set(Calendar.SECOND,0);

            Calendar start =  Calendar.getInstance();
            start.setTime(df.parse(s));
            Log.i(TAG,"checkInclude-2 : Parsed Start - "+start.getTime());

            Calendar end =  Calendar.getInstance();
            end.setTime(df.parse(en));
            end.add(Calendar.MINUTE,-30);
            Log.i(TAG,"checkInclude-2 : Parsed End - "+end.getTime());

            Date d = tsFinal.getTime();
            Log.i(TAG,"checkInclude-2 : Parsed Date - "+d);
            if((start.getTime().before(d)||start.getTime().equals(d))&&(end.getTime().after(d)||end.getTime().equals(d)))
            {
                Log.i(TAG,"checkInclude-2 : true");
                Log.i(TAG,"===============================checkInclude-2================================");
                return true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.i(TAG,"checkInclude-2 : error - "+e.getMessage());
        }
        Log.i(TAG,"checkInclude-2 : false");
        Log.i(TAG,"===============================checkInclude-2================================");
        return false;
    }
        public static int getSpan(MeshEPG epg)
    {
        Log.i(TAG,"===============================getSpan================================");
        Log.i(TAG,"getSpan : Title:"+epg.getProgram_name());
        Log.i(TAG,"getSpan : Channel:"+epg.getChannel_id());

        try
        {

            SimpleDateFormat dateFormat = new SimpleDateFormat(MeshEPG.TIMEFORMAT);
            Calendar start = Calendar.getInstance();
            start.setTime(dateFormat.parse(epg.getStart()));
            start.add(Calendar.MINUTE,-30);
            Calendar end = Calendar.getInstance();
            end.setTime(dateFormat.parse(epg.getEnd()));
            Date d = new Date();

            Log.i(TAG,"getSpan : Date:"+d);
            Log.i(TAG,"getSpan : Start:"+start.getTime());
            Log.i(TAG,"getSpan : End:"+end.getTime());
            if(end.getTime().before(d))
            {
                Log.i(TAG,"getSpan : 0");
                Log.i(TAG,"===============================getSpan================================");
                return 0;
            }
            else
            {
                if(start.getTime().before(d))
                {
                    start.setTime(d);
                }
                else
                {

                }
            }
            long duration = end.getTimeInMillis()-start.getTimeInMillis();
            int result = Integer.valueOf((duration/(30*60*1000))+"");
            result += 1;
            Log.i(TAG,"getSpan : "+result);
            Log.i(TAG,"===============================getSpan================================");
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.i(TAG,"getSpan : error - "+e.getMessage());
        }
        Log.i(TAG,"getSpan : Default - 2");
        Log.i(TAG,"===============================getSpan================================");
        return 2;
    }

    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
