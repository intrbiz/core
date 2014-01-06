package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;

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
        super.configure(data, additional);
        if (data instanceof IsaDouble)
        {
            IsaDouble dv = (IsaDouble) data;
            this.min = dv.min();
            this.max = dv.max();
        }
    }

    @Override
    public void validate(Double in) throws ValidationException
    {
        if (in != null)
        {
            double i = (Double) in;
            if (i < this.min || i > this.max) { throw new ValidationException("Value must be between " + this.min + " and " + this.max); }
        }
    }
}