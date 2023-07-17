package pr.iceworld.fernando.java8.basic;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatDemo {
    public static void main(String[] args) {
        String s = "123.456789d";
        double d = 123.456789d;
        NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);
        NumberFormat ne = NumberFormat.getInstance(Locale.ENGLISH);
        nf.setMaximumFractionDigits(2);
        ne.setMaximumFractionDigits(3);
        System.out.println(nf.format(d) + " ");
        System.out.println(ne.format(d) + " ");

        try {
            BigDecimal bigDecimal1 = new BigDecimal("127.01");
//            bigDecimal1.setScale(2);
//            BigDecimal bigDecimal2 = new BigDecimal("127,01");
            System.out.println("bigDecimal1 = " + bigDecimal1);
//            System.out.println("bigDecimal2 = " + bigDecimal2);
            System.out.println(nf.parse(s));
            System.out.println(ne.parse(s));
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }
}
