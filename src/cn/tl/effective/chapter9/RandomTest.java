package cn.tl.effective.chapter9;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author namikun
 * @date 2020/7/26
 * 并发情况下
 * Random 由于 CAS 操作，会造成大量线程自旋，导致性能下降
 * ThreadLocalRandom 每个线程都维护一个种子变量，因此不存在竞争，性能高
 */
public class RandomTest {

    public static void main(String[] args) {
        int count = 2000000;
        long s = System.nanoTime();
        for (int i = 0; i < count; i++) {
            new Random().nextInt(10000);
        }
        long m = System.nanoTime();
        System.out.println("Random:" + (m - s));

        m = System.nanoTime();
        for (int i = 0; i < count; i++) {
            ThreadLocalRandom.current().nextInt(10000);
        }
        long e = System.nanoTime();
        System.out.println("ThreadLocalRandom:" + (m - s));

    }

}
