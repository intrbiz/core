package com.intrbiz.validator;

public class ValidationException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public ValidationException()
    {
        super();
    }

    /**
     * @param message
     * @param cause
     */
    public ValidationException(String message, Throwable cause)
    {
        super(message, cause);
    }

    /**
     * @param message
     */
    public ValidationException(String message)
    {
        super(message);
    }

    /**
     * @param cause
     */
    public ValidationException(Throwable cause)
    {
        super(cause);
    }
    
}
