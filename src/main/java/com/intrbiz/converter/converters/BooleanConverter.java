package com.intrbiz.converter.converters;

import static com.intrbiz.Util.*;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;

public class BooleanConverter extends Converter<Boolean>
{
    public BooleanConverter()
    {
        super(Boolean.class);
    }

    @Override
    public Boolean parseValue(String value) throws ConversionException
    {
        if (isEmpty(value))
        {
            return null;
        }
        else if ("true".equalsIgnoreCase(value) || "yes".equalsIgnoreCase(value) || "on".equalsIgnoreCase(value))
        {
            return true;
        }
        else if ("false".equalsIgnoreCase(value) || "no".equalsIgnoreCase(value) || "off".equalsIgnoreCase(value))
        {
            return false;
        }
        else
        {
            throw new ConversionException("The value '" + value + "' could not be converted to a boolean.");
        }
    }

    @Override
    public String formatValue(Boolean in) throws ConversionException
    {
        if (in == null) return "";
        return in ? "true" : "false";
    }
}
