package pr.iceworld.fernando.java8.basic;

public class ExceptionProcessDemo {
    public static void main(String[] args) {
        int x = 5, y = 0;
        try {
            try {
                try {
                    System.out.println(x);
                    System.out.println(x / y);
                    System.out.println(y);
                } catch (ArithmeticException ex) {
                    System.out.println("Ïnner Catch1");
                    throw ex;
                }
            } catch (RuntimeException ex) {
                System.out.println("Ïnner Catch2");
                throw ex;
            } finally {
                System.out.println("Inner Finally");
            }
        } catch (Exception ex) {
            System.out.println("Outer Catch");
        }
    }
}
