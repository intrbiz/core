package com.intrbiz.converter;

import java.lang.annotation.Annotation;
import java.util.Map;

public interface Converter
{
    public void configure(Annotation data);
    public void configure(Map<String,Object> data);
    public Object convert(String requestvalue) throws ConversionException ;
    public String convert(Object in) throws ConversionException ;
}
