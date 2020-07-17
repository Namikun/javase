package cn.tl.thread;

import java.util.concurrent.*;

public class FutureTest {

    private static final LinkedBlockingDeque<Runnable> workQueue = new LinkedBlockingDeque<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = new ThreadPoolExecutor(10, 100, 0, TimeUnit.MILLISECONDS, workQueue);

        Future<Integer> future = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                System.out.println(6666);
                return 233;
            }
        });

        try {
            System.out.println("start...");
//            一直会等待线程执行结束返回结果再执行future.get();
            Integer r1 = future.get();
            System.out.println(r1);
            Integer r2 = future.get(1, TimeUnit.MILLISECONDS);
            System.out.println(r2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        CompletionService completionService = new ExecutorCompletionService(pool);
        for (int i = 0; i < 10; i++) {
            final int b = i;
            completionService.submit(new Callable() {
                @Override
                public Object call() throws Exception {
                    return b;
                }
            });
        }

        try {
            System.out.println("CompletionService start....");
            for (int i = 0; i < 10; i++) {
                Future take = completionService.take();
                System.out.println(take.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        pool.shutdown();


        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            Thread.sleep(2000);
            return 151;
        });

        new Thread(futureTask).start();

        System.out.println(futureTask.get());
    }
}
