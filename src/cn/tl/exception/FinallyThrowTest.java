package cn.tl.exception;

/**
 * finally覆盖测试
 * <p>
 * finally的throw/return 覆盖 try的throw/return
 */
public class FinallyThrowTest {

    public static void main(String[] args) {
        System.out.println(get(1));
    }

    public static int get(int i) {
        try {
            i++;
            throw new RuntimeException("try exception...");
        } catch (Exception e) {
            i++;
        } finally {
            i++;
            throw new RuntimeException("finally exception...");
        }
    }
}
