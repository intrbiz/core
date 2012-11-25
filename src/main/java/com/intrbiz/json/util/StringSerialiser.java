package com.intrbiz.json.util;

public class StringSerialiser
{

	public static String encode(String s)
	{
		StringBuilder r = new StringBuilder();
		if (s != null)
		{
			for (char c : s.toCharArray())
			{
				switch (c)
				{
				case '\\':
					r.append('\\').append('\\');
					break;
				case '"':
					r.append('\\').append('"');
					break;
				case '\'':
					r.append('\\').append('\'');
					break;
				case '\b':
					r.append('\\').append('b');
					break;
				case '\f':
					r.append('\\').append('f');
					break;
				case '\n':
					r.append('\\').append('n');
					break;
				case '\r':
					r.append('\\').append('r');
					break;
				case '\t':
					r.append('\\').append('t');
					break;
				case '\0':
					break;
				default:
					r.append(c);
					break;
				}
			}
		}
		return r.toString();
	}

	public static String decode(String s)
	{
		if (s.startsWith("\"") || s.startsWith("'")) s = s.substring(1);
		if (s.endsWith("\"") || s.endsWith("'")) s = s.substring(0, s.length() - 1);
		StringBuilder sb = new StringBuilder();
		char[] cs = s.toCharArray();
		int i = 0, l = cs.length;
		char c;
		while (i < l)
		{
			c = cs[i];
			i++;
			if (c == '\\')
			{
				c = cs[i];
				i++;
				if (c == 'u')
				{
					sb.appendCodePoint(Integer.parseInt(new String(new char[] { cs[i], cs[++i], cs[++i], cs[++i] }), 16));
					i++;
				}
				else
				{
					sb.append(decodeEscapedChar(c));
				}
			}
			else
			{
				sb.append(c);
			}
		}
		return sb.toString();
	}

	private static char decodeEscapedChar(char c)
	{
		switch (c)
		{
		case 'n':
			return '\n';
		case 'b':
			return '\b';
		case 'f':
			return '\f';
		case 't':
			return '\t';
		case 'r':
			return '\r';
		case '\"':
			return '\"';
		case '\'':
			return '\'';
		case '\\':
			return '\\';
		case '/':
			return '/';
		default:
			throw new IllegalStateException("Unexpected escape character: " + c);
		}
	}
}
