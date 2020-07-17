package cn.tl.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap key/value都不能为null，线程安全
 * Hashtable key/value都不能为null，线程安全
 * HashMap key/value都能为null，线程不安全
 * TreeMap key不可以为null, value可以为null
 *
 * HashMap: 链表散列结构，即链表和数组的集合体，JDK8后，由数组、链表、红黑树组成。
 * 内部有个两个实现类，static class Node<K,V> implements Map.Entry<K,V>
 *                    static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V>
 *                        其中LinkedHashMap.Entry是Map.Entry的子类
 * 还有一个数组Node<K,V>[] table,其大小总是2^n
 * 当数组中75%已经被占用，则扩容。
 * 1.左移1位，容器扩容2倍
 * 2.遍历老数组，给新数组赋值
 * 扩容成本很高，所以设定初始容量很重要。
 *
 * put
 * 如果数组为null或者length == 0，先初始化数组
 * 根据key的hash值进行一些计算得到数组的index
 * （key的hashCode高16位保持不变，低16位和高16位异或得到hash值,index = (tab.length - 1) & hash，使index不会越界）
 * （大小总是2^n使数组空间得到充分利用，元素分布更均匀，因为length - 1永远为111...11形式的二进制数据，减少node碰撞）
 * key为null时，index = 0
 * 如果table[index] == null，table[index] = new Node<>(hash, key, value, next);
 * 如果table[index] != null，如果key相等，覆盖该元素，
 * 如果不等，且链表中的元素超过8个，链表会转变成红黑树，新值会按照红黑树的规则插入（根节点不是固定的，每次获取当前的根节点）
 * 不超过8个，仍旧以链表形式存在，新值插入链表的末尾（JDK8之前插入表头）。
 *
 * String类型的key，不能用==判断或者可能有哈希冲突时，尽量减少长度
 * get
 * 根据key的hash值进行一些计算得到数组的index，迭代链表，调用equals比较key值，
 * 如果相等，返回node.value
 * 如果不等，返回null
 */
public class MapTest {

    public static void main(String[] args) {
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        hashtable.put(1, 1);

        new HashMap<>(6).put(1,1);
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>(6);

        map.put("1",1);
        map.computeIfAbsent("1", key -> map.put("2","value"));
        System.out.println(map.get("2"));
        map.computeIfAbsent("2", key -> map.put("2","value"));
    }
}
