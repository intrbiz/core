package com.intrbiz.json;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.intrbiz.json.writer.JSONWriter;

public class JSArray implements JSValue
{
	private List<JSValue> elements = new LinkedList<JSValue>();

	public JSArray()
	{
	}
	
	public JSArray(List<JSValue> j)
	{
		this.elements.addAll(j);
	}

	public List<JSValue> getElements()
	{
		return elements;
	}

	public void setElements(List<JSValue> elements)
	{
		this.elements = elements;
	}

	public void addElement(JSValue jv)
	{
		this.elements.add(jv);
	}

	public int size()
	{
		return this.elements.size();
	}

	public JSValue getElement(int idx)
	{
		return this.elements.get(idx);
	}

	public void reverse()
	{
		Collections.reverse(this.elements);
	}
	
	public String toString()
	{
		return JSONWriter.toJSON(this);
	}
}
