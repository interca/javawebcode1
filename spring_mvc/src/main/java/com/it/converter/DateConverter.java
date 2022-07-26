package com.it.converter;

import org.springframework.core.convert.converter.Converter;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String source) {
        //将日期字符串，转化为日期对象
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Data parse=null;
        try {
            parse = (Data) simpleDateFormat.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return (Date) parse;
    }
}
