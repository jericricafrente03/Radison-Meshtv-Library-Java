package com.ph.bittelasia.meshtv.tv.mtvlib.EPG.Model;

import android.util.Log;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel.MeshEPG;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MeshTimeSlot
{
    //=============================================Variable=========================================
    //--------------------------------------------Constant------------------------------------------
    public static final String TAG = MeshTimeSlot.class.getSimpleName();
    public static final String TAG_ID = MeshTimeSlot.class.getSimpleName();
    public static final String TAG_TIME = MeshTimeSlot.class.getSimpleName();
    public static final String DATE_FORMAT = "hh:mm aa";
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Instance-----------------------------------------
    int id;
    String time;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Constructor========================================
    public MeshTimeSlot()
    {

    }
    public MeshTimeSlot(String data)
    {
        try
        {
            JSONObject object = new JSONObject(data);
            id = object.getInt(TAG_ID);
            time = object.getString(TAG_TIME);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //==============================================================================================
    //=============================================Method===========================================
    //--------------------------------------------Validation----------------------------------------
    public boolean isDone()
    {

        Log.i(TAG,"============================= isDone =======================================");
        Log.i(TAG,"isDone - ID :"+id);
        Log.i(TAG,"isDone - Time :"+time);
        try
        {
            //Round of Minute
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE)>30?30:0);
            calendar.set(Calendar.SECOND,0);
            Log.i(TAG,"isDone - Rounded Off Current Date :"+calendar.getTime());


            //Convert TimeSlot to a date to compare from rounded off date represented by calendar
            SimpleDateFormat tsDateFormat = new SimpleDateFormat(DATE_FORMAT);
            Date d = tsDateFormat.parse(time);
            Calendar temporary = Calendar.getInstance();
            temporary.setTime(d);
            Calendar timeSlot = Calendar.getInstance();
            timeSlot.set(Calendar.MINUTE,temporary.get(Calendar.MINUTE));
            timeSlot.set(Calendar.HOUR_OF_DAY,temporary.get(Calendar.HOUR_OF_DAY));
            timeSlot.add(Calendar.MINUTE,30);
            Log.i(TAG,"isDone - Timeslot (+30mins) :"+timeSlot.getTime());
            //Compare current date and converted timeslot(+30mins)
            boolean result = !timeSlot.getTime().after(calendar.getTime());
            Log.i(TAG,"============================= isDone =======================================");
            return  result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.i(TAG,"isDone - Error :"+e.getMessage());
        }
        Log.i(TAG,"isDone - result (DEFAULT): true");
        Log.i(TAG,"============================= isDone =======================================");
        return true;
    }
    public boolean isScheduled(MeshEPG epg)
    {
        Log.i(TAG,"============================= isScheduled =======================================");
        try
        {
            //convert start and end to dates
            SimpleDateFormat df = new SimpleDateFormat(MeshEPG.TIMEFORMAT);
            Date start = df.parse(epg.getStart());
            Log.i(TAG,"isScheduled - start: "+start);
            Date end = df.parse(epg.getEnd());
            Log.i(TAG,"isScheduled - end: "+end);
            //Convert TimeSlot to a date
            SimpleDateFormat tsDateFormat = new SimpleDateFormat(DATE_FORMAT);
            Date d = tsDateFormat.parse(time);

            Calendar temporary = Calendar.getInstance();
            temporary.setTime(d);
            Calendar timeSlot = Calendar.getInstance();
            timeSlot.set(Calendar.MINUTE,temporary.get(Calendar.MINUTE));
            timeSlot.set(Calendar.HOUR_OF_DAY,temporary.get(Calendar.HOUR_OF_DAY));
            d = timeSlot.getTime();
            Log.i(TAG,"isScheduled - Time Slot: "+d);
            if((d.before(end)||d.equals(end))&&(d.after(start)||d.equals(start)))
            {
                Log.i(TAG,"isScheduled - Time Slot is scheduled - O");
                Log.i(TAG,"============================= isScheduled =======================================");
                return true;
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.i(TAG,"isScheduled - ERROR - "+e.getMessage());
        }
        Log.i(TAG,"isScheduled - Time Slot is not scheduled - X");
        Log.i(TAG,"============================= isScheduled =======================================");

        return false;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Getter-------------------------------------------
    public int getId() {
        return id;
    }
    public String getTime() {
        return time;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setTime(String time) {
        this.time = time;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}
