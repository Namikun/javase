package cn.tl.lambda;

@FunctionalInterface
public interface Func<T> {

    void out(T x);
}
