package com.intrbiz.util;

public final class Option<V extends Object>
{
    private final String name;
    
    public Option(String name)
    {
        this.name = name;
    }
    
    public String name()
    {
        return this.name;
    }
    
    public String toString()
    {
        return this.name;
    }
}
