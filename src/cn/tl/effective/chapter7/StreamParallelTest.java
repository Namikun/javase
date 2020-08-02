package cn.tl.effective.chapter7;

import java.math.BigInteger;
import java.util.stream.LongStream;

/**
 * @author namikun
 * @date 2020/7/22
 * 尽量不要使用并行stream，除非能保证其正确性，并且能加快程序运行速度
 */
public class StreamParallelTest {

    public static long test(long n) {
        return LongStream.rangeClosed(2, n).mapToObj(BigInteger::valueOf).filter(i -> i.isProbablePrime(50)).count();
    }

    public static long parallelTest(long n) {
        return LongStream.rangeClosed(2, n).parallel().mapToObj(BigInteger::valueOf).filter(i -> i.isProbablePrime(50)).count();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        test(10 ^ 8);
        long middle = System.currentTimeMillis();
        System.out.println(middle - start);
        parallelTest(10 ^ 8);
        long end = System.currentTimeMillis();
        System.out.println(end - middle);
    }
}
