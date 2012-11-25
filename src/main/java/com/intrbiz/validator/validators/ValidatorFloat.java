package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;
import java.util.Map;

import com.intrbiz.validator.ValidationException;
import com.intrbiz.validator.Validator;
import com.intrbiz.validator.annotation.FloatValidator;

public class ValidatorFloat implements Validator
{

	private boolean mandatory = false;
	private float min = Float.MIN_VALUE;
	private float max = Float.MAX_VALUE;
    
    public boolean isMandatory()
    {
        return this.mandatory;
    }

    public void configure(Annotation data)
    {
        FloatValidator fv = (FloatValidator)data ;
        this.mandatory = fv.mandatory();
        this.min = fv.min();
        this.max = fv.max();
    }
    
    public void configure(Map<String,Object> data)
    {
    	this.mandatory = (Boolean) data.get("mandatory");
    	this.min = (Float) data.get("min");
    	this.max = (Float) data.get("max");
    }

    public void validate(Object in) throws ValidationException
    {
        if (this.isMandatory() && in == null)
        {
            throw new ValidationException("Field is mandatory");
        }
        if (! (in instanceof Float) && this.isMandatory() )
        {
            throw new ValidationException("Field must be instanceof float");
        }
        else
        {
            if (in != null)
            {
                float i = (Float) in;
                if (i < this.min || i > this.max) { throw new ValidationException("Field must be between " + this.min + " and " + this.max); }
            }
        }
    }
    
}
