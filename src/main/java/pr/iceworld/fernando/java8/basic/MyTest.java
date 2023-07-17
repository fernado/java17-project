package pr.iceworld.fernando.java8.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MyClass {
    public String getMessage(String name) {
        return "Hello " + name;
    }
}

public class MyTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        String message = "";
        Object myClass = new MyClass();
        Method method;

//        method = myClass.getClass().getMethod("getMessage", String.class);
//        message = (String) method.invoke(myClass, "World");


        Class clz = Class.forName("pr.iceworld.fernando.java8.basic.MyClass");
        Class[] paramTypes = new Class[1];
        paramTypes[0] = String.class;
        method = clz.getDeclaredMethod("getMessage", paramTypes);
        message = (String) method.invoke(myClass, "World.");

        System.out.println(message);
    }
}
