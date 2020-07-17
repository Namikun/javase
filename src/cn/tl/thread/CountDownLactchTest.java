package cn.tl.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 倒计时器
 * 只有倒计时为0时，才往下执行，否则一直阻塞。不可复用
 */
public class CountDownLactchTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(3);

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("口哨吹响...");
            countDownLatch1.countDown();
        }).start();

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    countDownLatch1.await();
                    System.out.println("起跑...");
                    Thread.sleep((long) (Math.random() * 10000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1个人到达终点...");
                countDownLatch2.countDown();
            }).start();
        }
    }
}
