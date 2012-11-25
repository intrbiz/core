package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;
import java.util.Map;

import com.intrbiz.validator.ValidationException;
import com.intrbiz.validator.Validator;
import com.intrbiz.validator.annotation.DoubleValidator;

public class ValidatorDouble implements Validator
{
	private boolean mandatory = false;
	private double min = Double.MIN_VALUE;
	private double max = Double.MAX_VALUE;
    
    public boolean isMandatory()
    {
        return this.mandatory;
    }
    
    public void configure(Annotation data)
    {
        DoubleValidator  dv = (DoubleValidator)data;
        this.mandatory = dv.mandatory();
        this.min = dv.min();
        this.max = dv.max();
    }
    
    public void configure(Map<String,Object> data)
    {
    	this.mandatory = (Boolean) data.get("mandatory");
    	this.min = (Double) data.get("min");
    	this.max = (Double) data.get("max");
    }

    public void validate(Object in) throws ValidationException
    {
        if (this.isMandatory() && in == null)
        {
            throw new ValidationException("Field is mandatory");
        }
        if (! (in instanceof Double) && this.isMandatory() ) 
        {
            throw new ValidationException("Field must be instanceof double");
        }
        else
        {
            if (in != null)
            {
                double i = (Double) in;
                if (i < this.min || i > this.max) { throw new ValidationException("Field must be between " + this.min + " and " + this.max); }
            }
        }
    }
    
}