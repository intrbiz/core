package com.intrbiz.configuration;

public interface Configurable<CFGTYPE extends Configuration>
{
    void configure(CFGTYPE cfg) throws Exception;
    CFGTYPE getConfiguration();
}
