package cn.tl.threadbook;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 自定义线程异常处理
 */
public class MyThreadException implements Thread.UncaughtExceptionHandler {

    private Logger logger = Logger.getAnonymousLogger();

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        logger.log(Level.SEVERE, "异常线程： " + t.getName(), e);
    }
}
