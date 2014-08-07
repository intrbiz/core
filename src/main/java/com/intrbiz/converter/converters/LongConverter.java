package com.intrbiz.converter.converters;

import static com.intrbiz.Util.*;

import java.lang.annotation.Annotation;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;
import com.intrbiz.metadata.AsLong;
import com.intrbiz.metadata.CoalesceMode;
import com.intrbiz.metadata.IsaLong;

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
            if (this.coalesce == CoalesceMode.ON_NULL || this.coalesce == CoalesceMode.ALWAYS)
            {
                return this.defaultValue;
            }
            return null;
        }
        try
        {
            return new Long(Long.parseLong(requestvalue));
        }
        catch (Exception e)
        {
            if (this.coalesce == CoalesceMode.ON_CONVERSION_ERROR || this.coalesce == CoalesceMode.ON_ANY_ERROR || this.coalesce == CoalesceMode.ALWAYS)
            {
                return this.defaultValue;
            }
            else
            {
                throw new ConversionException("Error converting to long", e);
            }
        }
    }
    
    @Override
    public String formatValue(Long in) throws ConversionException
    {
        if (in == null) return "" ;
        return String.valueOf(in);
    }

    @Override
    public void configure(Annotation data, Annotation[] additional)
    {
        if (data instanceof AsLong)
        {
            AsLong c = (AsLong) data;
            this.setCoalesce(c.coalesce());
            this.setDefaultValue(c.defaultValue());
        }
        else if (data instanceof IsaLong)
        {
            IsaLong c = (IsaLong) data;
            this.setCoalesce(c.coalesce());
            this.setDefaultValue(c.defaultValue());
        }
    }
}
