package pr.iceworld.fernando.java8.muti.thread;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 神秘杰克
 * 公众号: Java菜鸟程序员
 * @date 2022/1/4
 * @Description 统计0的个数
 */
public class AtomicTest {

    private static AtomicLong atomicLong = new AtomicLong();
    private static Integer[] arrayOne = new Integer[]{0, 1, 2, 3, 0, 5, 6, 0, 56, 0};
    private static Integer[] arrayTwo = new Integer[]{10, 1, 2, 3, 0, 5, 6, 0, 56, 0};

    public static void main(String[] args) throws InterruptedException {
        final Thread threadOne = new Thread(() -> {
            final int size = arrayOne.length;
            for (int i = 0; i < size; ++i) {
                if (arrayOne[i].intValue() == 0) {
                    atomicLong.incrementAndGet();
                }
            }
        });
        final Thread threadTwo = new Thread(() -> {
            final int size = arrayTwo.length;
            for (int i = 0; i < size; ++i) {
                if (arrayTwo[i].intValue() == 0) {
                    atomicLong.incrementAndGet();
                }
            }
        });
        threadOne.start();
        threadTwo.start();
        //等待线程执行完毕
        threadOne.join();
        threadTwo.join();
        System.out.println("count总数为: " + atomicLong.get()); //count总数为: 7

    }
}