package pr.iceworld.fernando.java8.lambda;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class TestLambadaException {
    public static void main(String[] args) {
        method4();
    }

    static void synchronizedCollections() {
        List<Integer> list = Arrays.asList(1, 3, 5, 7, 9);
        Collections.synchronizedCollection(list);
        Collections.synchronizedList(list);
        Map<String, Integer> map = new HashMap<>();
        map.put(null, 0);
        System.out.println("HashMap ==> " + map.get(null));
        Collections.synchronizedMap(map);
        System.out.println("Collections.synchronizedMap(map) = map.get(null) ==> " + map.get(null));
        Set<String> set = new HashSet<>();
        Collections.synchronizedSet(set);
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        // this will throw error, as currenthashmap could not put and get null
        // concurrentHashMap.put(null, null);
        // System.out.println(concurrentHashMap.get(null));
    }

    static void method1() {
        List<Integer> integers = Arrays.asList(3, 9, 7, 6, 10, 0, 20);
        integers.forEach(i -> System.out.println(50 / i));
    }

    static void method2() {
        List<Integer> integers = Arrays.asList(3, 9, 7, 6, 10, 0, 20);
        integers.forEach(i -> {
            try {
                System.out.println(50 / i);
            } catch (ArithmeticException e) {
                System.err.println(
                        "Arithmetic Exception occured : " + e.getMessage());
            }
        });
    }

    static void method3() {
        List<Integer> integers = Arrays.asList(3, 9, 7, 6, 10, 0, 20);
        integers.forEach(wrapper1(i -> System.out.println(50 / i)));
    }

    static void method4() {
        List<Integer> integers = Arrays.asList(3, 9, 7, 6, 10, 0, 20);
        integers.forEach(wrapper2(i -> System.out.println(50 / i), ArithmeticException.class));

    }

    static Consumer<Integer> wrapper1(Consumer<Integer> consumer) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (ArithmeticException e) {
                System.err.println( "Arithmetic Exception occurred : " + e.getMessage());
            }
        };
    }

    static <T, E extends Exception> Consumer<T> wrapper2(Consumer<T> consumer, Class<E> clazz) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (Exception e) {
                try {
                    E clz = clazz.cast(e);
                    System.err.println("Arithmetic Exception occurred : " + e.getMessage());
                } catch (ClassCastException cce) {
                    throw cce;
                }
            }
        };
    }
}
