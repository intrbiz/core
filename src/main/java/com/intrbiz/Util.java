package com.intrbiz;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;

import com.intrbiz.collections.Condition;
import com.intrbiz.collections.Mapping;

/**
 * Core util library
 * 
 * Designed for:
 * 
 * import static com.intrbiz.core.Util.*;
 * 
 */
public final class Util
{
    private Util() {}
    
    public static final Charset UTF8 = Charset.forName("UTF8");

    /*
     * String stuff
     */

    /**
     * Convert the first character of a string to upper case
     */
    public final static String ucFirst(String s)
    {
        if (s == null) return null;
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    /**
     * Convert the first character of a string to lower case
     */
    public final static String lcFirst(String s)
    {
        if (s == null) return null;
        return s.substring(0, 1).toLowerCase() + s.substring(1);
    }

    /**
     * Convert a string to upper case
     */
    public final static String uc(String s)
    {
        if (s == null) return null;
        return s.toUpperCase();
    }

    /**
     * Convert a string to lower case
     */
    public final static String lc(String s)
    {
        if (s == null) return null;
        return s.toLowerCase();
    }

    /**
     * Append a character to the left hand side of a string a number of times
     */
    public final static String lpad(String s, char with, int count)
    {
        StringBuilder sb = new StringBuilder();
        for (; count > 0; count--)
        {
            sb.append(with);
        }
        sb.append(s);
        return sb.toString();
    }

    /**
     * Append a character to the left hand side of a string until the resultant string is of the given length
     */
    public final static String lpadTo(String s, char with, int length)
    {
        return lpad(s, with, length - s.length());
    }

    /**
     * Append a character to the right hand side of a string a number of times
     */
    public final static String rpad(String s, char with, int count)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (; count > 0; count--)
        {
            sb.append(with);
        }
        return sb.toString();
    }

    /**
     * Append a character to the right hand side of a string until the resultant string is of the given length
     */
    public final static String rpadTo(String s, char with, int length)
    {
        return rpad(s, with, length - s.length());
    }

    /*
     * Empty stuff
     */

    /**
     * Is the string empty: is it null or ""
     */
    public final static boolean isEmpty(String s)
    {
        return (s == null || s.length() <= 0);
    }
    
    @SafeVarargs
    public final static <T> T coalesce(T... ss)
    {
        for (T s : ss)
        {
            if (s != null) return s;
        }
        return null;
    }
    
    public final static String coalesceEmpty(String... ss)
    {
        for (String s : ss)
        {
            if (! isEmpty(s)) return s;
        }
        return null;
    }
    
    @SafeVarargs
    public final static <C extends Collection<?>> C coalesceEmpty(C... cc)
    {
        for (C c : cc)
        {
            if (! isEmpty(c)) return c;
        }
        return null;
    }
    
    public static <T,U> U nullable(T on, Function<T,U> action)
    {
        return on == null ? null : action.apply(on);
    }
    
    public static <T, U, E extends Exception> U requireNotNull(T on, Function<T,U> action, Supplier<E> onNull) throws E
    {
        if (on == null) throw onNull.get();
        return action.apply(on);
    }
    
    public static <T, E extends Exception> T requireNotNull(T on, Supplier<E> onNull) throws E
    {
        if (on == null) throw onNull.get();
        return on;
    }

    /**
     * Is the collection empty
     */
    public final static boolean isEmpty(Collection<?> c)
    {
        if (c == null) return true;
        return c.isEmpty();
    }

    /**
     * Is the array empty
     */
    public final static boolean isEmpty(Object[] c)
    {
        if (c == null) return true;
        return c.length == 0;
    }

    /**
     * Is the map empty
     */
    public final static boolean isEmpty(Map<?, ?> c)
    {
        if (c == null) return true;
        return c.isEmpty();
    }

    /*
     * Collection stuff
     */

    /**
     * Create a String by joining all elements of the collection with the separator
     */
    public final static String join(String separator, Iterable<?> over)
    {
        StringBuilder ret = new StringBuilder();
        if (over != null)
        {
            boolean ns = false;
            if (over != null)
            {
                for (Object i : over)
                {
                    if (ns) ret.append(separator);
                    ret.append(String.valueOf(i));
                    ns = true;
                }
            }
        }
        return ret.toString();
    }

    public final static String join(String separator, Object[] over)
    {
        StringBuilder ret = new StringBuilder();
        if (over != null)
        {
            boolean ns = false;
            if (over != null)
            {
                for (Object i : over)
                {
                    if (ns) ret.append(separator);
                    ret.append(String.valueOf(i));
                    ns = true;
                }
            }
        }
        return ret.toString();
    }

