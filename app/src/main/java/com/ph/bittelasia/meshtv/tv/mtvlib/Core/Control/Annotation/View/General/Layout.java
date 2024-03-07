package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation: Used for setting Layout to be inflated
 * <br>
 * <br>
 * Target: Class
 * <br>
 * Required by:
 * <br>1. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Activity.MeshTVActivity MeshTVActivity}
 * <br>2. {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Fragment.MeshTVFragment MeshTVFragment}
 * <br>3. {@link  com.ph.bittelasia.meshtv.tv.mtvlib.Core.View.Dialog.MeshTVDialogFragment MeshTVDialogFragment}
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Layout
{
    /**
     * Resource id of layout to be inflated
     * @return Resource id of layout to be inflated
     */
    int value();
}
