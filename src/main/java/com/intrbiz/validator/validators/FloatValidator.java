package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;

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
        super.configure(data, additional);
        if (data instanceof IsaFloat)
        {
            IsaFloat fv = (IsaFloat) data;
            this.min = fv.min();
            this.max = fv.max();
        }
    }

    public void validate(Float in) throws ValidationException
    {
        super.validate(in);
        if (in != null)
        {
            float i = (Float) in;
            if (i < this.min || i > this.max) { throw new ValidationException("Value must be between " + this.min + " and " + this.max); }
        }
    }

}
