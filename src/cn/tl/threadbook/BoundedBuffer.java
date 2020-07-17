package cn.tl.threadbook;

import java.util.concurrent.Semaphore;

/**
 * 用信号量实现有界阻塞缓存
 *
 * @param <E>
 */
public class BoundedBuffer<E> {

    private int length, takeIndex, putIndex = 0;
    private final Semaphore putSem, takeSem;
    private final E[] items;

    public BoundedBuffer(int length) {
        this.length = length;
        takeSem = new Semaphore(0);
        putSem = new Semaphore(length);
        items = (E[]) new Object[length];
    }

    public boolean isEmpty() {
        return takeSem.availablePermits() == 0;
    }

    public boolean isFull() {
        return putSem.availablePermits() == 0;
    }

    public E take() throws InterruptedException {
        takeSem.acquire();
        E e = get();
        putSem.release();
        return e;
    }

    public void put(E x) throws InterruptedException {
        putSem.acquire();
        add(x);
        takeSem.release();
    }


    private synchronized E get() {
        int i = takeIndex;
        E e = items[i];
        items[i] = null;// help GC
        takeIndex++;
        if (takeIndex == length) {
            takeIndex = 0;
        }
        return e;
    }

    private synchronized void add(E e) {
        int i = putIndex;
        items[i] = e;
        putIndex++;
        if (putIndex == length) {
            putIndex = 0;
        }
    }
}
