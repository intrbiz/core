package com.intrbiz.json;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.intrbiz.json.writer.JSONWriter;

public class JSCustomObject implements JSValue
{
	private List<JSValue> arguments = new LinkedList<JSValue>();

	private String classname;
	
	public JSCustomObject()
	{
	}

	public JSCustomObject(String classname, JSValue... arguments)
	{
		this.classname = classname;
		for (JSValue val : arguments)
		{
			this.arguments.add(val);
		}
	}

	public JSCustomObject(String classname, List<JSValue> arguments)
	{
		this.classname = classname;
		this.arguments.addAll(arguments);
	}
	
	public void addArgument(JSValue val)
	{
		this.arguments.add(val);
	}

	public List<JSValue> getArguments()
	{
		return arguments;
	}

	public void setArguments(List<JSValue> arguments)
	{
		this.arguments = arguments;
	}

	public String getClassname()
	{
		return classname;
	}

	public void setClassname(String classname)
	{
		this.classname = classname;
	}
	
	public void reverse()
	{
		Collections.reverse(this.arguments);
	}
	
	public String toString()
	{
		return JSONWriter.toJSON(this);
	}
}
