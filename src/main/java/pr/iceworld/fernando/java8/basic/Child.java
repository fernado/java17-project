package pr.iceworld.fernando.java8.basic;

class Parent {
    protected static int count = 0;

    public Parent() {
        count++;
    }

    static int getCount() {
        return count;
    }
}

public class Child extends Parent {
    public Child() {
        count++;
    }

    public static void main(String[] args) {
        System.out.println("Count = " + getCount());
        Child obj = new Child();
        System.out.println("Count = " + getCount());
    }
}
