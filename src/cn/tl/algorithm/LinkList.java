package cn.tl.algorithm;

/**
 * @author namikun
 * @date 2020/11/15
 * 双向链表
 */
public class LinkList<E> {

    private Node<E> head;

    private Node<E> tail;

    public void add(E e) {
        Node<E> node;
        if (head == null) {
            node = new Node<>(e, null);
            head = tail = node;
        } else {
            node = new Node<>(e, tail);
            tail.next = node;
            tail = node;
        }
    }

    public boolean remove(E e) {
        Node<E> node = head;
        while (node != null) {
            if (e.equals(node.e)) {
                Node<E> prev = node.prev;
                Node<E> next = node.next;
                prev.next = next;
                next.prev = prev;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void foreach() {
        Node<E> node = head;
        while (node != null) {
            System.out.println(node.e);
            node = node.next;
        }
    }

    public void reverseForeach() {
        Node<E> node = tail;
        while (node != null) {
            System.out.println(node.e);
            node = node.prev;
        }
    }

    private class Node<E> {

        private E e;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> prev) {
            this.e = e;
            this.prev = prev;
        }
    }

}
