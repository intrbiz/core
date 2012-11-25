package com.intrbiz.json;

import com.intrbiz.json.writer.JSONWriter;

public class JSBoolean implements JSValue
{
	private Boolean bool = false;

	public JSBoolean()
	{
	}

	public JSBoolean(Boolean bool)
	{
		this.bool = bool;
	}

	public Boolean isBoolean()
	{
		return bool;
	}

	public void setBoolean(Boolean bool)
	{
		this.bool = bool;
	}
	
	public String toString()
	{
		return JSONWriter.toJSON(this);
	}
}
