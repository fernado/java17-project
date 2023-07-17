package pr.iceworld.fernando.java8.lambda;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class LambdaTest {

    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Athu", 29),
                new Person("Lili", 21),
                new Person("Flybi", 31)
        );

        List<Person> anotherPersonList = List.of(
                new Person("John", 37),
                new Person("Vivi", 22),
                new Person("Gody", 45),
                new Person("Fernando", 45)
        );

        List<List<Person>> personListCombinded = List.of(personList, anotherPersonList);

        System.out.println("----------------------------------------- average, sum, max, min and count");
        IntSummaryStatistics intSummaryStatisticsPerson = personList.stream().collect(Collectors.summarizingInt(e -> e.age));
        System.out.println("Average = " + intSummaryStatisticsPerson.getAverage());
        System.out.println("Sum = " + intSummaryStatisticsPerson.getSum());
        System.out.println("Max = " + intSummaryStatisticsPerson.getMax());
        System.out.println("Min = " + intSummaryStatisticsPerson.getMin());
        System.out.println("Count = " + intSummaryStatisticsPerson.getCount());

        System.out.println("----------------------------------------- average, sum, max, min and count");
        System.out.println("Average = " + personList.stream().mapToDouble(e -> e.age).average());
        System.out.println("Sum = " + personList.stream().mapToDouble(e -> e.age).sum());
        System.out.println("Max = " + personList.stream().mapToDouble(e -> e.age).max());
        System.out.println("Min = " + personList.stream().mapToDouble(e -> e.age).min());
        System.out.println("Count = " + personList.stream().mapToDouble(e -> e.age).count());
        System.out.println("----------------------------------------- average, max, min");
        System.out.println("Average = " + personList.stream().collect(Collectors.averagingInt(value -> value.age)));
        System.out.println("Max = " + personList.stream().max(Comparator.comparingInt(o -> o.age)));
        System.out.println("Min = " + personList.stream().min(Comparator.comparingInt(o -> o.age)));

        System.out.println("----------------------------------------- filter and map");
        personList.stream().filter(e -> e.name.startsWith("A")).map(p -> p.name).forEach(System.out::println);
        System.out.println("----------------------------------------- flatmap");
        personList.stream().flatMap(e -> Arrays.asList(e.name.toCharArray()).stream()).forEach(System.out::println);
        System.out.println("----------------------------------------- flatmap and sorted by name");
        personListCombinded.stream().flatMap(e -> e.stream()).sorted(Comparator.comparing(o -> o.name)).forEach(System.out::println);
        System.out.println("----------------------------------------- flatmap and sorted by age desc");
        personListCombinded.stream().flatMap(e -> e.stream()).sorted((o1, o2) -> o2.age.compareTo(o1.age)).forEach(System.out::println);
        System.out.println("----------------------------------------- flatmap and max, min");
        System.out.println("Max = " + personListCombinded.stream().flatMapToDouble(people -> people.stream().flatMapToDouble(e -> DoubleStream.of(e.age))).max());
        System.out.println("Min = " + personListCombinded.stream().flatMapToDouble(people -> people.stream().flatMapToDouble(e -> DoubleStream.of(e.age))).min());
        System.out.println("----------------------------------------- sorted by name and limit");
        personList.stream().sorted(Comparator.comparing(o -> o.age)).limit(1).forEach(System.out::println);
        System.out.println("----------------------------------------- sorted by age desc and limit");
        personList.stream().sorted(Comparator.comparing(o -> -o.age)).limit(1).forEach(System.out::println);
        personList.stream().sorted(((o1, o2) -> o2.age.compareTo(o1.age))).limit(1).forEach(System.out::println);


        System.out.println("flat1 ----------------------------------------- ");
        Map<Integer, List<Person>> map = personListCombinded.stream().flatMap(e -> e.stream()).collect(Collectors.groupingBy(e -> e.age));
        System.out.println(map);
        System.out.println("flat2----------------------------------------- ");
        Map<Object, List<Person>> map2 = personListCombinded.stream().flatMap(e -> e.stream()).collect(Collectors.groupingBy(e -> e.age + e.name.substring(0, 1)));
        System.out.println(map2);
        System.out.println("flat3----------------------------------------- ");
        Map<Integer, List<String>> map3 = personListCombinded.stream().flatMap(e -> e.stream()).collect(
                Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println(map3);
        System.out.println("flat4 ----------------------------------------- ");
        Map<Integer, Long> map4 = personListCombinded.stream().flatMap(e -> e.stream()).collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
        System.out.println(map4);
        System.out.println("flat5 ----------------------------------------- ");
        List<Person> list5 = personListCombinded.stream().flatMap(e -> e.stream()).collect(Collectors.toList());
        System.out.println(list5);
        System.out.println("----------------------------------------- consumer");
        Consumer consumer = s -> System.out.println(s);
        consumer.accept("3");
        Function<String, String> function = (e1) -> e1 + "5";
        System.out.println(function.apply("3"));
        Predicate<String> predicate = s -> s.equals("3");
        System.out.println(predicate.test("3"));
        Supplier<String> supplier = () -> "5";
        System.out.println(supplier.get());

    }


    static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Person{");
            sb.append("name='").append(name).append('\'');
            sb.append(", age=").append(age);
            sb.append('}');
            return sb.toString();
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }
}
