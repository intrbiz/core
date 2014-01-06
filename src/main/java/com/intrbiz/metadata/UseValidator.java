package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.validator.Validator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UseValidator {
    Class<? extends Validator<?>> value();
}
