package com.intrbiz.converter.converters;

import static com.intrbiz.Util.*;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;

public class FloatConverter extends Converter<Float>
{
    public FloatConverter()
    {
        super(Float.class);
    }
    
    @Override
    public boolean canConvertTo(Class<?> type)
    {
        return type == Float.class || type == float.class;
    }

    @Override
    public Float parseValue(String requestvalue) throws ConversionException
    {
        if (isEmpty(requestvalue))
        {
            return null;
        }
        try
        {
            return new Float(Float.parseFloat(requestvalue));
        }
        catch (Exception e)
        {
            throw new ConversionException("Error converting to float",e);
        }
    }
    
    @Override
    public String formatValue(Float in) throws ConversionException
    {
        if (in == null) return "" ;
        return String.valueOf(in);
    }
}
