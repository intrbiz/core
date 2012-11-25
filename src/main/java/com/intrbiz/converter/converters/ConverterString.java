package com.intrbiz.converter.converters;

import java.lang.annotation.Annotation;
import java.util.Map;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;

public class ConverterString implements Converter
{

    public void configure(Annotation data)
    {
    }
    
    public void configure(Map<String,Object> data)
    {
    }

    public Object convert(String requestvalue) throws ConversionException
    {
        return requestvalue ;
    }

    public String convert(Object in) throws ConversionException
    {
        if (in == null) return "" ;
        return String.valueOf(in);
    }
    
}
