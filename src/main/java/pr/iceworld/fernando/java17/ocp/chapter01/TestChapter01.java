package pr.iceworld.fernando.java17.ocp.chapter01;

import java.time.*;

public class TestChapter01 {

    /**
     * 在美国东部时区（纽约时区），当夏令时生效时，时钟会在凌晨2点的时候向前调整一个小时，变成3点。
     * 因此，在2022年3月13日的凌晨2点，时钟会被调整为凌晨3点。这意味着3点之后的时间在夏令时期间会比标准时间晚一个小时。
     * 代码中创建的 ZonedDateTime 对象 z 表示了2022年3月13日的凌晨1点（即夏令时调整之前）的时间，并使用了美国纽约时区。
     * 然后，将一个持续时间为3小时的 Duration 对象 duration 添加到 z 上，得到了 later 对象。
     * 由于夏令时的调整，美国纽约时区的标准时间在凌晨2点调整为3点，而在3点之后，
     * 偏移量会从原来的 -05:00（美国东部标准时间）更改为 -04:00（美国东部夏令时）。所以当将 duration 的3小时添加到 z 上后，
     * 得到的 later 对象的时间会是5点，而偏移量则是 -04:00。
     * 因此，在这段代码中，纽约时间加3小时后，确实变成了05:00，并且偏移量也从 -05:00 变为 -04:00，这是由于夏令时的调整。
     *
     * 夏令时的开始和结束日期可以根据国家和地区的规定而异，因此具体的开始和结束日期会因地区而有所不同。以下是一些常见的夏令时开始和结束日期的示例：
     * 美国：
     * 夏令时开始日期：通常在每年的3月的第二个星期日开始。
     * 夏令时结束日期：通常在每年的11月的第一个星期日结束。
     * 欧洲：
     * 夏令时开始日期：通常在每年的最后一个周日的凌晨1点（2点往前调整一小时）开始。
     * 夏令时结束日期：通常在每年的最后一个周日的凌晨2点（2点往后调整一小时）结束。
     *
     * Most of the United States observes daylight saving time on March 13, 2022, by moving the
     * clocks forward an hour at 2 a.m. What does the following code output?
     * result is 5 false
     */
    public static void q5_testZoneTime() {
        var localDate = LocalDate.of(2022, 3, 13);
        var localTime = LocalTime.of(1, 0);
        // 伦敦时间为标准时间
        // 纽约时间与伦敦时间相差 -5小时  西5区
        var zone = ZoneId.of("America/New_York");
        var z = ZonedDateTime.of(localDate, localTime, zone);
        System.out.println(z);
        var offset = z.getOffset();
        var duration = Duration.ofHours(3);
        var later = z.plus(duration);
        System.out.println(later.getHour() + " " + offset.equals(later.getOffset()));
        System.out.println(later);
    }

    /**
     * total = 7
     * tip = 1
     */
    public static void q6() {
        int meal = 5;
        int tip = 2;
        var total = meal + (meal>6 ? tip++ : tip--);
        System.out.println(total);
        System.out.println(tip);
    }

    //public static void q7() {
    //    int year = 1874;
    //    // the below line compile error
    //    int month = Month.MARCH;
    //    int day = 24;
    //    LocalDate date = LocalDate.of(year, month, day);
    //    System.out.println(date.isBefore(LocalDate.now()));
    //}

    public static void q8() {
        var b = "12";
        b += "3";
        System.out.println(b.getClass().getName());
        // the below line compile error
        // string doesnt have this method, only StringBuilder and StringBuffer have.
        // b.reverse();
        // ignore above code, the result is 123
        System.out.println(b.toString());

        StringBuilder builder = new StringBuilder("123");
        builder.reverse();
        StringBuffer buffer = new StringBuffer("123");
        buffer.reverse();
    }

    /**
     * result is true 4
     */
    public static void q9() {
        var line = new StringBuilder("- ");
        var anotherLine = line.append("- ");
        System.out.print(line == anotherLine);
        System.out.print(" ");
        System.out.print(line.length());
    }

    /**
     * Given that daylight saving time starts on March 13, 2022, at 2 a.m. and clocks jump from
     * 1:59 a.m. to 03:00 a.m., which of the following can fill in the blank so the code doesn’t
     * throw an exception?
     */
    public static void q10() {
        var localDate = LocalDate.of(2022, 3, 13);
        //var localTime = LocalTime.of(___);
        // here should input 3, 0
        var localTime = LocalTime.of(3, 0);
        var zone = ZoneId.of("America/New_York");
        var z = ZonedDateTime.of(localDate, localTime, zone);
        System.out.println(z);
    }

    public static void q12() {
        var cat = Math.ceil(65);
        var moose = Math.max(7,8);
        var penguin = Math.pow(2, 3);
        System.out.println(cat);
        System.out.println(moose);
        System.out.println(penguin);
    }

    public static void main(String[] args) {
        q12();
    }
}
