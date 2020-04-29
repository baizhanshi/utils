package com.rambo.tools;

import org.apache.commons.lang.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 */
public class DateUtil extends org.apache.commons.lang.time.DateUtils {

    private static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm"};

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到上年年份字符串 格式（yyyy）
     */
    public static String getLastYear() {
        Date years = addYears(new Date(), -1);
        return formatDate(years, "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getLastMonth() {
        Date months = addMonths(new Date(), -1);
        return formatDate(months, "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式
     * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     * "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取过去的天数
     * <p>
     * param date
     * return
     */
    public static long pastDays(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时
     * <p>
     * param date
     * return
     */
    public static long pastHour(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟
     * <p>
     * param date
     * return
     */
    public static long pastMinutes(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 1000);
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     * <p>
     * param timeMillis
     * return
     */
    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /**
     * 获取两个日期之间的天数
     * <p>
     * param before
     * param after
     * return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }

    /**
     * 得到某年某周的第一天
     * <p>
     * param year
     * param week
     * return
     */
    public static Date getFirstDayOfWeek(int year, int week) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);

        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7);

        return getFirstDayOfWeek(cal.getTime());
    }

    /**
     * 得到某年某周的最后一天
     * <p>
     * param year
     * param week
     * return
     */
    public static Date getLastDayOfWeek(int year, int week) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7);

        return getLastDayOfWeek(cal.getTime());
    }

