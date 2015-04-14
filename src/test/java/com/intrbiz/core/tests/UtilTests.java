package com.intrbiz.core.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.junit.Test;

import com.intrbiz.Util;
import com.intrbiz.collections.Condition;
import com.intrbiz.collections.Mapping;

public class UtilTests
{

    @Test
    public void testUcFirst()
    {
        assertThat(Util.ucFirst("test"), is(equalTo("Test")));
    }

    @Test
    public void testLcFirst()
    {
        assertThat(Util.lcFirst("Test"), is(equalTo("test")));
    }    
    
    @Test
    public void testUc()
    {
        assertThat(Util.uc("test"), is(equalTo("TEST")));
    }
    
    @Test
    public void testLc()
    {
        assertThat(Util.lc("TEST"), is(equalTo("test")));
    }
    
    @Test
    public void testLpad()
    {
        assertThat(Util.lpad("test", '_', -1004), is(equalTo("test")));
        assertThat(Util.lpad("test", '_', -1), is(equalTo("test")));
        assertThat(Util.lpad("test", '_', 0), is(equalTo("test")));
        assertThat(Util.lpad("test", '_', 1), is(equalTo("_test")));
        assertThat(Util.lpad("test", '_', 2), is(equalTo("__test")));
        assertThat(Util.lpad("test", '_', 3), is(equalTo("___test")));
        assertThat(Util.lpad("test", '_', 4), is(equalTo("____test")));
    }
    
    @Test
    public void testLpadTo()
    {
        assertThat(Util.lpadTo("test", '_', -1004), is(equalTo("test")));
        assertThat(Util.lpadTo("test", '_', -1), is(equalTo("test")));
        assertThat(Util.lpadTo("test", '_', 4), is(equalTo("test")));
        assertThat(Util.lpadTo("test", '_', 5), is(equalTo("_test")));
        assertThat(Util.lpadTo("test", '_', 6), is(equalTo("__test")));
        assertThat(Util.lpadTo("test", '_', 7), is(equalTo("___test")));
        assertThat(Util.lpadTo("test", '_', 8), is(equalTo("____test")));
    }
    
    @Test
    public void testRpad()
    {
        assertThat(Util.rpad("test", '_', -1004), is(equalTo("test")));
        assertThat(Util.rpad("test", '_', -1), is(equalTo("test")));
        assertThat(Util.rpad("test", '_', 0), is(equalTo("test")));
        assertThat(Util.rpad("test", '_', 1), is(equalTo("test_")));
        assertThat(Util.rpad("test", '_', 2), is(equalTo("test__")));
        assertThat(Util.rpad("test", '_', 3), is(equalTo("test___")));
        assertThat(Util.rpad("test", '_', 4), is(equalTo("test____")));
    }
    
    @Test
    public void testRpadTo()
    {
        assertThat(Util.rpadTo("test", '_', -1004), is(equalTo("test")));
        assertThat(Util.rpadTo("test", '_', -1), is(equalTo("test")));
        assertThat(Util.rpadTo("test", '_', 4), is(equalTo("test")));
        assertThat(Util.rpadTo("test", '_', 5), is(equalTo("test_")));
        assertThat(Util.rpadTo("test", '_', 6), is(equalTo("test__")));
        assertThat(Util.rpadTo("test", '_', 7), is(equalTo("test___")));
        assertThat(Util.rpadTo("test", '_', 8), is(equalTo("test____")));
    }
    
    @Test
    public void testIsEmpty()
    {
        assertThat(Util.isEmpty((String) null), is(equalTo(true)));
        assertThat(Util.isEmpty((Collection<Object>) null), is(equalTo(true)));
        assertThat(Util.isEmpty((Object[]) null), is(equalTo(true)));
        assertThat(Util.isEmpty((Map<Object,Object>) null), is(equalTo(true)));
        //
        assertThat(Util.isEmpty(""), is(equalTo(true)));
        //
        assertThat(Util.isEmpty(new LinkedList<Object>()), is(equalTo(true)));
        assertThat(Util.isEmpty(new TreeSet<Object>()), is(equalTo(true)));
        //
        assertThat(Util.isEmpty(new Object[] {}), is(equalTo(true)));
        //
        assertThat(Util.isEmpty(new HashMap<Object,Object>()), is(equalTo(true)));
    }
    
    @Test
    public void testJoin()
    {
        List<String> l = new LinkedList<String>();
        l.add("1");
        l.add("2");
        l.add("3");
        assertThat(Util.join(", ", l), is(equalTo("1, 2, 3")));
        //
        assertThat(Util.join(", ", new String[] { "A", "B", "C" }), is(equalTo("A, B, C")));
        //
        assertThat(Util.join(", ", (List<?>) null), is(equalTo("")));
        assertThat(Util.join(", ", (String[]) null), is(equalTo("")));
    }
    
    @Test
    public void testMap()
    {
        List<String> l = new LinkedList<String>();
        l.add("a");
        l.add("b");
        l.add("c");
        //
        List<String> r = Util.map(l, new Mapping<String,String>() {
            public String map(String e)
            {
                return e.toUpperCase();
            }
        });
        //
        assertThat(r,  hasItem("A"));
        assertThat(r,  hasItem("B"));
        assertThat(r,  hasItem("C"));
    }
    
    @Test
    public void testFirst()
    {
        List<String> l = new LinkedList<String>();
        l.add("a");
        l.add("b");
        l.add("c");
        l.add("a");
        l.add("b");
        l.add("c");
        //
        String a = Util.first(l, new Condition<String>(){
            @Override
            public boolean match(String i)
            {
                return "a".equals(i);
            }
        });
        assertThat(a, is(equalTo("a")));
        String b = Util.first(l, new Condition<String>(){
            @Override
            public boolean match(String i)
            {
                return "b".equals(i);
            }
        });
        assertThat(b, is(equalTo("b")));
        String c = Util.first(l, new Condition<String>(){
            @Override
            public boolean match(String i)
            {
                return "c".equals(i);
            }
        });
        //
        assertThat(c, is(equalTo("c")));
    }
}
