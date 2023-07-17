package pr.iceworld.fernando.java11;


import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Jdk11NewTrait {
    public static void main(String[] args) {
        String s1 = "";
        String s2 = " ";
        System.out.println(s1.isBlank() == s2.isBlank());

        String newStr = "Hello Java 11 \n felord.cn \r 2021-09-28";
        Stream<String> lines = newStr.lines();
        lines.forEach(System.out::println);

        String str = "HELLO\u3000";
        // str = 6
        System.out.println("str = " + str.length());
        // trim = 6
        System.out.println("trim = " + str.trim().length());
        // strip = 5
        System.out.println("strip = " + str.strip().length());

        str = "HELLO";
        // 空字符
        String empty = str.repeat(0);
        // HELLO
        String repeatOne = str.repeat(1);
        // HELLOHELLO
        String repeatTwo = str.repeat(2);

        System.out.println("empty= " + empty);
        System.out.println("repeatOne= " + repeatOne);
        System.out.println("repeatTwo= " + repeatTwo);

        List<String> sampleList = Arrays.asList("张三", "java 11");
        // array = {"张三", "java 11"};
        String[] array = sampleList.toArray(new String[0]);
        array = sampleList.toArray(String[]::new);

        sampleList = Arrays.asList("张三", "java 11", "jack");
        // [jack]
        List<String> result = sampleList.stream()
                // 过滤以j开头的字符串
                .filter(s -> s.startsWith("j"))
                // 同时不包含11的字符串
                .filter(Predicate.not(s -> s.contains("11")))
                .collect(Collectors.toList());

        sampleList = Arrays.asList("张三", "java 11","jack");
        result = sampleList.stream()
                // 过滤以j开头的字符串
                .filter((@NotNull var s) -> s.startsWith("j"))
                // 同时不包含11的字符串
                .filter(Predicate.not((@NotNull var s) -> s.contains("11")))
                .collect(Collectors.toList());


    }
}
