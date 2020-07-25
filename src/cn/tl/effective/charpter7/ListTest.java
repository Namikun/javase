package cn.tl.effective.charpter7;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author namikun
 * @date 2020/7/22
 * 求子集
 */
public class ListTest<T> {

    /**
     * 创建匿名类，按位对应法
     */
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
     * 打印输入列表的所有连续子列表，跟其它不同，不能跨元素组合
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
     * Set 去重
     */
    public static List<Set<String>> getAllSubList(Set<String> set) {
        List<String> list = new ArrayList<>(set);
        int size = 1 << list.size();
        List<Set<String>> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Set<String> temp = new HashSet<>();
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

    /**
     * 递归实现 求子集
     */
    public static List<Set<String>> getRecursion(Set<String> set) {
        if (set.size() == 0) {
            List<Set<String>> list = new ArrayList<>();
            list.add(set);
            return list;
        } else if (set.size() == 1) {
            List<Set<String>> list = new ArrayList<>();
            list.add(new HashSet<>());
            list.add(set);
            return list;
        } else {
            Iterator<String> iterator = set.iterator();
            String next = iterator.next();
            set.remove(next);
            Set<String> s = new HashSet<>();
            s.add(next);
            // 切割为两部分，递归
            List<Set<String>> list1 = getRecursion(s);
            List<Set<String>> list2 = getRecursion(set);

            // 两部分的子集随机组合
            List<Set<String>> result = new ArrayList<>();
            for (Set<String> s1 : list1) {
                for (Set<String> s2 : list2) {
                    Set temp = new HashSet<>();
                    temp.addAll(s1);
                    temp.addAll(s2);
                    result.add(temp);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        printAllSubList(list);

        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        System.out.println(get(set));
        System.out.println(getAllSubList(set));

        System.out.println(getRecursion(set));
    }

}
