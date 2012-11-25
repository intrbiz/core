package com.intrbiz.json;

import com.intrbiz.json.writer.JSONWriter;

public class JSNumber implements JSValue
{
	private Number number = null;

	public JSNumber()
	{
	}

	public JSNumber(Number n)
	{
		this.number = n;
	}

	public Number getNumber()
	{
		return number;
	}

	public void setNumber(Number number)
	{
		this.number = number;
	}

	public String toString()
	{
		return JSONWriter.toJSON(this);
	}
}
