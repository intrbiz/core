package com.intrbiz.converter.converters;

import static com.intrbiz.Util.isEmpty;

import java.lang.annotation.Annotation;
import java.util.Map;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;

public class ConverterDouble implements Converter
{
    public void configure(Annotation data)
    {
    }

    public void configure(Map<String, Object> data)
    {
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

    public Object convert(String requestvalue) throws ConversionException
    {
        if (isEmpty(requestvalue)) { return null; }
        if (containsMagicDoSNumber(requestvalue)) throw new ConversionException("The request input is regarded as a potential DoS threat");
        try
        {
            return new Double(Double.parseDouble(requestvalue));
        }
        catch (Exception e)
        {
            throw new ConversionException("Error converting to int", e);
        }
    }

    public String convert(Object in) throws ConversionException
    {
        if (in == null) return "";
        return String.valueOf(in);
    }

}
