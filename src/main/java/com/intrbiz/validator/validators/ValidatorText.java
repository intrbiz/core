package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;
import java.util.Map;

import com.intrbiz.validator.ValidationException;
import com.intrbiz.validator.Validator;
import com.intrbiz.validator.annotation.TextValidator;

public class ValidatorText implements Validator
{
    protected boolean mandatory = false;
    protected int minLength = 0;
    protected int maxLength = Integer.MAX_VALUE;
    
    public boolean isMandatory()
    {
        return this.mandatory;
    }

    public int getMinLength()
    {
        return this.minLength;
    }
    
    public int getMaxLength()
    {
        return this.maxLength;
    }
    
    public void configure(Annotation data)
    {
        TextValidator tv  = (TextValidator)data;
        this.mandatory = tv.mandatory();
        this.minLength = tv.minLength();
        this.maxLength = tv.maxLength();
    }
    
    public void configure(Map<String,Object> data)
    {
    	this.mandatory = (Boolean) data.get("mandatory");
    	this.minLength = (Integer) data.get("minlength");
    	this.maxLength = (Integer) data.get("maxlength");
    }

    public void validate(Object in) throws ValidationException
    {
        if (this.isMandatory() && (in == null || ((String)in).length() == 0))
        {
            throw new ValidationException("Field is mandatory");
        }
        if (! (in instanceof String) && this.isMandatory() ) throw new ValidationException("Field must be instanceof string");
        if (in instanceof String)
        {
            String s = (String) in;
            if (s.length() < this.getMinLength() || s.length() > this.getMaxLength())
                throw new ValidationException("Field must be between " + this.getMaxLength() + " and " + this.getMinLength() + " in length");
        }
    }
    
}
