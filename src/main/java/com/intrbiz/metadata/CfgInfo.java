package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value=ElementType.TYPE)
public @interface CfgInfo {
    /**
     * The title of the configuration item.
     * @return
     * returns String
     */
    String title();
    /**
     * The description of the configuration item.
     * @return
     * returns String
     */
    String description() default "";
    
    /**
     * The parameters common to the configuration item.
     * @return
     * returns CfgParamInfo[]
     */
    CfgParamInfo[] parameters() default {};
}
