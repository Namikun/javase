package cn.tl.effective.chapter4;

/**
 * @author namikun
 * @date 2020/7/12
 */
public class Father implements Human {

    /**
     * 定义数组时，一定要是private。防止被外部修改
     */
    private static final String[] s = {"1", "2"};

    private void run1() {
        System.out.println("run1...");
    }

    protected void run2() {
        System.out.println("run2...");
    }

    /**
     * 父类静态方法可以被继承
     */
    static void father() {
        System.out.println("father...");
    }
}
