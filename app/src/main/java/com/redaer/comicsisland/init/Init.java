package com.redaer.comicsisland.init;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by asdf on 2017/4/16.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Init {
    enum Type{
        TEXT,
        ATTR
    }
    String elem();
    Type type() default Type.TEXT;
    String attr() default "";
}
