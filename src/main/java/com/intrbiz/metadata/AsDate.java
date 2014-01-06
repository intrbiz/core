package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.converter.converters.DateConverter;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@UseConverter(DateConverter.class)
public @interface AsDate
{
    String pattern() default "dd/MM/yyyy";
}
