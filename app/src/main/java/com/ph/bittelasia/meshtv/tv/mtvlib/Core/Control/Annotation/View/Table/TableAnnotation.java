package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.Table;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Mars on 3/13/2018.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableAnnotation
{
    int layout();
    int rowLayout() default -1;
    int columnLayout() default -1;
}
