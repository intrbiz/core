package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.converter.converters.UUIDConverter;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@UseConverter(UUIDConverter.class)
public @interface AsUUID
{
    /**
     * The default value to coalesce to if enabled
     */
    String defaultValue() default "";
    
    /**
     * Coalesce the value either during conversion or validation
     */
    CoalesceMode coalesce() default CoalesceMode.NEVER;
}
