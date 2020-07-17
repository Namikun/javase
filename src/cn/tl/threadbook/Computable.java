package cn.tl.threadbook;

import java.util.concurrent.ExecutionException;

@FunctionalInterface
public interface Computable<T, V> {

    V compute(T t) throws ExecutionException, InterruptedException;
}
