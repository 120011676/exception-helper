package com.gihub.qq120011676.ladybird.web.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        String p = "yyyy-MM-dd HH:mm:ss";
        String d = "2019-08-01";
        System.out.println(p.substring(0, d.length()));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.toLocalizedPattern());
        System.out.println(simpleDateFormat.toPattern());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm").toLocalizedPattern());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH").toPattern());
        Date date = simpleDateFormat.parse("2019-08-08");
        System.out.println(date);
    }
}
