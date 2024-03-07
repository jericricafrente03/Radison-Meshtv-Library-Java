package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Util.RemoteControl;

import android.view.KeyEvent;

/**
 * Substitutes KeyCodes from the new KR301 Remote to old KeyCodes
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 *
 */
public class KR301KeyCode
{
    //=========================================Variable=============================================
    /**
     * New Key code for Green Progress Button
     */
    public static final int PB_GREEN =184;
    /**
     * New Key code for Green Progress Button
     */
    public static final int PB_GREEN2 =133;
    /**
     * New Key code for Red Progress Button
     */
    public static final int PB_RED =183;
    /**
     * New Key code for Red Progress Button
     */
    public static final int PB_RED2 =132;
    /**
     * New Key code for Blue Progress Button
     */
    public static final int PB_BLUE2 =135;
    /**
     * New Key code for Blue Progress Button
     */
    public static final int PB_BLUE =186;
    /**
     * New Key code for Yellow Progress Button
     */
    public static final int PB_YELLOW2 =134;
    /**
     * New Key code for Yellow Progress Button
     */
    public static final int PB_YELLOW =185;
    /**
     * New Key code for OK Button
     */
    public static final int DPAD_OK =66;
    /**
     * New Key code for Back Button
     */
    public static final int DPAD_BACK =111;
    /**
     * 0
     */
    public static final int DPAD_0 = 7;
    public static final int DPAD_1 = 8;
    public static final int DPAD_2 = 9;
    public static final int DPAD_3 = 10;
    public static final int DPAD_4 = 11;
    public static final int DPAD_5 = 12;
    public static final int DPAD_6 = 13;
    public static final int DPAD_7 = 14;
    public static final int DPAD_8 = 15;
    public static final int DPAD_9 = 16;
    //==============================================================================================
    //=========================================Getter===============================================

    /**
     * Coverts the new keycode to the old
     * @param krcode keycode to be processed
     * @return original keycode
     */
    public static int getEquivalent(int krcode)
    {
        switch (krcode)
        {
            case DPAD_OK:
                return KeyEvent.KEYCODE_DPAD_CENTER;
            case PB_GREEN:
            case PB_GREEN2:
                return KeyEvent.KEYCODE_PROG_GREEN;
            case PB_RED:
            case PB_RED2:
                return KeyEvent.KEYCODE_PROG_RED;
            case PB_BLUE:
            case PB_BLUE2:
                return KeyEvent.KEYCODE_PROG_BLUE;
            case PB_YELLOW:
            case PB_YELLOW2:
                return KeyEvent.KEYCODE_PROG_YELLOW;
            case DPAD_BACK:
                return KeyEvent.KEYCODE_BACK;
            default:
                return krcode;
        }

    }
    //==============================================================================================
}
