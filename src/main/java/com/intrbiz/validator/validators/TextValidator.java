package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;

import com.intrbiz.metadata.CheckStringLength;
import com.intrbiz.metadata.CoalesceMode;
import com.intrbiz.validator.ValidationException;
import com.intrbiz.validator.Validator;

public class TextValidator extends Validator<String>
{
    protected int minLength = 0;
    
    protected int maxLength = Integer.MAX_VALUE;
    
    public TextValidator()
    {
        super(String.class);
    }

    public int getMinLength()
    {
        return this.minLength;
    }
    
    public int getMaxLength()
    {
        return this.maxLength;
    }
    
    @Override
    public void configure(Annotation data, Annotation[] additional)
    {
        if (data instanceof CheckStringLength)
        {
            CheckStringLength tv  = (CheckStringLength) data;
            this.minLength = tv.min();
            this.maxLength = tv.max();
            this.setMandatory(tv.mandatory());
            this.setCoalesce(tv.coalesce());
            this.setDefaultValue(tv.defaultValue());
        }
    }

    @Override
    public String validate(String in) throws ValidationException
    {
        in = super.validate(in);
        if (in != null && (in.length() < this.getMinLength() || in.length() > this.getMaxLength()))
        {
            if (this.coalesce == CoalesceMode.ON_VALIDATION_ERROR || this.coalesce == CoalesceMode.ON_ANY_ERROR || this.coalesce == CoalesceMode.ALWAYS)
            {
                return this.defaultValue;
            }
            else
            {
                throw new ValidationException("Value must be between " + this.getMaxLength() + " and " + this.getMinLength() + " in length");
            }
        }
        return in;
    }
    
}
