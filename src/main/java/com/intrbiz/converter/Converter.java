package com.intrbiz.converter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.intrbiz.metadata.UseConverter;


/**
 * Convert from and to the textual representation of a Java value
 */
public abstract class Converter<T>
{
    private final Class<T> type;

    public Converter(Class<T> type)
    {
        this.type = type;
    }

    /**
     * The type of the value
     */
    public final Class<T> getType()
    {
        return this.type;
    }
    
    public boolean canConvertTo(Class<?> type)
    {
        return this.getType() == type;
    }

    public void configure(Annotation annotation, Annotation[] additional)
    {
    }

    /**
     * Convert the given string to its value
     */
    public abstract T parseValue(String value) throws ConversionException;

    /**
     * Convert the given value to its String value
     */
    public abstract String formatValue(T in) throws ConversionException;

    //
    
    public static final Converter<?> fromParameter(Class<?> paramType, Annotation[] paramAnnos) throws ConversionException
    {
        try
        {
            Annotation converter = getConverterAnnotation(paramAnnos);
            if (converter != null)
            {
                UseConverter useConverter = converter.annotationType().getAnnotation(UseConverter.class);
                Converter<?> conv = useConverter.value().newInstance();
                conv.configure(converter, paramAnnos);
                return conv;
            }
        }
        catch (Exception e)
        {
            throw new ConversionException("Error loading converter", e);
        }
        return null;
    }

    public static final Converter<?> fromMethod(Method method) throws ConversionException
    {
        try
        {
            Annotation[] annotations = method.getAnnotations();
            Annotation converter = getConverterAnnotation(annotations);
            if (converter != null)
            {
                UseConverter useConverter = converter.annotationType().getAnnotation(UseConverter.class);
                Converter<?> conv = useConverter.value().newInstance();
                conv.configure(converter, annotations);
                return conv;
            }
        }
        catch (Exception e)
        {
            throw new ConversionException("Error loading converter", e);
        }
        return null;
    }

    private static Annotation getConverterAnnotation(Annotation[] annotations)
    {
        for (Annotation ann : annotations)
        {
            if (ann.annotationType().isAnnotationPresent(UseConverter.class)) return ann;
        }
        return null;
    }
}
