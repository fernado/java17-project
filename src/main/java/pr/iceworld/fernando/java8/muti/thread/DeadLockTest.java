package pr.iceworld.fernando.java8.muti.thread;

public class DeadLockTest {

    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (obj1) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("thread1 doing ...");
                    synchronized (obj2) {
                        System.out.println("thread1 doing another ...");
                    }
                }
            }
        };
        Thread thread2 = new Thread() {
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (obj2) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("thread2 doing ...");
                    synchronized (obj1) {
                        System.out.println("thread2 doing another ...");
                    }
                }
            }
        };

        thread1.start();
        thread2.start();
    }
}
