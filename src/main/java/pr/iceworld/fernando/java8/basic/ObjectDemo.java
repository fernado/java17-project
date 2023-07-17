package pr.iceworld.fernando.java8.basic;

import java.util.Optional;

public class ObjectDemo {
    @Override
    public String toString() {
        return "ObjectDemo";
    }
    public static void main(String[] args) {
        Optional<Object> o = Optional.of(new ObjectDemo());
        System.out.println(o.get().toString());

        int a = 9, b = 2;
        float f;
        f = a / b;
        System.out.println(f);
        f = f / 2;
        System.out.println(f);
        f = a + b / f;
        System.out.println(f);
        // 1001
        // 0100
        System.out.println(9.0/2);
    }
}
