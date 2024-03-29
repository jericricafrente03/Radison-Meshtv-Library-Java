package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.Event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation: Used for marking methods to be invoked during onCreate
 * <br>
 * <br>
 * Target: Method
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Init
{
    /**
     * Order to be followed when more than one method is annotated
     * @return Order to be followed when more than one method is annotated
     */
    int order();
}
