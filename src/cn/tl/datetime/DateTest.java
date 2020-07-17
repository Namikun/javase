package cn.tl.datetime;

import cn.tl.domain.Constant;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Optional;

public class DateTest {

    public static void main(String[] args) throws Exception {

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern(Constant.DATETIME_PATTERN);
        LocalDate localDate = LocalDate.parse("2018-06-07 17:30:30", pattern);
        System.out.println("localDate: " + localDate);
        System.out.println("ISO_LOCAL_DATE: " + localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("当月第一天：" + LocalDate.now().withDayOfMonth(1));
        System.out.println("当前年2月最后一天： " + LocalDate.now().withMonth(2).with(TemporalAdjusters.lastDayOfMonth()));
        //下周的日期两个方式，日、月、年类似
        System.out.println("下周日期： " + localDate.plus(1, ChronoUnit.WEEKS));
        System.out.println("下周日期： " + localDate.plusWeeks(1));
        System.out.println("2018年1月第一个星期天： " + LocalDate.of(2018, 1, 1).with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY)));


        LocalDateTime localDateTime = LocalDateTime.parse("2018-01-01 17:30:30", pattern);
        System.out.println("当天是周几： " + localDateTime.getDayOfWeek());
        System.out.println("ISO_LOCAL_DATE_TIME: " + localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("判断日期大小： " + localDateTime.isBefore(LocalDateTime.now()));

        System.out.println("LocalTime: " + LocalTime.of(1, 1, 1));

        YearMonth yearMonth = YearMonth.now();
        System.out.println("是否过期： " + yearMonth.isAfter(YearMonth.of(2018, 12)));
        System.out.println("lengthOfMonth: " + yearMonth.lengthOfMonth());
        System.out.println("lengthOfYear: " + yearMonth.lengthOfYear());

        MonthDay monthDay = MonthDay.of(6, 9);
        System.out.println("是否同一天生日：" + MonthDay.now().equals(monthDay));

        //时间周数差
        LocalDate startDate = LocalDate.parse("2017-02-01");
        LocalDate endDate = LocalDate.parse("2018-01-31");
        System.out.println("周数差: " + startDate.until(endDate, ChronoUnit.WEEKS));


        TemporalField weekFields = WeekFields.ISO.weekOfYear();
        int startWeek = startDate.get(weekFields);
        int endWeek = endDate.get(weekFields);
        //跨年不适用
        System.out.println(endWeek - startWeek);

        int firstWeek = LocalDate.of(2017, 1, 1).get(weekFields);
        System.out.println("第几周：" + firstWeek);
        int lastWeek = LocalDate.of(2017, 12, 31).get(weekFields);
        System.out.println("2017年的周数：" + (firstWeek == 0 ? lastWeek + 1 : lastWeek));

        Optional.of(new ArrayList<>()).ifPresent(o -> o.stream().forEach(System.out::println));
        Optional.ofNullable(null).ifPresent(o -> System.out.println(o));
    }
}
