package cn.tl.threadbook;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference 非阻塞算法实现栈结构
 * 新增的元素 放进栈顶
 */
public class ConcurrentStack<E> {

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

    private final AtomicReference<Node<E>> ar = new AtomicReference<>();

    public void push(E e) {
        Node<E> newNode = new Node<>(e);
        while (true) {
            Node<E> oldNode = ar.get();
            newNode.next = oldNode;
            if (ar.compareAndSet(oldNode, newNode)) {
                return;
            }
        }
    }

    public E pop() {
        while (true) {
            Node<E> oldNode = ar.get();
            if (oldNode == null) {
                return null;
            }
            Node newNode = oldNode.next;
            if (ar.compareAndSet(oldNode, newNode)) {
                return oldNode.item;
            }
        }
    }
}
