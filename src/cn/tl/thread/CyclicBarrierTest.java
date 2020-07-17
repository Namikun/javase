package cn.tl.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * N组任务分别执行，全部到达某个状态后，再继续分别往后执行
 * cyclicBarrier可以复用
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        int count = Runtime.getRuntime().availableProcessors();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(count + 1, () -> System.out.println("告一段落..."));

        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("一阶段结束...");
                    //await方法必须等待任务全部完成才继续往下执行，否则一直阻塞。
                    cyclicBarrier.await();

                    Thread.sleep(2000);
                    System.out.println("二阶段结束...");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
