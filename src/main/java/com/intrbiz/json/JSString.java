package com.intrbiz.json;

import com.intrbiz.json.writer.JSONWriter;

public class JSString implements JSValue
{
    private String string;

    public JSString()
    {
    }

    public JSString(String s)
    {
        this.string = s;
    }

    public String getString()
    {
        return string;
    }

    public void setString(String string)
    {
        this.string = string;
    }

    public String toString()
    {
        return JSONWriter.toJSON(this);
    }

}
