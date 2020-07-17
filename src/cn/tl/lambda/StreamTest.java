package cn.tl.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by pp on 2016-06-30.
 * Optional API与Stream类似
 */
public class StreamTest {

    public static void main(String[] args) throws Exception {

        //noneMatch
        //System.out.println(Stream.of("peter", "anna", "mike", "xenia").noneMatch(s -> s.startsWith("a")));

        //map
        Stream.of("peter", "anna", "mike", "xenia").map(String::toUpperCase).collect(Collectors.toList());

        //filter
        //Stream.of("peter", "anna", "mike", "xenia").filter(value -> value.startsWith("a")).collect(Collectors.toList());

        //concat
        //System.out.println(Stream.concat(Stream.of("peter", "anna"), Stream.of("peter", "anna", "mike", "xenia")).distinct().count());

        //flatMap lambda返回一个stream
        //System.out.println(Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 6)).flatMap(lists -> lists.stream()).count());

        //iterate
        //Stream.iterate(0,x->x+1).limit(3).forEach(System.out::println);

        //generate
        //Stream.generate(() -> "hello world").limit(3).forEach(System.out::println);

        //peek生成一个包含原Stream的所有元素的新Stream，同时会提供一个消费函数（Consumer实例），新Stream每个元素被消费的时候都会执行给定的消费函数；
        //Stream.of(1, 2, 3).peek(x -> System.out.println(x + 1)).forEach(x -> System.out.println(x));

        //skip 跳过n个元素
        //Stream.of(1, 2, 3, 4).skip(2).forEach(x -> System.out.println(x));

        //max  字符串包含数字最多的一个
        //System.out.println(Arrays.asList("33a333Bb", "ad234").stream().max(Comparator.comparing(s -> s.chars().filter(Character::isDigit).count())).get());

        //reduce
        //System.out.println(Arrays.asList(1, 2).stream().reduce(0, (a, b) -> a = a + b));

        Stream.of(1, 2, 3, 4).filter(x -> x > 2);

        filter(Arrays.asList(1, 2, 3, 5), x -> x > 2).forEach(System.out::println);

        map(Arrays.asList("a", "b"), String::toUpperCase).forEach(System.out::println);
    }

    /**
     * 返回值 泛型 前面需要加上<T>
     * reduce规定第二个参数不能改变原有acc的值
     *
     * @param list
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        return list.stream().reduce(new ArrayList<>(), (acc, x) -> {
            if (predicate.test(x)) {
                List<T> lists = new ArrayList<>(acc);
                lists.add(x);
                return lists;
            }
            return acc;
        }, (List<T> ts, List<T> ts2) -> {
            List<T> ts1 = new ArrayList<>(ts);
            ts1.addAll(ts2);
            return ts1;
        });

    }

    public static <T> List<T> filter1(List<T> list, Predicate<T> predicate) {
        return list.stream().collect(ArrayList::new, (acc, t) -> {
            if (predicate.test(t)) {
                acc.add(t);
            }
        }, ArrayList::addAll);

    }

    public static <T> List<T> map(List<T> list, Function<T, T> function) {
        return list.stream().collect(ArrayList::new, (acc, t) ->
                        acc.add(function.apply(t))
                , ArrayList::addAll);

    }

}
