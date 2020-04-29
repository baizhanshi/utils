package com.rambo.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @author baizhanshi on 2019/4/18.
 */
public class TestDate {

    public static void main(String[] args) {
        System.out.println("localDate-----------------------");
        //1.获取当前日期
        LocalDate today = LocalDate.now();
        System.out.println("当前日期是：" + today);
        //2.在当前时间加一天
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate yesterday = LocalDate.now().minusDays(1);
        System.out.println("明天的日期是：" + tomorrow);
        System.out.println("昨天的日期是：" + yesterday);
        //3.从今天减去加上一个月
        LocalDate prevMonth = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        LocalDate nextMonth = LocalDate.now().plus(1, ChronoUnit.MONTHS);
        System.out.println("上月的今天是:" + prevMonth);
        System.out.println("下月的今天是:" + nextMonth);
        //4.获取每周中的星期和每月中的日
        DayOfWeek thursday = LocalDate.parse("2018-04-18").getDayOfWeek();
        System.out.println("今天是周几: " + thursday);
        int eighteen = LocalDate.parse("2018-04-18").getDayOfMonth();
        System.out.println("今天是几号: " + eighteen);
        //5.查看今年是不是闰年
        boolean leapYear = LocalDate.now().isLeapYear();
        System.out.println("是否闰年: " + leapYear);
        //6.判断是在之前之后
        boolean isBefore = LocalDate.parse("2018-04-18").isBefore(LocalDate.parse("2018-04-20"));
        System.out.println("isBefore: " + isBefore);
        boolean isAfter = LocalDate.parse("2018-04-18").isAfter(LocalDate.parse("2018-04-20"));
        System.out.println("isAfter: " + isAfter);

        //7.这个月的第一天
        LocalDate firstDayOfMonth = LocalDate.parse("2018-04-18").with(TemporalAdjusters.firstDayOfMonth());

        System.out.println("这个月的第一天: " + firstDayOfMonth);

        //8.日期比较
        LocalDate birthday = LocalDate.of(1990, 04, 22);
        MonthDay birthdayMd = MonthDay.of(birthday.getMonth(), birthday.getDayOfMonth());
        MonthDay todayDate = MonthDay.from(LocalDate.now());
        System.out.println("今天是否是我的生日: " + todayDate.equals(birthdayMd));

        System.out.println("localTime-------------------------------");
        //1.获取当前时间
        LocalTime nowTime = LocalTime.now();
        System.out.println("现在的时间: " + nowTime);

        LocalTime nowTime1 = LocalTime.parse("15:02");
        System.out.println("时间是: " + nowTime1);

        LocalTime nowTime2 = LocalTime.of(15, 02);
        System.out.println("时间是: " + nowTime2);
        //2.上下一个小时
        LocalTime nextHour = LocalTime.parse("15:02").plus(1, ChronoUnit.HOURS);
        LocalTime preHour = LocalTime.parse("15:02").minus(1, ChronoUnit.HOURS);
        System.out.println("下一个小时: " + nextHour);
        System.out.println("上一个小时: " + preHour);
        //3.获取小时和分钟
        int hour = LocalTime.now().getHour();
        System.out.println("小时: " + hour);
        int minute = LocalTime.now().getMinute();
        System.out.println("分钟: " + minute);
        //4.时间比较
        boolean before = LocalTime.parse("15:02").isBefore(LocalTime.parse("16:02"));
        boolean after = LocalTime.parse("15:02").isAfter(LocalTime.parse("16:02"));
        System.out.println("isBefore: " + before);
        System.out.println("isAfter: " + after);
        //5.每天的开始时间和结束时间
        System.out.println(LocalDate.now() + " " + LocalTime.MAX);
        System.out.println(LocalDate.now() + " " + LocalTime.MIN);

        System.out.println("localDateTime-------------------");
        //1.获取当前日期和时间
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("现在: " + nowDateTime);
        //2.时间的加或者减
        LocalDateTime tomorrowTime = nowDateTime.plusDays(1);
        System.out.println("明天的这个时间: " + tomorrowTime);
        LocalDateTime minusTowHour = nowDateTime.minusHours(2);
        System.out.println("两小时前: " + minusTowHour);
        //3.获取当前月份
        int year = nowDateTime.getYear();
        Month month = nowDateTime.getMonth();
        int minutes = nowDateTime.getMinute();
        System.out.println("当前年份: " + year);
        System.out.println("当前月份: " + month);
        System.out.println("当前分钟: " + minutes);

        //4.日期格式化
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("默认格式化: " + nowDateTime);
        System.out.println("自定义格式化: " + nowDateTime.format(dateTimeFormatter));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = dtf.format(LocalDate.now());
        System.out.println("默认格式化: " + LocalDate.now());
        System.out.println("日期转字符串: " + dateString);

        //5.当前日期加天数 Period
        LocalDate initialDate = LocalDate.parse("2019-04-18");
        LocalDate finalDate = initialDate.plus(Period.ofDays(5));
        System.out.println("初始化日期: " + initialDate);
        System.out.println("加日期之后: " + finalDate);

        //6.获取两个日期的差距天数 后减去前
        long between = ChronoUnit.DAYS.between(initialDate, finalDate);
        Period tenDays = Period.between(initialDate, finalDate);
        System.out.println("差距天数1: " + between);
        System.out.println("差距天数2: " + tenDays.getDays());

        System.out.println("instant----------------");

        Instant instant = Instant.now();
        System.out.println("获取当前时间的时间戳：" + instant.getEpochSecond());//instant就是以前的date
        //确定时区的时间
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate birthLocalDate = instant.atZone(zoneId).toLocalDate();
        System.out.println("确定时区的时间:" + birthLocalDate);

        // 上海时间
        ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime shanghaiZonedDateTime = ZonedDateTime.now(shanghaiZoneId);

        // 东京时间
        ZoneId tokyoZoneId = ZoneId.of("Asia/Tokyo");
        ZonedDateTime tokyoZonedDateTime = ZonedDateTime.now(tokyoZoneId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("上海时间: " + shanghaiZonedDateTime.format(formatter));
        System.out.println("东京时间: " + tokyoZonedDateTime.format(formatter));
    }
}
