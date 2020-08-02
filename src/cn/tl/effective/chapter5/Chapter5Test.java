package cn.tl.effective.chapter5;

import java.util.List;

/**
 * @author namikun
 * @date 2020/8/2
 */
public class Chapter5Test<T> {

    // T[] t = new T[1]; 非法
    T[] t = (T[]) new Object[1];

    public static <E extends Comparable<? super E>> E max(List<? extends E> list) {
        E result = null;
        for (E e : list) {
            // Comparable 消费者
            if (e != null && e.compareTo(result) > 0) {
                result = e;
            }
        }

        return result;
    }
}
