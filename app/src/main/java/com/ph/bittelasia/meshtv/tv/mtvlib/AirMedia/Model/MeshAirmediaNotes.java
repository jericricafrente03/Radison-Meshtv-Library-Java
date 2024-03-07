package com.ph.bittelasia.meshtv.tv.mtvlib.AirMedia.Model;

import org.json.JSONObject;

/**
 * Represents notes on using Airmedia for a platform
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
public class MeshAirmediaNotes {
    //=============================================Variable=========================================
    //---------------------------------------------Constant-----------------------------------------
    public static final String TAG      = MeshAirmediaNotes.class.getSimpleName();
    /**
     * Tag to extract notes from JSONObject
     */
    public static final String TAG_NOTE  = "notes";
    /**
     * Tag to extract text of the note
     */
    public static final String TAG_TEXT = "text";
    /**
     * Tag to extract no of the note
     */
    public static final String TAG_NO   = "no";
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
    //----------------------------------------------Instance----------------------------------------
    /**
     * A description of what to d is being noted
     */
    String text;
    /**
     * Index of the note
     */
    int no;
    //----------------------------------------------------------------------------------------------
    //============================================Constructor=======================================
    /**
     * Constructor that parses {@link #text text} and {@link #no no}
     * @param data String data to be parsed
     */
    public MeshAirmediaNotes(String data)
    {
        try
        {

            JSONObject object = new JSONObject(data);
            text = object.getString(TAG_TEXT);
            no = object.getInt(TAG_NO);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //==============================================================================================
    //==============================================Method==========================================
    //----------------------------------------------Getter------------------------------------------
    /**
     * Gets the Airmedia {@link #text text}
     * @return Airmedia {@link #text text}
     *
     */
    public String getText() {
        return text;
    }
    /**
     * Returns the index of the instruction
     * @return index {@link #no no}
     */
    public int getNo() {
        return no;
    }
    //----------------------------------------------------------------------------------------------
    //----------------------------------------------Setter------------------------------------------
    /**
     * Sets a new description for a {@link #text text}
     * @param text new description for the {@link #text text}
     */
    public void setText(String text) {
        this.text = text;
    }
    /**
     * Sets a new index {@link #no no} for an instruction
     * @param no new Index {@link #no no} for the instruction
     */
    public void setNo(int no) {
        this.no = no;
    }
    //----------------------------------------------------------------------------------------------
    //==============================================================================================
}