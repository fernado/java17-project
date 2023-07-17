package pr.iceworld.fernando.java8.muti.thread;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;

public class AtomicLongAndLongAccumulatorExample {
    private long count;
    private AtomicLong count2 = new AtomicLong();
    private LongAccumulator accum = new LongAccumulator((x, y) -> x + y, count);

    public void incrementCount() {
        count++;
        count2.getAndIncrement();
        accum.accumulate(1);
    }
    public long getCount() {
        return this.count;
    }

    public long getCount2() {
        return this.count2.get();
    }
    public long getCount3() {
        return this.accum.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final AtomicLongAndLongAccumulatorExample ce = new AtomicLongAndLongAccumulatorExample();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ce.incrementCount();
                }
            }, "Thread" + i).start();
        }
        Thread.sleep(1);
//        System.out.println("Final number: " + ce.getCount());
//        System.out.println("Final number2: " + ce.getCount2());
        System.out.println("Final number2: " + ce.getCount3());


    }
}
