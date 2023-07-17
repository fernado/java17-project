package pr.iceworld.fernando.java8.muti.thread;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelTest {

    public static void main(String[] args) throws ClassNotFoundException {

        List<String> ll = Stream.of("little", "red", "riding", "hood")
                .parallel()
                .map(s -> {
                    System.out.println("map: " + s + " " + Thread.currentThread().getName());
                    return s + "_";
                })
                .filter(s -> {
                    System.out.println("filter: " + s + " " + Thread.currentThread().getName());
                    return s.length() > 3;
                })
                .reduce((s1, s2) -> {
                    System.out.println("reduce: " + s1 + " " + Thread.currentThread().getName());
                    return s1.length() > s2.length() ? s1: s2;
                }).stream().collect(Collectors.toList());
        System.out.println("----" + ll);

//        Class<?> parallelTest = Class.forName("pr.iceworld.fernando.java8.muti.thread.ParallelTest", true, ParallelTest.class.getClassLoader().getParent());
    }
}
