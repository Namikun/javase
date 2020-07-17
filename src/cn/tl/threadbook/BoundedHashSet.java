package cn.tl.threadbook;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 有界阻塞容器set
 * 利用Semaphore
 * @param <E>
 */
public class BoundedHashSet<E> {

    private final Set<E> set;
    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<>());
        this.sem = new Semaphore(bound);
    }

    public boolean add(E e) throws InterruptedException {
        sem.acquire();
        boolean added = false;
        try {
            added = set.add(e);
        } finally {
            if (!added) {
                sem.release();
            }
        }

        return added;
    }

    public boolean remove(E e) {
        boolean removed = set.remove(e);
        if (removed) {
            sem.release();
        }

        return removed;
    }
}
