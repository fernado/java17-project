package pr.iceworld.fernando.java8.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateClass {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2023, 2, 1);

        System.out.println(localDate);
        System.out.println("1 -- " + localDate.format(DateTimeFormatter.ofPattern("M dd, yyyy")));
        System.out.println("1 -- " + localDate.format(DateTimeFormatter.ofPattern("MM dd, yyyy")));
        System.out.println("1 -- " + localDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
        System.out.println("1 -- " + localDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
        System.out.println("1 -- " + localDate.format(DateTimeFormatter.ofPattern("MMMMM dd, yyyy")));
        // Too many pattern letters: M
//        System.out.println("1 -- " + localDate.format(DateTimeFormatter.ofPattern("MMMMMM dd, yyyy")));


        System.out.println("2 -- " + localDate.format(DateTimeFormatter.ofPattern("MM d, yyyy")));
        System.out.println("2 -- " + localDate.format(DateTimeFormatter.ofPattern("MM dd, yyyy")));
        // Too many pattern letters: d
//        System.out.println("2 -- " + localDate.format(DateTimeFormatter.ofPattern("MM ddd, yyyy")));


        System.out.println("3 -- " + localDate.format(DateTimeFormatter.ofPattern("MM dd, y")));
        System.out.println("3 -- " + localDate.format(DateTimeFormatter.ofPattern("MM dd, yy")));
        System.out.println("3 -- " + localDate.format(DateTimeFormatter.ofPattern("MM dd, yyy")));
        System.out.println("3 -- " + localDate.format(DateTimeFormatter.ofPattern("MM dd, yyyyy")));

        System.out.println("4 -- " + localDate.format(DateTimeFormatter.ofPattern("E, MM dd, yyyy")));
        System.out.println("4 -- " + localDate.format(DateTimeFormatter.ofPattern("EE, MM dd, yyyy")));
        System.out.println("4 -- " + localDate.format(DateTimeFormatter.ofPattern("EEE, MM dd, yyyy")));
        System.out.println("4 -- " + localDate.format(DateTimeFormatter.ofPattern("EEEE, MM dd, yyyy")));
        System.out.println("4 -- " + localDate.format(DateTimeFormatter.ofPattern("EEEEE, MM dd, yyyy")));
        // Too many pattern letters: E
//        System.out.println("4 -- " + localDate.format(DateTimeFormatter.ofPattern("EEEEEE, MM dd, yyyy")));
    }
}
