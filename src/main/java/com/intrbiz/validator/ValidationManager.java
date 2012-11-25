package com.intrbiz.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.intrbiz.validator.annotation.ValidatorType;

public final class ValidationManager
{

    public static final Validator getValidator(Method method) throws ValidationException
    {
        try
        {
            Annotation converter = getConverterType(method.getAnnotations());
            ValidatorType type = converter.annotationType().getAnnotation(ValidatorType.class);
            Validator valid = type.validator().newInstance();
            valid.configure(converter);
            return valid;
        }
        catch (Exception e)
        {
            throw new ValidationException("Error loading validator", e);
        }
    }

    private static Annotation getConverterType(Annotation[] annotations)
    {
        for (int i = 0; i < annotations.length; i++)
        {
            Annotation ann = annotations[i];
            if (ann.annotationType().isAnnotationPresent(ValidatorType.class)) return ann;
        }
        return null;
    }

}
