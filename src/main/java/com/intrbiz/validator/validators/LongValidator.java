package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;

import com.intrbiz.metadata.CoalesceMode;
import com.intrbiz.metadata.IsaLong;
import com.intrbiz.validator.ValidationException;
import com.intrbiz.validator.Validator;

public class LongValidator extends Validator<Long>
{
    private long min = Long.MIN_VALUE;

    private long max = Long.MAX_VALUE;

    public LongValidator()
    {
        super(Long.class);
    }

    @Override
    public void configure(Annotation data, Annotation[] additional)
    {
        if (data instanceof IsaLong)
        {
            IsaLong lv = (IsaLong) data;
            this.min = lv.min();
            this.max = lv.max();
            this.setMandatory(lv.mandatory());
            this.setCoalesce(lv.coalesce());
            this.setDefaultValue(lv.defaultValue());
        }
    }

    public Long validate(Long in) throws ValidationException
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
