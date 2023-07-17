package pr.iceworld.fernando.java17.ocp.chapter01;

public class Number {
    public static void main(String[] args) {

        //can add
        //underscores anywhere except at the beginning of a literal, the end of a literal, right before a
        //decimal point, or right after a decimal point.
        // DOES NOT COMPILE
        //double notAtStart = _1000.00;
        // DOES NOT COMPILE
        //double notAtEnd = 1000.00_;
        // DOES NOT COMPILE
        //double notByDecimal = 1000_.00;
        double annoyingButLegal = 1_00_0.0_0; // Ugly, but compiles
        double reallyUgly = 1__________2; // Also compiles

        System.out.println("1_00_0.0_0=" + annoyingButLegal);
        System.out.println("1__________2=" + reallyUgly);

        //Text blocks require a line break after the opening """
        //DOES NOT COMPILE
        //String block = """doe""";

        String textBlock = """
            Start text block
                Essential whitespace
            End text block\s b \
            Incidental whitespace
            "Java Study Guide" \
                by Scott & Jeanne
            """;

        System.out.println("textBlock=" + textBlock);

        System.out.println("--------------");
        String aaa = """
        aaaa
          bbbb
        """;
        String bbb = """
        aaaa
          bbbb""";

        System.out.println(aaa);
        System.out.println("--------------");
        System.out.println(bbb);
        System.out.println("--------------");
    }

}
