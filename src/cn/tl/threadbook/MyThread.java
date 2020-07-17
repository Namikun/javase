package cn.tl.threadbook;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义线程
 */
public class MyThread extends Thread {

    private static final String DEFAULT_NAME = "MyThread";
    private static final AtomicInteger THREAD_CREATE = new AtomicInteger(0);
    private static final AtomicInteger THREAD_ALIVE = new AtomicInteger(0);

    public MyThread(Runnable target) {
        this(target, DEFAULT_NAME);
    }

    public MyThread(Runnable target, String name) {
        super(target, name + "-Thread-" + THREAD_CREATE.incrementAndGet());
        // 设置线程异常处理
        setUncaughtExceptionHandler(new MyThreadException());
    }

    @Override
    public void run() {
        try {
            THREAD_ALIVE.incrementAndGet();
            super.run();
        } finally {
            THREAD_ALIVE.decrementAndGet();
        }
    }

    public static AtomicInteger getThreadCreate() {
        return THREAD_CREATE;
    }

    public static AtomicInteger getThreadAlive() {
        return THREAD_ALIVE;
    }
}
