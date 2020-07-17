package cn.tl.threadbook;

import java.util.concurrent.ThreadFactory;

/**
 * 自定义线程工厂
 */
public class MyThreadFactory implements ThreadFactory {

    private String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new MyThread(r, poolName);
    }
}
