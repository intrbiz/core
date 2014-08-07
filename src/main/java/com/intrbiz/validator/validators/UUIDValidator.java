package com.intrbiz.validator.validators;

import java.lang.annotation.Annotation;
import java.util.UUID;

import com.intrbiz.Util;
import com.intrbiz.metadata.IsaUUID;
import com.intrbiz.validator.Validator;

public class UUIDValidator extends Validator<UUID>
{
    public UUIDValidator()
    {
        super(UUID.class);
    }

    @Override
    public void configure(Annotation data, Annotation[] additional)
    {
        if (data instanceof IsaUUID)
        {
            IsaUUID v = (IsaUUID) data;
            this.setMandatory(v.mandatory());
            this.setCoalesce(v.coalesce());
            this.setDefaultValue(Util.isEmpty(v.defaultValue()) ? null : UUID.fromString(v.defaultValue()));
        }
    }
}
