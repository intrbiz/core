package com.intrbiz.validator;

import java.lang.annotation.Annotation;
import java.util.Map;

public interface Validator
{
    public void configure(Annotation data);
    public void configure(Map<String,Object> data);
    public void validate(Object in) throws ValidationException ;
    boolean isMandatory();
}
