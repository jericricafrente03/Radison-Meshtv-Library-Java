package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Exoplayer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Required by : {@link com.ph.bittelasia.meshtv.tv.mtvlib.ExoPlayer.View.Fragment.MeshTVExoplayerFragment MeshTVExoplayerFragment}
 * <br>Configures ExoPlayer Settings
 * @author Mars Ray Canizares Araullo
 * @author Steward Apostol
 * @version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MeshTVPlayerSettings
{
    /**
     * ID of layout to be inflated by the {@link com.ph.bittelasia.meshtv.tv.mtvlib.ExoPlayer.View.Fragment.MeshTVExoplayerFragment MeshTVExoplayerFragment}
     * @return ID of layout to be inflated
     */
    int layout() default 0;

    /**
     * Resource id of the SimpleExoplayerView to be used
     * @see com.google.android.exoplayer2.ui.SimpleExoPlayerView
     * @return SimpleExoplayerView resource ID
     */
    int exoplayer() default 0;

    /**
     * Toggle if SimpleExoplayerView will display Media Controls
     * @see com.google.android.exoplayer2.ui.SimpleExoPlayerView
     * @return Results
     * <br><br>
     * true - SimpleExoplayerView will use its default controls (DEFAULT)
     * <br>
     * false - SimpleExoplayerView will not use its default controls
     */
    boolean hasControls() default true;

    /**
     * Contributed by: Steward Apostol<br>
     * Toggles if SimpleExoplayerView should be brought to the front, handy when displaying SimpleExoplayers on DialogFragments
     * <br>
     * Setting this to true requires adding to xml:<br>
     * app:surface_type="texture_view"
     * @see android.app.DialogFragment
     * @see com.google.android.exoplayer2.ui.SimpleExoPlayerView
     * @return Results
     * <br><br>
     * true - SimpleExoplayerView will appear on top of other views
     * <br>
     * false - SimpleExoplayerView will use default z value (DEFAULT)
     */
    boolean bringToFront() default false;
}
