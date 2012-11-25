package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;
import java.util.Map;

import com.intrbiz.validator.ValidationException;
import com.intrbiz.validator.Validator;
import com.intrbiz.validator.annotation.IntegerValidator;

public class ValidatorInteger implements Validator
{

	private boolean mandatory = false;
	private int min = Integer.MIN_VALUE;
	private int max = Integer.MAX_VALUE;

    public boolean isMandatory()
    {
        return mandatory;
    }

    public void configure(Annotation data)
    {
        IntegerValidator iv = (IntegerValidator) data;
        this.mandatory = iv.mandatory();
        this.min = iv.min();
        this.max = iv.max();
    }
    
    public void configure(Map<String,Object> data)
    {
    	this.mandatory = (Boolean) data.get("mandatory");
    	this.min = (Integer) data.get("min");
    	this.max = (Integer) data.get("max");
    }

    public void validate(Object in) throws ValidationException
    {
        if (this.isMandatory() && in == null)
        {
            throw new ValidationException("Field is mandatory");
        }
        if ((!(in instanceof Integer)) && this.isMandatory())
        {
            throw new ValidationException("Field must be instanceof integer");
        }
        else
        {
            if (in != null)
            {
                int i = (Integer) in;
                if (i < this.min || i > this.max) { throw new ValidationException("Field must be between " + this.min + " and " + this.max); }
            }
        }
    }

}
