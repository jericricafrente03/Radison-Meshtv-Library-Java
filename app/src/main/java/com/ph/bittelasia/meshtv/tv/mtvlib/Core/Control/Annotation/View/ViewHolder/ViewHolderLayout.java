package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.ViewHolder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation: Used to set the Layout to be used by a {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter MeshTVAdapter}
 * <br>
 * <br>
 * Target: Class
 * <br>
 * Required by: {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter MeshTVAdapter}
 * <br>
 * If any of the layouts are missing {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter MeshTVAdapter} will use the value of
 * {@link #layout() layout()}
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ViewHolderLayout
{
    /**
     * Resoure ID of default layout to be inflated by {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter MeshTVAdapter}
     * @return Resoure ID of default layout to be inflated by {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter MeshTVAdapter}
     */
    int layout() default 0;
    /**
     * Resoure ID of layout to be inflated by
     * {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter MeshTVAdapter}
     *  when item is selected
     * @return Resoure ID of layout to be inflated by
     * {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter MeshTVAdapter}
     *  when item is selected
     */
    int layoutSelected() default 0;
    /**
     * Resoure ID of layout to be inflated by
     * {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter MeshTVAdapter}
     *  when item is selected
     * @return Resoure ID of layout to be inflated by
     * {@link com.ph.bittelasia.meshtv.tv.mtvlib.Core.Object.Adapter.MeshTVAdapter MeshTVAdapter}
     *  when item is clicked
     */
    int layoutCLicked() default 0;
}
