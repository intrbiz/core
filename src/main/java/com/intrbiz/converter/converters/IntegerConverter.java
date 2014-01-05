package com.intrbiz.converter.converters;

import static com.intrbiz.Util.*;

import java.lang.annotation.Annotation;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;

public class IntegerConverter extends Converter<Integer>
{
    public IntegerConverter()
    {
        super(Integer.class);
    }
    
    @Override
    public boolean canConvertTo(Class<?> type)
    {
        return type == Integer.class || type == int.class;
    }

    @Override
    public void configure(Annotation data, Annotation[] additional)
    {
    }

    @Override
    public Integer parseValue(String requestvalue) throws ConversionException
    {
        if (isEmpty(requestvalue))
        {
            return null;
        }
        else
        {
            try
            {
                return new Integer(Integer.parseInt(requestvalue));
            }
            catch (Exception e)
            {
                throw new ConversionException("Error converting to int", e);
            }
        }
    }

    @Override
    public String formatValue(Integer in) throws ConversionException
    {
        if (in == null) return "";
        return String.valueOf(in);
    }
}
