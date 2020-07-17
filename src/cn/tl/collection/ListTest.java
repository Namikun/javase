package cn.tl.collection;

import java.util.*;

/**
 * List特有的迭代器ListIterator可以在迭代过程中增删
 * <p>
 * Vector 数组 有索引 可以初始化容器长度 线程安全
 * <p>
 * ArrayList 数组 有索引 可以初始化容器长度 线程不安全
 * add: elementData[index] = newValue
 * get: elementData[index]
 * <p>
 * LinkedList 链表 没有索引 不可以初始化容器长度 线程不安全
 * add: Node.next = newNode
 * get: 判断index < (size >> 1)，从0遍历到index-1，才拿到值x.next，反之，从末尾size-1遍历到index+1,才拿到值x.prev，效率很差。
 * <p>
 * 涉及到索引，用ArrayList
 */
public class ListTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int max = 1000000;
        List<Object> vector = new Vector<>();

        List<Object> linkedList = new LinkedList<>();
        List<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long start = System.currentTimeMillis();
        for (Object o : linkedList) {
            Object b = o;
        }

        System.out.println("LinkedList for: " + (System.currentTimeMillis() - start));


        start = System.currentTimeMillis();
        for (Object o : arrayList) {
            Object b = o;
        }

        System.out.println("ArrayList for: " + (System.currentTimeMillis() - start));


        //List特有的迭代器ListIterator可以在迭代过程中增删
        for (ListIterator<Object> listIterator = arrayList.listIterator(); listIterator.hasNext(); ) {
            if ("abc".equals(listIterator.next())) {
                listIterator.remove();
            }
        }
    }

}

