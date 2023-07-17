package pr.iceworld.fernando.java8.muti.thread;

import java.util.concurrent.*;

public class CompletableFutureTestX {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //supplyAsync是创建带有返回值的异步任务
        //runAsync是创建没有返回值的异步任务

        //thenApply();
        //thenAccept();
        //thenRun();
        //whenComplete();
        //handle();
        //thenCombine();
        //applyToEither();
        allOf();
    }

    /**
     * thenApply和thenApplyAsync
     * thenApply 表示某个任务执行完成后执行的动作，即回调方法，会将该任务的执行结果即方法返回值作为入参传递到回调方法中，
     * 有返回值。
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    static void thenApply() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });
        System.out.println("-------------1");
        CompletableFuture<Integer> cf2 = cf1.thenApply((result) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            result += 2;
            return result;
        });
        System.out.println("-------------2");
        CompletableFuture<Integer> cf3 = cf1.thenApply((result) -> {
            System.out.println(Thread.currentThread() + " cf3 do something....");
            result += 2;
            return result;
        });
        System.out.println("-------------3");
        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.get());
        //等待任务2执行完成
        try {
            System.out.println("cf2结果->" + cf2.get(1, TimeUnit.MILLISECONDS));
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
        //等待任务3执行完成
        System.out.println("cf3结果->" + cf3.get());

    }

    /**
     * thenAccept和thenAcceptAsync
     * thenAccept表示某个任务执行完成后执行的动作，即回调方法，会将该任务的执行结果即方法返回值作为入参传递到回调方法中，
     * 无返回值。
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    static void thenAccept() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });
        System.out.println("-------------1");
        CompletableFuture<Void> cf2 = cf1.thenAccept((result) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
        });
        System.out.println("-------------2");
        CompletableFuture<Void> cf3 = cf1.thenAcceptAsync((result) -> {
            System.out.println(Thread.currentThread() + " cf3 do something....");
        });
        System.out.println("-------------3");
        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.get());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());
        //等待任务3执行完成
        System.out.println("cf3结果->" + cf3.get());

    }

    /**
     * thenRun和thenRunAsync
     * thenRun表示某个任务执行完成后执行的动作，即回调方法，无入参，
     * 无返回值。
     */
    static void thenRun() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });
        CompletableFuture<Void> cf2 = cf1.thenRun(() -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
        });
        CompletableFuture<Void> cf3 = cf1.thenRunAsync(() -> {
            System.out.println(Thread.currentThread() + " cf3 do something....");
        });

        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.get());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());
        //等待任务3执行完成
        System.out.println("cf3结果->" + cf3.get());

    }

    /**
     * whenComplete和whenCompleteAsync
     * whenComplete是当某个任务执行完成后执行的回调方法，会将执行结果或者执行期间抛出的异常传递给回调方法，
     * 如果是正常执行则异常为null，回调方法对应的CompletableFuture的result和该任务一致，
     * 如果该任务正常执行，则get方法返回执行结果，如果是执行异常，则get方法抛出异常
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    static void whenComplete() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            //int a = 1 / 0;
            return 1;
        });

        CompletableFuture<Integer> cf2 = cf1.whenComplete((result, e) -> {
            System.out.println("上个任务结果：" + result);
            System.out.println("上个任务抛出异常：" + e);
            System.out.println(Thread.currentThread() + " cf2 do something....");
            // cant return
            //return result + 3;
        });

//        //等待任务1执行完成
//        System.out.println("cf1结果->" + cf1.get());
//        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());
    }

    /**
     * 跟whenComplete基本一致，区别在于handle的回调方法有返回值。
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    static void handle() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
             //int a = 1/0;
            return 1;
        });

        CompletableFuture<Integer> cf2 = cf1.handle((result, e) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            System.out.println("上个任务结果：" + result);
            System.out.println("上个任务抛出异常：" + e);
            return result + 2;
        });

        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());

    }

    /**
     * thenCombine、thenAcceptBoth 和runAfterBoth
     * 这三个方法都是将两个CompletableFuture组合起来处理，只有两个任务都正常完成时，才进行下阶段任务。
     * <p>
     * 区别：thenCombine会将两个任务的执行结果作为所提供函数的参数，
     * 且该方法有返回值；
     * thenAcceptBoth同样将两个任务的执行结果作为方法入参，
     * 但是无返回值；
     * runAfterBoth没有入参，也没有返回值。注意两个任务中只要有一个执行异常，则将该异常信息作为指定任务的执行结果。
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    static void thenCombine() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });

        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            return 2;
        });

        CompletableFuture<Integer> cf3 = cf1.thenCombine(cf2, (a, b) -> {
            System.out.println(Thread.currentThread() + " cf3 do something....");
            return a + b;
        });

        CompletableFuture<Void> cf4 = cf1.thenAcceptBoth(cf2, (a, b) -> {
            System.out.println(Thread.currentThread() + " cf4 do something....");
            System.out.println("cf4=" + (a + b));
        });

        CompletableFuture<Void> cf5 = cf1.runAfterBoth(cf2, () -> {
            System.out.println(Thread.currentThread() + " cf5 do something....");
        });


        System.out.println("cf1结果->" + cf1.get());
        System.out.println("cf2结果->" + cf2.get());
        System.out.println("cf3结果->" + cf3.get());
        System.out.println("cf4结果->" + cf4.get());
        System.out.println("cf5结果->" + cf5.get());
    }

    /**
     * applyToEither、acceptEither和runAfterEither
     * 这三个方法和上面一样也是将两个CompletableFuture组合起来处理，当有一个任务正常完成时，就会进行下阶段任务。
     * <p>
     * 区别：
     * applyToEither会将已经完成任务的执行结果作为所提供函数的参数，
     * 有返回值；
     * acceptEither同样将已经完成任务的执行结果作为方法入参
     * 无返回值；
     * runAfterEither没有入参，也没有返回值。
     */
    static void applyToEither() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread() + " cf1 do something....");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "cf1 finished";
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            return "cf2 finished";
        });

        CompletableFuture<String> cf3 = cf1.applyToEither(cf2, (result) -> {
            System.out.println("applyToEither received " + result);
            System.out.println(Thread.currentThread() + " cf3 do something....");
            return "applyToEither finished";
        });
        CompletableFuture<Void> cf4 = cf1.acceptEither(cf2, (result) -> {
            System.out.println("acceptEither received " + result);
            System.out.println(Thread.currentThread() + " cf4 do something....");
        });
        CompletableFuture<Void> cf5 = cf1.runAfterEither(cf2, () -> {
            System.out.println(Thread.currentThread() + " runAfterEither no accept input and no result do something....");
            System.out.println("runAfterEither finished");
        });


        System.out.println("applyToEither result->" + cf3.get());
        System.out.println("acceptEither result->" + cf4.get());
        System.out.println("runAfterEither result->" + cf5.get());
    }

    /**
     * allOf / anyOf
     * allOf：CompletableFuture是多个任务都执行完成后才会执行，只要有一个任务执行异常，则返回的CompletableFuture执行get方法时会抛出异常，
     *  如果都是正常执行，则get返回null。
     *
     * anyOf ：CompletableFuture是多个任务只要有一个任务执行完成，则返回的CompletableFuture执行get方法时会抛出异常，
     * 如果都是正常执行，则get返回执行完成任务的结果。
     */
    static void allOf() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread() + " cf1 do something....");
                Thread.sleep(2011);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("cf1 任务完成");
            return "cf1 任务完成";
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread() + " cf2 do something....");
                //int a = 1/0;
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("cf2 任务完成");
            return "cf2 任务完成";
        });

        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread() + " cf3 do something....");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("cf3 任务完成");
            return "cf3 任务完成";
        });

        CompletableFuture<Void> cfAll = CompletableFuture.allOf(cf1, cf2, cf3);
        CompletableFuture<Object> ofAny = CompletableFuture.anyOf(cf1, cf2, cf3);
        System.out.println("cfAll结果->" + cfAll.get());
        System.out.println("ofAny结果->" + ofAny.get());



    }
}


class Thread1 implements Callable<String> {

    @Override
    public String call() throws Exception {


        Thread.sleep(1000);
        return "Thread1";
    }
}

class Thread2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "Thread2";
    }
}
