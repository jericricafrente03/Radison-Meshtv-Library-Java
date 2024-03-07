package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshSchedule extends RealmObject implements MeshObjectInterface {
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    @Ignore
    public static final String TAG              = MeshSchedule.class.getSimpleName();
    @Ignore
    public static final String TAG_ID           = "id";
    @Ignore
    public static final String TAG_START        = "start";
    @Ignore
    public static final String TAG_END          = "end";
    @Ignore
    public static final String TAG_LAYOUT_ID    = "layout_id";
    @Ignore
    public static final String TAG_DEF_TIMEOUT  = "default_timeout";
    @Ignore
    public static final String DATE_FORMAT = "yyyy-MM-dd kk:mm:ss";
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Instance-------------------------------------------
    @PrimaryKey
    private int id;
    private String start;
    private String end;
    private int layout_id;
    private int default_timeout;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================

    //============================================Method============================================
    //--------------------------------------------Getter--------------------------------------------
    public int getId() {
        return id;
    }
    public String getStart() {
        return start;
    }
    public String getEnd() {
        return end;
    }
    public int getLayout_id() {
        return layout_id;
    }
    public int getDefault_timeout() {
        return default_timeout;
    }
    //----------------------------------------------------------------------------------------------
    //--------------------------------------------Setter--------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public void setLayout_id(int layout_id) {
        this.layout_id = layout_id;
    }
    public void setDefault_timeout(int default_timeout) {
        this.default_timeout = default_timeout;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //========================================MeshObjectInterface===================================
    @Override
    public int getMeshID() {
        return 0;
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
    //==============================================================================================
}
