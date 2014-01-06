package com.intrbiz.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.intrbiz.converter.converters.UUIDConverter;
import com.intrbiz.validator.validators.UUIDValidator;

/**
 * Assert that the value is a UUID
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@UseValidator(UUIDValidator.class)
@UseConverter(UUIDConverter.class)
public @interface IsaUUID {
}
