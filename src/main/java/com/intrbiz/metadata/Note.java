package com.intrbiz.metadata;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * An arbitary textual note
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Note {
    String value();
}
