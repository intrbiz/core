package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;
import java.util.regex.Pattern;

import com.intrbiz.validator.annotation.EmailValidator;

public class ValidatorEmail extends ValidatorTextRegex
{

    @Override
    public void configure(Annotation data)
    {
        EmailValidator ev = (EmailValidator) data ;
        this.mandatory = ev.mandatory();
        this.pattern = Pattern.compile("([^@]+)(@)([A-Za-z0-9\\-_]{2,})(\\.[A-Za-z0-9\\-_]{2,})*");
    }

}
