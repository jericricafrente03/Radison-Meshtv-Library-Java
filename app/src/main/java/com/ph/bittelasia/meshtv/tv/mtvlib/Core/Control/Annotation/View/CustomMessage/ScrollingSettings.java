package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.CustomMessage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ScrollingSettings
{
    int scrollingTextId();

}
