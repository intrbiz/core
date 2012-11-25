package com.intrbiz.converter.converters;

import static com.intrbiz.Util.isEmpty;

import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;
import com.intrbiz.converter.annotation.DateConverter;

public class ConverterDate implements Converter
{
    private SimpleDateFormat format;

    public void configure(Annotation data)
    {
        DateConverter dconv = (DateConverter) data;
        this.format = new SimpleDateFormat(dconv.pattern());
    }
    
    public void configure(Map<String,Object> data)
    {
    	this.format = new SimpleDateFormat((String) data.get("pattern"));
    }

    public Object convert(String requestvalue) throws ConversionException
    {
        if (isEmpty(requestvalue))
        {
            return null;
        }
        try
        {
            return this.format.parse(requestvalue);
        }
        catch (Exception e)
        {
            throw new ConversionException("Error converting to int", e);
        }
    }

    public String convert(Object in) throws ConversionException
    {
        try
        {
            if (in == null) return "";
            return this.format.format((Date) in);
        }
        catch (Exception e)
        {
            throw new ConversionException("Error formatting date", e);
        }
    }
}
