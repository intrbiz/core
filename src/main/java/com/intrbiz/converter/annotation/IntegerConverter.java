package com.intrbiz.converter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.converter.converters.ConverterInteger;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ConverterType(converter=ConverterInteger.class)
public @interface IntegerConverter
{
}
