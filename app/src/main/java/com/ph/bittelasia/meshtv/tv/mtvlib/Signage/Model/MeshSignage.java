package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshSignage extends RealmObject implements MeshObjectInterface
{
    //==========================================Variable============================================
    //------------------------------------------Constant--------------------------------------------
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_COMPANY_ID="company_id";
    @Ignore
    public static final String TAG_DISPLAY_NAME="display_name";
    @Ignore
    public static final String TAG_COUNTER="counter";
    @Ignore
    public static final String  TAG_RUNTIME="runtime";
    @Ignore
    public static final String TAG_SCHEDULE_START="schedule_start";
    @Ignore
    public static final String TAG_SCHEDULE_END="schedule_end";
    @Ignore
    public static final String TAG_MEDIA="media";
    @Ignore
    public static final String TAG_FILETYPE="file_type";
    @Ignore
    public static final String TAG_ISSYSTEMMEDIA="is_system_media";
    @Ignore
    public static final String TAG_DESCRIPTION="description";
    @Ignore
    public static final String TYPE_VIDEO = "video";
    @Ignore
    public static final String TYPE_IMAGE = "image";
    @Ignore
    public static final String DATE_FORMAT = "yyyy-MM-dd kk:mm:ss";
    //----------------------------------------------------------------------------------------------
    //------------------------------------------Instance--------------------------------------------
    @PrimaryKey
    private int     id;
    private int     company_id;
    private int     counter;
    private int     runtime;
    private String  schedule_start;
    private String  schedule_end;
    private String  media;
    private String  file_type;
    private boolean isSystemMedia=false;
    private String display_name;
    private String description;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //===========================================Method=============================================
    //-------------------------------------------Setter---------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setCompanyId(int companyID) {
        this.company_id = companyID;
    }
    public void setFileType(String fileType) {
        this.file_type = fileType;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }
    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }
    public void setMedia(String media) {
        this.media = media;
    }
    public void setSchedule_start(String schedule_start) {
        this.schedule_start = schedule_start;
    }
    public void setSchedule_end(String schedule_end) {
        this.schedule_end = schedule_end;
    }
    public void setSystemMedia(boolean systemMedia) {
        isSystemMedia = systemMedia;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Getter---------------------------------------------
    public int getId() {
        return id;
    }
    public int getCompanyId() {
        return company_id;
    }
    public int getCounter() {
        return counter;
    }
    public int getRuntime() {
        return runtime;
    }
    public String getMedia() {
        return media;
    }
    public String getFileType() {
        return file_type;
    }
    public String getSchedule_start() {
        return schedule_start;
    }
    public String getSchedule_end() {
        return schedule_end;
    }
    public boolean isSystemMedia() {
        return isSystemMedia;
    }
    public String getDescription() {
        return description;
    }
    public String getDisplay_name() {
        return display_name;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //==============================================================================================
    //---------------------------------------MeshObjectInterface------------------------------------
    @Override
    public int getMeshID() {
        return id;
    }

    @Override
    public String getMeshLabel() {
        return null;
    }

    @Override
    public String getMeshDescription() {
        return null;
    }

    @Override
    public int getMeshQuantity() {
        return 0;
    }

    @Override
    public double getMeshPrice() {
        return 0;
    }

    @Override
    public String getMeshIMG() {
        return null;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

}
