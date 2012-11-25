package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.UUID;

import com.intrbiz.validator.ValidationException;
import com.intrbiz.validator.Validator;
import com.intrbiz.validator.annotation.UUIDValidator;

public class ValidatorUUID implements Validator
{
    private boolean mandatory = false;

    public boolean isMandatory()
    {
        return mandatory;
    }

    public void configure(Annotation data)
    {
        UUIDValidator iv = (UUIDValidator) data;
        this.mandatory = iv.mandatory();
    }

    public void configure(Map<String, Object> data)
    {
        this.mandatory = (Boolean) data.get("mandatory");
    }

    public void validate(Object in) throws ValidationException
    {
        if (this.isMandatory() && in == null) { throw new ValidationException("Field is mandatory"); }
        if ((!(in instanceof UUID)) && this.isMandatory()) { throw new ValidationException("Field must be instanceof UUID"); }
    }

}
