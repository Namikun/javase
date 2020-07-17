package cn.tl.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayBlockQueueTest {

    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    private Object[] items = new Object[20];
    private int count, takeIndex, putIndex;


    public static void main(String[] args) {
        //ArrayBlockingQueue<Object> abq = new ArrayBlockingQueue(20);

        ArrayBlockQueueTest test = new ArrayBlockQueueTest();

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                System.out.println(test.take());
            }
        }).start();

        for (int i = 0; i < 30; i++) {
            test.put(i);
        }
    }

    public Object take() {
        lock.lock();
        Object obj = null;
        try {
            while (count == 0) {
                notEmpty.await();
            }
            obj = items[takeIndex];
            takeIndex++;
            count--;
            if (takeIndex == items.length) {
                takeIndex = 0;
            }
            notFull.signal();

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

        return obj;
    }

    public void put(Object x) {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[putIndex] = x;
            putIndex++;
            count++;
            if (putIndex == items.length) {
                putIndex = 0;
            }
            notEmpty.signal();

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
}
