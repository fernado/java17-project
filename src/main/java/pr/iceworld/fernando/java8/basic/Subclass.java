package pr.iceworld.fernando.java8.basic;

class Superclass {
    Superclass() {
        this(0);
        System.out.println("1");
    }

    public Superclass(int x) {
        System.out.println("2" + x);
    }

    public void method1(String param) {
    }
}

public class Subclass extends Superclass {

    Subclass() {
        System.out.println("test");
    }
    Subclass(int x) {
        System.out.println("3" + x);
    }

    Subclass(int x, int y) {
        // 22
        // 423
        super(x);
        //20
        //1
        //32
        //423
//        this(x);
        System.out.println("4" + x + y);
    }

    public void method1(String param) {
    }

    /**
     * 'method1(String)' is already defined in 'pr.iceworld.fernando.java8.basic.Subclass'
     */
    //public String method1(String param) {
    //    return null;
    //}

    public static void main(String[] args) {
        new Subclass(2, 3);
    }
}