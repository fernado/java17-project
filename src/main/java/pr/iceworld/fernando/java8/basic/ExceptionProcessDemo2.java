package pr.iceworld.fernando.java8.basic;

public class ExceptionProcessDemo2 {
    public static void main(String[] args) {
        int x = 5, y = 0;
        try {
            try {
                System.out.println(x);
                System.out.println(x/y);
                System.out.println(y);
            } catch (ArithmeticException ae) {
                System.out.println("inner Catch1");
                throw ae;
            }
        } catch (RuntimeException re) {
            System.out.println("inner Catch2");
            throw re;
        } finally {
            System.out.println("Inner Finally");
        }
        System.out.println(".....");

    }
}
