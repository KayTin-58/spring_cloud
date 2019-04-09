package com.example.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * description
 *
 * @author zb 2019/04/03 15:23
 */
public class DateUtil {

    public static void getNewDate() {

        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
            String str="20110823";
            Date dt=sdf.parse(str);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            rightNow.add(Calendar.YEAR,-1);//日期减1年
            rightNow.add(Calendar.MONTH,3);//日期加3个月
            rightNow.add(Calendar.DAY_OF_YEAR,10);//日期加10天
            Date dt1=rightNow.getTime();
            String reStr = sdf.format(dt1);
            System.out.println(reStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
