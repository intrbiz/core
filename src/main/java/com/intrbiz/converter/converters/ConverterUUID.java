package com.intrbiz.converter.converters;

import static com.intrbiz.Util.isEmpty;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.UUID;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;

public class ConverterUUID implements Converter
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
        else
        {
            try
            {
                return UUID.fromString(requestvalue);
            }
            catch (Exception e)
            {
                throw new ConversionException("Error converting to UUID", e);
            }
        }
    }

    public String convert(Object in) throws ConversionException
    {
        if (in == null) return "";
        return ((UUID)in).toString();
    }
}
