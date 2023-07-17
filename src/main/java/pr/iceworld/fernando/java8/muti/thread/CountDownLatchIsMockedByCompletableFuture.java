package pr.iceworld.fernando.java8.muti.thread;

import java.util.concurrent.CompletableFuture;

/**
 * CountDownLatch 实现多个线程顺序执行
 */
public class CountDownLatchIsMockedByCompletableFuture {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Work(), "线程1");
        Thread t2 = new Thread(new Work(), "线程2");
        Thread t3 = new Thread(new Work(), "线程3");
        CompletableFuture.runAsync(() -> t1.start()).thenRun(() -> t2.start()).thenRun(() -> t3.start());
    }

    static class Work implements Runnable {
        @Override
        public void run() {
            System.out.println("执行 : " + Thread.currentThread().getName());
        }
    }
}
