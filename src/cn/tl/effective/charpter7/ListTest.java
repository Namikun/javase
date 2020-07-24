package cn.tl.effective.charpter7;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author namikun
 * @date 2020/7/22
 */
public class ListTest<T> {

    public static <T> Collection<Set<T>> get(Set<T> s) {
        List<T> list = new ArrayList<>(s);
        return new AbstractList<Set<T>>() {
            @Override
            public Set<T> get(int index) {
                Set<T> set = new HashSet<>();
                for (int i = 0; index != 0; i++, index >>= 1) {
                    if ((index & 1) == 1) {
                        set.add(list.get(i));
                    }
                }
                return set;
            }

            @Override
            public int size() {
                return 1 << s.size();
            }
        };
    }

    /**
     * 打印输入列表的所有连续子列表
     */
    public static void printAllSubList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j <= list.size(); j++) {
                System.out.println(list.subList(i, j));
            }
        }

        System.out.println("===========================");
        IntStream.range(0, list.size()).mapToObj(s -> IntStream.rangeClosed(s + 1, list.size()).mapToObj(v -> list.subList(s, v))).flatMap(x -> x)
                .forEach(System.out::println);
    }

    /**
     * 求集合的所有子集：按位对应法
     */
    public static List<List<Integer>> getAllSubList(List<Integer> list) {
        int size = 1 << list.size();
        List<List<Integer>> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            List<Integer> temp = new ArrayList<>();
            int index = i;
            for (int j = 0; index > 0; j++, index >>= 1) {
                if ((index & 1) != 0) {
                    temp.add(list.get(j));
                }
            }
            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        //printAllSubList(list);

        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        System.out.println(get(set));

        System.out.println(getAllSubList(list));

    }


}
