package pr.iceworld.fernando.java8.basic;

class Shape {}
class Triangle extends Shape {}
public class Qudrilaterl extends Shape {

    public static void main(String[] args) {
        Shape shape = new Qudrilaterl();
        Qudrilaterl qudrilaterl = new Qudrilaterl();

        shape = qudrilaterl;

    }

}
