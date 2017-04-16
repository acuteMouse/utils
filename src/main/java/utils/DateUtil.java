package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 功能：  时间操作相关工具类
 * Created by cgl on 2017/4/16 0016.
 */
public class DateUtil {

    private static SimpleDateFormat format;

    /**
     * 返回精确到‘秒’的字符串日期格式
     *
     * @param date
     * @return
     */
    public static String parseToString(Date date) {
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    /**
     * 返回精确到‘月’的字符串
     *
     * @param date
     * @return
     */
    public static String parseToMonth(Date date) {
        format = new SimpleDateFormat("yyyy-MM");
        return format.format(date);
    }

    /**
     * 返回精确到‘天’的字符串
     *
     * @param date
     * @return
     */
    public static String parseToDay(Date date) {
        format = new SimpleDateFormat("yyyy-MM-dd ");
        return format.format(date);
    }

    /**
     * 返回精确到‘小时’的字符串
     *
     * @param date
     * @return
     */
    public static String parseToHoure(Date date) {
        format = new SimpleDateFormat("yyyy-MM-dd HH");
        return format.format(date);
    }

    /**
     * 返回精确到‘分钟’ 的字符串
     *
     * @param date
     * @return
     */
    public static String parseToMin(Date date) {
        format = new SimpleDateFormat("yyyy-MM-dd HH");
        return format.format(date);
    }

    /**
     * 字符串的时日格式转成 Date
     * @param string
     * @return
     * @throws ParseException
     */
    public static Date parseToDate(String string) throws ParseException {
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(string);
    }

    /**
     * 返回指定日期多少天之前的日期
     * @param date
     * @param days
     * @return Date
     */
    public static Date getDayBefore(Date date,int days){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-days);
        return calendar.getTime();
    }

    /**
     *  返回指定日期多少天以后的日期
     * @param date
     * @param days
     * @return
     */
    public static  Date getDayAfter(Date date,int days){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,days);
        return calendar.getTime();
    }



}
