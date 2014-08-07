package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.intrbiz.metadata.CheckRegEx;
import com.intrbiz.metadata.CoalesceMode;
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
        if (data instanceof CheckRegEx)
        {
            CheckRegEx rtv = (CheckRegEx) data;
            this.pattern = Pattern.compile(rtv.value());
            this.setMandatory(rtv.mandatory());
            this.setCoalesce(rtv.coalesce());
            this.setDefaultValue(rtv.defaultValue());
        }
    }
    
    @Override
    public String validate(String in) throws ValidationException
    {
        in = super.validate(in);
        if (in != null)
        {
            try
            {
                Matcher m = this.pattern.matcher(in) ;
                if ( ! m.matches())
                {
                    if (this.coalesce == CoalesceMode.ON_VALIDATION_ERROR || this.coalesce == CoalesceMode.ON_ANY_ERROR || this.coalesce == CoalesceMode.ALWAYS)
                    {
                        return this.defaultValue;
                    }
                    else
                    {
                        throw new ValidationException("Value does not match the specified regualr expression");
                    }
                }
            }
            catch (Exception e)
            {
                if (this.coalesce == CoalesceMode.ON_VALIDATION_ERROR || this.coalesce == CoalesceMode.ON_ANY_ERROR || this.coalesce == CoalesceMode.ALWAYS)
                {
                    return this.defaultValue;
                }
                else
                {
                    throw new ValidationException("Value could not be validated", e);
                }
            }
        }
        return in;
    }
    
}
