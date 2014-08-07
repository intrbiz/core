package com.intrbiz.converter.converters;

import static com.intrbiz.Util.*;

import java.lang.annotation.Annotation;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;
import com.intrbiz.metadata.AsFloat;
import com.intrbiz.metadata.CoalesceMode;
import com.intrbiz.metadata.IsaFloat;

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
    public void configure(Annotation data, Annotation[] additional)
    {
        if (data instanceof AsFloat)
        {
            AsFloat c = (AsFloat) data;
            this.setCoalesce(c.coalesce());
            this.setDefaultValue(c.defaultValue());
        }
        else if (data instanceof IsaFloat)
        {
            IsaFloat c = (IsaFloat) data;
            this.setCoalesce(c.coalesce());
            this.setDefaultValue(c.defaultValue());
        }
    }

    @Override
    public Float parseValue(String requestvalue) throws ConversionException
    {
        if (isEmpty(requestvalue))
        {
            if (this.coalesce == CoalesceMode.ON_NULL || this.coalesce == CoalesceMode.ALWAYS)
            {
                return this.getDefaultValue();
            }
            return null;
        }
        try
        {
            return new Float(Float.parseFloat(requestvalue));
        }
        catch (Exception e)
        {
            if (this.coalesce == CoalesceMode.ON_CONVERSION_ERROR || this.coalesce == CoalesceMode.ON_ANY_ERROR || this.coalesce == CoalesceMode.ALWAYS)
            {
                return this.defaultValue;
            }
            else
            {
                throw new ConversionException("Error converting to float",e);
            }
        }
    }
    
    @Override
    public String formatValue(Float in) throws ConversionException
    {
        if (in == null) return "" ;
        return String.valueOf(in);
    }
}
