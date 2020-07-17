package cn.tl.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    private Map<String, Object> cache = new HashMap<>();
    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public Object getData(String key) {
        rwl.readLock().lock();
        Object o;
        try {
            o = cache.get(key);
            if (o == null) {
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try {
                    if (o == null) {
                        o = "222";
                        cache.put(key, o);
                    }
                } finally {
                    rwl.writeLock().unlock();
                }
                rwl.readLock().lock();
            }
        } finally {
            rwl.readLock().unlock();
        }

        return o;
    }
}
