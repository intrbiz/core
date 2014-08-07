package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;
import java.util.regex.Pattern;

import com.intrbiz.metadata.IsaEmailAddress;

public class EmailValidator extends RegexValidator
{
    @Override
    public void configure(Annotation data, Annotation[] additional)
    {
        super.configure(data, additional);
        if (data instanceof IsaEmailAddress)
        {
            IsaEmailAddress v = (IsaEmailAddress) data;
            this.pattern = Pattern.compile("([^@]+)(@)([A-Za-z0-9\\-_]{2,})(\\.[A-Za-z0-9\\-_]{2,})*");
            this.setMandatory(v.mandatory());
        }
    }
}
