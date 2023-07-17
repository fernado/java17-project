package pr.iceworld.fernando.java8.muti.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("executorService state = " + executorService);
        executorService.submit(() -> System.out.println("test"));
        executorService.shutdown();
    }
}
