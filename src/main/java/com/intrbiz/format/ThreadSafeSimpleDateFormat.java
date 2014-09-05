package com.intrbiz.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSafeSimpleDateFormat implements DateFormatter
{
    private final SimpleDateFormat master;
    
    public ThreadSafeSimpleDateFormat(String pattern)
    {
        if (pattern == null) throw new IllegalArgumentException("The date pattern must be given");
        this.master = new SimpleDateFormat(pattern);
    }
    
    protected SimpleDateFormat createFormatter()
    {
        return (SimpleDateFormat) this.master.clone();
    }

    @Override
    public String format(Date date)
    {
        return this.createFormatter().format(date);
    }

    @Override
    public Date parse(String date) throws ParseException
    {
        return this.createFormatter().parse(date);
    }
}
