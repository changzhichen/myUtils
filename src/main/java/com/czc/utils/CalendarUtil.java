package com.czc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author changzhichen
 * @date 2020-05-01 11:22
 */
public class CalendarUtil {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        // 当前时间的前一天
        System.out.println(calendar.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            calendar.setTime(sdf.parse("2020-4-30 00:00:00"));
            calendar.add(Calendar.MONTH, -1);
            System.out.println(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
