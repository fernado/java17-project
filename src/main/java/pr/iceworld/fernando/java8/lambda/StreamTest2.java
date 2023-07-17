package pr.iceworld.fernando.java8.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest2 {


    public static void stringToIntFlatmap() {
        List<String> ss = Arrays.asList("My name is fernando", "Nice to meet you!", "I'm very happy to join you");

        List<String> s1 = ss.stream().flatMap(e -> Arrays.stream(e.split(" "))).collect(Collectors.toList());

        System.out.println(s1);
    }

    public static void peekAndForeach() {
        List<String> sentences = Arrays.asList("hello world", "Jia Gou Wu Dao");
        //演示点1： 仅peek操作，最终不会执行
        System.out.println("----before peek----");
        sentences.stream().peek(sentence -> System.out.println(sentence));
        System.out.println("----after peek----");
        //演示点2： 仅foreach操作，最终会执行
        System.out.println("----before foreach----");
        sentences.stream().forEach(sentence -> System.out.println(sentence));
        System.out.println("----after foreach----");
        //演示点3： peek操作后面增加终止操作，peek会执行
        System.out.println("----before peek and count----");
        sentences.stream().peek(sentence -> System.out.println(sentence)).count();
        System.out.println("----after peek and count----");
    }


    static class Dept {
        private int id;

        public Dept(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    public static void testCollectStopOptions() {
        List<Dept> ids = Arrays.asList(new Dept(17), new Dept(22), new Dept(23));
        // collect成list
        List<Dept> collectList = ids.stream().filter(dept -> dept.getId() > 20)
                .collect(Collectors.toList());
        System.out.println("collectList:" + collectList);
        // collect成Set
        Set<Dept> collectSet = ids.stream().filter(dept -> dept.getId() > 20)
                .collect(Collectors.toSet());
        System.out.println("collectSet:" + collectSet);
        // collect成HashMap，key为id，value为Dept对象
        Map<Integer, Dept> collectMap = ids.stream().filter(dept -> dept.getId() > 20)
                .collect(Collectors.toMap(Dept::getId, dept -> dept));
        System.out.println("collectMap:" + collectMap);

        Map<Integer, Dept> collect = ids.stream().filter(e -> e.id > 20).collect(Collectors.toMap(Dept::getId, a -> a));
        System.out.println(collect);
    }

    public static void testCollectJoinStrings() {
        List<String> ids = Arrays.asList("205", "10", "308", "49", "627", "193", "111", "193");
        String joinResult = ids.stream().collect(Collectors.joining(","));
        System.out.println("拼接后：" + joinResult);
    }

    public static void testNumberCalculate() {
        List<Integer> ids = Arrays.asList(10, 20, 30, 40, 50);
        // 计算平均值
        Double average = ids.stream().collect(Collectors.averagingInt(value -> value));
        System.out.println("平均值：" + average);
        // 数据统计信息
        IntSummaryStatistics summary = ids.stream().collect(Collectors.summarizingInt(value -> value));
        System.out.println("数据统计信息： " + summary);
    }



    public static void testString() {
        System.out.println(10 + 20 + "Javatpoint");
        System.out.println("Javatpoint" + 10 + 20);
    }


    public static void main(String[] args) {
        testString();
    }
}
