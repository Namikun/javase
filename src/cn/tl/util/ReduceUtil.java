package cn.tl.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by pp on 2016-08-02.
 */
public class ReduceUtil {

    //应用到并行流上的任何操作都必须是无状态的，不干预的，并且具有关联性的
    //不能改变两个参数(r, t)的值，所以第二个表达式返回值只能是一个新值
    //第三个参数为了并行流合并操作 fork/join
    public static <T, R> List<R> map(Stream<T> stream, Function<T, R> fun) {
        return stream.reduce(new ArrayList<R>(), (r, t) -> {
            List<R> lists = new ArrayList<R>(r);
            R apply = fun.apply(t);
            lists.add(apply);
            return lists;
        }, (List<R> left, List<R> right) -> {
            List<R> lists = new ArrayList<R>(left);
            lists.addAll(right);
            return lists;
        });
    }

    public static <T> List<T> filter(Stream<T> stream, Predicate<T> predicate) {
        return stream.reduce(new ArrayList<T>(), (acc, t) -> {
            if (predicate.test(t)) {
                List<T> lists = new ArrayList<T>(acc);
                lists.add(t);
                return lists;
            }
            return acc;
        }, (List<T> left, List<T> right) -> {
            List<T> lists = new ArrayList<T>(left);
            lists.addAll(right);
            return lists;
        });
    }

    public static <T> List<T> filter1(Stream<T> stream, Predicate<T> predicate) {
        return stream.collect(ArrayList::new, (acc, t) -> {
            if (predicate.test(t)) {
                acc.add(t);
            }
        }, ArrayList::addAll);
    }
}
