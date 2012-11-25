package com.intrbiz.converter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.intrbiz.converter.annotation.ConverterType;

public final class ConverterManager
{

    public static final Converter getConverter(Method method) throws ConversionException
    {
        try
        {
            Annotation converter = getConverterType(method.getAnnotations());
            ConverterType converterType = converter.annotationType().getAnnotation(ConverterType.class);
            Converter conv = converterType.converter().newInstance();
            conv.configure(converter);
            return conv;
        }
        catch (Exception e)
        {
            throw new ConversionException("Error loading converter", e);
        }
    }

    private static Annotation getConverterType(Annotation[] annotations)
    {
        for (int i = 0; i < annotations.length; i++)
        {
            Annotation ann = annotations[i];
            if (ann.annotationType().isAnnotationPresent(ConverterType.class)) return ann;
        }
        return null;
    }
}
