package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;

import com.intrbiz.metadata.IsaBoolean;
import com.intrbiz.validator.Validator;

public class BooleanValidator extends Validator<Boolean>
{
    public BooleanValidator()
    {
        super(Boolean.class);
    }

    @Override
    public void configure(Annotation data, Annotation[] additional)
    {
        if (data instanceof IsaBoolean)
        {
            IsaBoolean iv = (IsaBoolean) data;
            this.setMandatory(iv.mandatory());
            this.setCoalesce(iv.coalesce());
            this.setDefaultValue(iv.defaultValue());
        }
    }
}