    /**
     * Apply a operation to every element in the collection and return a collection of results
     */
    public final static <I, O> Collection<O> map(Iterable<I> from, Collection<O> to, Mapping<I, O> mapping)
    {
        if (mapping == null) throw new IllegalArgumentException("Cannot map without a mapping");
        if (from != null && to != null)
        {
            for (I item : from)
            {
                to.add(mapping.map(item));
            }
        }
        return to;
    }

    public final static <I, O> List<O> map(List<I> from, Mapping<I, O> mapping)
    {
        return (List<O>) map(from, new LinkedList<O>(), mapping);
    }

    public final static <I, O> Set<O> map(Set<I> from, Mapping<I, O> mapping)
    {
        return (Set<O>) map(from, new HashSet<O>(), mapping);
    }

    public final static <I, O> SortedSet<O> map(SortedSet<I> from, Mapping<I, O> mapping)
    {
        return (SortedSet<O>) map(from, new TreeSet<O>(), mapping);
    }

    public final static <IK, IV, OK, OV> Map<OK, OV> map(Map<IK, IV> from, Map<OK, OV> to, Mapping<Entry<IK, IV>, Entry<OK, OV>> mapping)
    {
        if (mapping == null) throw new IllegalArgumentException("Cannot map without a mapping");
        for (Entry<IK, IV> e : from.entrySet())
        {
            Entry<OK, OV> o = mapping.map(e);
            to.put(o.getKey(), o.getValue());
        }
        return to;
    }

    /**
     * Get the first element in the collection which matches the given condition
     */
    public final static <E> E first(Iterable<E> over, Condition<E> matcher)
    {
        if (over != null)
        {
            for (E i : over)
            {
                if (matcher.match(i)) return i;
            }
        }
        return null;
    }
    
    public final static <E> E first(E[] over, Condition<E> matcher)
    {
        if (over != null)
        {
            for (E i : over)
            {
                if (matcher.match(i)) return i;
            }
        }
        return null;
    }

    /**
     * Get the last element in the collection which matches the given condition
     */
    public final static <E> E last(List<E> over, Condition<E> matcher)
    {
        if (over != null)
        {
            ListIterator<E> i = over.listIterator();
            while (i.hasPrevious())
            {
                E o = i.previous();
                if (matcher.match(o)) return o;
            }
        }
        return null;
    }

    /**
     * Find all elements in the collection which matches the given condition
     */
    public final static <E> Collection<E> filter(Collection<E> over, Collection<E> to, Condition<E> matcher)
    {
        if (over != null && to != null)
        {
            for (E i : over)
            {
                if (matcher.match(i)) to.add(i);
            }
        }
        return to;
    }

    public final static <E> List<E> filter(List<E> over, Condition<E> matcher)
    {
        return (List<E>) filter(over, new LinkedList<E>(), matcher);
    }

    public final static <E> Set<E> filter(Set<E> over, Condition<E> matcher)
    {
        return (Set<E>) filter(over, new HashSet<E>(), matcher);
    }

    public final static <E> SortedSet<E> filter(SortedSet<E> over, Condition<E> matcher)
    {
        return (SortedSet<E>) filter(over, new TreeSet<E>(), matcher);
    }
    
    /**
     * Reduce down a set of objects to another set of object
     */
    public final static <I, O> Collection<O> filter(Iterable<I> from, Collection<O> to, Mapping<I, O> mapping)
    {
        if (mapping == null) throw new IllegalArgumentException("Cannot map without a mapping");
        if (from != null && to != null)
        {
            for (I item : from)
            {
                O value = mapping.map(item);
                if (value != null) to.add(value);
            }
        }
        return to;
    }

    public final static <I, O> List<O> filter(List<I> from, Mapping<I, O> mapping)
    {
        return (List<O>) filter(from, new LinkedList<O>(), mapping);
    }

    public final static <I, O> Set<O> filter(Set<I> from, Mapping<I, O> mapping)
    {
        return (Set<O>) filter(from, new HashSet<O>(), mapping);
    }

    public final static <I, O> SortedSet<O> filter(SortedSet<I> from, Mapping<I, O> mapping)
    {
        return (SortedSet<O>) filter(from, new TreeSet<O>(), mapping);
    }

    public final static <IK, IV, OK, OV> Map<OK, OV> filter(Map<IK, IV> from, Map<OK, OV> to, Mapping<Entry<IK, IV>, Entry<OK, OV>> mapping)
    {
        if (mapping == null) throw new IllegalArgumentException("Cannot map without a mapping");
        for (Entry<IK, IV> e : from.entrySet())
        {
            Entry<OK, OV> o = mapping.map(e);
            if (o != null) to.put(o.getKey(), o.getValue());
        }
        return to;
    }

