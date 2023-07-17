package pr.iceworld.fernando.java8.muti.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier也能实现countDownLatch的功能，并且它的计数器n是可以被重置的，也就是说n=0线程被唤醒后，n又能重新回到原有值。
 */
public class CyclicBarrierMockCountDownLatchTest {
    // 当计数器为0时，立即执行
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3,
            () -> System.out.println("汇总线程：" + Thread.currentThread().getName() + " 任务合并。"));

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        mockCountdownLatch(executorService);

        // 关闭线程池
        executorService.shutdown();
    }

    /**
     * CyclicBarrier实现CountDownLatch的功能
     * @param executorService
     */
    private static void mockCountdownLatch(ExecutorService executorService) {
        // 将线程A添加到线程池
        executorService.submit(() -> {
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
        executorService.submit(() -> {
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
        executorService.submit(() -> {
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
