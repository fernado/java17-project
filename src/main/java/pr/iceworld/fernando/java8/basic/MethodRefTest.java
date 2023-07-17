package pr.iceworld.fernando.java8.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Name {
    private String first, las;

    Name(String f, String l) {
        first = f;
        las = l;
    }

    Name() {
    }

    public String toString() {
        return first + " " + las;
    }

    public static int compareByName(Name n1, Name n2) {
        return n1.las.compareTo(n2.las);
    }
}


public class MethodRefTest {

    synchronized BigDecimal findRoot(BigDecimal b) {
        return null;
    }

    void display() {
        System.out.println("Data = " + data);
    }

    int data;

    public static void main(String[] args) {
        Name n1 = new Name("Harry", "Home");
        Name n2 = new Name("Paul", "Pa");
        Name n3 = new Name("Jane", "Do");
        List<Name> lists = Arrays.asList(n1, n2, n3);
        lists.sort(Name::compareByName);
        lists.forEach(System.out::println);

        MethodRefTest methodRefTest = new MethodRefTest();
        methodRefTest.display();

        List<String> letters = new ArrayList<>(Arrays.asList("D", "B", "A", "C", "F", "G"));
        // D F G
        Predicate<String> p1 = s -> s.compareTo("C") > 0;

        System.out.println(">>>>>>>> " + p1.test("A"));
        // B
        Predicate<String> p2 = s -> s.equals("G");
        // A B C
        letters.removeIf(p1.or(p2).negate()
        );
        letters.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println(letters);

    }
}
