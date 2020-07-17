package cn.tl.threadbook;

import java.util.concurrent.*;

/**
 * 耗时操作的并发问题
 * 先检查后执行 还是存在并发重复执行的情况
 */
public class MemoizerQ<T, V> implements Computable<T, V> {

    private final ConcurrentMap<T, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<T, V> c;

    public MemoizerQ(Computable<T, V> c) {
        this.c = c;
    }

    @Override
    public V compute(final T t) throws ExecutionException, InterruptedException {
        Future<V> f = cache.get(t);
        if (f == null) {
            FutureTask<V> ft = new FutureTask(() -> c.compute(t));
            f = ft;
            cache.put(t, ft);
            ft.run();
        }
        return f.get();
    }

}
