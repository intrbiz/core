package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD, ElementType.FIELD})
public @interface CfgParamInfo {
    /**
     * The title of the configuration field.
     * @return
     * returns String
     */
    String title();
    /**
     * The description of the configuration field.
     * @return
     * returns String
     */
    String description();
}
