package com.intrbiz.converter;

public class ConversionException extends Exception
{
    private static final long serialVersionUID = 1L;

    public ConversionException()
    {
        super();
    }

    /**
     * @param message
     * @param cause
     */
    public ConversionException(String message, Throwable cause)
    {
        super(message, cause);
    }

    /**
     * @param message
     */
    public ConversionException(String message)
    {
        super(message);
    }

    /**
     * @param cause
     */
    public ConversionException(Throwable cause)
    {
        super(cause);
    }
    
}
