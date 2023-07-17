package pr.iceworld.fernando.java8.basic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Person {
    String name;
    Integer id;

    Person(String n, Integer i) {
        name = n;
        id = i;
    }

    Person(Integer i) {
        name = null;
        id = i;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " " + id;
    }
}

public class PersonTest {
    static List<Person> persons = Arrays.asList(new Person("Bob", 1), new Person(2), new Person("Jane", 3));
    static int x;

    public static void main(String[] args) {
        persons.stream().reduce((e1, e2) -> {
            x = e1.id;
            if (e1.id > e2.id) return e1;
            x = e2.id;
            return e2;
        }).flatMap(e -> Optional.ofNullable(e.name))
                .map(y -> new Person(y, x)).ifPresent(System.out::println);

        System.out.println("--------------------A");
        persons.stream().filter(p -> p.name != null)
//                        .flatMap(p -> Arrays.asList(p).stream())

                .forEach(System.out::println);
        System.out.println("--------------------B");
        System.out.println(Optional.ofNullable(persons.get(1).name).isPresent());
        System.out.println("--------------------C");

        Person pp = new Person("hh", 53);
        Optional<Optional<String>> optionalOptional = Optional.ofNullable(pp).map(PersonTest::getName);
        Optional<String> mapOptional = Optional.ofNullable(pp).map(s -> s.name);
        Optional<String> flatOptional = Optional.ofNullable(pp).flatMap(PersonTest::getName);
        System.out.println("optionalOptional = " + optionalOptional);
        System.out.println("mapOptional = " + mapOptional);
        System.out.println("flatOptional = " + flatOptional);

        //对于calculate这种函数，使用flatMap的话，返回的结果还是Optional，方便使用
        Optional<Integer> opt = Optional
                .ofNullable(11)
                .flatMap(a -> calculate(a));

        //对于calculate这种函数，如果使用map，返回的结果嵌套了Optional
        Optional<Optional<Integer>> opt2 = Optional
                .ofNullable(11)
                .map(a -> calculate(a));

        System.out.println("--------------------D");


        int c = 0;
        System.out.println((0 == c++));
        boolean b = false;
        System.out.println((b = true) ? "true》》" : "fasle》》");

        String e = "1";
        System.out.println( "1 != e " + ("1" != e));

        Double d = null;
        System.out.println("(d instanceof Double) " + (d instanceof Double));
        d = 1.3;
        System.out.println("(d instanceof Double) " + (d instanceof Double));

        int a = 0;
        System.out.println("a != 0 " + (a != 0));
    }

    private static Optional<String> getName(Person person){
        return Optional.ofNullable(person).map(s -> s.getName());
    }




    public static Optional<Integer> calculate(int input) {
        return Optional.of(input * 2);
    }
}
