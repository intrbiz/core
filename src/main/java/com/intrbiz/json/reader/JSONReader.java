package com.intrbiz.json.reader;

import java.io.StringReader;

import com.intrbiz.json.JSONException;
import com.intrbiz.json.JSValue;

public class JSONReader
{
	private JSONReaderInternal jr;

	public JSONReader(java.io.InputStream stream)
	{
		this.jr = new JSONReaderInternal(stream);
	}

	public JSONReader(java.io.InputStream stream, String encoding)
	{
		this.jr = new JSONReaderInternal(stream, encoding);
	}

	public JSONReader(java.io.Reader stream)
	{
		this.jr = new JSONReaderInternal(stream);
	}

	public final JSValue readValue() throws JSONException
	{
		try
		{
			return jr.readValue();
		}
		catch (ParseException pe)
		{
			throw new JSONException("Error parsing JSON input", pe);
		}
	}

	public static JSValue parse(String in)
	{
		try
		{
			JSONReader jr = new JSONReader(new StringReader(in));
			return jr.readValue();
		}
		catch (Exception e)
		{
		}
		return null;
	}
}
