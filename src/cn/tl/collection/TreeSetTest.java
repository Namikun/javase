package cn.tl.collection;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>((o1, o2) ->
                o1.length() - o2.length() != 0 ? o1.length() - o2.length() : o1.compareTo(o2)
        );

        set.add("abc");
        set.add("abcd");
        set.add("abcde");
        set.add("ab");
        set.add("abd");
        for (String element : set) {
            System.out.println(element);
        }

    }

}
