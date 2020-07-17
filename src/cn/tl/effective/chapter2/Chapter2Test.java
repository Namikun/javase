package cn.tl.effective.chapter2;

import java.util.Date;

/**
 * @author namikun
 * @date 2020/7/5
 */
public class Chapter2Test {

    public static void main(String[] args) {
        Person p = new Person.Builder().name("namikun").age(11).sex("male").birthday(new Date()).build();
        System.out.println(p);

        System.out.println(SingletonEnum.INSTANCE);
    }
}
