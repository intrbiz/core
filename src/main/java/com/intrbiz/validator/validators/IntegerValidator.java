package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;

import com.intrbiz.metadata.IsaInt;
import com.intrbiz.validator.ValidationException;
import com.intrbiz.validator.Validator;

public class IntegerValidator extends Validator<Integer>
{

    private int min = Integer.MIN_VALUE;

    private int max = Integer.MAX_VALUE;

    public IntegerValidator()
    {
        super(Integer.class);
    }

    @Override
    public void configure(Annotation data, Annotation[] additional)
    {
        super.configure(data, additional);
        if (data instanceof IsaInt)
        {
            IsaInt iv = (IsaInt) data;
            this.min = iv.min();
            this.max = iv.max();
        }
    }

    public void validate(Integer in) throws ValidationException
    {
        super.validate(in);
        if (in != null)
        {
            int i = (Integer) in;
            if (i < this.min || i > this.max) { throw new ValidationException("Value must be between " + this.min + " and " + this.max); }
        }
    }

}
