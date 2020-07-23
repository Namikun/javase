package cn.tl.effective.charpter7;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.*;

/**
 * @author namikun
 * @date 2020/7/21
 * 统计字符个数：
 * 1、使用map.merge方法
 * 2、stream流 groupingBy
 */
public class MapStreamTest {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        // map.merge 这里用法不是Stream代码，只是伪装成stream代码，可读性不高
        // Stream.of("s", "a", "s").forEach(s -> map.merge(s, 1, Long::sum));
        Map<String, Long> map1 = Stream.of("s", "a", "S").collect(groupingBy(String::toLowerCase, counting()));
        System.out.println(map1);

        // 取个数最多的前2个字符
        List<String> list = map1.keySet().stream().sorted(comparingLong(map1::get).reversed()).limit(2).collect(toList());
        System.out.println(list);

    }
}
