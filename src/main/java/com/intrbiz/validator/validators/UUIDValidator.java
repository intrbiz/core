package com.intrbiz.validator.validators;

import java.util.UUID;

import com.intrbiz.validator.Validator;

public class UUIDValidator extends Validator<UUID>
{
    public UUIDValidator()
    {
        super(UUID.class);
    }
}
