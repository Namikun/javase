package cn.tl.string;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by Administrator on 2016/7/9.
 */
public class StringCollectors implements Collector<String, StringCombiner, String> {

    //特征
    private static final Set<Characteristics> characteristics = Collections.emptySet();
    private final String delimiter;
    private final String prefix;
    private final String suffix;

    public StringCollectors(String delimiter, String prefix, String suffix) {
        this.delimiter = delimiter;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public Supplier<StringCombiner> supplier() {
        return () -> new StringCombiner(delimiter, prefix, suffix);
    }

    @Override
    public BiConsumer<StringCombiner,String> accumulator() {
        return StringCombiner::add;
    }

    @Override
    public BinaryOperator<StringCombiner> combiner() {
        return StringCombiner::merge;
    }

    @Override
    public Function<StringCombiner,String> finisher() {
        return StringCombiner::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }

}
