package pr.iceworld.fernando.java8.basic;

import java.util.function.Function;
import java.util.function.Predicate;

public class IKTest0 {
    private static int count;
    static {
        System.out.println("In block 1");
        count = 10;
    }

    IKTest0() {
        System.out.println("construct");
    }

    private int[] data;
    {
        System.out.println("In block 2");
        data = new int[count];
        for (int i = 0; i < count; i++) {
            data[i] = i;
        }
    }

    /**
     * 有且仅有一个抽象方法的接口函数式接口，即适用于函数式编程场景的接口。而java中的函数式编程体现就是Lambda，
     * 所以函数式接口就是可以适用于Lambda使用的接口。只有确保接口中有且仅有一个抽象方法，Java中的Lambda才能顺利地进行推导。
     * """
     * Predicate<T>
     * Function<T, R>
     * Consumer<T>
     * Supplier<T>
     * """
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Count = " + count);
        System.out.println("Before 1st call to new");
        IKTest0 test1 = new IKTest0();
        System.out.println("Before 2nd call to new");
        IKTest0 test2 = new IKTest0();

        System.out.println("-----------------");
        Predicate<String> lengther = (s) -> s.length() < 2;
        System.out.println("----------------- lengther: " + lengther.test("length"));
        Predicate<String> equalizer = Predicate.isEqual("car");
        System.out.println("----------------- equalizer: " + equalizer.test("car"));
        Function<Boolean, String> booleaner = i -> Boolean.toString(i);
        System.out.println("----------------- equalizer: " + booleaner.apply(false));
        Function<String, Boolean> stringer = s -> Boolean.parseBoolean(s);
        System.out.println("----------------- equalizer: " + stringer.apply("aa"));

        System.out.println(stringer.compose(booleaner).apply(true));
        System.out.println(booleaner.andThen(stringer).apply(false));
        System.out.println("..............A");
        System.out.println(booleaner.apply(true));
        System.out.println(booleaner.compose(stringer).apply("true").substring(0, 3));
        System.out.println(lengther.negate().or(equalizer).test("CAR"));

        System.out.println("...............B");
        System.out.println(lengther.negate().test("length"));
    }
}
