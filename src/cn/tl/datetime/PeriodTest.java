package cn.tl.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

/**
 * Period 日期偏移
 * Duration 时间偏移
 */
public class PeriodTest {

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2018, 5, 7);
        LocalDate endDate = LocalDate.of(2018, 6, 8);
        Period period = Period.between(startDate, endDate);
        System.out.println("year: " + period.getYears() + ", month: " + period.getMonths() + ", day: " + period.getDays());

        LocalTime startTime = LocalTime.of(21, 10, 1);
        LocalTime endTime = LocalTime.of(23, 14, 5);
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("hour: " + duration.toHours() + ", minute: " + duration.toMinutes() + ", second: " + duration.getSeconds());
    }
}
