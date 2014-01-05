package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.converter.IsConverter;
import com.intrbiz.converter.converters.IntegerConverter;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@IsConverter(converter=IntegerConverter.class)
public @interface AsInt
{
}
