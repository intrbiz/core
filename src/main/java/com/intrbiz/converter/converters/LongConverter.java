package com.intrbiz.converter.converters;

import static com.intrbiz.Util.*;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;

public class LongConverter extends Converter<Long>
{
    public LongConverter()
    {
        super(Long.class);
    }
    
    @Override
    public boolean canConvertTo(Class<?> type)
    {
        return type == Long.class || type == long.class;
    }

    @Override
    public Long parseValue(String requestvalue) throws ConversionException
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
            throw new ConversionException("Error converting to long",e);
        }
    }
    
    @Override
    public String formatValue(Long in) throws ConversionException
    {
        if (in == null) return "" ;
        return String.valueOf(in);
    }
}
