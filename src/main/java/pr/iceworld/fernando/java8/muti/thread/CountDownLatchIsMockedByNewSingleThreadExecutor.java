package pr.iceworld.fernando.java8.muti.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * * @author 小蒋学 *  CountDownLatch 实现多个线程顺序执行
 */
public class CountDownLatchIsMockedByNewSingleThreadExecutor {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("线程1"), "线程1");
        Thread t2 = new Thread(() -> System.out.println("线程2"), "线程2");
        Thread t3 = new Thread(() -> System.out.println("线程3"));
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // 将线程依次加入到线程池中
        executor.submit(t1);
        executor.submit(t2);
        executor.submit(t3);
        // 及时将线程池关闭
        executor.shutdown();
    }}
