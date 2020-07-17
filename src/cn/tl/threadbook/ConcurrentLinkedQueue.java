package cn.tl.threadbook;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference 非阻塞算法实现队列
 * 新增的元素 放在队尾
 */
public class ConcurrentLinkedQueue<E> {

    private static class Node<E> {
        E item;
        AtomicReference<Node<E>> next;

        public Node(E item, AtomicReference<Node<E>> next) {
            this.item = item;
            this.next = next;
        }
    }

    Node<E> node = new Node<>(null, null);
    private final AtomicReference<Node<E>> head = new AtomicReference<>(node);
    private final AtomicReference<Node<E>> tail = new AtomicReference<>(node);

    public boolean put(E e) {
        Node<E> newNode = new Node<>(e, null);
        while (true) {
            Node<E> tailNode = tail.get();
            Node<E> next = tailNode.next.get();
            if (tailNode == tail.get()) {
                if (next == null) {
                    if (tailNode.next.compareAndSet(null, newNode)) {
                        tail.compareAndSet(tailNode, newNode);
                        return true;
                    }
                } else {
                    tail.compareAndSet(tailNode, next);
                }
            }
        }
    }


}
