package cn.tl.lambda;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by pp on 2016-07-20.
 */
public class GroupBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {

    private Function<T, K> classifier;

    public GroupBy(Function<T, K> classifier) {
        this.classifier = classifier;
    }

    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        return (map, t) -> {
            K k = classifier.apply(t);
            List<T> ts = map.computeIfAbsent(k, x -> new ArrayList<>());
            ts.add(t);
        };
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
        return (map1, map2) -> {
//            map2.forEach((k, ts) ->
//                    map1.merge(k, ts, (ts1, ts2) -> {
//                        ts1.addAll(ts2);
//                        return ts1;
//                    })
//            );
            map1.putAll(map2);
            return map1;
        };
    }

    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
    }
}
