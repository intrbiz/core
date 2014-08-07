package com.intrbiz.converter.converters;

import java.lang.annotation.Annotation;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;
import com.intrbiz.metadata.AsString;
import com.intrbiz.metadata.CheckRegEx;
import com.intrbiz.metadata.CheckStringLength;
import com.intrbiz.metadata.CoalesceMode;

public class StringConverter extends Converter<String>
{
    public StringConverter()
    {
        super(String.class);
    }
    
    public String parseValue(String requestvalue) throws ConversionException
    {
        if (requestvalue == null && (this.coalesce == CoalesceMode.ON_NULL || this.coalesce == CoalesceMode.ALWAYS))
        {
            return this.defaultValue;
        }
        return requestvalue;
    }

    public String formatValue(String in) throws ConversionException
    {
        if (in == null) return "";
        return String.valueOf(in);
    }
    
    @Override
    public void configure(Annotation data, Annotation[] additional)
    {
        if (data instanceof AsString)
        {
            AsString v = (AsString) data;
            this.setCoalesce(v.coalesce());
            this.setDefaultValue(v.defaultValue());
        }
        else if (data instanceof CheckRegEx)
        {
            CheckRegEx v = (CheckRegEx) data;
            this.setCoalesce(v.coalesce());
            this.setDefaultValue(v.defaultValue());
        }
        else if (data instanceof CheckStringLength)
        {
            CheckStringLength v = (CheckStringLength) data;
            this.setCoalesce(v.coalesce());
            this.setDefaultValue(v.defaultValue());
        }
    }
}
