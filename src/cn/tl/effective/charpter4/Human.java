package cn.tl.effective.charpter4;

/**
 * @author namikun
 * @date 2020/7/17
 */
public interface Human {

    /**
     * 默认方法
     */
    default void run() {
        System.out.println("run...");
    }

    /**
     * 静态方法，接口的静态方法不能被继承
     */
    static void human() {
        System.out.println("human...");
    }
}
