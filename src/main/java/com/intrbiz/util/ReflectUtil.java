package com.intrbiz.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import static com.intrbiz.Util.*;

public class ReflectUtil
{
	public static List<Field> getFields(Class<?> c)
	{
		List<Field> r = new LinkedList<Field>();
		getFields(c,r);
		return r;
	}
	
	private static void getFields(Class<?> c, List<Field> lst)
	{
		if (c == null) return;
		for (Field f : c.getDeclaredFields())
		{
			lst.add(f);
		}
		getFields(c.getSuperclass(),lst);
	}
	
	public static Method getGetter(Class<?> c, Field f)
	{
		try
		{
			String name = "get" + ucFirst(f.getName());
			return c.getMethod(name, new Class[] {}) ;
		}
		catch (Exception e)
		{
		}
		try
		{
			String name = "is" + ucFirst(f.getName());
			return c.getMethod(name, new Class[] {}) ;
		}
		catch (Exception e)
		{
		}
		return null;
	}
	
	public static Method getSetter(Class<?> c, Field f)
	{
		try
		{
			String name = "set" + ucFirst(f.getName());
			return c.getMethod(name, new Class[] {f.getType()}) ;	
		}
		catch (Exception e)
		{
		}
		return null;
	}
}
