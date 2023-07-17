package pr.iceworld.fernando.java8.lambda;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestApp {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("1", "2", "2", "3", "4", "SSS");
        List<String> list2 = Arrays.asList("4", "5", "6", "5", "7", "VVVV");
        List<String> list3 = Arrays.asList("6", "7", "8", "5", "9", "BBBB");

        List<List<String>> lists = Arrays.asList(list1, list2, list3);

        List<String> collect = lists.stream().flatMap(list -> list.stream()).distinct().collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
        lists.stream().map(s -> s + "test").forEach(System.out::println);

        System.out.println("0---");
        List<Integer> list = Arrays.asList(5, 10, 15, 20, 25, 30);
        System.out.println(list.stream().reduce(0, (e1, e2) -> { return e1 + e2;}));
        System.out.println(list.stream().mapToInt(e -> e).average().orElse(0));
        System.out.println(list.stream().mapToInt(e -> e).min().orElse(0));
        System.out.println(list.stream().mapToInt(e -> e).max().orElse(0));
        System.out.println(list.stream().mapToInt(e -> e).sum());
        System.out.println(list.stream().sorted((e1, e2) -> -e1.compareTo(e2)).collect(Collectors.toList()));
        System.out.println("0000---");
        System.out.println(list.stream().sorted((e1, e2) -> e1.compareTo(e2)).limit(1).collect(Collectors.toList()));
        System.out.println(list.stream().sorted().collect(Collectors.toList()));
        System.out.println(list.stream().skip(2).collect(Collectors.toList()));
        System.out.println(list.stream().skip(2).limit(2).collect(Collectors.toList()));
        System.out.println("00---");
        List<Integer> newList = new ArrayList();

        for (Integer item : list) {
            if (item > 20) {
                System.out.println(item);
                newList.add(item);
            }
        }

        System.out.println("1---");
        list.stream().filter(s -> s > 20).forEach(System.out::println);
        System.out.println("2---");
        newList.clear();
        System.out.println("22 ---------");
        System.out.println(list.stream().map(s -> s > 20).collect(Collectors.toList()));
        newList.stream().forEach(System.out::println);
        System.out.println("3---");
        System.out.println(list.stream().filter(s -> s > 20).mapToInt(Integer::valueOf).sum());
        System.out.println(list.stream().reduce(0, (e1, e2) -> e1 + e2));
        System.out.println(list.stream().reduce(0, (integer1, integer2) -> {
            if (integer1 > 20 && integer2 > 20) {
                return integer1 + integer2;
            }
            else if (integer1 > 20) {
                return integer1;
            }
            else if (integer2 > 20) {
                return integer2;
            }
            return 0;
        }));

        System.out.println("4---");
        List<String> reduceList = Arrays.asList("dog", "tiger", "monkey", "vac");
        System.out.println(reduceList.stream().reduce("", (x1, x2) -> {if (x1.equals("dog")) return x1; return x2;}));
        System.out.println("5---");
        System.out.println(reduceList.stream().reduce((x1, x2) -> x1.length() == 3 ? x1: x2));
        System.out.println(reduceList.stream().filter(e -> e.length() == 3).collect(Collectors.toList()));
        System.out.println("6---");
        System.out.println(reduceList.stream().reduce("", (s1, s2) -> s1 + s2.charAt(0), (c1, c2) -> c1 +=c2));

        Integer si1 = -129;
        Integer si2 = -129;

        Integer si3 = -128;
        Integer si4 = -128;

        Integer i1 = 127;
        Integer i2 = 127;

        Integer i3 = 128;
        Integer i4 = 128;
        // Integer has a cache with -128 < x <= 127
        // false
        System.out.println(si1 == si2);
        // true
        System.out.println(si3 == si4);
        // true
        System.out.println(i1 == i2);
        // false
        System.out.println(i3 == i4);
        System.out.println("66666--------");
        Integer i5 = new Integer(1);
        Integer i6 = i5;
        i5 += 1;
        // i5 = 2, i6 = 1
        System.out.println(i5);
        System.out.println(i6);

        System.out.println(Stream.of("green", "yellow", "blue")
                .max((s1, s2) -> s1.compareTo(s2)));
        System.out.println(Stream.of("green", "yellow", "blue")
                .max((s1, s2) -> s1.compareTo(s2)).orElse("yellow")
        );
        System.out.println(Stream.of("green", "yellow", "blue")
                .max((s1, s2) -> s1.compareTo(s2)).filter(s -> s.endsWith("n")).orElse("yellow")
        );
    }
}

