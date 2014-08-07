package com.intrbiz.converter.converters;

import static com.intrbiz.Util.*;

import java.lang.annotation.Annotation;

import com.intrbiz.converter.ConversionException;
import com.intrbiz.converter.Converter;
import com.intrbiz.metadata.AsDouble;
import com.intrbiz.metadata.CoalesceMode;
import com.intrbiz.metadata.IsaDouble;
import com.intrbiz.metadata.IsaInt;

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
    
    @Override
    public void configure(Annotation data, Annotation[] additional)
    {
        if (data instanceof AsDouble)
        {
            AsDouble c = (AsDouble) data;
            this.setCoalesce(c.coalesce());
            this.setDefaultValue(c.defaultValue());
        }
        else if (data instanceof IsaInt)
        {
            IsaDouble c = (IsaDouble) data;
            this.setCoalesce(c.coalesce());
            this.setDefaultValue(c.defaultValue());
        }
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
        if (isEmpty(requestvalue)) 
        {
            if (this.coalesce == CoalesceMode.ON_NULL || this.coalesce == CoalesceMode.ALWAYS)
            {
                return this.getDefaultValue();
            }
            return null; 
        }
        if (containsMagicDoSNumber(requestvalue)) throw new ConversionException("The request input is regarded as a potential DoS threat");
        try
        {
            return new Double(Double.parseDouble(requestvalue));
        }
        catch (Exception e)
        {
            if (this.coalesce == CoalesceMode.ON_CONVERSION_ERROR || this.coalesce == CoalesceMode.ON_ANY_ERROR || this.coalesce == CoalesceMode.ALWAYS)
            {
                return this.defaultValue;
            }
            else
            {
                throw new ConversionException("Error converting to double", e);
            }
        }
    }

    @Override
    public String formatValue(Double in) throws ConversionException
    {
        if (in == null) return "";
        return String.valueOf(in);
    }

}
