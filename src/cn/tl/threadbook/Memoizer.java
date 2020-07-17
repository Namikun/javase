package cn.tl.threadbook;

import java.util.concurrent.*;

/**
 * 耗时操作的并发问题
 * 已经计算过，直接返回，反之，计算再返回
 * 当缓存的是 Future 而不是值时，会导致缓存污染问题。如果耗时操作被取消或者失败，应该从缓存中移除 Future
 */
public class Memoizer<T, V> implements Computable<T, V> {

    private final ConcurrentMap<T, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<T, V> c;

    public Memoizer(Computable<T, V> c) {
        this.c = c;
    }

    /**
     * @param t final类型 防止外部修改
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Override
    public V compute(final T t) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(t);
            if (f == null) {
                FutureTask<V> ft = new FutureTask<>(() -> c.compute(t));
                f = cache.putIfAbsent(t, ft);
                if (f == null) {
                    f = ft;
                    ft.run();
                }
            }
            try {
                return f.get();
            } catch (CancellationException e) {
                // 缓存异常，移除f，进入下一次循环
                cache.remove(t, f);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
