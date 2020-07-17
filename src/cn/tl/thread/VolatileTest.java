package cn.tl.thread;

public class VolatileTest {

    public static void main(String[] args) {
        new VolatileTest().init();
    }

    public void init() {
        InnerTask task = new InnerTask();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                task.son();
            }
        }).start();

        for (int i = 0; i < 50; i++) {
            task.main();
        }
    }

    class InnerTask {

        private volatile boolean flag = true;

        public void main() {
            while (flag) {

            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " main: " + i);
            }
            flag = true;
        }

        public void son() {
            while (!flag) {

            }
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " son: " + i);
            }

            flag = false;
        }
    }
}
