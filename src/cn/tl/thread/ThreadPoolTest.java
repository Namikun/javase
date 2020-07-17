package cn.tl.thread;

import cn.tl.threadbook.MyThreadFactory;
import cn.tl.threadbook.MyThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * newFixedThreadPool,newSingleThreadExecutor
 * 主要问题在于堆积的请求处理队列可能会耗费非常大的内存，甚至OOM
 * newCachedThreadPool,newScheduledThreadPool
 * 主要问题在于线程数量最大值为Integer.MAX_VALUE，可能会创建非常多的线程，甚至OOM
 * <p>
 * 先创建线程去执行任务，当线程数量=corePoolSize，后续的新任务都丢进队列，
 * 当队列也满了，如果maximumPoolSize>corePoolSize，继续创建线程执行新任务，否则执行拒绝策略。
 * 当线程数量=maximumPoolSize，后续的任务执行拒绝策略。
 * AbortPolicy: 丢弃新任务，并抛出异常，默认策略
 * DiscardPolicy: 丢弃新任务，不抛出异常
 * CallerRunsPolicy: 交由调用execute方法的线程去执行新任务
 * DiscardOldestPolicy: 接收新任务，但会丢弃队列头部的任务
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<Runnable> deque = new LinkedBlockingDeque<>(10);
        MyThreadPoolExecutor pool = new MyThreadPoolExecutor(3, 4, 0, TimeUnit.MILLISECONDS, deque, new MyThreadFactory("Tanlang"));

        for (int i = 0; i < 5; i++) {
            int a = i;
            pool.execute(() -> {
                try {
                    Thread.sleep(a * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(1 / a);
            });
        }
//        List<Callable<Integer>> tasks = new ArrayList<>(8);
//        for (int i = 0; i < 8; i++) {
//            int b = i;
//            tasks.add(() -> 1/b);
//        }
//
//        List<Future<Integer>> futures = pool.invokeAll(tasks, 5, TimeUnit.SECONDS);
//        futures.forEach(f -> {
//            try {
//                System.out.println("invokeAll:" + f.get(5, TimeUnit.SECONDS));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            } catch (TimeoutException e) {
//                e.printStackTrace();
//            } finally {
//                f.cancel(true);
//            }
//        });

        //线程池不再接受新任务，等所有任务执行完毕再关闭线程池
        pool.shutdown();
        //线程池立即关闭，并尝试中断正在执行的任务，并清空队列，返回未执行的任务
        /*List<Runnable> runnables = pool.shutdownNow();
        System.out.println("关闭线程池...size: " + runnables.size());
        for (Runnable runnable : runnables) {
            runnable.run();
        }*/

    }

}
