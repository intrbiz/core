package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;

import com.intrbiz.metadata.CheckStringLength;
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
        super.configure(data, additional);
        if (data instanceof CheckStringLength)
        {
            CheckStringLength tv  = (CheckStringLength) data;
            this.minLength = tv.min();
            this.maxLength = tv.max();
        }
    }

    @Override
    public void validate(String in) throws ValidationException
    {
        super.validate(in);
        if (in != null && (in.length() < this.getMinLength() || in.length() > this.getMaxLength())) throw new ValidationException("Value must be between " + this.getMaxLength() + " and " + this.getMinLength() + " in length");
    }
    
}
