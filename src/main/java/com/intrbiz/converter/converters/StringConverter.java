package com.intrbiz.converter.converters;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;

public class StringConverter extends Converter<String>
{
    public StringConverter()
    {
        super(String.class);
    }
    
    public String parseValue(String requestvalue) throws ConversionException
    {
        return requestvalue;
    }

    public String formatValue(String in) throws ConversionException
    {
        if (in == null) return "";
        return String.valueOf(in);
    }
    
}
