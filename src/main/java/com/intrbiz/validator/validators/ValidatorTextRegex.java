package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.intrbiz.validator.ValidationException;
import com.intrbiz.validator.Validator;
import com.intrbiz.validator.annotation.RegexTextValidator;

public class ValidatorTextRegex implements Validator
{

    protected Pattern pattern ;
    protected boolean mandatory ;
    
    public void configure(Annotation data)
    {
        RegexTextValidator rtv = (RegexTextValidator) data;
        this.mandatory = rtv.mandatory();
        this.pattern = Pattern.compile(rtv.pattern());
    }
    
    public void configure(Map<String,Object> data)
    {
    	this.mandatory = (Boolean) data.get("mandatory");
    	this.pattern = Pattern.compile((String) data.get("pattern"));
    }

    public boolean isMandatory()
    {
        return mandatory;
    }
    
    public void validate(Object in) throws ValidationException
    {
        if (this.isMandatory() && (in == null || ((String)in).length() == 0))
        {
            throw new ValidationException("Field is mandatory");
        }
        if (! (in instanceof String) && this.isMandatory() ) throw new ValidationException("Field must be instanceof string");
        // apply the regex
        String s = (String) in ;
        try
        {
            Matcher m = this.pattern.matcher(s) ;
            if ( ! m.matches())
            {
                throw new ValidationException("Field does not match the specified regualr expression");
            }
        }
        catch (Exception e)
        {
            throw new ValidationException("Field did not validate",e);
        }
    }
    
}
