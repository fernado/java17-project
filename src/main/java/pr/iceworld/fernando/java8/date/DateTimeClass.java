package pr.iceworld.fernando.java8.date;

import java.time.*;

interface MonthDayHelper {
    default MonthDay construct(Month month, int dayOfMonth) {
        return MonthDay.of(month, dayOfMonth);
    }
    static String toString(MonthDay monthDay) {
        return monthDay.getMonth().toString() + " " + monthDay.getDayOfMonth();
    }
}

interface LocalTimeHelper {
    default LocalTime construct(int hour, int minute, int second) {
        return LocalTime.of(hour, minute, second);
    }
    static String toString(LocalTime localTime) {
        return localTime.getHour() + " " + localTime.getMinute() + " " + localTime.getSecond();
    }
}

interface LocalDateTimeHelper {
    default LocalDateTime construct(int year, Month month, int dayOfMonth, int hour, int minute, int second) {
        return LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
    }
    static String toString(LocalDateTime localDateTime) {
        return localDateTime.getYear() + " " + localDateTime.getMonth().toString() + " " + localDateTime.getDayOfMonth()
                + " " + localDateTime.getHour() + " " + localDateTime.getMinute() + " " + localDateTime.getSecond();
    }
}
public class DateTimeClass implements MonthDayHelper, LocalTimeHelper, LocalDateTimeHelper {

    private MonthDay monthDay;
    private LocalTime localTime;
    private LocalDateTime localDateTime;

    DateTimeClass(Month month, int dayOfMonth, int hours, int minutes, int seconds) {
        monthDay = MonthDayHelper.super.construct(month, dayOfMonth);
        localTime = LocalTimeHelper.super.construct(hours, minutes, seconds);
    }

    DateTimeClass(Year year, Month month, int dayOfMonth, int hours, int minutes, int seconds) {
        monthDay = MonthDayHelper.super.construct(month, dayOfMonth);
        localTime = LocalTimeHelper.super.construct(hours, minutes, seconds);
        localDateTime = LocalDateTimeHelper.super.construct(year.getValue(), month, dayOfMonth, hours, minutes, seconds);
    }

    void print() {
        System.out.print(MonthDayHelper.toString(monthDay));
        System.out.println(" " + LocalTimeHelper.toString(localTime));
        if (localDateTime != null)
            System.out.println(LocalDateTimeHelper.toString(localDateTime));
    }

    public static void main(String[] args) {
        DateTimeClass dt1 = new DateTimeClass(Month.OCTOBER, 31, 12, 5, 30);
        DateTimeClass dt2 = new DateTimeClass(Month.JANUARY, 1, 5, 14, 25);
        DateTimeClass dt3 = new DateTimeClass(Year.of(2023), Month.JANUARY, 1, 5, 14, 25);
        dt1.print();
        dt2.print();
        dt3.print();



    }
}