    /*
     * URL util
     */

    public final static String urlEncode(String s, Charset charset)
    {
        try
        {
            return URLEncoder.encode(s, charset.name());
        }
        catch (Exception e)
        {
        }
        return null;
    }

    public final static String urlDecode(String s, Charset charset)
    {
        try
        {
            return URLDecoder.decode(s, charset.name());
        }
        catch (Exception e)
        {
        }
        return null;
    }

    /*
     * XML
     */

    public final static String xmlEncode(String in)
    {
        if (in == null) return "";
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < in.length(); i++)
        {
            char ch = in.charAt(i);
            switch (ch)
            {
                case '<':
                {
                    ret.append("&lt;");
                    break;
                }
                case '>':
                {
                    ret.append("&gt;");
                    break;
                }
                case '&':
                {
                    ret.append("&amp;");
                    break;
                }
                case '"':
                {
                    ret.append("&quot;");
                    break;
                }
                case '\r':
                case '\n':
                {
                    ret.append("&#");
                    ret.append(Integer.toString(ch));
                    ret.append(';');
                    break;
                }
                default:
                {
                    ret.append(ch);
                }
            }
        }
        return ret.toString();
    }

    public final static void xmlEncode(String input, Writer writer) throws IOException
    {
        if (input != null)
        {
            for (int i = 0; i < input.length(); i++)
            {
                char ch = input.charAt(i);
                switch (ch)
                {
                    case '<':
                    {
                        writer.write("&lt;");
                        break;
                    }
                    case '>':
                    {
                        writer.write("&gt;");
                        break;
                    }
                    case '&':
                    {
                        writer.write("&amp;");
                        break;
                    }
                    case '"':
                    {
                        writer.write("&quot;");
                        break;
                    }
                    case '\r':
                    case '\n':
                    {
                        writer.write("&#");
                        writer.write(Integer.toString(ch));
                        writer.write(';');
                        break;
                    }
                    default:
                    {
                        writer.write(ch);
                    }
                }
            }
        }
    }

    /*
     * HTML
     */

    public final static String htmlEncode(String in)
    {
        if (in == null) return "";
        StringBuilder buf = new StringBuilder();
        for (char c : in.toCharArray())
        {
            if (32 <= c && c <= 126 && c != '<' && c != '>' && c != '\'' && c != '&' && c != '"')
            {
                buf.append(c);
            }
            else if (c == '\r' || c == '\n' || c == '\t')
            {
                buf.append(c);
            }
            else
            {
                switch (c)
                {
                    case '&':
                        buf.append("&amp;");
                        break;
                    case '"':
                        buf.append("&quot;");
                        break;
                    case '<':
                        buf.append("&lt;");
                        break;
                    case '>':
                        buf.append("&gt;");
                        break;
                    default:
                        buf.append("&#x").append(Integer.toHexString(c)).append(";");
                }
            }
        }
        return buf.toString();
    }

    public final static void htmlEncode(String in, Writer writer) throws IOException
    {
        if (in != null)
        {
            for (char c : in.toCharArray())
            {
                if (32 <= c && c <= 126 && c != '<' && c != '>' && c != '\'' && c != '&' && c != '"')
                {
                    writer.write(c);
                }
                else if (c == '\r' || c == '\n' || c == '\t')
                {
                    writer.write(c);
                }
                else
                {
                    switch (c)
                    {
                        case '&':
                            writer.write("&amp;");
                            break;
                        case '"':
                            writer.write("&quot;");
                            break;
                        case '<':
                            writer.write("&lt;");
                            break;
                        case '>':
                            writer.write("&gt;");
                            break;
                        default:
                            writer.write("&#x");
                            writer.write(Integer.toHexString(c));
                            writer.write(";");
                    }
                }
            }
        }
    }
    
    public static String loadResourceAsString(Class<?> relative, String path)
    {
        InputStream in = relative.getResourceAsStream(path);
        if (in != null)
        {
            StringBuilder sb = new StringBuilder();
            try (InputStreamReader r = new InputStreamReader(in, UTF8))
            {
                char[] b = new char[1024];
                int l;
                while ((l = r.read(b)) != -1)
                {
                    sb.append(b, 0, l);
                }
            }
            catch (IOException e)
            {
                throw new RuntimeException("Failed to load resource " + path, e);
            }
            return sb.toString();
        }
        throw new RuntimeException("Failed to load resource " + path);
    }
}
