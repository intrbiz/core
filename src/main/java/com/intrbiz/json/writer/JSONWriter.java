package com.intrbiz.json.writer;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

import com.intrbiz.json.JSArray;
import com.intrbiz.json.JSBoolean;
import com.intrbiz.json.JSCustomObject;
import com.intrbiz.json.JSNumber;
import com.intrbiz.json.JSONException;
import com.intrbiz.json.JSObject;
import com.intrbiz.json.JSString;
import com.intrbiz.json.JSValue;
import com.intrbiz.json.util.StringSerialiser;

public class JSONWriter
{
	private static final NumberFormat fmt = new DecimalFormat("#.######");
	
	private PrintWriter to;

	public JSONWriter(Writer w)
	{
		this.to = new PrintWriter(w);
	}

	public void writeValue(JSValue value) throws JSONException
	{
		if (value == null)
		{
			to.write("null");
		}
		else if (value instanceof JSObject)
		{
			this.writeObject((JSObject) value);
		}
		else if (value instanceof JSArray)
		{
			this.writeArray((JSArray) value);
		}
		else if (value instanceof JSString)
		{
			this.writeString((JSString) value);
		}
		else if (value instanceof JSBoolean)
		{
			this.writeBoolean((JSBoolean) value);
		}
		else if (value instanceof JSNumber)
		{
			this.writeNumber((JSNumber) value);
		}
		else if (value instanceof JSCustomObject)
		{
			this.writeCustomObject((JSCustomObject) value);
		}
	}

	public void writeCustomObject(JSCustomObject obj) throws JSONException
	{
		if (obj.getClassname() == null)
			throw new JSONException("Classname cannot be null");
		to.write(" new ");
		to.write(obj.getClassname());
		to.write("(");
		boolean nc = false;
		for (JSValue arg : obj.getArguments())
		{
			if (nc)
				to.write(",");
			this.writeValue(arg);
			nc = true;
		}
		to.write(")");

	}

	public void writeArray(JSArray array) throws JSONException
	{
		to.write('[');
		boolean nc = false;
		for (JSValue jv : array.getElements())
		{
			if (nc)
				to.write(',');
			this.writeValue(jv);
			nc = true;
		}
		to.write(']');
	}

	public void writeBoolean(JSBoolean obj) throws JSONException
	{
		to.write(String.valueOf(obj.isBoolean()));
	}

	public void writeNumber(JSNumber obj) throws JSONException
	{
		to.write( fmt.format( obj.getNumber() ) );
	}

	public void writeString(JSString obj) throws JSONException
	{
		to.write('\"');
		to.write(StringSerialiser.encode(obj.getString()));
		to.write('\"');
	}

	public void writeObject(JSObject obj) throws JSONException
	{
		to.write('{');
		boolean nc = false;
		for (Map.Entry<String, JSValue> en : obj.getMembers().entrySet())
		{
			if (nc)
				to.write(',');
			to.write('"');
			to.write(en.getKey());
			to.write('"');
			to.write(':');
			this.writeValue(en.getValue());
			nc = true;
		}
		to.write('}');
	}

	public void close()
	{
		this.to.close();
	}

	public void flush()
	{
		this.to.flush();
	}

	public static String toJSON(JSValue val)
	{
		StringWriter sw = new StringWriter();
		try
		{
			JSONWriter jw = new JSONWriter(sw);
			jw.writeValue(val);
			jw.close();
		}
		catch (Exception e)
		{
		}
		return sw.toString();
	}
}
