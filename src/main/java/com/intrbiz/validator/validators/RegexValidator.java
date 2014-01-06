package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.intrbiz.metadata.CheckRegEx;
import com.intrbiz.validator.ValidationException;
import com.intrbiz.validator.Validator;

public class RegexValidator extends Validator<String>
{
    protected Pattern pattern;
    
    public RegexValidator()
    {
        super(String.class);
    }
    
    @Override
    public void configure(Annotation data, Annotation[] additional)
    {
        super.configure(data, additional);
        if (data instanceof CheckRegEx)
        {
            CheckRegEx rtv = (CheckRegEx) data;
            this.pattern = Pattern.compile(rtv.value());
        }
    }
    
    @Override
    public void validate(String in) throws ValidationException
    {
        super.validate(in);
        if (in != null)
        {
            try
            {
                Matcher m = this.pattern.matcher(in) ;
                if ( ! m.matches())
                {
                    throw new ValidationException("Value does not match the specified regualr expression");
                }
            }
            catch (Exception e)
            {
                throw new ValidationException("Value could not be validated",e);
            }
        }
    }
    
}
