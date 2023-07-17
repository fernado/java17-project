package pr.iceworld.fernando.java8.muti.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrier也能实现countDownLatch的功能，并且它的计数器n是可以被重置的，也就是说n=0线程被唤醒后，n又能重新回到原有值。
 */
public class CyclicBarrierTest {
    //public CyclicBarrier(int parties)
    //public CyclicBarrier(int parties, Runnable barrierAction)

    static int size = 3;
    // 当计数器为0时，立即执行
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(size,
            () -> System.out.println("汇总线程：" + Thread.currentThread().getName() + " 任务合并。"));

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(4);

        //mockCountdownLatch(executorService);
        //betterCountdownLatch(pool);
        mockAthleteReady(pool);
        // 关闭线程池
        pool.shutdown();
    }

    public static void mockAthleteReady(ExecutorService pool) {
        //CyclicBarrier cyclicBarrier = new CyclicBarrier(size);
        for (int i = 0; i < size; i++) {
            int index = i;
            pool.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(index);
                    System.out.println(Thread.currentThread().getName() + " -- 第" + index + "位运动员准备好了");
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        try {
            //主线程也加入等待
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(size + "位运动员都准备好了，可以起跑!");
    }

    /**
     * CyclicBarrier相对CountDownLatch的优化
     * @param pool
     */
    private static void betterCountdownLatch(ExecutorService pool) {
        // 将线程A添加到线程池
        pool.submit(() -> {
            try {
                System.out.println("线程A：" + Thread.currentThread().getName() + "执行第1步。");
                cyclicBarrier.await();
                System.out.println("线程A：" + Thread.currentThread().getName() + "执行第2步。");
                cyclicBarrier.await();
                System.out.println("线程A：" + Thread.currentThread().getName() + "执行第3步。");
                cyclicBarrier.await();
                System.out.println("线程A：" + Thread.currentThread().getName() + "执行第4步。");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // 将线程B添加到线程池
        pool.submit(() -> {
            try {
                System.out.println("线程B：" + Thread.currentThread().getName() + "执行第1步。");
                cyclicBarrier.await();
                System.out.println("线程B：" + Thread.currentThread().getName() + "执行第2步。");
                cyclicBarrier.await();
                System.out.println("线程B：" + Thread.currentThread().getName() + "执行第3步。");
                cyclicBarrier.await();
                System.out.println("线程B：" + Thread.currentThread().getName() + "执行第4步。");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // 将线程C添加到线程池
        pool.submit(() -> {
            try {
                System.out.println("线程C：" + Thread.currentThread().getName() + "执行第1步。");
                cyclicBarrier.await();
                System.out.println("线程C：" + Thread.currentThread().getName() + "执行第2步。");
                cyclicBarrier.await();
                System.out.println("线程C：" + Thread.currentThread().getName() + "执行第3步。");
                cyclicBarrier.await();
                System.out.println("线程C：" + Thread.currentThread().getName() + "执行第4步。");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    /**
     * CyclicBarrier实现CountDownLatch的功能
     * @param pool
     */
    private static void mockCountdownLatch(ExecutorService pool) {
        // 将线程A添加到线程池
        pool.submit(() -> {
            try {
                System.out.println("线程A：" + Thread.currentThread().getName() + "执行任务。");
                System.out.println("线程A：到达屏障点");
                cyclicBarrier.await();
                System.out.println("线程A：退出屏障点");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // 将线程B添加到线程池
        pool.submit(() -> {
            try {
                System.out.println("线程B：" + Thread.currentThread().getName() + "执行任务。");
                System.out.println("线程B：到达屏障点");
                cyclicBarrier.await();
                System.out.println("线程B：退出屏障点");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // 将线程B添加到线程池
        pool.submit(() -> {
            try {
                System.out.println("线程C：" + Thread.currentThread().getName() + "执行任务。");
                System.out.println("线程C：到达屏障点");
                cyclicBarrier.await();
                System.out.println("线程C：退出屏障点");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
