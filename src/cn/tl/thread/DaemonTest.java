package cn.tl.thread;

/**
 * 守护线程
 */
public class DaemonTest {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("finally");
            }
        });

        t.setDaemon(true);
        t.start();
    }
}
