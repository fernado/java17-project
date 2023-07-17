package pr.iceworld.fernando.java8.basic;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

class ParentFinal {
    public void method1() {
    }

    // final method cant be override
    public final void method2() {
    }
}
class NativeClassD {
    public void method1() {}
    public native void method2();
}
public class FinalClassDemo extends ParentFinal {

    //private final int x;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("30");
        list.add(1, "20");
        //FinalClassDemo.method3();

        NativeClassD nativeClassD = new NativeClassD();
        nativeClassD.method1();
        //nativeClassD.method2();
        NativeClassD.class.isAssignableFrom(NativeClassD.class);
    }
    @Override
    public void method1() {


    }


    public void method4() {
        synchronized (this) {

        }
    }

    public synchronized void method5() {

    }

    public static void method3() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        //hashtable.put(null, "");
        //System.out.println(hashtable.get(null));
        hashtable.put("", null);
        System.out.println(hashtable.get(""));


    }

}
