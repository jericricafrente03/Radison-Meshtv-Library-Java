package com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Channel;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshEPG  extends RealmObject implements MeshObjectInterface
{
    //============================================Variable==========================================
    //--------------------------------------------Constant------------------------------------------
    @Ignore
    public static final String TAG                      = MeshEPG.class.getSimpleName();
    @Ignore
    public static final String TAG_ID                   = "id";
    @Ignore
    public static final String TAG_CHANNEL_ID           = "channel_id";
    @Ignore
    public static final String TAG_PROGRAM_NAME         = "program_name";
    @Ignore
    public static final String TAG_PROGRAM_DESCRIPTION  = "program_description";
    @Ignore
    public static final String TAG_PROGRAM_IMAGE        = "program_image";
    @Ignore
    public static final String TAG_START                = "start";
    @Ignore
    public static final String TAG_END                  = "end";
    @Ignore
    public static final String TAG_DAY                  = "day_no";
    @Ignore
    public static final String TAG_ENABLED              = "enabled";
    @Ignore
    public static final String CLASS_NAME               = "get_epg";
    @Ignore
    public static final String TIMEFORMAT               = "yyyy-MM-dd kk:mm";
    @Ignore
    public static final int ENABLED                     = 1;
    @Ignore
    public static final int DISABLED                    = 0;
    @Ignore
    public static final int SUNDAY                      = 7;
    @Ignore
    public static final int MOMNDAY                     = 1;
    @Ignore
    public static final int TUESDAY                     = 2;
    @Ignore
    public static final int WEDNESDAY                   = 3;
    @Ignore
    public static final int THURSDAY                    = 4;
    @Ignore
    public static final int FRIDAY                      = 5;
    @Ignore
    public static final int SATURDAY                    = 6;
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Instance------------------------------------------
    @PrimaryKey
    int id;
    int channel_id;
    String program_name;
    String program_description;
    String program_image;
    String start;
    String end;
    int day_no;
    int enabled;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Method=============================================
    //-------------------------------------------Getter---------------------------------------------
    public int getId() {
        return id;
    }
    public int getChannel_id() {
        return channel_id;
    }
    public String getProgram_name() {
        return program_name;
    }
    public String getProgram_description() {
        return program_description;
    }
    public String getProgram_image() {
        return program_image;
    }
    public String getStart() {
        return start;
    }
    public String getEnd() {
        return end;
    }
    public int getDay_no() {
        return day_no;
    }
    public int getEnabled() {
        return enabled;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Setter---------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }
    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }
    public void setProgram_description(String program_description) {this.program_description = program_description;}
    public void setProgram_image(String program_image) {
        this.program_image = program_image;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public void setDay_no(int day_no) {
        this.day_no = day_no;
    }
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //=======================================MeshObjectInterface====================================
    @Override
    public int getMeshID() {return 0;}
    @Override
    public String getMeshLabel() {return null;}
    @Override
    public String getMeshDescription() {return null;}
    @Override
    public int getMeshQuantity() {return 0;}
    @Override
    public double getMeshPrice() {return 0;}
    @Override
    public String getMeshIMG() {return null;}
    //==============================================================================================
}
