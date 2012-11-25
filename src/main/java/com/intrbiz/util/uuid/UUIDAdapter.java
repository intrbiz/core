package com.intrbiz.util.uuid;

import java.util.UUID;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class UUIDAdapter extends XmlAdapter<String, UUID>
{
    @Override
    public String marshal(UUID arg0) throws Exception
    {
        if (arg0 == null) return null;
        return arg0.toString();
    }

    @Override
    public UUID unmarshal(String arg0) throws Exception
    {
        if (arg0 == null) return null;
        return UUID.fromString(arg0);
    }
}
