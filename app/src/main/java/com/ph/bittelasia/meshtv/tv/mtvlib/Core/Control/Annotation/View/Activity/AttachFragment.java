package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Activity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Annotates methods to attach {ink com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment}@s
 * to {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Activity.MeshTVActivity MeshTVActivity}
 * <br>Configures application settings
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AttachFragment
{
    /**
     * Container ID the fragment will be added to
     * @return Container ID
     */
    int container();
    /**
     * Tag to be use to reference to the {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment}
     * @return Tag for the {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment}
     */
    String tag();

    /**
     * Chronological order Fragments will be attached to an Activity
     * @return order the Fragment will be attached
     * @see android.support.v4.app.Fragment
     * @see android.app.Activity
     */
    int order() default 0;
}
