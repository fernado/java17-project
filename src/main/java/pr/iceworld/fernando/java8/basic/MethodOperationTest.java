package pr.iceworld.fernando.java8.basic;

public class MethodOperationTest {
    static int number2 = getValue();
    static int number1 = 10;
    static int getValue() {
        return number1;
    }
    static int doSum() {
        return number1 + number2;
    }

    static int doMinus() {
        return number1 - number2;
    }
    public static void main(String[] args) {

        Integer number1 = new Integer(1);
        Integer number2 = number1;
        number1++;
        System.out.println(number1);
        System.out.println(number2);


        System.out.println("number1 + number2 = " + doSum());
        System.out.println("number1 - number2 = " + doMinus());
    }
}
