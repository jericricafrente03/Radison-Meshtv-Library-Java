package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Settings;
import com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Constant.AppDataSource;
import com.ph.bittelasia.meshtv.tv.mtvlib.R;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation: Used for configuring MeshTV Applications
 * <br>
 * <br>
 * Target: Class
 * <br>
 * Required by : {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.App.MeshTVApp MeshTVApp }
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AppSettings
{

    boolean reportsAnalytics() default false;
    AppMode appMode() default AppMode.HOTEL;
    /**
     * Sets if the app is on Demo or Live.
     * @return
     * Results:
     * <br>true - demo
     * <br>false - live
     */
    boolean isDemo() default true;
    /**
     * Sets if the app is should limit the use of Wi-Fi.
     * @return
     * Results:
     * <br>true - restrict
     * <br>false - unrestricted
     */
    boolean restrictWifi() default false;
    /**
     * Sets if the app should connect to XMPP.
     * @return
     * Results:
     * <br>true - connects to XMPP
     * <br>false - does not connect to XMPP
     */
    boolean useXMPP()   default false;
    /**
     * Sets the data source of the APP
     * @return
     * Results:
     * <br> {@link AppDataSource#SERVER AppDataSource.SERVER} - data will be fetched from a live server
     * <br> {@link AppDataSource#FILE_SYSTEM AppDataSource.FILE_SYSTEM} - data will be fetched from /sdcard/Android/<DEMO_FOLDER> which is set using {@link #fileSystemDirectory fileSystemDirectory()}
     * <br> {@link AppDataSource#RAW AppDataSource.RAW} - data will be fetched from the Apps Raw folder
     */
    int dataSource() default AppDataSource.RAW;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#RECORD_AUDIO RECORD_AUDIO}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean recordAudio() default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE WRITE_EXTERNAL_STORAGE}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean writeExternal() default true;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#READ_EXTERNAL_STORAGE READ_EXTERNAL_STORAGE}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean readExternal() default  true;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#READ_CALENDAR READ_CALENDAR}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean readCalendar() default  false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#WRITE_CALENDAR WRITE_CALENDAR}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean writeCalendar()default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#CAMERA CAMERA}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean useCamera() default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#READ_CONTACTS READ_CONTACTS}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean readContacts() default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#WRITE_CONTACTS WRITE_CONTACTS}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean writeContacts() default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#GET_ACCOUNTS GET_ACCOUNTS}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean getAccounts() default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#ACCESS_FINE_LOCATION ACCESS_FINE_LOCATION}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean accessFineLocation() default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#ACCESS_COARSE_LOCATION ACCESS_COARSE_LOCATION}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean accessCoarseLocation() default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean readPhoneState() default  false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#CALL_PHONE CALL_PHONE}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean callPhone() default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#READ_CALL_LOG READ_CALL_LOG}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean readCallLog() default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#WRITE_CALL_LOG WRITE_CALL_LOG}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean writeCallLog() default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#ADD_VOICEMAIL ADD_VOICEMAIL}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean addVoiceMail() default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#USE_SIP USE_SIP}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean useSip() default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#PROCESS_OUTGOING_CALLS PROCESS_OUTGOING_CALLS}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean processOutgoingCalls() default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#BODY_SENSORS BODY_SENSORS}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean bodySensors() default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#SEND_SMS SEND_SMS}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean sendSMS() default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#RECEIVE_SMS RECEIVE_SMS}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean receiveSMS() default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#RECEIVE_WAP_PUSH RECEIVE_WAP_PUSH}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean receiveWAP() default false;
    /**
     * Flag to request for dangerous permission {@link android.Manifest.permission#RECEIVE_MMS RECEIVE_MMS}
     * @return
     * <br> true - request during first run
     * <br> false - do not request
     */
    boolean receiveMMS() default false;
    /**
     * Sets the Demo Folder to store demo default data
     * @return Folder name for demo default data
     */
    String fileSystemDirectory() default "XHotel";

    boolean isManualSetUp() default  false;
    int notificationSound() default -1;
    int alertSound() default -1;
}
