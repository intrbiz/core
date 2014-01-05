package com.intrbiz.converter.converters;

import static com.intrbiz.Util.*;

import java.util.UUID;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;

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
                throw new ConversionException("The value '" + value + "' could not be converted to a UUID.", e);
            }
        }
    }

    @Override
    public String formatValue(UUID in) throws ConversionException
    {
        return in == null ? "" : in.toString();
    }
}
