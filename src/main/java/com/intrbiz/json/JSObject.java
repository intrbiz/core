package com.intrbiz.json;

import java.util.LinkedHashMap;
import java.util.Map;

import com.intrbiz.json.writer.JSONWriter;

public class JSObject implements JSValue
{
    private Map<String,JSValue> members = new LinkedHashMap<String,JSValue>();
    
    public JSObject()
    {
    }

    public Map<String, JSValue> getMembers()
    {
        return members;
    }

    public void setMembers(Map<String, JSValue> members)
    {
        this.members = members;
    }
    
    public void addMember(String n, JSValue jv)
    {
        this.members.put(n,jv);
    }
    
    public JSValue getMember(String n)
    {
        return this.members.get(n);
    }
    
    public void removeMember(String n)
    {
        this.members.remove(n);
    }
    
	public String toString()
	{
		return JSONWriter.toJSON(this);
	}
}
