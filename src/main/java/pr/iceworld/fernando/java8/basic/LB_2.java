package pr.iceworld.fernando.java8.basic;

class LB_1 {
    public void retValue() {
        System.out.println("LB_1");
    }
}
public class LB_2 extends LB_1 {
    public void retValue() {
        System.out.println("LB_2");
    }

    public static void main(String args[]) {
        LB_1 lb = new LB_2();
        lb.retValue();
    }
}