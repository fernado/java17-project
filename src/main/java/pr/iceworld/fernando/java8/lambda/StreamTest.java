package pr.iceworld.fernando.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTest {

    static class Worker {
        private String name;
        private int age;

        public Worker(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Worker{");
            sb.append("name='").append(name).append('\'');
            sb.append(", age=").append(age);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 10, 15, 20, 25, 30);

        List<Worker> workers = Arrays.asList(new Worker("zhangsan", 25),
                new Worker("lisi", 22),
                new Worker("wangwu", 29),
                new Worker("zhaoliu", 20),
                new Worker("liuqi", 27),
                new Worker("zhugeba", 30));

        System.out.println(list.stream().allMatch(s -> s.equals(20)));
        System.out.println(list.stream().allMatch(s -> s.equals(40)));
        System.out.println(list.stream().filter(s -> s.equals(20)).allMatch(s -> s.equals(20)));


        System.out.println(list.stream().anyMatch(s -> s.equals(20)));
        System.out.println(list.stream().anyMatch(s -> s.equals(40)));
        System.out.println(list.stream().noneMatch(s -> s.equals(20)));
        System.out.println(list.stream().noneMatch(s -> s.equals(40)));

        System.out.println("--------------------0");
        System.out.println(list.stream().findAny().get());
        System.out.println(list.stream().findFirst().get());

        System.out.println("--------------------1");
        System.out.println(list.stream().max(Integer::compareTo).get());
        System.out.println(list.stream().min(Integer::compareTo).get());
        System.out.println(list.stream().count());

        System.out.println("--------------------2");
        System.out.println(list.stream().limit(2).collect(Collectors.toList()));
        System.out.println(list.stream().skip(2).collect(Collectors.toList()));

        System.out.println(list.stream().skip(2).limit(2).collect(Collectors.toList()));


        System.out.println("--------------------3");
        System.out.println(list.stream().sorted().collect(Collectors.toList()));
        System.out.println(list.stream().sorted(Integer::compareTo).collect(Collectors.toList()));

        System.out.println("--------------------4");
        System.out.println(Arrays.asList(list.stream().toArray()));
        System.out.println(Arrays.asList(list.stream().filter(s -> s > 20).toArray()));
        System.out.println(Arrays.asList(list.stream().filter(s -> s > 20).toArray(Integer[]::new)));

        System.out.println(Arrays.asList(workers.stream().toArray()));
        System.out.println(Arrays.asList(workers.stream().toArray(Worker[]::new)));

        // map() can be used where we have to map the elements of a particular collection to a certain function,
        // and then we need to return the stream which contains the updated results.
        // flatMap() can be used where we have to flatten or transform out the string, as we cannot flatten our string using map().


        System.out.println("--------------------41");

        System.out.println(workers.stream().map(s -> s.name.startsWith("l")).collect(Collectors.toList()));
        System.out.println(workers.stream().map(s -> s.age * 1.0).collect(Collectors.toList()));
        System.out.println(workers.stream().map(s -> s.age * 1).collect(Collectors.toList()));
        System.out.println(workers.stream().map(s -> s.age * 1L).collect(Collectors.toList()));

        System.out.println("--------------------5");

        List<Worker> workers2 = Arrays.asList(new Worker("joe", 25),
                new Worker("wil", 22),
                new Worker("pr/iceworld/fernando", 29),
                new Worker("wi", 20),
                new Worker("john", 27),
                new Worker("graw", 30));
        List<List<Worker>> workerList = new ArrayList<>();
        workerList.add(workers);
        workerList.add(workers2);
        System.out.println(workerList.stream().flatMap(s -> s.stream().filter(e -> e.name.startsWith("l"))).collect(Collectors.toList()));
        System.out.println(workerList.stream().flatMap(s -> s.stream().filter(e -> e.age * 1.0 > 25)).collect(Collectors.toList()));
        System.out.println(workerList.stream().flatMap(s -> s.stream().filter(e -> e.age * 1 > 25)).collect(Collectors.toList()));
        System.out.println(workerList.stream().flatMap(s -> s.stream().filter(e -> e.age * 1L > 25)).collect(Collectors.toList()));


        System.out.println("--------------------6");
        System.out.println(list.stream().filter(s -> s > 20).reduce((e1, e2) -> e1 + e2).isPresent());
        System.out.println(list.stream().filter(s -> s > 20).reduce((e1, e2) -> e1 + e2).get());

        System.out.println(list.stream().reduce((e1, e2) -> e1 + e2).get());

        System.out.println(list.stream().reduce(0, (e1, e2) -> e1 + e2));
        System.out.println(list.stream().reduce(5, (e1, e2) -> e1 + e2));
        System.out.println(list.stream().reduce(0, (e1, e2) -> e1 + 1 + e2 + 1, (e1, e2) -> e1 + e2));
        System.out.println(list.stream().reduce(5, (e1, e2) -> e1 + 1 + e2 + 1, (e3, e4) -> e3 + e4));


        List<Integer> square = list.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println(square);

        List<String> list3 = Arrays.asList("Stream", "Collection", "List");

        // demonstration of filter method
        List<String> result = list3.stream()
                .filter(s -> s.startsWith("S")).
                collect(Collectors.toList());
        System.out.println(result);

        // demonstration of sorted method
        List<String> show =
                list3.stream().sorted().collect(Collectors.toList());
        System.out.println(show);


        // collect method returns a set
        Set<Integer> squareSet =
                list.stream().map(x -> x * x).collect(Collectors.toSet());
        System.out.println(squareSet);

        System.out.println("-------------------10");
        // demonstration of forEach method
        list.stream().map(x -> x * x).forEach(y -> System.out.println(y));
        System.out.println("-------------------11");
        // demonstration of reduce method
        int even = list.stream().filter(x -> x % 2 == 0).reduce(0, (a, b) -> a + b);
        System.out.println(even);

    }
}
