package com.ph.bittelasia.meshtv.tv.mtvlib.Signage.Model;

import com.ph.bittelasia.meshtv.tv.mtvlib.Realm.Model.Core.MeshObjectInterface;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class MeshZone extends RealmObject implements MeshObjectInterface
{
    //===========================================Variable===========================================
    //-------------------------------------------Constant-------------------------------------------
    @Ignore
    public static final String TAG = MeshZone.class.getSimpleName();
    @Ignore
    public static final String TAG_ID = "id";
    @Ignore
    public static final String TAG_CONTENT = "content";
    @Ignore
    public static final String TAG_FONT = "font";
    @Ignore
    public static final String TAG_FONT_SIZE = "font_size";
    @Ignore
    public static final String TAG_COLOR = "color";
    @Ignore
    public static final String TAG_LAYOUT = "layout";
    @Ignore
    public static final String TAG_BACKGROUND = "background";
    //----------------------------------------------------------------------------------------------
    //-------------------------------------------Instance-------------------------------------------
    @PrimaryKey
    private int id;
    private String content;
    private String font;
    private int font_size;
    private String color;
    private String layout;
    private String background;
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //============================================Method============================================
    //--------------------------------------------Getter--------------------------------------------
    public int getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public String getFont() {
        return font;
    }
    public int getFont_size() {
        return font_size;
    }
    public String getColor() {
        return color;
    }
    public String getLayout() {
        return layout;
    }
    public String getBackground() {
        return background;
    }
    //----------------------------------------------------------------------------------------------
    //---------------------------------------------Setter-------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setFont(String font) {
        this.font = font;
    }
    public void setFont_size(int font_size) {
        this.font_size = font_size;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setLayout(String layout) {
        this.layout = layout;
    }
    public void setBackground(String background) {
        this.background = background;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //======================================MeshObjectInterface=====================================
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
    //==============================================================================================
}
