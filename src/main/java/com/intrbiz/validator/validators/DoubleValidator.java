package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;

import com.intrbiz.metadata.CoalesceMode;
import com.intrbiz.metadata.IsaDouble;
import com.intrbiz.validator.ValidationException;
import com.intrbiz.validator.Validator;

public class DoubleValidator extends Validator<Double>
{
    private double min = Double.MIN_VALUE;

    private double max = Double.MAX_VALUE;

    public DoubleValidator()
    {
        super(Double.class);
    }

    @Override
    public void configure(Annotation data, Annotation[] additional)
    {
        if (data instanceof IsaDouble)
        {
            IsaDouble dv = (IsaDouble) data;
            this.min = dv.min();
            this.max = dv.max();
            this.setMandatory(dv.mandatory());
            this.setCoalesce(dv.coalesce());
            this.setDefaultValue(dv.defaultValue());
        }
    }

    @Override
    public Double validate(Double in) throws ValidationException
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