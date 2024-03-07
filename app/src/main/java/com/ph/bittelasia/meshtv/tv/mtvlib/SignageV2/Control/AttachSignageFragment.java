package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.Control;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AttachSignageFragment
{
    int zone();
}
