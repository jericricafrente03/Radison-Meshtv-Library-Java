package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Activity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation: Used for configuring {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Activity.MeshTVActivity MeshTVActivity }
 * <br>
 * <br>
 * Required by :
 * <br>{@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Activity.MeshTVActivity MeshTVActivity }
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ActivitySetting
{
    /**
     * Sets if activity will be using action bar
     * @return
     * Results:
     * <br> true (DEFAULT) - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Activity.MeshTVActivity MeshTVActivity } will not use ActionBar
     * <br> false - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Activity.MeshTVActivity MeshTVActivity } will use ActionBar
     */
    boolean isFullScreen() default true;

    /**
     * Sets if the {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Activity.MeshTVActivity MeshTVActivity } will be allowed to request dagerouse permissions
     * @return
     * Results:
     * <br> true - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Activity.MeshTVActivity MeshTVActivity } will be allowed to request dangerous permissions
     * <br> false - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Activity.MeshTVActivity MeshTVActivity } will not be allowed to request dangerous permissions
     */
    boolean requestPermissions() default false;

    /**
     * Sets if {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Activity.MeshTVActivity MeshTVActivity } is used to play videos. If so when a PIP is playing while you open this activity, the PIP will close.
     * @return
     * Results:
     * <br> true - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Activity.MeshTVActivity MeshTVActivity } will close PIPs when opened
     * <br> false - {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Activity.MeshTVActivity MeshTVActivity } will not close PIPs when opened
     */
    boolean playsVideos() default false;


    /**
     * Flags if the activity should check if the STB is already registered
     * @version 2.0
     * @return
     */

    boolean isManualSetUp() default false;


}
