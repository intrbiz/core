package com.intrbiz.converter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.converter.converters.ConverterDate;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ConverterType(converter=ConverterDate.class)
public @interface TimeConverter
{
    String pattern() default "hh:mm:ss" ;
}
