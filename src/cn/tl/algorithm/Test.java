package cn.tl.algorithm;

/**
 * @author namikun
 * @date 2020/11/4
 */
public class Test {

    public static void main(String[] args) {
//        LinkTable<Integer> table = new LinkTable<>();
//        table.add(1);
//        table.add(2);
//        table.add(3);
//        table.add(4);
//        table.add(5);
//
//        table.remove(0);
//        table.reverse();
//        table.foreach();

        LinkList<Integer> list = new LinkList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.remove(3);
        list.reverseForeach();
        list.foreach();
    }
}
