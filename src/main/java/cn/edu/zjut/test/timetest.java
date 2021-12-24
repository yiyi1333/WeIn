package cn.edu.zjut.test;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class timetest {
    public static void main(String ar[]){
//        //得到long类型当前时间
//        long  l = System.currentTimeMillis();
////new日期对象
//        Date date =  new  Date(l);
////转换提日期输出格式
//        SimpleDateFormat dateFormat =  new  SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
//        System.out.println(dateFormat.format(date));

        long  l = System.currentTimeMillis();
        Date d = new Date(l);
        SimpleDateFormat dateFormat =  new  SimpleDateFormat( "yyyy-MM-dd" );
        String dateNowStr = dateFormat.format(d);
        java.sql.Date ss = java.sql.Date.valueOf(dateNowStr);
        Time time = new Time(0);
        time.setTime(d.getTime());
    }
}
