package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.Map;

import com.intrbiz.validator.ValidationException;
import com.intrbiz.validator.Validator;
import com.intrbiz.validator.annotation.DateValidator;

public class ValidatorDate implements Validator
{
    protected boolean mandatory = false ;
    
    public boolean isMandatory()
    {
        return mandatory;
    }
    
    public void configure(Annotation data)
    {
        this.mandatory = ((DateValidator) data).mandatory();
    }
    
    public void configure(Map<String,Object> data)
    {
    	this.mandatory = (Boolean) data.get("mandatory");
    }

    public void validate(Object in) throws ValidationException
    {
        if (this.isMandatory() && in == null)
        {
            throw new ValidationException("Field is mandatory");
        }
        if (! (in instanceof Date) && this.isMandatory() ) 
            throw new ValidationException("Field must be instanceof double");
    }
    
}
