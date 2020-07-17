package cn.tl.design.singleton;

public class Singleton {

    private Singleton() {
    }

    private static volatile Singleton instance = null;

    /**
     * 双重if判断
     *
     * @return
     */
    public static Singleton getInstance1() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }

    /**
     * 私有静态内部类
     */
    private static class SingletonHolder {
        private static Singleton singleton = new Singleton();
    }
}
