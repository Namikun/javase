package cn.tl.lambda;

import cn.tl.domain.Album;
import cn.tl.domain.Artist;
import cn.tl.string.StringCollectors;
import cn.tl.string.StringCombiner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTest {

    public static void main(String[] args) {

        //toMap
        Map<Integer, Integer> collect1 = Stream.of(1, 3, 4).collect(Collectors.toMap(x -> x, x -> x + 1));
        //toCollection
        TreeSet<Integer> collect2 = Stream.of(1, 3, 4).collect(Collectors.toCollection(TreeSet::new));

        // maxBy minBy
        //System.out.println(Stream.of(1, 2, 3).collect(Collectors.maxBy(Integer::compare)).get());

        //averagingInt averagingDouble averagingLong
        //System.out.println(Stream.of(1, 2, 3).collect(Collectors.averagingInt(x->x)));

        //summingInt
        //System.out.println(Stream.of(1, 3, 4).collect(Collectors.summingInt(x -> x)));
        //summarizingDouble
        DoubleSummaryStatistics summaryStatistics = Stream.of(1, 3, 4).collect(Collectors.summarizingDouble(x -> x));

        //groupingBy前两个方法最终调用第三个方法，第二个参数默认HashMap::new 第三个参数默认Collectors.toList()
        Map<Integer, List<Integer>> map = Stream.of(1, 3, 3, 4).collect(Collectors.groupingBy(x -> x));
        Map<Integer, Long> collect = Stream.of(1, 3, 3, 4).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        HashMap<Integer, Long> collect7 = Stream.of(1, 3, 3, 4).collect(Collectors.groupingBy(x -> x, HashMap::new, Collectors.counting()));

        //partitioningBy
        Map<Boolean, List<Integer>> collect5 = Stream.of(1, 3, 4).collect(Collectors.partitioningBy(x -> x > 2));
        Map<Boolean, Long> collect4 = Stream.of(1, 3, 4).collect(Collectors.partitioningBy(x -> x > 2, Collectors.counting()));

        //Collectors reducing
        System.out.println("Collectors reducing: " + Stream.of(1, 3, 4).collect(Collectors.reducing(0, x -> x + 1, (x, y) -> x + y)));

        //join
        //System.out.println(Stream.of("a", "b", "c").collect(Collectors.joining(",")));

        //Collectors.mapping
        System.out.println(Stream.of("a", "b", "c").collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.joining(","))));

        //collectingAndThen
        String collect6 = Stream.of("a", "b", "c").collect(Collectors.collectingAndThen(Collectors.joining(","), x -> x + "d"));
        System.out.println(collect6);

        //System.out.println(myJoin2(Stream.of("123", "444", "555")));
    }

    // 按照主唱分组得到专辑名
    public static Map<Artist, List<String>> getNameWithGroupBy(Stream<Album> stream) {
        return stream.collect(
                Collectors.groupingBy(Album::getMainMusician, Collectors.mapping(Album::getName, Collectors.toList())));
    }

    /**
     * 重构连接字符串
     *
     * @param stream
     * @return
     */
    public static String myJoin1(Stream<Artist> stream) {
        return stream.map(Artist::getName)
                .reduce(new StringCombiner(",", "[", "]"), StringCombiner::add, StringCombiner::merge)
                .toString();
    }

    /**
     * 重构连接字符串
     *
     * @param stream
     * @return
     */
    public static String myJoin2(Stream<String> stream) {
        return stream.collect(new StringCollectors(",", "[", "]"));
    }

}
