package com.intrbiz.converter.converters;

import static com.intrbiz.Util.*;

import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;
import com.intrbiz.metadata.AsDate;

public class DateConverter extends Converter<Date>
{
    private SimpleDateFormat format;
    
    public DateConverter()
    {
        super(Date.class);
    }

    @Override    
    public void configure(Annotation data, Annotation[] additional)
    {
        AsDate dconv = (AsDate) data;
        this.format = new SimpleDateFormat(dconv.value());
    }

    @Override
    public Date parseValue(String requestvalue) throws ConversionException
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
            throw new ConversionException("Error converting to Date", e);
        }
    }

    @Override
    public String formatValue(Date in) throws ConversionException
    {
        try
        {
            if (in == null) return "";
            return this.format.format(in);
        }
        catch (Exception e)
        {
            throw new ConversionException("Error formatting Date", e);
        }
    }
}
