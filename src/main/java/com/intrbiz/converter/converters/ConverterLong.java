package com.intrbiz.converter.converters;

import static com.intrbiz.Util.isEmpty;

import java.lang.annotation.Annotation;
import java.util.Map;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;

public class ConverterLong implements Converter
{
    public void configure(Annotation data)
    {
    }
    
    public void configure(Map<String,Object> data)
    {
    }

    public Object convert(String requestvalue) throws ConversionException
    {
        if (isEmpty(requestvalue))
        {
            return null;
        }
        try
        {
            return new Long(Long.parseLong(requestvalue));
        }
        catch (Exception e)
        {
            throw new ConversionException("Error converting to int",e);
        }
    }
    
    public String convert(Object in) throws ConversionException
    {
        if (in == null) return "" ;
        return String.valueOf(in);
    }
}
