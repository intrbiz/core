package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;

import com.intrbiz.metadata.CoalesceMode;
import com.intrbiz.metadata.IsaFloat;
import com.intrbiz.validator.ValidationException;
import com.intrbiz.validator.Validator;

public class FloatValidator extends Validator<Float>
{
    private float min = Float.MIN_VALUE;

    private float max = Float.MAX_VALUE;

    public FloatValidator()
    {
        super(Float.class);
    }

    public void configure(Annotation data, Annotation[] additional)
    {
        if (data instanceof IsaFloat)
        {
            IsaFloat fv = (IsaFloat) data;
            this.min = fv.min();
            this.max = fv.max();
            this.setMandatory(fv.mandatory());
            this.setCoalesce(fv.coalesce());
            this.setDefaultValue(fv.defaultValue());
        }
    }

    public Float validate(Float in) throws ValidationException
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
