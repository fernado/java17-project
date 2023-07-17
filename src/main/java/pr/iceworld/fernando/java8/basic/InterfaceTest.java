package pr.iceworld.fernando.java8.basic;


interface Company {
    public String getAddress(String companyName);
    default public String getPhoneNumber() {
        return "555";
    }

    String getAddress(int company) throws ExceptionB ;
}

class ExceptionA extends Exception {

}

class ExceptionB extends ExceptionA {

}

public class InterfaceTest implements Company {

    public static void main(String[] args) {
        Company interfaceTest = new InterfaceTest();
        System.out.println(interfaceTest.getAddress("cc"));
    }

    @Override
    public String getAddress(String companyName) {
        return "hh";
    }

//    public int getAddress(String companyName) {
//        return 20;
//    }


    /**
     * 不能抛出比父类更高的异常
     */
    @Override
    public String getAddress(int companyName) throws ExceptionB {
        return "int";
    }
}
