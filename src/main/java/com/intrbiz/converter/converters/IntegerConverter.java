package com.intrbiz.converter.converters;

import static com.intrbiz.Util.*;

import java.lang.annotation.Annotation;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;
import com.intrbiz.metadata.AsInt;
import com.intrbiz.metadata.CoalesceMode;
import com.intrbiz.metadata.IsaInt;

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
        if (data instanceof AsInt)
        {
            AsInt c = (AsInt) data;
            this.setCoalesce(c.coalesce());
            this.setDefaultValue(c.defaultValue());
        }
        else if (data instanceof IsaInt)
        {
            IsaInt c = (IsaInt) data;
            this.setCoalesce(c.coalesce());
            this.setDefaultValue(c.defaultValue());
        }
    }

    @Override
    public Integer parseValue(String requestvalue) throws ConversionException
    {
        if (isEmpty(requestvalue))
        {
            if (this.coalesce == CoalesceMode.ON_NULL || this.coalesce == CoalesceMode.ALWAYS)
            {
                return this.getDefaultValue();
            }
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
                if (this.coalesce == CoalesceMode.ON_CONVERSION_ERROR || this.coalesce == CoalesceMode.ON_ANY_ERROR || this.coalesce == CoalesceMode.ALWAYS)
                {
                    return this.defaultValue;
                }
                else
                {
                    throw new ConversionException("Error converting to int", e);
                }
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
