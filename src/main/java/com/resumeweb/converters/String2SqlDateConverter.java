package com.resumeweb.converters;

import org.springframework.core.convert.converter.Converter;

import java.sql.Date;

public class String2SqlDateConverter implements Converter<String,Date> {
    /**
     * 日期必须符合 yyyy-mm-dd格式
     * @param s
     * @return
     */
    @Override
    public Date convert(String s) {
        Date date = null;
        if(s == null || s.equals("") || s.equals("undefined") || s.equals("null"))
            return date;
        try {
            date = Date.valueOf(s);
        }catch (IllegalArgumentException e){
            System.err.println("Date Format Error:" + e.getMessage());
        }
        return date;
    }
}
