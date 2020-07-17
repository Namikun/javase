package cn.tl.thread;

import java.util.concurrent.Exchanger;

/**
 * Exchanger用于线程间的数据交换
 * 可用于校验两个人输入同一份资料时是否一致
 */
public class ExchangeTest {

    public static void main(String[] args) throws Exception {
        Exchanger exchanger = new Exchanger();

        new Thread(() -> {
            String A = "+1s";
            try {
                Object exchange = exchanger.exchange(A);
                System.out.println("+1s change to " + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            String B = "-1s";
            try {
                Object exchange = exchanger.exchange(B);
                System.out.println("-1s change to " + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
