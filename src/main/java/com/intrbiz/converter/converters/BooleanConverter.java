package com.intrbiz.converter.converters;

import static com.intrbiz.Util.*;

import java.lang.annotation.Annotation;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;
import com.intrbiz.metadata.AsBoolean;
import com.intrbiz.metadata.CoalesceMode;
import com.intrbiz.metadata.IsaBoolean;

public class BooleanConverter extends Converter<Boolean>
{
    public BooleanConverter()
    {
        super(Boolean.class);
    }
    
    @Override
    public void configure(Annotation data, Annotation[] additional)
    {
        if (data instanceof AsBoolean)
        {
            AsBoolean c = (AsBoolean) data;
            this.setCoalesce(c.coalesce());
            this.setDefaultValue(c.defaultValue());
        }
        else if (data instanceof IsaBoolean)
        {
            IsaBoolean c = (IsaBoolean) data;
            this.setCoalesce(c.coalesce());
            this.setDefaultValue(c.defaultValue());
        }
    }

    @Override
    public Boolean parseValue(String value) throws ConversionException
    {
        if (isEmpty(value))
        {
            if (this.coalesce == CoalesceMode.ON_NULL || this.coalesce == CoalesceMode.ALWAYS)
            {
                return this.getDefaultValue();
            }
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
            if (this.coalesce == CoalesceMode.ON_CONVERSION_ERROR || this.coalesce == CoalesceMode.ON_ANY_ERROR || this.coalesce == CoalesceMode.ALWAYS)
            {
                return this.defaultValue;
            }
            else
            {
                throw new ConversionException("The value '" + value + "' could not be converted to a boolean.");
            }
        }
    }

    @Override
    public String formatValue(Boolean in) throws ConversionException
    {
        if (in == null) return "";
        return in ? "true" : "false";
    }
}
