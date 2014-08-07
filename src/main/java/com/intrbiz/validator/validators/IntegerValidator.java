package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;

import com.intrbiz.metadata.CoalesceMode;
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
        if (data instanceof IsaInt)
        {
            IsaInt iv = (IsaInt) data;
            this.min = iv.min();
            this.max = iv.max();
            this.setMandatory(iv.mandatory());
            this.setCoalesce(iv.coalesce());
            this.setDefaultValue(iv.defaultValue());
        }
    }

    public Integer validate(Integer in) throws ValidationException
    {
        in = super.validate(in);
        if (in != null)
        {
            if (in < this.min || in > this.max)
            {
                if (this.coalesce == CoalesceMode.ON_VALIDATION_ERROR || this.coalesce == CoalesceMode.ON_ANY_ERROR || this.coalesce == CoalesceMode.ALWAYS)
                {
                    return this.defaultValue;
                }
                else
                {
                    throw new ValidationException("Value must be between " + this.min + " and " + this.max);
                }
            }
        }
        return in;
    }

}
