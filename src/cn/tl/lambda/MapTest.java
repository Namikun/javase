package cn.tl.lambda;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/9.
 */
public class MapTest {

    static Map<Integer, Long> map = new HashMap<>();

    static {
        map.put(0, 0L);
        map.put(1, 1L);
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        //map.put(1,4);

        //compute
        // 结果!=null,存储结果。==null，原有value!=null,先remove(key),再返回null，否则直接返回null
        Integer compute = map.compute(1, (a, b) -> a + b);
        System.out.println(compute);

        //computeIfPresent
        //原有value==null，返回null。!=null，lambda表达式值!=null,存储并返回新值，否则先remove，再返回null
        Integer integer = map.computeIfPresent(1, (a, b) -> a + b);
        System.out.println(integer);

        //computeIfAbsent
        System.out.println(computer(0));

        //merge
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        map1.put(1, 1);
        map2.put(1, 1);
        map1.put(2, 2);
        map2.put(4, 3);
        map2.forEach((k, s) -> map1.merge(k, s, Integer::sum));
        //map1.putAll(map2);
        System.out.println(map1);
    }

    //斐波那契数列
    public static Long computer(int x) {
        //x对应value存在即返回value，不存在，计算并保存
        return map.computeIfAbsent(x, n -> computer(n - 1) + computer(n - 2));
    }
}
