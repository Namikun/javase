package cn.tl.algorithm;

/**
 * @author namikun
 * @date 2020/11/4
 * 单向链表
 */
public class LinkTable<E> {

    private Node<E> head;

    private Node<E> tail;

    public void add(E e) {
        Node<E> node = new Node<>(e);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public boolean remove(E e) {
        Node<E> node = head;
        Node<E> temp = null;
        while (node != null) {
            if (e.equals(head.e)) {
                head = node.next;
                node.next = null;
                return true;
            }
            Node next = node.next;
            if (node.e.equals(e)) {
                if (next == null) {
                    tail = temp;
                    temp.next = null;
                } else {
                    temp.next = next;
                    node.next = null;
                }
                return true;
            }
            temp = node;
            node = next;
        }

        return false;
    }

    public void reverse() {
        if (this.head != null) {
            Node<E> node = this.head;
            Node<E> next = node.next;
            while (next != null) {
                Node<E> temp = next.next;
                next.next = node;
                node = next;
                next = temp;
            }

            this.head.next = null;
            // 交换首尾节点
            Node<E> temp = this.head;
            this.head = this.tail;
            this.tail = temp;
        }
    }

    public void foreach() {
        Node<E> node = head;
        while (node != null) {
            System.out.println(node.e);
            node = node.next;
        }
    }


    private class Node<E> {

        private E e;
        private Node next;

        public Node(E e) {
            this.e = e;
        }
    }

}
