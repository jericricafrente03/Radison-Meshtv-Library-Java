package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation: Annotated method will repeatedly be triggered when delay has timed-out
 * <br>
 * <br>
 * Target: Method
 * <br>
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TimedMethod
{
    /**
     * Delay between method invocations
     * <br>
     * <br>
     * Default: 1000 ms
     * @return delay in milliseconds
     */
    long delay() default 1000;

    /**
     * Toggles if the first invocation will be done instantly or after the {@link #delay delay}
     * @return
     * Values:
     * <br>
     * <br>
     * true (DEFAULT) - will be invoked immediately
     * <br>
     * false - will be invoked after {@link #delay delay}
     */
    boolean launchFirstImmediately() default true;
}
