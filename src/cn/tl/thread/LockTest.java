package cn.tl.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程1执行10次，线程执行20次，主线程执行30次，如此循环20次
 */
public class LockTest {

    private Lock lock = new ReentrantLock();
    private final Condition condition1 = lock.newCondition();
    private final Condition condition2 = lock.newCondition();
    private final Condition condition3 = lock.newCondition();
    private int flag = 1;


    public static void main(String[] args) {
        new LockTest().init();
    }

    public void init() {

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                lock.lock();
                try {
                    while (flag != 1){
                        try {
                            condition1.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    sub1();

                    flag = 2;
                    condition2.signal();
                }finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                lock.lock();
                try {
                    while (flag != 2) {
                        try {
                            condition2.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    sub2();

                    flag = 3;
                    condition3.signal();
                }finally {
                    lock.unlock();
                }
            }
        }).start();


        for (int i = 0; i < 20; i++) {
            lock.lock();
            try {
                while (flag != 3){
                    try {
                        condition3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                main();

                flag = 1;
                condition1.signal();
            }finally {
                lock.unlock();
            }

        }
    }

    public void main() {
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }

    public void sub1() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }

    public void sub2() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
