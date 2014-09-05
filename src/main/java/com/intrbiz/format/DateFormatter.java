package com.intrbiz.format;

import java.text.ParseException;
import java.util.Date;

public interface DateFormatter
{
    String format(Date date);
    
    Date parse(String date) throws ParseException;
}
