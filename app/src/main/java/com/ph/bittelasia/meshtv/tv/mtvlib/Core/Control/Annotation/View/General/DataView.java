package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.General;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author Mars Ray Canizares Araullo
 * @version 1.0
 * Not Implemented Yet
 */
@Deprecated
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DataView
{
    int id();
    Class data();
}
