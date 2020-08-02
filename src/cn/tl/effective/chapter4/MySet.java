package cn.tl.effective.chapter4;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * @author namikun
 * @date 2020/7/17
 * 非静态内部类使用场景 适配器
 */
public class MySet extends AbstractSet {

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * 非静态内部类，每个实例都包含一个额外的外部对象的引用，不利用垃圾回收
     */
    private class MyIterator implements Iterator {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }
}
