package cn.tl.thread;

import java.util.concurrent.Semaphore;

/**
 * new Semaphore(3, true); 信号量，当permits=1时，可以实现多线程同步互斥。
 * true代表先进先出，3表示最多3个坑位，多余的人需要等待别人让出坑位
 */
public class SemaphoreTest {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3, true);

        for (int i = 0; i < 5; i++) {
            int b = i;
            new Thread(() -> {
                try {
                    //获取许可，如果没获取到，则阻塞，一直到获取到许可为止
                    semaphore.acquire();
                    System.out.println(b + "号人已占坑");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(b + "号人已释放坑");
                    //释放许可
                    semaphore.release();
                }
            }).start();
        }
    }
}
