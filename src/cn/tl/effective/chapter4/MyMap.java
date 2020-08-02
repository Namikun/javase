package cn.tl.effective.chapter4;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

/**
 * @author namikun
 * @date 2020/7/17
 */
public class MyMap extends AbstractMap implements Map {

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    /**
     * 静态内部类充当外部对象的内部组件
     *
     * @param <K>
     * @param <V>
     */
    static class Node<K, V> implements Map.Entry<K, V> {
        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public V setValue(V value) {
            return null;
        }
    }
}
