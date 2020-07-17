package cn.tl.algorithm;

import cn.tl.domain.Node;

/**
 * 链表反转
 */
public class LinkedReverse {

    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        Node node = reverseLinked(a);
        while (node != null) {
            System.out.println(node.name);
            node = node.next;
        }
    }

    public static Node reverseLinked(Node node) {
        Node next = node.next;
        node.next = null;
        while (next != null) {
            Node temp = next.next;
            next.next = node;
            node = next;
            next = temp;
        }

        return node;
    }
}
