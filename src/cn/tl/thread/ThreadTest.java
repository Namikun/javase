package cn.tl.thread;

/**
 * 子线程执行100次，主线程执行10次，如此循环50次
 */
public class ThreadTest {

    public static void main(String[] args) {
        new ThreadTest().init();
    }

    public void init() {
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                son();
            }
        }).start();

        for (int i = 0; i < 50; i++) {
            main();
        }
    }

    private boolean flag = true;

    public synchronized void main() {
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "main: " + i);
        }
        flag = true;
        this.notify();
    }

    public synchronized void son() {
        while (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "son: " + i);
        }

        flag = false;
        this.notify();
    }

}
