package com.intrbiz.converter.converters;

import static com.intrbiz.Util.*;

import java.lang.annotation.Annotation;
import java.util.UUID;

import com.intrbiz.Util;
import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;
import com.intrbiz.metadata.AsUUID;
import com.intrbiz.metadata.CoalesceMode;
import com.intrbiz.metadata.IsaUUID;

public class UUIDConverter extends Converter<UUID>
{
    public UUIDConverter()
    {
        super(UUID.class);
    }

    @Override
    public UUID parseValue(String value) throws ConversionException
    {
        if (isEmpty(value))
        {
            if (this.coalesce == CoalesceMode.ON_NULL || this.coalesce == CoalesceMode.ALWAYS)
            {
                return this.defaultValue;
            }
            return null;
        }
        else
        {
            try
            {
                return UUID.fromString(value);
            }
            catch (Exception e)
            {
                if (this.coalesce == CoalesceMode.ON_CONVERSION_ERROR || this.coalesce == CoalesceMode.ON_ANY_ERROR || this.coalesce == CoalesceMode.ALWAYS)
                {
                    return this.defaultValue;
                }
                else
                {
                    throw new ConversionException("The value '" + value + "' could not be converted to a UUID.", e);
                }
            }
        }
    }

    @Override
    public String formatValue(UUID in) throws ConversionException
    {
        return in == null ? "" : in.toString();
    }   
    
    @Override
    public void configure(Annotation data, Annotation[] additional)
    {
        if (data instanceof AsUUID)
        {
            AsUUID v = (AsUUID) data;
            this.setCoalesce(v.coalesce());
            this.setDefaultValue(Util.isEmpty(v.defaultValue()) ? null : UUID.fromString(v.defaultValue()));
        }
        else if (data instanceof IsaUUID)
        {
            IsaUUID v = (IsaUUID) data;
            this.setCoalesce(v.coalesce());
            this.setDefaultValue(Util.isEmpty(v.defaultValue()) ? null : UUID.fromString(v.defaultValue()));
        }
    }
}
