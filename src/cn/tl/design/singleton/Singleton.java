package cn.tl.design.singleton;

public class Singleton {

    private Singleton() {
    }

    private static volatile Singleton instance = null;

    /**
     * 双重if判断，加上局部变量
     *
     * @return
     */
    public static Singleton getInstance1() {
        Singleton result = instance;
        if (result == null) {
            synchronized (Singleton.class) {
                if (result == null) {
                    result = instance = new Singleton();
                }
            }
        }

        return result;
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
