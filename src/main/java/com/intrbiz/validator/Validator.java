package com.intrbiz.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.intrbiz.metadata.IsMandatory;
import com.intrbiz.metadata.UseValidator;

public abstract class Validator<T>
{
    private final Class<T> type;
    
    protected boolean mandatory = false;
    
    public Validator(Class<T> type)
    {
        this.type = type;
    }
    
    public final Class<T> getType()
    {
        return this.type;
    }
    
    public boolean canValidate(Class<?> type)
    {
        return this.getType() == type;
    }
    
    public final boolean isMandatory()
    {
        return this.mandatory;
    }
    
    protected void setMandatory(boolean mandatory)
    {
        this.mandatory = mandatory;
    }
    
    public void configure(Annotation data, Annotation[] additional)
    {
        // is there a mandatory annotation?
        for (Annotation a : additional)
        {
            if (a instanceof IsMandatory)
            {
                this.setMandatory(true);
                break;
            }
        }        
    }
    
    public void validate(T in) throws ValidationException
    {
        if (this.isMandatory() && in == null) throw new ValidationException("A not-null value is required");
    }
    
    //
    
    public static final Validator<?> fromParameter(Class<?> parameterType, Annotation[] parameterAnnotations) throws ValidationException
    {
        try
        {
            Annotation validator = getValidatorType(parameterAnnotations);
            if (validator != null)
            {
                UseValidator type = validator.annotationType().getAnnotation(UseValidator.class);
                Validator<?> valid = type.value().newInstance();
                valid.configure(validator, parameterAnnotations);
                return valid;
            }
        }
        catch (Exception e)
        {
            throw new ValidationException("Error loading validator", e);
        }
        return null;
    }
    
    public static final Validator<?> fromMethod(Method method) throws ValidationException
    {
        try
        {
            Annotation[] annos = method.getAnnotations();
            Annotation validator = getValidatorType(annos);
            if (validator != null)
            {
                UseValidator type = validator.annotationType().getAnnotation(UseValidator.class);
                Validator<?> valid = type.value().newInstance();
                valid.configure(validator, annos);
                return valid;
            }
        }
        catch (Exception e)
        {
            throw new ValidationException("Error loading validator", e);
        }
        return null;
    }

    private static Annotation getValidatorType(Annotation[] annotations)
    {
        for (Annotation ann : annotations)
        {
            if (ann.annotationType().isAnnotationPresent(UseValidator.class)) return ann;
        }
        return null;
    }
}
