package pr.iceworld.fernando.java17.ocp.chapter01;

public class Egg {
    public Egg() {
        number = 5;
    }

    public static void main(String[] args) {
        Egg egg = new Egg();
        // 5
        // Fields and blocks are run first in order, setting number
        // to 3 and then 4. Then the constructor runs, setting number to 5.
        System.out.println(egg.number);
    }

    private int number = 3;

    {
        number = 4;
    }
}