package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;
import java.util.Date;

import com.intrbiz.metadata.IsaDate;
import com.intrbiz.validator.Validator;

public class DateValidator extends Validator<Date>
{   
    public DateValidator()
    {
        super(Date.class);
    }    
    
    @Override
    public void configure(Annotation data, Annotation[] additional)
    {
        if (data instanceof IsaDate)
        {
            IsaDate v = (IsaDate) data;
            this.setMandatory(v.mandatory());
        }
    }
}
