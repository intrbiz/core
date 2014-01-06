package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;

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
        super.configure(data, additional);
        if (data instanceof IsaLong)
        {
            IsaLong lv = (IsaLong) data;
            this.min = lv.min();
            this.max = lv.max();
        }
    }

    public void validate(Long in) throws ValidationException
    {
        super.validate(in);
        if (in != null)
        {
            long i = (Long) in;
            if (i < this.min || i > this.max) { throw new ValidationException("Value must be between " + this.min + " and " + this.max); }
        }
    }

}
