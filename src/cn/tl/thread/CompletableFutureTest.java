package cn.tl.thread;

import java.util.concurrent.*;

public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(5));

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 1, pool);

        Integer integer = future.get();

        System.out.println(integer);
    }
}
