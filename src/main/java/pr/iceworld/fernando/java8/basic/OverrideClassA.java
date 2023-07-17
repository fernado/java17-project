package pr.iceworld.fernando.java8.basic;

class SuperclassA {
    protected int doAction(int a, String b) {
        return -1;
    }
}

class SubclassA extends SuperclassA {
    @Override
    protected int doAction(int a, String b) throws RuntimeException {
        return -1;
    }
}

/**
 * 不能用非运行时异常做重写
 */
//class SubclassB extends SuperclassA {
//    @Override
//    protected int doAction(int a, String b) throws IOException {
//        new FileReader("").close();
//        return -1;
//    }
//}

class SubclassC extends SuperclassA {
    @Override
    public int doAction(int a, String b) {
        return -1;
    }
}

/**
 * 不能用非运行时异常做重写
 */
//class SubclassD extends SuperclassA {
//    @Override
//    public int doAction(int a, String b) throws IOException {
//        new FileReader("").close();
//        return -1;
//    }
//}

public class OverrideClassA extends SuperclassA {

    @Override
    protected int doAction(int a, String b) {
        return -1;
    }
}
