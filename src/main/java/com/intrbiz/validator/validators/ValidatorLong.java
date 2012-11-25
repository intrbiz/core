package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;
import java.util.Map;

import com.intrbiz.validator.ValidationException;
import com.intrbiz.validator.Validator;
import com.intrbiz.validator.annotation.LongValidator;

public class ValidatorLong implements Validator
{
	private boolean mandatory = false;
	private long min = Long.MIN_VALUE;
	private long max = Long.MAX_VALUE;
    
    public boolean isMandatory()
    {
        return this.mandatory;
    }

    public void configure(Annotation data)
    {
        LongValidator lv = (LongValidator)data;
        this.mandatory = lv.mandatory();
        this.min = lv.min();
        this.max = lv.max();
    }
    
    public void configure(Map<String,Object> data)
    {
    	this.mandatory = (Boolean) data.get("mandatory");
    	this.min = (Long) data.get("min");
    	this.max = (Long) data.get("max");
    }

    public void validate(Object in) throws ValidationException
    {
        if (this.isMandatory() && in == null)
        {
            throw new ValidationException("Field is mandatory");
        }
        if (! (in instanceof Long) && this.isMandatory() )
        {
            throw new ValidationException("Field must be instanceof long");
        }
        else
        {
            if (in != null)
            {
                long i = (Long) in;
                if (i < this.min || i > this.max) { throw new ValidationException("Field must be between " + this.min + " and " + this.max); }
            }   
        }
    }
    
}
