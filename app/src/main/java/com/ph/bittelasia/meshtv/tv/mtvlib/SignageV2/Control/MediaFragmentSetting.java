package com.ph.bittelasia.meshtv.tv.mtvlib.SignageV2.Control;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MediaFragmentSetting
{

    int videoId() default -1;
    int imageId() default -1;
    int tickerId() default -1;

    int weatherIconId() default -1;
    int temperatureId() default -1;
    int weatherDescriptionId() default -1;
    int humidityId() default -1;
    int windSpeedId() default -1;

    int blockerId() default -1;
    int feedListId() default -1;
    int dateId() default -1;
    String dateFormat() default "MMM dd, yyyy";
    int timeId() default -1;
    String timeFormat() default "hh:mm aa";
    boolean isTickerOnly() default false;
}
