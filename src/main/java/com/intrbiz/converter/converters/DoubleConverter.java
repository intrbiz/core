package com.intrbiz.converter.converters;

import static com.intrbiz.Util.*;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;

public class DoubleConverter extends Converter<Double>
{
    public DoubleConverter()
    {
        super(Double.class);
    }
    
    @Override
    public boolean canConvertTo(Class<?> type)
    {
        return type == Double.class || type == double.class;
    }

    /**
     * See:
     * http://www.theregister.co.uk/2011/02/07/java_denial_of_service_bug/
     * http://blogs.adobe.com/asset/2011/02/year-of-the-snail.html
     * @param s
     * @return
     * returns boolean
     */
    public static boolean containsMagicDoSNumber(String s)
    {
        return s.replace(".", "").contains("2225073858507201");
    }

    @Override
    public Double parseValue(String requestvalue) throws ConversionException
    {
        if (isEmpty(requestvalue)) { return null; }
        if (containsMagicDoSNumber(requestvalue)) throw new ConversionException("The request input is regarded as a potential DoS threat");
        try
        {
            return new Double(Double.parseDouble(requestvalue));
        }
        catch (Exception e)
        {
            throw new ConversionException("Error converting to double", e);
        }
    }

    @Override
    public String formatValue(Double in) throws ConversionException
    {
        if (in == null) return "";
        return String.valueOf(in);
    }

}
