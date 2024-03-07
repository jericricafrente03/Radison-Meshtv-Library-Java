package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Widget;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation: Used to reference widgets automatically
 * <br>
 * <br>
 * Target: Field
 * <br>
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindWidget
{
    /**
     * Resource ID of the widget to reference
     * @return Resource ID of the widget to reference
     */
    int value();
}
