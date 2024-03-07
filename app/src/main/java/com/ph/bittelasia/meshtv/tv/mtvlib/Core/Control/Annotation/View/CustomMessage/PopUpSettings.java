package com.ph.bittelasia.meshtv.tv.mtvlib.Core.Control.Annotation.View.CustomMessage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PopUpSettings
{
    int imageId() default -1;
    int messageId() default -1;
    int videoContainerId() default -1;
    boolean isScrollingMessage() default true;
    boolean isTimedPopUp() default false;
}