    /**
     * 取得当前日期所在周的第一天
     * <p>
     * param date
     * return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek()); // Sunday
        return calendar.getTime();
    }

    /**
     * 取得当前日期所在周的最后一天
     * <p>
     * param date
     * return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6); // Saturday
        return calendar.getTime();
    }

    /**
     * 取得当前日期所在周的前一周最后一天
     * <p>
     * param date
     * return
     */
    public static Date getLastDayOfLastWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfWeek(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.WEEK_OF_YEAR) - 1);
    }

    /**
     * 返回指定日期的月的第一天
     * <p>
     * param date
     * return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), 1);
        return calendar.getTime();
    }

    /**
     * Description:获取指定日期年的第一天
     */
    public static Date getFirstDayOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), Calendar.JANUARY, 1);
        return calendar.getTime();
    }

    /**
     * Description:获取指定日期年的最后一天
     */
    public static Date getLastDayOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), Calendar.DECEMBER, 31);
        return calendar.getTime();
    }

    /**
     * Description:获取指定日期年的第一天
     */
    public static Date getFirstDayOfLastYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR) - 1, Calendar.JANUARY, 1);
        return calendar.getTime();
    }

    /**
     * Description:获取指定日期年的最后一天
     */
    public static Date getLastDayOfLastYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR) - 1, Calendar.DECEMBER, 31);
        return calendar.getTime();
    }

    /**
     * 返回指定年月的月的第一天
     * <p>
     * param year
     * param month
     * return
     */
    public static Date getFirstDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的月的最后一天
     * <p>
     * param date
     * return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定年月的月的最后一天
     * <p>
     * param year
     * param month
     * return
     */
    public static Date getLastDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * Description:返回指定日期的上个月的第一天
     */
    public static Date getFirstDayOfLastMonth(Date date) {
        Date addMonths = addMonths(date, -1);
        return setDays(addMonths, 1);
    }

    /**
     * 返回指定日期的上个月的最后一天
     * <p>
     * param date
     * return
     */
    public static Date getLastDayOfLastMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的季的第一天
     * <p>
     * param date
     * return
     */
    public static Date getFirstDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getFirstDayOfQuarter(calendar.get(Calendar.YEAR),
                getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的季的第一天
     * <p>
     * param year
     * param quarter
     * return
     */
    public static Date getFirstDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month;
        if (quarter == 1) {
            month = 1 - 1;
        } else if (quarter == 2) {
            month = 4 - 1;
        } else if (quarter == 3) {
            month = 7 - 1;
        } else if (quarter == 4) {
            month = 10 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getFirstDayOfMonth(year, month);
    }

    /**
     * 返回当前日期的季的最后一天
     * <p>
     * param date
     * return
     */
    public static Date getLastDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfQuarter(calendar.get(Calendar.YEAR),
                getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的季的最后一天
     * <p>
     * param year
     * param quarter
     * return
     */
    public static Date getLastDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month;
        if (quarter == 1) {
            month = 3 - 1;
        } else if (quarter == 2) {
            month = 6 - 1;
        } else if (quarter == 3) {
            month = 9 - 1;
        } else if (quarter == 4) {
            month = 12 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month);
    }

    /**
     * 返回当前日期的季的第一天
     * <p>
     * param date
     * return
     */
    public static Date getFirstDayOfLastQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getFirstDayOfLastQuarter(calendar.get(Calendar.YEAR),
                getQuarterOfYear(date));
    }

    /**
     * 返回指定日期的上一季的最后一天
     * <p>
     * param date
     * return
     */
    public static Date getLastDayOfLastQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfLastQuarter(calendar.get(Calendar.YEAR),
                getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的上一季的最后一天
     * <p>
     * param year
     * param quarter
     * return
     */
    public static Date getLastDayOfLastQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 12 - 1;
        } else if (quarter == 2) {
            month = 3 - 1;
        } else if (quarter == 3) {
            month = 6 - 1;
        } else if (quarter == 4) {
            month = 9 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month);
    }

    /**
     * 返回指定年季的上一季的第一天
     * <p>
     * param year
     * param quarter
     * return
     */
    public static Date getFirstDayOfLastQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 12 - 3;
        } else if (quarter == 2) {
            month = 3 - 3;
        } else if (quarter == 3) {
            month = 6 - 3;
        } else if (quarter == 4) {
            month = 9 - 3;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getFirstDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的季度
     * <p>
     * param date
     * return
     */
    public static int getQuarterOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) / 3 + 1;
    }

    /**
     * Description:获取当前上一季度
     */
    public static int getLastQuarterOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) / 3;
    }


    public static Date getDateStart(Date date) throws ParseException {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 00:00:00");
        return date;
    }

    public static Date getDateEnd(Date date) throws ParseException {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 23:59:59");
        return date;
    }

    /**
     * 获取指定日期的星期
     */
    public static String getDateWeek(Date date) {
        return formatDate(date, "E");
    }


    /**
     * 获取某年某周的星期一
     * <p>
     * param y
     * param w
     * return
     */
    public static Date getBeginDate(Integer y, Integer w) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(y, 0, 1, 0, 0, 0);
        int week = calendar.get(calendar.DAY_OF_WEEK) - 1;
        int days = w * 7 - (8 - week);
        calendar.add(Calendar.DATE, days - 1);
        Date beginDate = calendar.getTime();
        return beginDate;
    }

    /**
     * 获取某年某周的星期天
     * <p>
     * param y
     * param w
     * return
     */
    public static Date getEndDate(Integer y, Integer w) {
        Date beginDate = getBeginDate(y, w);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        calendar.add(Calendar.DATE, 6);
        Date endDate = calendar.getTime();
        return endDate;
    }

    /**
     * Description:获取进行比较的日期整型数字
     */
    public static int getDateInt(String date) {
        return Integer.parseInt(DateFormatUtils.format(DateUtil.parseDate(date), "yyyyMMdd"));
    }

    /**
     * Description:获取进行比较的日期整型数字
     */
    public static int getDateInt(Date date) {
        return Integer.parseInt(DateFormatUtils.format(date, "yyyyMMdd"));
    }


    /**
     * 获取时间差的中文描述
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static String getDateFormat(Date startDate, Date endDate) {
        return getDatePoor(startDate, endDate, "%s天%s小时%s分钟");
    }

    public static String getDatePoor(Date startDate, Date endDate, String str) {
        long[] result = getDatePoorNum(startDate, endDate);
        return String.format(str, result[0], result[1], result[2]);
    }

    /**
     * 获取时间格式化差
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static long[] getDatePoorNum(Date startDate, Date endDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        long[] result = new long[4];
        result[0] = day;
        result[1] = hour;
        result[2] = min;
        result[3] = sec;
        return result;
    }

    /**
     * 获取今天23:59:59秒到当前时间的差值
     *
     * @return
     */
    private long getExpireTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23,
                59, 59);
        //今天晚上23:59:59的时间戳
        long lastDate = calendar.getTime().getTime() / 1000;
        //当前时间的时间戳
        Instant instant = Instant.now();
        //获取时间差额
        return lastDate - instant.getEpochSecond();
    }


    public static void main(String[] args) {
        try {
            Date nowDate = new Date();
            Date lastDate = addYears(nowDate, -1);

            System.out.println("01.已 yyyy-MM-dd 格式获取日期字符串：" + getDate());
            System.out.println("02.已特定日期格式获取日期字符串：" + getDate("yyyyMMdd"));
            System.out.println("03.已 yyyy-MM-dd HH:mm:ss 日期格式获取特定日期字符串：" + formatDateTime(nowDate));
            System.out.println("04.已特定日期格式获取特定日期字符串：" + formatDate(nowDate, "yyyy-MM-dd-HH:mm:ss"));

            System.out.println("05.获取当前时间小时分秒字符串：" + getTime());
            System.out.println("06.获取当前时间全字符串：" + getDateTime());
            System.out.println("07.获取当前年字符串：" + getYear());
            System.out.println("08.获取去年字符串：" + getLastYear());
            System.out.println("09.获取当前月字符串：" + getMonth());
            System.out.println("10.获取上一月字符串：" + getLastMonth());
            System.out.println("11.获取当前日字符串：" + getDay());
            System.out.println("12.获取当前星期字符串：" + getWeek());
            System.out.println("13.将日期型字符串转化为日期 格式：" + parseDate("yyyy-MM-dd HH:mm:ss"));
            System.out.println("14.入参与当前时间对比获取过去的天数：" + pastDays(lastDate));
            System.out.println("15.入参与当前时间对比获取过去的小时：" + pastHour(lastDate));
            System.out.println("16.入参与当前时间对比获取过去的分钟：" + pastMinutes(lastDate));
            System.out.println("17.长整型转换为时间（天,时:分:秒.毫秒）：" + formatDateTime(222222222));
            System.out.println("18.获取两个日期之间相差的天数：" + getDistanceOfTwoDate(lastDate, new Date()));

            System.out.println("19.获取指定日期年的第一天：" + formatDate(getFirstDayOfYear(nowDate)));
            System.out.println("20.获取指定日期年的最后一天：" + formatDate(getLastDayOfYear(nowDate)));
            System.out.println("22.获取指定日期上一年的第一天：" + formatDate(getFirstDayOfLastYear(nowDate)));
            System.out.println("22.获取指定日期上一年的最后一天：" + formatDate(getLastDayOfLastYear(nowDate)));

            System.out.println("23.得到某年某周的第一天：" + formatDate(getFirstDayOfWeek(2017, 7)));
            System.out.println("24.得到某年某周的最后一天：" + formatDate(getLastDayOfWeek(2017, 5)));
            System.out.println("25.得到指定日期所在周的第一天：" + formatDate(getFirstDayOfWeek(nowDate)));
            System.out.println("26.获取指定日期所在周的最后一天：" + formatDate(getLastDayOfWeek(nowDate)));
            System.out.println("27.获取指定日期上周最后一天：" + formatDate(getLastDayOfLastWeek(nowDate)));

            System.out.println("28.获取指定日期月的第一天：" + formatDate(getFirstDayOfMonth(nowDate)));
            System.out.println("29.获取指定日期月的最后一天：" + formatDate(getLastDayOfMonth(nowDate)));
            System.out.println("30.获取指定日期上月第一天：" + formatDate(getFirstDayOfLastMonth(nowDate)));
            System.out.println("31.获取指定日期上月最后一天：" + formatDate(getLastDayOfLastMonth(nowDate)));
            System.out.println("32.获取某年某月的第一天：" + formatDate(getFirstDayOfMonth(2016, 11)));
            System.out.println("33.获取某年某月的最后一天：" + formatDate(getLastDayOfMonth(2016, 11)));

            System.out.println("34.获取指定日期季度第一天：" + formatDate(getFirstDayOfQuarter(nowDate)));
            System.out.println("35.获取指定日期季度最后一天：" + formatDate(getLastDayOfQuarter(nowDate)));
            System.out.println("36.获取某年某月对应季度第一天：" + formatDate(getFirstDayOfQuarter(2016, 1)));
            System.out.println("37.获取某年某月对应季度最后一天：" + formatDate(getLastDayOfQuarter(2016, 2)));
            System.out.println("38.获取指定季度上一季度第一天：" + formatDate(getFirstDayOfLastQuarter(nowDate)));
            System.out.println("39.获取指定季度上一季度最后一天：" + formatDate(getLastDayOfLastQuarter(nowDate)));
            System.out.println("40.获取某年某月对应上一季度第一天：" + formatDate(getFirstDayOfLastQuarter(2016, 3)));
            System.out.println("41.获取某年某月对应上一季度最后一天：" + formatDate(getLastDayOfLastQuarter(2016, 4)));

            System.out.println("42.获取指定日期季度：" + getQuarterOfYear(nowDate));
            System.out.println("43.获取指定日期上一季度：" + getLastQuarterOfYear(nowDate));
            System.out.println("44.获取指定日期开始：" + formatDate(getDateStart(nowDate), "yyyy-MM-dd HH:mm:ss"));
            System.out.println("45.获取指定日期结束：" + formatDate(getDateEnd(nowDate), "yyyy-MM-dd HH:mm:ss"));
            System.out.println("46.获取指定日期星期：" + getDateWeek(nowDate));
            System.out.println("47.获取某年某周的第一天：" + formatDate(getBeginDate(2017, 2)));
            System.out.println("48.获取某年某周的星期天：" + formatDate(getEndDate(2016, 1)));
            System.out.println("49.获取指定日期字符串的整数：" + getDateInt("2016-07-14"));
            System.out.println("50.获取指定日期的整数：" + getDateInt(nowDate));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
