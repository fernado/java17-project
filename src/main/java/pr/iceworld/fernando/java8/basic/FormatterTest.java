package pr.iceworld.fernando.java8.basic;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Formatter;
import java.util.Locale;
import java.util.Spliterator;
import java.util.function.Consumer;

public class FormatterTest {

    public static void main(String[] args) {
        String stringA = "A";
        String stringB = "B";
        String stringnull = null;
        String stringNotNull = "";
        StringBuilder bufferc = new StringBuilder("C");
        Formatter fmt = new Formatter(bufferc);

        fmt.format("%s%s", stringA, stringB);
        System.out.println("Line 1: " + fmt);

        fmt.format("%-2s", stringB);
        System.out.println("Line 2: " + fmt);

        fmt.format("%b", stringnull);
        System.out.println("Line 3: " + fmt);

        fmt.format("%b", stringNotNull);
        System.out.println("Line 4: " + fmt);

        Locale locale = new Locale("zh");
        System.out.println(" " + locale.getCountry());



    }
}
