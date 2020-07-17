package cn.tl.effective.chapter3;

import java.util.Comparator;

/**
 * @author namikun
 * @date 2020/7/12
 */
public class Charpter3Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(18, new String[]{"swim", "football"});
        Person clone = person.clone();
        // 对象引用地址
        System.out.println(clone == person);
        System.out.println(clone.equals(person));
        // 数组引用地址
        System.out.println(clone.getHobby() == person.getHobby());
        // Class对象
        System.out.println(clone.getClass().equals(person.getClass()));

        Comparator<Person> comparator = Comparator.comparingInt(p -> p.getAge());

        Integer.compare(1, 2);
    }
}
