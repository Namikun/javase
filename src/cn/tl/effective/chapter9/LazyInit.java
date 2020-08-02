package cn.tl.effective.charpter9;

/**
 * @author namikun
 * @date 2020/7/28
 */
public class LazyInit {

    private LazyInit() {

    }

    private static volatile LazyInit lazyInit;

    public static LazyInit getLazyInit() {
        if (lazyInit == null) {
            synchronized (LazyInit.class) {
                if (lazyInit == null) {
                    lazyInit = new LazyInit();
                }
            }
        }

        return lazyInit;
    }

    /**
     * 读取 volatile 变量开销比较大，使用局部变量接收，可以减少读取 volatile 变量次数，提高效率
     */
    public static LazyInit getLazyInit1() {
        LazyInit result = lazyInit;
        if (result == null) {
            synchronized (LazyInit.class) {
                if (result == null) {
                    result = lazyInit = new LazyInit();
                }
            }
        }

        return result;
    }

}
